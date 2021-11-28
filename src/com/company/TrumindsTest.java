package com.company;

import java.awt.desktop.AboutHandler;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class TrumindsTest {
//    public static void main(String[] args) throws IOException {
//        int [][] mat = { {0, 0, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}};
//        //System.out.println(solution(2, mat));
//
////        System.out.println(ans(new int[]{10, 25, 30, 35, 6, 59, 75, 32, 105}));
////        List<Integer> list = new ArrayList<>();
////        list.add(7);
////        list.add(5);
////        list.add(9);
////
////
////        List<Integer> list2 = new ArrayList<>();
////        list2.add(13);
////        list2.add(1);
////        list2.add(4);
//
//
////        System.out.println(numBST(list));
////        System.out.println(minFriends(3,2));
//
////        System.out.println(countBracketSequence("())"));
////        System.out.println(minSwaps(new int[]{2, 2, 1}, new int[]{2, 2, 3}));
////        TrumindsTest trumindsTest = new TrumindsTest();
////        System.out.println(trumindsTest.minSwaps(new int[]{2, 2, 1}, new int[]{2, 2, 3}));
////
////        Integer n1 = 200;
////        Integer n2 = 200;
////        Integer num1 = 200;
////        Integer num2 = 200;
////
////
////        if(n1 == n2){
////            System.out.println("n1==n2");
////        }else{
////            System.out.println("not equal");
////        }
//
//
////        int n = scanner.nextInt();
////        int[] arr = new int[n];
////        for(int i = 0; i < n; i++){
////            arr[i] = scanner.nextInt();
////        }
////
////        int count = 0;
////        for(int i = 0; i < n; i++){
////            if(arr[i] != i + 1) {
////                count++;
////            }
////        }
////        if(count <= 2){
////            System.out.println("YES");
////        }else{
////            System.out.println("NO");
////        }
////        int x = scanner.nextInt();
////        int n = scanner.nextInt();
////        int req = n/x;
////        if(req * x != n){
////            req++;
////        }
////        System.out.println(req);
//
////        int m = scanner.nextInt();
////        int n = scanner.nextInt();
////
////        int[] arr1 = new int[m];
////        int[] arr2 = new int[n];
////        for(int i = 0; i < m; i++){
////            arr1[i] = scanner.nextInt();
////        }
////
////        for(int i = 0; i < n; i++){
////            arr2[i] = scanner.nextInt();
////        }
////
////        long[][] table = new long[m+1][n+1];
////        int mod = (int)1e9 + 7;
////        for(int i = 0; i < table.length; i++){
////            for(int j = 0; j < table[i].length; j++){
////                if(i == 0 || j == 0){
////                    table[i][j] = 0;
////                }else{
////                    long prev = table[i][j - 1] % mod;
////                    long next = table[i - 1][j] % mod;
////                    long pn = table[i - 1][j - 1] % mod;
////                    if(arr1[i - 1] == arr2[j - 1]){
////
////                        long sum = 1 + prev + next ;
////                        sum = sum % mod;
////                        table[i][j] =  sum;
////                    }else{
////                        long sum = prev + next - pn;
////                        sum = sum % mod;
////                        table[i][j] = sum;
////                    }
////                }
////            }
////        }
////        long res = table[m][n] + 1;
////        res = res %mod;
////        System.out.println((int) res);
//        //color();
////        System.out.println(count(new int[]{3, 1, 3, 2}));
//        //nBoxes();
//
////        getXor(new int[]{1, 2, 3}, new int[]{1, 0}, new int[]{2, 2}, new int[]{2, 2}, new int[]{1, 2});
////        System.out.println(Arrays.toString(braces(new String[]{ "{[}]"})));
////        Solution(2, new int[]{245, 78});
//
//
////        Scanner scanner = new Scanner(System.in);
////        int valuesCount = scanner.nextInt();
////        String[] values = new String[valuesCount];
////
////        for(int i = 0; i < valuesCount; i++){
////            String valuesItem = scanner.nextLine();
////            values[i] = valuesItem;
////        }
////
////        String[] res = braces(values);
////        for(int i = 0; i < res.length; i++){
////            System.out.println(res[i]);
////        }
////        scanner.close();
////        Node head1 = new Node(6, null);
////        head1 = new Node(1, head1);
////        head1 = new Node(7, head1);
////
////        Node head2 = new Node(2, null);
////        head2 = new Node(9, head2);
////        head2 = new Node(5, head2);
////
////        Node ans = add_two_list(head1, head2);
////        while(ans != null){
////            System.out.println(ans.value);
////            ans = ans.next;
////        }
//
////        List<Integer> arr = new ArrayList<>();
////        arr.add(5);
////        arr.add(1);
////        arr.add(4);
////        arr.add(3);
////        arr.add(6);
////        arr.add(8);
////        arr.add(10);
////        arr.add(7);
////        arr.add(9);
////        shiftall(arr);
////        System.out.println(arr);
//
////        System.out.println(findMinAngle(9, 0));
////        System.out.println(findMinAngle(5, 30));
//
////        System.out.println(find_pivot_index(arr, arr.size()));
//
////        System.out.println(reframe("Baseball and Volleyball"));
////        System.out.println(getOneBits(161));
//        //System.out.println(Arrays.toString(calculateProfit(3, new int[]{10, 25, 4}, 2, new int[]{25, 30})));
////        System.out.println(Arrays.toString(calculateProfit(3, new int[]{10, 25, 4}, 2, new int[]{25, 30})));
//        //count1();
//        //isos();
//        //System.out.println(numberOfWays(3, 2, 2, new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 2}, new int[]{2, 2}));
////        System.out.println(solve(5, 3, new int[]{1, 2, 8, 4, 6}, new int[]{5, 15, 5, 2, 9}));
////        generatePasswords();
////        List<Integer> list2 = new ArrayList<>();
////        list2.add(6);
////        list2.add(3);
////        list2.add(5);
////        list2.add(8);
////        System.out.println(evenSubarray(list2, 1));
//
////        List<String> words = new ArrayList<>();
////        words.add("listen");
////        words.add("silent");
////        words.add("it");
////        words.add("is");
////
////        List<String> sentences = new ArrayList<>();
////        sentences.add("listen it is silent");
////        System.out.println(countSentences(words, sentences));
//
//        List<String> words = new ArrayList<>();
//        words.add("30 99 sign-in");
//        words.add("30 105 sign-out");
//        words.add("12 100 sign-in");
//        words.add("20 80 sign-in");
//        words.add("12 120 sign-out");
//        words.add("20 101 sign-out");
//        words.add("21 110 sign-in");
//
////        words.add("60 12 sign-in");
////        words.add("80 20 sign-out");
////        words.add("10 20 sign-in");
////        words.add("60 20 sign-out");
//
//
//        System.out.println(processLogs(words, 100));
//
//    }

    public static  void main(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.next();
        }
        for(String str: arr){
            boolean isPalindrome = checkPalindrome(str);
            if(isPalindrome){
                System.out.println(str);
            }else{
                String[][] partArr= partition(str);
                System.out.println(Arrays.toString(partArr));
            }
        }

    }

    public  static boolean checkPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static String[][] partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);

        return new String[][]{};
    }

    static void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }


    public static  boolean withinK (int K, int [][] A, int i, int j, ArrayList<Integer> houses) {
        for (int h = 0; h < houses.size(); h+= 2)
            if ((houses.get(h) == i) && (houses.get (h+1) == j)) return false;
            else if (Math.abs (i - houses.get(h)) + Math.abs (j - houses.get(h+1)) > K) return false;
        return true;

    }

    public static  int solution (int K, int [][] A) {
        ArrayList<Integer> houses = new ArrayList<>();
        int rows = A.length;
        int cols = A[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (A[i][j] == 1) {
                    houses.add (i); houses.add (j);
                }

        int counter = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (withinK (K, A, i, j, houses)) {
                    counter++;
                }

        return counter;
    }


    public static int ans(int[] arr){
        int prev = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){

            if(i == arr.length - 1) {
                continue;
            }else if(arr[i] > arr[i + 1]){
                sum += arr[i] - prev;
                prev = arr[i+ 1];
            }
        }

        if(prev < arr[arr.length - 1]){
            sum+= arr[arr.length - 1] -prev;
        }else{
            sum+= prev;
        }

        return  sum;
    }
    
    public static int countCompanies(int friend_nodes, List<Integer> friends_from, List<Integer> friends_to, List<Integer> friends_weight){
        return 0;
    }

    public static List<Integer> numBST(List<Integer> nodeValues){
        List<Integer> res = new ArrayList<>();
        int MOD = (int)1e9+7;
        for(Integer num: nodeValues){
            int val = findCatalan(num);
            res.add(val);
        }

        return res;
    }

    public static int findCatalan(int n)
    {
        // using BigInteger to calculate large factorials
        BigInteger b = new BigInteger("1");

        // calculating n!
        for (int i = 1; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }

        // calculating n! * n!
        b = b.multiply(b);

        BigInteger d = new BigInteger("1");

        // calculating (2n)!
        for (int i = 1; i <= 2 * n; i++) {
            d = d.multiply(BigInteger.valueOf(i));
        }

        // calculating (2n)! / (n! * n!)
        BigInteger ans = d.divide(b);

        // calculating (2n)! / ((n! * n!) * (n+1))
        ans = ans.divide(BigInteger.valueOf(n + 1));
        ans = ans.mod(BigInteger.valueOf((long)1e8+7));
        return ans.intValue();
    }

    public static long minFriends(int numNodes, int numEdges){
        int k, low = 1, high = numNodes + 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            k = solve1(numNodes, mid);
            if (k < numEdges)
                low = mid;
            else
                high = mid;
        }
        return high;
    }

    static int solve1(int n, int k) {
        int g1 = n % k;
        int g2 = k - g1;
        int sz1 = n / k + 1;
        int sz2 = n / k;
        int ret = g1 * sz1 * g2 * sz2 + g1 * (g1 - 1) * sz1 * sz1 / 2 + g2
                * (g2 - 1) * sz2 * sz2 / 2;
        return ret;
    }

    public static int comparatorValue(List<Integer> a, List<Integer> b, int d){
        int count = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Integer num: b){
            map.put(num, num);
        }

        for(Integer num: a){
            int low = num - d;
            int high = num + d;

            Integer val = map.ceilingKey(low);
            if(val == null || val > high){
                count++;
            }
        }
        return count;
    }

    public static int countBracketSequence(String s){

        int idx = 0;
        int j = 0;
        int len = s.length();


        boolean more = false;
        Stack<Integer> ds = new Stack<>();
        for(idx = 0; idx < len; idx++){
            char c = s.charAt(idx);
            if(c == '('){
                ds.push(idx);
            }else{
                if(ds.isEmpty()){
                    more = true;
                    break;
                }
                ds.pop();
            }
        }

        if(more){
            int res = idx;
            j = idx + 1;
            int val = 0;
            for(; j < len; j++){
                char cr = s.charAt(j);
                if(cr == '('){
                    val++;
                }else{
                    val--;
                    if(val < 0){
                        return 0;
                    }
                }
            }

            if(val != 0){
                return 0;
            }

            return res + 1;
        }else{
            if(ds.size() != 1){
                return 0;
            }
            return len - ds.pop();
        }
    }

    public static int minSwaps(int[] x, int[] y){
        System.out.println(x[0] + x[1] + x[2] + " ");
        return recursion(0, x, y);
    }


    public static int recursion(int idx, int[]x, int[] y){
        if(idx >= x.length){
            return 0;
        }

        if(x[idx] == y[idx]){
            return recursion(idx + 1, x, y);
        }else if(idx == x.length - 1){
            return -1;
        }else if(x[idx + 1] + 1 == y[idx] && x[idx] - 1 == y[idx + 1]) {
            int left = x[idx] - 1;
            int right = x[idx + 1] + 1;
            x[idx] = right;
            x[idx + 1] = left;
            int count = recursion(idx + 1, x, y);
            if(count == -1){
                return -1;
            }
            return  count+ 1;
        }else{
            return -1;
        }
    }

    public static void color(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());

        }


        for(int i = 0; i < m; i++){
            int src = scanner.nextInt() - 1;
            int dest = scanner.nextInt() - 1;

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        sum = 0;
        dfs(0, graph, map, n - 1);
        System.out.println(sum);


    }
    static int sum;
    public static void  dfs(int src,  ArrayList<ArrayList<Integer>> graph, Map<Integer, Integer> map, int n){

        if(src == n && map.size() == n ){
            sum++;
            return;
        }

        for(int i = 0; i < 3; i++){

            boolean isValid = true;
            for(int child : graph.get(src)){
                if(map.containsKey(child) && map.get(child) == i){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                map.put(src, i);
                for(int child : graph.get(src)){
                    if(!map.containsKey(child)){
                      dfs(child, graph, map, n);
                    }
                }

            }
            System.out.println(src + " --> " + i + " " +sum);
        }
        map.remove(src);

    }


    public static  void count(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);

        }

        int[] max = new int[]{-1, 0};
        int[] secondMax =  new int[]{-1, 0};
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > max[1]){
                secondMax[0] = max[0];
                secondMax[1] = max[1];
                max[1] = entry.getValue();
                max[0] = entry.getKey();
            }else if(entry.getValue() > secondMax[1]){
                secondMax[1] = entry.getValue();
                secondMax[0] = entry.getKey();
            }
        }

        int count = 0;
        int count2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(i %2 == 0){
                if(arr[i] != max[0]){
                    count++;
                }

                if(arr[i] != secondMax[0]){
                    count2++;
                }
            }else{
                if(arr[i] != secondMax[0]){
                    count++;
                }
                if(arr[i] != max[0]){
                    count2++;
                }
            }
        }

        System.out.println( Math.min(count, count2));

    }

    public static void nBoxes(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Integer> set = new HashSet<>();
        set.add(1);
        for(int i = 0; i < m; i++){
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            if(set.contains(src)){
                set.add(dest);
            }
        }

        System.out.println(set.size() - 1);

    }


    public static void getXor(int[] arr, int[] l, int[] r, int[] x, int[] freq) throws IOException {
        BufferedWriter printer = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < r.length; i++){
            if(freq[i] % 2 == 1) {
                for (int j = l[i]; j <= r[i]; j++) {
                    arr[j] = arr[j] ^ x[i];
                }
            }
        }

        for(int val: arr){
            printer.write(val+"\n");

        }
        printer.flush();
    }

   public static String[] braces(String[] values){
        String[] result = new String[values.length];
        for(int i = 0; i < values.length; i++){
            String s = values[i];
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < s.length(); j++){
                System.out.println(stack);
               char c = s.charAt(j);
               if(c == '(' || c == '{' || c =='['){
                   stack.push(c);
                   continue;
               }
               if(stack.isEmpty()){
                   result[i] = "NO";
                   break;
               }
               char top = stack.peek();
               if(c == ')' && top == '('){
                   stack.pop();
               }else if(c == '}' && top == '{'){
                   stack.pop();
               }else if(c == ']' && top == '['){
                   stack.pop();
               }else{
                   result[i] = "NO";
                   break;
               }
            }
            if(stack.isEmpty()){
                result[i] = "YES";
            }else{
                result[i] = "NO";
            }
        }
        return result;
    }


    public static  void Solution(int n, int[] arr){
        int []dp = new int [1024];

        for (int i = 0; i < (1 << 10); i++)
        {
            dp[i] = -1;
        }
        int ans = 0;
        for (int i = 0; i < (1 << 10); i++) {
            ans = Math.max(ans, traverse(i, arr, n, dp));
        }
        System.out.println(ans);
    }


    static int traverse(int u, int[] array, int n, int[] dp)
    {
        if (u == 0)
            return 0;

        if (dp[u] != -1)

            return dp[u];

        for (int i = 0; i < n; i++)

        {
            int mask = get_binary(array[i]);
            if ((mask | u) == u) {
                dp[u] = Math.max(Math.max(0, dp[u ^ mask]) + array[i], dp[u]);
            }
        }
        return dp[u];
    }


    static int get_binary(int u)
    {
        int ans = 0;
        while (u > 0)
        {
            int rem = u % 10;
            ans |= (1 << rem);
            u /= 10;
        }
        return ans;
    }

    static class Node{
        int value;
        Node next;
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private static Node add_two_list(Node head1, Node head2){
        Node head = new Node(-1, null);
        Node curr = head;
        int carry = 0;

        while(head1 != null && head2 != null){
            int val = head1.value + head2.value + carry;
            carry = val / 10;
            val = val % 10;
            Node node = new Node(val, null);
            curr.next = node;
            curr = curr.next;

            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1 != null){
            int val = head1.value + carry;
            carry = val / 10;
            val = val % 10;
            Node node = new Node(val, null);
            curr.next = node;
            curr = curr.next;
            head1 = head1.next;

        }

        while(head2 != null){
            int val = head2.value + carry;
            carry = val / 10;
            val = val % 10;
            Node node = new Node(val, null);
            curr.next = node;
            curr = curr.next;
            head2 = head2.next;

        }

        if(carry > 0){
            Node node = new Node(1, curr);
            curr.next = node;
        }

        return head.next;
    }

    private  static  void shiftall(List<Integer> arr){
        int left = 0;

        for(int right  = 1; right < arr.size(); right++){
            int temp = arr.get(right);

            // if present value is positive we can skip
            if(temp > 0){
                continue;
            }

            // if present value is negative shift all the elements of arr one unit right
            left = right - 1;

            while (left >= 0 && arr.get(left) > 0){
                arr.set(left + 1, arr.get(left));
                left--;
            }

            //place current negative element at one unit right of left pointer
            arr.set(left +1, temp);
        }
    }

    public static float findMinAngle(int h, int m){
        float perMinDegree = 6;
        float perHourDegree = 30;

        float degreeMin = (perMinDegree * m) % 360;
        float minInHour = m * 1.0f / 60;
        float degreeHour = ((h + minInHour) * perHourDegree) % 360;

        float angle1 = Math.abs(degreeHour - degreeMin);
        float angle2 = 360.0f - angle1;

        return Math.min(angle1, angle2);


    }

    private  static  int find_pivot_index(List<Integer> arr, int arrLength){

        int[] start = new int[arrLength];
        start[0] = Integer.MIN_VALUE;

        // Fill start[]1..n-1]
        for (int i = 1; i < arrLength; i++)
            start[i] = Math.max(start[i - 1], arr.get(i - 1));

        // Initialize minimum from right
        int end = Integer.MAX_VALUE;

        // Traverse array from right
        for (int i = arrLength - 1; i >= 0; i--)
        {
            // Check if we found a required element
            if (start[i] < arr.get(i) && end > arr.get(i))
                return i;

            // Update right minimum
            end = Math.min(end, arr.get(i));
        }

        // If there was no element matching criteria
        return -1;
    }
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode pruneTree(TreeNode root, int k){
       if(root == null){
           return null;
       }
       root.left = pruneTree(root.left, k - root.value);
       root.right = pruneTree(root.right, k - root.value);

       if(root.left == null && root.right == null && k > root.value){
           root = null;
       }
       return root;
    }

    private int inorderRecursion(TreeNode root, int sum, int k){
        if(root == null){
            return 0;
        }
        sum += root.value;
        int left = inorderRecursion(root.left, sum, k);
        int right = inorderRecursion(root.right, sum, k);

        if(sum + left < k){
            root.left = null;
        }

        if(sum + right < k){
            root.right = null;
        }

        return root.value + Math.max(left, right);
    }
    
    public static String reframe(String sentence){
        String[] words = sentence.split("\\s+");

        Arrays.sort(words, new Comparator<String>() {

            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();

            if(i == 0){
                word = word.substring(0,1).toUpperCase() + word.substring(1);
            }
            sb.append(word);
            if(i < words.length - 1){
                sb.append(" ");
            }else{
                sb.append(".");
            }
        }

        return sb.toString();
    }


    public  static List<Integer> getOneBits(int n){
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(n > 0){
            int rem = n % 2;
            n = n/2;
            list.add(0, rem);
            if(rem == 1){
                count++;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(count);
        for(int i = 0; i< list.size(); i++){
            if(list.get(i) == 1){
                result.add(i+1);
            }
        }

        return result;

    }

    public static int[] calculateProfit(int n, int[] profit, int q, int[] query){
        int[] arr = new int[query.length];
        Arrays.sort(profit);
        HashMap<Integer, Integer> map = new HashMap<>();
        backtracking(0, profit, new HashSet<Integer>(), map);
        ArrayList<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for(int i = 1; i< list.size(); i++){
            int[] val = list.get(i);
            val[1] = val[1] + list.get(i - 1)[1];
        }
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for(int[] val: list){
            tMap.put(val[0], val[1]);
        }

        for(int i = 0; i < query.length; i++){
            Integer greater = tMap.ceilingKey(query[i]);
            if(greater!= null){
                arr[i] = tMap.get(greater);
            }
        }
        return arr;
    }



    public static void backtracking(int sum, int[] profit,  HashSet<Integer> visited, HashMap<Integer, Integer> map){

        if(visited.size() == profit.length){
            if(!map.containsKey(sum)){
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum) + 1);

            return;
        }

        for(int i = 0; i < profit.length; i++){
            if(visited.contains(i)){
                continue;
            }

            if(i > 0 && profit[i - 1] == profit[i] && visited.contains(i-1)){
                continue;
            }

            int currentProfit = profit[i] >> visited.size();
            visited.add(i);
            backtracking(sum + currentProfit, profit,  visited, map);
            visited.remove(i);
        }
    }

    public static void count1(){
        Set<BigInteger> set = new HashSet<>();
        Set<BigInteger> set1 = new HashSet<>();
        for(int i = 1; i <= 40; i++){
            for(int j = 1; j <= 40; j++){
               BigInteger val = BigInteger.valueOf(2).pow(i).add(BigInteger.valueOf(4).pow(j));
                set.add(val);
                if(val.mod(BigInteger.valueOf(10)).equals(BigInteger.ZERO)){
                    set1.add(val);
                }
            }
        }

        System.out.println(set.size());
        System.out.println(set1.size());
    }

    public static void isos(){
        int total  = 41412;
        int sum = 0;
        int val = 407;

        while(sum <= total){
            if(sum == total){
                System.out.println("true");
            }
            sum += val;
            val = val -2;

        }
    }

    public static int numberOfWays(int N, int MAXH, int M, int[] L, int[] R, int[] A, int[] B){

        long[][] arr = new long[N][2];
        long MOD = (long) 1e9+7;
        long count = 1;
        for(long[] range: arr){
            range[0] = 1;
            range[1] = MAXH;
        }

        for(int i = 0; i < M; i++){
            int start = L[i] - 1;
            int end = R[i] - 1;

            int from = A[i];
            int to = B[i];

            for(int j = start; j <= end; j++){
                long currFrom = arr[j][0];
                long currTo = arr[j][1];


                if(currFrom > to || from > currTo){
                    System.out.println(currFrom + " " + currTo + " " + from + " " + to) ;
                    return 0;
                }

                arr[j][0] = Math.max(currFrom, from);
                arr[j][1] = Math.min(currTo, to);
            }
        }

        for(int i = 0; i < arr.length; i++){
            long val = arr[i][1] - arr[i][0] + 1;
            val = val % MOD;
            count = count * val;
            count = count % MOD;
        }

        count = count % MOD;
        return (int) count;
    }


    public static long solve(int N , int K, int[] weight, int[] taste){

        long max = Integer.MIN_VALUE;
        int[] st = constructST(weight, N);
        for(int i = 0; i < taste.length; i++){
            int sum = taste[i];
            int j = i+1;
            while(j < weight.length){
                int idx = maxInRange(j, Math.min(j + K - 1, weight.length  - 1), weight, st);
                System.out.println(j + " " + (j+K) + " " + idx);
                if(idx == -1){
                    break;
                }
                sum += taste[idx];
                j = idx+ 1;
            }

            max = Math.max(sum, max);
        }

        return max;

    }

    public static int maxInRange(int start, int end, int[] weight, int[] st){
        if(start >= weight.length){
            return -1;
        }
//        int max = start;
//        for(int i = start + 1; i <= end; i++){
//            if(weight[i] > weight[max]){
//                max = i;
//            }
//        }
//
//        return  max;
        return MaxUtil(st, 0, weight.length - 1, start,end, 0);
    }

    static int MaxUtil(int[] st, int ss,
                       int se, int l,
                       int r, int node)
    {

        if (l <= ss && r >= se)
            return st[node];


        if (se < l || ss > r)
            return -1;


        int mid = ss + (se - ss) / 2;

        return Math.max(
                MaxUtil(st, ss, mid, l, r,
                        2 * node + 1),
                MaxUtil(st, mid + 1, se, l, r,
                        2 * node + 2));
    }

    static int constructSTUtil(int arr[],
                               int ss, int se,
                               int[] st, int si)
    {

        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }



        int mid = ss + (se - ss) / 2;

        st[si] = Math.max(
                constructSTUtil(arr, ss, mid,
                        st, si * 2 + 1),
                constructSTUtil(arr, mid + 1,
                        se, st,
                        si * 2 + 2));

        return st[si];
    }

    static int[] constructST(int arr[], int n)
    {


        int x = (int)Math.ceil(Math.log(n) / Math.log(2));


        int max_size = 2 * (int)Math.pow(2, x) - 1;


        int[] st = new int[max_size];


        constructSTUtil(arr, 0, n - 1, st, 0);


        return st;
    }

    public static void generatePasswords(){
        int n = 6;
        char[] chars = new char[36];
        for(int i = 0; i < 26; i++){
            chars[i] = (char)('a' + i);
        }

        for(int i = 0; i < 10; i++){
            chars[i+ 26] = (char)('0' + i);
        }


        StringBuilder sb = new StringBuilder();

        backtracking("", chars, sb);
        System.out.println(count);
    }
    static  long count = 0;
    public static void backtracking(String word, char[] chars, StringBuilder sb){
        if(word.length() == 6){
            //sb.append(word).append("\n");
            count++;
            return;
        }

        for(int i = 0; i < chars.length; i++){
            backtracking(word + chars[i], chars, sb);
        }
    }
    
    
    
    
    public static int evenSubarray(List<Integer> numbers, int k){
        Set<List<Integer>> unique= new LinkedHashSet<>();

        int[] arr = new int[numbers.size()];
        int numOdd = 0;
        for(int i=0;i<arr.length;i++){
            if(numbers.get(i)%2!=0){
                numOdd++;
            }
            arr[i] = numOdd;
        }
        for(int i=0;i<numbers.size();i++){
            List<Integer> subList = new ArrayList<>();
            int subtract = i==0?0:arr[i-1];
            int j=i;
            while(j<numbers.size() && arr[j]-subtract<=k){
                subList.add(numbers.get(j));
                unique.add(subList);
                subList = new ArrayList<>(subList);
                j++;
            }
            unique.add(subList);
        }

        return unique.size();

    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences){
        HashMap<Integer, Integer> map= new HashMap<>();
        for(String str: wordSet){
            int code = convert(str);
            if(!map.containsKey(code)){
                map.put(code, 0);
            }
            map.put(code, map.get(code) + 1);
        }
        List<Long> res = new ArrayList<>();
        for(String sentence: sentences){
            long count = 1;
            String[] arr = sentence.split("\\s+");
            for(String str: arr){
                int code = convert(str);
                if(map.containsKey(code)){
                    count = count * map.get(code);
                }
            }
           res.add(count);
        }

        return res;
    }

    public static int convert(String str){
        int[] arr = new int[26];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            arr[c - 'a']++;
        }
        return Arrays.hashCode(arr);
    }

    public static List<String> processLogs(List<String> logs, int maxSpan){
        List<String> ids = new ArrayList<>();
        HashMap<String, int[]> map = new HashMap<>();
        for(String log: logs){
            String[] arr = log.split("\\s+");
            String id = arr[0];
            int time = Integer.parseInt(arr[1]);
            boolean isSignIn = arr[2].equals("sign-in");
            if(!map.containsKey(id)){
                map.put(id, new int[]{-1, -1});
            }
            if(isSignIn){
                map.get(id)[0] = time;
            }else{
                map.get(id)[1] = time;
            }
        }

        for(Map.Entry<String, int[]> entry: map.entrySet()) {
            if( entry.getValue()[1] == -1 || entry.getValue()[0] == -1){
                continue;
            }
            int diff = entry.getValue()[1] - entry.getValue()[0];
            System.out.println(entry.getKey() + " " + diff);
            if (diff <= maxSpan) {
                ids.add(entry.getKey());
            }
        }

        Collections.sort(ids, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
        return  ids;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        String lowerStr = convertToLowercase(input);
//        System.out.println(lowerStr);
//    }
//
    public static String convertToLowercase(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                c = (char)(c + 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int start = scanner.nextInt();
//        int end = scanner.nextInt();
//        printPrimeInInterval(start, end);
//    }
//    public static void printPrimeInInterval(int start, int end){
//        if (start == 1) {
//            start++;
//            if (end >= 2) {
//                System.out.print(start + " ");
//                start++;
//            }
//        }
//        if (start == 2)
//            System.out.print(start + " ");
//
//        if (start % 2 == 0)
//            start++;
//
//        for (int i = start; i <= end; i = i + 2) {
//            boolean isPrime = true;
//            for (int j = 2; j * j <= i; ++j) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime)
//                System.out.print(i + " ");
//        }
//    }
//}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int decimalValue = convertBinaryToDecimal(input);
        System.out.println(decimalValue);
    }

    public static int convertBinaryToDecimal(String str){
        int pow = 0;
        int res = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            int factor = (int) Math.pow(2, pow);
            pow++;
            char c = str.charAt(i);
            if(c == '1'){
                res += factor;
            }
        }
        return res;
    }
}



/*
 BEGIN BUBBLE SORT(list)

 INTEGER N = list.length
 for i in range[0, N-1)
   for j in [0, N- i - 1)
       if list[j] > list[j+1]
           swap(list[j], list[j+1])
       END if
   END for
 END For

 END BUBBLE SORT

 Best case time complexity = O(N*N)
 Worst case time complexity = O(N*N)

 BEGIN MODIFIED BUBBLE SORT(list)

 INTEGER N = list.length
 BOOLEAN FLAG = false

 for i in range[0, N-1)
   FLAG = false
   for j in [0, N- i - 1)
       if list[j] > list[j+1]
           swap(list[j], list[j+1])
           FLAG = true
       END if
   END for
   if FLAG == false
       break
   END if
 END For

 END MODIFIED BUBBLE SORT

 Best case time complexity = O(N)
 Worst case time complexity = O(N*N)
* */



//    static int countSubstring(String S, int N)
//    {
//        //we treat uppercase as 1 and lowercase as -1
//       //In hashmap we are inserting sum, frequency of prefix strings having that sum
//        HashMap<Integer, Integer> prevSum = new HashMap<>();
//
//        // res is our answer
//        int res = 0;
//
//            // current sum is sum of lowercase and uppercase characters...1 for uppercase and -1 for lowercase
//        int currentSum = 0;
//
//        // traversing string and storing the result in map
//        for(int i = 0; i < N; i++)
//        {
//
//            //if current char is uppercase add one to currentsum else subtract one
//            if (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')
//            {
//                currentSum++;
//            }
//            else
//                currentSum--;
//
//            // if current sum is 0 that means equal no of uppercase and lowercase in that case add 1 to our answer that is res
//            if (currentSum == 0)
//                res++;
//
//            // if map contains this sum that means increment res
//            if (prevSum.containsKey(currentSum))
//            {
//                res += prevSum.get(currentSum);
//            }
//
//            // insert current sum and frequency in map
//            prevSum.put(currentSum, prevSum.getOrDefault(currentSum, 0) + 1);
//        }
//        return res;
//    }