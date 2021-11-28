package com.company;

import java.util.*;

public class AmazonSDETest {
    public static void main(String[] args) {
        List<List<Integer>> forwardRouteList = new ArrayList<>();
        List<List<Integer>> backwardRouteList = new ArrayList<>();
        int maxTravelDist = 10000;

        List<Integer> f1 = new ArrayList<>();
        f1.add(1);
        f1.add(3000);
        forwardRouteList.add(f1);

        List<Integer> f3 = new ArrayList<>();
        f3.add(2);
        f3.add(5000);
        forwardRouteList.add(f3);

        List<Integer> f2 = new ArrayList<>();
        f2.add(3);
        f2.add(7000);
        forwardRouteList.add(f2);

        List<Integer> f4 = new ArrayList<>();
        f4.add(4);
        f4.add(10000);
        forwardRouteList.add(f4);

        List<Integer> b1 = new ArrayList<>();
        b1.add(1);
        b1.add(2000);
        backwardRouteList.add(b1);

        List<Integer> b2 = new ArrayList<>();
        b2.add(2);
        b2.add(3000);
        backwardRouteList.add(b2);

        List<Integer> b3 = new ArrayList<>();
        b3.add(3);
        b3.add(4000);
        backwardRouteList.add(b3);

        List<Integer> b4 = new ArrayList<>();
        b4.add(4);
        b4.add(5000);
        backwardRouteList.add(b4);

        System.out.println(routePairs2(maxTravelDist, forwardRouteList, backwardRouteList));



        List<List<Integer>> allocations = new ArrayList<>();

        List<Integer> c1 = new ArrayList<>();
        c1.add(1);
        c1.add(2);
        allocations.add(c1);

        c1 = new ArrayList<>();
        c1.add(3);
        c1.add(4);
        allocations.add(c1);

        c1 = new ArrayList<>();
        c1.add(1);
        c1.add(-1);
        allocations.add(c1);

        System.out.println(findRestaurants(allocations, 2));

    }

    public static List<List<Integer>> routePairs(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> backwardRouteList){
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        for(List<Integer> backRoute: backwardRouteList){
            if(!map.containsKey(backRoute.get(1))){
                map.put(backRoute.get(1), new ArrayList<>());
            }
            map.get(backRoute.get(1)).add(backRoute);
        }

        int max = Integer.MIN_VALUE;
        for(List<Integer> forwRoute: forwardRouteList){
            int rem = maxTravelDist - forwRoute.get(1);
            int id = forwRoute.get(0);

            Integer closest = map.floorKey(rem);

            if(closest != null && closest + forwRoute.get(1) >= max){
                int total = closest + forwRoute.get(1);

                List<List<Integer>> local = new ArrayList<>();
                for(List<Integer> curr: map.get(closest)){
                    List<Integer> uidList = new ArrayList<>();
                    uidList.add(id);
                    uidList.add(curr.get(0));
                    local.add(uidList);
                }

                if(total > max){
                    result.clear();
                }
                max = total;

                result.addAll(local);

            }
        }

        if(result.size() == 0){
            result.add(new ArrayList<>());
        }

        return  result;
    }


    /*
    * Approach is to store the returnRoute in TreeMap(distance, list of returnRoute pairs having that distance). After doing so,
    * traverse through the forwardRouteList. While traversing calculate remaining distance to achieve maxTravelDist(rem = maxTravelDist - forwRoute.get(1)).
    * Now find the distance(closest) in treeMap just smaller than equal to this remaining distance rem(we are using treemap floorKey() method to achieve this).
    * if we got such distance we check whether the sum of closest and forwDistance is greater than current max value or not.
    * If our sum is greater than or equal to max value. we are appending all such keys in our final result.
    * After traversing through the forwardRouteList, if we didn't find any such pair, we are simply adding an empty list in our result as mentioned in problem.
    * finally returning the result.
    *
    *
    *
    * */

    public static List<List<Integer>> findRestaurants(List<List<Integer>> allocations, int numRestaurants){
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(allocations, new Comparator<List<Integer>>() {

            public int compare(List<Integer> o1, List<Integer> o2) {
                int dist1 = (o1.get(0)*o1.get(0)) + ((o1.get(1)*o1.get(1)));
                int dist2 = (o2.get(0)*o2.get(0)) + ((o2.get(1)*o2.get(1)));

                return dist1 - dist2;
            }
        });

       for(List<Integer> curr: allocations){
           if(numRestaurants <= 0){
               break;
           }
           result.add(new ArrayList<>(curr));
           numRestaurants--;
       }

       if(result.size() == 0){
           result.add(new ArrayList<>());
       }

       return result;
    }

    public static List<List<Integer>> routePairs2(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> backwardRouteList){
        List<List<Integer>> result = new ArrayList<>();

        Collections.sort(backwardRouteList, new Comparator<List<Integer>>() {

            public int compare(List<Integer> o1, List<Integer> o2){

                return o1.get(1) - o2.get(1);
            }
        });


        int max = Integer.MIN_VALUE;

        for(List<Integer> forwRoute: forwardRouteList){
            int rem = maxTravelDist - forwRoute.get(1);
            int id = forwRoute.get(0);

            int closest = getLessThanEqualTo(rem, backwardRouteList);

            if(closest != -1){
                int closestVal = backwardRouteList.get(closest).get(1);
                int total = closestVal + forwRoute.get(1);
                if( total < max){
                    continue;
                }


                if(total > max){
                    result.clear();
                }
                max = total;



                while(closest >= 0 && backwardRouteList.get(closest).get(1) == closestVal){
                    List<Integer> uidList = new ArrayList<>();
                    uidList.add(id);
                    uidList.add(backwardRouteList.get(closest).get(0));
                    result.add(uidList);
                    closest--;
                }
            }
        }

        if(result.size() == 0){
            result.add(new ArrayList<>());
        }

        return  result;
    }


    public static  int getLessThanEqualTo(int val, List<List<Integer>> backwardRouteList){
        int start = 0;
        int end = backwardRouteList.size() - 1;
        int res = -1;
       while(start <= end){
           int mid = start +  (end - start) / 2;

           if(backwardRouteList.get(mid).get(1) == val){
               return  mid;
           }else if(backwardRouteList.get(mid).get(1) > val){
               end = mid - 1;
           }else {
               res = mid;
               start = mid + 1;
           }
       }

       return res;

    }

}
