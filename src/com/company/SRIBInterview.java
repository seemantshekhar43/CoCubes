package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SRIBInterview {
    public static void main(String[] args) {
//        System.out.println(replaceAllSpaces("Mr John Smith    ", 13));
//
//        System.out.println(permutationsOfLengthK(new int[]{1, 2, 3, 4}, 3));

        Trie trie = new Trie();

        trie.insert("raman");
        trie.insert("raghav");;
        trie.insert("ramaneesh");
        trie.insert("sagar");
        System.out.println(trie.searchWord("raman"));
        System.out.println(trie.searchPrefix("raman"));
        System.out.println(trie.searchWord("ram"));
        System.out.println(trie.searchPrefix("ram"));
        //System.out.println(trie.deleteWord("ramneesh"));
        System.out.println(trie.searchPrefix("raman"));
        System.out.println(trie.searchWord("raman"));
        System.out.println(trie.topKSuggestions("rag", 3));
    }

    public static  String replaceAllSpaces(String str, int trueLength){
        char[] arr = str.toCharArray();

        int j = arr.length - 1;
        for(int i = trueLength - 1; i >= 0; i--){
            char c = arr[i];
            if(c == ' '){
                arr[j--] = '0';
                arr[j--] = '2';
                arr[j--] = '%';
            }else{
                arr[j--] = c;
            }
        }

        return new String(arr);
    }

    public static List<List<Integer>> permutationsOfLengthK(int[] arr, int k){
        List<List<Integer>> list = new ArrayList<>();

        backtrack(new ArrayList<Integer>(), new boolean[arr.length], k, arr, list);
        System.out.println(list.size());
        return list;
    }

    public static void backtrack( ArrayList<Integer> curr, boolean[] visited, int k, int[] arr, List<List<Integer>> list){

        if(curr.size() == k){
            list.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(visited[i]){
                continue;
            }

            //mark
            curr.add(arr[i]);
            visited[i] = true;

            //traverse
            backtrack(curr, visited, k, arr, list);

            //unmark
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
