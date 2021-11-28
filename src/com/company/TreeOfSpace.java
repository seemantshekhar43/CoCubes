package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeOfSpace {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = getValue(bufferedReader);
        int numChildren =getValue(bufferedReader);
        int numQueries = getValue(bufferedReader);
        ArrayList<String> countries = new ArrayList<>();
        for(int i = 0; i< size; i++){
            countries.add(getCountry(bufferedReader));
        }
        Tree tree = new Tree(countries, numChildren);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numQueries; i++){
            result.append(getResult(tree, bufferedReader)).append("\n");
        }
        System.out.println(result.toString());

    }

    public static int getValue(BufferedReader bufferedReader) throws IOException {

        StringTokenizer tok = new StringTokenizer(bufferedReader.readLine());
        return Integer.parseInt(tok.nextToken());
    }

    public static String getCountry(BufferedReader bufferedReader) throws  IOException{

        StringTokenizer tok = new StringTokenizer(bufferedReader.readLine());
        String country = tok.nextToken();
        return country;
    }

    public static String getResult(Tree tree, BufferedReader bufferedReader) throws IOException {


        StringTokenizer tok = new StringTokenizer(bufferedReader.readLine());
        int queryCode = Integer.parseInt(tok.nextToken());
        String value = tok.nextToken();
        int uid = Integer.parseInt(tok.nextToken());
        return tree.resolveQuery(queryCode, value, uid) +"";

    }

    static public class Node{
        int uid;
        String country;
        Node parent;
        ArrayList<Node> children;
        int lockStatus;
        HashSet<Node> subtreeLockedDescendants;

        public Node(String country, Node parent){
            this.country = country;
            this.parent = parent;
            this.subtreeLockedDescendants = new HashSet<>();
            this.children = new ArrayList<>();
            this.lockStatus = 0;
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
            Node r = nodeConstructor(list.get(0), null);

            Queue<Node> queue = new ArrayDeque<>();
            queue.add(r);
            int count = 1;
            while (!queue.isEmpty()){
                Node curr = queue.remove();
                for(int i = 0; i< n && count < list.size(); i++){
                    Node node = nodeConstructor(list.get(count), curr);
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
                case 3:
                    return upgradeLock(value, uid);
            }

            return false;

        }


        public boolean lock(String value, int uid){
            if(!this.valueNodeMap.containsKey(value)){
                return false;
            }

            Node node = this.valueNodeMap.get(value);
            if(node.lockStatus == 1){
                return false;
            }

            if(node.subtreeLockedDescendants.size() > 0){
                return  false;
            }

            if(!isParentLocked(node)){
                return false;
            }

            node.lockStatus = 1;
            node.uid = uid;
            incrementCountInParent(node);

            return true;
        }

        public boolean unlock(String value, int uid){
            if(!this.valueNodeMap.containsKey(value)){
                return false;
            }

            Node node = this.valueNodeMap.get(value);
            if(node.lockStatus != 1){
                return false;
            }

            if(node.uid != uid){
                return  false;
            }

            node.lockStatus = 0;
            node.uid = Integer.MIN_VALUE;
            decrementCountInParent(node);

            return true;
        }

        public boolean upgradeLock(String value, int uid){
            if(!this.valueNodeMap.containsKey(value)){
                return false;
            }

            Node node = this.valueNodeMap.get(value);
            if(node.lockStatus == 1){
                return false;
            }

            if(node.subtreeLockedDescendants.size() == 0){
                return false;
            }
            if(!checkSubtreeLockUID(node, uid)){
                return  false;
            }

            unlockSubtree(node);
            lock(node.country, uid);

            return  true;
        }

        private void unlockSubtree(Node node){
            ArrayList<Node> nodes = new ArrayList<>(node.subtreeLockedDescendants);
            for(Node curr: nodes){
                unlock(curr.country, curr.uid);
            }
        }

        private boolean checkSubtreeLockUID(Node node, int uid){
            for(Node curr: node.subtreeLockedDescendants){
                if(curr.uid != uid){
                    return  false;
                }
            }
            return true;
        }

        private boolean isParentLocked(Node node){
            Node curr = node.parent;
            while(curr != null){
                if(curr.lockStatus == 1){
                    return false;
                }
                curr = curr.parent;
            }

            return true;
        }

        private void incrementCountInParent(Node node){
            Node curr = node.parent;
            while(curr != null){
                curr.subtreeLockedDescendants.add(node);
                curr = curr.parent;
            }

        }

        private void decrementCountInParent(Node node){
            Node curr = node.parent;
            //System.out.println("going to remove "+ node.value + " from " + curr.value);
            while(curr != null){
                curr.subtreeLockedDescendants.remove(node);
                curr = curr.parent;
            }
        }


        private Node nodeConstructor(String value, Node parent){
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
                System.out.println(curr.country);
                    for(Node node: curr.children){
                        queue.add(node);
                    }
            }
        }

    }

}

