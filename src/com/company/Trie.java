package com.company;

/*
*
*   Time Complexity:
*   Insertion / Deletion / Searching / Prefix Searching = word length
*
*   Space Complexity: O(No. of words * Max word length)
*
*
* */

import java.util.ArrayList;
import java.util.List;

public class Trie {

    static class TrieNode{
        char val;
        int prefixCount;
        TrieNode[] children;
        boolean isLast;

        public TrieNode(char val){
            this.val = val;
            this.prefixCount = 0;
            children = new TrieNode[26];
            isLast = false;
        }
    }

    private final TrieNode root;

    public Trie(){
        this.root = new TrieNode('0');
    }

    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            curr.prefixCount++;
            if(curr.children[c - 'a'] == null){
                TrieNode node = new TrieNode(c);
                curr.children[c - 'a'] = node;
            }
            curr = curr.children[c - 'a'];

        }
        curr.prefixCount++;
        curr.isLast = true;

    }

    public boolean searchWord(String word){
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }

        return  curr.isLast;
    }

    public int searchPrefix(String word){
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return 0;
            }
            curr = curr.children[c - 'a'];
        }

        return curr.prefixCount;
    }

    public boolean deleteWord(String word){
        if(!searchWord(word)){
            System.out.println(word + " does not exist!");
            return false;
        }
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            curr.prefixCount--;
            curr = curr.children[c - 'a'];
        }
        curr.prefixCount--;
        curr.isLast = false;


        return true;
    }

    public List<String> topKSuggestions(String word, int k){
        List<String> list = new ArrayList<>();
        if(word.length() == 0){
            return list;
        }

        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                return  list;
            }
            curr = curr.children[c - 'a'];
        }

        traverse(curr, word.substring(0, word.length() - 1), k, list);

        return  list;
    }

    private void traverse(TrieNode curr, String word, int k, List<String> list){
        if(list.size() == k){
            return;
        }
        if(curr == null){
            return;
        }
        word = word + curr.val;

        if(curr.isLast){
            list.add(word);
        }

        for(TrieNode node : curr.children){
            traverse(node, word, k, list);
        }

    }

}


