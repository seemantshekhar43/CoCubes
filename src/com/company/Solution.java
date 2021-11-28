package com.company;

import java.util.Arrays;
import java.util.Comparator;

//
//import java.util.ArrayList;
//
class Solution {

    public static void main(String[] args) {
//        System.out.println(minCost(new int[]{1, 2, 3}, new int[]{20, 30, 40}));
//        System.out.println(findWater(3, 3, 5));
//        System.out.println(fishPopulation(1, 2, 1));
        System.out.println(longestChain(5, new String[]{"abce", "abc", "abcd", "abcefg", "abcefgty"}));

    }


    static class Pair{
        int len;
        int cost;

        public Pair(int len, int cost){
            this.len = len;
            this.cost = cost;
        }
    }


    public static float findWater(int r, int c, float val){
        float[][] dp = new float[(int)val + 1][(int)val + 1];
        dp[0][0] = val;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                if(dp[i][j] > 1.0f){
                    float rem = dp[i][j] - 1.0f;
                    dp[i][j] = 1.0f;
                    dp[i + 1][j] += rem /2.0f;
                    dp[i + 1][j + 1] += rem /2.0f;
                }
            }
        }
        return dp[r - 1][c - 1];
    }


    public static  int minCost(int[] a, int [] b){
        Pair[] pairs = new Pair[a.length];
        for(int i = 0; i < a.length; i++){
            Pair pair = new Pair(a[i], b[i]);
            pairs[i] = pair;
        }
        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.len == o2.len){
                    return o1.cost - o2.cost;
                }else {
                    return o1.len - o2.len;
                }
            }
        });


        int total = Integer.MAX_VALUE;

        int front = pairs[0].len;
        int back = pairs[pairs.length - 1].len;

        for(int i = front; i <= back; i++){
            int local = 0;
            for (Pair pair : pairs) {
                int diff = Math.abs(pair.len - i);
                local += (diff * pair.cost);
            }
            total = Math.min(local, total);
        }

        return total;
    }


    static long total;
    public static long fishPopulation(long n, long nb, long g){
        total = nb;

        recursion(n, 1, nb, g);
        return  total;

    }

    public static void recursion(long left, long age, long count, long child){
        if(left == 0){
            return;
        }
        if(age == 4){
            total -= count;
            return;
        }
        if(age == 1 || age == 2){
            //new born
            total += (count * child);
            recursion(left - 1, 1, count * child, child);
        }
        recursion(left - 1, age + 1, count, child);

    }

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

    public static int longestChain(int n, String[] a){
        TrieNode root = new TrieNode('0');

        //insert strings
        for(String str: a){
            insert(str, root);
        }

        //dfs
        int maxEnds = dfsTrie(root);

        return  maxEnds;
    }

    public static void insert(String word, TrieNode root){
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

    public static int dfsTrie(TrieNode root){
        if(root == null){
            return  0;
        }
        int count = 0;
        for(TrieNode child: root.children){
            int childCount = dfsTrie(child);
            count = Math.max(count, childCount);
        }
        if(root.isLast){
            count++;
        }
        return  count;
    }

}