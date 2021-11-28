package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeOfSpaceLockUnlockOnly {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(br.readLine());
        int nNodes = Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(br.readLine());
        int nQueries = Integer.parseInt(st1.nextToken());
        ArrayList<String> values = new ArrayList<>();
        for(int i = 0; i< len; i++){
            st1 = new StringTokenizer(br.readLine());
            String str = st1.nextToken();
            values.add(str);
        }
        Tree tree = new Tree(values, nNodes);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nQueries; i++){
            st1 = new StringTokenizer(br.readLine());
            int queryCode = Integer.parseInt(st1.nextToken());
            String value = st1.nextToken();
            int uid = Integer.parseInt(st1.nextToken());
            sb.append(tree.resolveQuery(queryCode, value, uid)).append("\n");
        }
        System.out.println(sb.toString());

    }

    static public class Node{
        String value;
        Node parent;
        ArrayList<Node> children;
        boolean isLocked;
        int uid;
        int lockedDescendants;

        public Node(String value, Node parent){
            this.value = value;
            this.parent = parent;
            this.lockedDescendants = 0;
            this.children = new ArrayList<>();
            this.isLocked = false;
            this.uid = Integer.MIN_VALUE;
        }
    }

    public static class Tree{
        Node root;
        int num;
        HashMap<String, Node> valueNodeMap;

        public Tree(ArrayList<String> values, int n){
            this.valueNodeMap = new HashMap<>();
            this.root = constructTree(values, n);
            this.num = n;
        }

        private Node constructTree(ArrayList<String> list, int n){
            if(list.size() == 0){
                return null;
            }
            Node r = createNodeHelper(list.get(0), null);

            Queue<Node> queue = new ArrayDeque<>();
            queue.add(r);
            int count = 1;
            while (!queue.isEmpty()){
                Node curr = queue.remove();
                for(int i = 0; i< n && count < list.size(); i++){
                    Node node = createNodeHelper(list.get(count), curr);
                    curr.children.add(node);
                    queue.add(node);
                    count++;
                }
            }

            return r;
        }


        private boolean resolveQuery(int queryCode, String value, int uid){
            switch (queryCode){
                case 1:
                    return  lock(value, uid);
                case 2:
                    return unlock(value, uid);

            }

            return false;

        }


        public boolean lock(String value, int uid){
            if(!this.valueNodeMap.containsKey(value)){
                return false;
            }

            Node node = this.valueNodeMap.get(value);
            if(node.isLocked){
                return false;
            }

            if(node.lockedDescendants > 0){
                return  false;
            }

            if(!checkAncestorLockStatus(node)){
                return false;
            }

            node.isLocked = true;
            node.uid = uid;
            addNodeInParentLockList(node);

            return true;
        }

        public boolean unlock(String value, int uid){
            if(!this.valueNodeMap.containsKey(value)){
                return false;
            }

            Node node = this.valueNodeMap.get(value);
            if(!node.isLocked){
                return false;
            }

            if(node.uid != uid){
                return  false;
            }

            node.isLocked = false;
            node.uid = Integer.MIN_VALUE;
            removeNodeInParentLockList(node);

            return true;
        }



        private void unlockAllLockedDescendant(Node node){
            ArrayList<Node> nodes = new ArrayList<>(node.lockedDescendants);
            for(Node curr: nodes){
                unlock(curr.value, curr.uid);
            }
        }



        private boolean checkAncestorLockStatus(Node node){
            Node curr = node.parent;
            while(curr != null){
                if(curr.isLocked){
                    return false;
                }
                curr = curr.parent;
            }

            return true;
        }

        private void addNodeInParentLockList(Node node){
            Node curr = node.parent;
            while(curr != null){
                curr.lockedDescendants++;
                curr = curr.parent;
            }

        }

        private void removeNodeInParentLockList(Node node){
            Node curr = node.parent;
            //System.out.println("going to remove "+ node.value + " from " + curr.value);
            while(curr != null){
                curr.lockedDescendants--;
                curr = curr.parent;
            }
        }


        private Node createNodeHelper(String value, Node parent){
            Node node = new Node(value, parent);
            this.valueNodeMap.put(value, node);
            return node;
        }


        public void printTree(){
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(this.root);

            Node mark = new Node("", null);
            queue.add(mark);
            while (!queue.isEmpty()){
                Node curr = queue.remove();

                if(curr == mark){
                    System.out.println();
                    if(!queue.isEmpty()){
                        queue.add(mark);
                    }
                }
                System.out.println(curr.value);
                for(Node node: curr.children){
                    queue.add(node);
                }
            }
        }

    }

}

