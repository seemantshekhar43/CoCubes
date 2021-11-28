//package com.company;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class TreeOfSpaceThreadSafe {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        int len = Integer.parseInt(st1.nextToken());
//        st1 = new StringTokenizer(br.readLine());
//        int nNodes = Integer.parseInt(st1.nextToken());
//        st1 = new StringTokenizer(br.readLine());
//        int nQueries = Integer.parseInt(st1.nextToken());
//        ArrayList<String> values = new ArrayList<>();
//        for(int i = 0; i< len; i++){
//            st1 = new StringTokenizer(br.readLine());
//            String str = st1.nextToken();
//            values.add(str);
//        }
//        Tree tree = new Tree(values, nNodes);
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < nQueries; i++){
//            st1 = new StringTokenizer(br.readLine());
//            int queryCode = Integer.parseInt(st1.nextToken());
//            String value = st1.nextToken();
//            int uid = Integer.parseInt(st1.nextToken());
//            sb.append(tree.resolveQuery(queryCode, value, uid)).append("\n");
//        }
//        System.out.println(sb.toString());
//
//    }
//
//    static public class Node{
//        String value;
//        Node parent;
//        ArrayList<Node> children;
//        int isLocked;
//        int uid;
//        int lockedDescendants;
//
//        public Node(String value, Node parent){
//            this.value = value;
//            this.parent = parent;
//            this.lockedDescendants = 0;
//            this.children = new ArrayList<>();
//            this.isLocked = 0;
//            this.uid = Integer.MIN_VALUE;
//        }
//    }
//
//    public static class Tree{
//        Node root;
//        int num;
//        HashMap<String, Node> valueNodeMap;
//
//        public Tree(ArrayList<String> values, int n){
//            this.valueNodeMap = new HashMap<>();
//            this.root = constructTree(values, n);
//            this.num = n;
//        }
//
//        private Node constructTree(ArrayList<String> list, int n){
//            if(list.size() == 0){
//                return null;
//            }
//            Node r = createNodeHelper(list.get(0), null);
//
//            Queue<Node> queue = new ArrayDeque<>();
//            queue.add(r);
//            int count = 1;
//            while (!queue.isEmpty()){
//                Node curr = queue.remove();
//                for(int i = 0; i< n && count < list.size(); i++){
//                    Node node = createNodeHelper(list.get(count), curr);
//                    curr.children.add(node);
//                    queue.add(node);
//                    count++;
//                }
//            }
//
//            return r;
//        }
//
//
//        private boolean resolveQuery(int queryCode, String value, int uid){
//            switch (queryCode){
//                case 1:
//                    return  lock(value, uid);
//                case 2:
//                    return unlock(value, uid);
//            }
//
//            return false;
//
//        }
//
//
//        public boolean lock(String value, int uid){
//            if(!this.valueNodeMap.containsKey(value)){
//                return false;
//            }
//
//            Node node = this.valueNodeMap.get(value);
//
//            // if node has locked descendants
//            if(node.isLocked == 1 ||node.lockedDescendants > 0){
//                return  false;
//            }
//
//            // make lock status true
//            node.isLocked++;
//
//            // if node is already locked
//            if(node.isLocked > 1){
//                node.isLocked--;
//                return false;
//            }
//
//
//            Node curr = node.parent;
//            ArrayList<Node> list = new ArrayList<>();
//            boolean mark = false;
//
//            // check and update ancestor
//            while(curr != null){
//
//                // simply incrementing the lockedDescendants
//                curr.lockedDescendants++;
//                if( curr.isLocked == 1){
//
//                    curr.lockedDescendants--;
//                    mark = true;
//                    break;
//                }else {
//                    list.add(curr);
//                    curr = curr.parent;
//                }
//
//            }
//
//            if(node.lockedDescendants > 0 || mark){
//                for(Node n: list){
//                    n.lockedDescendants--;
//                }
//                node.isLocked--;
//                return  false;
//            }
//
//
//            node.uid = uid;
//            return true;
//        }
//
//        public boolean unlock(String value, int uid){
//            if(!this.valueNodeMap.containsKey(value)){
//                return false;
//            }
//
//            Node node = this.valueNodeMap.get(value);
//            if(!node.isLocked){
//                return false;
//            }
//
//            if(node.uid != uid){
//                return  false;
//            }
//
//            node.isLocked = false;
//            node.uid = Integer.MIN_VALUE;
//
//            Node curr = node.parent;
//            while(curr != null){
//                curr.lockedDescendants--;
//                curr = curr.parent;
//            }
//
//            return true;
//        }
//
//
//
//        private Node createNodeHelper(String value, Node parent){
//            Node node = new Node(value, parent);
//            this.valueNodeMap.put(value, node);
//            return node;
//        }
//
//
//        public void printTree(){
//            Queue<Node> queue = new ArrayDeque<>();
//            queue.add(this.root);
//
//            Node mark = new Node("", null);
//            queue.add(mark);
//            while (!queue.isEmpty()){
//                Node curr = queue.remove();
//
//                if(curr == mark){
//                    System.out.println();
//                    if(!queue.isEmpty()){
//                        queue.add(mark);
//                    }
//                }
//                System.out.println(curr.value);
//                for(Node node: curr.children){
//                    queue.add(node);
//                }
//            }
//        }
//
//    }
//
//}
//
//    public boolean lock(String value,int uid){
//        if(!this.valueNodeMap.containsKey(value)){
//            return false;
//        }
//        Node node=this.valueNodeMap.get(value);
//
//        // if node has locked descendants
//        if(node.isLocked == 1 || node.lockedDescendants>0){
//            return false;
//        }
//
//        // make lock status true
//        node.isLocked++;
//
//        // if node is already locked
//        if(node.isLocked>1){
//            node.isLocked--;
//            return false;
//        }
//
//        Node curr=node.parent;
//        ArrayList<Node> list=new ArrayList<>();
//        boolean mark=false;
//
//        // check and update ancestor
//        while(curr!=null){
//            // simply incrementing the lockedDescendants
//            curr.lockedDescendants++;
//            if(curr.isLocked==0){
//                list.add(curr);
//                curr=curr.parent;
//            }else{
//                curr.lockedDescendants--;
//                mark=true;
//                break;
//            }
//        }
//
//        // if lockedDescendants count got updated or mark is true, revert back
//        if(node.lockedDescendants>0||mark){
//            for(Node n:list){
//                n.lockedDescendants--;
//            }
//            node.isLocked--;
//            return false;
//        }
//
//        //update UID
//        node.uid=uid;
//        return true;
//    }


// Final answer lock and unlock both


// Tree Node
//static class Node{
//    int uid;
//    int isBusy;
//    String country;
//    Node parent;
//    ArrayList<Node> children;
//    int lockStatus;
//    int subtreeLockedDescendants;
//
//    public Node(String country, Node parent){
//        this.country = country;
//        this.parent = parent;
//        this.subtreeLockedDescendants = 0;
//        this.children = new ArrayList<>();
//        this.lockStatus = 0;
//        this.uid = Integer.MIN_VALUE;
//    }
//}
//
//
//    /*
//     * @value: name of country to be locked (String)
//     * return : was able to lock or not (boolean)
//     */
//    public boolean lock(String value){
//
//        Node node = this.valueNodeMap.get(value);
//
//        // if node is already locked
//        //if(node.lockStatus == 1){
//        //    return false;
//        //}
//
//
//
//        // if node has locked children in it's subtree
//        if(node.subtreeLockedDescendants > 0){
//            return false;
//        }
//
//        //lock might get rolled back
//        node.isBusy += 1;
//
//        // lock node as of now... will revert back if anything check fails
//        node.lockStatus += 1;
//
//
//        //another thread is already locking this node
//        if(node.lockStatus > 1){
//            node.lockStatus -= 1;
//            node.isBusy -= 1;
//            return false;
//        }
//
//        // check and update parent nodes
//        List<Node> backup = new ArrayList<>();
//        Node itr = node.parent;
//        boolean check = false;
//        while(itr != null){
//
//            // increment subtreeLockedDescendants... will revert back if node is locked
//            itr.subtreeLockedDescendants += 1;
//
//            // if node is unlocked
//            if(itr.lockStatus == 0){
//                backup.add(itr);
//                itr = itr.parent;
//            }
//
//            // if node is locked...break
//            else{
//                itr.subtreeLockedDescendants -= 1;
//                //make check flag true as we got a parent already locked
//                check = true;
//                break;
//            }
//        }
//
//        // recheck locked children count and check flag
//        if(node.subtreeLockedDescendants > 0 || check){
//            //revert back the changes
//            for(Node itr: backup){
//                itr.subtreeLockedDescendants -= 1;
//            }
//            node.lockStatus = 0;
//            node.isBusy -= 1;
//            return false;
//        }
//
//        // if everything goes fine return true
//        node.isBusy -= 1;
//        return true;
//    }
//
//    /*
//     * @value: name of country to be unlocked (String)
//     * return : was able to unlock or not (boolean)
//     */
//    public boolean unlock(String value){
//
//        Node node = this.valueNodeMap.get(value);
//
//        // if lock might get rolled back
//        if(node.isBusy != 0){
//            return false;
//        }
//
//        // unlock node as of now... will revert back if anything check fails
//        node.lockStatus -= 1;
//
//        //another thread is unlocking this node or it's already unlocked
//        if(node.lockStatus < 0){
//            node.lockStatus += 1;
//            return false;
//        }
//
//        //decrement count of subtreeLockedDescendants in parent nodes
//        Node itr = node.parent;
//
//        while(itr != null){
//            itr.subtreeLockedDescendants -= 1;
//            itr = itr.parent;
//        }
//
//        //as we have successully unlocked the node, return true
//        return true;
//    }

