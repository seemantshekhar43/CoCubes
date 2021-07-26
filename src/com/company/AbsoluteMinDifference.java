package com.company;

public class AbsoluteMinDifference {

    public static int min_diff;


    public static void possibleSubArrays(int[] arr, int size, boolean[] elements,
                                         int count, boolean[] visited,
                                         int add, int present_add, int idx)
    {

        if (idx == size){
            return;
        }

        if ((size / 2 - count) > (size - idx)){
            return;
        }

        possibleSubArrays(arr, size, elements,
                count, visited, add,
                present_add, idx+1);

        count++;
        present_add = present_add + arr[idx];
        elements[idx] = true;

        if (count == size / 2)
        {
            if (Math.abs(add / 2 - present_add) < min_diff) {
                min_diff = Math.abs(add / 2 -
                        present_add);
                for (int i = 0; i < size; i++){
                    visited[i] = elements[i];
                }
            }
        }
        else{
            possibleSubArrays(arr, size, elements,
                    count,
                    visited, add, present_add,
                    idx + 1);
        }

        elements[idx] = false;
    }


    public static int tugOfWar(int arr[])
    {
        int size = arr.length;
        boolean[] elements = new boolean[size];
        boolean[] visited = new boolean[size];

        min_diff = Integer.MAX_VALUE;

        int sum = 0;
        for (int i = 0; i < size; i++)
        {
            sum += arr[i];
            elements[i] = visited[i] = false;
        }


        possibleSubArrays(arr, size, elements, 0,
                visited, sum, 0, 0);



       int sum1 = 0;
       int sum2 = 0;
        for (int i = 0; i < size; i++)
        {
            if (visited[i])
                sum1+=arr[i];
        }

        for (int i = 0; i < size; i++)
        {
            if (!visited[i])
                sum2+=arr[i];
        }

        return Math.abs(sum1 - sum2);
    }


    public static void main (String[] args)
    {
        int[] arr = {23, 45, -34, 12, 0, 98,
                -99, 4, 189, -1, 4};
        System.out.println(tugOfWar(arr));
    }
}
