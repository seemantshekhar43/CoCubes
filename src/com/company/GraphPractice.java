package com.company;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GraphPractice {
    public static void main(String[] args) {
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        List<Integer> wt = new ArrayList<>();

        String ramesh = "Ramesh";
        System.out.println(ramesh);
        changeString(ramesh);
        System.out.println(ramesh);

        from.add(1);
        from.add(2);
        from.add(1);
        from.add(4);
//        from.add(1);
//        from.add(5);

        to.add(2);
        to.add(3);
        to.add(4);
        to.add(3);
//        to.add(5);
//        to.add(3);

        wt.add(100);
        wt.add(200);
        wt.add(10);
        wt.add(20);
//        wt.add(4);
//        wt.add(6);
        System.out.println(getMinimumStress(4, from, to, wt, 1, 3));
    }

    public static void changeString(String ramesh){
        ramesh = "Suresh";
        System.out.println(ramesh);
    }

    public static ArrayList<ArrayList<Integer>> getConnectedComponentsOfGraph(ArrayList<ArrayList<Integer>> graph){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];

        for(int i = 0; i < graph.size(); i++){
            if(!visited[i]){
                ArrayList<Integer> component = new ArrayList<>();
                dfsComponent(i, visited, component, graph);
                list.add(component);
            }
        }
        return list;
    }

    public static void dfsComponent(int src, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> graph){

        visited[src] = true;
        list.add(src);
        for(Integer neigh: graph.get(src)){
            if(!visited[neigh]){
                dfsComponent(neigh, visited, list, graph);
            }
        }
    }

    public static boolean isGraphConnected(ArrayList<ArrayList<Integer>> graph){

        boolean[] visited = new boolean[graph.size()];
        dfsIsConnected(0, visited, graph);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public static void dfsIsConnected(int src, boolean[] visited, ArrayList<ArrayList<Integer>> graph){
        visited[src] = true;
        for(Integer neigh: graph.get(src)){
            if(!visited[neigh]){
                dfsIsConnected(neigh, visited, graph);
            }
        }
    }

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static int getMinimumStress(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo, List<Integer> graphWeight, int source, int destination){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < graphNodes; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < graphFrom.size(); i++){
            int src = graphFrom.get(i) - 1;
            int dest = graphTo.get(i) - 1;
            int wt = graphWeight.get(i);
            Edge edge = new Edge(src, dest, wt);
            graph.get(src).add(edge);
            Edge edge1 = new Edge(dest, src, wt);
            graph.get(dest).add(edge1);
        }

        int stress =  getMinWeight(new Edge(-1, source - 1, -1), destination - 1, graph, new boolean[graphNodes]);
        if(stress == Integer.MAX_VALUE){
            return -1;
        }
        return stress;
    }

    public static int getMinWeight(Edge curr, int dest, ArrayList<ArrayList<Edge>> graph, boolean[] visited){
        if(curr.dest == dest){
            return curr.wt;
        }

        visited[curr.dest] = true;
        int max = curr.wt;
        int min = Integer.MAX_VALUE;
        for(Edge edge: graph.get(curr.dest)){
            if(!visited[edge.dest]){
                int val = getMinWeight(edge, dest, graph, visited);
                min = Math.min(val, min);
            }
        }
        max = Math.max(min, max);
        visited[curr.dest] = false;
        return max;
    }
    
     public static String reverse(char[] charArray){
        String str= new String(charArray);
        String[] arr = str.split("\\s+");
        int start = 0;
        int end = arr.length - 1;

        while(start <  end){
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        StringBuilder ans = new StringBuilder();
        for(String s: arr){
            ans.append(s).append(" ");
        }

        return  ans.toString();

     }

    
}
