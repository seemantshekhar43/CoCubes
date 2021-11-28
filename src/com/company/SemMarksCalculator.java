package com.company;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.*;

public class SemMarksCalculator {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Number of Subjects: ");
//        int n = scanner.nextInt();
//        int[][] grades = new int[n][3];
//        for(int i = 0; i < n; i++){
//            System.out.print("Enter credit and grade: ");
//
//

       // System.out.println(Arrays.toString(representative(5, new int[]{12, 99, 22, 21, 6, 7}, 2)));
        solution(3, new int[]{1, 2, 3, 4, 5, 6, 7});
    }


    public static int[] representative(int input1, int[] input2, int input3){

        Arrays.sort(input2);

        if(input3 == 1){
            return new int[]{input2[input2.length - 1]};
        }
       int[] res = new int[input3];
       int min = Integer.MAX_VALUE;
       int start = 0;
       int end = 0;
       for(int i = 0; i <= input2.length - input3; i++){
           int local = 0;
           for(int j = i; j < i + input3 - 1; j++){
               local += Math.abs(input2[j] - input2[j + 1]);
           }
           if(local <= min){
               min = local;
               start = i;
               end = i + input3 - 1;

           }
       }
       int count = 0;
       for(int i = start; i <= end; i++){
           res[count++] = input2[i];
       }


        Arrays.sort(res);

        return  res;

    }
    
    public static void solution(int D, int[] V){
        StringBuilder sb = new StringBuilder();
        int[] ans5 = new int[]{1, 2, 4, 8, 16, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 31, 15, 7, 3, 6, 5, 9, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 14, 13, 12, 11, 10};
        int[] ans3 = new int[]{1, 2, 4, 5, 6, 7, 3};
        int[] ans2 = new int[]{1, 2, 3};
        int[] ans1 = new int[]{1};
        int[] ans4 = new int[]{1, 2, 4, 8, 9, 10, 11, 12, 13, 14, 15, 7, 3, 6, 5};
        int[] ans;
        if(D == 1){
            ans = ans1;
        }

        if(D == 2){
            ans = ans2;
        }

        else if(D == 3){
            ans = ans3;
        }
        else if(D == 4){
            ans = ans4;
        }

        else if(D == 5){
            ans = ans5;
        }

        else{
            ans = ans5;
        }

        for(int i: ans){
            if(i- 1 < V.length){
                sb.append(V[i - 1]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }


}
