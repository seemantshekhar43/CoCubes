package com.company;

public class LongestConsecutivePathInACharacterMatrix {

    static int maxCalculator(char[][] mat, int i, int j, char prev, int[][] dp, int[] rowHelper, int[] colHelper)
    {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length){
            return 0;
        }
        if((mat[i][j] - prev) != 1){
            return 0;
        }
        int result = 0;
        for (int k=0; k<8; k++)
            result = Math.max(result, 1 + maxCalculator(mat, i + rowHelper[k],
                    j + colHelper[k], mat[i][j], dp, rowHelper, colHelper));
        return dp[i][j] = result;
    }


    static int getLen(char[][]mat, char ch)
    {

        if(mat.length == 0){
            return 0;
        }

        int[][] dp = new int[mat.length][mat[0].length];
        int[] rowHelper = {0, 1, 1, -1, 1, 0, -1, -1};
        int[] colHelper = {1, 0, 1, 1, -1, -1, 0, -1};
        for(int i = 0; i< dp.length; ++i)
            for(int j = 0; j< dp[i].length; ++j)
                dp[i][j] = -1;

        int max = 0;

        for (int i = 0; i< mat.length; i++)
        {
            for (int j = 0; j< mat[i].length; j++)
            {
                if (mat[i][j] == ch) {
                    for (int k=0; k<8; k++)
                        max = Math.max(max, 1 + maxCalculator(mat,
                                i + rowHelper[k], j + colHelper[k], ch, dp, rowHelper, colHelper));
                }
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        char[][] mat = {
                { 'D', 'E', 'H', 'X', 'B' },
                { 'A', 'O', 'G', 'P', 'E' },
                { 'D', 'D', 'C', 'F', 'D' },
                { 'E', 'B', 'E', 'A', 'S' },
                { 'C', 'D', 'Y', 'E', 'N' }
        };

        System.out.println(getLen(mat, 'C') );

    }
}
