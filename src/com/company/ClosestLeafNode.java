package com.company;


public class ClosestLeafNode {

    static class NodeDistancePair{
        Node node;
        int distance = Integer.MAX_VALUE;
    }
    static class Node{
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }


    public static int closestLeaf(Node root, int target)
    {
        int sum = 0;
        if(root.left == null && root.right == null){
            return root.data;
        }
        Node[] path = nodeToRootPath(root, target, 1);



        Node prev = null;
        NodeDistancePair pair = new NodeDistancePair();
        for(int i = path.length - 1; i >= 0 ; i--){
            leafNodeDown(path[i], prev, path.length - i - 1, pair);
        }

        return pair.distance;

    }

    public static void leafNodeDown(Node root, Node block, int k, NodeDistancePair pair){
        if(root == null || root == block){
            return ;
        }

        if(root.left == null && root.right == null){
            if(k < pair.distance){
                pair.distance = k;
                pair.node = root;
            }
        }
        leafNodeDown(root.left, block, k+1, pair);
        leafNodeDown(root.right, block, k+1, pair);
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

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(13);
        root.right.left = new Node(14);
        root.right.right = new Node(15);
        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);
        root.right.left.left.left = new Node(1);
        root.right.left.left.right = new Node(2);
        root.right.left.right.left = new Node(3);
        root.right.left.right.right = new Node(4);
        root.right.right.left.left = new Node(5);
        root.right.right.left.right = new Node(6);
        root.right.right.right.left = new Node(7);
        root.right.right.right.right = new Node(8);
        Node x = root.right;

        System.out.println(closestLeaf(root, 15));
    }
}
