package com.company;

public class MinimumSwapsToMakeSequencesIncreasing {

    public static void main(String[] args) {
        System.out.println(minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
    }


    public static int minSwap(int[] nums1, int[] nums2) {
        int swap = 1;
        int noSwap = 0;

        for(int i = 1 ; i< nums1.length; i++){

            int prevNoSwap = noSwap;
            int prevSwap = swap;
            swap = nums1.length;
            noSwap = nums1.length;

            boolean impossible = true;

            if(nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]){
                swap = prevSwap + 1;
                noSwap = prevNoSwap;
                impossible = false;
            }
            if(nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]){
                swap = Math.min(prevNoSwap + 1, swap);
                noSwap = Math.min(prevSwap, noSwap);
                impossible = false;
            }
            if(impossible){
                return -1;
            }



        }

        return Math.min(swap, noSwap);
    }
}
