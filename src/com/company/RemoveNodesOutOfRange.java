package com.company;

public class RemoveNodesOutOfRange {

    static class Node{
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public static Node trimBST(Node root, int low, int high) {
        if(root == null){
            return null;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if(root.data > high){
            Node left = root.left;
            root = null;
            return left;

        }else if(root.data < low){
            Node right = root.right;
            root = null;
            return right;
        }
        return root;
    }



    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 6);
        root = insert(root, -13);
        root = insert(root, 14);
        root = insert(root, -8);
        root = insert(root, 15);
        root = insert(root, 13);
        root = insert(root, 7);

        System.out.print("Inorder Traversal of " +
                "the given tree is: ");
        inorderTraversal(root);

        root = trimBST(root, -10, 13);

        System.out.print("\nInorder traversal of " +
                "the modified tree: ");
        inorderTraversal(root);
    }

    public static Node insert(Node root,
                              int key)
    {
        if(root == null)
        {
            return new Node(key);
        }
        if(root.data > key)
        {
            root.left = insert(root.left, key);
        }
        else
        {
            root.right = insert(root.right, key);
        }
        return root;
    }

    private static void inorderTraversal(Node root)
    {
        if(root != null)
        {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    // Driver code

}
