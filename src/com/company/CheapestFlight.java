package com.company;

import java.util.ArrayList;

class CheapestFlight {


    public static void main(String[] args) {
        int n = 19;
        int[][] flights = {{3,15,7066},{2,7,9254},{15,12,54},{6,8,8137},{7,12,9819},{5,2,7956},{14,3,6675},{8,14,4543},{5,13,1689},{2,12,1220},{9,15,5710},{11,13,5799},{16,3,154},{4,6,5499},{13,2,1143},{0,6,485},{16,2,5211},{9,7,4453},{0,8,8798},{4,9,4760},{16,6,9182},{6,18,3774},{17,3,630},{0,2,5689},{18,1,4688},{4,11,4044},{14,0,4253},{2,18,3697},{16,18,7525},{15,14,1480},{2,10,4931},{10,8,1741},{3,10,7964},{7,15,7880},{17,2,9694},{6,14,9167},{10,1,6844},{13,3,4742},{16,15,6428},{0,1,5819},{13,17,2815},{14,17,5654},{5,3,8906},{9,14,9342},{7,17,3559},{16,12,2633},{17,9,331},{10,4,3234},{2,17,9607},{12,5,2003},{5,9,6784},{15,0,175},{10,11,6834},{2,9,6348},{18,13,7372},{15,7,3535},{1,14,7877},{1,4,8036},{7,16,7089},{1,12,6523},{4,14,3668},{1,10,8785},{1,13,1219},{13,11,8834},{18,11,2920},{12,2,531},{4,17,8509},{2,11,3368},{16,5,5302},{14,5,6143},{10,14,1639},{10,16,7114},{10,13,9941},{13,18,1779},{9,5,5628},{12,14,2892},{11,17,1064},{1,17,8652},{15,16,8192},{9,10,260},{7,1,6405},{16,7,3532},{3,0,9842},{12,16,3233},{13,1,8375},{10,7,6730},{18,4,6232},{17,5,7097},{14,13,7290},{10,2,4442},{13,5,8228},{14,6,4709},{6,11,4636},{14,8,10000},{8,9,9133},{5,18,6091},{10,3,6397},{4,3,8425},{14,12,7883},{4,16,901},{16,4,4051},{1,0,7827},{5,11,8596},{18,9,4058},{18,6,5500},{16,9,2414},{12,11,4230},{1,6,3821},{18,0,1299},{11,5,4232},{15,2,5251},{12,13,1716},{17,15,3},{0,16,1708},{3,11,661},{17,16,9213},{8,0,2913},{2,6,556},{5,1,9106},{16,10,7006},{2,13,3038}};
        int src = 12;
        int dest = 10;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dest, k));
    }

    public static class Pair{
        int v;
        int w;

        public Pair(int v, int w){
            this.v = v;
            this. w = w;
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {



        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Pair> list = new ArrayList<>();
            graph.add(list);
        }
        for(int[] arr: flights){
            int s = arr[0];
            int d = arr[1];
            int wt = arr[2];

            graph.get(s).add(new Pair(d, wt));
        }

        int min = dfs(src, dst, k+1, 0, graph, new boolean[n]);
        return min != Integer.MAX_VALUE ? min : -1;

    }

    public static int dfs(int src, int dest, int k, int sum, ArrayList<ArrayList<Pair>> graph, boolean[] visited){


        if(src == dest){
            System.out.println("path");
            if(k >= 0){
                return sum;
            }
            return Integer.MAX_VALUE;
        }

        visited[src] = true;
        int min = Integer.MAX_VALUE;
        for(Pair neigh: graph.get(src)){
            if(!visited[neigh.v]){
                min = Math.min(min, dfs(neigh.v, dest, k - 1, sum+neigh.w, graph, visited));
            }
        }
        visited[src] = false;
        return min;

    }
}
