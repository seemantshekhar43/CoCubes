package com.company;

public class MaximumGoldMine {

    static int maxGold(int n, int m, int[][] M)
    {
        // code here
        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;

        for(int j = m-1; j >= 0; j--){
            for(int i = n-1; i >= 0; i--){

                if(j == m-1){
                    dp[i][j] = M[i][j];
                }else{
                    int lMax = dp[i][j+1];
                    if(i+1 < n){
                        lMax = Math.max(lMax, dp[i+1][j+1]);
                    }

                    if(i - 1 >= 0){
                        lMax = Math.max(lMax, dp[i-1][j+1]) ;
                    }
                    dp[i][j] = lMax +M[i][j];
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}};
        System.out.println(maxGold(mat.length, mat[0].length, mat));
    }
}
