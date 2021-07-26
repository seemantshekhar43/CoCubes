package com.company;

public class SumOfCousinsNodes {
    static class Node{
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static class Pair{
        Node parent;
        int level;
        boolean found;
        public Pair(Node parent, int level){
            this.level = level;
            this.parent = parent;
            this.found = false;
        }

    }

    public static int sumOfCousins(Node root, int target){
        Pair pair = new Pair(null, -1);
        levelOfNode(root, 0, target, null, pair);
        if(pair.parent == null || pair.level == -1){
            return -1;
        }
        int sum = sumAtLevel(root, pair, pair.level);

        return pair.found? sum: -1;
    }


    public static boolean levelOfNode(Node root, int level, int target, Node parent, Pair pair){
        if(root == null){
            return false;
        }
        if(root.data == target){
            pair.level = level;
            pair.parent = parent;
            return true;
        }


        boolean found= levelOfNode(root.left, level+1, target, root, pair);
        if(found){
            return true;
        }
        return levelOfNode(root.right, level+1, target, root, pair);
    }

    public static int sumAtLevel(Node root, Pair pair, int level){
        if(root == null ||root == pair.parent){
            return 0;
        }
        if(level == 0){
            pair.found = true;
            return root.data;
        }

        return sumAtLevel(root.left, pair, level-1) + sumAtLevel(root.right, pair, level-1);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(sumOfCousins(root, 7));
    }
}
