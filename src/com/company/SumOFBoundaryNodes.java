package com.company;

public class SumOFBoundaryNodes {

    static class Node{
        int data;
     Node left, right;

     public Node(int d)
     {
         data = d;
         left = right = null;
     }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(8);
        root.left.right = new Node(14);
        root.right.left = new Node(11);
        root.right.right = new Node(3);
        root.left.right.left = new Node(12);
        root.right.left.right = new Node(1);
        root.right.left.left = new Node(7);

        System.out.println(sumOfBoundaryNodes(root));
    }

    public static int sumOfBoundaryNodes(Node node)
    {
        Node curr = node;
       int sum = 0;

        //node
        sum += node.data;
        //left
        curr = node.left;
        while(curr!= null && !(curr.left == null && curr.right == null)){
           sum+= curr.data;
            if(curr.left != null){
                curr = curr.left;
            }else{
                curr =curr.right;
            }
        }

        //leaf

        sum+= leafNodeSum(node);

        //right
        curr = node.right ;

        while(curr!= null && !(curr.left == null && curr.right == null)){
            sum+= curr.data;
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr =curr.left;
            }
        }

        return sum;
    }


    public static int leafNodeSum(Node node){
        if(node == null){
            return 0;
        }
        if(node.left == null  && node.right == null){
            return node.data;
        }
        return leafNodeSum(node.left) + leafNodeSum(node.right);
    }

}
