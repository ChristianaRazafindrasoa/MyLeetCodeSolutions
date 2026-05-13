package com.leetcode;

import java.util.*;

class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0; i < num.length(); i++) {
            char number = num.charAt(i);
            char opposite = num.charAt(num.length() - 1 - i);
            if ((number == '6' && opposite == '9') ||
                (number == '9' && opposite == '6') ||
                (number == '8' && opposite == '8') ||
                (number == '1' && opposite == '1') ||
                (number == '0' && opposite == '0')) {
                continue;
            }
            return false;
        }
        return true;
    }
}

// class Solution {
//     public boolean isReflected(int[][] points) {
//         Map<Integer, Set<Integer>> xToYsMap = buildMap(points);
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;
//         for (Map.Entry<Integer, Set<Integer>> entry : xToYsMap.entrySet()) {
//             min = Math.min(min, entry.getKey());
//             max = Math.max(max, entry.getKey());
//         }

//         double yLine = min + (double)(max - min) / 2;
//         Set<Integer> leftXCoords = getLeftXCoords(xToYsMap, yLine);
//         for (int left : leftXCoords) {
//             int right = left + (int)((yLine - left) * 2);
//             if (!xToYsMap.containsKey(right) || 
//                 !areSame(xToYsMap.get(left), xToYsMap.get(right))) {
//                 return false;
//             }
//             xToYsMap.remove(left);
//             if (left != right) {
//                 xToYsMap.remove(right);
//             }
//         }
//         return xToYsMap.size() == 0;
//     }

//     private Map<Integer, Set<Integer>> buildMap(int[][] points) {
//         Map<Integer, Set<Integer>> xToYsMap = new HashMap<>();
//         for (int[] point : points) {
//             if (!xToYsMap.containsKey(point[0])) {
//                 xToYsMap.put(point[0], new HashSet<>());
//             }
//             xToYsMap.get(point[0]).add(point[1]);
//         }
//         return xToYsMap;
//     }

//     private Set<Integer> getLeftXCoords(Map<Integer, Set<Integer>> xToYsMap, double yLine) {
//         Set<Integer> leftXCoords = new HashSet<>();
//         for (int key : xToYsMap.keySet()) {
//             if (key <= yLine) {
//                 leftXCoords.add(key);
//             }
//         }
//         return leftXCoords;
//     }

//     private boolean areSame(Set<Integer> left, Set<Integer> right) {
//         if (left.size() != right.size()) {
//             return false;
//         }
//         for (int yCoord : left) {
//             if (!right.contains(yCoord)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().isReflected(new int[][]{{0,0},{1,0}}));
//         System.out.println(new Solution().isReflected(new int[][]{{-1,1},{1,1},{1,1}}));
//         System.out.println(new Solution().isReflected(new int[][]{{1,1},{9,1},{8,2}}));
//     }
// }

// class Solution {
//     public int minimumSemesters(int n, int[][] relations) {
//         int semesters = 0;
//         int[] inDegrees = new int[n + 1];
//         List<List<Integer>> adjList = new ArrayList<>(n + 1);
//         buildAdjListInDegrees(n, relations, inDegrees, adjList);

//         Queue<Integer> queue = new ArrayDeque<>();
//         Set<Integer> visited = new HashSet<>();
//         for (int i = 1; i <= n; i++) {
//             if (inDegrees[i] == 0) {
//                 queue.add(i);
//             }
//         }

//         while (!queue.isEmpty()) {
//             semesters++;
//             int size = queue.size();
//             while (size > 0) {
//                 int current = queue.poll();
//                 if (!visited.add(current)) {
//                     return -1;
//                 }
//                 for (int neighbor : adjList.get(current)) {
//                     inDegrees[neighbor]--;
//                     if (inDegrees[neighbor] == 0) {
//                         queue.add(neighbor);
//                     }
//                 }
//                 size--;
//             }
//         }

//         if (visited.size() < n) {
//             return -1;
//         }
//         return semesters;
//     }

//     private void buildAdjListInDegrees(
//             int n, int[][] relations, int[] inDegrees, List<List<Integer>> adjList) {
//         for (int i = 0; i <= n; i++) {
//             adjList.add(new ArrayList<>());
//         }
//         for (int[] relation : relations) {
//             adjList.get(relation[0]).add(relation[1]);
//             inDegrees[relation[1]]++;
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minimumSemesters(3, new int[][]{{1,3},{2,3}}));
//         System.out.println(new Solution().minimumSemesters(3, new int[][]{{1,2},{2,3},{3,1}}));
//     }
// }

// class Solution {
//     public Node cloneTree(Node root) {
//         if (root == null) {
//             return root;
//         }
//         Map<Node, Node> oldToNew = new HashMap<>();
//         buildOldToNewNodes(root, oldToNew);
//         assignNewNodes(root, oldToNew);
//         return oldToNew.get(root);
//     }

//     private void buildOldToNewNodes(Node current, Map<Node, Node> oldToNew) {
//         if (current == null) {
//             return;
//         }
//         Node currentCopy = new Node(current.val);
//         oldToNew.put(current, currentCopy);
//         for (Node child : current.children) {
//             buildOldToNewNodes(child, oldToNew);
//         }
//     }

//     private void assignNewNodes(Node current, Map<Node, Node> oldToNew) {
//         if (current == null) {
//             return;
//         }
//         Node currentCopy = oldToNew.get(current);
//         for (Node child : current.children) {
//             currentCopy.children.add(oldToNew.get(child));
//             assignNewNodes(child, oldToNew);
//         }
//     }
// }

// class Solution {
//     public int totalReplacements(int[] ranks) {
//         int min = ranks[0];
//         int replacements = 0;
//         for (int rank : ranks) {
//             if (min > rank) {
//                 min = rank;
//                 replacements++;
//             }
//         }
//         return replacements;
//     }
// }

// class Solution {
//     public void wiggleSort(int[] nums) {
//         Arrays.sort(nums);
//         int[] result = new int[nums.length];
//         int index = 0;
//         for (int i = 0; i < nums.length; i += 2) {
//             result[i] = nums[index];
//             if (index < nums.length / 2) {
//                 result[i + 1] = nums[nums.length - 1 - index];
//             }
//             index++;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = result[i];
//         } 
//     }

//     public static void main(String[] args) {
//         int[] nums = new int[]{3,5,2,1,6,4,6};
//         new Solution().wiggleSort(nums);
//         System.out.println(Arrays.toString(nums));
//     }
// }

// class Solution {
//     public int numberOfSpecialSubstrings(String s) {
//         int[] asciiValues = new int[128];
//         int left = 0;
//         int right = 1;
//         asciiValues[s.charAt(left)]++;
//         int count = s.length();
        
//         while (right < s.length()) {
//             char cRight = s.charAt(right);
//             if (asciiValues[cRight] == 0) {
//                 if (right != left) {
//                     count += (right - left);
//                 }
//                 asciiValues[cRight]++;
//                 right++;
//                 continue;
//             }
//             while (asciiValues[cRight] > 0) {
//                 char cLeft = s.charAt(left);
//                 asciiValues[cLeft]--;
//                 left++;
//             }
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().numberOfSpecialSubstrings("abab")); // 7
//         System.out.println(new Solution().numberOfSpecialSubstrings("ooo")); // 3
//         System.out.println(new Solution().numberOfSpecialSubstrings("abcd")); // 10
//     }
// }

// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         int left = 0;
//         int right = 0;
//         int maxScore = 0;
//         int score = 0;
//         while (right < nums.length) {
//             if (set.add(nums[right])) {
//                 score += nums[right++];
//                 maxScore = Math.max(maxScore, score);
//                 continue;
//             }
//             while (set.contains(nums[right])) {
//                 score -= nums[left];
//                 set.remove(nums[left++]);   
//             }
//         }
//         return maxScore;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));;
//     }
// }

// class Solution {
//     public boolean canPermutePalindrome(String s) {
//         Map<Character, Integer> charToFreq = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             if (!charToFreq.containsKey(c)) {
//                 charToFreq.put(c, 0);
//             }
//             charToFreq.put(c, charToFreq.get(c) + 1);
//         }

//         int oddFreqs = 0;
//         for (char c : charToFreq.keySet()) {
//             if (charToFreq.get(c) % 2 == 1) {
//                 oddFreqs++;
//             }
//             if (oddFreqs > 1) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().canPermutePalindrome("eedcd"));
//     }
// }

// class Solution {
//     public int countComponents(int n, int[][] edges) {
//         int components = 0;
//         Map<Integer, List<Integer>> adjMap = buildAdjMap(n, edges);
//         Set<Integer> visited = new HashSet<>();
//         for (int i = 0; i < n; i++) {
//             if (!visited.contains(i)) {
//                 dfs(i, adjMap, visited);
//                 components++;
//             }
//         }
//         return components;
//     }

//     private void dfs(int current, Map<Integer, List<Integer>> adjMap, Set<Integer> visited) {
//         if (!visited.add(current)) {
//             return;
//         }
//         if (!adjMap.containsKey(current)) {
//             return;
//         }
//         for (int neighbor : adjMap.get(current)) {
//             dfs(neighbor, adjMap, visited);
//         }
//     }

//     private Map<Integer, List<Integer>> buildAdjMap(int n, int[][] edges) {
//         Map<Integer, List<Integer>> adjMap = new HashMap<>();
//         for (int[] edge : edges) {
//             if (!adjMap.containsKey(edge[0])) {
//                 adjMap.put(edge[0], new ArrayList<>());
//             }
//             adjMap.get(edge[0]).add(edge[1]);
//             if (!adjMap.containsKey(edge[1])) {
//                 adjMap.put(edge[1], new ArrayList<>());
//             }
//             adjMap.get(edge[1]).add(edge[0]);
//         }
//         return adjMap;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().countComponents(5, new int[][]{{0,1},{1,2},{3,4}}));
//     }
// }

// class Solution {
//     public int lengthOfLongestSubstringKDistinct(String s, int k) {
//         int[] asciiValues = new int[128];
//         int left = 0;
//         int right = 0;
//         int distinct = 0;
//         int maxLength = 0;

//         while (right < s.length()) {
//             char cRight = s.charAt(right);
//             if (asciiValues[cRight] == 0) {
//                 distinct++;
//             }
//             asciiValues[cRight]++;
//             right++;

//             while (distinct > k) {
//                 char cLeft = s.charAt(left);
//                 asciiValues[cLeft]--;
//                 if (asciiValues[cLeft] == 0) {
//                     distinct--;
//                 }
//                 left++;
//             }

//             maxLength = Math.max(maxLength, right - left);
//         }
//         return maxLength;
//     }
// }

// class Solution {
//     public int lengthOfLongestSubstringTwoDistinct(String s) {
//         int[] map = new int[128];
//         int left = 0;
//         int right = 0;
//         int distinct = 0;
//         int maxLength = 0;
//         while (right < s.length()) {
//             char cRight = s.charAt(right);
//             if (map[cRight] == 0) {
//                 distinct++;
//             }
//             map[cRight]++;
//             right++;

//             while (distinct > 2) {
//                 char cLeft = s.charAt(left);
//                 map[cLeft]--;
//                 if (map[cLeft] == 0) {
//                     distinct--;
//                 }
//                 left++;
//             }
//             maxLength = Math.max(maxLength, right - left);
//         }
//         return maxLength;
//     }

//     public int lengthOfLongestSubstringTwoDistinct2(String s) {
//         Map<Character, Integer> charToFrequency = new HashMap<>();
//         Set<Integer> visited = new HashSet<>();
//         int left = 0;
//         int right = 0;
//         int maxLength = Integer.MIN_VALUE;
//         while (left < s.length() && right < s.length()) {
//             if (visited.add(right)) {
//                 char cRight = s.charAt(right);
//                 if (!charToFrequency.containsKey(cRight)) {
//                     charToFrequency.put(cRight, 0);
//                 }
//                 charToFrequency.put(cRight, charToFrequency.get(cRight) + 1);
//             }

//             if (charToFrequency.size() <= 2) {
//                 maxLength = Math.max(maxLength, right - left + 1);
//                 right++;
//             } else {
//                 char cLeft = s.charAt(left);
//                 charToFrequency.put(cLeft, charToFrequency.get(cLeft) - 1);
//                 int freq = charToFrequency.get(cLeft);
//                 if (freq == 0) {
//                     charToFrequency.remove(cLeft);
//                 }
//                 left++;
//             }
//         }
//         return maxLength;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("eceba"));
//         System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
//         System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("ababffzzeee"));
//         // 3 5 4
//     }
// }

// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {
//         if (root.left == null && root.right == null) {
//             return 0;
//         }
//         int leftDepth = 0;
//         if (root.left != null) {
//             leftDepth = diameterOfBinaryTree(root.left) + 1;
//         }
//         int rightDepth = 0;
//         if (root.right != null) {
//             rightDepth = diameterOfBinaryTree(root.right) + 1;
//         }
//         return leftDepth + rightDepth;
//     }
// }

// class Solution {
//     public record Pair(int depth, int diameter) {
//     }
//     private Pair calculate(Node node) {
//         if (node.children.isEmpty()) {
//             return new Pair(0, 0);
//         }
//         List<Pair> pairs = new ArrayList<>();
//         for (Node child : node.children) {
//             Pair p = calculate(child);
//             pairs.add(p);
//         }
//         pairs.sort((a, b) -> Integer.compare(b.depth, a.depth));
//         int largestDepth = pairs.get(0).depth();
//         int secondLargestDepth = pairs.size() > 1 ? pairs.get(1).depth() : 0;
//         int diameterFromHere = largestDepth + secondLargestDepth + 1;

//         int maxDiameterSoFar = 0;
//         for (Pair p : pairs) {
//             maxDiameterSoFar = Math.max(maxDiameterSoFar, p.diameter());
//         }
//         return new Pair(
//             largestDepth + 1,
//             Math.max(diameterFromHere, maxDiameterSoFar));
//     }

//     public int diameter(Node root) {
//         return calculate(root).diameter();
//     }
// }

// class Solution {
//     public int minCost(int n) {
//         return minCostHelper(n, new Integer[501]);
//     }

//     private int minCostHelper(int n, Integer[] memo) {
//         if (n == 1) {
//             return 0;
//         }
//         if (n == 2) {
//             return 1;
//         }
//         if (memo[n] != null) {
//             return memo[n];
//         }
//         int cost;
//         if (n % 2 == 0) {
//             cost = (n / 2 * n / 2) + minCostHelper(n / 2, memo) + minCostHelper(n / 2, memo); 
//         } else {
//             cost = (n / 2 * (n / 2 + 1)) + minCostHelper(n / 2, memo) + minCostHelper(n / 2 + 1, memo);
//         }
//         memo[n] = cost;

//         return cost;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minCost(5));
//     }
// }

// class Logger {
//     private Map<String, Integer> msgToTimeMap = new HashMap<>();
    
//     public Logger() {
        
//     }
    
//     public boolean shouldPrintMessage(int timestamp, String message) {
//         if (!msgToTimeMap.containsKey(message) || 
//                 msgToTimeMap.get(message) + 10 <= timestamp) {
//             msgToTimeMap.put(message, timestamp);
//             return true;
//         }
//         return false;
//     }
// }

// class StringIterator {
//     private String compressedString;
//     private int index = 0;
//     private char currentChar;
//     private int currentFreq;

//     public StringIterator(String compressedString) {
//         this.compressedString = compressedString;
//         getCurrentChar();
//     }
    
//     public char next() {
//         if (!hasNext()) {
//             return ' ';
//         }
//         if (currentFreq == 0) {
//             getCurrentChar();
//         }
//         currentFreq--;
//         return currentChar;
//     }
    
//     public boolean hasNext() {
//         if (currentFreq > 0) {
//             return true;
//         }
//         return index < compressedString.length();
//     }

//     private void getCurrentChar() {
//         currentChar = compressedString.charAt(index++);
//         StringBuilder sb = new StringBuilder();
//         while (index < compressedString.length() && 
//             Character.isDigit(compressedString.charAt(index))) {
//             sb.append(compressedString.charAt(index++));
//         }
//         currentFreq = Integer.parseInt(sb.toString());
//     }
// }

// class FirstUnique {
//     class ListNode {
//         int val;
//         ListNode prev;
//         ListNode next;
//         public ListNode(int val, ListNode prev, ListNode next) {
//             this.val = val;
//             this.prev = prev;
//             this.next = next;
//         }    
//     }

//     private ListNode head = new ListNode(-1, null, null);
//     private ListNode tail = new ListNode(-1, null, null);
//     private Map<Integer, ListNode> valToFirstNodeMap = new HashMap<>();

//     public FirstUnique(int[] nums) {
//         head.next = tail;
//         tail.prev = head;
//         for (int num : nums) {
//             add(num);
//         }
//     }
    
//     public int showFirstUnique() {
//         return head.next.val;
//     }
    
//     public void add(int value) {
//         if (!valToFirstNodeMap.containsKey(value)) {
//             ListNode prev = tail.prev;
//             ListNode current = new ListNode(value, prev, tail);
//             prev.next = current;
//             tail.prev = current;
//             valToFirstNodeMap.put(value, current);
//         } else {
//             ListNode current = valToFirstNodeMap.get(value);
//             if (current.prev != null && current.next != null) {
//                 ListNode prev = current.prev;
//                 prev.next = current.next;
//                 current.next.prev = prev;
//             }
//         }
//     }
// }

// class PhoneDirectory {
//     private boolean[] isAssigned;
//     private Queue<Integer> availableSlots;

//     public PhoneDirectory(int maxNumbers) {
//         isAssigned = new boolean[maxNumbers];
//         availableSlots = new ArrayDeque<>(maxNumbers);
//         for (int i = 0; i < maxNumbers; i++) {
//             availableSlots.add(i);
//         }
//     }
    
//     public int get() {
//         if (availableSlots.isEmpty()) {
//             return -1;
//         }
//         isAssigned[availableSlots.peek()] = true;
//         return availableSlots.poll();
//     }
    
//     public boolean check(int number) {
//         return !isAssigned[number];
//     }
    
//     public void release(int number) {
//         availableSlots.add(number);
//         isAssigned[number] = false;
//     }
// }


// class MovingAverage {
//     private Queue<Integer> queue = new LinkedList<>();
//     private double sum = 0;
//     private int size;

//     public MovingAverage(int size) {
//         this.size = size;
//     }
    
//     public double next(int val) {
//         if (queue.size() == size) {
//             sum -= queue.poll();
//         }
//         queue.add(val);
//         sum += val;
//         return sum / queue.size();
//     }

//     public static void main(String[] args) {
//         MovingAverage ma = new MovingAverage(3);
//         System.out.println(ma.next(1));
//         System.out.println(ma.next(10));
//         System.out.println(ma.next(3));
//         System.out.println(ma.next(5));
//     }
// }


// class Solution {
//     public boolean canWin(String currentState) {
//         return !canPlayerTwoWin(currentState, false);
//     }

//     private boolean canPlayerTwoWin(String currentState, boolean isPlayerOne) {
//         if (isWinState(currentState)) {
//             return !isPlayerOne;
//         }
//         for (String nextMove : nextMoves(currentState)) {
//             if (canPlayerTwoWin(nextMove, !isPlayerOne)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean isWinState(String currentState) {
//         for (int i = 0; i < currentState.length() - 1; i++) {
//             if (currentState.charAt(i) == '+' &&
//                 currentState.charAt(i + 1) == '+') {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private List<String> nextMoves(String currentState) {
//         List<String> result = new ArrayList<>();
//         for (int i = 0; i < currentState.length() - 1; i++) {
//             if (currentState.charAt(i) == '+' &&
//                 currentState.charAt(i + 1) == '+') {
//                 StringBuilder sb = new StringBuilder();
//                 sb.append(currentState.substring(0, i));
//                 sb.append("--");
//                 if (i + 2 < currentState.length()) {
//                     sb.append(currentState.substring(i + 2, currentState.length()));
//                 }
//                 result.add(sb.toString());
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().canWin("++++"));
//         System.out.println(new Solution().canWin("+++++++++"));
//         System.out.println(new Solution().canWin("+"));
//     }
// }

// class Solution {
//     public List<String> generatePossibleNextMoves(String currentState) {
//         List<String> result = new ArrayList<>();
//         for (int i = 0; i < currentState.length() - 1; i++) {
//             if (currentState.charAt(i) == '+' &&
//                 currentState.charAt(i + 1) == '+') {
//                 StringBuilder sb = new StringBuilder();
//                 sb.append(currentState.substring(0, i));
//                 sb.append("--");
//                 if (i + 2 < currentState.length()) {
//                     sb.append(currentState.substring(i + 2, currentState.length()));
//                 }
//                 result.add(sb.toString());
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().generatePossibleNextMoves("++++"));
//         System.out.println(new Solution().generatePossibleNextMoves("+"));
//         System.out.println(new Solution().generatePossibleNextMoves("+-+-"));
//     }
// }

// class Solution {
//     public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
//         List<List<Integer>> result = new ArrayList<>();
//         for (int[] interval : intervals) {
//             if (interval[0] > toBeRemoved[1] || interval[1] < toBeRemoved[0]) {
//                 result.add(List.of(interval[0], interval[1]));
//             } else {
//                 if (toBeRemoved[0] > interval[0] && toBeRemoved[0] < interval[1]) {
//                 result.add(List.of(interval[0], toBeRemoved[0]));
//                 } 
//                 if (toBeRemoved[1] > interval[0] && toBeRemoved[1] < interval[1]) {
//                     result.add(List.of(toBeRemoved[1], interval[1]));
//                 }
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().removeInterval(
//             new int[][]{{0,2},{3,4},{5,7}}, new int[]{1,6}));
//         System.out.println(new Solution().removeInterval(
//             new int[][]{{0,5}}, new int[]{2,3}));
//     }
// }

// class Solution {
//     public class Location {
//         int x;
//         int y;
//         public Location(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//         public String toString() {
//             return x + "," + y;
//         }
//     }

//     private static final int[][] DELTAS = new int[][] {
//         {-1,0}, {1,0}, {0,-1}, {0,1}
//     };
    
//     public int minArea(char[][] image, int x, int y) {
//         Set<Integer> xCoords = new HashSet<>();
//         Set<Integer> yCoords = new HashSet<>();
//         dfs(image, new HashSet<>(), xCoords, yCoords, new Location(x, y));
        
//         Location topLeft = new Location(Integer.MAX_VALUE, Integer.MAX_VALUE);
//         Location bottomRight = new Location(Integer.MIN_VALUE, Integer.MIN_VALUE);
//         for (int xCoord : xCoords) {
//             topLeft.x = Math.min(xCoord, topLeft.x);
//             bottomRight.x = Math.max(xCoord, bottomRight.x);
//         }
//         for (int yCoord : yCoords) {
//             topLeft.y = Math.min(yCoord, topLeft.y);
//             bottomRight.y = Math.max(yCoord, bottomRight.y);
//         }
//         int length = bottomRight.x - topLeft.x + 1;
//         int height = bottomRight.y - topLeft.y + 1;
//         return length * height;
//     }

//     private void dfs(char[][] image, Set<String> visited, Set<Integer> xCoords, Set<Integer> yCoords, Location current) {
//         if (current.x >= image.length || current.x < 0 || 
//             current.y >= image[0].length || current.y < 0) {
//             return;
//         }
//         if (image[current.x][current.y] == '0') {
//             return;
//         }
//         if (!visited.add(current.toString())) {
//             return;
//         }
//         xCoords.add(current.y);
//         yCoords.add(current.x);
//         for (int[] delta : DELTAS) {
//             Location neighbor = new Location(current.x + delta[0], current.y + delta[1]);
//             dfs(image, visited, xCoords, yCoords, neighbor);
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minArea(
//             new char[][]{
//                 {'0','0','1','0'},
//                 {'0','1','1','0'},
//                 {'0','1','0','0'}},
//             0, 2));
//     }
// }

// class Solution {
//     public boolean canAttendMeetings(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i - 1][1] > intervals[i][0]) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// class Solution {
//     private static final int[][] DELTAS = new int[][]{
//         {-1,-2},{-2,-1},
//         {-1,2},{-2,1},
//         {1,2},{2,1},
//         {1,-2},{2,-1}
//     };

//     public class Location {
//         int x;
//         int y;
//         public Location(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//         public String toString() {
//             return x + "," + y;
//         }
//     }
    
//     public int minKnightMoves(int x, int y) {
//         int minMoves = 0;
//         Queue<Location> queue = new ArrayDeque<>(300*300);
//         Set<String> visited = new HashSet<>(300*300);
//         queue.add(new Location(0, 0));
//         visited.add("0,0");
//         Location[] bounds = getBoundingLocation(x, y);

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (!queue.isEmpty() && size > 0) {
//                 Location current = queue.poll();
//                 if (current.x == x && current.y == y) {
//                     return minMoves;
//                 }
//                 for (int[] delta : DELTAS) {
//                     Location neighbor = new Location(
//                         current.x + delta[0], current.y + delta[1]);
//                     if (isValid(neighbor, bounds) && visited.add(neighbor.toString())) {
//                         queue.add(neighbor);
//                     }
//                 }
//                 size--;
//             }
//             minMoves++;
//         }
//         return minMoves;
//     }

//     private boolean isValid(Location location, Location[] bounds) {
//         Location topLeftBound = bounds[0];
//         Location bottomLeftBound = bounds[1];
//         Location topRightBound = bounds[2];
//         Location bottomRightBound = bounds[3];
//         if (bottomLeftBound != null && topRightBound != null) {
//             return location.x >= bottomLeftBound.x && location.x <= topRightBound.x &&
//             location.y >= bottomLeftBound.y && location.y <= topRightBound.y;
//         }
//         return location.x >= topLeftBound.x && location.x <= bottomRightBound.x &&
//             location.y >= bottomRightBound.y && location.y <= topLeftBound.y;
//     }

//     private Location[] getBoundingLocation(int x, int y) {
//         Location topLeftBound = null;
//         Location bottomLeftBound = null;
//         Location topRightBound = null;
//         Location bottomRightBound = null;
//         if (x >= 0 && y >= 0) {
//             bottomLeftBound = new Location(-2, -2);
//             topRightBound = new Location(Integer.MAX_VALUE, Integer.MAX_VALUE);
//         } else if (x <= 0 && y >= 0) {
//             topLeftBound = new Location(Integer.MIN_VALUE, Integer.MAX_VALUE); 
//             bottomRightBound = new Location(2, -2);
//         } else if (x <= 0 && y <= 0) {
//             bottomLeftBound = new Location(Integer.MIN_VALUE, Integer.MIN_VALUE); 
//             topRightBound = new Location(2, 2);
//         } else if (x >= 0 && y <= 0) {
//             topLeftBound = new Location(-2, 2);
//             bottomRightBound = new Location(Integer.MAX_VALUE, Integer.MIN_VALUE);
//         }
//         return new Location[]{topLeftBound, bottomLeftBound, topRightBound, bottomRightBound};
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minKnightMoves(270, -21));
//         System.out.println(new Solution().minKnightMoves(2, 1));
//         System.out.println(new Solution().minKnightMoves(5, 5));
//     }
// }

// 0
// 1
// [1, 2], [3], [4]
// class Vector2D {
//     private int arrayIndex = 0;
//     private int elementIndex = 0;
//     int[][] vec;

//     public Vector2D(int[][] vec) {
//         this.vec = vec;
//         while(arrayIndex < vec.length && vec[arrayIndex].length != 0) {
//             arrayIndex++;
//         }  
//     }
    
//     public int next() {
//         int next = vec[arrayIndex][elementIndex];
//         if (elementIndex >= vec[arrayIndex].length - 1) {
//             while(arrayIndex < vec.length && vec[arrayIndex].length != 0) {
//                 arrayIndex++;
//             }    
//             if (arrayIndex < vec.length) {
//                 elementIndex = 0;
//             }
//         } else {
//             elementIndex++;
//         }
//         return next;
//     }
    
//     public boolean hasNext() {
//         if (arrayIndex >= vec[arrayIndex].length) {
//             return false;
//         }
//         return elementIndex < vec.length;
//     }
// }

// class Solution {
//     public class IndexedNode {
//         TreeNode node;
//         int index;
//         public IndexedNode(TreeNode node, int index) {
//             this.node = node;
//             this.index = index;
//         }
//     }

//     public List<List<Integer>> verticalOrder(TreeNode root) {
//         Map<Integer, List<Integer>> indexToNodes = getIndexToNodesMap(root);
//         List<List<Integer>> result = new ArrayList<>(indexToNodes.size());
//         for (Map.Entry<Integer, List<Integer>> entry : indexToNodes.entrySet()) {
//             List<Integer> current = new ArrayList<>();
//             for (int node : entry.getValue()) {
//                 current.add(node);
//             }
//             result.add(current);
//         }
//         return result;
//     }

//     private Map<Integer, List<Integer>> getIndexToNodesMap(TreeNode root) {
//         Map<Integer, List<Integer>> indexToNodesMap = new TreeMap<>();
//         if (root == null) {
//             return indexToNodesMap;
//         }

//         Queue<IndexedNode> queue = new LinkedList<>();
//         queue.add(new IndexedNode(root, 0));  

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (!queue.isEmpty() && size > 0) {
//                 IndexedNode current = queue.poll();
//                 if (!indexToNodesMap.containsKey(current.index)) {
//                     indexToNodesMap.put(current.index, new ArrayList<>());
//                 }
//                 indexToNodesMap.get(current.index).add(current.node.val);
//                 if (current.node.left != null) {
//                     queue.add(new IndexedNode(current.node.left, current.index - 1));
//                 }
//                 if (current.node.right != null) {
//                     queue.add(new IndexedNode(current.node.right, current.index + 1));
//                 }
//                 size--;
//             }
//         }
//         return indexToNodesMap;
//     }
// }

class Node {
    public int val;
    public List<Node> children;
    public Node() {
        children = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}


// class Solution {
//     public boolean isOneEditDistance(String s, String t) {
//         return isOneEditDistanceHelper(s, t, 0, 0, false);
//     }

//     private boolean isOneEditDistanceHelper(String s, String t, int indexS, int indexT, boolean changed) {
//         if (indexS == s.length() && indexT == t.length()) {
//             return changed;
//         }
//         if (indexS == s.length()) {
//             return changed == false && (indexT == t.length() - 1);
//         }
//         if (indexT == t.length()) {
//             return changed == false && (indexS == s.length() - 1);
//         }
//         if (s.charAt(indexS) == t.charAt(indexT)) {
//             return isOneEditDistanceHelper(s, t, indexS + 1, indexT + 1, changed);
//         }
//         if (changed) {
//             return false;
//         }
//         boolean replace = isOneEditDistanceHelper(s, t, indexS + 1, indexT + 1, true);
//         boolean insert = isOneEditDistanceHelper(s, t, indexS + 1, indexT, true);
//         boolean delete = isOneEditDistanceHelper(s, t, indexS, indexT + 1, true);
//         return replace || insert || delete;
//     } 

//     public static void main(String[] args) {
//         System.out.println(new Solution().isOneEditDistance("a", ""));
//         System.out.println(new Solution().isOneEditDistance("abc", "af"));
//         System.out.println(new Solution().isOneEditDistance("acb", "ab"));
//     }
// }


// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int result = 0;
//         int[] prefixSum = new int[nums.length + 1];
//         int sum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             prefixSum[i] = sum;
//             sum += nums[i];
//         }
//         prefixSum[prefixSum.length - 1] = sum;

//         for (int start = 0; start < prefixSum.length; start++) {
//             for (int end = start + 1; end < prefixSum.length; end++) {
//                 int currentSum = prefixSum[end] - prefixSum[start];
//                 if (currentSum == k) {
//                     result++;
//                 }
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         // System.out.println(new Solution().subarraySum(new int[]{1,1,1}, 2));
//         // System.out.println(new Solution().subarraySum(new int[]{1,2,3}, 3));
//         // System.out.println(new Solution().subarraySum(new int[]{1,-1,0}, 0));
//         System.out.println(0.1 + 0.2);
//     }
// }

// class Solution {
//     public int minDistance(String word1, String word2) {
//         return minDistanceHelper(word1, word2, 0, 0, 0);
//     }

//     private int minDistanceHelper(String word1, String word2, int index1, int index2, int ops) {
//         if (index1 == word1.length() && index2 == word2.length()) {
//             return ops;
//         }
//         int replace = Integer.MAX_VALUE;
//         if (index1 < word1.length() && index2 < word2.length()) {
//             if (word1.charAt(index1) == word2.charAt(index2)) {
//                 replace = minDistanceHelper(word1, word2, index1 + 1, index2 + 1, ops);
//             } else {
//                 replace = minDistanceHelper(word1, word2, index1 + 1, index2 + 1, ops + 1);
//             }
//         }
//         int delete = Integer.MAX_VALUE;
//         if (index1 < word1.length()) {
//             delete = minDistanceHelper(word1, word2, index1 + 1, index2, ops + 1);
//         }
//         int insert = Integer.MAX_VALUE;
//         if (index2 < word2.length()) {
//             insert = minDistanceHelper(word1, word2, index1, index2 + 1, ops + 1);
//         }
//         return Math.min(replace, Math.min(insert, delete));
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minDistance("horse", "ros"));
//         System.out.println(new Solution().minDistance("intention", "execution"));
//     }
// }


// class Solution {
//     public long countSubarrays(int[] nums) {
//         long result = 0;
//         int start = 0;
//         while (start < nums.length) {
//             if (start < nums.length - 1 && nums[start] < nums[start + 1]) {
//                 int end = start + 1;
//                 while (end < nums.length && nums[end - 1] < nums[end]) {
//                     end++;
//                 }
//                 long n = (long) (end - start);
//                 result += ((n * (n + 1)) / 2);
//                 start = end;
//             } else {
//                 result++;
//                 start++;
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().countSubarrays(new int[]{1,3,5,4,4,6}));
//         System.out.println(new Solution().countSubarrays(new int[]{1,2,3,4,5}));
//     }
// }


// class Solution {
//     public ListNode deleteDuplicatesUnsorted(ListNode head) {
//         Map<Integer, Integer> freqValues = getDuplicates(head);
//         ListNode result = new ListNode(0);
//         result.next = head;

//         ListNode current = result;
//         while (head != null) {
//             if (freqValues.containsKey(head.val) && freqValues.get(head.val) == 1) {
//                 current.next = head;
//                 current = current.next;
//             }
//             head = head.next;
//         }
//         current.next = null;
//         return result.next;
//     }

//     private Map<Integer, Integer> getDuplicates(ListNode head) {
//         ListNode current = head;
//         Map<Integer, Integer> duplicateValues = new HashMap<>();
//         while (current != null) {
//             if (!duplicateValues.containsKey(current.val)) {
//                 duplicateValues.put(current.val, 0);
//             }
//             duplicateValues.put(current.val, duplicateValues.get(current.val) + 1);
//             current = current.next;
//         }
//         return duplicateValues;
//     }
// }

// class Solution {
//     public ListNode deleteDuplicatesUnsorted(ListNode head) {
//         Set<Integer> duplicateValues = getDuplicates(head);
//         ListNode result = new ListNode();
//         result.next = head;

//         ListNode current = result;
//         while (current != null && current.next != null) {
//             if (duplicateValues.contains(current.next.val)) {
//                 current.next = current.next.next;
//             }
//             current = current.next;
//         }
//         return result.next;
//     }

//     private Set<Integer> getDuplicates(ListNode head) {
//         ListNode current = head;
//         Set<Integer> presentValues = new HashSet<>();
//         Set<Integer> duplicateValues = new HashSet<>();
//         while (current != null) {
//             if (!presentValues.add(current.val)) {
//                 duplicateValues.add(current.val);
//             }
//             current = current.next;
//         }
//         return duplicateValues;
//     }
// }

// class Solution {
//     public String removeVowels(String s) {
//         StringBuilder sb = new StringBuilder();

//         for (char c : s.toCharArray()) {
//             if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                 continue;
//             }
//             sb.append(c);
//         }

//         return sb.toString();
//     }
// }

// class Solution {
//     public int maxKilledEnemies(char[][] grid) {
//         int maxKilledEnemies = 0;
//         for (int row = 0; row < grid.length; row++) {
//             for (int col = 0; col < grid[0].length; col++) {
//                 if (grid[row][col] == '0') {
//                     maxKilledEnemies = Math.max(maxKilledEnemies, maxKilledEnemiesHelper(row, col, grid));
//                 }
//             }
//         }
//         return maxKilledEnemies;
//     }

//     private int maxKilledEnemiesHelper(int row, int col, char[][] grid) {
//         Map<String, Integer> memo = new HashMap<>();
//         int enemiesLeft = maxEnemiesDFS(row, col - 1, grid, new int[]{0,-1}, 0, memo);
//         int enemiesRight = maxEnemiesDFS(row, col + 1, grid, new int[]{0,1}, 0, memo);
//         int enemiesUp = maxEnemiesDFS(row - 1, col, grid, new int[]{-1,0}, 0, memo);
//         int enemiesDown = maxEnemiesDFS(row + 1, col, grid, new int[]{1,0}, 0, memo);
//         return enemiesLeft + enemiesRight + enemiesUp + enemiesDown;
//     }

//     private int maxEnemiesDFS(int row, int col, char[][] grid, int[] delta, int enemies, Map<String, Integer> memo) {
//         if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
//             return enemies;
//         }
//         String key = toKey(row, col, delta);
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }
//         if (grid[row][col] == 'W') {
//             return enemies;
//         }
//         if (grid[row][col] == 'E') {
//             enemies++;
//         }
//         int max = maxEnemiesDFS(row + delta[0], col + delta[1], grid, delta, enemies, memo);
//         memo.put(key, max);
//         return max;
//     }

//     private String toKey(int row, int col, int[] delta) {
//         return "" + row + "," + col + "," + delta[0] + "," + delta[1];
//     }

//     public static void main(String[] args) {
//         //System.out.println(new Solution().maxKilledEnemies(new char[][]{{'0','E','E','W'}}));
//         System.out.println(new Solution().maxKilledEnemies(new char[][]{{'W','W','W','W','E'},{'W','E','E','E','E'},{'W','E','0','E','0'},{'W','E','E','E','E'},{'W','W','W','W','W'}}));
//     }
// }

// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         if (nums.length == 1) {
//             return 1;
//         }
//         int[] onesLeft = new int[nums.length + 1];
//         int ones = 0;
//         for (int i = 0; i < onesLeft.length; i++) {
//             onesLeft[i] = ones;
//             if (i < nums.length && nums[i] == 1) {
//                 ones++;
//             } else if (i < nums.length && nums[i] == 0) {
//                 ones = 0;
//             }
//         }

//         int[] onesRight = new int[nums.length + 1];
//         ones = 0;
//         for (int i = onesRight.length - 1; i >= 0; i--) {
//             onesRight[i] = ones;
//             if (i < nums.length && nums[i] == 1) {
//                 ones++;
//             } else if (i < nums.length && nums[i] == 0) {
//                 ones = 0;
//             }
//         }

//         int maxConsecutiveOnes = 0;
//         for (int i = 0; i < onesLeft.length; i++) {
//             int max = onesLeft[i] + onesRight[i];
//             if (nums[i] == 0) {
//                 max++;
//             }
//             maxConsecutiveOnes = Math.max(maxConsecutiveOnes, max);
//         }
//         return maxConsecutiveOnes;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{1}));
//         System.out.println(new Solution().findMaxConsecutiveOnes(new int[]{0}));
//     }
// }

// class Solution {
//     public int longestConsecutive(TreeNode root) {
//         return longestConsecutiveHelper(root, 1, 1);
//     }

//     private int longestConsecutiveHelper(TreeNode root, int currentLength, int maxLength) {
//         if (root == null) {
//             return 0;
//         }
//         if (root.left == null && root.right == null) {
//             return maxLength;
//         }
//         int left = 1;
//         if (root.left != null) {
//             if (root.val == (root.left.val - 1)) {
//                 left = longestConsecutiveHelper(root.left, currentLength + 1, Math.max(maxLength, currentLength + 1));
//             } else {
//                 left = longestConsecutiveHelper(root.left, 1, Math.max(maxLength, 1));
//             }
//         }
//         int right = 1;
//         if (root.right != null) {
//             if (root.val == (root.right.val - 1)) {
//                 right = longestConsecutiveHelper(root.right, currentLength + 1, Math.max(maxLength, currentLength + 1));
//             } else {
//                 right = longestConsecutiveHelper(root.right, 1, Math.max(maxLength, 1));
//             }
//         }
//         return Math.max(left, right);
//     }
// }


// class Solution {
//     public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
//         List<List<Integer>> missingRanges = new ArrayList<>();
//         List<Integer> existingRanges = new ArrayList<>();
//         for (int num : nums) {
//             existingRanges.add(num);
//         }
//         existingRanges.add(upper + 1);

//         int index = 0;
//         int prev = lower - 1;
//         while (index < existingRanges.size()) {
//             List<Integer> range = new ArrayList<>();
//             while (index < existingRanges.size() && existingRanges.get(index) == prev + 1) {
//                 prev = existingRanges.get(index++);
//             }
//             if (index >= existingRanges.size()) {
//                 return missingRanges;
//             }
//             range.add(prev + 1);
//             prev = existingRanges.get(index++);
//             range.add(prev - 1);
//             missingRanges.add(range);
//         }
//         return missingRanges;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
//         System.out.println(new Solution().findMissingRanges(new int[]{-1}, -1, -1));
//         System.out.println(new Solution().findMissingRanges(new int[]{-1}, -2, -1));
//     }
// }

// class Solution {
//     public boolean validTree(int n, int[][] edges) {
//         if (edges.length != n - 1) {
//             return false;
//         }
//         List<List<Integer>> adjList = buildAdjList(n, edges);
//         return dfs(n, 0, adjList, new HashSet<>(), new HashSet<>());
//     }

//     private boolean dfs(int n, int current, List<List<Integer>> adjList, Set<Integer> visited, Set<Integer> visiting) {
//         if (!visiting.add(current)) {
//             return false;
//         }
//         visited.add(current);
//         for (int neighbor : adjList.get(current)) {
//             dfs(n, neighbor, adjList, visited, visiting);
//         }
//         visiting.remove(current);
//         return visited.size() == n;
//     }

//     private List<List<Integer>> buildAdjList(int n, int[][] edges) {
//         List<List<Integer>> adjList = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<>());
//         }
//         for (int[] edge : edges) {
//             adjList.get(edge[0]).add(edge[1]);
//             adjList.get(edge[1]).add(edge[0]);
//         }
//         return adjList;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));
//         System.out.println(new Solution().validTree(3, new int[][]{{1,0},{2,0}}));
//         System.out.println(new Solution().validTree(3, new int[][]{{1,0},{0,2},{2,1}}));
//         System.out.println(new Solution().validTree(5, new int[][]{{0,1},{0,4},{1,4},{2,3}}));
//     }
// }

// class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         Set<List<Integer>> set = new HashSet<>();
//         List<Integer> list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(num);
//         }
//         permuteUniqueHelper(set, new ArrayList<>(), list);

//         List<List<Integer>> result = new ArrayList<>();
//         for (List<Integer> ans : set) {
//             result.add(ans);
//         }
//         return result;
//     }

//     private void permuteUniqueHelper(Set<List<Integer>> set, List<Integer> current, List<Integer> nums) {
//         if (nums.isEmpty()) {
//             set.add(new ArrayList<>(current));
//             return;
//         }
//         for (int i = 0; i < nums.size(); i++) {
//             current.add(nums.remove(i));
//             permuteUniqueHelper(set, current, nums);
//             nums.add(i, current.remove(current.size() - 1));
//         }
//     }

//     public static void main(String[] args) {
//         for (List<Integer> list : new Solution().permuteUnique(new int[]{1,1,3})) {
//             System.out.println(list);
//         }
//     }
// }

// class Solution {
//     public int[][] generateMatrix(int n) {
//         int[][] matrix = new int[n][n];
//         int right = n;
//         int down = n;
//         int left = -1;
//         int up = 0;
//         int row = 0;
//         int col = 0;
//         int num = 1;

//         while (num <= (n * n)) {
//             while (col < right) {
//                 matrix[row][col++] = num++;
//             }
//             col--;
//             row++;
//             right--;

//             while (row < down) {
//                 matrix[row++][col] = num++;
//             }
//             row--;
//             col--;
//             down--;

//             while (col > left) {
//                 matrix[row][col--] = num++;
//             }
//             col++;
//             row--;
//             left++;

//             while (row > up) {
//                 matrix[row--][col] = num++;
//             }
//             row++;
//             col++;
//             up++;
//         }
//         return matrix;
//     }

//     public static void main(String[] args) {
//         for (int[] row : new Solution().generateMatrix(10)) {
//             System.out.println(Arrays.toString(row));
//         }
//     }
// }

// class Relation {
//     public boolean knows(int a, int b){ 
//         if ((a == 0 && b == 1) || (a == 2 && b == 0) || (a == 2 && b == 1)) {
//             return true;
//         }
//         return false;
//     }
// }

// public class Solution extends Relation {
//     public int findCelebrity(int n) {
//         int i = 0;
//         while (i < n) {
//             int count = 0;
//             int j = 0;
//             while (j < n) {
//                 if (j != i && knows(j, i)) {
//                     count++;
//                 }
//                 if (count == n - 1) {
//                     return i;
//                 }
//                 j++;
//             } 
//             i++;
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         new Solution().findCelebrity(3);
//     }
// }


// class Solution {
//     public int shortestDistance(String[] wordsDict, String word1, String word2) {
//         Set<Integer> indices1 = new HashSet<>();
//         Set<Integer> indices2 = new HashSet<>(); 

//         for (int i = 0; i < wordsDict.length; i++) {
//             if (wordsDict[i] == word1) {
//                 indices1.add(i);
//             } else if (wordsDict[i] == word2) {
//                 indices2.add(i);
//             }
//         }

//         int min = Integer.MAX_VALUE;
//         for (int indice1 : indices1) {
//             for (int indice2 : indices2) {
//                 min = Math.min(Math.abs(indice1 - indice2), min);
//             }
//         }

//         return min;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().shortestDistance(new String[]{"practice","makes","perfect","coding","makes"}, "practice", "coding"));
//     }
// }

// class Solution {
//     public int visibleMountains(int[][] peaks) {
//         int[][] mountains = getMountains(peaks);
//         Arrays.sort(mountains, (a,b) -> Integer.compare(a[0], b[0]));

//         int index = 0;
//         Stack<int[]> stack = new Stack<>();

//         while (index < mountains.length) {
//             if (stack.isEmpty()) {
//                 stack.add(mountains[index++]);
//                 continue;
//             } 

//             int[] mountain = mountains[index];
//             if (isInsideOf(mountain, stack.peek())) {
//                 index++;
//                 continue;
//             } 
            
//             while (!stack.isEmpty() && isInsideOf(stack.peek(), mountain)) {
//                 stack.pop();
//             }
//             stack.add(mountain);
//             index++;
            
//         }
//         return stack.size();
//     }

//     private boolean isInsideOf(int[] first, int[] second) {
//         return first[0] <= second[0] && first[1] <= second[1];
//     }

//     private int[][] getMountains(int[][] peaks) {
//         int[][] mountains = new int[peaks.length][2];
//         for (int i = 0; i < peaks.length; i++) {
//             mountains[i][0] = peaks[i][0] - peaks[i][1]; 
//             mountains[i][1] = peaks[i][0] + peaks[i][1]; 
//         }
//         return mountains;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().visibleMountains(new int[][]{{1,3},{1,3}}));
//         System.out.println(new Solution().visibleMountains(new int[][]{{2,2},{6,3},{5,4}}));
//         System.out.println(new Solution().visibleMountains(new int[][]{{1,3},{1,3},{1,3},{4,5},{5,3}}));
//     }
// }


// class Solution {
//     public boolean canConvert(String str1, String str2) {
//         if (str1.length() != str2.length()) {
//             return false;
//         }

//         Set<Character> str2Chars = new HashSet<>();
//         Map<Character, List<Integer>> charToIndices = new HashMap<>();
//         for (int i = 0; i < str1.length(); i++) {
//             char c1 = str1.charAt(i);
//             if (!charToIndices.containsKey(c1)) {
//                 charToIndices.put(c1, new ArrayList<>());
//             } 
//             charToIndices.get(c1).add(i);
//             str2Chars.add(str2.charAt(i));
//         }

//         if (str2Chars.size() == 26) {
//             return false;
//         }

//         for (List<Integer> indices : charToIndices.values()) {
//             char c = str2.charAt(indices.get(0));
//             for (int i = 0; i < indices.size(); i++) {
//                 if (c != str2.charAt(indices.get(i))) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));  // false
//         System.out.println(new Solution().canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza"));  // false
//         System.out.println(new Solution().canConvert("xyz", "xzz")); // true
//     }
// }

// class Sea {
//     public boolean hasShips(int[] topRight, int[] bottomLeft){
//         return true;
//     }
// }

// class Solution {
//     public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
//         return countShipsHelper(sea, topRight, bottomLeft);
//     }

//     private int countShipsHelper(Sea sea, int[] topRight, int[] bottomLeft) {
//         if (!sea.hasShips(topRight, bottomLeft)) {
//             return 0;
//         }
//         if (isPoint(topRight, bottomLeft)) {
//             return 1;
//         }
//         int[][] rects = getRects(topRight, bottomLeft);
//         int topLeftSea = countShipsHelper(sea, rects[0], rects[1]);
//         int bottomLeftSea = countShipsHelper(sea, rects[2], rects[3]);
//         int topRightSea = countShipsHelper(sea, rects[4], new int[]{midX, midY});
//         int bottomRightSea = countShipsHelper(sea, new int[]{topRight[0], midY}, new int[]{midX, bottomLeft[1]});
//         return topLeftSea + bottomLeftSea + topRightSea + bottomRightSea;
//     }

//     public int[][] getRects(int[] topRight, int[] bottomLeft) {
//         int midX = bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2;
//         int midY = topRight[1] - (topRight[1] - bottomLeft[1]) / 2;
//         int topLeftSea = countShipsHelper(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY});
//         int bottomLeftSea = countShipsHelper(sea, new int[]{midX, midY}, bottomLeft);
//         int topRightSea = countShipsHelper(sea, topRight, new int[]{midX, midY});
//         int bottomRightSea = countShipsHelper(sea, new int[]{topRight[0], midY}, new int[]{midX, bottomLeft[1]});
//     }

//     private boolean isPoint(int[] topRight, int[] bottomLeft) {
//         return topRight[0] == bottomLeft[0] && 
//                 topRight[1] == bottomLeft[2];
//     }

//     public static void main(String[] args) {
//         new Solution().getRects(new Solution().new Rect(new int[]{3,3}, new int[]{1,1}));
//         new Solution().getRects(new Solution().new Rect(new int[]{2,2}, new int[]{1,1}));
//         new Solution().getRects(new Solution().new Rect(new int[]{2,3}, new int[]{1,1}));
//         new Solution().getRects(new Solution().new Rect(new int[]{3,2}, new int[]{1,1}));
//         new Solution().ge
//     }
// }

// class Solution {
//     public boolean canConvert(String str1, String str2) {
//         if (str1.length() != str2.length()) {
//             return false;
//         }

//         Map<Character, Character> oneToTwo = new HashMap<>();
//         Map<Character, Character> twoToOne = new HashMap<>();
//         for (int i = 0; i < str1.length(); i++) {
//             char c1 = str1.charAt(i);
//             char c2 = str2.charAt(i);
//             if (oneToTwo.containsKey(c1)) {
//                 if (oneToTwo.get(c1) != c2) {
//                     return false;
//                 }
//             } else {
//                 oneToTwo.put(c1, c2);
//             }

//             // if (twoToOne.containsKey(c2)) {
//             //     if (twoToOne.get(c2) != c1) {
//             //         return false;
//             //     }
//             // } else {
//             //     twoToOne.put(c2, c1);
//             // }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().canConvert("xyz", "xzz"));
//         System.out.println(new Solution().canConvert("aabcc", "ccdee"));
//         System.out.println(new Solution().canConvert("leetcode", "codeleet"));
//         System.out.println(new Solution().canConvert("leetcode", "cooerfpo"));
//     }
// }

// class Solution {
//     public String applySubstitutions(List<List<String>> replacements, String text) {
//         Map<Character, String> replacementsMap = new HashMap<>();
//         for (List<String> replacement : replacements) {
//             replacementsMap.put(replacement.get(0).charAt(0), replacement.get(1));
//         }
//         return substitute(replacementsMap, text, "", 0);
//     }

//     private String substitute(Map<Character, String> replacementsMap, String text, String current, int index) {
//         if (index >= text.length()) {
//             return current;
//         }
//         if (text.charAt(index) != '%') {
//             current += text.charAt(index);
//             return substitute(replacementsMap, text, current, index + 1);
//         }
//         index++;
//         char c = text.charAt(index);
//         current += substitute(replacementsMap, replacementsMap.get(c), "", 0);
//         return substitute(replacementsMap, text, current, index + 2);
//     }
// }

// class Solution {
//     public int minProductSum(int[] nums1, int[] nums2) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int result = 0;
//         for (int i = 0; i < nums1.length; i++) {
//             result += (nums1[nums1.length - i] * nums2[i]);
//         }
//         return result;
//     }
// }

// class Solution {
//     public int visibleMountains(int[][] peaks) {
//         int result = 0;
//         int[][] mountains = getMountains(peaks);
        
//         Arrays.sort(mountains, (a,b) -> Integer.compare(a[0], b[0]));
//         Stack<int[]> stack = new Stack<>();
//         for (int[] mountain : mountains) {
//             stack
//         }
//         return result;
//     }

//     private int[][] getMountains(int[][] peaks) {
//         int[][] mountains = new int[peaks.length][2];
//         for (int i = 0; i < peaks.length; i++) {
//             mountains[i][0] = peaks[i][0] - peaks[i][1]; 
//             mountains[i][1] = peaks[i][0] + peaks[i][1]; 
//         }
//         return mountains;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().visibleMountains(new int[][]{{2,2},{6,3},{5,4}}));
//         System.out.println(new Solution().visibleMountains(new int[][]{{1,3},{1,3}}));
//     }
// }

// class Solution {
//     // public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
//     //     List<List<Integer>> adjList = buildAdjList(n, edges);
//     //     if (adjList.get(source).size() == 0) {
//     //         return false;
//     //     }
//     //     for (int neighbor : adjList.get(source)) {
//     //         if (!dfs(adjList, neighbor, destination, new HashSet<>(), new HashSet<>())) {
//     //             return false;
//     //         }
//     //     }
//     //     return true;
//     // }

//     // private List<List<Integer>> buildAdjList(int n, int[][] edges) {
//     //     List<List<Integer>> adjList = new ArrayList<>();
//     //     for (int i = 0; i < n; i++) {
//     //         adjList.add(new ArrayList<>());
//     //     }
//     //     for (int[] edge : edges) {
//     //         adjList.get(edge[0]).add(edge[1]);
//     //     }
//     //     return adjList;
//     // }

//     // private boolean dfs(
//     //     List<List<Integer>> adjList, int current, int destination, Set<Integer> visited, Set<Integer> visiting) {
//     //     if (visiting.contains(current)) {
//     //         return false;
//     //     }
//     //     if (adjList.get(current).size() == 0) {
//     //         return current == destination;
//     //     }
//     //     if (!visited.add(current)) {
//     //         return false;
//     //     }
//     //     visiting.add(current);
//     //     for (int neighbor : adjList.get(current)) {
//     //         if (!dfs(adjList, neighbor, destination, visited, visiting)) {
//     //             return false;
//     //         }
//     //     }
//     //     visiting.remove(current);
//     //     return true;
//     // }

//     public static void main(String[] args) {
//         System.out.println(new Solution().leadsToDestination(4, new int[][]{{1,0},{2,3}}, 0, 1));
//         System.out.println(new Solution().leadsToDestination(5, new int[][]{{0,1},{0,2},{0,3},{0,3},{1,2},{0,2}}, 0, 4));
//     }
// }


// class Solution {
//     public String filterCharacters(String s, int k) {
//         Map<Character, Integer> charToFreq = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             if (!charToFreq.containsKey(c)) {
//                 charToFreq.put(c, 0);
//             }
//             charToFreq.put(c, charToFreq.get(c) + 1);
//         }

//         StringBuilder sb = new StringBuilder();
//         for (char c : s.toCharArray()) {
//             if (charToFreq.get(c) < 3) {
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         return maxProfitHelper(prices, fee, 0, true);
//     }

//     private int maxProfitHelper(int[] prices, int fee, int index, boolean canBuy) {
//         if (index >= prices.length) {
//             return 0;
//         }
//         int profit = 0;
//         if (canBuy) {
//             int buy = -prices[index] + maxProfitHelper(prices, fee, index + 1, false);
//             int noBuy = maxProfitHelper(prices, fee, index + 1, true);
//             profit = Math.max(buy, noBuy);
//         } else {
//             int sell = prices[index] - fee + maxProfitHelper(prices, fee, index + 1, true);
//             int noSell = maxProfitHelper(prices, fee, index + 1, false);
//             profit = Math.min(sell, noSell);
//         }
//         return profit;
//     }
// }

// class Solution {
//     public List<Integer> grayCode(int n) {
//         List<Integer> grayCode = new ArrayList<>();
//         Set<Integer> visited = new HashSet<>();
//         grayCode.add(0);
//         visited.add(0);
//         grayCodeHelper(grayCode, visited, n);
//         return grayCode;
//     }

//     private void grayCodeHelper(List<Integer> grayCode, Set<Integer> visited, int n) {
//         int size = (int) Math.pow(2, (double) n);
//         if (grayCode.size() == size) {
//             return;
//         }
//         int current = grayCode.get(grayCode.size() - 1);
//         for (int neighbor : getNeighbors(current, n)){
//             if (visited.add(neighbor)) {
//                 grayCode.add(neighbor);
//                 grayCodeHelper(grayCode, visited, n);
//             }
//         }
//     }

//     private List<Integer> getNeighbors(int num, int n) {
//         List<Integer> result = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             boolean enabled = !getBit(num, i);
//             result.add(setBit(num, i, enabled));
//         }
//         return result;
//     }

//     private boolean getBit(int num, int index) {
//         int mask = 1 << index;
//         return (int)(num & mask) > 0;
//     }

//     private int setBit(int num, int index, boolean enabled) {
//         int n = 0;
//         if(enabled) {
//             int mask = 1 << index;
//             n = num | mask;
//         } else {
//             int mask = 1 << index;
//             mask = ~mask;
//             n = num & mask;
//         }
//         return n;
//     }

//     public static void main(String[] args) {
//         for (int num : new Solution().grayCode(3)) {
//             System.out.println(num);
//         }
//     }
// }

// class Solution {
//     public int largestBSTSubtree(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
//             return countNodes(root);
//         }
//         return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
//     }

//     private boolean isBST(TreeNode root, int left, int right) {
//         if (root == null) {
//             return true;
//         }
//         if (root.val <= left || root.val >= right ) {
//             return false;
//         }
//         return isBST(root.left, left, root.val) && isBST(root.right, root.val, right);
//     }

//     private int countNodes(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         return countNodes(root.left) + countNodes(root.right) + 1;
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1, new TreeNode(), new TreeNode());
//         root.left.left = new TreeNode();
//         root.right.left = new TreeNode();
//         root.left.right = new TreeNode();
//         System.out.println(new Solution().countNodes(root));
//     }
// }

// class Solution {
//     public String alienOrder(String[] words) {
//         Map<Character, Integer> inDegrees = new HashMap<>();
//         if (words.length == 1) {
//             for (char c : words[0].toCharArray()) {
//                 inDegrees.putIfAbsent(c, 0);
//             }
//             StringBuilder sb = new StringBuilder();
//             for (char c : inDegrees.keySet()) {
//                 sb.append(c);
//             } 
//             return sb.toString();
//         }
//         Map<Character, List<Character>> adjMap = new HashMap<>();
//         int cycle = buildMaps(words, adjMap, inDegrees);
//         if (cycle == -1) {
//             return "";
//         }
//         inDegrees.ke
//         return getOrder(adjMap, inDegrees);
//     }

//     private int buildMaps(String[] words, Map<Character, List<Character>> adjMap, Map<Character, Integer> inDegrees) {
//         for (int i = 1; i < words.length; i++) {
//             String first = words[i - 1];
//             String second = words[i];
//             for (char c : first.toCharArray()) {
//                 inDegrees.putIfAbsent(c, 0);
//             }
//             for (char c : second.toCharArray()) {
//                 inDegrees.putIfAbsent(c, 0);
//             }

//             int index = 0;
//             while (index < first.length() && index < second.length() && 
//                     first.charAt(index) == second.charAt(index)) {
//                 index++;
//             }
//             if (index >= first.length()) {
//                 continue;
//             }
//             if (index >= second.length()) {
//                 return -1;
//             }
//             char antecedent = first.charAt(index);
//             if (!inDegrees.containsKey(antecedent)) {
//                 inDegrees.put(antecedent, 0);
//             }
//             char dependent = second.charAt(index);
//             if (!adjMap.containsKey(antecedent)) {
//                 adjMap.put(antecedent, new ArrayList<>());
//             }
//             adjMap.get(antecedent).add(dependent);
//             if (!inDegrees.containsKey(dependent)) {
//                 inDegrees.put(dependent, 0);
//             }
//             inDegrees.put(dependent, inDegrees.get(dependent) + 1);
//         }
//         return 1;
//     }

//     private String getOrder(Map<Character, List<Character>> adjMap, Map<Character, Integer> inDegrees) {
//         Queue<Character> queue = new LinkedList<>();
//         for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
//             if (entry.getValue() == 0) {
//                 queue.add(entry.getKey());
//             }
//         }

//         StringBuilder sb = new StringBuilder();
//         while (!queue.isEmpty()) {
//             char current = queue.poll();
//             sb.append(current);
//             if (!adjMap.containsKey(current)) {
//                 continue;
//             }
//             List<Character> neighbors = adjMap.get(current);
//             for (char neighbor : neighbors) {
//                 inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
//                 if (inDegrees.get(neighbor) == 0) {
//                     queue.add(neighbor);
//                 }
//             }
//         }

//         String result = sb.toString();
//         if (result.length() != inDegrees.size()) {
//             return "";
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().alienOrder(new String[]{"wrt","wrf"}));
//         System.out.println(new Solution().alienOrder(new String[]{"ab","adc"}));
//         System.out.println(new Solution().alienOrder(new String[]{"x","z","x"}));
//         System.out.println(new Solution().alienOrder(new String[]{"wrt","wrtkj"}));
//         System.out.println(new Solution().alienOrder(new String[]{"abc","ab"}));
//     }
// }

public class LeetCode2 {
    int val;
    LeetCode2 next;
    LeetCode2() {}
    LeetCode2(int val) { this.val = val; }
    LeetCode2(int val, LeetCode2 next) { this.val = val; this.next = next; }
}

// class MaxStack {


//     private ListNode head = new ListNode();
//     private ListNode tail = new ListNode();
//     private TreeMap<Integer, List<ListNode>> valToNodes = new TreeMap<>();

//     public MaxStack() {
//         head.next = tail;
//         tail.previous = head;
//     }
    
//     public void push(int x) {
//         ListNode prev = tail.previous;
//         ListNode current = new ListNode(x, prev, tail);
//         tail.previous = current;
//         prev.next = current;

//         if (!valToNodes.containsKey(x)) {
//             valToNodes.put(x, new ArrayList<>());
//         }
//         valToNodes.get(x).add(current);
//     }
    
//     public int pop() {
//         ListNode current = tail.previous;
//         ListNode prev = current.previous;
//         tail.previous = prev;
//         prev.next = tail;

//         List<ListNode> nodes = valToNodes.get(current.value);
//         int pop = nodes.remove(nodes.size() - 1).value;
//         if (nodes.size() == 0) {
//             valToNodes.remove(current.value);
//         }
//         return pop;
//     }
    
//     public int top() {
//         ListNode current = tail.previous;
//         return current.value;
//     }
    
//     public int peekMax() {
//         List<ListNode> max = valToNodes.get(valToNodes.lastKey());
//         ListNode maxNode = max.get(max.size() - 1);
//         return maxNode.value;
//     }
    
//     public int popMax() {
//         List<ListNode> max = valToNodes.get(valToNodes.lastKey());
//         ListNode maxNode = max.remove(max.size() - 1);
//         if (max.size() == 0) {
//             valToNodes.remove(valToNodes.lastKey());
//         }
//         ListNode prev = maxNode.previous;
//         ListNode next = maxNode.next;
//         prev.next = next;
//         next.previous = prev;
//         return maxNode.value;
//     }
// }

// class Solution {
//     private final static int[][] DELTAS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

//     public void wallsAndGates(int[][] rooms) {
//         Queue<Integer> queue = new LinkedList<>();
//         for (int row = 0; row < rooms.length; row++) {
//             for (int col = 0; col < rooms[0].length; col++) {
//                 if (rooms[row][col] == 0) {
//                     queue.add(row * rooms[0].length + col);
//                 }
//             }
//         }

//         Set<Integer> visited = new HashSet<>();
//         int distance = 1;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (!queue.isEmpty() && size > 0) {
//                 int current = queue.poll();
//                 for (int neighbor : getNeighbors(rooms, current, visited)) {
//                     visited.add(neighbor);
//                     queue.add(neighbor);
//                     rooms[neighbor / rooms[0].length][neighbor % rooms[0].length] = distance;
//                 }
//                 size--;
//             }
//             distance++;
//         }
//     }

//     private List<Integer> getNeighbors(int[][] rooms, int position, Set<Integer> visited) {
//         List<Integer> neighbors = new ArrayList<>();
//         int currentRow = position / rooms[0].length;
//         int currentCol = position % rooms[0].length;
//         for (int[] delta : DELTAS) {
//             int neighborRow = currentRow + delta[0];
//             int neighborCol = currentCol + delta[1];
//             int neighbor = neighborRow * rooms[0].length + neighborCol;
//             if (neighborRow >= 0 && neighborRow < rooms.length &&
//                  neighborCol >= 0 && neighborCol < rooms[0].length && 
//                  !visited.contains(neighbor) && 
//                  rooms[neighborRow][neighborCol] == Integer.MAX_VALUE
//             ) {
//                 neighbors.add(neighbor);
//             }
//         }
//         return neighbors;
//     }

//     public static void main(String[] args) {
//         new Solution().wallsAndGates(new int[][]{
//             {2147483647,-1,0,2147483647},
//             {2147483647,2147483647,2147483647,-1},
//             {2147483647,-1,2147483647,-1},
//             {0,-1,2147483647,2147483647}
//         });
//         new Solution().wallsAndGates(new int[][]{{2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647}});
//     }
// }

// class Solution {
//     public int longestRepeatingSubstring(String s) {
//         int left = 0;
//         int right = s.length()-1;
//         int result = -1;
//         while(left <= right) {
//             int middle = left + (right - left) / 2;
//             if (isRepeatingSubstring(s, middle)) {
//                 result = middle;
//                 left = middle + 1;
//             } else {
//                 right = middle - 1;
//             }
//         }
//         return result;
//     }

//     private boolean isRepeatingSubstring(String s, int window) {
//         // HashSet<Integer> set = new HashSet<>();
//         // int hash = 0;
//         // int exp = window - 1;
//         // for (int i = 0; i <= window; i++) {
//         //     hash += Character.getNumericValue((s.charAt(i) - 0)) * Math.pow(31, exp--);
//         //     hash %= 1_000_000_007;
//         // }
//         // set.add(hash);

//         // for (int right = window + 1; right < s.length(); right++) {
//         //     int left = right - window - 1;
//         //     hash = hash - 
//         //     if (!set.add(substring)) {
//         //         return true;
//         //     }
//         // }
//         return false;
//     }

//     public static void main(String[] args) {
//         new Solution().longestRepeatingSubstring("aabcaabdaab");
//     }
//     // public int longestRepeatingSubstring1(String s) {
//     //     int maxLength = 0;
//     //     Set<String> substrings = new HashSet<>();
//     //     for (int i = 0; i < s.length(); i++) {
//     //         for (int j = i; j < s.length(); j++) {
//     //             String substring = s.substring(i, j + 1);
//     //             if (!substrings.add(substring)) {
//     //                 maxLength = Math.max(maxLength, substring.length());
//     //             }
//     //         }
//     //     }
//     //     return maxLength;
//     // }
// }

// class Solution {
//     public int[] getModifiedArray(int length, int[][] updates) {
//         int[] result = new int[length];
//         for (int[] update : updates) {
//             int startIndex = update[0];
//             int endIndex = update[1] + 1;
//             int value = update[2];
//             result[startIndex] += value;
//             if (endIndex < length) {
//                 result[endIndex] -= value;
//             }
//         }

//         int runningSum = 0;
//         for (int i = 0; i < length; i++) {
//             runningSum += result[i];
//             result[i] = runningSum;
//         }
//         return result;
//     }

//     public int[] getModifiedArray1(int length, int[][] updates) {
//         int[] result = new int[length];
//         for (int[] update : updates) {
//             for (int i = update[0]; i <= update[1]; i++) {
//                 result[i] += update[2];
//             }
//         }
//         return result;
//     }
// }


// // This is the interface that allows for creating nested lists.
// // You should not implement it, or speculate about its implementation
// public interface NestedInteger {
//     // Constructor initializes an empty nested list.
//     public NestedInteger();

//     // Constructor initializes a single integer.
//     public NestedInteger(int value);

//     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     public boolean isInteger();

//     // @return the single integer that this NestedInteger holds, if it holds a single integer
//     // The result is undefined if this NestedInteger holds a nested list
//     public Integer getInteger();

//     // Set this NestedInteger to hold a single integer.
//     public void setInteger(int value);

//     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//     public void add(NestedInteger ni);

//     // @return the nested list that this NestedInteger holds, if it holds a nested list
//     // The result is undefined if this NestedInteger holds a single integer
//     public List<NestedInteger> getList();
// }

// class Solution {
//     public class NestedInteger {
//         // Constructor initializes an empty nested list.
//         public NestedInteger(){}

//         // Constructor initializes a single integer.
//         public NestedInteger(int value){}

//         // @return true if this NestedInteger holds a single integer, rather than a nested list.
//         public boolean isInteger();

//         // @return the single integer that this NestedInteger holds, if it holds a single integer
//         // The result is undefined if this NestedInteger holds a nested list
//         public Integer getInteger();

//         // Set this NestedInteger to hold a single integer.
//         public void setInteger(int value);

//         // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//         public void add(NestedInteger ni){}

//         // @return the nested list that this NestedInteger holds, if it holds a nested list
//         // The result is undefined if this NestedInteger holds a single integer
//         public List<NestedInteger> getList(){}
//     }

//     public int depthSum(List<NestedInteger> nestedList) {
//         int sum = 0;
//         for (NestedInteger nestedInteger : nestedList) {
//             sum += depthSumHelper(nestedInteger);
//         }
//         return sum;
//     }

//     private int depthSumHelper(NestedInteger nestedInteger) {
//         if (nestedInteger.isInteger()) {
//             return nestedInteger.getInteger();
//         }
//         int depth = 1;
//         int sum = 0;
//         List<NestedInteger> list = nestedInteger.getList();
//         for (NestedInteger ni : list) {
//             sum += (depthSumHelper(ni) * (depth + 1));
//         }
//         nestedInteger.setInteger(sum);
//         return sum;
//     }
// }

// class Leaderboard {
//     class Player {
//         private int score;
//         public Player(int playerId, int score) {
//             this.score = score;
//         }
//     }
//     private Map<Integer, Player> idToPlayer = new HashMap<>();

//     public Leaderboard() {
        
//     }
    
//     public void addScore(int playerId, int score) {
//         if (!idToPlayer.containsKey(playerId)) {
//             idToPlayer.put(playerId, new Player(playerId, 0));
//         }
//         idToPlayer.get(playerId).score += score;
//     }
    
//     public int top(int K) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(K);
//         for (Player player : idToPlayer.values()) {
//             int poll = Integer.MIN_VALUE; 
//             if (pq.size() == K) {
//                 poll = pq.poll();
//             }
//             pq.add(Math.max(poll, player.score));
//         }

//         int top = 0;
//         while (!pq.isEmpty()) {
//             top += pq.poll();
//         }
//         return top;
//     }
    
//     public void reset(int playerId) {
//         idToPlayer.get(playerId).score = 0;
//     }
// }


// class FileSystem {
//     class Node {
//         private String folder;
//         private Map<String, Node> childFolderToNode = new HashMap<>();
//         private int value = -1;
//         public Node(String folder){
//             this.folder = folder;
//         }
//     }

//     private Node parent = new Node("/");

//     public FileSystem() {
        
//     }
    
//     public boolean createPath(String path, int value) {
//         if (path.length() == 0 || path.length() == 1) {
//             return false;
//         }

//         Node current = parent;
//         List<String> folders = getFolders(path);
//         for (int index = 0; index < folders.size() - 1; index++) {
//             String folder = folders.get(index);
//             if (!current.childFolderToNode.containsKey(folder)) {
//                 return false;
//             }
//             current = current.childFolderToNode.get(folder);
//         }

//         String lastFolder = folders.get(folders.size() - 1);
//         if (!current.childFolderToNode.containsKey(lastFolder)) {
//             current.childFolderToNode.put(lastFolder, new Node(lastFolder));
//         }
//         current = current.childFolderToNode.get(lastFolder);
//         if (current.value != -1) {
//             return false;
//         }
//         current.value = value;

//         return true;
//     }
    
//     public int get(String path) {
//         if (path.length() == 0 || path.length() == 1) {
//             return -1;
//         }

//         List<String> folders = getFolders(path);
//         int value = 0;
//         Node current = parent;
//         for (String folder : folders) {
//             if (!current.childFolderToNode.containsKey(folder)) {
//                 return -1;
//             }
//             current = current.childFolderToNode.get(folder);
//             value = current.value;
//         }
//         return value;
//     }

//     private List<String> getFolders(String path) {
//         List<String> folders = new ArrayList<>();
//         int index = 1;

//         while (index < path.length()) {
//             StringBuilder sb = new StringBuilder();
//             while (index < path.length() && path.charAt(index) != '/') {
//                 sb.append(path.charAt(index++));
//             }
//             folders.add(sb.toString());
//             index++;
//         }

//         return folders;
//     }

//     public static void main(String[] args) {
//         // FileSystem fs = new FileSystem();
//         // System.out.println(fs.createPath("/leet", 1));
//         // System.out.println(fs.createPath("/leet/code", 2));
//         // System.out.println(fs.get("/leet/code"));
//         // System.out.println(fs.createPath("/c/d", 1));
//         // System.out.println(fs.get("/c"));
//         FileSystem fs = new FileSystem();
//         System.out.println(fs.createPath("/j", 1));     //true
//         System.out.println(fs.createPath("/j/i", 2));   //true
//         System.out.println(fs.get("/j"));                      //1
//         System.out.println(fs.createPath("/ji/w", 3));  //false
//         System.out.println(fs.get("/j/i"));                    // 2
//     }
// } 

// class Solution {
//     public int connectSticks(int[] sticks) {
//         int result = 0;
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int stick : sticks) {
//             pq.add(stick);
//         }
//         while (pq.size() != 1) {
//             int first = pq.poll();
//             int second = pq.poll();
//             int sum = first + second;
//             result += sum;
//             pq.add(sum);
//         }
//         return result;
//     }
// }

// class Solution {
//     public long maxCoins(int[] lane1, int[] lane2) {
//         long maxCoins = Long.MIN_VALUE;
//         for (int start = 0; start < lane1.length; start++) {
//             maxCoins = Math.max(maxCoins, maxCoinsHelper2(lane1, lane2, start, 1, 0));
//         }
//         return maxCoins;
//     }

//     private long maxCoinsHelper(int[] lane1, int[] lane2, int index, int lane, int switches) {
//         if (index >= lane1.length) {
//             return 0;
//         }
//         long exit = Long.MIN_VALUE;
//         long left = Long.MIN_VALUE;
//         long right = Long.MIN_VALUE;
//         if (lane == 1) {
//             left = lane1[index] + maxCoinsHelper(lane1, lane2, index + 1, 1, switches);
//             if (switches < 2) {
//                 right = lane2[index] + maxCoinsHelper(lane1, lane2, index + 1, 2, switches + 1);
//                 exit = Math.max(lane1[index], lane2[index]);
//             } else {
//                 exit = lane1[index];
//             } 
//         } else {
//             if (switches < 2) {
//                 left = lane1[index] + maxCoinsHelper(lane1, lane2, index + 1, 1, switches + 1);
//                 exit = Math.max(lane1[index], lane2[index]);
//             } else {
//                 exit = lane2[index];
//             } 
//             right = lane2[index] + maxCoinsHelper(lane1, lane2, index + 1, 2, switches);
//             exit = lane2[index];
//         }
//         return Math.max(Math.max(left, right), exit);
//     }

//     private long maxCoinsHelper2(int[] lane1, int[] lane2, int index, int lane, int switches) {
//     if (index >= lane1.length) {
//         return 0;
//     }

//     long exit;
//     long left = Long.MIN_VALUE;
//     long right = Long.MIN_VALUE;

//     if (lane == 1) {
//         left = lane1[index] + maxCoinsHelper(lane1, lane2, index + 1, 1, switches);
//         if (switches < 2) {
//             right = lane2[index] + maxCoinsHelper(lane1, lane2, index + 1, 2, switches + 1);
//         }
//         exit = lane1[index];
//     } else {
//         if (switches < 2) {
//             left = lane1[index] + maxCoinsHelper(lane1, lane2, index + 1, 1, switches + 1);
//         }
//         right = lane2[index] + maxCoinsHelper(lane1, lane2, index + 1, 2, switches);
//         exit = lane2[index];
//     }

//     return Math.max(exit, Math.max(left, right));
// }

//     public static void main(String[] args) {
//         System.out.println(new Solution().maxCoins(new int[]{1,3,-4}, new int[]{5,0,-5}));
//     }
// }



// class Solution {
//     public long numberOfSubstrings(String s) {
//         long result = 0;
//         Map<Character, List<Integer>> charToIndices = new HashMap<>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (!charToIndices.containsKey(c)) {
//                 charToIndices.put(c, new ArrayList<>());
//             }
//             charToIndices.get(c).add(i);
//         }

//         for (Map.Entry<Character, List<Integer>> entry : charToIndices.entrySet()) {
//             result++;
//             int size = entry.getValue().size();
//             if (size == 1) {
//                 continue;
//             }
//             result += (size * (size-1));
//             result += (size - 1);
//         }
//         return result;
//     }

//     private long comb(int n, int k) {
//         long a = fact(n);
//         long b = fact(2) * fact(n - 2);
//         if (b == 0) {
//             return 1;
//         }
//         return a / b;
//     }

//     private long fact(int num) {
//         long fact = 1;
//         for (long i = num; i >= 1; i--) {
//             fact *= i;
//         }
//         return fact;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().comb(6, 2));
//     }
// }

// class Interval {
//     public int start;
//     public int end;

//     public Interval() {}

//     public Interval(int _start, int _end) {
//         start = _start;
//         end = _end;
//     }
// }

// class Solution {
//     public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
//         List<Interval> result = new ArrayList<>();
//         TreeMap<Integer, Integer> map = buildMap(schedule);
//         int runningSum = 0;
//         boolean isFree = false;
//         int start = -1;
//         int end = -1;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             runningSum += entry.getValue();
//             if (runningSum == 0) {
//                 start = entry.getKey();
//                 isFree = true;
//             }
//             if (runningSum == 1 && isFree) {
//                 end = entry.getKey();
//                 result.add(new Interval(start, end));
//                 isFree = false;
//             }
//         }
//         return result;
//     }

//     private TreeMap<Integer, Integer> buildMap(List<List<Interval>> schedule) {
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for (List<Interval> list : schedule) {
//             for (Interval interval : list) {
//                 if (!map.containsKey(interval.start)) {
//                     map.put(interval.start, 0);
//                 }
//                 map.put(interval.start, map.get(interval.start) + 1);
//                 if (!map.containsKey(interval.end)) {
//                     map.put(interval.end, 0);
//                 }
//                 map.put(interval.end, map.get(interval.end) - 1);
//             }
//         }
//         return map;
//     }
// }

// class Solution {
//     public String betterCompression(String compressed) {
//         TreeMap<Character, Integer> charToFrequency = fillMap(compressed);
//         StringBuilder sb = new StringBuilder();
//         for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
//             sb.append(entry.getKey());
//             sb.append(String.valueOf(entry.getValue()));
//         }
//         return sb.toString();
//     }

//     private TreeMap<Character, Integer> fillMap(String compressed) {
//         TreeMap<Character, Integer> charToFrequency = new TreeMap<>();
//         int index = 0;
//         while (index < compressed.length()) {
//             char c = compressed.charAt(index);
//             index++;

//             int freq = 0;
//             while (index < compressed.length() && Character.getNumericValue(compressed.charAt(index)) < 10) {
//                 freq *= 10;
//                 freq += Character.getNumericValue(compressed.charAt(index)); 
//                 index++;
//             }
            
//             if (!charToFrequency.containsKey(c)) {
//                 charToFrequency.put(c, 0);
//             }
//             charToFrequency.put(c, charToFrequency.get(c) + freq);
//         }
//         return charToFrequency;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().betterCompression("a3c9b2c1"));
//     }
// }

// class Node {
//     public int val;
//     public List<Node> children;
//     public Node() {
//         children = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         children = new ArrayList<Node>();
//     }
//     public Node(int _val,ArrayList<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// }

// class Solution {
//     public Node findRoot(List<Node> tree) {
//         Map<Node, Node> nodeToParent = new HashMap<>();
//         for (Node node : tree) {
//             for (Node child : node.children) {
//                 nodeToParent.put(child, node);
//             }
//         }

//         for (Node node : tree) {
//             if (!nodeToParent.containsKey(node)) {
//                 return node;
//             }
//         }
//         return new Node();
//     }
// }

// class Solution {
//     public List<List<Integer>> findLeaves(TreeNode root) {
//         TreeNode current = root;
//         List<List<Integer>> result = new ArrayList<>();
//         Map<TreeNode, Integer> nodeToLevel = new HashMap<>();
//         int max = fillMap(current, nodeToLevel);
        
//         for (int i = 0; i < max; i++) {
//             result.add(new ArrayList<>());
//         }
//         for (Map.Entry<TreeNode, Integer> entry : nodeToLevel.entrySet()) {
//             result.get(entry.getValue() - 1).add(entry.getKey().val);
//         }
//         return result;
//     }

//     private int fillMap(TreeNode root, Map<TreeNode, Integer> nodeToLevel) {
//         if (root.left == null && root.right == null) {
//             nodeToLevel.put(root, 1);
//             return 1;
//         }
//         int leftLevel = Integer.MAX_VALUE;
//         if (root.left != null) {
//             leftLevel = fillMap(root.left, nodeToLevel);
//         }
//         int rightLevel = Integer.MAX_VALUE;
//         if (root.right != null) {
//             rightLevel = fillMap(root.right, nodeToLevel);
//         }
//         nodeToLevel.put(root, Math.min(leftLevel, rightLevel) + 1);
//         return nodeToLevel.get(root);
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(1, new TreeNode(2), null);
//         System.out.println(new Solution().findLeaves(root));
//     }
// }

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int left = 0;
//         int right = 0;
//         int sum = nums[0];
//         int result = 0;
//         while (left < nums.length) {
//             while (right < nums.length - 1 && sum < k) {
//                 right++;
//                 sum += nums[right];
//             }
            
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().subarraySum(new int[]{1,2,3}, 3));
//         System.out.println(new Solution().subarraySum(new int[]{1,1,1}, 2));
//         System.out.println(new Solution().subarraySum(new int[]{1,-1,0}, 0));
//         System.out.println(new Solution().subarraySum(new int[]{1}, 0));
//     }
// }

// class Solution {
//     public int minMeetingRooms(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for (int[] interval : intervals) {
//             if (!map.containsKey(interval[0])) {
//                 map.put(interval[0], 0);
//             }
//             map.put(interval[0], map.get(interval[0]) + 1);
//             if (!map.containsKey(interval[1])) {
//                 map.put(interval[1], 0);
//             }
//             map.put(interval[1], map.get(interval[1]) - 1);
//         }

//         int runningSum = 0;
//         int minRooms = 0;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             runningSum += entry.getValue();
//             minRooms = Math.max(runningSum, minRooms);
//         }
//         return minRooms;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minMeetingRooms(new int[][]{{5,10},{15,20},{0,30}}));
//         System.out.println(new Solution().minMeetingRooms(new int[][]{{7,10},{2,4}}));
//     }
// }

// class Solution {
//     public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
//         Set<Integer> diffs = new HashSet<>();
//         fillMap(root1, target, diffs);
//         return twoSumHelper(root2, diffs);
//     }

//     private void fillMap(TreeNode root1, int target, Set<Integer> diffs) {
//         if (root1.left != null) {
//             fillMap(root1.left, target, diffs);
//         }
//         diffs.add(target - root1.val);
//         if (root1.right != null) {
//             fillMap(root1.right, target, diffs);
//         }
//     }

//     private boolean twoSumHelper(TreeNode root2, Set<Integer> diffs) {
//         if (diffs.contains(root2.val)) {
//             return true;
//         }
//         boolean isLeft = false;
//         if (root2.left != null) {
//             isLeft = twoSumHelper(root2.left, diffs);
//         }
//         boolean isRight = false;
//         if (root2.right != null) {
//             isRight = twoSumHelper(root2.right, diffs);
//         }
//         return isLeft || isRight;
//     }
// }

// class Solution {
//     public int minCost(int[][] costs) {
//         Integer[][] memo = new Integer[costs[0].length][costs.length];
//         return minCostHelper(costs, 3, 0, memo);
//     }

//     private int minCostHelper(int[][] costs, int prevColor, int house, Integer[][] memo) {
//         if (house >= costs.length) {
//             return 0;
//         }
//         if (house != 0 && memo[prevColor][house] != null) {
//             return memo[prevColor][house];
//         }
//         int minCost = Integer.MAX_VALUE;
//         if (prevColor != 0) {
//             minCost = Math.min(costs[house][0] + minCostHelper(costs, 0, house + 1, memo), minCost);
//         }
//         if (prevColor != 1) {
//             minCost = Math.min(costs[house][1] + minCostHelper(costs, 1, house + 1, memo), minCost);
//         }
//         if (prevColor != 2) {
//             minCost = Math.min(costs[house][2] + minCostHelper(costs, 2, house + 1, memo), minCost);
//         }
//         if (prevColor != 3) {
//             memo[prevColor][house] = minCost;
//         }
//         return minCost;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
//     }
// }

// class MRUQueue {
//     private int[] nums;
//     public MRUQueue(int n) {
//         nums = new int[n];
//         for (int i = 1; i <= n; i++) {
//             nums[i - 1] = i;
//         }
//     }
    
//     public int fetch(int k) {
//         int num = nums[k - 1];
//         for (int i = k; i < nums.length; i++) {
//             nums[i - 1] = nums[i];
//         }
//         nums[nums.length - 1] = num;
//         return num;
//     }
// }

// class Codec {

//     // Encodes a list of strings to a single string.
//     public String encode(List<String> strs) {
//         StringBuilder sb = new StringBuilder();
//         for (String str : strs) {
//             sb.append(str.length());
//             sb.append('.');
//             sb.append(str);
//         }
//         return sb.toString();
//     }
//     //5.Hello5.World

//     // Decodes a single string to a list of strings.
//     public List<String> decode(String s) {
//         List<String> result = new ArrayList<>();
//         int index = 0;
//         while (index < s.length()) {
//             int length = 0;
//             while (index < s.length() && s.charAt(index) != '.') {
//                 char c = s.charAt(index++);
//                 length *= 10;
//                 length += Character.getNumericValue(c);
//             }
//             index++;

//             StringBuilder sb = new StringBuilder();
//             while (length != 0) {
//                 sb.append(s.charAt(index++));
//                 length--;
//             }
//             result.add(sb.toString());
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Codec().encode(Arrays.asList("Hello","World")));
//         List<String> strs = new Codec().decode("5.Hello5.World");
//         for (String str : strs) {
//             System.out.println(str);
//         }
//     }
// }


// class HitCounter {
//     private Queue<Integer> queue = new LinkedList<>();

//     public HitCounter() {
        
//     }
    
//     public void hit(int timestamp) {
//         queue.add(timestamp);
//     }
    
//     public int getHits(int timestamp) {
//         while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
//             queue.poll();
//         }
//         return queue.size();
//     }

//     public static void main(String[] args) {
//         HitCounter hc = new HitCounter();
//         hc.hit(1);
//         hc.hit(300);
//         System.out.println(hc.getHits(300));
//         System.out.println(hc.getHits(301));
//     }
// }

// class Solution {
//     private int n;
//     private Set<Integer> islandCells = new HashSet<>();
//     private Map<Integer, Integer> cellToIslandId = new HashMap<>();
//     private Map<Integer, Integer> islandIdToSize = new HashMap<>();
//     private static final int[][] NEIGHBORS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

//     public int largestIsland(int[][] grid) {
//         n = grid.length;
//         getIslands(grid);
//         if (islandCells.size() == n * n ) {
//             return islandCells.size();
//         }

//         int maxArea = 0;
//         for (int pos = 0; pos < (n * n); pos++) {
//             int row = pos / n;
//             int col = pos % n;
//             if (grid[row][col] == 0) {
//                 int newArea = getNewArea(grid, row, col);
//                 maxArea = Math.max(maxArea, newArea);
//             }
//         }
//         return maxArea;
//     }

//     private void getIslands(int[][] grid) {
//         Set<Integer> visited = new HashSet<>();
//         int id = 0;
//         for (int row = 0; row < n; row++) {
//             for (int col = 0; col < n; col++) {
//                 if (visited.contains(row * n + col) || grid[row][col] == 0) {
//                     continue;
//                 }
//                 Set<Integer> cells = new HashSet<>();
//                 dfs(grid, row, col, cells);
//                 islandIdToSize.put(id, cells.size());
//                 for (int cell : cells) {
//                     islandCells.add(cell);
//                     cellToIslandId.put(cell, id);
//                     visited.add(cell);
//                 }
//                 id++;
//             }
//         }
//     }

//     private void dfs(int[][] grid, int row, int col, Set<Integer> cells) {
//         if (row < 0 || row >= n || col < 0 || col >= n) {
//             return;
//         }
//         if (grid[row][col] == 0 || cells.contains(row * n + col)) {
//             return;
//         }
//         cells.add(row * n + col);
//         for (int[] neighbor : NEIGHBORS) {
//             dfs(grid, row + neighbor[0], col + neighbor[1], cells);
//         }
//     }

//     private int getNewArea(int[][] grid, int row, int col) {
//         int area = 1;
//         Set<Integer> visitedIslands = new HashSet<>();
//         for (int[] neighbor : NEIGHBORS) {
//             int neighborRow = row + neighbor[0];
//             int neighborCol = col + neighbor[1];
//             if (neighborRow < 0 || neighborRow >= n || 
//                 neighborCol < 0 || neighborCol >= n ||
//                 grid[neighborRow][neighborCol] == 0 ||
//                 visitedIslands.contains(cellToIslandId.get(neighborRow * n + neighborCol))) {
//                 continue;
//             }
//             int currentId = cellToIslandId.get(neighborRow * n + neighborCol);
//             visitedIslands.add(currentId);
//             area += islandIdToSize.get(currentId);
//         }   
//         return area;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().largestIsland(new int[][]{{1,0},{0,1}}));
//         System.out.println(new Solution().largestIsland(new int[][]{{1,1},{1,0}}));
//         System.out.println(new Solution().largestIsland(new int[][]{{1,1},{1,1}}));
//     }
// }

// class Solution {
//     public int findTheWinner(int n, int k) {
//         List<Integer> players = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             players.add(i);
//         }

//         int index = 0;
//         while (players.size() != 1) {
//             index += (k - 1);
//             index %= players.size();
//             players.remove(index);
//         }
//         return players.get(0);
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findTheWinner(5, 2));
//         System.out.println(new Solution().findTheWinner(6, 5));
//     }
// }

// class Solution {
//     public int integerReplacement(int n) {
//         long num = (long) n;
//         return integerReplacement(num);
//     }

//     public int integerReplacement(long n) {
//         if (n == 1) {
//             return 0;
//         }
//         int result = 0;
//         if (n % 2 == 0) {
//             result += 1 + integerReplacement(n / 2);
//         } else {
//             int inc = integerReplacement(n + 1);
//             int dec = integerReplacement(n - 1);
//             result += 1 + Math.min(inc, dec);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(Integer.MAX_VALUE);
//         System.out.println(new Solution().integerReplacement(2147483647));
//     }
// }

// class Solution {
//     public int maxIceCream(int[] costs, int coins) {
//         Arrays.sort(costs);
//         int max = 0;
//         for (int cost : costs) {
//             if (cost > coins) {
//                 return max;
//             }
//             coins -= cost;
//             max++;
//         }
//         return max;
//     }
// }

// class Solution {
//     public int totalNQueens(int n) {
//         return nQueensHelper(n, 0, n * n - 1, new HashSet<>());
//     }

//     private int nQueensHelper(int queens, int current, int maxPos, Set<Integer> positions) {
//         if (positions.size() == queens) {
//             return 1;
//         }
//         if (current > maxPos) {
//             return 0;
//         }
//         int result = 0;
//         if (isValid(queens, current, positions)) {
//             positions.add(current);
//             result += nQueensHelper(queens, current + 1, maxPos, positions);
//             positions.remove(current);
//         } 
//         return result + nQueensHelper(queens, current + 1, maxPos, positions);
//     }

//     private boolean isValid(int side, int current, Set<Integer> positions) {
//         int row = current / side;
//         int col = current % side;
//         if (positions.size() == 0) {
//             return true;
//         }
//         for (int c = 0; c < side; c++) {
//             if (positions.contains(row * side + c)) {
//                 return false;
//             }
//         }
//         for (int r = 0; r < side; r++) {
//             if (positions.contains(r * side + col)) {
//                 return false;
//             }
//         }

//         int r = row;
//         int c = col;
//         while (r >= 0 && r < side && c >= 0 && c < side) {
//             if (positions.contains(r * side + c)) {
//                 return false;
//             }
//             r--; 
//             c--;
//         }
//         r = row;
//         c = col;
//         while (r >= 0 && r < side && c >= 0 && c < side) {
//             if (positions.contains(r * side + c)) {
//                 return false;
//             }
//             r--; 
//             c++;
//         }
//         r = row;
//         c = col;
//         while (r >= 0 && r < side && c >= 0 && c < side) {
//             if (positions.contains(r * side + c)) {
//                 return false;
//             }
//             r++; 
//             c--;
//         }
//         r = row;
//         c = col;
//         while (r >= 0 && r < side && c >= 0 && c < side) {
//             if (positions.contains(r * side + c)) {
//                 return false;
//             }
//             r++; 
//             c++;
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().totalNQueens(1));
//         System.out.println(new Solution().totalNQueens(2));
//         System.out.println(new Solution().totalNQueens(4));
//     }
// }


// class CountIntervals {
//     TreeMap<Integer, Integer> map = new TreeMap<>();
    
//     public CountIntervals() {
        
//     }
    
//     public void add(int left, int right) {
//         if (!map.containsKey(left)) {
//             map.put(left, 0);
//         }
//         map.put(left, map.get(left) + 1);
//         if (!map.containsKey(right + 1)) {
//             map.put(right + 1, 0);
//         }
//         map.put(right + 1, map.get(right + 1) - 1);
//     }

//     public int count() {
//         int count = 0;
//         Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//         if (!it.hasNext()) {
//             return 0;
//         }
//         Map.Entry<Integer, Integer> first = it.next();
//         int left = first.getKey();
//         int runningSum = first.getValue();
//         while(it.hasNext()){
//             Map.Entry<Integer, Integer> next = it.next();
//             if (runningSum == 0 && next.getValue() == 1) {
//                 left = next.getKey();
//             } 
//             runningSum += next.getValue();
//             if (runningSum == 0 || !it.hasNext()) {
//                 count += next.getKey() - left;
//                 runningSum = 0;
//             }
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         CountIntervals ci = new CountIntervals();
//         ci.add(2, 3);
//         ci.add(7, 10);
//         System.out.println(ci.count());
//         ci.add(5, 8);
//         System.out.println(ci.count());
//     }
// }


// class MyCoolCal {
// private TreeMap<Integer, Integer> bookings = new TreeMap<>();

//     public MyCoolCal() {
        
//     }
//     public int countMeetings(int time) {
        
//     }
//     public void book(int startTime, int endTime) {
//         bookings.tailMap(null, false)
//     }
// }


// class MyCalendarTwo {
// private TreeMap<Integer, Integer> bookings = new TreeMap<>();

//     public MyCalendarTwo() {
        
//     }
    
//     public boolean book(int startTime, int endTime) {
//         if (!bookings.containsKey(startTime)) {
//             bookings.put(startTime, 0);
//         }
//         bookings.put(startTime, bookings.get(startTime) + 1);
//         if (!bookings.containsKey(endTime)) {
//             bookings.put(endTime, 0);
//         }
//         bookings.put(endTime, bookings.get(endTime) - 1);

//         if (isTriplyBooked(startTime, endTime)) {
//             bookings.put(startTime, bookings.get(startTime) - 1);
//             bookings.put(endTime, bookings.get(endTime) + 1);
//             return false;
//         }
//         return true;
//     }

//     private boolean isTriplyBooked(int startTime, int endTime) {
//         int runningSum = 0;
//         for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
//             runningSum += entry.getValue();
//             if (runningSum >= 3) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// class MyCalendarThree {
//     private TreeMap<Integer, Integer> bookings = new TreeMap<>();
//     public MyCalendarThree() {
        
//     }
    
//     public int book(int startTime, int endTime) {
//         if (!bookings.containsKey(startTime)) {
//             bookings.put(startTime, 0);
//         }
//         bookings.put(startTime, bookings.get(startTime) + 1);
//         if (!bookings.containsKey(endTime)) {
//             bookings.put(endTime, 0);
//         }
//         bookings.put(endTime, bookings.get(endTime) - 1);

//         return kBooking(startTime, endTime);
//     }

//     private int kBooking(int startTime, int endTime) {
//         int runningSum = 0;
//         int max = 0;
//         for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
//             runningSum += entry.getValue();
//             max = Math.max(runningSum, max);
//         }
//         return max;
//     }

//     public static void main(String[] args) {
//         MyCalendarTwo calendar = new MyCalendarTwo();
//         System.out.println(calendar.book(10, 20));
//         System.out.println(calendar.book(50, 60));
//         System.out.println(calendar.book(10, 40));
//         System.out.println(calendar.book(5, 15));
//     }
// }

// class Solution {
//     public int longestSubarray(int[] nums) {
//         List<Integer> freqList = buildFreqList(nums);
//         int result = Integer.MIN_VALUE;
//         for (int i = 0; i < freqList.size(); i++) {
//             if (freqList.get(i) != 0) {
//                 continue;
//             }
//             int left = 0;
//             if (i > 0) {
//                 left = freqList.get(i - 1);
//             }
//             int right = 0;
//             if (i < freqList.size() - 1) {
//                 right = freqList.get(i + 1);
//             }
//             result = Math.max(result, left + right);
//         }

//         if (result == Integer.MIN_VALUE) {
//             return nums.length - 1;
//         }
//         return result;
//     }

//     private List<Integer> buildFreqList(int[] nums) {
//         List<Integer> list = new ArrayList<>();
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {
//                 if (count > 0) {
//                     list.add(count);
//                     count = 0;
//                 }
//                 list.add(0);
//             } else {
//                 count++;
//             }
//         }
//         if (count > 0) {
//             list.add(count);
//         }
//         return list;
//     }

//     public static void main(String[] args) {
//         new Solution().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1});
//     }
// }

// class Solution {
//     public long getDescentPeriods(int[] prices) {
//         long result = 0;
//         int index = 0;
//         int start = 0;
//         while (index < prices.length) {
//             while (index < prices.length - 1 && prices[index] - 1 == prices[index + 1]) {
//                 index++;
//             }
//             index++;
//             result += findPowerSets(start, index);
//             start = index;
//         }
//         return result;
//     }

//     private long findPowerSets(int start, int end) {
//         int length = end - start;
//         long result = (long) Math.pow((double) length, 2) + length;
//         return (long) result / 2;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().getDescentPeriods(new int[]{5,3,2,1,4}));
//         System.out.println(new Solution().getDescentPeriods(new int[]{5,2,1,4,3,2,1,6}));
//         System.out.println(new Solution().getDescentPeriods(new int[]{8,6,7,7}));
//         // 8
//         // 15
//         // 4
//     }
// }

// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         List<Integer> safeNodes = new ArrayList<>();
//         List<List<Integer>> adjList = buildAdjList(graph);
//         int[] inDegrees = new int[graph.length];
//         Queue<Integer> queue = new LinkedList<>();

//         for (int index = 0; index < graph.length; index++) {
//             int[] node = graph[index];
//             inDegrees[index] = node.length;
//             if (node.length == 0) {
//                 safeNodes.add(index);
//                 queue.add(index);
//             }
//         }

//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             List<Integer> neighbors = adjList.get(current);
//             for (int neighbor : neighbors) {
//                 inDegrees[neighbor]--;
//                 if (inDegrees[neighbor] == 0) {
//                     safeNodes.add(neighbor);
//                     queue.add(neighbor);
//                 }
//             }
//         }
//         Collections.sort(safeNodes);
//         return safeNodes;
//     }

//     private List<List<Integer>> buildAdjList (int[][] graph) {
//         List<List<Integer>> result = new ArrayList<>();
//         for (int i = 0; i < graph.length; i++) {
//             result.add(new ArrayList<>());
//         }

//         for (int index = 0; index < graph.length; index++) {
//             int[] node = graph[index];
//             for (int neighbor : node) {
//                 result.get(neighbor).add(index);
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
//     }
// }

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         Integer[][] memo = new Integer[text1.length()][text2.length()];
//         return subsequenceHelper(text1, text2, 0, 0, memo);
//     }

//     private int subsequenceHelper(String text1, String text2, int index1, int index2, Integer[][] memo) {
//         if (index1 >= text1.length() || index2 >= text2.length()) {
//             return 0;
//         }
//         if (memo[index1][index2] != null) {
//             return memo[index1][index2];
//         }
//         if (text1.charAt(index1) == text2.charAt(index2)) {
//             return 1 + subsequenceHelper(text1, text2, index1 + 1, index2 + 1, memo);
//         }
//         int moveIndex1 = subsequenceHelper(text1, text2, index1 + 1, index2, memo);
//         int moveIndex2 = subsequenceHelper(text1, text2, index1, index2 + 1, memo);
//         int max = Math.max(moveIndex1, moveIndex2);
//         memo[index1][index2] = max;
//         return max;
//     }
// }

//class Solution {
//     public int mincostTickets(int[] days, int[] costs) {
//         Integer[] memo = new Integer[days.length];
//         return cost(days, costs, 0, memo);
//     }

//     private int cost(int[] days, int[] costs, int daysIndex, Integer[] memo) {
//         if (daysIndex >= days.length) {
//             return 0;
//         }
//         if (memo[daysIndex] != null) {
//             return memo[daysIndex];
//         }
//         int cost1 = costs[0] + cost(days, costs, moveDaysIndex(days, daysIndex, 1), memo);
//         int cost2 = costs[1] + cost(days, costs, moveDaysIndex(days, daysIndex, 7), memo);
//         int cost3 = costs[2] + cost(days, costs, moveDaysIndex(days, daysIndex, 30), memo);
//         int min = Math.min(Math.min(cost1, cost2), cost3);
//         memo[daysIndex] = min;
//         return memo[daysIndex];
//     }

//     private int moveDaysIndex(int[] days, int dayIndex, int pass) {
//         int startDay = days[dayIndex];
//         int endDay = startDay + pass;
//         int current = dayIndex;
//         while (current < days.length && days[current] < endDay) {
//             current++;
//         }
//         return current;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
//         System.out.println(new Solution().mincostTickets(new int[]{6,8,9,18,20,21,23,25}, new int[]{2,10,41}));
//         System.out.println(new Solution().mincostTickets(new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28}, new int[]{3,13,45}));
//         // ex ou
//         // 11 11
//         // 16 16
//         // 44 45
//     }
// }

// class Solution {
//     public int partitionString(String s) {
//         int index = 0;
//         int result = 0;
//         while (index < s.length()) {
//             Set<Character> set = new HashSet<>();
//             while (index < s.length() && set.add(s.charAt(index))) {
//                 index++;
//             }
//             result++;
//         }
//         return result;
//     }
// }

// class FrontMiddleBackQueue {
//     private Deque<Integer> left = new ArrayDeque<>();
//     private Deque<Integer> right = new ArrayDeque<>();
    
//     public FrontMiddleBackQueue() {
        
//     }
    
//     public void pushFront(int val) {
//         left.addFirst(val);
//         balanceDequeues();
//     }
    
//     public void pushMiddle(int val) {
//         if (left.size() - right.size() > 0) {
//             right.addFirst(left.removeLast());
//         }
//         left.addLast(val);
//     }
    
//     public void pushBack(int val) {
//         right.addLast(val);
//         balanceDequeues();
//     }
    
//     public int popFront() {
//         if (left.isEmpty()) {
//             return -1;
//         }
//         int front = left.removeFirst();
//         balanceDequeues();
//         return front;
//     }
    
//     public int popMiddle() {
//         if (left.isEmpty() && right.isEmpty()) {
//             return -1;
//         }
//         int middle = left.removeLast();
//         balanceDequeues();
//         return middle;
//     }
    
//     public int popBack() {
//         if (left.isEmpty()) {
//             return -1;
//         }
//         if (right.isEmpty()) {
//             return left.removeLast();
//         }
//         int last = right.removeLast();
//         balanceDequeues();
//         return last;
//     }

//     private void balanceDequeues() {
//         if (left.size() - right.size() < 0) {
//             int middle = right.removeFirst();
//             left.addLast(middle);
//         } else if (left.size() - right.size() > 1){
//             int middle = left.removeLast();
//             right.addFirst(middle);
//         }
//     }

//     public static void main(String[] args) {
//         FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
//         queue.pushFront(1);
//         queue.pushBack(2);
//         queue.pushMiddle(3);
//         queue.pushMiddle(4);
//         queue.popFront();
//     }
// }

// class Solution {
//     class Log {
//         int id;
//         int start;
//         int end;
//         int duration = 0;
//         public Log(int id, int start) {
//             this.id = id;
//             this.start = start;
//         }
//     }
//     public int[] exclusiveTime(int n, List<String> logs) {
//         int[] result = new int[n];
//         Stack<Log> stack = new Stack<>();
//         for (String log : logs) {
//             String[] data = decode(log);

//             if (data[1].equals("start")) {
//                 if (!stack.isEmpty()) {
//                     Log previous = stack.peek();
//                     previous.end = Integer.parseInt(data[2]);
//                     previous.duration += (previous.end - previous.start - 1);
//                 }
//                 stack.add(new Log(Integer.parseInt(data[0]), Integer.parseInt(data[2])));
//             } else {
//                 Log current = stack.pop();
//                 if (!stack.isEmpty()) {
//                     Log previous = stack.peek();
//                     previous.start = Integer.parseInt(data[2]);
//                 }
//                 current.end = Integer.parseInt(data[2]);
//                 current.duration = current.end - current.start + 1;
//                 result[Integer.parseInt(data[0])] += current.duration;
//             }
//         }
//         return result;
//     }

//     private String[] decode(String log) {
//         int index = 0;
//         int arrayIndex = 0;
//         String[] decode = new String[3];
//         while (index < log.length()) {
//             StringBuilder sb = new StringBuilder();
//             while (index < log.length() && log.charAt(index) != ':') {
//                 sb.append(log.charAt(index));
//                 index++;
//             }
//             decode[arrayIndex++] = sb.toString();
//             index++;
//         }
//         return decode;
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(new Solution().exclusiveTime(2,Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"))));
//         System.out.println(Arrays.toString(new Solution().exclusiveTime(1, Arrays.asList("0:start:0","0:end:1"))));
//     }
// }

// class Solution {
//     public int totalFruit2(int[] fruits) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int max = 0;
//         int left = 0;
//         int right = 0;
//         while (right < fruits.length) {
//             if (map.size() < 2) {
//                 if (!map.containsKey(fruits[right])) {
//                     map.put(fruits[right], 0);
//                 }
//                 map.put(fruits[right], map.get(fruits[right]) + 1);
//                 right++;
//             } else if (map.size() == 2){
//                 if (!map.containsKey(fruits[right])) {
//                     max = Math.max(max, right - left);
//                     map.put(fruits[right],1);
//                 } else {
//                     right++;
//                     map.put(fruits[right], map.get(fruits[right]) + 1);
//                 }
//             } else {
//                 if (map.get(fruits[left]) == 1) {
//                     map.remove(fruits[left]);
//                 } else {
//                     map.put(fruits[left], map.get(fruits[left]) - 1);
//                 }
//                 left++;
//             }
//         }
//         max = Math.max(max, right - left);
//         return max;
//     }

//     public int totalFruit(int[] fruits) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int max = 0;
//         int left = 0;
//         int right = 0;
//         while (right < fruits.length) {
//             int fruit = fruits[right];
//             if (map.size() == 2 && !map.containsKey(fruit)) {
//                 while (left < right && map.size() == 2) {
//                     if (map.get(fruits[left]) == 1) {
//                         map.remove(fruits[left]);
//                     } else {
//                         map.put(fruits[left], map.get(fruits[left]) - 1);
//                     }
//                     left++;
//                 }
//             }
//             if (!map.containsKey(fruit)) {
//                 map.put(fruit, 0);
//             }
//             map.put(fruit, map.get(fruit) + 1);
//             right++;
//             max = Math.max(max, right - left);
//         }
//         //max = Math.max(max, right - left);
//         return max;
//     }
//     public static void main(String[] args) {
//         System.out.println(new Solution().totalFruit(new int[]{1,2,3,2,2}));
//         System.out.println(new Solution().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
//     }
// }

// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<String> stack = new Stack<>();
//         for (String token : tokens) {
//             if (token.length() > 1 || Character.getNumericValue(token.charAt(0)) != -1) {
//                 stack.add(token);
//                 continue;
//             }
//             String second = stack.pop();
//             String first = stack.pop();
//             String result = evaluate(first, second, token);
//             stack.add(result);
//         }
//         return Integer.parseInt(stack.pop());
//     }

//     private String evaluate(String first, String second, String token) {
//         int op1 = Integer.parseInt(first);
//         int op2 = Integer.parseInt(second);
//         int result = 0;
//         if (token.equals("+")) {
//             result = op1 + op2;
//         } else if (token.equals("-")) {
//             result = op1 - op2;
//         } else if (token.equals("*")) {
//             result = op1 * op2;
//         } else if (token.equals("/")) {
//             result = op1 / op2;
//         } 
//         return String.valueOf(result);
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().evalRPN(new String[]{"2","1","+","3","*"}));
//     }
// }

// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         map.put(-1, 0);
//         for (int i = 0; i < nums.length; i++) {
//             if (!map.containsKey(nums[i])) {
//                 map.put(nums[i], 0);
//             }
//             map.put(nums[i], map.get(nums[i]) + 1);
//         }
//         for (int i : map.keySet()) {
//             if (map.floorKey(i - 1) == null) {
//                 continue;
//             }
//             map.put(i, map.get(map.floorKey(i - 1)) + map.get(i));
//         }
//         for (int i = 0; i < nums.length; i++) {
//             nums[i] = map.get(map.floorKey(nums[i] - 1));
//         }
//         return nums;
//     }

//     public static void main(String[] args) {
//         String s = "*";
//         int a = 127;
//         System.out.println(String.);
//     }
// }

// class Solution {
//     public int[] shuffle(int[] nums, int n) {
//         int[] xcoords = new int[n];
//         for (int i = 1; i < n; i++) {
//             xcoords[i] = nums[i];
//         }
//         int j = 1;
//         for (int i = 1; i < nums.length - 1; i += 2) {
//             nums[i] = nums[j + n - 1];
//             nums[i + 1] = xcoords[j];
//             j++;
//         }
//         return nums;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().shuffle(new int[]{2,5,1,3,4,7}, 3));
//     }
// }

// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;

    
//     public Node() {
//         this.val = false;
//         this.isLeaf = false;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = topLeft;
//         this.topRight = topRight;
//         this.bottomLeft = bottomLeft;
//         this.bottomRight = bottomRight;
//     }
// }

// class Solution {
//     public Node construct(int[][] grid) {
//         if (grid.length == 1) {
//             return new Node(true, true);
//         }
//         return constructHelper(grid, 0, (grid.length * grid.length) - 1);
//     }

//     private Node constructHelper(int[][] grid, int up, int down) {
//         if (up > down) {
//             return null;
//         }
//         if (up == down || isLeaf(grid, up, down)) {
//             return new Node(grid[up / grid.length][up % grid.length] == 1, true);
//         }
//         Node root = new Node(true, false);
//         int[][] fourLeaves = getFourLeaves(grid, up, down);
//         root.topLeft = constructHelper(grid, fourLeaves[0][0], fourLeaves[0][1]);
//         root.topRight = constructHelper(grid, fourLeaves[1][0], fourLeaves[1][1]);
//         root.bottomLeft = constructHelper(grid, fourLeaves[2][0], fourLeaves[2][1]);
//         root.bottomRight = constructHelper(grid, fourLeaves[3][0], fourLeaves[3][1]);
//         return root;
//     }

//     private boolean isLeaf(int[][] grid, int up, int down){
//         int value = grid[up / grid.length][up % grid.length];
//         int row = up / grid.length;
//         int col = down / grid.length;
//         int left = up % grid.length;
//         int right = down % grid.length;
//         for (int y = row; y <= col; y++) {
//             for (int x = left; x <= right; x++) {
//                 if (grid[y][x] != value) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     private int[][] getFourLeaves(int[][] grid, int up, int down) {
//         int side = down / grid.length - up / grid.length + 1;
//         int length = grid.length;
//         int[][] fourLeaves = new int[][]{
//             {up, (((down / length) - (side / 2)) * length) + (down % length) - (side / 2)},
//             {up + (side / 2), (((down / length) - (side / 2)) * length) + (down % length)},
//             {((up / length) + (side / 2)) * length + (up % length), down - (side / 2)},
//             {((up / length) + (side / 2)) * length + (up % length) + (side / 2), down}
//         };
//         return fourLeaves;
//     }

//     public static void main(String[] args) {
//         new Solution().construct(new int[][]{{0,0,0,0},{0,0,1,0},{1,1,1,1},{0,1,1,1}});
//     }
// }

// class Solution {
    // private List<TreeNode> deepestNodes = new ArrayList<>();
    // private Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
    // private Map<Integer, List<TreeNode>> levelToNode = new HashMap<>();

    // public TreeNode subtreeWithAllDeepest(TreeNode root) {
    //     fillDeepestNodes(root, 0);
    //     int max = 0;
    //     for (int level : levelToNode.keySet()) {
    //         max = Math.max(max, level);
    //     }
    //     deepestNodes = levelToNode.get(max);
    //     return findLCA();
    // }

    // private void fillDeepestNodes(TreeNode current, int level) {
    //     if (current.left == null && current.right == null) {
    //         if (!levelToNode.containsKey(level)) {
    //             levelToNode.put(level, new ArrayList<>());
    //         }
    //         levelToNode.get(level).add(current);
    //         return;
    //     }
    //     if (current.left != null) {
    //         nodeToParent.put(current.left, current);
    //         fillDeepestNodes(current.left, level + 1);
    //     }
    //     if (current.right != null) {
    //         nodeToParent.put(current.right, current);
    //         fillDeepestNodes(current.right, level + 1);
    //     }
    // }

    // private TreeNode findLCA() {
    //     TreeNode ancestor = deepestNodes.get(0);
    //     if (deepestNodes.size() == 1) {
    //         return ancestor;
    //     }
    //     for (int i = 1; i < deepestNodes.size(); i++) {
    //         deepestNodes.set(i, findLCAHelper(ancestor, deepestNodes.get(i)));
    //     }
    //     return deepestNodes.get(deepestNodes.size() - 1);
    // }

    // private TreeNode findLCAHelper(TreeNode first, TreeNode second) {
    //     Set<TreeNode> firstParents = new HashSet<>();
    //     while (first != null) {
    //         firstParents.add(first);
    //         first = nodeToParent.get(first);
    //     }
    //     while (!firstParents.contains(second)) {
    //         second = nodeToParent.get(second);
    //     }
    //     return second;
    // }

//     public static void main(String[] args) {
//         TreeNode left = new TreeNode(1);
//         TreeNode right = new TreeNode(3);
//         left.right = new TreeNode(2);
//         TreeNode root = new TreeNode(0, left, right);
        
//         System.out.println(new Solution().subtreeWithAllDeepest(root).val);
//     }
// }


// class Solution {
//     public int countCompleteSubarrays(int[] nums) {
//         int result = 0;
//         Set<Integer> originalSet = new HashSet<>();
//         for (int i = 0; i < nums.length; i++) {
//             originalSet.add(nums[i]);
//         }

//         Map<Integer, Integer> map = new HashMap<>();
//         int left = 0;
//         int right = 0;
//         while (right < nums.length) {
//             while (map.size() == originalSet.size()) {
//                 result += nums.length - right;
//                 if (map.get(nums[left]) == 1) {
//                     map.remove(nums[left]);
//                 } else {
//                     map.put(nums[left], map.get(nums[left] - 1));
//                 }
//                 left++;
//             } 
//             if (!map.containsKey(nums[right])) {
//                 map.put(nums[right], 0);
//             }
//             map.put(nums[right], map.get(nums[right]) + 1);
//             right++;
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().countCompleteSubarrays(new int[]{1,3,1,2,2}));
//         System.out.println(new Solution().countCompleteSubarrays(new int[]{5,5,5,5}));
//         System.out.println(new Solution().countCompleteSubarrays(new int[]{381,1304,381,758,1304,381,758}));
//         // 4 10 14
//     }
// }


// class Solution {
//     private static final int[][] DELTAS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//         int height = grid.size();
//         int length = grid.get(0).size();

//         int[] healthLevels = new int[length * height];
//         Arrays.fill(healthLevels, Integer.MAX_VALUE);
//         healthLevels[0] = getWeight(grid, 0, length);

//         PriorityQueue<Integer> positionQueue = new PriorityQueue<>(
//             (a, b) -> Integer.compare(healthLevels[a], healthLevels[b])
//         );
//         positionQueue.add(0);

//         while (!positionQueue.isEmpty()) {
//             int position = positionQueue.poll();
//             if (healthLevels[position] == Integer.MAX_VALUE) {
//                 continue;
//             }
//             int row = position / length;
//             int col = position % length;

//             for (int[] delta : DELTAS) {
//                 int neighborRow = row + delta[0];
//                 int neighborCol = col + delta[1];
//                 if (neighborRow < 0 || neighborRow >= height ||
//                     neighborCol < 0 || neighborCol >= length) {
//                     continue;
//                 }

//                 int neighbor = neighborRow * length + neighborCol;
//                 int neighborWeight = grid.get(neighborRow).get(neighborCol);
//                 int newCost = healthLevels[position] + neighborWeight;
//                 if (newCost < healthLevels[neighbor]) {
//                     healthLevels[neighbor] = newCost;
//                     positionQueue.add(neighbor);
//                 }
//             }
//         }
//         return healthLevels[height * length - 1] < health;
//     }

//     private int getWeight(List<List<Integer>> grid, int pos, int length) {
//         int row = pos / length;
//         int col = pos % length;
//         return grid.get(row).get(col);
//     }
// }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// class Solution {
//     public TreeNode addOneRow(TreeNode root, int val, int depth) {
//         if (depth == 1) {
//             TreeNode newRoot = new TreeNode(val, root, null);
//             return newRoot;
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         int level = 1;
//         queue.add(root);

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (size > 0) {
//                 TreeNode current = queue.poll();
//                 if (level == depth - 1) {
//                     TreeNode left = current.left;
//                     TreeNode right = current.right;
//                     current.left = new TreeNode(val, left, null);
//                     current.right = new TreeNode(val, null, right);
//                 }
//                 if (current.left != null) {
//                     queue.add(current.left);
//                 }
//                 if (current.right != null) {
//                     queue.add(current.right);
//                 }
//                 size--;
//             }
//             level++;
//         }
//         return root;
//     }
// }

// class Solution {
//     public String removeOccurrences(String s, String part) {
//         Stack<Character> stack = new Stack<>();
//         int index = 0;
//         while (index < s.length()) {
//             stack.add(s.charAt(index));
//             if (stack.peek() == part.charAt(part.length() - 1)) {
//                 Stack<Character> occurrence = new Stack<>();
//                 int currentIndex = part.length() - 1;
//                 while (!stack.isEmpty() && currentIndex >= 0 && stack.peek() == part.charAt(currentIndex)) {
//                     occurrence.add(stack.pop());
//                     currentIndex--;
//                 }
//                 if (currentIndex >= 0) {
//                     while (!occurrence.isEmpty()) {
//                         stack.add(occurrence.pop());
//                     }
//                 }
//             }
//             index++;
//         }

//         StringBuilder sb = new StringBuilder();
//         while (!stack.isEmpty()) {
//             sb.append(stack.pop());
//         }
//         return sb.reverse().toString();
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().removeOccurrences("axxxxyyyyb", "xy"));
//     }
// }

// class Solution {
//     private static final int[][] DELTAS = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

//     public int numEnclaves(int[][] grid) {
//         int numEnclaves = 0;
//         Set<String> visitedCells = new HashSet<>();
//         for (int row = 0; row < grid.length; row++) {
//             for (int col = 0; col < grid[0].length; col++) {
//                 String key = toKey(row, col);
//                 if (grid[row][col] == 1 && !visitedCells.contains(key)) {
//                     int cellCount = bfs(grid, row, col, visitedCells);
//                     numEnclaves += cellCount;
//                 }
//             }
//         }
//         return numEnclaves;
//     }

//     private int bfs(int[][] grid, int row, int col, Set<String> visitedCells) {
//         Queue<String> queue = new LinkedList<>();
//         boolean isEnclaved = true;
//         int cellCount = 1;
//         String position = toKey(row, col);
//         queue.add(position);
//         visitedCells.add(position);

//         while (!queue.isEmpty()) {
//             String current = queue.poll();
//             int currentRow = Integer.parseInt(current.substring(0, 3));
//             int currentCol = Integer.parseInt(current.substring(4, 7));
//             if (isEdge(grid, currentRow, currentCol)) {
//                 isEnclaved = false;
//             }

//             for (int[] delta : DELTAS) {
//                 int nextRow = currentRow + delta[0];
//                 int nextCol = currentCol + delta[1];
//                 String neighbor = toKey(nextRow, nextCol);
//                 if (isInsideGrid(grid, nextRow, nextCol) && grid[nextRow][nextCol] == 1 && !visitedCells.contains(neighbor)) {
//                     cellCount++;
//                     visitedCells.add(neighbor);
//                     queue.add(neighbor);
//                 }
//             }
//         }

//         if (isEnclaved) {
//             return cellCount;
//         }
//         return 0;
//     }

//     private String toKey(int row, int col) {
//         return String.format("%03d,%03d", row, col);
//     }

//     private boolean isInsideGrid(int[][] grid, int row, int col) {
//         if (row >= 0 && row < grid.length) {
//             if (col >= 0 && col < grid[0].length) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean isEdge(int[][] grid, int row, int col) {
//         return row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().numEnclaves(
//             new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}
//         ));
//     }
// }

// class Solution {
//     public List<Integer> pancakeSort(int[] arr) {
//         List<Integer> pancakeSort = new ArrayList<>();
//         if (arr.length == 0 || arr.length == 1) {
//             return pancakeSort;
//         }

//         int num = arr.length;
//         while (num > 1) {
//             int largestIndex = findLargestIndex(arr, num);
//             if (largestIndex != num) {
//                 reverseArray(arr, largestIndex);
//                 if (largestIndex != 1) {
//                     pancakeSort.add(largestIndex);
//                 }
//                 reverseArray(arr, num);
//                 pancakeSort.add(num);
//             }
//             num--;
//         }
//         return pancakeSort;
//     }

//     private int findLargestIndex(int[] arr, int num) {
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == num) {
//                 return i + 1;
//             }
//         }
//         return 0;
//     }

//     private void reverseArray(int[] arr, int index) {
//         int last = index - 1;
//         for (int i = 0; i <= ((index - 1) / 2); i++) {
//             int temp = arr[i];
//             arr[i] = arr[last];
//             arr[last] = temp;
//             last--;
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().pancakeSort(new int[]{3,2,4,1}));
//         System.out.println(new Solution().pancakeSort(new int[]{1,2,3}));
//     }
// }

// class Solution {
//     public String findCommonResponse(List<List<String>> responses) {
//         List<Set<String>> uniqueResponses = new ArrayList<>();
//         for (int i = 0; i < responses.size(); i++) {
//             List<String> responseList = responses.get(i);
//             Set<String> responseSet = new HashSet<>();
//             for (String response : responseList) {
//                 responseSet.add(response);
//             }
//             uniqueResponses.add(responseSet);
//         }

//         Map<String, Integer> responseFrequency = new TreeMap<>();
//         for (Set<String> responseSet: uniqueResponses) {
//             for (String response : responseSet) {
//                 if (!responseFrequency.containsKey(response)) {
//                     responseFrequency.put(response, 0);
//                 }
//                 responseFrequency.replace(response, responseFrequency.get(response) + 1);
//             }
//         }

//         int maxFrequency = 0;
//         String result = "";
//         for (String key : responseFrequency.keySet()) {
//             if (responseFrequency.get(key) > maxFrequency) {
//                 maxFrequency = responseFrequency.get(key);
//                 result = key;
//             }
//         }
//         return result;
//     }
// }


// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         return canVisit(rooms, 0, new HashSet<>());
//     }

//     private boolean canVisit(List<List<Integer>> rooms, int currentIndex, Set<Integer> visitedRooms) {
//         visitedRooms.add(currentIndex);
//         if (visitedRooms.size() == rooms.size()) {
//             return true;
//         }
//         if (rooms.get(currentIndex).size() == 0) {
//             return false;
//         }
//         for (int index = 0; index < rooms.get(currentIndex).size(); index++) {
//             int key = rooms.get(currentIndex).get(index);
//             if (canVisit(rooms, key, visitedRooms)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// class CustomStack {
//     private List<Integer> list;
//     private int size;

//     public CustomStack(int maxSize) {
//         list = new ArrayList<>(maxSize);
//         size = maxSize;
//     }
    
//     public void push(int x) {
//         if (list.size() >= size) {
//             return;
//         }
//         list.add(x);
//     }
    
//     public int pop() {
//         if (list.size() == 0) {
//             return -1;
//         }
//         return list.remove(list.size() - 1);
//     }
    
//     public void increment(int k, int val) {
//         int index = 0;
//         while (index < list.size() && index < k) {
//             list.set(index, list.get(index) + val);
//             index++;
//         }
//     }
// }

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(){}
//     ListNode(int val) {
//         this.val = val;
//     }
//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

// class Solution {
//     public ListNode[] splitListToParts(ListNode head, int k) {
//         ListNode current = head;
//         ListNode[] result = new ListNode[k];
//         int size = 0;
//         while (current != null) {
//             current = current.next;
//             size++;
//         }
//         current = head;

//         int length = size / k;
//         int remainder = size % k;
//         for (int i = 0; i < result.length; i++) {
//             result[i] = current;
//             int index = length;
//             if (remainder > 0) {
//                 index++;
//                 remainder--;
//             }
//             while (current != null && index > 0) {
//                 ListNode next = current.next;
//                 if (index == 1) {
//                     current.next = null;
//                 }
//                 current = next;
//                 index--;
//             }
//         }

//         return result;
//     }
// }


// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// class Solution {
//     public TreeNode reverseOddLevels(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int level = 0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<TreeNode> nodes = new ArrayList<>();
//             for (int i = 0; i < size; i++) {
//                 TreeNode current = queue.poll();
//                 nodes.add(current);
//                 if (current.left != null) {
//                     queue.add(current.left);
//                 }
//                 if (current.right != null) {
//                     queue.add(current.right);
//                 }
//             }
            
//             if (level % 2 == 1) {
//                 int lastIndex = nodes.size() - 1;
//                 for (int i = 0; i < (nodes.size() / 2); i++) {
//                     int temp = nodes.get(i).val;
//                     nodes.get(i).val = nodes.get(lastIndex).val;
//                     nodes.get(lastIndex).val = temp;
//                     lastIndex--;
//                 }
//             }

//             level++;
//         }
//         return root;
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(2);
//         root.left = new TreeNode(3);
//         root.right = new TreeNode(5);
//         root.left.left = new TreeNode(8);
//         root.left.right = new TreeNode(13);
//         root.right.left = new TreeNode(21);
//         root.right.right = new TreeNode(34);
//         new Solution().reverseOddLevels(root);
//     }
// }

// class Solution {
//     public int minNumberOperations(int[] target) {
//         int totalSum = getSum(target);
//         int operations = 0;
//         while (totalSum != 0) {
//             int index = getFirstNonZero(target);
//             while (index < target.length && target[index] != 0) {
//                 target[index]--;
//                 totalSum--;
//                 index++;
//             }
//             operations++;
//         }
//         return operations;
//     }

//     private int getFirstNonZero(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != 0) {
//                 return i;
//             }
//         }
//         return nums.length;
//     }

//     private int getSum(int[] nums) {
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
//         return sum;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minNumberOperations(new int[]{3,1,5,4,2}));
//     }
// }

// class Solution {
//     public boolean isMatch(String s, String p) {
//         Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
//         return isMatchHelper(s, p, 0, 0, memo);
//     }

//     private boolean isMatchHelper(String s, String p, int indexS, int indexP, Boolean[][] memo) {
//         if (indexS == s.length() && indexP == p.length()) {
//             return true;
//         }
//         if (indexP >= p.length()) {
//             return false;
//         }
//         if (indexS >= s.length() && p.charAt(indexP) != '*') {
//             return false;
//         }
//         if (memo[indexS][indexP] != null) {
//             return memo[indexS][indexP];
//         }
//         if (Character.isAlphabetic(p.charAt(indexP)) && s.charAt(indexS) != p.charAt(indexP)) {
//             memo[indexS][indexP] = false;
//             return false;
//         }
//         if (p.charAt(indexP) == '*') {
//             boolean skip = isMatchHelper(s, p, indexS, indexP + 1, memo);
//             boolean include = false;
//             if (indexS < s.length()) {
//                 include = isMatchHelper(s, p, indexS + 1, indexP, memo);
//             }
//             memo[indexS][indexP] = skip || include;
//             return memo[indexS][indexP];
//         }
//         memo[indexS][indexP] = isMatchHelper(s, p, indexS + 1, indexP + 1, memo);
//         return memo[indexS][indexP];
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().isMatch("aa", "*"));
//         System.out.println(new Solution().isMatch("aa", "a"));
//         System.out.println(new Solution().isMatch("cb", "?a"));
//         System.out.println(new Solution().isMatch("acdcb", "a*c?b"));
//         System.out.println(new Solution().isMatch("aadibsa", "a*a"));
//         System.out.println(new Solution().isMatch("", "**"));
//     }
// }

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {

//     }

//     TreeNode(int x) {
//         val = x;
//     }
// }


// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if ((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
//             return root;
//         }
//         if ((p.val < root.val && q.val < root.val)) {
//             return lowestCommonAncestor(root.left, p, q);
//         }
//         return lowestCommonAncestor(root.right, p, q);
//     }
// }

// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int pivotIndex = findPivotIndex(nums, pivot);
//         List<Integer> left = new ArrayList<>();
//         int middle = 0;
//         List<Integer> right = new ArrayList<>();
//         for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
//             if (nums[currentIndex] < nums[pivotIndex]) {
//                 left.add(nums[currentIndex]);
//             } else if (nums[currentIndex] > nums[pivotIndex]) {
//                 right.add(nums[currentIndex]);
//             } else {
//                 middle++;
//             }
//         }

//         int index = 0;
//         for (int i = 0; i < left.size(); i++) {
//             nums[index++] = left.get(i);
//         }
//         for (int i = 0; i < middle; i++) {
//             nums[index++] = pivot;
//         }
//         for (int i = 0; i < right.size(); i++) {
//             nums[index++] = right.get(i);
//         }
//         return nums;
//     }

//     private int findPivotIndex(int[] nums, int pivot) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == pivot) {
//                 return i;
//             }
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(new Solution().pivotArray(new int[]{4,0,4,5,-11}, 5)));
//     }
// }

// class Solution {
//     class StringPtr {
//         private int index = 0;
//         private String expression;

//         public StringPtr(String expression) {
//             this.expression = expression;
//         }

//         private char getNext() {
//             char next = expression.charAt(index);
//             index++;
//             return next;
//         }

//         private char peek() {
//             return expression.charAt(index);
//         }
//     }

//     public boolean parseBoolExpr(String expression) {
//         return parseHelper(expression, new StringPtr(expression));
//     }

//     private boolean parseHelper(String expression, StringPtr stringPtr) {
//         if (expression.charAt(stringPtr.index) == 't') {
//             stringPtr.index++;
//             return true;
//         }

//         if (expression.charAt(stringPtr.index) == 'f') {
//             stringPtr.index++;
//             return false;
//         }

//         char type = stringPtr.getNext();
//         check(stringPtr.getNext() == '(');
//         List<Boolean> boolList = new ArrayList<>();
//         while (stringPtr.peek() != ')') {
//             if (stringPtr.peek() == ',') {
//                 stringPtr.getNext();
//             }
//             boolList.add(parseHelper(expression, stringPtr));
//         }
//         check(stringPtr.getNext() == ')');
//         return parseSubExpr(boolList, type);
//     }

//     private void check(boolean expr) {
//         if (!expr) {
//             throw new IllegalStateException("Expected expression to evaluate to true");
//         }
//     }

//     private boolean parseSubExpr(List<Boolean> boolList, char type) {
//         boolean result = boolList.get(0);
//         for (Boolean bool : boolList) {
//             if (type == '&') {
//                 result = result && bool;
//             } else if (type == '|') {
//                 result = result || bool;
//             } else {
//                 result = !result;
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().parseBoolExpr("&(|(f))"));
//         System.out.println(new Solution().parseBoolExpr("|(f,f,f,t)"));
//         System.out.println(new Solution().parseBoolExpr("!(&(f,t))"));
//         System.out.println(new Solution().parseBoolExpr("|(&(t,f,t),t)"));
//     }
// }


// class Solution {
//     public int sum(int[] nums) {
//         int index = 0;
//         int sum = 0;
//         int current = nums[index];
//         while (index < nums.length || nums[nums.length - 1] != 0) {
//             if (index < nums.length && nums[index] >= current) {
//                 nums[index] -= current;
//                 index++;
//             } else {
//                 index = findLastZero(nums) + 1;
//                 sum += current;
//                 current = nums[index];
//             }
//         }
//         sum += current;
//         return sum;
//     }

//     private int findLastZero(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0 && nums[i + 1] != 0) {
//                 return i;
//             }
//         }
//         return nums.length - 1;
//     }
    
//     public static void main(String[] args) {
//         System.out.println(new Solution().sum(new int[]{2,2,3,1,5}));
//         // 2, 2, 3, 1, 5
//         // 0, 0, 1, 1, 5
//         // 0, 0, 0, 0, 4
//         // 2 + 1 + 4 = 7
//     }
// }


// class Solution {
//     public List<String> findItinerary(List<List<String>> tickets) {
//         TreeMap<String, TreeSet<String>> adjMap = buildAdjMap(tickets);
//         List<String> itinerary = new ArrayList<>();
//         dfs("JFK", itinerary, adjMap);
//         Collections.reverse(itinerary);
//         return itinerary;
//     }

//     private TreeMap<String, TreeSet<String>> buildAdjMap(List<List<String>> tickets){
//         TreeMap<String, TreeSet<String>> adjMap = new TreeMap<>();
//         for (List<String> ticket : tickets) {
//             if (!adjMap.containsKey(ticket.get(0))) {
//                 adjMap.put(ticket.get(0), new TreeSet<>());
//             }
//             adjMap.get(ticket.get(0)).add(ticket.get(1));
//         }
//         return adjMap;
//     }

//     private void dfs(String city, List<String> itinerary, TreeMap<String, TreeSet<String>> adjMap) {
//         TreeSet<String> destinations = adjMap.get(city);
//         while (destinations != null && !destinations.isEmpty()) {
//             String next = destinations.first();
//             destinations.remove(next);
//             dfs(next, itinerary, adjMap);
//         }
//         itinerary.add(city);
//     }

//     public static void main(String[] args) {
//         List<List<String>> tickets = new ArrayList<>();
//         tickets.add(Arrays.asList("JFK", "SFO"));
//         tickets.add(Arrays.asList("JFK", "ATL"));
//         tickets.add(Arrays.asList("SFO", "ATL"));
//         tickets.add(Arrays.asList("ATL", "JFK"));
//         tickets.add(Arrays.asList("ATL", "SFO"));
//         System.out.println(new Solution().findItinerary(tickets));
//     }
// }


// class Solution {
//     private static final int MOD = 1_000_000_007;
//     public int numDecodings(String s) {
//         int[] dp = new int[s.length() + 1];
//         dp[0] = 1;
//         dp[1] = ways(s.charAt(0));
//         for (int i = 2; i <= s.length(); i++) {
//             long oneWays = (long) (ways(s.charAt(i - 1)) * dp[i - 1]);
//             long twoWays = ways(s.charAt(i - 2), s.charAt(i - 1)) * dp[i - 2];
//             dp[i] = (int) ((oneWays + twoWays) % MOD);
//         }
//         return dp[s.length()];
//     }

//     private int ways(char curr) {
//         if (curr == '*') {
//             return 9;
//         } else if (curr != '0') {
//             return 1;
//         }
//         return 0;
//     }

//     private long ways(char prev, char curr) {
//         if (prev == '*' && curr == '*') {
//             return 15;
//         } else if (curr == '*') {
//             return (prev == '1') ? 9 : (prev == '2') ? 6 : 0;
//         } else if (prev == '*') {
//             return (curr < '7') ? 2 : 1;
//         } else {
//             int val = Integer.parseInt("" + prev + curr);
//             return val >= 10 && val <= 26 ? 1 : 0;
//         }
//     }
    

//     public static void main(String[] args) {
//         System.out.println(new Solution().numDecodings("12*"));
//     }
// }

// class Solution {
//     public int[][] kClosest(int[][] points, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> compare(b, a));

//         for (int[] point : points) {
//             if (pq.size() < k) {
//                 pq.add(point);
//             } else if (pq.size() == k && compare(pq.peek(), point) > 0) {
//                 pq.poll();
//                 pq.add(point);
//             }
//         }
        

//         int[][] result = new int[k][2];
//         for (int i = 0; i < k; i++) {
//             int[] point = pq.poll();
//             result[i] = point;
//         }
//         return result;
//     }

//     private int getDistance(int[] point) {
//         return point[0] * point[0] + point[1] * point[1];
//     }

//     private int compare(int[] point1, int[] point2) {
//         return Integer.compare(getDistance(point1), getDistance(point2));
//     }

//     public static void main(String[] args) {
//         for (int[] point : new Solution().kClosest(new int[][]{{-143,163},{210,-53},{217,-101}}, 2)) {
//             System.out.println(Arrays.toString(point));
//         }
//         // for (int[] point : new Solution().kClosest(new int[][]{{1,3},{-2,2}}, 1)) {
//         //     System.out.println(Arrays.toString(point));
//         // }
//         // System.out.println(new Solution().getDistance(new int[]{-50,181}));
//         // System.out.println(new Solution().getDistance(new int[]{-143,163}));
//         // System.out.println(new Solution().getDistance(new int[]{210,-53}));
//         // System.out.println(new Solution().getDistance(new int[]{217,-101}));
//     }
// }

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         Integer[][] memo = new Integer[obstacleGrid.length][obstacleGrid[0].length];
//         return uniquePaths(obstacleGrid, 0, 0, memo);
//     }

//     private int uniquePaths(int[][] obstacleGrid, int row, int col, Integer[][] memo) {
//         if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
//             return 0;
//         }
//         if (memo[row][col] != null) {
//             return memo[row][col];
//         }
//         if (obstacleGrid[row][col] == 1) {
//             memo[row][col] = 0;
//             return 0;
//         }
//         if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
//             memo[row][col] = 1;
//             return 1;
//         }

//         int paths = 0;
//         paths += uniquePaths(obstacleGrid, row + 1, col, memo) + uniquePaths(obstacleGrid, row, col + 1, memo);
//         memo[row][col] = paths;
//         return paths;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
//         System.out.println(new Solution().uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
//     }
// }

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
//         List<int[]> list = new ArrayList<>();
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i - 1][1] >= intervals[i][0]) {
//                 list.add(new int[]{intervals[i - 1][0], intervals[i][1]});
//             } else {
//                 list.add(intervals[i - 1]);
//                 list.add(intervals[i]);
//             }
//         }

//         int[][] result = new int[list.size()][2];
//         for (int i = 0; i < result.length; i++) {
//             result[i] = list.get(i);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(new Solution().merge(new int[][]{{3,7},{1,5}})));
//     }
// }

// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int start = 0;
//         int gasLevel = 0;
//         for (int i = start; i < (gas.length * 2); i++) {
//             int index = i % gas.length;
//             gasLevel += gas[index];
//             if (gasLevel < cost[index]) {
//                 start = (i + 1) % gas.length;
//                 gasLevel = 0;
//                 continue;
//             }
//             gasLevel -= cost[index];
//             if ((index == start - 1 || (index - start == gas.length - 1)) && gasLevel >= 0) {
//                 return start;
//             }
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
//         System.out.println(new Solution().canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
//         System.out.println(new Solution().canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
//     }
// }

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {

//     }

//     TreeNode(int x) {
//         val = x;
//     }
// }

// class Solution {
//     public TreeNode balanceBST(TreeNode root) {
//         List<TreeNode> nodeList = new ArrayList<>();
//         getNodeList(root, nodeList);
//         return buildTree(nodeList, 0, nodeList.size() - 1);
//     }

//     private TreeNode buildTree(List<TreeNode> nodeList, int left, int right) {
//         if (left > right) {
//             return null;
//         }
//         int middle = (right - left) / 2 + left;
//         TreeNode current = new TreeNode(nodeList.get(middle).val);
//         current.left = buildTree(nodeList, left, middle - 1);
//         current.right = buildTree(nodeList, middle + 1, right);
//         return current;
//     }

//     private void getNodeList(TreeNode root, List<TreeNode> nodeList) {
//         if (root.left != null) {
//             getNodeList(root.left, nodeList);
//         }
//         nodeList.add(root);
//         if (root.right != null) {
//             getNodeList(root.right, nodeList);
//         }
//     }
// }

// class ExamTracker {
//     private TreeMap<Integer, Long> timeToTotalScoreMap = new TreeMap<>();
//     public ExamTracker() {
//         timeToTotalScoreMap.put(0, (long) 0);
//     }
    
//     public void record(int time, int score) {
//         Integer prevTime = timeToTotalScoreMap.floorKey(time);
//         timeToTotalScoreMap.put(time, (long) score + timeToTotalScoreMap.get(prevTime));
//     }
    
//     public long totalScore(int startTime, int endTime) {
//         Integer startKey = timeToTotalScoreMap.floorKey(startTime - 1);
//         Integer endKey = timeToTotalScoreMap.floorKey(endTime);

//         long totalScore = 0;

//         if (startKey != null && endKey != null) {
//             totalScore = timeToTotalScoreMap.get(endKey) - timeToTotalScoreMap.get(startKey);
//         }
//         return totalScore;
//     }

//     public static void main(String[] args) {
//         ExamTracker et = new ExamTracker();
//         et.record(2, 2);
//         et.record(5, 99);
//         System.out.println(et.totalScore(5, 10));
//     }
// }

// class Graph {
//     class Node {
//         int val;
//         public Node (int val) {
//             this.val = val;
//         }
//     }

//     class Edge {
//         Node fromNode;
//         Node toNode;
//         int weight; 
//         public Edge(Node fromNode, Node toNode, int weight) {
//             this.fromNode = fromNode;
//             this.toNode = toNode;
//             this.weight = weight;
//         }
//     }

//     private List<List<Edge>> adjList = new ArrayList<>();
//     private List<Node> nodeList = new ArrayList<>();

//     public Graph(int n, int[][] edges) {
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<>());
//             nodeList.add(new Node(i));
//         }
//         for (int[] edge : edges) {
//             addEdge(edge);
//         }
//     }
    
//     public void addEdge(int[] edge) {
//         Edge newEdge = new Edge(nodeList.get(edge[0]), nodeList.get(edge[1]), edge[2]);
//         adjList.get(edge[0]).add(newEdge);
//     }
    
//     public int shortestPath(int node1, int node2) {
//         Set<Integer> visited = new HashSet<>();
//         int[] distances = new int[nodeList.size()];
//         for (int i = 0; i < distances.length; i++) {
//             if (i != node1) {
//                 distances[i] = Integer.MAX_VALUE;
//             }
//         }

//         PriorityQueue<Node> pq = new PriorityQueue<>(
//             (Node n1, Node n2) -> Integer.compare(distances[n1.val], distances[n2.val])
//         );
//         pq.add(nodeList.get(node1));

//         while (!pq.isEmpty()) {
//             Node current = pq.poll();
//             visited.add(current.val);
//             if (node2 == current.val) {
//                 return distances[current.val];
//             }
//             for (Edge edge : adjList.get(current.val)) {
//                 int toNodeVal = edge.toNode.val;
//                 if (visited.contains(toNodeVal)) {
//                     continue;
//                 }
//                 distances[toNodeVal] = Math.min(distances[toNodeVal], distances[current.val] + edge.weight);
//                 pq.add(edge.toNode);
//             }
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Graph(4, new int[][]{{0,2,5},{0,1,2},{3,0,3},{1,2,1}}).shortestPath(0,3));
//     }
// }


// class Solution {
//     public int change(int amount, int[] coins) {
//         Integer[][] memo = new Integer[amount + 1][coins.length];
//         return changeHelper(amount, coins, 0, memo);
//     }

//     private int changeHelper(int amount, int[] coins, int index, Integer[][] memo) {
//         if (index >= coins.length) {
//             return 0;
//         }
//         if (amount == 0) {
//             return 1;
//         }
//         if (memo[amount][index] != null) {
//             return memo[amount][index];
//         }

//         int included = 0;
//         if (amount - coins[index] >= 0) {
//             included = changeHelper(amount - coins[index], coins, index, memo);
//         }
//         int notIncluded = changeHelper(amount, coins, index + 1, memo);

//         memo[amount][index] = included + notIncluded;
//         return included + notIncluded;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().change(5, new int[]{5}));
//         System.out.println(new Solution().change(5, new int[]{3}));
//         System.out.println(new Solution().change(5, new int[]{1,2,5}));
//         System.out.println(new Solution().change(500, new int[]{3,5,7,8,9,10,11}));
//         // 1 0 4  
//     }
// }

// class Solution {
//     class DisjointSet {
//         int[] parent;
//         public DisjointSet(int n) {
//             this.parent = new int[n + 1];
//             for (int i = 1; i <= n; i++) {
//                 parent[i] = i;
//             }
//         }

//         public void union(int a, int b) {
//             int parentA = find(a);
//             int parentB = find(b);
//             if(parentA == parentB) {
//                 return;
//             }
//             parent[parentA] = parentB;
//         }

//         public int find(int a) {
//             if (parent[a] == a) {
//                 return a;
//             }
//             return find(parent[a]);
//         }
//     }

//     public int[] findRedundantConnection(int[][] edges) {
//         DisjointSet disjointSet = new DisjointSet(edges.length);
//         for (int[] edge : edges) {
//             if (disjointSet.find(edge[0]) == disjointSet.find(edge[1])) {
//                 return edge;
//             }
//             disjointSet.union(edge[0], edge[1]);
//         }
//         return new int[2];
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(new Solution().findRedundantConnection(
//             new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}}
//         )));
//     }
// }

// class Solution {
//     public int numSplits(String s) {
//         int splits = 0;
//         int[] sizes = new int[s.length()];
//         Set<Character> rightSet = new HashSet<>();
//         Set<Character> leftSet = new HashSet<>();

//         for (int i = s.length() - 1; i >= 0; i--) {
//             rightSet.add(s.charAt(i));
//             sizes[i] = rightSet.size();
//         }

//         for (int i = 0; i < s.length() - 1; i++) {
//             leftSet.add(s.charAt(i));
//             if (leftSet.size() == sizes[i + 1]) {
//                 splits++;
//             }
//         }

//         return splits;
//     }
// }

// class Solution {
//     private  static final int POSITIONS = 6;
//     private static final int[][] DELTAS = new int[][]{{1,3},{0,4,2},{1,5},{0,4},{1,3,5},{2,4}};

//     public class Board {
//         private int[] positions = new int[POSITIONS];
//         public Board(int pos0, int pos1, int pos2, int pos3, int pos4, int pos5){
//             this.positions[0] = pos0;
//             this.positions[1] = pos1;
//             this.positions[2] = pos2;
//             this.positions[3] = pos3;
//             this.positions[4] = pos4;
//             this.positions[5] = pos5;
//         }
//         public Board(int blankIndex, int swapIndex, Board current) {
//             for (int i = 0; i < POSITIONS; i++) {
//                 this.positions[i] = current.positions[i];
//             }
//             this.positions[blankIndex] = current.positions[swapIndex];
//             this.positions[swapIndex] = 0;
//         }
//     }

//     public int slidingPuzzle(int[][] board) {
//         return bfs(
//             new Board(board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2]), 
//             new Board(1, 2, 3, 4, 5, 0)
//         );
//     }

//     private int bfs(Board start, Board end) {
//         int moves = 0;
//         Queue<Board> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<>();
//         queue.add(start);
//         visited.add(toKey(start));

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (size > 0) {
//                 Board current = queue.poll();
//                 for (Board neighbor : getNeighbors(current)) {
//                     if (areTheSame(neighbor, end)) {
//                         return moves + 1;
//                     }
//                     if (!visited.contains(toKey(neighbor))) {
//                         queue.add(neighbor);
//                         visited.add(toKey(neighbor));
//                     }
//                 }
//                 size--;
//             }
//             moves++;
//         }
//         return -1;
//     }

//     private boolean areTheSame(Board first, Board second) {
//         for (int pos = 0; pos < POSITIONS; pos++) {
//             if (first.positions[pos] != second.positions[pos]) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private List<Board> getNeighbors(Board current) {
//         List<Board> neighbors = new ArrayList<>();
//         int index = 0;
//         for (int pos = 0; pos < POSITIONS; pos++) {
//             if (current.positions[pos] == 0) {
//                 index = pos;
//             }
//         }

//         for (int delta : DELTAS[index]) {
//             neighbors.add(new Board(index, delta, current));
//         }
//         return neighbors;
//     }

//     private String toKey(Board board) {
//         return String.format("%d%d%d%d%d%d", 
//             board.positions[0], 
//             board.positions[1], 
//             board.positions[2], 
//             board.positions[3], 
//             board.positions[4], 
//             board.positions[5]);
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
//     }
// }

// class Solution {
//     public int twoEggDrop(int n) {
//         for (int i = 1; i < n; i++) {
//             if(isNumberOfMoves(0, i, n)) {
//                 return i;
//             }
//         }
//         return -1;
//     }

//     private boolean isNumberOfMoves(int currentFloor, int steps, int maxFloor) {
//         if (steps >= 0 && currentFloor == maxFloor) {
//             return true;
//         }

//         if (steps == 0 && currentFloor < maxFloor) {
//             return false;
//         }

//         boolean isNumberOfMoves = false;
//         if ((currentFloor + steps) < maxFloor) {
//             isNumberOfMoves = isNumberOfMoves(currentFloor + steps, steps - 1, maxFloor);
//         } else {
//             isNumberOfMoves = isNumberOfMoves(currentFloor + 1, steps - 1, maxFloor);
//         }
//         return isNumberOfMoves;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().twoEggDrop(100));
//     }
// }


// class Solution {
//     public int[] canSeePersonsCount(int[] heights) {
//         int[] result = new int[heights.length];
//         Stack<Integer> indices = new Stack<>();
//         for (int index = heights.length - 1; index >= 0; index--) {
//             int size = indices.size();
//             int count = 1;
//             while (!indices.isEmpty() && heights[indices.peek()] <= heights[index]) {
//                 indices.pop();
//                 count++;
//             }
//             result[index] = Math.min(size, count);
//             indices.add(index);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(new Solution().canSeePersonsCount(new int[]{10,6,8,5,11,9})));
//         System.out.println(Arrays.toString(new Solution().canSeePersonsCount(new int[]{5,1,2,3,10})));
//     }
// }

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     public TreeNode() {}
//     public TreeNode(int val) { this.val = val; }
//     public TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// class Solution {
//     public TreeNode removeLeafNodes(TreeNode root, int target) {
//         TreeNode specialRoot = new TreeNode(-1, root, null);
//         Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
//         buildParentMap(specialRoot, childToParentMap);

//         List<TreeNode> leafNodesList = new ArrayList<>();
//         getLeafNodes(specialRoot, leafNodesList);

//         for (TreeNode leaf : leafNodesList) {
//             removeLeafNodesHelper(leaf, target, childToParentMap);
//         }
//         return specialRoot.left;
//     }

//     private void buildParentMap(TreeNode current, Map<TreeNode, TreeNode> childToParentMap) {
//         if (current.left != null) {
//             childToParentMap.put(current.left, current);
//             buildParentMap(current.left, childToParentMap);
//         }
//         if (current.right != null) {
//             childToParentMap.put(current.right, current);
//             buildParentMap(current.right, childToParentMap);
//         }
//     }
    
//     private void getLeafNodes(TreeNode current, List<TreeNode> leafNodesList) {
//         if (current == null) {
//             return;
//         }
//         if (current.left == null && current.right == null) {
//             leafNodesList.add(current);
//             return;
//         }
//         getLeafNodes(current.left, leafNodesList);
//         getLeafNodes(current.right, leafNodesList);
//     }

//     private void removeLeafNodesHelper(TreeNode leaf, int target, Map<TreeNode, TreeNode> childToParentMap) {
//         if (!childToParentMap.containsKey(leaf)) {
//             leaf = null;
//             return;
//         }
        
//         if (leaf.val != target) {
//             return;
//         }

//         TreeNode parent = childToParentMap.get(leaf);
//         if (leaf == parent.left) {
//             parent.left = null;
//         } else if (leaf == parent.right) {
//             parent.right = null;
//         }

//         if (parent.left == null && parent.right == null) {
//             removeLeafNodesHelper(parent, target, childToParentMap);
//         }
//     }    

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         TreeNode root = new TreeNode(3);
//         // TreeNode left = new TreeNode(3);
//         // root.left = left;
//         // left.left = new TreeNode(3);
//         solution.removeLeafNodes(root, 3);
//     }
// }

// class Solution {
//     class CountNode {
//         private int sum;
//         private int totalNodes;
//         private int countNodes;
//         public CountNode(){}
//         public CountNode(int sum, int totalNodes, int countNodes) {
//             this.sum = sum;
//             this.totalNodes = totalNodes;
//             this.countNodes = countNodes;
//         }
//     }
 
//     public int averageOfSubtree(TreeNode root) {
//         return postOrderTraversal(root, 0, 0, 0).countNodes;
//     }

//     private CountNode postOrderTraversal(TreeNode current, int sum, int totalNodes, int countNodes) {
//         CountNode left = new CountNode();
//         if (current.left != null) {
//             left = postOrderTraversal(current.left, sum, totalNodes, countNodes);
//         }
//         CountNode right = new CountNode();
//         if (current.right != null) {
//             right = postOrderTraversal(current.right, sum, totalNodes, countNodes);
//         }
        
//         int satisfy = 0;
//         if (current.val == (left.sum + right.sum + current.val) / (left.totalNodes + right.totalNodes + 1)) {
//             satisfy = 1;
//         }
//         return new CountNode(
//             left.sum + right.sum + current.val,
//             totalNodes + 1,
//             left.countNodes + right.countNodes + satisfy); 
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         TreeNode root = new TreeNode(2);
//         TreeNode left = new TreeNode(3);
//         root.left = left;
//         System.out.println(solution.averageOfSubtree(root));
//     }
// }

// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         Map<Integer, String> map = new HashMap<>();
//         for (int i = 0; i < graph.length; i++) {
//             if (!map.containsKey(i) && !isBipartiteHelper(graph, i, map, "blue")) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean isBipartiteHelper(int[][] graph, int index, Map<Integer, String> map, String current) {
//         if (index >= graph.length) {
//             return true;
//         }

//         if (map.containsKey(index)) {
//             return !current.equals(map.get(index));
//         }

//         String nextColor = "blue";
//         if (current.equals("blue")) {
//             nextColor = "red";
//         }
//         map.put(index, nextColor);

//         for (int num : graph[index]) {
//             if (!isBipartiteHelper(graph, num, map, nextColor)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().isBipartite(new int[][]{{}}));
//         System.out.println(new Solution().isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
//         System.out.println(new Solution().isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
//         System.out.println(new Solution().isBipartite(new int[][]{{},{2,4,6},{1,4,8,9},
//                 {7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}}));
//     }
// }


// class FreqStack {
//     class ListNode {
//         private int frequency;
//         private ListNode previous;
//         private ListNode next;
//         private Stack<Integer> stack = new Stack<>();
//         public ListNode(int frequency, ListNode previous, ListNode next) {
//             this.frequency = frequency;
//             this.previous = previous;
//             this.next = next;
//         }
//     }
//     class DoublyLinkedList {
//         ListNode head = new ListNode(0, null, null);
//         ListNode tail = new ListNode(0, null, null);
//         public DoublyLinkedList () {
//             this.head.next = tail;
//             this.tail.previous = head;
//         }
//     }

//     private Map<Integer, ListNode> valToLastNode = new HashMap<>();
//     private DoublyLinkedList linkedList = new DoublyLinkedList();
//     public FreqStack() {}
    
//     public void push(int val) {
//         ListNode head = linkedList.head;
//         ListNode tail = linkedList.tail;
//         ListNode current;
//         int frequency;
        
//         if (!valToLastNode.containsKey(val)) {
//             current = head;
//             frequency = 0;
//         } else {
//             current = valToLastNode.get(val);
//             frequency = current.frequency;
//         }

//         if (current.next == tail) {
//             ListNode next = new ListNode(frequency + 1, current, current.next);
//             current.next = next;
//             tail.previous = next;
//         }
//         current = current.next;
//         current.stack.add(val);
//         valToLastNode.put(val, current);
//     }
    
//     public int pop() {
//         ListNode largestFrequency = linkedList.tail.previous;
//         Stack<Integer> stack = largestFrequency.stack;
//         int frequency = largestFrequency.frequency;
//         int mostFrequentVal = stack.pop();

//         if (frequency == 1) {
//             valToLastNode.remove(mostFrequentVal);
//         } else {
//             valToLastNode.put(mostFrequentVal, valToLastNode.get(mostFrequentVal).previous);
//         }

//         if (stack.size() == 0) {
//             ListNode previous = largestFrequency.previous;
//             linkedList.tail.previous = previous;
//             previous.next = linkedList.tail;
//         }
//         return mostFrequentVal;
//     }

//     public static void main(String[] args) {
//         FreqStack fs = new FreqStack();
//         fs.push(5);
//         fs.push(7);
//         fs.push(5);
//         fs.push(7);
//         fs.push(4);
//         fs.push(5);
//         System.out.println(fs.pop());
//         System.out.println(fs.pop());
//         System.out.println(fs.pop());
//         System.out.println(fs.pop());
//     }
// }



// class Solution {
//     class DSU {
//         private int[] parent;
//         private int[] size;
//         public DSU(int n){
//             this.parent = new int[n];
//             this.size = new int[n];
//             for (int i = 0; i < parent.length; i++) {
//                 parent[i] = i;
//                 size[i] = 1;
//             }
//         }
//         public void union(int a, int b) {
//             int parentA = find(a);
//             int parentB = find(b);
//             if (parentA != parentB) {
//                 if (size[a] > size[b]) {
//                     parent[parentB] = parentA;
//                     size[parentA] += size[parentB];
//                 } else {
//                     parent[parentA] = parentB;
//                     size[parentB] += size[parentA];
//                 }
//             }
//         }
//         public int find(int a) {
//             if (parent[a] == a) {
//                 return a;
//             }
//             return find(parent[a]);
//         }
//     }

//     class Edge implements Comparable<Edge> {
//         private int indexA;
//         private int indexB;
//         private int weight;
//         public Edge(int indexA, int indexB, int weight) {
//             this.indexA = indexA;
//             this.indexB = indexB;
//             this.weight = weight;
//         }
//         public int compareTo(Edge other) {
//             return Integer.compare(this.weight, other.weight);
//         }
//     }

//     public int minCostConnectPoints(int[][] points) {
//         int minCost = 0;
//         if (points.length == 1) {
//             return minCost;
//         }
//         DSU dsu = new DSU(points.length);
//         PriorityQueue<Edge> minHeap = buildMinHeap(points);
//         while (!minHeap.isEmpty()) {
//             Edge current = minHeap.poll();
//             int parentA = dsu.find(current.indexA);
//             int parentB = dsu.find(current.indexB);
//             if (parentA != parentB) {
//                 dsu.union(parentA, parentB);
//                 minCost += current.weight;
//             }
//         }
//         return minCost;
//     }

//     private PriorityQueue<Edge> buildMinHeap(int[][] points) {
//         PriorityQueue<Edge> minHeap = new PriorityQueue<>();
//         for (int a = 0; a < points.length; a++) {
//             int[] pointA = points[a];
//             for (int b = 0; b < points.length; b++) {
//                 if (a == b) {
//                     continue;
//                 }
//                 int[] pointB = points[b];
//                 int weight = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
//                 Edge edge = new Edge(a, b, weight);
//                 minHeap.add(edge);
//             }
//         }
//         return minHeap;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().minCostConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}}));
//     }
// }


// class MedianFinder {
//     private PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
//     private PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
//     private int leftSize = 0;
//     private int rightSize = 0;

//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
//         if (leftSize == 0) {
//             leftHeap.add(num);
//             leftSize++;
//         } else if (leftSize == rightSize) {
//             if (leftHeap.peek() < num) {
//                 rightHeap.add(num);
//                 num = rightHeap.poll();
//             }
//             leftHeap.add(num);
//             leftSize++;
//         } else if (leftSize == rightSize + 1) {
//             if (leftHeap.peek() < num) {
//                 rightHeap.add(num);
//             } else {
//                 leftHeap.add(num);
//                 rightHeap.add(leftHeap.poll());
//             }
//             rightSize++;
//         }
//     }
    
//     public double findMedian() {
//         int totalSize = leftSize + rightSize;
//         if (totalSize % 2 == 1) {
//             return (double) leftHeap.peek();
//         }
//         return (double) (leftHeap.peek() + rightHeap.peek()) / 2;
//     }

//     public static void main(String[] args) {
//         MedianFinder mf = new MedianFinder();
//         mf.addNum(-1);
//         mf.addNum(-2);
//         mf.addNum(-4);
//         mf.addNum(-3);
//         System.out.println(mf.findMedian());
//         mf.addNum(9);
//         System.out.println(mf.findMedian());
//     }
// }

// class MedianFinder {
//     private List<Integer> dataStream = new ArrayList<>();

//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
//         int insertIndex = binarySearch(dataStream, num);
//         dataStream.add(0);

//         for (int i = dataStream.size() - 1; i > insertIndex; i--) {
//             dataStream.set(i, dataStream.get(i - 1));
//         }
//         dataStream.set(insertIndex, num);
//     }

//     private int binarySearch(List<Integer> dataStream, int target) {
//         int left = 0;
//         int right = dataStream.size() - 1;
//         while (left <= right) {
//             int middle = left + (right - left) / 2;
//             if (target > dataStream.get(middle)) {
//                 left = middle + 1;
//             } else if (target < dataStream.get(middle)) {
//                 right = middle - 1;
//             } else {
//                 return middle;
//             }
//         }
//         return left;
//     }
    
//     public double findMedian() {
//         int size = dataStream.size();
//         int middle = size / 2;
//         if (size % 2 == 1) {
//             double oddMedian = (double) dataStream.get(middle);
//             return oddMedian;
//         } 

//         double sum = (double) dataStream.get(middle) + dataStream.get(middle - 1);
//         double evenMedian = sum / 2;
//         return evenMedian;
//     }

//     public static void main(String[] args) {
//         MedianFinder mf = new MedianFinder();
//         mf.addNum(-1);
//         mf.addNum(-2);
//         mf.addNum(-4);
//         mf.addNum(-3);
//         System.out.println(mf.findMedian());
//         mf.addNum(9);
//         System.out.println(mf.findMedian());
//     }
// }

// class Solution {
//     private final static int[][] DELTAS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

//     public int longestIncreasingPath(int[][] matrix) {
//         int longestPath = 0;
//         Integer[][] memo = new Integer[matrix.length][matrix[0].length];
//         for (int row = 0; row < matrix.length; row++) {
//             for (int col = 0; col < matrix[0].length; col++) {
//                 longestPath = Math.max(longestPath, increasingPath(matrix, row, col, memo));
//             }
//         }
//         return longestPath;
//     }

//     private int increasingPath(int[][] matrix, int row, int col, Integer[][] memo) {
//         if (memo[row][col] != null) {
//             return memo[row][col];
//         }
//         int maxLength = 1;
//         for (int[] delta : DELTAS) {
//             if (isInsideGrid(matrix, row + delta[0], col + delta[1]) 
//                     && matrix[row][col] < matrix[row + delta[0]][col + delta[1]]) {
//                 maxLength = Math.max(maxLength, 1 + increasingPath(matrix, row + delta[0], col + delta[1], memo));
//                 memo[row][col] = maxLength;
//             }
//         }
//         return maxLength;
//     }

//     private boolean isInsideGrid(int[][] matrix, int row, int col) {
//         if (row < 0 || row >= matrix.length) {
//             return false;
//         }
//         return col >= 0 && col < matrix[0].length;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().longestIncreasingPath(new int[][]{{1,2}}));
//         System.out.println(new Solution().longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
//     }
// }

// class RandomizedCollection {
//     private Map<Integer, Set<Integer>> valToIndices = new HashMap<>();
//     private List<Integer> numList = new ArrayList<>();
//     private int insertIndex = 0;
//     private Random random = new Random();

//     public RandomizedCollection() {
        
//     }
    
//     public boolean insert(int val) {
//         boolean isNotPresent = !valToIndices.containsKey(val);
//         if (isNotPresent) {
//             valToIndices.put(val, new HashSet<>());
//         }
//         numList.add(val);
//         valToIndices.get(val).add(insertIndex++);
//         return isNotPresent;
//     }
    
//     public boolean remove(int val) {
//         boolean isPresent = valToIndices.containsKey(val);
//         if (isPresent) {
//             int removeIndex = valToIndices.get(val).iterator().next();
//             int lastInsertIndex = insertIndex - 1;
//             int lastElement = numList.get(lastInsertIndex);
//             numList.set(removeIndex, lastElement);
//             numList.removeLast();
//             insertIndex--;

//             int frequency = valToIndices.get(val).size();
//             if (frequency == 1) {
//                 valToIndices.remove(val);
//             } else {
//                 valToIndices.get(val).remove(removeIndex);
//             }

//             if (valToIndices.containsKey(lastElement)) {
//                 valToIndices.get(lastElement).remove(lastInsertIndex);
//                 valToIndices.get(lastElement).add(removeIndex);
//             }
            
//         }
//         return isPresent;
//     }
    
//     public int getRandom() {
//         int randomIndex = random.nextInt(numList.size());
//         return numList.get(randomIndex);
//     }

//     public static void main(String[] args) {
//         RandomizedCollection rc = new RandomizedCollection();
//         System.out.println(rc.insert(1));
//         System.out.println(rc.insert(1));
//         System.out.println(rc.insert(2));
//         System.out.println(rc.insert(1));
//         System.out.println(rc.remove(1));
//         System.out.println(rc.remove(2));
//         System.out.println(rc.remove(2));
//         System.out.println(rc.getRandom());
//         System.out.println(rc.getRandom());
//     }
// }

// class Solution {
//     public int trap(int[] height) {
//         int trap = 0;
//         if (height.length == 1) {
//             return trap;
//         }

//         int[] maxRights = new int[height.length];
//         int maxRight = height[height.length - 1];
//         for (int col = height.length - 1; col >= 0; col--) {
//             maxRight = Math.max(maxRight, height[col]);
//             maxRights[col] = maxRight;
//         }

//         int[] maxLefts = new int[height.length];
//         int maxLeft = height[0];
//         for (int col = 0; col < height.length; col++) {
//             maxLeft = Math.max(maxLeft, height[col]);
//             maxLefts[col] = maxLeft;
//         }

//         for (int col = 1; col < height.length - 1; col++) {
//             int minHeight = Math.min(maxLefts[col], maxRights[col]);
//             if (minHeight - height[col] > 0) {
//                 trap += minHeight - height[col];
//             }
//         }
//         return trap;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//         System.out.println(new Solution().trap(new int[]{4,2,0,3,2,5}));
//         System.out.println(new Solution().trap(new int[]{2,0,2}));
//     }
// }

// class Solution {
//     public boolean search(int[] nums, int target) {
//         if (nums.length == 1) {
//             return target == nums[0];
//         }

//         int pivotIndex = findPivotIndex(nums, 0, nums.length - 1);
//         if (pivotIndex == -1) {
//             return searchHelper(nums, 0, nums.length - 1, target);
//         }
//         if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
//             return searchHelper(nums, 0, pivotIndex - 1, target);
//         }
//         return searchHelper(nums, pivotIndex, nums.length - 1, target);
//     }

//     private int findPivotIndex(int[] nums, int left, int right) {
//         if (left == right - 1) {
//             if (nums[left] > nums[right]) {
//                 return right;
//             } else {
//                 return -1;
//             }
//         }

//         int middle = left + (right - left) / 2;
//         if (nums[left] > nums[middle]) {
//             return findPivotIndex(nums, left, middle);
//         } else if (nums[middle] > nums[right]) {
//             return findPivotIndex(nums, middle, right);
//         }

//         int leftPivot = findPivotIndex(nums, left, middle);
//         if (leftPivot == -1) {
//             return findPivotIndex(nums, middle, right);
//         }
//         return leftPivot;
//     }

//     private boolean searchHelper(int[] nums, int left, int right, int target) {
//         while (left < right) {
//             int middle = left + (right - left) / 2;
//             if (target > nums[middle]) {
//                 left = middle + 1;
//             } else if (target < nums[middle]) {
//                 right = middle - 1;
//             } else {
//                 return true;
//             }
//         }
//         return nums[left] == target;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().search(new int[]{1,1}, 0));
//         //System.out.println(new Solution().search(new int[]{1,0,1,1,1}, 0)); // 1
//         //System.out.println(new Solution().search(new int[]{2,2,5,5,5,6,0,0,1,1,2}, 0)); // 6
//         //System.out.println(new Solution().search(new int[]{1,1,1,1,2,1}, 2)); // 4
//         //System.out.println(new Solution().search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2)); // 13
//     }
// }

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         if (head == null || head.next == null) {
//             return null;
//         }

//         ListNode slow = head.next;
//         ListNode fast = head.next.next;
//         while (fast != null && fast.next != null && slow != fast) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         if (fast == null || fast.next == null) {
//             return null;
//         }
//         fast = head;
//         while (fast != slow) {
//             fast = fast.next;
//             slow = slow.next;
//         }
//         return fast;
//     }

//     public static void main(String[] args) {
//         ListNode first = new ListNode(1);
//         ListNode second = new ListNode(2);
//         ListNode third = new ListNode(3);
//         ListNode fourth = new ListNode(4);
//         first.next = second;
//         second.next = third;
//         third.next = fourth;
//         fourth.next = second;
//         System.out.println(new Solution().detectCycle(first));
//     }
// }

// class SummaryRanges {
//     private TreeSet<Integer> streamSet = new TreeSet<>();

//     public SummaryRanges() {
        
//     }
    
//     public void addNum(int value) {
//         streamSet.add(value);
//     }
    
//     public int[][] getIntervals() {
//         if (streamSet.size() == 0) {
//             return new int[][]{};
//         }

//         List<int[]> intervals = new ArrayList<>();
//         int[] interval = new int[2];
//         interval[0] = streamSet.getFirst();
//         int previous = streamSet.getFirst();

//         for (int current : streamSet) {
//             if (current > previous + 1) {
//                 interval[1] = previous;
//                 intervals.add(new int[]{interval[0], interval[1]});
//                 interval[0] = current;
//             }
//             previous = current;
//         }
//         intervals.add(new int[]{interval[0], previous});
        
//         int[][] result = new int[intervals.size()][2];
//         for (int i = 0; i < result.length; i++) {
//             result[i] = intervals.get(i);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         SummaryRanges sr = new SummaryRanges();
//         sr.addNum(1);
//         sr.addNum(7);
//         System.out.println(sr.getIntervals());
//         sr.addNum(2);
//         System.out.println(sr.getIntervals());
//     }
// }

// class Solution {
//     public int bulbSwitch(int n) {
//         boolean[] isBulbOn = new boolean[n + 1];
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < isBulbOn.length; j += i) {
//                 isBulbOn[j] = !isBulbOn[j];
//             }

//         }
//         isBulbOn[n] = !isBulbOn[n];

//         int count = 0;
//         for (int i = 1; i < isBulbOn.length; i++) {
//             if (isBulbOn[i]) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().bulbSwitch(100));
//     }
// }

// class Solution {
//     private static final char[] DIGITS = new char[]{'1','2','3','4','5','6','7','8','9'};
//     private static final int[][] DELTAS = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

//     public void solveSudoku(char[][] board) {
//         solveSudokuHelper(board, 0, board.length * board.length);
//     }

//     private boolean solveSudokuHelper(char[][] board, int pos, int maxPos) {
//         int row = pos / board.length;
//         int col = pos % board.length;
//         if (pos >= maxPos) {
//             return true;
//         }

//         if (board[row][col] != '.') { 
//             return solveSudokuHelper(board, pos + 1, maxPos);
//         }

//         for (char digit : DIGITS) {
//             if (isValid(digit, row, col, board)) {
//                 board[row][col] = digit;
//                 if (solveSudokuHelper(board, pos + 1, maxPos)) {
//                     return true;
//                 }
//                 board[row][col] = '.';
//             }
//         }     
//         return false;
//     }

//     private boolean isValid(char digit, int r, int c, char[][] board) {
//         int row = r;
//         int col = c;
//         for (int[] delta : DELTAS) {
//             while (row + delta[0] >= 0 && row + delta[0] < board.length && col + delta[1] >= 0 && col + delta[1] < board.length) {
//                 row += delta[0];
//                 col += delta[1];
//                 if (board[row][col] == digit) {
//                     return false;
//                 }
//             }
//             row = r;
//             col = c;
//         }
//         return isValidThreeByThree(digit, r, c, board);
//     }

//     private boolean isValidThreeByThree(char digit, int originalRow, int originalCol, char[][] board) {
//         int col = originalCol / 3;
//         int row = originalRow / 3;
//         for (int r = (row * 3); r < (row * 3 + 3); r++) {
//             for (int c = (col * 3); c < (col * 3 + 3); c++) {
//                 if (board[r][c] == digit) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         char[][] board = new char[][]{
//             {'5','3','.','.','7','.','.','.','.'},
//             {'6','.','.','1','9','5','.','.','.'},
//             {'.','9','8','.','.','.','.','6','.'},
//             {'8','.','.','.','6','.','.','.','3'},
//             {'4','.','.','8','.','3','.','.','1'},
//             {'7','.','.','.','2','.','.','.','6'},
//             {'.','6','.','.','.','.','2','8','.'},
//             {'.','.','.','4','1','9','.','.','5'},
//             {'.','.','.','.','8','.','.','7','9'}};
//         new Solution().solveSudoku(board);
//         for (char[] row : board) {
//             System.out.println(row);
//         }
//     }
// }

// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         boolean[][] board = new boolean[n][n];
//         List<List<String>> result = new ArrayList<>();
//         solveNQueensHelper(board, 0, n, result, new HashSet<>());
//         return result;
//     }

//     private void solveNQueensHelper(
//         boolean[][] board,
//         int pos, 
//         int queens,    
//         List<List<String>> result, 
//         HashSet<Integer> current) {

//         int row = pos / board.length;
//         int col = pos % board.length;

//         if (queens == 0) {
//             List<String> validBoard = toString(current, board.length);
//             result.add(new ArrayList<>(validBoard));
//             return;
//         }

//         if (pos >= Math.pow(board.length, 2)) {
//             return;
//         }

//         if (canPlaceQueen(board, row, col)) {
//             board[row][col] = true;
//             current.add(pos);
//             solveNQueensHelper(board, pos + 1, queens - 1, result, current);
//             board[row][col] = false;
//             current.remove(pos);
//         }
//         solveNQueensHelper(board, pos + 1, queens, result, current);
//     }

//     private boolean canPlaceQueen(boolean[][] board, int r, int c) {
//         int length = board.length;
//         int row = r;
//         int col = c;
//         for (int[] delta : new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}){
//             while (row + delta[0] >= 0 && row + delta[0] < length && col + delta[1] >= 0 && col + delta[1] < length) {
//                 row += delta[0];
//                 col += delta[1];
//                 if (board[row][col]) {
//                     return false;
//                 }
//             }
//             row = r;
//             col = c;
//         }
//         return true;
//     }

//     private List<String> toString(HashSet<Integer> current, int length) {
//         List<String> result = new ArrayList<>();
//         for (int row = 0; row < length; row++) {
//             StringBuilder sb = new StringBuilder();
//             for (int col = 0; col < length; col++) {
//                 int pos = row * length + col;
//                 if (current.contains(pos)) {
//                     sb.append('Q');
//                 } else {
//                     sb.append('.');
//                 }
//             }
//             result.add(sb.toString());
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().solveNQueens(5));
//     }
// }

// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         int[] sCount = new int[26];
//         int[] pCount = new int[26];
//         List<Integer> startIndices = new ArrayList<>();

//         for (char c : p.toCharArray()) {
//             pCount[Character.getNumericValue(c) - 10]++;
//         }

//         int start = 0;
//         for (int i = 0; i < s.length(); i++) {
//             sCount[Character.getNumericValue(s.charAt(i)) - 10]++;
//             if ((i - start + 1) == p.length()) {
//                 if (Arrays.equals(sCount, pCount)) {
//                     startIndices.add(start);
//                 }
//                 sCount[Character.getNumericValue(s.charAt(start)) - 10]--;
//                 start++;
//             }
//         }

//         return startIndices;
//     }

//     public static void main(String[] args) {
//         System.out.println(Character.getNumericValue('a'));
//         System.out.println(new Solution().findAnagrams("abab", "ab"));
//         System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
//     }
// }

// class Solution {
//     public int findMaxForm(String[] strs, int m, int n) {
//         int[][] zeroesAndOnes = buildArray(strs);
//         Integer[][][] memo = new Integer[strs.length + 1][m + 1][n + 1];
//         int maxSum = getSumsForm(zeroesAndOnes, m, n, 0, memo);
//         return maxSum;
//     }

//     private int[][] buildArray (String[] strs) {
//         int[][] result = new int[strs.length][2];
//         for (int index = 0; index < strs.length; index++) {
//             String str = strs[index];
//             for (int i = 0; i < str.length(); i++) {
//                 if (str.charAt(i) == '1') {
//                     result[index][1]++;
//                 } else {
//                     result[index][0]++;
//                 }
//             }
//         }
//         return result;
//     }

//     private int getSumsForm (int[][] zeroesAndOnes, int zeroes, int ones, int index, Integer[][][] memo) {
//         if (zeroes == 0 && ones == 0) {
//             return 0; 
//         }

//         if (index == zeroesAndOnes.length) {
//             return 0;
//         }

//         if (memo[index][zeroes][ones] != null) {
//             return memo[index][zeroes][ones];
//         }

//         int zero = zeroes - zeroesAndOnes[index][0];
//         int one = ones - zeroesAndOnes[index][1];
//         int included = 0;
//         if (zero >= 0 && one >= 0) {
//             included = 1 + getSumsForm(zeroesAndOnes, zero, one, index + 1, memo);
//         }
//         int notIncluded = getSumsForm(zeroesAndOnes, zeroes, ones, index + 1, memo);
//         int result =  Math.max(included, notIncluded);
//         memo[index][zeroes][ones] = result;
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findMaxForm(new String[]{"10","1","0"}, 1, 1)); //2
//         System.out.println(new Solution().findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3)); //4
//         System.out.println(new Solution().findMaxForm(new String[]{"00","000"}, 1, 10)); //0
//         System.out.println(new Solution().findMaxForm(new String[]{"10001110","11000","111110"}, 6, 6)); //1
//         long start = System.currentTimeMillis();
//         System.out.println(new Solution().findMaxForm(new String[]{"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"}, 9, 80)); //17    
//         long end = System.currentTimeMillis();
//         System.out.println(end - start);
//     }
// }

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int totalSum = 0;
//         for (int num : nums) {
//             totalSum += num;
//         }
//         if (totalSum % 2 == 1) {
//             return false;
//         }
//         int partialSum = totalSum / 2;   
//         Map<String, Boolean> memo = new HashMap<>();
//         return canSumToK(nums, 0, partialSum, memo);
//     }

//     private boolean canSumToK(int[] nums, int index, int sum, Map<String, Boolean> memo) {
//         if (sum == 0) {
//             return true;
//         }
//         if (index == nums.length) {
//             return false;
//         }
//         String key = toKey(index, sum);
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }
//         int num = nums[index];
//         boolean includeNum = false;
//         if (sum - num >= 0) {
//             includeNum = canSumToK(nums, index + 1, sum - num, memo);
//         }
//         boolean ignoreNum = canSumToK(nums, index + 1, sum, memo);
//         memo.put(key, includeNum || ignoreNum);
//         return includeNum || ignoreNum;
//     }

//     private String toKey(int index, int sum) {
//         return "" + index + "," + sum;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().canPartition(new int[]{1,5,11,5}));
//     }
// }

// class Solution {
//     public String longestPalindrome(String s) {
//         String longestPalindrome = String.valueOf(s.charAt(0));
//         for (int middle = 1; middle < s.length(); middle++) {
//             String evenPalindrome = "";
//             String oddPalindrome = "";
//             if (s.charAt(middle) == s.charAt(middle - 1)) {
//                 evenPalindrome = getPalindrome(s, middle - 1, middle);
//                 if (evenPalindrome.length() > longestPalindrome.length()) {
//                     longestPalindrome = evenPalindrome;
//                 }
//             } 
            
//             if ((middle + 1) < s.length() && s.charAt(middle - 1) == s.charAt(middle + 1)) {
//                 oddPalindrome = getPalindrome(s, middle - 1, middle + 1);
//                 if (oddPalindrome.length( ) > longestPalindrome.length()) {
//                     longestPalindrome = oddPalindrome;
//                 }
//             }
//         }
//         return longestPalindrome;
//     }

//     private String getPalindrome(String s, int start, int end) {
//         while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
//             start--;
//             end++;
//         }
//         return s.substring(start + 1, end);
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().longestPalindrome("ccc"));
//     }
// }

// class Solution {
//     public String longestWord(String[] words) {
//         String longestWord = "";
//         Map<String, List<String>> neighborMap = buildNeighborMap(words);
//         for (String word : words) {
//             if (word.length() > 1) {
//                 continue;
//             }
//             String result = bfs(neighborMap, word);
//             longestWord = getLongest(result, longestWord);
//         }
//         return longestWord;
//     }

//     private String bfs(Map<String, List<String>> neighborMap, String startingWord) {
//         String longestWord = "";
//         Queue<String> queue = new LinkedList<>();
//         queue.add(startingWord);

//         while (!queue.isEmpty()) {
//             String current = queue.poll();
//             if (neighborMap.get(current).size() == 0) {
//                 longestWord = getLongest(longestWord, current);
//             }
//             for (String neighbor : neighborMap.get(current)) {
//                 queue.add(neighbor);
//             }
//         }
//         return longestWord;
//     }

//     private Map<String, List<String>> buildNeighborMap (String[] words) {
//         Map<String, List<String>> neighborMap = new HashMap<>();
//         for (String word : words) {
//             neighborMap.put(word, new ArrayList<>());
//             for (String neighbor : words) {
//                 if ((neighbor.length() == word.length() + 1)
//                     && neighbor.substring(0, neighbor.length() - 1).equals(word)) {
//                     neighborMap.get(word).add(neighbor);
//                 }
//             }
//         }
//         return neighborMap;
//     }

//     private String getLongest(String s1, String s2) {
//         if (s1.length() > s2.length()) {
//             return s1;
//         }
//         if (s1.length() < s2.length()) {
//             return s2;
//         }
//         if (s2.compareTo(s1) > 0) {
//             return s1;
//         }
//         return s2;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"}));
//     }
// }

// class Solution {
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         int target = graph.length - 1;
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> current = new ArrayList<>();
//         current.add(0);
//         allPathsSourceTargetHelper(graph, target, 0, current, result);
//         return result;
//     }

//     public void allPathsSourceTargetHelper(int[][] graph, int target, int index, List<Integer> current, List<List<Integer>> result) {
//         for (int num : graph[index]) {
//             current.add(num);
//             if (num == target) {
//                 result.add(new ArrayList<>(current));
//             }
//             allPathsSourceTargetHelper(graph, target, num, current, result);
//             current.remove(current.size() - 1);
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
//     }
// }

