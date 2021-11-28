package com.company;

import java.util.*;

class Result {

    /*
     * Complete the 'teamFormation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY score
     *  2. INTEGER team_size
     *  3. INTEGER k
     */

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> score = new ArrayList<>();
//        int n = scanner.nextInt();
//        for(int i = 0; i < n; i++){
//            score.add(scanner.nextInt());
//        }
//        int team_size = scanner.nextInt();
//        int k = scanner.nextInt();


//        //System.out.println(teamFormation(score, team_size, k));
//        System.out.println(getSpecialSubstring("abcde", 1, "10101111111111111111111111"));
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(3);
//        list.add(7);
//        list.add(10);
//        list.add(14);
//
//        System.out.println(rearrange(list));




    }

    static class ThreadDemo implements  Runnable{

        @Override
        public void run() {
            System.out.println("runnging");
        }
    }



    public static long teamFormation(List<Integer> score, int team_size, int m) {
        // Write your code here

        Integer max3=0;
        Integer max1=0;
        Integer max2=0;
        long add=0;

        int idx=0;
        List<Integer> score1=new ArrayList<Integer>();
        List<Integer> score2=new ArrayList<Integer>();
        for(int j=0;j<team_size;j++){
            if(score.size()<m)
                break;
            for(int i=0;i<m;i++)
            {

                score1.add(score.get(i));
                score2.add(score.get(score.size()-i-1));
            }
            max1= Collections.max(score1);
            max2=Collections.max(score2);
            if(max1 > max2)
            {
                max3=max1;
                add+=max3;
                idx=score1.indexOf(max1);
                score.remove(idx);
            }
            else{
                max3=max2;
                add+=max3;
                idx=score2.indexOf(max2);
                score.remove(score.size()-idx-1);
            }
            score1.clear();
            score2.clear();

        }
        return add;



    }


    public static int getSpecialSubstring(String s, int k, String charValue){
        int max = 0;
        int start = 0;
        int end = 0;
        int count = 0;

        while(end < s.length()){
            int idx = s.charAt(end) - 'a';

            if(charValue.charAt(idx) == '0'){
                count++;
            }

            if(count <= k){
                max = Math.max(max, end - start + 1);
                end++;
            }else{
                while(count > k){
                    if(charValue.charAt(s.charAt(start) - 'a') == '0'){
                        count--;
                    }
                    start++;
                }
                end++;
            }
        }

        return max;
    }

    public static List<Integer> rearrange(List<Integer> elements){

        Collections.sort(elements, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int nOne1 = getNoOfOne(o1);
                int nOne2 = getNoOfOne(o2);
                if(nOne1 != nOne2){
                    return nOne1 - nOne2;
                }else{
                    return o1 - o2;
                }
            }
        });

        return  elements;
    }

    public static int getNoOfOne(int n){
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

}
