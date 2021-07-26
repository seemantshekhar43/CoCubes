package com.company;

public class SumOfNodesAtDistanceK {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }


    public static void main(String[] args) {
        Node root;
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node target = root.left.right;
        System.out.println(KDistanceNodesSum(root, target.data, 2));
    }

    public static int KDistanceNodesSum(Node root, int target , int k)
    {
       int sum = 0;
        Node[] path = nodeToRootPath(root, target, 1);
        if(path.length == 0){
            return sum;
        }

        Node prev = null;

        for(int i = path.length - 1; i >= 0 && k>= 0; i--, k--){
            sum += KNodeDownSum(path[i], prev, k);
            prev = path[i];
        }

        return sum;

    }


    public static int KNodeDownSum(Node root, Node block, int k){
        if(root == null || root == block){
            return 0;
        }

        if(k == 0){
            return root.data;
        }
        return KNodeDownSum(root.left, block, k-1) + KNodeDownSum(root.right, block, k-1);
    }


    public static Node[] nodeToRootPath(Node root, int target, int count){
        if(root == null){
            return new Node[0];
        }

        if(root.data == target){
            Node[] path = new Node[count];
            path[count-1] = root;

            return path;
        }

        Node[] leftPath = nodeToRootPath(root.left, target, count+1);
        if(leftPath.length > 0){
            leftPath[count - 1] = root;

            return leftPath;
        }

        Node[] rightPath = nodeToRootPath(root.right, target, count+1);
        if(rightPath.length > 0){

            rightPath[count - 1] = root;

            return rightPath;
        }

        return new Node[0];
    }
}
