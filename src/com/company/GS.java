package com.company;

import java.util.*;

public class GS {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int initR = 0;
        int initC = 0;
        int finalR = 1;
        int finalC = 2;
        int[][] dp = new int[rows][cols];


        int[] costRowArr = new int[]{ 2, 5};
        int[] costColArr = new int[]{ 6, 1};


        List<Integer> costRows = new ArrayList<>();
        List<Integer> costCols = new ArrayList<>();

        costRows.add(2);
        costRows.add(5);
//        costRows.add(3);

        costCols.add(6);
        costCols.add(1);
//        costCols.add(6);
//
//        int[] costRowArr = new int[costRows.size()];
//        int[] costColArr = new int[costCols.size()];
//
//        for(int i = 0; i< costRows.size(); i++){
//            costRowArr[i] = costRows.get(i);
//        }
//
//        for(int i = 0; i< costCols.size(); i++){
//            costColArr[i] = costCols.get(i);
//        }

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }


        //System.out.println(minCost(initRow, sCol, dRow, dCol, costRowArr, costColArr, rows, cols, new boolean[rows][cols], dp));
//        for(int[] arr: dp){
//            System.out.println(Arrays.toString(arr));
//        }


//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        boolean[][] visited = new boolean[rows][cols];
//        pq.add(new Pair(initR, initC, 0));
//        while(!pq.isEmpty()){
//            //remove
//            Pair curr = pq.remove();
//
//            //mark*
//            if(!visited[curr.r][curr.c]){
//                visited[curr.r][curr.c] = true;
//            }else{
//                continue;
//            }
//
//            //work
//            if(curr.r == finalR && curr.c == finalC){
//                System.out.println(curr.cost);
//                break;
//            }
//
//            //add*
//            if(curr.r - 1 >= 0 && !visited[curr.r - 1][curr.c]){
//                pq.add(new Pair(curr.r - 1, curr.c, curr.cost + costRows.get(curr.r - 1)));
//            }
//            if(curr.r + 1 < rows && !visited[curr.r + 1][curr.c]){
//                pq.add(new Pair(curr.r + 1, curr.c, curr.cost + costRows.get(curr.r)));
//            }
//            if(curr.c - 1 >= 0 && !visited[curr.r][curr.c - 1]){
//                pq.add(new Pair(curr.r, curr.c - 1, curr.cost + costCols.get(curr.c - 1)));
//            }
//            if(curr.c + 1 < cols && !visited[curr.r][curr.c + 1]){
//                pq.add(new Pair(curr.r, curr.c + 1, curr.cost + costCols.get(curr.c)));
//            }
//        }


        System.out.println(minCost(rows, cols, initR, initC, finalR, finalC, costRows, costCols));
        System.out.println(minCost2(rows, cols, initR, initC, finalR, finalC, costRows, costCols));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(countPairs(list, 2));

        System.out.println(minCost3(initR, initC, finalR, finalC, costRows, costCols, rows, cols, new boolean[rows][cols]));

    }

    public static int minCost(int rows, int cols, int initR, int initC, int finalR, int finalC, List<Integer> costRows, List<Integer> costCols) {
        Queue<Pair> pq = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        pq.add(new Pair(initR, initC, 0));
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            //remove
            Pair curr = pq.remove();

            //mark*
            if (!visited[curr.r][curr.c]) {
                visited[curr.r][curr.c] = true;
            } else {
                continue;
            }

            //work
            if (curr.r == finalR && curr.c == finalC) {
                ans = Math.min(ans, curr.cost);

            }

            //add*
            if (curr.r - 1 >= 0 && !visited[curr.r - 1][curr.c]) {
                pq.add(new Pair(curr.r - 1, curr.c, curr.cost + costRows.get(curr.r - 1)));
            }
            if (curr.r + 1 < rows && !visited[curr.r + 1][curr.c]) {
                pq.add(new Pair(curr.r + 1, curr.c, curr.cost + costRows.get(curr.r)));
            }
            if (curr.c - 1 >= 0 && !visited[curr.r][curr.c - 1]) {
                pq.add(new Pair(curr.r, curr.c - 1, curr.cost + costCols.get(curr.c - 1)));
            }
            if (curr.c + 1 < cols && !visited[curr.r][curr.c + 1]) {
                pq.add(new Pair(curr.r, curr.c + 1, curr.cost + costCols.get(curr.c)));
            }
        }
        return ans;
    }

    public static class Pair implements Comparable<Pair> {
        int r;
        int c;
        int cost;

        public Pair(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        public int compareTo(Pair o) {
            return o.cost - this.cost;
        }
    }

    private static int minCost2(int rows, int cols, int initR, int initC, int finalR, int finalC, List<Integer> costRows,
                                List<Integer> costCols) {
        int ans = Integer.MAX_VALUE;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean visit[][] = new boolean[rows][cols];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        visit[initR][initC] = true;
        queue.add(new int[]{initR, initC, 0});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();

            if (q[0] == finalR && q[1] == finalC) {

                ans = Math.min(ans, q[2]);

            }

            for (int d = 0; d < 4; d++) {
                int nr = q[0] + dir[d][0];
                int nc = q[1] + dir[d][1];
                if ((nr < rows && nr > -1 && nc < cols && nc > -1) && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    int cost = q[2];
                    if (d == 0 || d == 1) {

                        cost += costRows.get(q[0]);

                    } else {

                        cost += costCols.get(q[1]);

                    }

                    queue.add(new int[]{nr, nc, cost});
                }
            }
        }

        return ans;
    }

    public static int minCost(int sRow, int sCol, int dRow, int dCol, int[] costRow, int[] costCol, int nRow, int nCol, boolean[][] visited, int[][] dp) {
        if (sRow == dRow && sCol == dCol) {
            return 0;
        }

        if (dp[sRow][sCol] != -1) {
            return dp[sRow][sCol];
        }
        visited[sRow][sCol] = true;
        int min = 1000000000;
        if (sRow - 1 >= 0 && !visited[sRow - 1][sCol]) {
            min = Math.min(min, minCost(sRow - 1, sCol, dRow, dCol, costRow, costCol, nRow, nCol, visited, dp) + costRow[sRow - 1]);
        }
        if (sRow + 1 < nRow && !visited[sRow + 1][sCol]) {
            min = Math.min(min, minCost(sRow + 1, sCol, dRow, dCol, costRow, costCol, nRow, nCol, visited, dp) + costRow[sRow]);
        }

        if (sCol - 1 >= 0 && !visited[sRow][sCol - 1]) {
            min = Math.min(min, minCost(sRow, sCol - 1, dRow, dCol, costRow, costCol, nRow, nCol, visited, dp) + costCol[sCol - 1]);
        }
        if (sCol + 1 < nCol && !visited[sRow][sCol + 1]) {
            min = Math.min(min, minCost(sRow, sCol + 1, dRow, dCol, costRow, costCol, nRow, nCol, visited, dp) + costCol[sCol]);
        }
        visited[sRow][sCol] = false;
        dp[sRow][sCol] = min;
        return min;

    }

    public static long threeSum(long t, List<Integer> d) {
        Collections.sort(d);
        long count = 0;

        for (int i = 0; i < d.size() - 2; i++) {
            int start = i + 1;
            int end = d.size() - 1;

            while (start < end) {
                if (d.get(i) + d.get(start) + d.get(end) > t) {
                    end--;
                } else {

                    count += (end - start);
                    start++;
                }
            }
        }
        return count;
    }


    public static int countPairs(List<Integer> numbers, int k){
        HashSet<Integer> set = new HashSet<>(numbers);
        if(k == 0){
            return set.size();
        }
        int count = 0;
        for(Integer num: set){
            if(set.contains(num + k)){
                count++;
            }
        }
        return count;
    }

    public static int minCost3(int sRow, int sCol, int dRow, int dCol, List<Integer> costRow, List<Integer> costCol, int nRow, int nCol,  boolean[][] visited) {


        if (sRow == dRow && sCol == dCol) {
            return 0;
        }


        visited[sRow][sCol] = true;
        int min = 1000000000;
        if (sRow - 1 >= 0 && !visited[sRow - 1][sCol]) {
            min = Math.min(min, minCost3(sRow - 1, sCol, dRow, dCol, costRow, costCol, nRow, nCol, visited) + costRow.get(sRow - 1));
        }
        if (sRow + 1 < nRow && !visited[sRow + 1][sCol]) {
            min = Math.min(min, minCost3(sRow + 1, sCol, dRow, dCol, costRow, costCol, nRow, nCol, visited) + costRow.get(sRow));
        }

        if (sCol - 1 >= 0 && !visited[sRow][sCol - 1]) {
            min = Math.min(min, minCost3(sRow, sCol - 1, dRow, dCol, costRow, costCol, nRow, nCol, visited) + costCol.get(sCol - 1));
        }
        if (sCol + 1 < nCol && !visited[sRow][sCol + 1]) {
            min = Math.min(min, minCost3(sRow, sCol + 1, dRow, dCol, costRow, costCol, nRow, nCol, visited) + costCol.get(sCol));
        }
        visited[sRow][sCol] = false;

        return min;
    }

}
