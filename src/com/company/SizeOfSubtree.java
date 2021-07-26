package com.company;

public class SizeOfSubtree {

    static class Node{
        int data;
      Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public static int sizeOfSubTreeIfExist(Node a, Node b){
        if(isSubtree(a, b)){
            return  sizeOfSubtree(b);
        }else{
            return -1;
        }
    }

    public static boolean isSubtree(Node root, Node subRoot) {

        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){

            boolean isValidSubTree = traverse(root, subRoot);
            if(isValidSubTree){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static int sizeOfSubtree(Node root){
        if(root == null){
            return 0;
        }
        return sizeOfSubtree(root.left) + sizeOfSubtree(root.right) + 1;
    }
    public static boolean traverse(Node root, Node curr){
        if(root == null && curr == null){
            return true;
        }else if(root == null){
            return false;
        }else if(curr == null){
            return false;
        }

        if(root.data != curr.data){
            return false;
        }

        return traverse(root.left, curr.left) && traverse(root.right, curr.right);
    }

    public static void main(String[] args) {

    }
}
