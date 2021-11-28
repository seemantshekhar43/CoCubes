//package com.company;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Check {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int len = scanner.nextInt();
//        int nNodes = scanner.nextInt();
//        int nQueries = scanner.nextInt();
//        ArrayList<String> values = new ArrayList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        for(int i = 0; i< len; i++){
//            String str = scanner.next();
//            values.add(str);
//        }
//        TreeOfSpace.Tree tree = new TreeOfSpace.Tree(values, nNodes);
////        tree.printTree();
//
//        //System.out.println(tree.lock("China", 9));
//        for(int i = 0; i < nQueries; i++){
//            int queryCode = scanner.nextInt();
//            String value = scanner.next();
//            int uid = scanner.nextInt();
//            System.out.println(tree.resolveQuery(queryCode, value, uid));
//        }
//
//
//
//
//    }
//}
