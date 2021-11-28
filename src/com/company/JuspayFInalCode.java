///* IMPORTANT: Multiple classes and nested static classes are supported */
//
///*
// * uncomment this if you want to read input.
////imports for BufferedReader
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
////import for Scanner and other utility classes
//import java.util.*;
//*/
//
//// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.io.IOException;
//
//class TestClass {
//
//
//    static class Node{
//        int uid;
//        String country;
//        Node parent;
//        ArrayList<Node> children;
//        int lockStatus;
//        HashSet<Node> subtreeLockedDescendants;
//
//        public Node(String country, Node parent){
//            this.country = country;
//            this.parent = parent;
//            this.subtreeLockedDescendants = new HashSet<>();
//            this.children = new ArrayList<>();
//            this.lockStatus = 0;
//            this.uid = Integer.MIN_VALUE;
//        }
//    }
//
//
//    static class Tree{
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
//
//            Node r = nodeConstructor(list.get(0), null);
//
//            Queue<Node> queue = new ArrayDeque<>();
//            queue.add(r);
//            int count = 1;
//
//            while(!queue.isEmpty()){
//                Node curr = queue.remove();
//                for(int i = 0; i < n && count < list.size(); i++){
//                    Node node = nodeConstructor(list.get(count), curr);
//                    curr.children.add(node);
//                    queue.add(node);
//                    count++;
//                }
//            }
//
//            return r;
//        }
//
//        private Node nodeConstructor(String value, Node parent){
//            Node node = new Node(value, parent);
//            this.valueNodeMap.put(value, node);
//            return node;
//        }
//
//        private boolean resolveQuery(int queryCode, String value, int uid){
//            switch(queryCode){
//                case 1:
//                    return lock(value, uid);
//                case 2:
//                    return unlock(value, uid);
//                case 3:
//                    return upgrade(value, uid);
//                default:
//                    return false;
//            }
//
//        }
//
//        private boolean isParentUnLocked(Node node){
//            Node curr = node.parent;
//            while(curr != null){
//                if(curr.lockStatus == 1){
//                    return false;
//                }
//                curr = curr.parent;
//            }
//
//            return true;
//        }
//
//        private void incrementCountInparent(Node node){
//            Node curr = node.parent;
//            while(curr != null){
//                curr.subtreeLockedDescendants.add(node);
//                curr = curr.parent;
//            }
//        }
//
//        public boolean lock(String value, int uid){
//
//            Node node = this.valueNodeMap.get(value);
//
//            if(node.lockStatus == 1){
//                return false;
//            }
//
//            if(node.subtreeLockedDescendants.size() > 0){
//                return false;
//            }
//
//            if(!isParentUnLocked(node)){
//                return false;
//            }
//
//            node.lockStatus = 1;
//            node.uid = uid;
//            incrementCountInparent(node);
//
//            return true;
//        }
//
//
//        private void decrementCountInParent(Node node){
//            Node curr = node.parent;
//
//            while(curr != null){
//                curr.subtreeLockedDescendants.remove(node);
//                curr = curr.parent;
//            }
//        }
//
//        public boolean unlock(String value, int uid){
//
//            Node node = this.valueNodeMap.get(value);
//
//            if(node.lockStatus != 1){
//                return false;
//            }
//
//            if(node.uid != uid){
//                return false;
//            }
//
//            node.lockStatus = 0;
//            node.uid = Integer.MIN_VALUE;
//            decrementCountInParent(node);
//
//            return true;
//        }
//
//        private boolean checkSubtreeLockUID(Node node, int uid){
//            for(Node curr: node.subtreeLockedDescendants){
//                if(curr.uid != uid){
//                    return false;
//                }
//            }
//
//            return true;
//        }
//
//        private void unlockSubtree(Node node){
//            ArrayList<Node> nodes = new ArrayList<>(node.subtreeLockedDescendants);
//            for(Node curr: nodes){
//                unlock(curr.country, curr.uid);
//            }
//        }
//
//        public boolean upgrade(String value, int uid){
//
//            Node node = this.valueNodeMap.get(value);
//
//            if(node.lockStatus == 1){
//                return false;
//            }
//
//            if(node.subtreeLockedDescendants.size() == 0){
//                return false;
//            }
//
//            if(!checkSubtreeLockUID(node, uid)){
//                return false;
//            }
//
//            unlockSubtree(node);
//            lock(node.country, uid);
//
//            return true;
//        }
//    }
//
//
//    public static void main(String args[] ) throws Exception {
//        /* Sample code to perform I/O:
//         * Use either of these methods for input
//
//        //BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String name = br.readLine();                // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
//
//        //Scanner
//        Scanner s = new Scanner(System.in);
//        String name = s.nextLine();                 // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
//
//        */
//
//        // Write your code here
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> countries = new ArrayList<>();
//        int size = getValue(bufferedReader);
//        int numChildren = getValue(bufferedReader);
//        int numQueries = getValue(bufferedReader);
//
//        for(int i = 0; i < size; i++){
//            countries.add(getCountry(bufferedReader));
//        }
//
//        Tree tree = new Tree(countries, numChildren);
//        StringBuilder result = new StringBuilder();
//        for(int i = 0; i < numQueries; i++){
//            result.append(getResult(tree, bufferedReader)).append("\n");
//        }
//        System.out.println(result.toString());
//
//    }
//
//    public static int getValue(BufferedReader bufferedReader) throws IOException{
//        StringTokenizer tok = new StringTokenizer(bufferedReader.readLine());
//        return Integer.parseInt(tok.nextToken());
//    }
//
//    public static String getCountry(BufferedReader bufferedReader) throws IOException{
//        StringTokenizer tok = new StringTokenizer(bufferedReader.readLine());
//        String country = tok.nextToken();
//        return country;
//    }
//
//    public static boolean getResult(Tree tree, BufferedReader bufferedReader) throws IOException{
//        StringTokenizer tok = new StringTokenizer(bufferedReader.readLine());
//        int queryCode = Integer.parseInt(tok.nextToken());
//        String value = tok.nextToken();
//        int uid = Integer.parseInt(tok.nextToken());
//
//        return tree.resolveQuery(queryCode, value, uid);
//    }
//
//
//}
//
//    PART B BELOW
//        ------------
//
//// Tree Node
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
//        //as we have successfully unlocked the node, return true
//        return true;
//    }
//
