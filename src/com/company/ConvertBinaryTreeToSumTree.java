package com.company;

public class ConvertBinaryTreeToSumTree {

    static class Node{
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public static void toSumTree(Node root){
        //add code here.
        traverse(root);

    }

    public static int traverse(Node root){
        if(root == null){
            return 0;
        }
        int sum = root.data;

        int left = traverse(root.left);
        int right = traverse(root.right);
        root.data = left + right;
        return left + right + sum;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        toSumTree(root);

    }
}
