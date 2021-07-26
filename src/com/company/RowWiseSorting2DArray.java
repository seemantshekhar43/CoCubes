package com.company;

import java.util.Arrays;

public class RowWiseSorting2DArray {

    public static int[][] sort2DArray(int[][] mat){

        for(int i =0; i< mat.length; i++){
            sortArray(mat[i], 0, mat.length-1);
        }

        return mat;
    }

    public static void sortArray(int[] arr, int left, int right){
        if(left < right){
            int pivot = partition(arr, left, right);
            sortArray(arr, left, pivot-1);
            sortArray(arr,pivot+1, right);
        }
    }

    public static int partition(int[] arr, int left, int right){

        int pivot = arr[right];
        int i = left - 1;
        int j = left;
        for(; j< right; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return i;


    }

    public static void main(String[] args) {
        int[][] m = { { 3, 3, 3, 3 },
                { 7, 3, 0, 2 },
                { 9, 5, 3, 2 },
                { 6, 3, 1, 2 } };

        int[][] sorted = sort2DArray(m);
        for(int[] arr: sorted){
            System.out.println(Arrays.toString(arr));
        }


    }



}
