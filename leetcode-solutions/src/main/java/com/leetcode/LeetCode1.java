package com.leetcode;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Calendar;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Set;
// import java.util.Stack;
// import java.util.TreeMap;
// import java.util.Map;
// import java.util.Optional;
// import java.util.PriorityQueue;
// import java.util.Queue;
// import java.util.Random;
// import java.util.Scanner;
// import java.util.TreeSet;
// import java.util.Map.Entry;
// import java.lang.Math;
// import java.net.Socket;
// import java.util.Iterator;

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
//             allPathsSourceTargetHelper(graph, target, index + num, current, result);
//             current.remove(current.size() - 1);
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
//     }
// }

// class FoodRatings {
//     class FoodRating implements Comparable<FoodRating> {
//         String food;
//         int rating;
//         public FoodRating(String food, int rating) {
//             this.food = food;
//             this.rating = rating;
//         }
//         public int compareTo(FoodRating fr) {
//             if (this.rating > fr.rating) {
//                 return 1;
//             }
//             if (this.rating < fr.rating) {
//                 return -1;
//             }
//             return fr.food.compareTo(this.food);
//         }
//     }

//     class CuisineRating {
//         String cuisine;
//         int rating;
//         public CuisineRating (String cuisine, int rating) {
//             this.cuisine = cuisine;
//             this.rating = rating;
//         }
//     }

//     private Map<String, CuisineRating> foodToCuisineRating = new HashMap<>();
//     private Map<String, TreeSet<FoodRating>> cuisineToRatings = new HashMap<>(); 

//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         for (int i = 0; i < foods.length; i++) {
//             String food = foods[i];
//             String cuisine = cuisines[i];
//             int rating = ratings[i];
//             foodToCuisineRating.put(food, new CuisineRating(cuisine, rating));

//             if (!cuisineToRatings.containsKey(cuisine)) {
//                 cuisineToRatings.put(cuisine, new TreeSet<>());
//             }
//             cuisineToRatings.get(cuisine).add(new FoodRating(food, rating));
//         }
//     }
    
//     public void changeRating(String food, int newRating) {
//         String cuisine = foodToCuisineRating.get(food).cuisine;
//         int rating = foodToCuisineRating.get(food).rating;
//         TreeSet<FoodRating> treeSet = cuisineToRatings.get(cuisine);
//         treeSet.remove(new FoodRating(food, rating));
//         treeSet.add(new FoodRating(food, newRating));
//         foodToCuisineRating.put(food, new CuisineRating(cuisine, rating));
//     }
    
//     public String highestRated(String cuisine) {
//         return cuisineToRatings.get(cuisine).last().food;
//     }

//     public static void main(String[] args) {
//         FoodRatings foodRatings = new FoodRatings(
//             new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, 
//             new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, 
//             new int[]{9, 12, 8, 15, 14, 7});
//         System.out.println(foodRatings.highestRated("korean"));
//         foodRatings.changeRating("sushi", 16);
//         foodRatings.changeRating("ramen", 16);
//     }
// }


// class DataStream {
//     private Queue<Integer> queue = new LinkedList<>();
//     private int size;
//     private int value;
//     private int count = 0;

//     public DataStream(int value, int k) {
//         this.size = k;
//         this.value = value;
//     }
    
//     public boolean consec(int num) {
//         if (queue.size() == size) {
//             int pop = queue.poll();
//             if (pop != value) {
//                 count--;
//             }
//         }
//         if (num != value) {
//             count++;
//         }
//         queue.add(num);
//         return count == 0 && queue.size() == size;
//     }
// }


// class Solution {
//     public String multiply(String num1, String num2) {
//         if (isZero(num1) || isZero(num2)) {
//             return "0";
//         }

//         List<String> factors = new ArrayList<>();
//         int tens = 0;
//         for (int i = num2.length() - 1; i >= 0; i--) {
//             StringBuilder factor = new StringBuilder();
//             int digit2 = Character.getNumericValue(num2.charAt(i));
//             for (int zero = 0; zero < (num2.length() - i - 1); zero++) {
//                 factor.append('0');
//             }
//             for (int j = num1.length() - 1; j >= 0; j--) {
//                 int digit1 = Character.getNumericValue(num1.charAt(j));
//                 int product = digit1 * digit2 + tens;
//                 factor.append(product % 10);
//                 tens = product / 10;
//             }
//             if (tens > 0) {
//                 factor.append(tens);
//             }
//             tens = 0;
//             factors.add(factor.reverse().toString());
//         }

//         String result = "0";
//         int remainder = 0;
//         for (String factor : factors) {
//             StringBuilder sb = new StringBuilder();
//             int index = 0;
//             while (index < result.length() && index < factor.length()) {
//                 int digit1 = Character.getNumericValue(result.charAt(result.length() - (index + 1)));
//                 int digit2 = Character.getNumericValue(factor.charAt(factor.length() - (index + 1)));
//                 int sum = digit1 + digit2 + remainder;
//                 sb.append(sum % 10);
//                 remainder = sum / 10;
//                 index++;
//             }
//             while (index < result.length()) {
//                 int digit1 = result.charAt(result.length() - (index + 1));
//                 int sum = digit1 + remainder;
//                 sb.append(sum % 10);
//                 remainder = sum / 10;
//                 index++;
//             }
//             while (index < factor.length()) {
//                 int digit2 = Character.getNumericValue(factor.charAt(factor.length() - (index + 1)));
//                 int sum = digit2 + remainder;
//                 sb.append(sum % 10);
//                 remainder = sum / 10;
//                 index++;
//             }
//             if (remainder > 0) {
//                 sb.append(remainder);
//             }
//             remainder = 0;
//             result = sb.reverse().toString();
//         }
//         return result;
//     }

//     private boolean isZero(String num) {
//         if (num.length() == 1 && num.charAt(0) == '0') {
//             return true;
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().multiply("123", "45"));
//         System.out.println(new Solution().multiply("9", "99"));
//         System.out.println(new Solution().multiply("9", "9"));
//     }
// }


// class Bitset {
//     private int[] bitsetArray;
//     private int size;
//     private int lastInt = size / 32;
//     private int remainder = size % 32;

//     public Bitset(int size) {
//         this.bitsetArray = new int[(size + 31) / 32];
//         this.size = size;
//     }
    
//     public void fix(int idx) {
//         int index = idx / 32;
//         int mask = 1 << (31 - (idx % 32));
//         bitsetArray[index] |= mask;
//     }
    
//     public void unfix(int idx) {
//         int index = idx / 32;
//         int invertedMask = ~(1 << (31 - (idx % 32)));
//         bitsetArray[index] &= invertedMask;
//     }
    
//     public void flip() {
//         for (int i = 0; i < lastInt; i++) {
//             bitsetArray[i] = ~bitsetArray[i];
//         }
//         if (remainder != 0) {
//             int mask = (1 << remainder) - 1;
//             mask <<= (32 - remainder);
//             bitsetArray[lastInt] ^= mask;
//         }
//     }
    
//     public boolean all() {
//         int count = count();
//         return count == size;
//     }
    
//     public boolean one() {
//         for (int num : bitsetArray) {
//             if (num != 0) {
//                 return true;
//             }
//         }
//         return false;
//     }
    
//     public int count() {
//         int count = 0;
//         for (int num : bitsetArray) {
//             count += Integer.bitCount(num);
//         }
//         return count;
//     }
    
//     public String toString() {
//         StringBuilder result = new StringBuilder(size);
//         for (int i = 0; i < size; i++) {
//             int num = bitsetArray[i / 32];
//             if ((num & (1 << 31 - (i % 32))) != 0) {
//                 result.append("1");
//             } else {
//                 result.append("0");
//             }
//         }
//         return result.toString();
//     }
    
//     public static void main(String[] args) {
//         Bitset bs = new Bitset(5);
//         System.out.println(bs.toString());
//         bs.fix(3);
//         System.out.println(bs.toString());
//         bs.fix(1);
//         System.out.println(bs.toString());
//         bs.flip();
//         System.out.println(bs.toString());
//         System.out.println(bs.all());
//         bs.unfix(0);
//         System.out.println(bs.toString());
//         bs.flip();
//         System.out.println(bs.toString());
//         System.out.println(bs.one());
//         bs.unfix(0);
//         System.out.println(bs.toString());
//         System.out.println(bs.count());
//         System.out.println(bs.toString());
//     }
// }

// class Spreadsheet {
//     Map<String, Integer> spreadsheet = new HashMap<>();

//     public Spreadsheet(int rows) {
        
//     }
    
//     public void setCell(String cell, int value) {
//         spreadsheet.put(cell, value);
//     }
    
//     public void resetCell(String cell) {
//         spreadsheet.remove(cell);
//     }
    
//     public int getValue(String formula) {
//         int sum = 0;
//         List<String> summands = getSummands(formula);
//         for (String summand : summands) {
//             if (spreadsheet.containsKey(summand)) {
//                 sum += spreadsheet.get(summand);
//             } else if (!isACell(summand)) {
//                 sum += Integer.valueOf(summand);
//             }
//         }
//         return sum;
//     }

//     private List<String> getSummands(String formula) {
//         List<String> summands = new ArrayList<>();
//         int index = 1;
//         while (index < formula.length()) {
//             StringBuilder sb = new StringBuilder();
//             while (index < formula.length() && formula.charAt(index) != '+') {
//                 sb.append(formula.charAt(index));
//                 index++;
//             }
//             summands.add(sb.toString());
//             index++;
//         }
//         return summands;
//     }

//     private boolean isACell(String summand) {
//         int first = Character.getNumericValue(summand.charAt(0));
//         return first >= 10;
//     }
// }


// class Solution {
//     class Pair {
//         int frequency;
//         int val;
//         public Pair (int frequency, int val) {
//             this.frequency = frequency;
//             this.val = val;
//         }
//     }

//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
//         for (int num : nums) {
//             if (!numToFrequencyMap.containsKey(num)) {
//                 numToFrequencyMap.put(num, 0);
//             }
//             numToFrequencyMap.put(num, 1 + numToFrequencyMap.get(num));
//         }

//         PriorityQueue<Pair> minHeap = new PriorityQueue<>(
//             (a, b) -> Integer.compare(a.frequency, b.frequency)
//         );
//         for (int num : numToFrequencyMap.keySet()) {
//             Pair pair = new Pair(numToFrequencyMap.get(num), num);
//             if (minHeap.size() < k) {
//                 minHeap.add(pair);
//             } else if (minHeap.peek().frequency < pair.frequency) {
//                 minHeap.poll();
//                 minHeap.add(pair);
//             }
//         }

//         int[] result = new int[k];
//         for (int i = 0; i < result.length; i++) {
//             result[i] = minHeap.poll().val;
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 1));
//     }
// }

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         return maximalSquareHelper(matrix, 0, 0);
//     }

//     private int maximalSquareHelper(char[][] matrix, int row, int col) {
//         if (row >= matrix.length || col >= matrix[0].length) {
//             return 0;
//         }

//         int maxSquareRight = maximalSquareHelper(matrix, row, col + 1);
//         int maxSquareDown = maximalSquareHelper(matrix, row + 1, col);

//         if (matrix[row][col] == '0') {
//             return 0 + Math.max(maxSquareRight, maxSquareDown);
//         }

//         if (row + maxSquareDown < matrix.length && col + maxSquareRight < matrix[0].length
//             && matrix[row + maxSquareDown][col + maxSquareRight] == '0') {
//             return Math.max(maxSquareRight, maxSquareDown);
//         }

//         int edge = (int) Math.sqrt(Math.min(maxSquareRight, maxSquareDown)) + 1;
//         return (int) Math.pow(edge, 2);
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().maximalSquare(new char[][]{{'0','1'},{'1','0'}}));
//         System.out.println(new Solution().maximalSquare(new char[][]{{'0'}}));
//         System.out.println(new Solution().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
//     }
// }

// class SnapshotArray {
//     private int id = 0;
//     private TreeMap<Integer, Integer>[] treemapArray;

//     public SnapshotArray(int length) {
//         this.treemapArray = new TreeMap[length];
//         for (int i = 0; i < length; i++) {
//             treemapArray[i] = new TreeMap<>();
//         }
//     }
    
//     public void set(int index, int val) {
//         treemapArray[index].put(id, val);
//     }
    
//     public int snap() {
//         int snapId = id++;
//         return snapId;
//     }   
    
//     public int get(int index, int snap_id) {
//         int snapId = treemapArray[index].floorKey(snap_id);
//         return treemapArray[index].get(snapId);
//     }
// }

// class SnapshotArray {
//     private int length;
//     private int id = 0;
//     private int[] currentArray;
//     private Map<Integer, int[]> idToArray = new HashMap<>();

//     public SnapshotArray(int length) {
//         this.length = length;
//         this.currentArray = new int[length];
//     }
    
//     public void set(int index, int val) {
//         currentArray[index] = val;
//     }
    
//     public int snap() {
//         int currentId = id;
//         int[] snapArray = Arrays.copyOf(currentArray, length);
//         idToArray.put(currentId, snapArray);
//         id++;
//         return currentId;
//     }
    
//     public int get(int index, int snap_id) {
//         int num = idToArray.get(snap_id)[index];
//         return num;
//     }
// }

// class Solution {
//     public int fibonacci(int num) {
//         double constant = 1 / Math.sqrt(5);
//         double ratio1 = (1 + Math.sqrt(5)) / 2;
//         double ratio2 = (1 - Math.sqrt(5)) / 2;
//         double result = constant * Math.pow(ratio1, (num + 1)) - constant * Math.pow(ratio2, (num + 1));
//         return (int) result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().fibonacci(2));
//         System.out.println(new Solution().fibonacci(3));
//         System.out.println(new Solution().fibonacci(4));
//         System.out.println(new Solution().fibonacci(5));
//     }
// }

// class SmallestInfiniteSet {
//     private int smallestInt = 1;
//     Set<Integer> numsInHeapSet = new HashSet<>();
//     PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//     public SmallestInfiniteSet() {
        
//     }
    
//     public int popSmallest() {
//         if (numsInHeapSet.add(smallestInt)) {
//             minHeap.add(smallestInt);
//         }
//         smallestInt++;

//         int result = minHeap.poll();
//         numsInHeapSet.remove(result);
//         return result;
//     }
    
//     public void addBack(int num) {
//         if (numsInHeapSet.add(num)){
//             minHeap.add(num);
//         }
//     }
// }



// class Solution {
//     public int leastBricks(List<List<Integer>> wall) {
//         Map<Integer, Integer> positionToEdgesMap = new HashMap<>();
//         for (int row = 0; row < wall.size(); row++) {
//             for (int col = 0; col < wall.get(row).size() - 1; col++) {
//                 int position = wall.get(row).get(col);
//                 if (!positionToEdgesMap.containsKey(position)) {
//                     positionToEdgesMap.put(position, 0);
//                 }
//                 positionToEdgesMap.put(position, 1 + positionToEdgesMap.get(position));
//             }
//         }

//         if (positionToEdgesMap.size() == 0) {
//             return wall.size();
//         }

//         int mostEdges = 0;
//         for (int edge : positionToEdgesMap.values()) {
//             mostEdges = Math.max(mostEdges, edge);
//         }

//         int leastBricks = wall.size() - mostEdges;
//         return leastBricks;
//     }

//     public static void main(String[] args) {
//         List<Integer> row1 = List.of(1,1);
//         List<Integer> row2 = List.of(2);
//         List<Integer> row3 = List.of(1,1);
//         List<List<Integer>> bricks = new ArrayList<>(){};
//         bricks.add(row1);
//         bricks.add(row2);
//         bricks.add(row3);
//         System.out.println(new Solution().leastBricks(bricks));
//     }
// }


// class Solution {
//     public int countNumbersWithUniqueDigits(int n) {
//         if (n == 0) {
//             return 1;
//         }
//         if (n == 1) {
//             return 10;
//         }
//         int digits = 9 - n + 2;
//         int comb = 9;
//         for (int i = 9; i >= digits; i--) {
//             comb *= i;
//         }
//         return comb + countNumbersWithUniqueDigits(n - 1);
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().countNumbersWithUniqueDigits(2));
//         System.out.println(new Solution().countNumbersWithUniqueDigits(3));
//         System.out.println(new Solution().countNumbersWithUniqueDigits(4));
//         System.out.println(new Solution().countNumbersWithUniqueDigits(8));
//     }
// }



// class NumArray {
//     class Node {
//         int sum;
//         int[] interval;
//         Node left;
//         Node right;
//         public Node () {

//         }
//         public Node(int sum, int[] interval, Node left, Node right) {
//             this.sum = sum;
//             this.interval = interval;
//             this.left = left;
//             this.right = right;
//         }
//         public boolean isLeaf() {
//             return interval[1] == interval[0];
//         }
//     }

//     private Node head;

//     public NumArray(int[] nums) {
//         head = buildTree(nums, 0, nums.length - 1);
//     }

//     private Node buildTree(int[] nums, int left, int right) {
//         int leaves = right - left + 1;

//         if (leaves == 0) {
//             return null;
//         }

//         if (leaves == 1) {
//             return new Node(
//                 nums[left],
//                 new int[]{left, right},
//                 null,
//                 null);
//         }

//         int middle = left + ((right - left) / 2);
//         Node leftNode = buildTree(nums, left, middle);
//         Node rightNode = buildTree(nums, middle + 1, right);

//         return new Node(
//             leftNode.sum + rightNode.sum,
//             new int[]{left, right},
//             leftNode,
//             rightNode);
//     }
    
//     public void update(int index, int val) {
//         Stack<Node> stack = new Stack<>();
//         stack.add(head);

//         while (!stack.peek().isLeaf()) {
//             Node current = stack.peek();
//             if (index <= current.left.interval[1]) {
//                 stack.add(current.left);
//             } else {
//                 stack.add(current.right);
//             }
//         }

//         int oldVal = 0;
//         while (!stack.isEmpty()) {
//             Node current = stack.pop();
//             if (current.isLeaf()) {
//                 oldVal = current.sum;
//             }
//             current.sum = current.sum - oldVal + val; 
//         }
//     }
    
//     public int sumRange(int left, int right) {
//         return sumRangeHelper(head, left, right);
//     }

//     private int sumRangeHelper(Node current, int left, int right) {
//         if (current.interval[0] <= left && current.interval[1] >= right) {
//             return current.sum;
//         }

//         if (current.interval[1] < left || current.interval[0] > right) {
//             return 0;
//         }

//         return sumRangeHelper(current.left, left, right) + sumRangeHelper(current.right, left, right);
//     }
// }

// class Solution {
//     class Edge {
//         int node;
//         int price;
//         public Edge(int node, int price) {
//             this.node = node;
//             this.price = price;
//         }
//     }
    
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int minPrice = Integer.MAX_VALUE;
//         List<List<Edge>> nodeToNeighborList = buildAdjList(n, flights);
//         Queue<Edge> queue = new LinkedList<>();
//         queue.add(new Edge(src, 0));
        
//         while (!queue.isEmpty() && k >= 0) {
//             int size = queue.size();
//             while (size > 0) {
//                 Edge current = queue.poll();
//                 for (Edge neighbor : nodeToNeighborList.get(current.node)) {
//                     if (neighbor.node == dst) {
//                         minPrice = Math.min(minPrice, current.price + neighbor.price);
//                     }
//                     queue.add(new Edge(neighbor.node, current.price + neighbor.price));
//                 }   
//                 size--;
//             }
//             k--;
//         }

//         if (minPrice == Integer.MAX_VALUE) {
//             return -1;
//         }
//         return minPrice;
//     }

//     private List<List<Edge>> buildAdjList(int n, int[][] flights) {
//         List<List<Edge>> adjList = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<>());
//         }
//         for (int[] flight : flights) {
//             adjList.get(flight[0]).add(new Edge(flight[1], flight[2]));
//         }
//         return adjList;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));
//         System.out.println(new Solution().findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
//         System.out.println(new Solution().findCheapestPrice(5, new int[][]{{1,0,5},{2,1,5},{3,0,2},{1,3,2},{4,1,1},{2,4,1}}, 2, 0, 2));
//         //500
//         //200
//         //7
//     }
// }

// class Solution {
//     class Edge {
//         int node;
//         double prob;
//         public Edge(int node, double prob) {
//             this.node = node;
//             this.prob = prob;
//         }
//     }

//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         double[] probabilities = new double[n];
//         Map<Integer, List<Edge>> adjMap = buildMap(n, edges, succProb);
//         PriorityQueue<Edge> pq = new PriorityQueue<>(
//             (a, b) -> Double.compare(b.prob, a.prob)
//         );
//         probabilities[start_node] = 1;
//         pq.add(new Edge(start_node, probabilities[start_node]));
        

//         while (!pq.isEmpty()) {
//             Edge currentEdge = pq.poll();
//             if (currentEdge.node == end_node) {
//                 return currentEdge.prob;
//             }
//             if (probabilities[currentEdge.node] > currentEdge.prob) {
//                 continue;
//             }
//             double currentProb = currentEdge.prob;
//             if (adjMap.get(currentEdge.node) != null) {
//                 for (Edge neighbor : adjMap.get(currentEdge.node)) {
//                     if (probabilities[neighbor.node] < (currentProb * neighbor.prob)) {
//                         probabilities[neighbor.node] = (currentProb * neighbor.prob);
//                         pq.add(new Edge(neighbor.node, probabilities[neighbor.node]));
//                     }
//                 }
//             }
//         }

//         return probabilities[end_node];
//     }

//     private Map<Integer, List<Edge>> buildMap(int n, int[][] edges, double[] succProb) {
//         Map<Integer, List<Edge>> adjMap = new HashMap<>();
//         for (int i = 0; i < edges.length; i++) {
//             int[] edge = edges[i];
//             if (!adjMap.containsKey(edge[0])) {
//                 adjMap.put(edge[0], new ArrayList<>());
//             }
//             adjMap.get(edge[0]).add(new Edge(edge[1], succProb[i]));
//             if (!adjMap.containsKey(edge[1])) {
//                 adjMap.put(edge[1], new ArrayList<>());
//             }
//             adjMap.get(edge[1]).add(new Edge(edge[0], succProb[i]));
//         }
//         return adjMap;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.3}, 0, 2));
//         System.out.println(new Solution().maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
//         System.out.println(new Solution().maxProbability(5, 
//             new int[][]{{2,3},{1,2},{3,4},{1,3},{1,4},{0,1},{2,4},{0,4},{0,2}}, 
//             new double[]{0.06,0.26,0.49,0.25,0.2,0.64,0.23,0.21,0.77}, 
//             0, 3));
//         //[0.06,0.26,0.49,0.25,0.2,0.64,0.23,0.21,0.77]
//         //[[2,3],[1,2],[3,4],[1,3],[1,4],[0,1],[2,4],[0,4],[0,2]]
//     }
// }

// class NestedInteger {
//     public boolean isInteger() {
//         return true;
//     }
//     public Integer getInteger() {
//         return 0;
//     }
//     public List<NestedInteger> getList() {
//         return new ArrayList<>();
//     }
// }


// class NestedIterator implements Iterator<Integer> {
//     private List<NestedInteger> nestedList;
//     private List<Integer> flattenedList = new ArrayList<>();
//     private int index = 0;

//     public NestedIterator(List<NestedInteger> nestedList) {
//         this.nestedList = nestedList;
//         flattenList(this.nestedList);
//     }

//     public void flattenList(List<NestedInteger> nestedList) {
//         for (NestedInteger nestedInt : nestedList) {
//             if (nestedInt.isInteger()) {
//                 flattenedList.add(nestedInt.getInteger());
//             } else {
//                 flattenList(nestedInt.getList());
//             }
//         }
//     }

//     @Override
//     public Integer next() {
//         int next = flattenedList.get(index);
//         index++;
//         return next;
//     }

//     @Override
//     public boolean hasNext() {
//         return index < flattenedList.size();
//     }
// }

// class Solution {
//     class Node {
//         int label;
//         int time;
//         public Node(int label, int time) {
//             this.label = label;
//             this.time = time;
//         }
//     }

//     public int networkDelayTime(int[][] times, int n, int k) {
//         int delayTime = 0;
//         Map<Integer, List<Node>> adjMap = buildAdjMap(times, n);
//         int[] distances = new int[n+1];
//         for (int i = 1; i < distances.length; i++) {
//             if (i == k) {
//                 distances[i] = 0;
//             } else {
//                 distances[i] = Integer.MAX_VALUE;
//             }
//         }

//         Set<Integer> visited = new HashSet<>();
//         PriorityQueue<Node> queue = new PriorityQueue<>(
//             (a,b) -> Integer.compare(a.time, b.time)
//         );
//         queue.add(new Node(k, 0));
        
//         while (!queue.isEmpty()) {
//             Node current = queue.poll();
//             int currentMax = distances[current.label];
//             delayTime = currentMax;
//             visited.add(current.label);
//             if (adjMap.get(current.label) == null) {
//                 continue;
//             }
//             for (Node neighbor : adjMap.get(current.label)) {
//                 if (visited.contains(neighbor.label)) {
//                     continue;
//                 }
//                 if (distances[neighbor.label] > neighbor.time + currentMax) {
//                     distances[neighbor.label] = neighbor.time + currentMax;
//                 }
//                 queue.add(new Node(neighbor.label, distances[neighbor.label]));
//             }
//         }
        

//         if (visited.size() != n) {
//             return -1;
//         }
//         return delayTime;
//     }

//     private Map<Integer, List<Node>> buildAdjMap(int[][] times, int n) {
//         Map<Integer, List<Node>> adjMap = new HashMap<>();
//         for (int[] time : times) {
//             if (!adjMap.containsKey(time[0])) {
//                 adjMap.put(time[0], new ArrayList<>());
//             }
//             adjMap.get(time[0]).add(new Node(time[1], time[2]));
//         }
//         return adjMap;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));   //2
//         System.out.println(new Solution().networkDelayTime(new int[][] {{1,2,1}}, 2, 1));                   //1
//         System.out.println(new Solution().networkDelayTime(new int[][] {{1,2,1}}, 2, 2));                 //-1
//         System.out.println(new Solution().networkDelayTime(new int[][] {{1,2,1},{2,3,2},{1,3,4}}, 3, 1)); //3
//     }
// }

// class Solution {
//     class Node {
//         int edge;
//         double prob;
//         public Node(int edge, double prob) {
//             this.edge = edge;
//             this.prob = prob;
//         }
//     }

//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         Map<Integer, List<Node>> adjMap = buildAdjMap(n, edges, succProb);
//         double[] probabilities = new double[n];
//         boolean[] visited = new boolean[n];
//         PriorityQueue<Node> maxHeap = new PriorityQueue<>(
//             (a, b) -> Double.compare(b.prob, a.prob)
//         );
        
//         for (Node node : adjMap.get(start_node)) {
//             maxHeap.add(node);
//         }
//         visited[start_node] = true;

//         while (!maxHeap.isEmpty()) {
//             Node current = maxHeap.poll();
//             if (probabilities[current] > ) {
                
//             }
//         }

//         return probabilities[end_node];
//     }

//     private Map<Integer, List<Node>> buildAdjMap(int n, int[][] edges, double[] succProb) {
//         Map<Integer, List<Node>> adjMap = new HashMap<>();
//         for (int i = 0; i < edges.length; i++) {
//             int[] edge = edges[i];
//             if (!adjMap.containsKey(edge[0])) {
//                 adjMap.put(edge[0], new ArrayList<>());
//             }
//             if (!adjMap.containsKey(edge[1])) {
//                 adjMap.put(edge[1], new ArrayList<>());
//             }
//             adjMap.get(edge[0]).add(new Node(edge[1], succProb[i]));
//             adjMap.get(edge[1]).add(new Node(edge[0], succProb[i]));
//         }
//         return adjMap;
//     }

//     public static void main(String[] args) {
//         //System.out.println(new Solution().maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.3}, 0, 2));
//         System.out.println(new Solution().maxProbability(3, new int[][]{{0,1}}, new double[]{0.5}, 0, 2));
//     }
// }

// class Solution {
//     class Letter {
//         int frequency;
//         char character;
//         public Letter (int frequency, char character) {
//             this.frequency = frequency;
//             this.character = character;
//         }
//     }

//     public String reorganizeString(String s) {
//         Map<Character, Integer> frequencyMap = buildFrequencyMap(s);
//         PriorityQueue<Letter> pq = buildPriorityQueue(frequencyMap);
//         StringBuilder sb = new StringBuilder();

//         while (pq.size() >= 2) {
//             Letter firstLetter = pq.poll();
//             Letter secondLetter = pq.poll();
//             sb.append(firstLetter.character);
//             sb.append(secondLetter.character);
//             firstLetter.frequency--;
//             secondLetter.frequency--;

//             if (firstLetter.frequency != 0) {
//                 pq.add(firstLetter);
//             }

//             if (secondLetter.frequency != 0) {
//                 pq.add(secondLetter);
//             }
//         }
        
//         if (!pq.isEmpty() && pq.peek().frequency > 1) {
//             return "";
//         }
//         if (!pq.isEmpty()) {
//             sb.append(pq.poll().character);
//         }
//         return sb.toString();
//     }

//     private Map<Character, Integer> buildFrequencyMap (String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : s.toCharArray()) {
//             if (!map.containsKey(c)) {
//                 map.put(c, 0);
//             }
//             map.put(c, map.get(c) + 1);
//         }
//         return map;
//     }

//     private PriorityQueue<Letter> buildPriorityQueue(Map<Character, Integer> frequencyMap) {
//         PriorityQueue<Letter> pq = new PriorityQueue<>(
//             (obj1, obj2) -> Integer.compare(obj2.frequency, obj1.frequency)
//         );
//         for (char c : frequencyMap.keySet()) {
//             Letter letter = new Letter(frequencyMap.get(c), c);
//             pq.add(letter);
//         }
//         return pq;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().reorganizeString("aab")); //aba
//         System.out.println(new Solution().reorganizeString("aaab")); //
//         System.out.println(new Solution().reorganizeString("abbabbaaab")); //ababababab
//         System.out.println(new Solution().reorganizeString("aabbcc")); //abacbc
//     }
// }

// class Twitter {
//     private Map<Integer, Set<Integer>> userToFollowsMap = new HashMap<>(500);
//     private List<Tweet> tweetList = new ArrayList<>();
//     private int tweetIndex = 0;

//     private class Tweet {
//         int index;
//         int userId;
//         int tweetId;
//         public Tweet(int index, int userId, int tweetId) {
//             this.index = index;
//             this.userId = userId;
//             this.tweetId = tweetId;
//         }
//     }

//     public Twitter() {
        
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         Tweet tweet = new Tweet(tweetIndex, userId, tweetId);
//         tweetList.add(tweet);
//         tweetIndex++;
//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         List<Integer> newsFeed = new ArrayList<>();
//         Set<Integer> followList = new HashSet<>();
//         if (userToFollowsMap.containsKey(userId)) {
//             followList = new HashSet<>(userToFollowsMap.get(userId));
//         }
//         followList.add(userId);

//         PriorityQueue<Tweet> pq = new PriorityQueue<>(
//             (obj1,obj2) -> Integer.compare(obj2.index, obj1.index)
//         );
//         for (Tweet tweet : tweetList) {
//             if (followList.contains(tweet.userId)) {
//                 pq.add(tweet);
//             }
//         }

//         int maxSize = 10;
//         while (maxSize > 0 && pq.size() > 0) {
//             Tweet current = pq.poll();
//             newsFeed.add(current.tweetId);
//             maxSize--;
//         }
//         return newsFeed;
//     }
    
//     public void follow(int followerId, int followeeId) {
//         if (!userToFollowsMap.containsKey(followerId)) {
//             userToFollowsMap.put(followerId, new HashSet<>());
//         }
//         userToFollowsMap.get(followerId).add(followeeId);
//     }
    
//     public void unfollow(int followerId, int followeeId) {
//         if (userToFollowsMap.containsKey(followerId)) {
//             userToFollowsMap.get(followerId).remove(followeeId);
//         }
//     }
// }


// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int left = 0;
//         int right = 0;
//         int count = 0;
//         int sum = 0;

//         while (left < nums.length || right < nums.length) {
//             if (nums[right] == goal) {
//                 count++;
//             }
//             if (condition) {
                
//             }
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
//         System.out.println(new Solution().numSubarraysWithSum(new int[] {0,0,0,0,0}, 0));
//     }
// }

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == goal) {
//                 count++;   
//             }
//             int sum = nums[i];
//             for (int j = i + 1; j < nums.length; j++) {
//                 sum += nums[j];
//                 if (sum == goal) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
//         System.out.println(new Solution().numSubarraysWithSum(new int[] {0,0,0,0,0}, 0));
//     }
// }

// class MyCalendar {
//     private List<int[]> bookings = new ArrayList<>();

//     public MyCalendar() {
        
//     }
    
//     public boolean book(int startTime, int endTime) {
//         int[] newBooking = new int[]{startTime, endTime};
//         for (int[] oldBooking : bookings) {
//             if (isOverlapping(oldBooking, newBooking)) {
//                 return false;
//             }
//         }
//         bookings.add(new int[]{startTime, endTime});
//         return true;
//     }

//     private boolean isOverlapping(int[] oldBooking, int[] newBooking) {
//         if (newBooking[0] >= oldBooking[1] || newBooking[1] < oldBooking[0]) {
//             return false;
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         MyCalendar calendar = new MyCalendar();
//         System.out.println(calendar.book(97, 100));
//         System.out.println(calendar.book(19, 30));
//         System.out.println(calendar.book(20, 25));
//     }
// }

// class MyCalendar {
//     TreeMap<Integer, Integer> calendar = new TreeMap<>();

//     public MyCalendar() {
//         calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
//     }

//     public boolean book(int start, int end) {
//         Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
//         boolean res = end <= pair.getValue();
//         if (res)
//             calendar.put(end, start);
//         return res;
//     }

//     public static void main(String[] args) {
//         MyCalendar calendar = new MyCalendar();
//         System.out.println(calendar.book(97, 100));
//         System.out.println(calendar.book(19, 30));
//         System.out.println(calendar.book(20, 25));
//     }
// }


// class MyCircularQueue {
//     private Integer[] queue;
//     private int size;
//     private int frontIndex = 0;
//     private int rearIndex = 0;

//     public MyCircularQueue(int k) {
//         size = k;
//         queue = new Integer[size];
//     }
    
//     public boolean enQueue(int value) {
//         if (isFull()) {
//             return false;
//         }

//         // if (!isEmpty()) {
//         //     rearIndex = (rearIndex + 1) % size;
//         // }

//         queue[rearIndex] = value;
//         rearIndex = (rearIndex + 1) % size;
//         return true;
//     }
    
//     public boolean deQueue() {
//         if (isEmpty()) {
//             return false;
//         }

//         queue[frontIndex] = null;
//         int nextFrontIndex = (frontIndex + 1) % size;

//         if (queue[nextFrontIndex] != null) {
//             frontIndex = nextFrontIndex;
//         }
//         return true;
//     }
    
//     public int Front() {
//         if (isEmpty()) {
//             return -1;
//         }
//         return queue[frontIndex];
//     }
    
//     public int Rear() {
//         if (isEmpty()) {
//             return -1;
//         }
//         return queue[rearIndex];
//     }
    
//     public boolean isEmpty() {
//         return rearIndex == frontIndex;
//     }
    
//     public boolean isFull() {
//         return frontIndex == (rearIndex + 1) % size;
//     }


// }

// class Solution {
//     class LockState {
//         public static final int DIAL_COUNT = 4;

//         public int[] dials;
//         public LockState(int[] dials) {
//             this.dials = dials;
//         }

//         public LockState copy() {
//             int[] dialsCopy = Arrays.copyOf(dials, DIAL_COUNT);
//             return new LockState(dialsCopy);
//         }
//     }

//     // class Lock {
//     //     private int[] nums = new int[4];
//     //     public Lock(String state) {
//     //         for (int i = 0; i < state.length(); i++) {
//     //             nums[i] = Character.getNumericValue(state.charAt(i));
//     //         }
//     //     }
//     //     public String[] possibleTurns() {
//     //         String[] turns = new String[8];
//     //         int index = 0;
//     //         for (int i = 0; i < nums.length; i++) {
//     //             int prev = nums[i];
//     //             nums[i] = (nums[i] + 1) % 10;
//     //             turns[index++] = toKey();
//     //             nums[i] = prev;
//     //             nums[i] = (nums[i] - 1) % 10;
//     //             turns[index++] = toKey();
//     //             nums[i] = prev;
//     //         }
//     //         return turns;
//     //     }
//     //     private String toKey() {
//     //         StringBuilder sb = new StringBuilder();
//     //         for (int num: nums) {
//     //             sb.append(num);
//     //         }
//     //         return sb.toString();
//     //     }
//     // }

//     public int openLock(String[] deadends, String target) {
//         String start = "0000";
//         if (target.equals(start)) {
//             return 0;
//         }
//         Set<String> invalidSet = new HashSet<>();
//         for (String turn : deadends) {
//             invalidSet.add(turn);
//             if (turn.equals(start)) {
//                 return -1;
//             }
//         }
//         return bfs(invalidSet, target, start);
//     }

//     private String toKey(LockState lockState) {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < lockState.dials.length; i++) {
//             sb.append(lockState.dials[i]);
//         }
//         return sb.toString();
//     }

//     private LockState fromKey(String key) {
//         int[] dials = new int[LockState.DIAL_COUNT];
//         for (int i = 0 ; i < key.length(); i++) {
//             dials[i] = Character.getNumericValue(key.charAt(i));
//         }
//         return new LockState(dials);
//     }

//     private List<String> neighbors(LockState lockState) {
//         List<String> neighbors = new ArrayList<>(8);
//         for (int i = 0 ; i < lockState.dials.length; i++) {  
//             LockState neighborNext = lockState.copy();
//             neighborNext.dials[i] = (lockState.dials[i] + 1) % 10;
//             neighbors.add(toKey(neighborNext));

//             LockState neighborPrev = lockState.copy();
//             neighborPrev.dials[i] = (lockState.dials[i] - 1) % 10;

//             neighbors.add(toKey(neighborPrev));
//         }
//         return neighbors;
//     }

//     private int bfs(Set<String> invalidSet, String target, String start) {
//         Queue<String> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<>();
//         queue.add(start);
//         visited.add(start);
//         int level = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (size > 0) {
//                 String current = queue.poll();
//                 if (current.equals(target)) {
//                     return level;
//                 }
//                 LockState lockState = fromKey(current);
//                 for (String turn : neighbors(lockState)) {
//                     if (!visited.contains(turn) && !invalidSet.contains(turn)) {
//                         queue.add(turn);
//                         visited.add(turn);
//                     }
//                 }
//                 size--;
//             }
//             level++;
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         //System.out.println(new Solution().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
//         System.out.println(new Solution().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
//         System.out.println(new Solution().openLock(new String[]{"8888"}, "0009"));
//     }
// }

// class Solution {
//     private Map<Integer, List<Integer>> numToIndicesMap = new HashMap<>();
//     private Random random = new Random();

//     public Solution(int[] nums) {
//         buildMap(nums);
//     }

//     private void buildMap(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             if (!numToIndicesMap.containsKey(nums[i])) {
//                 numToIndicesMap.put(nums[i], new ArrayList<>());
//             }
//             numToIndicesMap.get(nums[i]).add(i);
//         }
//     }
    
//     public int pick(int target) {
//         List<Integer> indices = numToIndicesMap.get(target);
//         int size = indices.size();
//         int index = random.nextInt(size);
//         return indices.get(index);
//     }
// }

// class Codec {
//     public Codec(){}

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         StringBuilder sb = new StringBuilder();
//         buildString(sb, root);
//         return sb.toString();
//     }

//     private void buildString(StringBuilder sb, TreeNode root) {
//         sb.append("(");
//         if (root != null) { 
//             sb.append(root.val);
//             buildString(sb, root.left);
//             buildString(sb, root.right);
//         } 
//         sb.append(")"); 
//     } 

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         StringPtr stringPtr = new StringPtr(data);
//         return buildTree(stringPtr);
//     }

//     class StringPtr {
//         private int index;
//         private String str;
//         public StringPtr(String str) {
//             this.str = str;
//         }
//         public char next() {
//             return str.charAt(index++);
//         }
//         public boolean isDone() {
//             return index >= str.length();
//         }
//         public char peek() {
//             return str.charAt(index);
//         }
//     }

//     private TreeNode buildTree(StringPtr stringPtr) {
//         stringPtr.next(); 
//         TreeNode node;
//         Optional<Integer> num = parseInt(stringPtr);
//         if (num.isPresent()) {
//             node = new TreeNode(num.get());
//             node.left = buildTree(stringPtr);
//             node.right = buildTree(stringPtr);
//         } else {
//             node = null;
//         }
//         stringPtr.next(); 
//         return node;
//     }

//     private Optional<Integer> parseInt(StringPtr stringPtr) {
//         StringBuilder sb = new StringBuilder();
//         while (!stringPtr.isDone() && stringPtr.peek() != ')' && stringPtr.peek() != '(') {
//             sb.append(stringPtr.next());
//         }
//         if (sb.length() == 0) {
//             return Optional.empty();
//         }
//         return Optional.of(Integer.parseInt(sb.toString()));
//     }
//     public static void main(String[] args) {
//         TreeNode foo = new Codec().deserialize("(2(1()())(3()()))");  
//     }
// }

// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         Map<Character, Integer> map = new HashMap<>();

//         char[] letters = s.toCharArray();
//         for (int i = 0; i < letters.length; i++) {
//             char letter = letters[i];
//             map.put(letter, i);
//         }

//         List<Integer> result = new ArrayList<>();
//         int count = 1;
//         int max = 0;

//         for (int i = 0; i < s.length(); i++) {
//             int end = map.get(letters[i]);
//             max = Math.max(max, end);
//             if (max == i) {
//                 result.add(count);
//                 count = 0;
//             }
//             count++;
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
//     }
// }

// class Solution {
//     public int[] maxKDistinct(int[] nums, int k) {
//         Arrays.sort(nums);
//         List<Integer> maxNums = new ArrayList<>();
//         int index = nums.length - 1;

//         while (maxNums.size() != k && index >= 0) {
//             if (index < nums.length - 1 && nums[index] == nums[index + 1]) {
//                 index--;
//                 continue;
//             }
//             maxNums.add(nums[index]);
//             index--;
//         }

//         int[] result = new int[maxNums.size()];
//         for (int i = 0; i < maxNums.size(); i++) {
//             result[i] = maxNums.get(i);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(new Solution().maxKDistinct(new int[] {84,93,100,77,93}, 3)));
//     }
// }

// class Solution {
//     public long splitArray(int[] nums) {
//         long min = Long.MAX_VALUE;
//         boolean[][] preffixes = buildPreffixes(nums);

//         for (int i = 0; i < preffixes.length; i++) {
//             if (preffixes[i][0] && preffixes[i][1]) {
//                 long sum = Math.abs(sumLeft(nums, i) - sumRight(nums, i));
//                 min = Math.min(min, sum);
//             }
//         }

//         if (min == Long.MAX_VALUE) {
//             min = -1;
//         }
//         return min;
//     }

//     private long sumLeft(int[] nums, int index) {
//         long sum = 0;
//         for (int i = 0; i <= index; i++) {
//             sum += nums[i];
//         }
//         return sum;
//     }

//     private long sumRight(int[] nums, int index) {
//         long sum = 0;
//         for (int i = index + 1; i < nums.length; i++) {
//             sum += nums[i];
//         }
//         return sum;
//     }

//     private boolean[][] buildPreffixes(int[] nums) {
//         boolean[][] preffixes = new boolean[nums.length - 1][2];
//         boolean inc = true;
//         boolean dec = true;
//         preffixes[0][0] = inc;
//         preffixes[preffixes.length - 1][1] = dec;

//         for (int i = 1; i < preffixes.length; i++) {
//             if (nums[i] <= nums[i - 1]) {
//                 inc = false;
//             }
//             preffixes[i][0] = inc;
//         }

//         for (int i = preffixes.length - 2; i >= 0; i--) {
//             if (nums[i + 1] <= nums[i + 2]) {
//                 dec = false;
//             }
//             preffixes[i][1] = dec;
//         }
//         return preffixes;
//     }
// }

// class Solution {
//     public int[] decimalRepresentation(int n) {
//         List<Integer> decimals = new ArrayList<>();
//         int tens = 1;
//         while (n != 0) {
//             int num = n % 10;
//             n /= 10;
//             if (num != 0) {
//                 decimals.add(num * tens);
//             }
//             tens *= 10;
//         }
//         int[] result = new int[decimals.size() - 1];
//         Collections.reverse(decimals);
//         for (int i = 0; i < decimals.size(); i++) {
//             result[i] = decimals.get(i);
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().decimalRepresentation(102));
//     }
// }

// class FrequencyTracker {
//     private Map<Integer, Integer> numToFrequency = new HashMap<>();
//     private Map<Integer, Integer> frequencyToNum = new HashMap<>();

//     public FrequencyTracker() {
        
//     }
    
//     public void add(int number) {
//         if (!numToFrequency.containsKey(number)) {
//             numToFrequency.put(number, 0);
//         }
//         int frequency = numToFrequency.get(number);
//         if (frequency != 0 && frequencyToNum.containsKey(frequency)) {
//             frequencyToNum.put(frequency, frequencyToNum.get(frequency) - 1);
//         }
        
//         frequency++;
//         if (!frequencyToNum.containsKey(frequency)) {
//             frequencyToNum.put(frequency, 0);
//         }
//         frequencyToNum.put(frequency, frequencyToNum.get(frequency) + 1);
//         numToFrequency.put(number, frequency);
//     }
    
//     public void deleteOne(int number) {
//         if (!numToFrequency.containsKey(number)) {
//             return;
//         }
//         int frequency = numToFrequency.get(number);
//         if (!frequencyToNum.containsKey(frequency)) {
//             frequencyToNum.put(frequency, 0);
//         } else {
//             frequencyToNum.put(frequency, frequencyToNum.get(frequency) - 1);
//         }

//         frequency--;
//         if (frequency == 0) {
//             numToFrequency.remove(number);
//             return;
//         }
//         if (!frequencyToNum.containsKey(frequency)) {
//             frequencyToNum.put(frequency, 0);
//         }
//         frequencyToNum.put(frequency, frequencyToNum.get(frequency) + 1);
//         numToFrequency.put(number, frequency);
//     }
    
//     public boolean hasFrequency(int frequency) {
//         if (frequencyToNum.containsKey(frequency)) {
//             return frequencyToNum.get(frequency) != 0;
//         }
//         return false;
//     }
// }

// class SeatManager {
//     private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//     public SeatManager(int n) {
//         for (int i = 1; i <= n; i++) {
//             minHeap.add(i);
//         }
//     }
    
//     public int reserve() {
//         return minHeap.poll();
//     }
    
//     public void unreserve(int seatNumber) {
//         minHeap.add(seatNumber);
//     }
// }

// class Solution {
//     public int[] findFrequentTreeSum(TreeNode root) {
//         Map<Integer, Integer> frequencyMap = new HashMap<>();
//         calculateSum(root, frequencyMap);
//         List<Integer> sumList = getMaxSums(frequencyMap);

//         int[] result = new int[sumList.size()];
//         for (int i = 0; i < result.length; i++) {
//             result[i] = sumList.get(i);
//         }
//         return result;
//     }

//     private int calculateSum(TreeNode node, Map<Integer, Integer> frequencyMap) {
//         if (node == null) {
//             return 0;
//         }

//         int leftSum = calculateSum(node.left, frequencyMap);
//         int rightSum = calculateSum(node.right, frequencyMap);
//         int sum = node.val + leftSum + rightSum;

//         if (!frequencyMap.containsKey(sum)) {
//             frequencyMap.put(sum, 0);
//         }
//         frequencyMap.put(sum, 1 + frequencyMap.get(sum));

//         return sum;
//     }

//     private List<Integer> getMaxSums(Map<Integer, Integer> frequencyMap) {
//         List<Integer> sumList = new ArrayList<>();
//         int max = 0;

//         for (int frequency : frequencyMap.values()) {
//             max = Math.max(max, frequency);
//         }

//         for (int sum : frequencyMap.keySet()) {
//             if (frequencyMap.get(sum) == max) {
//                 sumList.add(sum);
//             }
//         }

//         return sumList;
//     }
// }

// class Solution {
//     public List<List<String>> partition(String s) {
//         List<List<String>> partitionList = new ArrayList<>();
//         Map<Integer, List<String>> memo = new HashMap<>();
//         partitionHelper(s, 0, new ArrayList<>(), partitionList, memo);
//         return partitionList;
//     }

//     private List<List<String>> partition2(String s, int start, Map<Integer, List<List<String>>> memo) {
//         if (memo.containsKey(start)) {
//             return memo.get(start);
//         }
//         List<List<String>> partitionList = new ArrayList<>();
//         partitionHelper(s, 0, new ArrayList<>(), partitionList);
//         memo.put(start, partitionList);
//         return partitionList;
//     }

//     private void partitionHelper(
//         String s,
//         int start,
//         List<String> currentList,
//         List<List<String>> partitionList) {
//         if (start == s.length()) {
//             partitionList.add(new ArrayList<>(currentList));
//             return;
//         }

//         for (int len = 1; len <= s.length() - start; len++) {
//             String current = s.substring(start, start + len);
//             if (isPalindrome(current)) {
//                 currentList.add(current);
//                 partitionHelper(s, start + len, currentList, partitionList, memo);
//                 currentList.remove(currentList.size() - 1);
//             }
//         }   
//     }

//     private boolean isPalindrome(String s) {
//         int left = 0;
//         int right = s.length() - 1;
//         while (left < right) {
//             if (s.charAt(left) != s.charAt(right)) {
//                 return false;
//             }
//             left++;
//             right--;
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         // System.out.println(new Solution().partition("a"));
//         System.out.println(new Solution().partition("aab"));
//     }
// }

// class ExamRoom {
//     private int[] distances;
//     private Set<Integer> takenSeats = new HashSet<>();

//     class Interval {
//         int start;
//         int end;
        
//     }

//     public ExamRoom(int n) {
//         distances = new int[n];
//     }
    
//     public int seat() {
//         updateDistances(distances, takenSeats);
//         int maxIndex = 0;
//         int maxDistance = 0;
//         for (int i = 0; i < distances.length; i++) {
//             if (maxDistance < distances[i]) {
//                 maxDistance = distances[i];
//                 maxIndex = i;
//             }
//         }
//         takenSeats.add(maxIndex);
//         return maxIndex;
//     }
    
//     public void leave(int p) {
//         takenSeats.remove(p);
//     }

//     private void updateDistances(int[] distances, Set<Integer> takenSeats) {
//         Arrays.fill(distances, Integer.MAX_VALUE);

//         for (int index = 0; index < distances.length; index++) {
//             for (int takenSeat : takenSeats) {
//                 distances[index] = Math.min(distances[index], Math.abs(takenSeat - index));
//             }
//         }
//     }
// }

// class ExamRoom {
//     private int[] distances;
//     private Set<Integer> takenSeats = new HashSet<>();

//     public ExamRoom(int n) {
//         distances = new int[n];
//     }
    
//     public int seat() {
//         updateDistances(distances, takenSeats);
//         int maxIndex = 0;
//         int maxDistance = 0;
//         for (int i = 0; i < distances.length; i++) {
//             if (maxDistance < distances[i]) {
//                 maxDistance = distances[i];
//                 maxIndex = i;
//             }
//         }
//         takenSeats.add(maxIndex);
//         return maxIndex;
//     }
    
//     public void leave(int p) {
//         takenSeats.remove(p);
//     }

//     private void updateDistances(int[] distances, Set<Integer> takenSeats) {
//         Arrays.fill(distances, Integer.MAX_VALUE);

//         for (int index = 0; index < distances.length; index++) {
//             for (int takenSeat : takenSeats) {
//                 distances[index] = Math.min(distances[index], Math.abs(takenSeat - index));
//             }
//         }
//     }
// }

// class Solution {
//     public int numDecodings(String s) {
//         Integer[] memo = new Integer[105];
//         return numDecodingsHelper(s, 0, memo);
//     }

//     private int numDecodingsHelper(String s, int index, Integer[] memo) {
//         if (memo[index] != null) {
//             return memo[index];
//         }
//         if (index >= s.length()) {
//             memo[index] = 1;
//             return 1;
//         }
//         if (s.charAt(index) == '0') {
//             memo[index] = 0;
//             return 0;
//         }
//         int oneLetter = numDecodingsHelper(s, index + 1, memo);
//         memo[index + 1] = oneLetter;

//         int twoLetters = 0;
//         if (index + 1 < s.length() && isALetter(s.charAt(index), s.charAt(index + 1))) {
//             twoLetters = numDecodingsHelper(s, index + 2, memo);
//             memo[index + 2] = twoLetters;
//         }
//         return oneLetter + twoLetters;
//     }

//     private boolean isALetter(char char1, char char2) {
//         int num1 = Character.getNumericValue(char1) * 10;
//         int num2 = Character.getNumericValue(char2);
//         return (num1 + num2) <= 26;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().numDecodings("0"));
//         System.out.println(new Solution().numDecodings("1"));
//         System.out.println(new Solution().numDecodings("22"));
//         System.out.println(new Solution().numDecodings("2226221662"));

//     }
// }

// class Solution {
//     public int compareVersion(String version1, String version2) {
//         List<Integer> v1 = buildList(version1);
//         List<Integer> v2 = buildList(version2);
//         System.out.println(v1);
//         int index = Math.max(v1.size(), v2.size());
        
//         for (int i = 0; i <= index; i++) {
//             int num1 = 0;
//             int num2 = 0;
//             if (i < v1.size()) {
//                 num1 = v1.get(i);
//             }
//             if (i < v2.size()) {
//                 num2 = v2.get(i);
//             }

//             if (num1 < num2) {
//                 return -1;
//             } else if (num1 > num2) {
//                 return 1;
//             }
//         }
//         return 0;
//     }

//     private List<Integer> buildList (String version) {
//         int index = 0;
//         List<Integer> versionList = new ArrayList<>();
//         while (index < version.length()) {
//             int num = 0;
//             while (index < version.length() && version.charAt(index) != '.') {
//                 num *= 10;
//                 num += Character.getNumericValue(version.charAt(index));
//                 index++;
//             }
//             index++;
//             versionList.add(num);
//         }
//         return versionList;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().compareVersion("1.2", "1.10"));
//     }
// }

// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
//         print(pairs);
//         int count = 0;
//         int start = Integer.MIN_VALUE;
//         for (int[] pair : pairs){
//             if (pair[0] > start) {
//                 count++;
//                 start = pair[1];
//             }
//         }
//         return count;
//     }

//     private void print(int[][] pairs){
//         for (int[] pair : pairs) {
//             System.out.println(Arrays.toString(pair));
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
//         System.out.println(new Solution().findLongestChain(new int[][]{{1,2},{7,8},{4,5}}));
//     }
// }

// class Solution {
//     public boolean stoneGame(int[] piles) {
//         return stoneGameHelper(piles, 0, piles.length - 1);
//     }

//     private boolean stoneGameHelper(int[] piles, int firstIndex, int lastIndex) {
//         int totalAlice = 0;
//         int totalBob = 0;

//         if ((lastIndex - firstIndex) == 1) {
//             totalAlice += Math.max(piles[firstIndex], piles[lastIndex]);
//             totalBob += Math.min(piles[firstIndex], piles[lastIndex]);
//             return totalAlice > totalBob;
//         }

//         if ((totalAlice + piles[firstIndex]) > (totalBob + piles[lastIndex])) {
//             if (stoneGameHelper(piles, firstIndex + 1, lastIndex)) {
//                 return true;
//             }
//         }
        
//         return stoneGameHelper(piles, firstIndex, lastIndex - 1);
//     }
// }

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         Map<String, Integer> memo = new HashMap<>();
//         return minimumTotalHelper(triangle, 0, 0, memo);
//     }

//     private int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, Map<String, Integer> memo) {
//         String key = toKey(row, col);
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         int sum = triangle.get(row).get(col);
//         if (row == triangle.size() - 1) {
//             return sum;
//         }

//         int left = minimumTotalHelper(triangle, row + 1, col, memo);
//         int right = minimumTotalHelper(triangle, row + 1, col + 1, memo);
//         int minSum = sum + Math.min(left, right);
//         memo.put(key, minSum);
//         return minSum;
//     }

//     private String toKey(int row, int col) {
//         return "" + row + "," + col;
//     }
// }

// class PeekingIterator implements Iterator<Integer> {
//     private Integer nextInt;
//     private Iterator<Integer> iterator;

// 	public PeekingIterator(Iterator<Integer> iterator) {
// 	    // initialize any member here.
//         this.iterator = iterator;
//         if (iterator.hasNext()) {
//             nextInt = iterator.next();
//         }
// 	}
	
//     // Returns the next element in the iteration without advancing the iterator.
// 	public Integer peek() {
//         return nextInt;
// 	}
	
// 	// hasNext() and next() should behave the same as in the Iterator interface.
// 	// Override them if needed.
// 	@Override
// 	public Integer next() {
//         Integer prevInt = nextInt;
//         if (iterator.hasNext()) {
//             nextInt = iterator.next();
//         } else {
//             nextInt = null;
//         }
// 	    return prevInt;
// 	}
	
// 	@Override
// 	public boolean hasNext() {
//         return nextInt != null;
// 	}
// }

// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if ((s1.length() + s2.length()) != s3.length()) {
//             return false;
//         }
//         Map<String, Boolean> map = new HashMap<>();
//         return isInterleaveHelper(s1, s2, s3, 0, 0, 0, map);
//     }

//     private boolean isInterleaveHelper(String  s1, String s2, String s3, int i1, int i2, int i3, Map<String, Boolean> map) {
//         if (i3 == s3.length()) {
//             return true;
//         }

//         String key = toKey(i1, i2, i3);
//         if (map.containsKey(key)) {
//             return map.get(key);
//         }

//         if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
//             if(isInterleaveHelper(s1, s2, s3, i1 + 1, i2, i3 + 1, map)){
//                 map.put(key, true);
//                 return true;
//             }
//         }

//         if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
//             boolean answer = isInterleaveHelper(s1, s2, s3, i1, i2 + 1, i3 + 1, map);
//             map.put(key, answer);
//             return answer;
//         }

//         map.put(key, false);
//         return false;
//     }

//     private String toKey(int i1, int i2, int i3) {
//         return "" + i1 + "," + i2 + "," + i3;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//         // System.out.println(new Solution().isInterleave("ad", "a", "aad"));
//         // System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));

//     }
// }

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

// class Solution {
//     public Node cloneGraph(Node node) {
//         Stack<Node> stack = new Stack<>();
//         Map<Node, Node> map = new HashMap<>();
//         stack.add(node);
//         map.put(node, new Node(node.val, new ArrayList<>()));
        
//         while(!stack.isEmpty()) {
//             Node current = stack.pop();
//             if (!map.containsKey(current)) {
//                 map.put(current, new Node(current.val, new ArrayList<>()));
//             }

//             for (Node neighbor : current.neighbors) {
//                 if (!map.containsKey(neighbor)) {
//                     map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
//                     stack.add(neighbor);
//                 }
//                 Node newNode = map.get(current);
//                 newNode.neighbors.add(map.get(neighbor));
//             }
//         }

//         return map.get(node);
//     }
// }

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         return coinChangeHelper(coins, amount);
//     }

//     private int coinChangeHelper(int[] coins, int amount) {
//         if (amount < 0) {
//             return -1;
//         }

//         if (amount == 0) {
//             return 0;
//         }

//         int min = Integer.MAX_VALUE;
//         for (int i = coins.length - 1; i >= 0; i--) {
//             int change = coinChangeHelper(coins, amount - coins[i]);
//             if (change != -1) {
//                 min = Math.min(min, change + 1);
//             }
//         }

//         if (min == Integer.MAX_VALUE) {
//             return -1;
//         }
//         return min;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().coinChange(new int[]{1,2,5}, 11));
//     }
// }

// class Solution {
//     public static int length;
//     public static int width;
//     private int[][] DELTAS = new int[][] {
//         {-1, 0},
//         {1, 0},
//         {0, -1},
//         {0, 1}
//     };

//     public void solve(char[][] board) {
//         length = board.length;
//         width = board[0].length;

//         Set<String> visited = new HashSet<>();
//         for (int row = 0; row < length; row++) {
//             for (int col = 0; col < width; col++) {
//                 String key = toKey(row, col);
//                 if (board[row][col] == 'O' && !visited.contains(key)) {
//                     bfs(board, key, visited);
//                 }
//             }
//         }
//     }

//     private void bfs(char[][] board, String key, Set<String> set) {
//         boolean isSurrounded = true;
//         Queue<String> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<>(); 
//         queue.add(key);

//         while (!queue.isEmpty()) {
//             String current = queue.poll();
//             int currentRow = Integer.valueOf(current.substring(0, 3)); 
//             int currentCol = Integer.valueOf(current.substring(4));
//             if (!visited.contains(current)) {
//                 visited.add(current);
//                 if (isEdge(current)) {
//                     isSurrounded = false;
//                 }
//                 for (int[] delta : DELTAS) {
//                     int neighborRow = currentRow + delta[0];
//                     int neighborCol = currentCol + delta[1];
//                     if (neighborRow >= 0 && neighborRow < length && neighborCol >= 0 && neighborCol < width
//                             && board[neighborRow][neighborCol] == 'O') {
//                         queue.add(toKey(neighborRow, neighborCol));
//                     }
//                 }
//             }
//         }

//         for (String location : visited) {
//             set.add(location);
//             if (isSurrounded) {
//                 int row = Integer.valueOf(location.substring(0, 3)); 
//                 int col = Integer.valueOf(location.substring(4));
//                 board[row][col] = 'X';
//             }
//         }
//     }

//     private String toKey(int row, int col) {
//         return String.format("%03d,%03d", row, col);
//     }

//     public static boolean isEdge(String location) {
//         String zero = "000";
//         String preffix = String.format("%03d", (length - 1)); 
//         String suffix = String.format("%03d", (width - 1)); 
//         if (location.startsWith(preffix) || location.startsWith(zero) || 
//                 location.endsWith(suffix) || location.endsWith(zero)) {
//             return true;
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         // char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//         char[][] board = new char[][] {{'O'}};
//         new Solution().solve(board);
//         for (char[] row : board) {
//             System.out.println(Arrays.toString(row));
//         }
//     }
// }

// class Solution {
//     public int hammingDistance(int x, int y) {
//         int num = x ^ y;
//         int count = 0;
//         while (num != 0) {
//             if ((num & 1) == 1) {
//                 count++;
//             }
//             num >>= 1;
//         }
//         return count;
//     }
// }

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Boolean[] memo = new Boolean[s.length()];
//         return canDictionaryCoverWord(0, s, wordDict, memo);
//     }

//     private boolean canDictionaryCoverWord(int startIndex, String word, List<String> dictionary, Boolean[] memo) {
//         if (startIndex == word.length()) {
//             return true;
//         }

//         if (memo[startIndex] != null) {
//             return memo[startIndex];
//         }

//         for (String dictionaryWord : dictionary) {
//             String remainingWord = word.substring(startIndex);
//             if (remainingWord.startsWith(dictionaryWord)) {
//                 int newStartIndex = startIndex + dictionaryWord.length();
//                 if (canDictionaryCoverWord(newStartIndex, word, dictionary, memo)) {
//                     memo[newStartIndex] = true;
//                     return true;
//                 }
//                 memo[newStartIndex] = false;
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
//         System.out.println(new Solution().wordBreak("leetcod", wordDict));
//     }
// }

// class Solution {
//     public int calculate(String s) {
//         Stack<String> stack = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);

//             if (c == ' ') {
//                 continue;
//             }

//             StringBuilder sb = new StringBuilder();
//             if (Character.isDigit(c) && !stack.isEmpty() && isNumber(stack.peek())) {
//                 stack.add(makeNumber(stack.pop(), c));
//             } else if (c == ')') {
//                 evaluate(stack);
//             } else {
//                 sb.append(c);
//                 stack.push(sb.toString());
//             } 
//         }

//         if (stack.size() > 2) {
//             evaluate(stack);
//         }

//         return Integer.valueOf(stack.peek());
//     }

//     private void evaluate(Stack<String> stack) {
//         int a = 0; int b = 0; int c = 0;
//         List<String> list = new ArrayList<>();

//         while (!stack.isEmpty() && stack.peek().equals("(")) {
//             list.add(stack.pop());
//         }
        
//         if (!stack.isEmpty()) {
//             stack.pop();
//         }



        
//     }

//     private boolean isNumber(String s) {
//         try {
//             Integer.parseInt(s);
//         } catch (Exception e) {
//             return false;
//         }
//         return true;
//     }

//     private String makeNumber(String s, char c) {
//         int num = (Integer.valueOf(s) * 10) + Character.getNumericValue(c);
//         return String.valueOf(num);   
//     }

//     public static void main(String[] args) {
//         Stack<String> stack = new Stack<>();
//         stack.add("2");
//         stack.add("-");
//         stack.add("1");
//         stack.add("+");
//         stack.add("2");
//         // System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
//         // System.out.println(new Solution().calculate("2-1+2"));
//         // System.out.println(new Solution().calculate("    1+ 1")); 
//         System.out.println(new Solution().calculate("(1)")); 
//     }
// }


// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int level = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<TreeNode> list = new ArrayList<>();
//             while (!queue.isEmpty() && size != 0) {
//                 list.add(queue.poll());
//             }

//             for (TreeNode node : list) {
//                 if (node.left != null) {
//                     queue.add(node.left);
//                 }
//                 if (node.right != null) {
//                     queue.add(node.right);
//                 }
//             }

//             if (level % 2 == 1) {
//                 Collections.reverse(list);
//             }
//             level++;

//             List<Integer> nodes = new ArrayList<>();
//             for (TreeNode node : list) {
//                 nodes.add(node.val);
//             }
//             result.add(nodes);
//         }

//         return result;
//     }
// }

// class Solution {
//     public int findMin(int[] nums) {
//         int left = 0;
//         int right = nums.length - 1;
//         while (nums[left] > nums[right]) {
//             int mid = (right + left) / 2;
//             if (nums[mid] < nums[left]) {
//                 right = mid;
//                 left++;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return nums[left];
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findMin(new int[]{4,5,6,7,0,1,2}));
//     }
// }

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         generateHelper(n, "", result, 0, 0);
//         return result;
//     }

//     private void generateHelper(int n, String current, List<String> result, int opened, int closed) {
//         if (current.length() == n * 2 && opened == closed) {
//             result.add(current);
//             return;
//         }

//         if (opened == closed && closed == n) {
//             return;
//         }

//         if (opened > 0 && opened <= n) {
//             generateHelper(n, current + ")", result, opened, closed + 1);
//         }
//         generateHelper(n, current + "(", result, opened + 1, closed );
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().generateParenthesis(1));
//     }
// }

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         permuteHelper(result, new ArrayList<>(), nums, new boolean[nums.length]);
//         return result;
//     }

//     private void permuteHelper(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] isUsed) {
//         if (current.size() == nums.length) {
//             result.add(new ArrayList<>(current));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (!isUsed[i]) {
//                 current.add(nums[i]);
//                 isUsed[i] = true;
//                 permuteHelper(result, current, nums, isUsed);
//                 current.remove(current.size() - 1);
//                 isUsed[i] = false;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().permute(new int[]{1,2,3}));
//     }
// }

// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         List<List<Integer>> result = new ArrayList<>();
//         combinationSumHelper(result, new ArrayList<>(), candidates, target, 0, 0);
//         return result;
//     }

//     private void combinationSumHelper(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int sum, int index) {
//         if (sum == target) {
//             result.add(new ArrayList<>(current));
//             return;
//         }

//         if (sum > target || index >= candidates.length) {
//             return;
//         }

//         current.add(candidates[index]);
//         combinationSumHelper(result, current, candidates, target, sum + candidates[index], index);
//         current.remove(current.size() - 1);
//         combinationSumHelper(result, current, candidates, target, sum, index + 1);
//     }


//     public static void main(String[] args) {
//         System.out.println(new Solution().combinationSum(new int[] {2,3,4,7}, 6));
//         System.out.println(new Solution().combinationSum(new int[] {10,17,15,18,16,31,22,25,20,23,30,12,19,38,36,26,40,32,34,13,35,29,39,14,11,27}, 31));
//     }
// }

// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> result = new ArrayList<>();
//         combineHelper(result, new ArrayList<>(), n, k);
//         return result;
//     }

//     private void combineHelper(List<List<Integer>> result, List<Integer> current, int n, int k) {
//         if (current.size() == k) {
//             result.add(new ArrayList<>(current));
//             return;
//         }
        
//         for (int i = n; i > 0; i--) {
//             current.add(i);
//             combineHelper(result, current, i - 1, k);
//             current.remove(current.size() - 1);
//         }
//     }
// }

// class Solution {
//     public int maxProfit2(int[] prices) {
//         if (prices.length == 1) {
//             return 0;
//         }

//         for (int i = 0; i < prices.length - 1; i++) {
//             prices[i] = prices[i + 1] - prices[i];
//         }

//         int global = 0;

//         for (int i = 0; i < prices.length - 1; i++) {
//             global += Math.max(0, prices[i]);
//         }

//         return global;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().maxProfit2(new int[]{3,2,1}));
//     }
// }

// Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

// class Solution {
//     public Node copyRandomList(Node head) {
//         Map<Node, Node> newToOld = new HashMap<>();
//         Map<Node, Node> oldToNew = new HashMap<>();
//         Node newHead = new Node(0);
//         Node currentNode = newHead;

//         while (head != null) {
//             currentNode.next = new Node(head.val);
//             currentNode = currentNode.next;
//             if (head.random != null) {
//                 newToOld.put(currentNode, head);
//                 oldToNew.put(head, currentNode);
//             }
//             head = head.next;
//         }

//         for (Node newNode : newToOld.keySet()) {
//             Node oldRandom = newToOld.get(newNode).random;
//             newNode.random = oldToNew.get(oldRandom);
//         }
    
//         return newHead.next;
//     }
// }

// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         return checkBalance(root) != -1;
//     }

//     private int checkBalance(TreeNode node) {
//         if (node == null) {
//             return 0;
//         }

//         int leftHeight = checkBalance(node.left);
//         if (leftHeight == -1) {
//             return -1;
//         }

//         int rightHeight = checkBalance(node.right);
//         if (rightHeight == -1) {
//             return -1;
//         }

//         if (Math.abs(rightHeight - leftHeight) > 1) {
//             return -1;
//         }

//         return 1 + Math.max(leftHeight, rightHeight);
//     }

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(3);
//         root.left = new TreeNode(5);
//         root.right = new TreeNode(8);
//         root.left.left = new TreeNode(2);
//         root.left.left.left = new TreeNode(4);
//         System.out.println(new Solution().isBalanced(root));
//     }
// }

// class Solution {
//     public int maxArea(int[] height) {
//         int max = 0;
//         for (int i = 0; i < height.length - 1; i++){
//             for(int j = i + 1; j < height.length; j++) {
//                 int area = Math.min(height[i], height[j]) * (j - i);
//                 max = Math.max(max, area);
//             }
//         }
//         return max;
//     }
// }

// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int maxArea = area(height[left], height[right], (right - left));
       
//         while (left < right) {
//             if (height[left] <= height[right]) {
//                 int leftBar = height[left];
//                 while (left < right && height[left] <= leftBar) {
//                     left++;
//                 }
//             } else {
//                 int rightBar = height[right];
//                 while (left < right && height[right] <= rightBar) {
//                     right--;
//                 }
//             }
//             maxArea = Math.max(maxArea, area(height[left], height[right], (right - left)));
//         }

//         return maxArea;
//     }

//     private int area(int left, int right, int width) {
//         return Math.min(left, right) * width;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().maxArea(new int[]{1,1}));
//     }
// }

// class Solution {
//     public int reverse(int x) {
//         if (x == Integer.MIN_VALUE) {
//             return 0;
//         }

//         int count = 0;
//         int M = Integer.MAX_VALUE / 10;
//         boolean isNeg = false;
//         if (x < 0) {
//             isNeg = true;
//         }

//         x = Math.abs(x);
//         int reversed = 0;
//         while (x != 0) {
//             int num = x % 10;
//             if (count == 9) {
//                 if (reversed > M) {
//                     return 0;
//                 } 
//             }
//             reversed = (reversed * 10) + num;
//             x /= 10;
//             count++;
//         }

//         if (isNeg) {
//             reversed *= -1;
//         }
//         return reversed;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().reverse(-2147483648));
//     }
// }

// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if (left == right) {
//             return head;
//         }

//         ListNode current = head;
//         ListNode after = null;
//         int index = 1;

//         while (index != left) {
//             current = current.next;
//             index++;
//         }

//         ListNode previous = current;
//         ListNode prev = current.next;
//         previous.next = after;

//         while (index != right) {
            
//         }

//         return head;
//     }
// }

// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         int arrows = 1;
//         Arrays.sort(points, (x,y) -> Integer.compare(x[0], y[0]));
//         int[] interval = points[0];
//         for (int i = 1; i < points.length; i++) {
//             if (points[i][0] >= interval[0] && points[i][0] <= interval[1]) {
//                 newInterval(interval, points[i]);
//             } else {
//                 arrows++;
//                 interval = points[i];
//             }
//         }
//         return arrows;
//     }

//     private int[] newInterval(int[] interval, int[] point) {
//         interval[0] = Math.max(interval[0], point[0]);
//         interval[1] = Math.min(interval[1], point[1]);
//         return interval;
//     }

//     public static void main(String[] args) {
//         System.out.println(new Solution().findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},
//         {0,9},{3,9},{0,6},{2,8}}));
//         System.out.println(new Solution().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
//     }
// }

// class BSTIterator {
//     private TreeNode currentNode = null;
//     private Stack<TreeNode> stack = new Stack<>();

//     public BSTIterator(TreeNode root) {
//         currentNode = root;
//     }

//     public int next() {
//         while (currentNode != null) {
//             stack.push(currentNode);
//             currentNode = currentNode.left;
//         }
//         currentNode = stack.pop();
//         int next = currentNode.val;
//         currentNode = currentNode.right;
//         return next;
//     }

//     public boolean hasNext() {
//         return !stack.isEmpty() || currentNode != null;
//     }

//     // public static void main(String[] args) {
//     //     TreeNode root = new TreeNode(7);
//     //     root.left = new TreeNode(3);
//     //     root.right = new TreeNode(15);
//     //     root.right.left = new TreeNode(9);
//     //     root.right.right = new TreeNode(20);
//     //     new BSTIterator(root).printInOrder(root);
//     // }
// }

// class BSTIterator {
// private List<Integer> treenodes = new ArrayList<>();
// private int index = 0;

// public BSTIterator(TreeNode root) {
// inOrderTraversal(root);
// }

// private void inOrderTraversal(TreeNode root) {
// if (root.left != null) {
// inOrderTraversal(root.left);
// }
// treenodes.add(root.val);
// if (root.right != null) {
// inOrderTraversal(root.right);
// }
// }

// public int next() {
// int next = treenodes.get(index);
// index++;
// return next;
// }

// public boolean hasNext() {
// return index < treenodes.size();
// }
// }

// class Solution {
// public ListNode removeNthFromEnd(ListNode head, int n) {
// int length = 0;
// ListNode current = head;
// while (current != null) {
// length++;
// current = current.next;
// }

// int removeIndex = length - n + 1;
// if (removeIndex == 1) {
// return head.next;
// }

// current = head;
// for (int i = 1; i < removeIndex - 1; i++) {
// current = current.next;
// }
// current.next = current.next.next;
// return head;
// }
// }

// class Solution {
// public Node connect(Node root) {
// if (root == null) {
// return root;
// }
// Node result = root;
// bfs(root);
// return result;
// }

// private void bfs(Node root) {
// Queue<Node> queue = new LinkedList<>();
// queue.add(root);

// while (!queue.isEmpty()) {
// int nodesInLevel = queue.size();
// while (nodesInLevel > 0) {
// Node current = queue.poll();
// if (nodesInLevel > 1) {
// current.next = queue.peek();
// }
// if (current.left != null) {
// queue.add(current.left);
// }
// if (current.right != null) {
// queue.add(current.right);
// }
// nodesInLevel--;
// }
// }
// }
// }

// class Solution {
// public int[][] insert(int[][] intervals, int[] newInterval) {
// if (intervals.length == 0) {
// int[][] result = new int[1][2];
// result[0] = newInterval;
// return result;
// }

// intervals = newIntervals(intervals, newInterval);
// newInterval = new int[] { -1, -1 };

// for (int i = 0; i < intervals.length; i++) {
// int[] currentInterval = intervals[i];
// if (isOverlapping(currentInterval, newInterval)) {
// merge(currentInterval, newInterval);
// }
// newInterval = currentInterval;
// }

// return removeDuplicates(intervals);
// }

// private boolean isOverlapping(int[] currentInterval, int[] newInterval) {
// if (currentInterval[1] < newInterval[0]) {
// return false;
// } else if (currentInterval[0] > newInterval[1]) {
// return false;
// }
// return true;
// }

// private void merge(int[] currentInterval, int[] newInterval) {
// currentInterval[0] = Math.min(newInterval[0], currentInterval[0]);
// currentInterval[1] = Math.max(newInterval[1], currentInterval[1]);
// newInterval[0] = currentInterval[0];
// newInterval[1] = currentInterval[1];
// }

// private int[][] newIntervals(int[][] intervals, int[] interval) {
// int[][] newIntervals = new int[intervals.length + 1][2];
// int insert = 0;
// boolean isAdded = false;
// for (int i = 0; i < intervals.length; i++) {
// if (!isAdded && intervals[i][0] > interval[0]) {
// newIntervals[insert++] = interval;
// isAdded = true;
// }
// newIntervals[insert++] = intervals[i];
// }
// if (!isAdded) {
// newIntervals[insert] = interval;
// }
// return newIntervals;
// }

// private int[][] removeDuplicates(int[][] intervals) {
// int length = 1;
// for (int i = 1; i < intervals.length; i++) {
// if (intervals[i][0] != intervals[i - 1][0]) {
// length++;
// }
// }

// int[][] result = new int[length][2];
// length--;
// int current = -1;
// for (int i = intervals.length - 1; i >= 0; i--) {
// if (intervals[i][0] != current) {
// result[length--] = intervals[i];
// current = intervals[i][0];
// }
// }

// return result;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().insert(new int[][] { { 1, 5 } },
// new int[] { 6, 8 }));
// // System.out.println(new Solution().insert(new int[][] { { 3, 5 }, { 12, 15
// }
// // },
// // new int[] { 0, 0 }));
// // System.out.println(new Solution().insert(new int[][] { { 1, 2 }, { 3, 5 },
// {
// // 6, 7 }, { 8, 10 }, { 12, 16 } },
// // new int[] { 4, 8 }));
// }

// }

// class Solution {
// public int[][] insert(int[][] intervals, int[] newInterval) {
// if (intervals.length == 0) {
// int[][] result = new int[1][2];
// result[0] = newInterval;
// return result;
// }

// intervals = addNewInterval(intervals, newInterval);

// for (int[] currentInterval : intervals) {
// if (isOverlapping(currentInterval, newInterval)) {
// merge(currentInterval, newInterval);
// }
// }
// return removeDuplicates(intervals);
// }

// private boolean isOverlapping(int[] currentInterval, int[] newInterval) {
// if (currentInterval[1] < newInterval[0]) {
// return false;
// } else if (currentInterval[0] > newInterval[1]) {
// return false;
// }
// return true;
// }

// private void merge(int[] currentInterval, int[] newInterval) {
// currentInterval[0] = Math.min(newInterval[0], currentInterval[0]);
// currentInterval[1] = Math.max(newInterval[1], currentInterval[1]);
// newInterval[0] = currentInterval[0];
// newInterval[1] = currentInterval[1];
// }

// private int[][] removeDuplicates(int[][] intervals) {
// int length = 1;
// int current = intervals[0][0];
// for (int i = 1; i < intervals.length; i++) {
// if (intervals[i][0] != current) {
// length++;
// current = intervals[i][0];
// }
// }

// int[][] result = new int[length][2];
// length--;
// int start = -1;
// for (int i = intervals.length - 1; i >= 0; i--) {
// if (intervals[i][0] != start) {
// result[length--] = intervals[i];
// start = intervals[i][0];
// }
// }
// return result;
// }

// private int[][] addNewInterval(int[][] intervals, int[] newInterval) {
// int[][] newIntervals = new int[intervals.length + 1][2];
// int insert = 0;
// for (int i = 0; i < intervals.length; i++) {
// if (newInterval[0] < intervals[i][0]) {
// newIntervals[insert] = newInterval;
// insert++;
// }
// newIntervals[insert++] = intervals[i];
// }
// return newIntervals;
// }

// public static void main(String[] args) {
// // System.out.println(new Solution().insert(new int[][] { { 1, 5 } },
// // new int[] { 6, 8 }));
// System.out.println(new Solution().insert(new int[][] { { 1, 2 }, { 3, 5 }, {
// 6, 7 }, { 8, 10 }, { 12, 16 } },
// new int[] { 4, 8 }));
// }
// }

// class Solution {
// public int minMutation(String startGene, String endGene, String[] bank) {
// if (bank.length == 0) {
// return -1;
// }
// Queue<String> queue = new LinkedList<>();
// Set<String> visited = new HashSet<>();
// return bfs(startGene, endGene, bank, queue, visited);
// }

// private int bfs(String startGene, String endGene, String[] bank,
// Queue<String> queue, Set<String> visited) {
// int mutations = 0;
// queue.add(startGene);

// while (!queue.isEmpty()) {
// Set<String> inLevel = new HashSet<>();
// int size = queue.size();
// while (!queue.isEmpty() && size > 0) {
// String currentGene = queue.poll();
// if (visited.contains(currentGene)) {
// continue;
// }
// inLevel.add(currentGene);
// size--;
// }

// for (String currentGene : inLevel) {
// visited.add(currentGene);
// for (String gene : bank) {
// if (visited.contains(gene)) {
// continue;
// }
// int mutation = 0;
// for (int i = 0; i < 8; i++) {
// if (gene.charAt(i) != currentGene.charAt(i)) {
// mutation++;
// }
// }
// if (mutation < 2) {
// if (gene.equals(endGene)) {
// return mutations + 1;
// }
// queue.add(gene);
// }
// }
// }

// mutations++;
// }
// return -1;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().minMutation("AAAAAAAT", "CCCCCCCC",
// new String[] { "AAAAAAAC", "AAAAAAAA", "CCCCCCCC" }));
// }
// }

// class Solution {
// public void rotate(int[] nums, int k) {
// if (k % nums.length == 0) {
// return;
// }
// k %= nums.length;
// rotateHelper(nums, 0, nums.length - 1);
// rotateHelper(nums, 0, k - 1);
// rotateHelper(nums, k, nums.length - 1);
// }

// private void rotateHelper(int[] nums, int start, int end) {
// while (start < end) {
// int temp = nums[start];
// nums[start] = nums[end];
// nums[end] = temp;
// start++;
// end--;
// }
// }
// }

// class Solution {
// public void rotate2(int[] nums, int k) {
// if (k % nums.length == 0) {
// return;
// }
// int rotations = nums.length;
// k %= nums.length;
// int index = 0;
// while (rotations > 0) {
// rotations -= rotateHelper(nums, k, index, index);
// index++;
// }
// }

// private int rotateHelper(int[] nums, int k, int index, int first) {
// int rotations = 0;
// int prev = nums[first];
// do {
// index = (index + k) % nums.length;
// int temp = nums[index];
// nums[index] = prev;
// prev = temp;
// rotations++;
// } while (index != first);
// return rotations;
// }

// public void rotate(int[] nums, int k) {
// int remaining = nums.length;
// int start = 0;
// while (remaining > 0) {
// remaining -= move(nums, k, start);
// start++;
// }
// }

// private static int move(int[] nums, int k, int start) {
// int iterations = 0;
// int current = start;
// int previousNum = nums[current];
// do {
// int next = (current + k) % nums.length;
// int temp = nums[next];
// nums[next] = previousNum;
// previousNum = temp;
// current = next;
// iterations++;
// } while (current != start);
// assert iterations >= 1;
// return iterations + 1;
// }

// public static void main(String[] args) {
// int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
// new Solution().rotate2(nums, 26);
// System.out.println(Arrays.toString(nums));
// }
// }

// class Solution {
// public void rotate(int[] nums, int k) {
// if (k % nums.length == 0) {
// return;
// }
// for (int i = 0; i < k; i++) {
// rotateHelper(nums);
// }
// }

// private void rotateHelper(int[] nums) {
// int temp = nums[nums.length - 1];
// for (int i = nums.length - 1; i > 0; i--) {
// nums[i] = nums[i - 1];
// }
// nums[0] = temp;
// }
// }

// class Solution {
// public List<List<Integer>> getAncestors(int n, int[][] edges) {
// List<List<Integer>> adjList = new ArrayList<>();
// int[] inDegrees = new int[n];
// buildAjdListAndInDegrees(edges, n, adjList, inDegrees);
// List<List<Integer>> resuList = new ArrayList<>();
// fillResultList(adjList, resuList, n);
// return sortList(resuList, adjList, n);
// }

// private void buildAjdListAndInDegrees(int[][] edges, int n,
// List<List<Integer>> adjList, int[] inDegrees) {
// for (int i = 0; i < n; i++) {
// adjList.add(new ArrayList<>());
// }
// for (int[] edge : edges) {
// inDegrees[0] += 1;
// adjList.get(edge[1]).add(edge[0]);
// }
// }

// private void fillResultList(List<List<Integer>> adjList, List<List<Integer>>
// resuList, int n) {
// for (int i = 0; i < n; i++) {
// resuList.add(new ArrayList<>());
// }
// for (int i = 0; i < n; i++) {
// List<Integer> edges = adjList.get(i);
// for (int edge : edges) {
// List<Integer> list = adjList.get(edge);
// if (list.size() > 0) {
// resuList.get(i).addAll(list);
// }
// }
// }
// }

// private List<List<Integer>> sortList(List<List<Integer>> resuList,
// List<List<Integer>> adjList, int n) {
// List<List<Integer>> sortList = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// sortList.add(new ArrayList<>());
// TreeSet<Integer> set = new TreeSet<>();
// for (int edge : resuList.get(i)) {
// set.add(edge);
// }
// for (int edge : adjList.get(i)) {
// set.add(edge);
// }
// for (int edge : set) {
// sortList.getLast().add(edge);
// }
// }
// return sortList;
// }

// public static void main(String[] args) {
// int[][] edges = new int[][] { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7
// },
// { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 6 } };
// new Solution().getAncestors(8, edges);
// }
// }

// class Solution {
// public int removeDuplicates(int[] nums) {
// int num = nums[0];
// int count = 0;
// int insertIndex = 0;
// for (int i = 0; i < nums.length; i++) {
// if (nums[i] == num) {
// count++;
// } else {
// count = 1;
// num = nums[i];
// }

// if (count <= 2) {
// nums[insertIndex] = num;
// insertIndex++;
// }
// }
// return insertIndex;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().removeDuplicates(new int[] { 0, 0, 1, 1, 1,
// 1, 2, 3, 3 }));
// }
// }

// class Solution {
// public int search(int[] nums, int target) {
// int pivotIndex = 0;
// if (nums[0] > nums[nums.length - 1]) {
// pivotIndex = rotationIndex(nums);
// }
// return searchHelper(nums, target, pivotIndex);
// }

// private int rotationIndex(int[] nums) {
// int firstIndex = 0;
// int lastIndex = nums.length - 1;
// while (firstIndex < lastIndex) {
// int midIndex = (lastIndex - firstIndex) / 2 + firstIndex;
// if (nums[0] <= nums[midIndex]) {
// firstIndex = midIndex + 1;
// } else {
// lastIndex = midIndex;
// }
// }
// return lastIndex;
// }

// private int searchHelper(int[] nums, int target, int index) {
// int left = 0;
// int right = nums.length - 1;
// if (target >= nums[index] && target <= nums[right]) {
// left = index;
// } else {
// right = index - 1;
// }

// while (left <= right) {
// int mid = (right - left) / 2 + left;
// if (nums[mid] == target) {
// return mid;
// } else if (nums[mid] < target) {
// left = mid + 1;
// } else {
// right = mid - 1;
// }
// }
// return -1;
// }
// }

// class Solution {
// public void rotate(int[][] matrix) {
// if (matrix.length == 1) {
// return;
// }
// flipHorizontally(matrix);
// flipDiagonally(matrix);
// }

// private void flipHorizontally(int[][] matrix) {
// int rowDown = matrix.length - 1;
// for (int row = 0; row < matrix.length / 2; row++) {
// for (int col = 0; col < matrix.length; col++) {
// int temp = matrix[rowDown][col];
// matrix[rowDown][col] = matrix[row][col];
// matrix[row][col] = temp;
// }
// rowDown--;
// }
// }

// private void flipDiagonally(int[][] matrix) {
// for (int row = 1; row < matrix.length; row++) {
// flipDiagonallyHelper(matrix, row, 0);
// }
// if (matrix.length == 2) {
// return;
// }
// for (int col = 1; col < matrix.length - 1; col++) {
// flipDiagonallyHelper(matrix, matrix.length - 1, col);
// }
// }

// private void flipDiagonallyHelper(int[][] matrix, int row, int col) {
// while (row > col) {
// int temp = matrix[row][col];
// matrix[row][col] = matrix[col][row];
// matrix[col][row] = temp;
// row--;
// col++;
// }

// }

// public static void main(String[] args) {
// int[][] matrix = new int[][] { { 1 } };
// new Solution().rotate(matrix);
// }
// }

// class Solution {
// public ListNode partition(ListNode head, int x) {
// ListNode result = new ListNode();
// ListNode start = result;
// ListNode greater = new ListNode();
// ListNode end = greater;
// while (head != null) {
// if (head.val >= x) {
// greater.next = new ListNode(head.val);
// greater = greater.next;
// } else {
// result.next = new ListNode(head.val);
// result = result.next;
// }
// head = head.next;
// }
// result.next = end.next;
// return start.next;
// }
// }

// class Solution {
// private static final int[][] NEIGHBOR_DELTA = new int[][] {
// { -1, -1 },
// { -1, 0 },
// { -1, 1 },
// { 0, -1 },
// { 0, 1 },
// { 1, -1 },
// { 1, 0 },
// { 1, 1 }
// };

// public void gameOfLife(int[][] board) {
// int width = board[0].length;
// int height = board.length;
// int[][] result = new int[height][width];
// for (int col = 0; col < width; col++) {
// for (int row = 0; row < height; row++) {
// result[row][col] = fillResult(board, result, row, col, width, height);
// }
// }
// copyBoard(board, result);
// }

// private int fillResult(int[][] board, int[][] result, int row, int col, int
// width, int height) {
// int liveNeighbors = liveNeighbors(board, row, col, width, height);
// if (liveNeighbors == 3) {
// return 1;
// } else if (liveNeighbors < 2 || liveNeighbors > 3) {
// return 0;
// }
// return board[row][col];
// }

// private int liveNeighbors(int[][] board, int row, int col, int width, int
// height) {
// int count = 0;
// for (int[] delta : NEIGHBOR_DELTA) {
// int colNeighbor = delta[1] + col;
// int rowNeighbor = delta[0] + row;
// if (colNeighbor >= 0 && colNeighbor < width && rowNeighbor >= 0 &&
// rowNeighbor < height) {
// if (board[rowNeighbor][colNeighbor] == 1) {
// count++;
// }
// }
// }
// return count;
// }

// private void copyBoard(int[][] board, int[][] result) {
// for (int col = 0; col < board[0].length; col++) {
// for (int row = 0; row < board.length; row++) {
// board[row][col] = result[row][col];
// }
// }
// }

// public static void main(String[] args) {
// int[][] board = new int[][] { { 0 }, { 1 } };
// new Solution().gameOfLife(board);
// System.out.println(Arrays.toString(board));
// }
// }

// class Solution {
// public boolean wordPattern(String pattern, String s) {
// Map<String, Integer> wordToCharacter = new HashMap<>();
// Map<Integer, String> charaterToWord = new HashMap<>();
// int indexPattern = 0;
// int indexS = 0;
// while (indexS < s.length() && indexPattern < pattern.length()) {
// StringBuilder sb = new StringBuilder();
// while (indexS < s.length() && s.charAt(indexS) != ' ') {
// sb.append((int) s.charAt(indexS));
// indexS++;
// }
// String word = sb.toString();
// int c = (int) pattern.charAt(indexPattern);
// if (wordToCharacter.containsKey(word) && wordToCharacter.get(word) != c) {
// return false;
// }
// if (charaterToWord.containsKey(c) && !charaterToWord.get(c).equals(word)) {
// return false;
// }
// wordToCharacter.put(word, c);
// charaterToWord.put(c, word);
// indexPattern++;
// indexS++;
// }
// return indexS >= s.length() && indexPattern >= pattern.length();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().wordPattern("abca", "dog cat cat dog"));
// }
// }

// class Solution {
// public int search(int[] nums, int target) {
// Map<Integer, Integer> map = new HashMap<>();
// for (int i = 0; i < nums.length; i++) {
// map.put(nums[i], i);
// }

// if (map.containsKey(target)) {
// return map.get(target);
// }
// return -1;
// }
// }

// ***** TO DO *****
// class Solution {
// public ListNode sortList(ListNode head) {
// return sort(head);
// }

// private ListNode sort(ListNode head) {
// if (head == null || head.next == null) {
// return head;
// }

// ListNode slow = head;
// ListNode fast = head;

// while (fast.next != null && fast.next.next != null) {
// slow = slow.next;
// fast = fast.next.next;
// }

// ListNode next = slow.next;
// slow.next = null;

// ListNode start = sort(head);
// ListNode mid = sort(next);

// return merge(start, mid);
// }

// private ListNode merge(ListNode head1, ListNode head2) {
// ListNode head = new ListNode();
// ListNode result = head;
// while (head1 != null && head2 != null) {
// if (head1.val < head2.val) {
// head.next = head1;
// head1 = head1.next;
// } else {
// head.next = head2;
// head2 = head2.next;
// }
// head = head.next;
// }

// while (head1 != null) {
// head.next = head1;
// head1 = head1.next;
// head = head.next;
// }

// while (head2 != null) {
// head.next = head2;
// head2 = head2.next;
// head = head.next;
// }
// return result.next;
// }

// public static void main(String[] args) {
// ListNode head = new ListNode(-1);
// head.next = new ListNode(5);
// head.next.next = new ListNode(3);
// head.next.next.next = new ListNode(0);
// new Solution().sortList(head);
// }
// }

// class Solution {
// private TreeNode prev = null;

// public void flatten(TreeNode root) {
// if (root == null) {
// return;
// }
// flatten(root.right);
// flatten(root.left);

// root.right = prev;
// root.left = null;

// prev = root;
// }

// public static void main(String[] args) {
// TreeNode root = new TreeNode(1);
// root.left = new TreeNode(2);
// root.right = new TreeNode(5);
// root.right.right = new TreeNode(6);
// new Solution().flatten(root);
// }
// }

// class Solution {
// public void flatten(TreeNode root) {
// if (root == null) {
// return;
// }
// List<Integer> listNodes = new ArrayList<>();
// TreeNode head = root;
// fillList(listNodes, head);
// buildListNode(root, listNodes);
// }

// private void fillList(List<Integer> listNodes, TreeNode head) {
// if (head == null) {
// return;
// }
// listNodes.add(head.val);
// fillList(listNodes, head.left);
// fillList(listNodes, head.right);
// }

// private void buildListNode(TreeNode root, List<Integer> listNodes) {
// for (int i = 0; i < listNodes.size(); i++) {
// root.val = listNodes.get(i);
// root.left = null;
// if (i < listNodes.size() - 1) {
// root.right = new TreeNode();
// root = root.right;
// }
// }
// }
// }

// class Solution {
// public TreeNode buildTree(int[] inorder, int[] postorder) {
// Map<Integer, Integer> inOrderIndices = new HashMap<>();
// for (int i = 0; i < inorder.length; i++) {
// inOrderIndices.put(inorder[i], i);
// }
// return buildTreeHelper(postorder, inOrderIndices, postorder.length - 1, 0,
// postorder.length - 1);
// }

// private TreeNode buildTreeHelper(int[] postorder, Map<Integer, Integer>
// inOrderIndices, int rootIndex, int left,
// int right) {
// TreeNode root = new TreeNode(postorder[rootIndex]);
// int mid = inOrderIndices.get(postorder[rootIndex]);
// if (left < mid) {
// root.left = buildTreeHelper(postorder, inOrderIndices, rootIndex - right +
// mid - 1, left, mid - 1);
// }
// if (right > mid) {
// root.right = buildTreeHelper(postorder, inOrderIndices, rootIndex - 1, mid +
// 1, right);
// }
// return root;
// }
// }

// class Solution {
// public TreeNode buildTree(int[] preorder, int[] inorder) {
// Map<Integer, Integer> inOrderIndices = new HashMap<>();
// for (int i = 0; i < inorder.length; i++) {
// inOrderIndices.put(inorder[i], i);
// }
// return buildTreeHelper(preorder, inOrderIndices, 0, 0, inorder.length - 1);
// }

// private TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer>
// inOrderIndices, int rootIndex, int left,
// int right) {
// TreeNode root = new TreeNode(preorder[rootIndex]);
// int mid = inOrderIndices.get(preorder[rootIndex]);
// if (left < mid) {
// root.left = buildTreeHelper(preorder, inOrderIndices, rootIndex + 1, left,
// mid - 1);
// }
// if (right > mid) {
// root.right = buildTreeHelper(preorder, inOrderIndices, rootIndex + mid - left
// + 1, mid + 1, right);
// }
// return root;
// }
// }

// class Solution {
// public int countNodes(TreeNode root) {
// if (root == null) {
// return 0;
// }
// int count = 1;
// return count + countNodes(root.left) + countNodes(root.right);
// }
// }

// class Solution {
// public String minWindow(String s, String t) {
// String result = "";
// if (s.length() < t.length()) {
// return result;
// }

// int length = Integer.MAX_VALUE;
// Map<Character, Integer> letters = new HashMap<>();
// for (char c : t.toCharArray()) {
// if (!letters.containsKey(c)) {
// letters.put(c, 0);
// }
// letters.put(c, 1 + letters.get(c));
// }

// Map<Character, Integer> occurences = new HashMap<>();
// int start = 0;
// int count = 0;
// while (start < s.length() - 1) {
// char cStart = s.charAt(start);
// if (!letters.containsKey(cStart)) {
// start++;
// continue;
// }

// count++;
// occurences.put(cStart, 1);

// int end = start + 1;
// while (end < s.length() && count < t.length()) {
// char cEnd = s.charAt(end);
// if (!letters.containsKey(cEnd) || letters.get(cEnd) == occurences.get(cEnd))
// {
// end++;
// continue;
// }
// count++;
// if (!occurences.containsKey(cEnd)) {
// occurences.put(cEnd, 0);
// }
// occurences.put(cEnd, 1 + occurences.get(cEnd));
// }
// if ((end + 1 - start) < length) {
// result = s.substring(start, end + 1);
// length = end + 1 - start;
// }
// occurences.put(cStart, occurences.get(cStart) - 1);
// count--;
// start++;

// }
// return result;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
// }
// }

// class Solution {
// public int[] twoSum(int[] numbers, int target) {
// int[] result = new int[2];
// int left = 0;
// int right = numbers.length - 1;
// while (left < right) {
// int sum = numbers[left] + numbers[right];
// if (sum == target) {
// result[0] = left + 1;
// result[1] = right + 1;
// return result;
// } else if (sum < target) {
// left++;
// } else {
// right--;
// }
// }
// return result;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9));
// }
// }

// class Solution {
// public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
// Map<TreeNode, TreeNode> map = new HashMap<>();
// fillMap(map, root);

// Set<TreeNode> set = new HashSet<>();
// while (map.containsKey(p)) {
// set.add(p);
// p = map.get(p);
// }

// while (map.containsKey(q)) {
// if (set.contains(q)) {
// return q;
// }
// q = map.get(q);
// }
// return root;
// }

// private void fillMap(Map<TreeNode, TreeNode> map, TreeNode root) {
// if (root.left != null) {
// map.put(root.left, root);
// fillMap(map, root.left);
// }
// if (root.right != null) {
// map.put(root.right, root);
// fillMap(map, root.right);
// }
// }
// }

// class Solution {
// public int minPathSum(int[][] grid) {
// Map<String, Integer> memo = new HashMap<>();
// return minPathSumHelper(grid, 0, 0, 0, memo);
// }

// private int minPathSumHelper(int[][] grid, int col, int row, int sum,
// Map<String, Integer> memo) {
// if (row == grid.length - 1 && col == grid[0].length - 1) {
// sum += grid[row][col];
// return sum;
// }

// if (row >= grid.length || col >= grid[0].length) {
// return Integer.MAX_VALUE;
// }
// String location = toKey(row, col);
// if (memo.containsKey(location)) {
// return memo.get(location);
// }
// sum += grid[row][col]
// + Math.min(minPathSumHelper(grid, col + 1, row, sum, memo),
// minPathSumHelper(grid, col, row + 1, sum, memo));
// memo.put(toKey(row, col), sum);
// return sum;
// }

// private String toKey(int row, int col) {
// return row + "," + col;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().minPathSum(new int[][] { { 3, 1, 20 }, {
// 10, 2, 1 } }));
// }
// }

// class Solution {
// public boolean containsNearbyDuplicate(int[] nums, int k) {
// Map<Integer, Integer> map = new HashMap<>();
// for (int i = 0; i < nums.length; i++) {
// int key = nums[i];
// if (map.containsKey(key)) {
// if (Math.abs(map.get(key) - i) <= k) {
// return true;
// }
// }
// map.put(key, i);
// }
// return false;
// }
// }

// class Solution {
// public List<List<Integer>> combine(int n, int k) {
// // if (n == 1) {
// // List<List<Integer>> result = new ArrayList<>();
// // List<Integer> list = new ArrayList<>();
// // list.add(1);
// // result.add(list);
// // return result;
// // }

// // int[] nums = new int[n];
// // for (int i = 1; i <= n; i++) {
// // nums[i - 1] = i;
// // }

// List<List<Integer>> result = new ArrayList<>();
// List<Integer> list = new ArrayList<>();
// combineHelper(1, k, n, list, result);
// return result;
// }

// private void combineHelper(int num, int k, int n, List<Integer> list,
// List<List<Integer>> result) {
// if (list.size() == k) {
// result.add(new ArrayList<>(list));
// return;
// }

// for (int i = num; i <= n; i++) {
// list.add(i);
// combineHelper(i + 1, k, n, list, result);
// list.removeLast();
// }
// }

// public static void main(String[] args) {
// System.out.println(new Solution().combine(1, 1));
// }
// }

// class Solution {
// public List<List<Integer>> combine(int n, int k) {
// if (n == 1) {
// List<List<Integer>> result = new ArrayList<>();
// List<Integer> list = new ArrayList<>();
// list.add(1);
// result.add(list);
// return result;
// }
// int[] nums = new int[n];
// for (int i = 1; i <= n; i++) {
// nums[i - 1] = i;
// }

// List<List<Integer>> result = new ArrayList<>();
// Set<String> set = new HashSet<>();
// List<Integer> list = new ArrayList<>();
// for (int i = 0; i < nums.length; i++) {
// combineHelper(nums, k, i, list, result, set);
// }
// return result;
// }

// private void combineHelper(int[] nums, int k, int index, List<Integer> list,
// List<List<Integer>> result,
// Set<String> set) {
// if (list.size() == k) {
// String key = toKey(list);
// if (!set.contains(key)) {
// result.add(new ArrayList<>(list));
// }
// set.add(key);
// return;
// }
// if (index >= nums.length) {
// return;
// }
// list.add(nums[index]);
// for (int i = 1; i < nums.length; i++) {
// combineHelper(nums, k, index + i, list, result, set);
// }
// list.removeLast();
// }

// private String toKey(List<Integer> list) {
// StringBuilder sb = new StringBuilder();
// for (int num : list) {
// sb.append(num);
// sb.append(",");
// }
// return sb.toString();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().combine(1, 1));
// }
// }

// class Solution {
// public ListNode rotateRight(ListNode head, int k) {
// if (head == null) {
// return null;
// }
// if (head.next == null || k == 0) {
// return head;
// }
// ListNode current = head;
// int size = 1;
// while (current.next != null) {
// current = current.next;
// size++;
// }
// int n = size - (k % size);
// if (n == size) {
// return head;
// }
// current = head;
// while (n > 1) {
// current = current.next;
// n--;
// }

// ListNode result = current.next;
// current.next = null;
// current = result;
// while (current.next != null) {
// current = current.next;
// }
// current.next = head;
// return result;
// }
// }

// class Solution {
// public int removeDuplicates(int[] nums) {
// int index = 1;
// if (nums.length == 1) {
// return index;
// }
// for (int i = 1; i < nums.length; i++) {
// if (nums[i] != nums[i - 1]) {
// nums[index] = nums[i];
// index++;
// }
// }
// return index;
// }
// }

// class Solution {
// public int maxSubarraySumCircular(int[] nums) {
// if (nums.length == 1) {
// return nums[0];
// }
// int maxSum = 0;
// for (int start = 0; start < nums.length; start++) {
// int current = nums[start];
// int global = nums[start];
// for (int index = start + 1; index < (nums.length + start) % nums.length;
// index = (index + 1)
// % nums.length) {
// current = Math.max(nums[index], current + nums[index]);
// global = Math.max(current, global);
// }
// maxSum = Math.max(maxSum, global);
// }
// return maxSum;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().maxSubarraySumCircular(new int[] { 1, -2,
// 3, 1 }));
// }
// }

// class Solution {
// public int maxSubArray(int[] nums) {
// int current = nums[0];
// int global = nums[0];

// for (int i = 1; i < nums.length; i++) {
// current = Math.max(nums[i], current + nums[i]);
// global = Math.max(global, current);
// }

// return global;
// }
// }

// class Solution {
// public int maxProfit(int[] prices) {
// if (prices.length == 1) {
// return 0;
// }

// for (int i = 0; i < prices.length - 1; i++) {
// prices[i] = prices[i + 1] - prices[i];
// }

// int current = prices[0];
// int global = prices[0];

// for (int i = 1; i < prices.length - 1; i++) {
// current = Math.max(prices[i], current + prices[i]);
// global = Math.max(current, global);
// }

// if (global > 0) {
// return global;
// }
// return 0;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().maxProfit(new int[] { 2, 1, 2, 1, 0, 1, 2
// }));
// }
// }

// class Solution {
// public void merge(int[] nums1, int m, int[] nums2, int n) {
// if (n == 0) {
// return;
// }
// int index = nums1.length - 1;
// int index1 = m - 1;
// int index2 = n - 1;
// while (index >= 0) {
// while (index1 >= 0 && index2 >= 0) {
// if (nums1[index1] >= nums2[index2]) {
// nums1[index] = nums1[index1];
// index1--;
// } else {
// nums1[index] = nums2[index2];
// index2--;
// }
// index--;
// }

// while (index1 >= 0) {
// nums1[index] = nums1[index1];
// index1--;
// index--;
// }

// while (index2 >= 0) {
// nums1[index] = nums2[index2];
// index2--;
// index--;
// }
// }
// }

// public static void main(String[] args) {
// int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
// new Solution().merge(nums1, 3, new int[] { 2, 5, 6 }, 3);
// System.out.println(Arrays.toString(nums1));
// }
// }

// class Solution {
// private Integer previous = null;
// private int min = Integer.MAX_VALUE;

// public int getMinimumDifference(TreeNode root) {
// dfs(root);
// return min;
// }

// private void dfs(TreeNode node) {
// if (node == null) {
// return;
// }
// dfs(node.left);
// if (previous != null) {
// min = Math.min(min, node.val - previous);
// }
// previous = node.val;
// dfs(node.right);
// }
// }

// class Solution {
// public int lengthOfLIS(int[] nums) {
// int[] lis = new int[nums.length];
// Arrays.fill(lis, 1);
// for (int end = nums.length - 1; end >= 0; end--) {
// for (int start = end - 1; start >= 0; start--) {
// if (nums[start] < nums[end]) {
// lis[start] = Math.max(lis[start], lis[end] + 1);
// }
// }
// }
// int max = 0;
// for (int length : lis) {
// max = Math.max(max, length);
// }
// return max;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7,
// 101, 18 }));
// }
// }

// class Solution {
// public boolean isValidSudoku(char[][] board) {
// for (int row = 0; row < board.length; row++) {
// if (!isValidRow(board, row)) {
// return false;
// }
// }

// for (int col = 0; col < board[0].length; col++) {
// if (!isValidCol(board, col)) {
// return false;
// }
// }

// for (int col = 0; col < board[0].length; col += 3) {
// for (int row = 0; row < board.length; row += 3) {
// if (!isValidBox(board, row, col)) {
// return false;
// }
// }
// }

// return true;
// }

// private boolean isValidRow(char[][] board, int row) {
// Set<Character> set = new HashSet<>();
// for (int col = 0; col < board[0].length; col++) {
// if (board[col][row] == '.') {
// continue;
// }
// if (set.contains(board[col][row])) {
// return false;
// }
// set.add(board[col][row]);
// }
// return true;
// }

// private boolean isValidCol(char[][] board, int col) {
// Set<Character> set = new HashSet<>();
// for (int row = 0; row < board.length; row++) {
// if (board[col][row] == '.') {
// continue;
// }
// if (set.contains(board[col][row])) {
// return false;
// }
// set.add(board[col][row]);
// }
// return true;
// }

// private boolean isValidBox(char[][] board, int row, int col) {
// Set<Character> set = new HashSet<>();
// for (int c = col; c < (col + 3); c++) {
// for (int r = row; r < (row + 3); r++) {
// if (board[c][r] == '.') {
// continue;
// }
// if (set.contains(board[c][r])) {
// return false;
// }
// set.add(board[c][r]);
// }
// }
// return true;
// }
// }

// class Solution {
// public int lengthOfLongestSubstring(String s) {
// if (s.length() == 0 || s.length() == 1) {
// return s.length();
// }
// int start = 0;
// int end = 1;
// int max = 0;
// Set<Character> set = new HashSet<>();
// set.add(s.charAt(start));
// while (end < s.length()) {
// while (set.contains(s.charAt(end))) {
// set.remove(s.charAt(start));
// start++;
// }
// set.add(s.charAt(end));
// max = Math.max(max, (end - start) + 1);
// end++;
// }
// return max;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
// }
// }

// class Solution {
// public String reverseWords(String s) {
// List<String> list = new ArrayList<>();
// int index = 0;
// while (index < s.length()) {
// while (index < s.length() && s.charAt(index) == ' ') {
// index++;
// }
// if (index == s.length()) {
// continue;
// }
// String word = "";
// while (index < s.length() && s.charAt(index) != ' ') {
// word += s.charAt(index);
// index++;
// }
// list.add(word);
// }
// Collections.reverse(list);
// System.out.println(list);
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < list.size(); i++) {
// sb.append(list.get(i));
// if (i != list.size() - 1) {
// sb.append(" ");
// }
// }
// return sb.toString();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().reverseWords(" hello world "));
// }
// }

// class WordDictionary {
// class Node {
// char letter;
// Map<Character, Node> children = new HashMap<>();
// boolean isWord;

// public Node(char letter) {
// this.letter = letter;
// }
// }

// private Node root = new Node('*');

// public WordDictionary() {

// }

// public void addWord(String word) {
// addWordHelper(word, root, 0);
// }

// private void addWordHelper(String word, Node current, int index) {
// if (index == word.length()) {
// current.isWord = true;
// return;
// }
// char letter = word.charAt(index);
// if (!current.children.containsKey(letter)) {
// Node next = new Node(letter);
// next.children = new HashMap<>();
// current.children.put(letter, next);
// }
// addWordHelper(word, current.children.get(letter), index + 1);
// }

// public boolean search(String word) {
// return searchHelper(word, root, 0);
// }

// private boolean searchHelper(String word, Node current, int index) {
// if (index == word.length()) {
// return current.isWord;
// }
// char letter = word.charAt(index);
// if (letter != '.') {
// if (!current.children.containsKey(letter)) {
// return false;
// }
// return searchHelper(word, current.children.get(letter), index + 1);
// } else {
// for (Node node : current.children.values()) {
// if (searchHelper(word, node, index + 1)) {
// return true;
// }
// }
// }
// return false;
// }

// public static void main(String[] args) {
// WordDictionary dict = new WordDictionary();
// dict.addWord("bad");
// dict.addWord("bar");
// dict.addWord("mad");
// System.out.println(dict.search("bar"));
// System.out.println(dict.search(".ad"));
// System.out.println(dict.search("m.."));
// }
// }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// class Solution {
// public int change(int amount, int[] coins) {
// Map<Integer, Integer> memo = new HashMap<>();
// Arrays.sort(coins);
// return changeHelper(amount, coins, memo, coins[coins.length - 1]);
// }

// private int changeHelper(int amount, int[] coins, Map<Integer, Integer> memo,
// int max) {
// if (amount == 0) {
// return 1;
// }
// if (amount < 0) {
// return 0;
// }
// if (memo.containsKey(amount)) {
// return memo.get(amount);
// }
// int paths = 0;
// for (int i = coins.length - 1; i >= 0; i--) {
// int coin = coins[i];
// if (coin <= max) {
// int path = changeHelper(amount - coin, coins, memo, coin);
// paths += path;
// }
// }
// memo.put(amount, paths);
// return paths;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().change(5, new int[] { 1, 2, 5 }));
// }
// }

// public class Solution {
// // you need treat n as an unsigned value
// public int reverseBits(int n) {
// int left = 31;
// int right = 0;

// while (left > right) {
// int leftBit = n & (1 << left);
// int rightBit = n & (1 << right);
// if ((leftBit != 0) != (rightBit != 0)) {
// if (leftBit != 0) {
// n = turnOn(n, right);
// n = turnOff(n, left);
// }
// if (rightBit != 0) {
// n = turnOn(n, left);
// n = turnOff(n, right);
// }
// }
// left--;
// right++;
// }
// return n;
// }

// private int turnOn(int n, int index) {
// return n | (1 << index);
// }

// private int turnOff(int n, int index) {
// return n & ~(1 << index);
// }

// public static void main(String[] args) {
// System.out.println(new Solution().reverseBits(1));
// }
// }

// class MyQueue {
// private Stack<Integer> stack1 = new Stack<>();
// private Stack<Integer> stack2 = new Stack<>();

// public MyQueue() {

// }

// public void push(int x) {
// stack1.push(x);
// }

// public int pop() {
// removeAll(stack1, stack2);
// int pop = stack2.pop();
// addAll(stack1, stack2);
// return pop;
// }

// public int peek() {
// removeAll(stack1, stack2);
// int peek = stack2.peek();
// addAll(stack1, stack2);
// return peek;
// }

// public boolean empty() {
// return stack1.isEmpty();
// }

// private void removeAll(Stack<Integer> stack1, Stack<Integer> stack2) {
// while(!stack1.isEmpty()) {
// int current = stack1.pop();
// stack2.push(current);
// }
// }

// private void addAll(Stack<Integer> stack1, Stack<Integer> stack2) {
// while(!stack2.isEmpty()) {
// int current = stack2.pop();
// stack1.push(current);
// }
// }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// class Solution {
// public int change(int amount, int[] coins) {
// Map<Integer, Integer> memo = new HashMap<>();
// return changeHelper(amount, coins, memo);
// }

// private int changeHelper(int amount, int[] coins, Map<Integer, Integer> memo)
// {
// if (amount == 0) {
// return 0;
// }
// int paths = 0;
// for (int coin : coins) {
// if (amount - coin >= 0) {
// int path = changeHelper(amount - coin, coins, memo);
// paths += path;
// }
// }
// return 1 + paths;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().change(5, new int[] { 1, 2, 5 }));
// }
// }

// class Solution {
// public int coinChange(int[] coins, int amount) {
// Map<Integer, Integer> memo = new HashMap<>();
// int minCoins = coinChangeHelper(coins, amount, memo);
// if (minCoins == Integer.MAX_VALUE) {
// return -1;
// }
// return minCoins;
// }

// private int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer>
// memo) {
// if (amount == 0) {
// return 0;
// }
// if (memo.containsKey(amount)) {
// return memo.get(amount);
// }
// int min = Integer.MAX_VALUE;
// for (int coin : coins) {
// if (amount - coin >= 0) {
// int minCoins = coinChangeHelper(coins, amount - coin, memo);
// min = Math.min(min, minCoins);
// memo.put(amount, 1 + min);
// }
// }
// if (min == Integer.MAX_VALUE) {
// return Integer.MAX_VALUE;
// }
// return 1 + min;
// }
// }

// class Solution {
// public String addBinary(String a, String b) {
// StringBuilder sb = new StringBuilder();
// int aIndex = a.length() - 1;
// int bIndex = b.length() - 1;
// int sum = 0;
// while (aIndex >= 0 || bIndex >= 0) {
// int aDigit = 0;
// int bDigit = 0;
// if (aIndex >= 0) {
// aDigit = Character.getNumericValue(a.charAt(aIndex));
// }
// if (bIndex >= 0) {
// bDigit = Character.getNumericValue(b.charAt(bIndex));
// }
// sum += aDigit + bDigit;
// if (sum > 2) {
// sb.append("1");
// sum = 1;
// } else if (sum == 2) {
// sb.append("0");
// sum = 1;
// } else if (sum == 1) {
// sb.append("1");
// sum = 0;
// } else {
// sb.append("0");
// sum = 0;
// }
// aIndex--;
// bIndex--;
// }
// if (sum == 1) {
// sb.append("1");
// }
// return sb.reverse().toString();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().addBinary("1111", "1111"));
// }
// }

// class Solution {
// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
// ListNode l3 = new ListNode();
// ListNode result = l3;
// int sum = 0;
// while (l1 != null && l2 != null) {
// l3.next = new ListNode();
// l3 = l3.next;
// sum += l1.val + l2.val;
// l3.val = sum % 10;
// sum /= 10;
// l1 = l1.next;
// l2 = l2.next;
// }

// while (l1 != null) {
// l3.next = new ListNode();
// l3 = l3.next;
// sum += l1.val;
// l3.val = sum % 10;
// sum /= 10;
// l1 = l1.next;
// }

// while (l2 != null) {
// l3.next = new ListNode();
// l3 = l3.next;
// sum += l2.val;
// l3.val = sum % 10;
// sum /= 10;
// l2 = l2.next;
// }

// if (sum == 1){
// l3.next = new ListNode();
// l3 = l3.next;
// l3.val = 1;
// }

// return result.next;
// }
// }

// class Solution {
// public boolean canConstruct(String ransomNote, String magazine) {
// Map<Character, Integer> map = new HashMap<>();
// for (char c : magazine.toCharArray()) {
// if (!map.containsKey(c)) {
// map.put(c, 0);
// }
// map.put(c, 1 + map.get(c));
// }
// for (char c : ransomNote.toCharArray()) {
// if (map.get(c) == 0) {
// return false;
// }
// map.put(c, map.get(c) - 1);
// }
// return true;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().canConstruct("fihjjjjei",
// "hjibagacbhadfaefdjaeaebgi"));
// }
// }

// class Solution {
// public boolean canConstruct(String ransomNote, String magazine) {
// char[] note = ransomNote.toCharArray();
// Arrays.sort(note);
// char[] mag = magazine.toCharArray();
// Arrays.sort(mag);
// int noteIndex = 0;
// int magIndex = 0;
// while (noteIndex < note.length && magIndex < mag.length) {
// if (note[noteIndex] == mag[magIndex]) {
// noteIndex++;
// } else if (note[noteIndex] < mag[magIndex]) {
// return false;
// }
// magIndex++;
// }
// return noteIndex == note.length;
// }
// }

// class Solution {
// public TreeNode invertTree(TreeNode root) {
// if (root == null) {
// return null;
// }
// Stack<TreeNode> stack = new Stack<>();
// stack.push(root);

// while (!stack.isEmpty()) {
// TreeNode current = stack.pop();
// TreeNode left = current.left;
// current.left = current.right;
// current.right = left;
// if (current.left != null) {
// stack.push(current.left);
// }
// if (current.right != null) {
// stack.push(current.right);
// }
// return root;
// }
// }
// }

// class RandomizedSet {
// private Map<Integer, Integer> map = new HashMap<>();
// private List<Integer> list = new ArrayList<>();
// private Random random = new Random();

// public RandomizedSet() {

// }

// public boolean insert(int val) {
// if (map.containsKey(val)) {
// return false;
// }
// int index = list.size();
// map.put(val, index);
// list.add(val);
// return true;
// }

// public boolean remove(int val) {
// if (!map.containsKey(val)) {
// return false;
// }
// int index = map.get(val);
// int lastValue = list.getLast();
// list.set(list.size() - 1, list.get(index));
// list.set(index, lastValue);
// map.put(lastValue, index);
// map.remove(val);
// list.removeLast();
// return true;
// }

// public int getRandom() {
// int index = random.nextInt(list.size());
// return list.get(index);
// }
// }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// class Solution {
// public String longestCommonPrefix(String[] strs) {
// String prefix = strs[0];
// for (int i = 1; i < strs.length; i++) {
// prefix = commonPrefix(prefix, strs[i]);
// if (prefix.equals("")) {
// return prefix;
// }
// }
// return prefix;
// }

// private String commonPrefix(String prefix, String current) {
// int maxIndex = Math.min(prefix.length(), current.length());
// int index = 0;
// while (index < maxIndex && prefix.charAt(index) == current.charAt(index)) {
// index++;
// }
// return prefix.substring(0, index);
// }

// public static void main(String[] args) {
// System.out.println(new Solution().longestCommonPrefix(new String[] { "tower",
// "time", "tar" }));
// }
// }

// class Solution {
// public List<List<Integer>> getAncestors(int n, int[][] edges) {
// List<List<Integer>> ancestors = new ArrayList<>();
// Map<Integer, List<Integer>> adjMap = new HashMap<>();
// List<Integer> startingNodes = getStratingNodes(adjMap, edges, n);
// for (int startingNode : startingNodes) {
// dfs(startingNode, adjMap);
// }
// return ancestors;
// }

// private List<Integer> getStratingNodes(Map<Integer, List<Integer>> adjMap,
// int[][] edges, int n) {
// List<Integer> startingNodes = new ArrayList<>();
// int[] outDegrees = new int[n];
// for (int i = 0; i < n; i++) {
// adjMap.put(i, new ArrayList<>());
// }
// for (int[] edge : edges) {
// adjMap.get(edge[1]).add(edge[0]);
// outDegrees[edge[0]] += 1;
// }
// for (int i = 0; i < n; i++) {
// if (outDegrees[i] == 0) {
// startingNodes.add(i);
// }
// }
// return startingNodes;
// }

// private void dfs(int start, Map<Integer, List<Integer>> adjMap) {
// Stack<Integer> stack = new Stack<>();
// Set<Integer> visited = new HashSet<>();
// stack.push(start);

// while (!stack.isEmpty()) {
// int current = stack.pop();
// visited.add(current);
// for (int ancestor : adjMap.get(current)) {
// for (int num : visited) {
// adjMap.get(num).add(ancestor);
// }
// }
// }
// }

// public static void main(String[] args) {
// System.out.println(new Solution().getAncestors(8,
// new int[][] { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, {
// 3, 6 }, { 3, 7 }, { 4, 6 } }));
// }
// }

// class Solution {
// public List<List<Integer>> getAncestors(int n, int[][] edges) {
// List<List<Integer>> result = new ArrayList<>();
// Map<Integer, Set<Integer>> directAncestorsMap = new HashMap<>();
// buildDirectAncestorsMap(n, edges, directAncestorsMap);

// for (int key : directAncestorsMap.keySet()) {
// Set<Integer> set = directAncestorsMap.get(key);
// Queue<Integer> queue = new LinkedList<>();
// while (!queue.isEmpty()) {
// int current = queue.poll();
// directAncestorsMap.get(current);
// }
// }

// }

// private void buildDirectAncestorsMap(int n, int[][] edges, Map<Integer,
// Queue<Integer>> adjMap) {
// for (int i = 0; i < n; i++) {
// adjMap.put(i, new LinkedList<>());
// }
// for (int[] edge : edges) {
// adjMap.get(edge[1]).add(edge[0]);
// }
// }
// }

// class Solution {
// public String removeKdigits(String num, int k) {
// if (num.length() == k) {
// return "0";
// }

// int removed = 0;
// Stack<Integer> stack = new Stack<>();
// stack.push(Character.getNumericValue(num.charAt(0)));

// int index = 1;
// while (!stack.isEmpty() && removed < k && index < num.length()) {
// int n = Character.getNumericValue(num.charAt(index));
// if (n > stack.peek()) {
// removed++;
// } else if (n < stack.peek()) {
// stack.pop();
// stack.push(n);
// removed++;
// } else {
// stack.push(n);
// }
// index++;
// }
// if (stack.isEmpty()) {
// return num.substring(index, num.length() - 1);
// }
// return buildString(stack, num, index);
// }

// private String buildString(Stack<Integer> stack, String num, int index) {
// StringBuilder sb = new StringBuilder();
// while (!stack.isEmpty()) {
// int c = stack.pop();
// sb.append(c);
// }

// String result = sb.reverse().toString() + num.substring(index, num.length());
// return result.replaceFirst("^0+(?!$)", "");
// }

// public static void main(String[] args) {
// System.out.println(new Solution().removeKdigits("33526221184202197273", 19));
// }
// }

// class Solution {
// public int[] nextGreaterElement(int[] nums1, int[] nums2) {
// for (int i = 0; i < nums1.length; i++) {
// int j = 0;
// while(j < nums2.length && nums1[i] != nums2[j]) {
// j++;
// }
// int k = j + 1;
// while (k < nums2.length && nums2[k] <= nums2[j]) {
// k++;
// }
// if(k == nums2.length) {
// nums1[i] = -1;
// } else {
// nums1[i] = k;
// }
// }
// return nums1;
// }
// }

// class Solution {
// public ListNode removeNodes(ListNode head) {
// ListNode current = head;
// Stack<ListNode> stack = new Stack<>();
// while (current != null) {
// while (!stack.isEmpty() && current.val > stack.peek().val) {
// stack.pop();
// if (stack.isEmpty()) {
// head = current;
// } else {
// stack.peek().next = current;
// }
// }
// stack.push(current);
// current = current.next;
// }
// return head;
// }
// }

// class Solution {
// public List<List<Integer>> subsetsWithDup(int[] nums) {
// List<List<Integer>> result = new ArrayList<>();
// Arrays.sort(nums);
// backtrack(nums, result, new ArrayList<>(), 0);
// return result;
// }

// private void backtrack(int[] array, List<List<Integer>> result, List<Integer>
// list, int index) {
// result.add(new ArrayList<>(list));
// for (int i = index; i < array.length; i++) {
// if (i > index && array[i] == array[i - 1]) {
// continue;
// }
// list.add(array[i]);
// backtrack(array, result, list, i + 1);
// list.removeLast();
// }
// }

// public static void main(String[] args) {
// System.out.println(new Solution().subsetsWithDup(new int[] { 1, 2, 3, 3 }));
// }
// }

// class Solution {
// public List<List<Integer>> permute(int[] nums) {
// List<List<Integer>> result = new ArrayList<>();
// boolean[] isUsed = new boolean[nums.length];
// permuteHelper(nums, result, new ArrayList<>(), isUsed);
// return result;
// }

// private void permuteHelper(int[] nums, List<List<Integer>> result,
// List<Integer> list, boolean[] isUsed) {
// if (list.size() == nums.length) {
// result.add(new ArrayList<>(list));
// return;
// }

// for (int i = 0; i < nums.length; i++) {
// if (isUsed[i] == true) {
// continue;
// }
// list.add(nums[i]);
// isUsed[i] = true;
// permuteHelper(nums, result, list, isUsed);
// list.removeLast();
// isUsed[i] = false;
// }
// }

// public static void main(String[] args) {
// System.out.println(new Solution().permute(new int[] { 0,1 }));
// }
// }

// class Solution {
// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// public TreeNode constructMaximumBinaryTree(int[] nums) {
// return buildTree(nums, 0, nums.length - 1);
// }

// private TreeNode buildTree(int[] nums, int left, int right) {
// if (left == right) {
// return new TreeNode(nums[left]);
// }
// int maxIndex = maxIndex(nums, left, right);
// TreeNode node = new TreeNode(nums[maxIndex]);
// node.left = buildTree(nums, left, maxIndex - 1);
// node.right = buildTree(nums, maxIndex + 1, right);
// return node;
// }

// private int maxIndex(int[] nums, int left, int right) {
// int maxIndex = left;
// for (int i = left; i <= right; i++) {
// if (nums[i] > nums[maxIndex]) {
// maxIndex = i;
// }
// }
// return maxIndex;
// }
// }

// class Solution {
// public int maxArea(int[] height) {
// int maxArea = 0;
// for (int i = 0; i < height.length - 1; i++) {
// for (int j = i + 1; j < height.length; j++) {
// int area = Math.min(height[i], height[j]) * (j - i);
// maxArea = Math.max(maxArea, area);
// }
// }
// return maxArea;
// }
// }

// class UndergroundSystem {
// class Ride {
// int id;
// String startStation;
// int startTime;
// String endStation;
// int endTime;

// public Ride(int id, String startStation, int startTime) {
// this.id = id;
// this.startStation = startStation;
// this.startTime = startTime;
// }
// }

// private Map<Integer, Ride> idToRideMap = new HashMap<>();
// private Map<String, List<Integer>> routeToDurationsMap = new HashMap<>();

// public UndergroundSystem() {

// }

// public void checkIn(int id, String stationName, int t) {
// Ride ride = new Ride(id, stationName, t);
// idToRideMap.put(id, ride);
// }

// public void checkOut(int id, String stationName, int t) {
// Ride ride = idToRideMap.get(id);
// ride.endStation = stationName;
// ride.endTime = t;
// String route = toKey(ride.startStation, ride.endStation);
// int duration = ride.endTime - ride.startTime;
// if (routeToDurationsMap.get(route) == null) {
// routeToDurationsMap.put(route, new ArrayList<>());
// }
// routeToDurationsMap.get(route).add(duration);
// }

// public double getAverageTime(String startStation, String endStation) {
// String route = toKey(startStation, endStation);
// List<Integer> list = routeToDurationsMap.get(route);
// int sum = 0;
// for (int duration : list) {
// sum += duration;
// }
// return (double) sum / list.size();
// }

// private String toKey(String startStation, String endStation) {
// return startStation + "," + endStation;
// }
// }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

// class Solution {
// public boolean isHappy(int n) {
// Set<Integer> set = new HashSet<>();
// while (n > 0) {
// set.add(n);
// int sum = 0;
// while (n > 0) {
// sum += Math.pow((n % 10), 2);
// n /= 10;
// }
// if (sum == 1) {
// return true;
// }
// if (set.contains(sum)) {
// return false;
// }
// n = sum;
// }
// return false;
// }
// }

// class TimeMap {
// private HashMap<String, TreeMap<Integer, String>> map = new HashMap<>(10000);

// public TimeMap() {

// }

// public void set(String key, String value, int timestamp) {
// if (!map.containsKey(key)) {
// map.put(key, new TreeMap<>());
// }
// TreeMap<Integer, String> treeMap = map.get(key);
// treeMap.put(timestamp, value);
// }

// public String get(String key, int timestamp) {
// TreeMap<Integer, String> treeMap = map.get(key);
// if (treeMap == null) {
// return "";
// }
// if (treeMap.floorKey(timestamp) == null) {
// return "";
// }
// int time = treeMap.floorKey(timestamp);
// return treeMap.get(time);
// }
// }

// class Solution {
// public List<Integer> spiralOrder(int[][] matrix) {
// List<Integer> spiralOrder = new ArrayList<>();
// Set<String> set = new HashSet<>();
// int matrixSize = matrix.length * matrix[0].length;
// int x = 0;
// int y = 0;

// while (set.size() < matrixSize) {
// while (!set.contains(toKey(x, y)) && y < matrix[0].length) {
// set.add(toKey(x, y));
// spiralOrder.add(matrix[x][y]);
// y++;
// }
// x++;
// y--;
// while (!set.contains(toKey(x, y)) && x < matrix.length) {
// set.add(toKey(x, y));
// spiralOrder.add(matrix[x][y]);
// x++;
// }
// x--;
// y--;
// while (!set.contains(toKey(x, y)) && y >= 0) {
// set.add(toKey(x, y));
// spiralOrder.add(matrix[x][y]);
// y--;
// }
// x--;
// y++;
// while (!set.contains(toKey(x, y)) && x >= 0) {
// set.add(toKey(x, y));
// spiralOrder.add(matrix[x][y]);
// x--;
// }
// x++;
// y++;
// }
// return spiralOrder;
// }

// private String toKey(int x, int y) {
// return x + "," + y;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().spiralOrder(new
// int[][]{{1,2,3},{4,5,6},{7,8,9}}));
// }
// }

// class Solution {
// public int hIndex(int[] citations) {
// int papers = citations.length;
// int[] buckets = new int[papers + 1];

// for (int citation : citations) {
// buckets[Math.min(citation, papers)] += 1;
// }

// int max = 0;
// for (int hIndex = papers; hIndex >= 0; hIndex--) {
// max += buckets[hIndex];
// if (max >= hIndex) {
// return hIndex;
// }
// }
// return -1;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().hIndex(new int[]{3,0,6,1,5}));
// }
// }

// class Solution {
// public int evalRPN(String[] tokens) {
// Stack<Integer> stack = new Stack<>();
// int index = 0;
// while (index < tokens.length) {
// String token = tokens[index];
// if (token.equals("+") || token.equals("-") || token.equals("*") ||
// token.equals("/")) {
// int b = stack.pop();
// int a = stack.pop();
// int result = 0;
// if (token.equals("+")) {
// result = a + b;
// } else if (token.equals("-")) {
// result = a - b;
// } else if (token.equals("*")) {
// result = a * b;
// } else {
// result = a / b;
// }
// stack.add(result);
// } else {
// stack.add(Integer.valueOf(token));
// }
// index++;
// }
// return stack.pop();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().evalRPN(new String[] { "2", "1", "+", "3",
// "*" }));
// }
// }

// class Solution {
// class Trie {
// public void insert(String s) {
// Node current = root;
// for (int i = 0; i < s.length(); i++) {
// char letter = s.charAt(i);
// if (!current.children.containsKey(letter)) {
// Node child = new Node();
// child.letter = letter;
// current.children.put(letter, child);
// }
// current = current.children.get(letter);
// }
// current.isWord = true;
// }

// public List<String> wordsWithPrefix(String prefix, int limit) {
// List<String> list = new ArrayList<>();
// Node current = root;
// for (int i = 0; i < prefix.length(); i++) {
// char letter = prefix.charAt(i);
// if (!current.children.containsKey(letter)) {
// return list;
// }
// current = current.children.get(letter);
// }
// return list;
// }

// public void gatherWords(String prefix, Node current, List<String> result, int
// limit) {
// if (result.size() == limit) {
// return;
// }
// if (current.isWord) {
// result.add(prefix);
// }
// for (char letter : current.children.keySet()) {
// gatherWords(prefix + letter, current.children.get(letter), result, limit);
// }
// }
// }

// class Node {
// char letter;
// TreeMap<Character, Node> children = new TreeMap<>();
// boolean isWord = false;
// }

// private Node root = new Node();

// public List<List<String>> suggestedProducts(String[] products, String
// searchWord) {
// Trie trie = new Trie();
// for (String product : products) {
// trie.insert(product);
// }

// List<List<String>> result = new ArrayList<>();
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < searchWord.length(); i++) {
// sb.append(searchWord.charAt(i));
// String prefix = sb.toString();
// result.add(trie.wordsWithPrefix(prefix, 3));
// }
// return result;
// }
// }

// class Solution {
// public int climbStairs(int n) {
// Integer[] memo = new Integer[n];
// return climbStairsHelper(n, memo);
// }

// private int climbStairsHelper(int n, Integer[] memo) {
// if (n == 0 || n == 1) {
// return n;
// }
// if (memo[n] == null) {
// memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
// }
// return memo[n];
// }

// public static void main(String[] args) {
// System.out.println(new Solution().climbStairs(44));
// }
// }

// class Solution {
// public boolean searchMatrix(int[][] matrix, int target) {
// if (target < matrix[0][0] || target > matrix[matrix.length -
// 1][matrix[0].length - 1]) {
// return false;
// }

// List<Integer> nums = new ArrayList<>();
// for (int x = 0; x < matrix.length; x++) {
// for (int y = 0; y < matrix[0].length; y++) {
// nums.add(matrix[x][y]);
// }
// }

// int left = 0;
// int right = nums.size() - 1;
// while (left <= right) {
// int middle = ((right - left) / 2) + left;
// int num = nums.get(middle);
// if (target < num) {
// right = middle - 1;
// } else if (target > num) {
// left = middle + 1;
// } else {
// return true;
// }
// }
// return false;
// }

// public static void main(String[] args) {
// int[][] nums = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30,
// 34, 60 } };
// System.out.println(new Solution().searchMatrix(nums, 11));
// }
// }

// class Solution {
// public List<Double> averageOfLevels(TreeNode root) {
// List<Double> averages = new ArrayList<>();
// Queue<TreeNode> queue = new LinkedList<>();
// queue.add(root);
// while (!queue.isEmpty()) {
// int nodesInLevel = queue.size();
// long sum = 0;
// List<TreeNode> list = new ArrayList<>();
// while (nodesInLevel > 0) {
// list.add(queue.poll());
// nodesInLevel--;
// }
// for (TreeNode node : list) {
// sum += node.val;
// if (node.left != null) {
// queue.add(node.left);
// }
// if (node.right != null) {
// queue.add(node.right);
// }
// }
// double average = sum / list.size();
// averages.add(average);
// }
// return averages;
// }
// }

// class LRUCache {
// class ListNode<T> {
// T key;
// T val;
// ListNode<T> previous;
// ListNode<T> next;

// public ListNode() {
// }

// public ListNode(T val) {
// this.val = val;
// }

// public ListNode(T key, T val) {
// this.key = key;
// this.val = val;
// }
// }

// class DoublyLinkedList<T> {
// private ListNode<T> head = new ListNode<>();
// private ListNode<T> tail = new ListNode<>();

// public DoublyLinkedList() {
// this.head.next = tail;
// this.tail.previous = head;
// }

// public void add(ListNode<T> first) {
// ListNode<T> zero = head;
// ListNode<T> second = zero.next;
// zero.next = first;
// first.previous = zero;
// first.next = second;
// second.previous = first;
// }

// public void delete(ListNode<T> current) {
// ListNode<T> previous = current.previous;
// ListNode<T> next = current.next;
// previous.next = next;
// next.previous = previous;
// }

// public void deleteTail() {
// if (tail.previous != head) {
// delete(tail.previous);
// return;
// }
// throw new IllegalArgumentException();
// }

// public T getTailKey() {
// return tail.previous.key;
// }
// }

// private int capacity;
// private DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
// private Map<Integer, ListNode<Integer>> map = new HashMap<>();

// public LRUCache(int capacity) {
// this.capacity = capacity;
// }

// public int get(int key) {
// if (!map.containsKey(key)) {
// return -1;
// }
// ListNode<Integer> current = map.get(key);
// int value = current.val;
// list.delete(current);
// list.add(current);
// return value;
// }

// public void put(int key, int value) {
// if (map.containsKey(key)) {
// ListNode<Integer> current = map.get(key);
// list.delete(current);
// current.val = value;
// list.add(current);
// } else if (map.size() < capacity) {
// ListNode<Integer> current = new ListNode<>(key, value);
// list.add(current);
// map.put(key, current);
// } else {
// int lruKey = list.getTailKey();
// list.deleteTail();
// map.remove(lruKey);
// ListNode<Integer> current = new ListNode<>(key, value);
// list.add(current);
// map.put(key, current);
// }
// }

// public static void main(String[] args) {
// LRUCache lruCache = new LRUCache(2);
// lruCache.put(1, 1);
// lruCache.put(2, 2);
// System.out.println(lruCache.get(1));
// lruCache.put(3, 3);
// System.out.println(lruCache.get(2));
// lruCache.put(4, 4);
// System.out.println(lruCache.get(1));
// System.out.println(lruCache.get(3));
// System.out.println(lruCache.get(4));
// }
// }

// class LRUCache {
// class ListNode {
// int key;
// int val;
// ListNode previous;
// ListNode next;

// public ListNode() {
// }

// public ListNode(int val) {
// this.val = val;
// }

// public ListNode(int key, int val) {
// this.key = key;
// this.val = val;
// }
// }

// class DoublyLinkedList {
// private ListNode head = new ListNode();
// private ListNode tail = new ListNode();

// public DoublyLinkedList() {
// this.head.next = tail;
// this.tail.previous = head;
// }

// public void add(ListNode first) {
// ListNode zero = head;
// ListNode second = zero.next;
// zero.next = first;
// first.previous = zero;
// first.next = second;
// second.previous = first;
// }

// public void delete(ListNode current) {
// ListNode previous = current.previous;
// ListNode next = current.next;
// previous.next = next;
// next.previous = previous;
// }

// public void deleteTail() {
// if (tail.previous != head) {
// delete(tail.previous);
// return;
// }
// throw new IllegalArgumentException();
// }

// public int getTailKey() {
// return tail.previous.key;
// }
// }

// private int capacity;
// private DoublyLinkedList list = new DoublyLinkedList();
// private Map<Integer, ListNode> map = new HashMap<>();

// public LRUCache(int capacity) {
// this.capacity = capacity;
// }

// public int get(int key) {
// if (!map.containsKey(key)) {
// return -1;
// }
// ListNode current = map.get(key);
// int value = current.val;
// list.delete(current);
// list.add(current);
// return value;
// }

// public void put(int key, int value) {
// if (map.containsKey(key)) {
// ListNode current = map.get(key);
// list.delete(current);
// current.val = value;
// list.add(current);
// } else if (map.size() < capacity) {
// ListNode current = new ListNode(key, value);
// list.add(current);
// map.put(key, current);
// } else {
// int lruKey = list.getTailKey();
// list.deleteTail();
// map.remove(lruKey);
// ListNode current = new ListNode(key, value);
// list.add(current);
// map.put(key, current);
// }
// }
// }

// class Solution {
// public int jump(int[] nums) {
// Integer[] memo = new Integer[nums.length];
// return jumpHelper(nums, 0, memo);
// }

// private int jumpHelper(int[] nums, int index, Integer[] memo) {
// int min = Integer.MAX_VALUE;
// if (index >= nums.length - 1) {
// return 0;
// }
// if (nums[index] == 0) {
// memo[index] = Integer.MAX_VALUE;
// }
// if (memo[index] != null) {
// return memo[index];
// }
// for (int i = 1; i <= nums[index]; i++) {
// min = Math.min(min, jumpHelper(nums, index + i, memo));
// if (index + i < nums.length) {
// memo[index + i] = min;
// }
// }
// if (min == Integer.MAX_VALUE) {
// return min;
// }
// return min + 1;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().jump(new int[] {
// 5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5
// }));
// }
// }

// class Solution {
// public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
// ListNode list = new ListNode();
// ListNode head = list;
// while (list1 != null && list2 != null) {
// if (list1.val <= list2.val) {
// list.next = list1;
// list1 = list1.next;
// } else {
// list.next = list2;
// list2 = list2.next;
// }
// list = list.next;
// }

// while (list1 != null) {
// list.next = list1;
// list1 = list1.next;
// list = list.next;
// }

// while (list2 != null) {
// list.next = list2;
// list2 = list2.next;
// list = list.next;
// }

// return head.next;
// }
// }

// class Solution {
// public boolean isValidBST(TreeNode root) {
// return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
// }

// private boolean isValidBSTHelper(TreeNode root, long min, long max) {
// if (root == null) {
// return true;
// }

// if (root.val <= min || root.val >= max) {
// return false;
// }

// min = Math.min(min, root.val);
// max = Math.max(max, root.val);
// return isValidBSTHelper(root.left, min, root.val) &&
// isValidBSTHelper(root.right, root.val, max);
// }
// }

// class Solution {
// public List<List<Integer>> threeSum(int[] nums) {
// List<List<Integer>> result = new ArrayList<>();
// Arrays.sort(nums);
// int left = 0;
// while (left < nums.length - 2) {
// while (left > 0 && left < nums.length - 2 && nums[left] == nums[left - 1]) {
// left++;
// }

// int middle = left + 1;
// int right = nums.length - 1;

// while (middle < right) {
// if (nums[left] + nums[middle] + nums[right] < 0) {
// middle++;
// } else if (nums[left] + nums[middle] + nums[right] > 0) {
// right--;
// } else {
// List<Integer> ans = new ArrayList<>();
// Collections.addAll(ans, nums[left], nums[middle], nums[right]);
// result.add(ans);
// middle++;

// while (middle < right && nums[middle] == nums[middle - 1]) {
// middle++;
// }
// }
// }

// left++;
// }

// return result;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().threeSum(new int[] { -1, 0, 1, 2, -1, -4
// }));
// }
// }

// class Solution {
// public int strStr(String haystack, String needle) {
// if (haystack.length() < needle.length()) {
// return -1;
// }

// for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
// int j = 0;
// while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
// j++;
// }
// if (j == needle.length()) {
// return i;
// }
// }

// return -1;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().strStr("abc", "c"));
// }
// }

// class Solution {
// public int[] shortestToChar(String s, char c) {
// int[] distance = new int[s.length()];
// for (int i = 0; i < distance.length; i++){

// }
// return distance;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().shortestToChar("lertcode", 'e'));
// }
// }

// class Solution {
// public int arrayPairSum(int[] nums) {
// Arrays.sort(nums);
// int sum = 0;
// for (int i = 0; i < nums.length; i += 2) {
// sum += nums[i];
// }
// return sum;
// }

// public static void main(String[] args) {
// int[] nums = { 1, 4, 3, 2 };
// System.out.println(new Solution().arrayPairSum(nums));
// }
// }

// class Solution {
// public List<String> generateParenthesis(int n) {
// List<String> result = new ArrayList<>();
// int length = n * 2;
// generateParenthesisHelper("", length, 0, result);
// return result;
// }

// private void generateParenthesisHelper(String current, int length, int
// openParen, List<String> result) {
// if (current.length() == length) {
// result.add(current);
// return;
// }
// if (current.length() + openParen < length)
// generateParenthesisHelper(current + "(", length, openParen + 1, result);

// if (openParen > 0) {
// generateParenthesisHelper(current + ")", length, openParen - 1, result);
// }
// }
// }

// class Solution {
// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// public boolean hasPathSum(TreeNode root, int targetSum) {
// if (root == null) {
// return false;
// }
// if (root.left == null && root.right == null) {
// return (targetSum - root.val) == 0;
// }
// boolean left = hasPathSum(root.left, targetSum - root.val);
// boolean right = hasPathSum(root.right, targetSum - root.val);
// return left || right;
// }
// }

// class Solution {
// public void setZeroes(int[][] matrix) {
// int height = matrix.length;
// int width = matrix[0].length;
// boolean[] rows = new boolean[height];
// boolean[] cols = new boolean[width];
// for (int x = 0; x < matrix.length; x++) {
// for (int y = 0; y < matrix[0].length; y++) {
// if (matrix[x][y] == 0) {
// rows[x] = true;
// cols[y] = true;
// }
// }
// }

// for (int i = 0; i < rows.length; i++) {
// if (rows[i]) {
// for (int y = 0; y < width; y++) {
// matrix[i][y] = 0;
// }
// }
// }

// for (int i = 0; i < cols.length; i++) {
// if (cols[i]) {
// for (int x = 0; x < height; x++) {
// matrix[x][i] = 0;
// }
// }
// }
// }
// }

// class Solution {
// public class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

// public ListNode removeElements(ListNode head, int val) {
// if (head == null) {
// return head;
// }
// ListNode current = head;
// while (current != null) {
// if (current.next != null && current.next.val == val) {
// current.next = current.next.next;
// } else {
// current = current.next;
// }
// }
// if (head.val == val) {
// return head.next;
// }
// return head;
// }
// }

// class Solution {
// public boolean rotateString(String s, String goal) {
// if (s.length() != goal.length()) {
// return false;
// }

// for (int i = 0; i < s.length(); i++) {
// if (isMatching(s, goal, i)) {
// return true;
// }
// }
// return false;
// }

// private boolean isMatching(String s, String goal, int index) {
// int j = 0;
// while (j < goal.length()) {
// if (goal.charAt(j) != s.charAt(index)) {
// return false;
// }
// j++;
// index = ((index + 1) % s.length());
// }

// return true;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().rotateString("abcde", "abced"));
// }
// }

// class Solution {
// public double largestTriangleArea(int[][] points) {
// double max = 0.0;
// for (int a = 0; a < points.length; a++) {
// for (int b = a + 1; b < points.length; b++) {
// for (int c = b + 1; c < points.length; c++) {
// int[] aa = points[a];
// int[] bb = points[b];
// int[] cc = points[c];
// double area = Math.abs(area(aa, bb, cc));
// max = Math.max(max, area);
// }
// }
// }
// return max;
// }

// private double area(int[] aa, int[] bb, int[] cc) {
// int t1 = aa[0] * ( bb[1] - cc[1]);
// int t2 = bb[0] * ( cc[1] - aa[1]);
// int t3 = cc[0] * ( aa[1] - bb[1]);
// return (double)( t1 + t2 + t3 )/2;
// }
// }

// class Solution {
// public List<Integer> rightSideView(TreeNode root) {
// List<Integer> result = new ArrayList<>();
// if (root == null) {
// return result;
// }

// Queue<TreeNode> queue = new LinkedList<>();
// queue.add(root);
// while (!queue.isEmpty()) {
// List<TreeNode> nodes = new ArrayList<>();
// int size = queue.size();
// while (size > 0) {
// TreeNode current = queue.poll();
// nodes.add(current);
// size--;
// }

// result.add(nodes.getLast().val);

// for (TreeNode node : nodes) {
// if (node.left != null) {
// queue.add(node.left);
// }
// if (node.right != null) {
// queue.add(node.right);
// }
// }
// }

// return result;
// }
// }

// public class Solution extends VersionControl {
// public int firstBadVersion(int n) {
// int left = 1;
// while (left <= n) {
// int middle = (n - left) / 2 + left;
// if (isBadVersion(middle)) {
// n = middle - 1;
// } else {
// left = middle + 1;
// }
// }
// return left;
// }
// }

// class Solution {
// public int searchInsert(int[] nums, int target) {
// int left = 0;
// int right = nums.length - 1;
// while (left <= right) {
// int middle = (right - left) / 2 + left;
// if (target == nums[middle]) {
// return middle;
// } else if (target < nums[middle]) {
// right = middle - 1;
// } else {
// left = middle + 1;
// }
// }

// return left;
// }
// }

// NOT RESOLVED
// class Solution {
// class Location {
// int x;
// int y;
// int index;

// Location(int x, int y, int index) {
// this.x = x;
// this.y = y;
// this.index = index;
// }
// }

// public boolean exist(char[][] board, String word) {
// for (int x = 0; x < board.length; x++) {
// for (int y = 0; y < board[0].length; y++) {
// if (dfs(board, word, new Location(x, y, 0))) {
// return true;
// }
// }
// }
// return false;
// }

// private boolean dfs(char[][] board, String word, Location start) {
// Set<String> letters = new HashSet<>();
// Stack<Location> stack = new Stack<>();
// stack.add(start);

// while (!stack.isEmpty()) {
// Location current = stack.pop();
// char character = board[current.x][current.y];
// String coords = current.x + "," + current.y;
// if (!letters.contains(coords) && character == word.charAt(current.index)
// && current.index == word.length() - 1) {
// return true;
// }

// if (!letters.contains(coords) && character == word.charAt(current.index)) {
// letters.add(coords);
// for (Location neighbor : neighbors(current)) {
// if (isInsideGrid(neighbor, board)) {
// stack.add(neighbor);
// }
// }
// }
// }
// return false;
// }

// private List<Location> neighbors(Location current) {
// Location up = new Location(current.x - 1, current.y, current.index + 1);
// Location down = new Location(current.x + 1, current.y, current.index + 1);
// Location left = new Location(current.x, current.y - 1, current.index + 1);
// Location right = new Location(current.x, current.y + 1, current.index + 1);
// return Arrays.asList(up, down, left, right);
// }

// private boolean isInsideGrid(Location current, char[][] board) {
// return current.x < board.length && current.y < board[0].length && current.x
// >= 0 && current.y >= 0;
// }

// public static void main(String[] args) {
// char[][] board = {
// { 'C', 'A', 'A' },
// { 'A', 'A', 'A' },
// { 'B', 'C', 'D' },
// };
// System.out.println(new Solution().exist(board, "AAB"));
// }
// }

// class Solution {
// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// public TreeNode sortedArrayToBST(int[] nums) {
// return buildBST(nums, 0, nums.length - 1);
// }

// private TreeNode buildBST(int[] nums, int left, int right) {
// if (left == right) {
// return new TreeNode(nums[left]);
// }

// if (left > right) {
// return null;
// }

// int middle = ((right - left) / 2) + left;
// TreeNode root = new TreeNode(nums[middle]);
// root.left = buildBST(nums, left, middle - 1);
// root.right = buildBST(nums, middle + 1, right);
// return root;
// }
// }

// class Solution {
// public int calPoints(String[] operations) {
// Stack<Integer> stack = new Stack<>();
// for (String operation : operations) {
// if (operation.equals("+")) {
// int last = stack.pop();
// int secondToLast = stack.peek();
// int score = last + secondToLast;
// stack.add(last);
// stack.add(score);
// } else if (operation.equals("D")) {
// int last = stack.peek();
// int score = last * 2;
// stack.add(score);
// } else if (operation.equals("C")) {
// stack.pop();
// } else {
// stack.add(Integer.valueOf(operation));
// }
// }

// int sum = 0;
// while (!stack.isEmpty()) {
// sum += stack.pop();
// }
// return sum;
// }
// }

// public class Solution {
// public class ListNode {
// int val;
// ListNode next;

// ListNode(int x) {
// val = x;
// next = null;
// }
// }

// public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
// ListNode currentA = headA;
// ListNode currentB = headB;

// Set<ListNode> set = new HashSet<>();
// while (currentA != null) {
// set.add(currentA.next);
// currentA = currentA.next;
// }

// while (currentB != null) {
// if (set.contains(currentB)) {
// return currentB;
// }
// currentB = currentB.next;
// }

// return null;
// }
// }

// class Solution {
// public boolean validPath(int n, int[][] edges, int source, int destination) {
// List<List<Integer>> graph = new ArrayList<>();
// for (int i = 0; i < n; i++) {
// graph.add(new ArrayList<>());
// }

// for (int[] edge : edges) {
// graph.get(edge[0]).add(edge[1]);
// graph.get(edge[1]).add(edge[0]);
// }

// boolean[] visited = new boolean[n];
// Queue<Integer> queue = new LinkedList<>();
// queue.add(source);
// visited[source] = true;

// while (!queue.isEmpty()) {
// int current = queue.poll();
// if (current == destination) {
// return true;
// }

// for (int neighbor : graph.get(current)) {
// if (!visited[neighbor]) {
// visited[neighbor] = true;
// queue.add(neighbor);
// }
// }
// }
// return false;
// }
// }

// class Solution {
// public String[] findRelativeRanks(int[] score) {
// PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
// (a, b) -> b.getKey() - a.getKey());
// for (int i = 0; i < score.length; i++) {
// pq.add(new Pair<>(score[i], i));
// }

// String[] rank = new String[score.length];
// int place = 1;
// while (!pq.isEmpty()) {
// Pair<Integer, Integer> pair = pq.poll();
// int index = pair.getValue();
// if (place == 1) {
// rank[index] = "Gold Medal";
// } else if (place == 2) {
// rank[index] = "Silver Medal";
// } else if (place == 3) {
// rank[index] = "Bronze Medal";
// } else {
// rank[index] = String.valueOf(place);
// }
// place++;
// }
// return rank;
// }
// }

// class Solution {
// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// public boolean isSymmetric(TreeNode root) {
// if (root == null) {
// return true;
// }
// return isSymmetricHelper(root.left, root.right);
// }

// private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
// if (left == null && right == null) {
// return true;
// }
// if (left == null || right == null || left.val != right.val) {
// return false;
// }
// return isSymmetricHelper(left.left, right.right) &&
// isSymmetricHelper(left.right, right.left);
// }

// public static void main(String[] args) {
// System.out.println(new Solution.isSymmetric());
// }
// }

// class Solution {
// public int lengthOfLastWord(String s) {
// int firstLetter = s.length() - 1;
// while (firstLetter >= 0 && s.charAt(firstLetter) == ' ') {
// firstLetter--;
// }
// int lastLetter = firstLetter - 1;
// while (lastLetter >= 0 && s.charAt(lastLetter) != ' ') {
// lastLetter--;
// }
// return firstLetter - lastLetter;
// }
// }

// class Solution {
// public class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

// public ListNode mergeKLists(ListNode[] lists) {
// ListNode result = new ListNode();
// ListNode current = result;

// PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode x, ListNode y) ->
// {
// if (x.val == y.val) {
// return 0;
// } else if (x.val < y.val) {
// return -1;
// } else {
// return +1;
// }
// });

// for (ListNode list : lists) {
// if (list != null) {
// pq.add(list);
// }
// }

// while (!pq.isEmpty()) {
// ListNode top = pq.poll();
// current.next = top;
// current = current.next;
// if (top.next != null) {
// pq.add(top.next);
// }
// }

// return result.next;
// }
// }

// class Solution {
// public int uniquePaths(int m, int n) {
// Integer[][] memo = new Integer[m][n];
// return 1 + uniquePaths(m, n, 0, 0, memo);
// }

// private int uniquePaths(int m, int n,int y, int x, Integer[][] memo) {
// if (y >= m - 1 || x >= n - 1) {
// return 0;
// }
// if (memo[y][x] != null) {
// return memo[y][x];
// }
// int uniquePaths = uniquePaths(m, n, y, x + 1, memo) + uniquePaths(m, n, y +
// 1, x, memo) + 1;
// memo[y][x] = uniquePaths;
// return uniquePaths;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().uniquePaths(3, 2));
// }
// }

// class Solution {
// public int rob(int[] nums) {
// Integer[] memo = new Integer[nums.length];
// return maxAmount(nums, 0, memo);
// }

// private int maxAmount(int[] nums, int index, Integer[] memo) {
// if (index >= nums.length) {
// return 0;
// }
// if (memo[index] != null) {
// return memo[index];
// }
// int maxAmount = Math.max(maxAmount(nums, index + 1, memo), nums[index] +
// maxAmount(nums, index + 2, memo));
// memo[index] = maxAmount;
// return maxAmount;
// }
// }

// class Solution {
// public int minCostClimbingStairs(int[] cost) {
// Integer[] memo = new Integer[cost.length];
// return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
// }

// private int minCost(int[] cost, int index, Integer[] memo) {
// if (index >= cost.length) {
// return 0;
// }
// if (memo[index] != null) {
// return memo[index];
// }

// int costIfWeMoveToTheNextStep = cost[index] + minCost(cost, index + 1, memo);
// int costIfWeMoveTwoSteps = cost[index] + minCost(cost, index + 2, memo);
// int minCost = Math.min(costIfWeMoveToTheNextStep, costIfWeMoveTwoSteps);
// memo[index] = minCost;
// return minCost;
// }
// }

// class Solution {
// private long fib(long n, Map<Long, Long> memo) {
// if (n == 0) {
// return 0;
// }
// if (n == 1) {
// return 1;
// }
// if (memo.containsKey(n)) {
// return memo.get(n);
// }
// long fib = fib(n - 1, memo) + fib(n - 2, memo);
// memo.put(n, fib);

// return fib;
// }

// public long fib(long n) {
// Map<Long, Long> memo = new HashMap<>();
// return fib(n, memo);
// }

// public static void main(String[] args) {
// System.out.println("Beginning");
// int n = 200;
// long startTimeMillis = System.currentTimeMillis();
// System.out.println(n + "th fib number is " + new Solution().fib(n));
// long endTimeMillis = System.currentTimeMillis();
// System.out.println("Complete in " + (endTimeMillis - startTimeMillis) /
// 1000.0f + " seconds");
// }
// }

// class MyLinkedList {
// class Node {
// int val;
// Node next;
// }

// private Node root;
// private int size = 0;

// public int get(int index) {
// if (index >= size){
// return -1;
// }
// Node current = root;
// for (int i = 0; i < index; i++){
// current = current.next;
// }
// return current.val;
// }

// public void addAtHead(int val) {
// Node currentHead = root;
// Node newNode = new Node();
// newNode.val = val;
// newNode.next = currentHead;
// root = newNode;
// size++;
// }

// public void addAtTail(int val) {
// Node current = root;
// for (int i = 0; i < size - 1; i++){
// current = current.next;
// }
// Node newNode = new Node();
// newNode.val = val;
// current.next = newNode;
// size++;
// }

// public void addAtIndex(int index, int val) {
// if (index > size){
// return;
// }
// Node current = root;
// for (int i = 0; i < index-1; i++){
// current = current.next;
// }
// Node next = current.next;
// Node newNode = new Node();
// newNode.val = val;
// newNode.next = next;
// current.next = newNode;
// size++;
// }

// public void deleteAtIndex(int index) {
// if (index > size){
// return;
// }
// Node current = root;
// for (int i = 0; i < index - 1; i++){
// current = current.next;
// }
// Node next = current.next;
// Node newNext = next.next;
// current.next = newNext;
// size--;
// }

// public String toString() {
// StringBuilder sb = new StringBuilder();
// sb.append("[");
// Node current = root;
// while (current != null) {
// sb.append(current.val);
// sb.append(", ");
// current = current.next;
// }
// sb.append("]");
// return sb.toString();
// }

// public static void main(String[] args) {
// MyLinkedList linkedList = new MyLinkedList();
// linkedList.addAtHead(1);
// System.out.println(linkedList.toString());

// linkedList.addAtTail(3);
// System.out.println(linkedList.toString());

// linkedList.addAtIndex(1,2);
// System.out.println(linkedList.toString());
// System.out.println(linkedList.get(1));
// linkedList.deleteAtIndex(1);
// System.out.println(linkedList.toString());

// System.out.println(linkedList.get(1));
// }
// }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

// class Solution {
// public List<List<Integer>> subsets(int[] nums) {
// List<List<Integer>> list = new ArrayList<>();
// backtrack(list, new ArrayList<>(), nums, 0);
// return list;
// }

// private void backtrack(List<List<Integer>> list , List<Integer> tempList, int
// [] nums, int start){
// list.add(new ArrayList<>(tempList));
// for(int i = start; i < nums.length; i++){
// tempList.add(nums[i]);
// backtrack(list, tempList, nums, i + 1);
// tempList.remove(tempList.size() - 1);
// }
// }
// }

// class Solution {
// public List<List<Integer>> subsets(int[] nums) {
// List<Integer> chosen = new ArrayList<>();
// List<List<Integer>> result = new ArrayList<>();
// int index = 0;
// Set<String> set = new HashSet<>();
// generateSubset(nums, index, chosen, result, set);
// return result;
// }

// private void generateSubset(int[] nums, int index, List<Integer> chosen,
// List<List<Integer>> result, Set<String> set){
// String keyToString = keyToString(chosen);
// if (!set.contains(keyToString)){
// result.add(new ArrayList<>(chosen));
// set.add(keyToString);
// }
// if(index == nums.length){
// return;
// }
// chosen.add(nums[index]);
// generateSubset(nums, index + 1, chosen, result, set);
// chosen.remove(chosen.size() - 1);
// generateSubset(nums, index + 1, chosen, result, set);
// }

// private String keyToString(List<Integer> chosen){
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < chosen.size(); i++){
// sb.append(chosen.get(i));
// sb.append(",");
// }
// return sb.toString();
// }
// }

// class Solution {
// public int[] dailyTemperatures(int[] temperatures) {
// int[] answer = new int[temperatures.length];
// Stack<Integer> stack = new Stack<>();

// for (int index = 0; index < temperatures.length; index++){
// while(!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]){
// int current = stack.pop();
// answer[current] = index - current;
// }
// stack.push(index);
// }
// return answer;
// }
// }

// class Solution {
// public boolean isUgly(int n) {
// while (n > 1){
// if (n % 5 == 0){
// n /= 5;
// } else if (n % 3 == 0){
// n /= 3;
// } else if (n % 2 == 0){
// n /= 2;
// } else {
// return false;
// }
// }
// return true;
// }
// }

// class NumberContainers {
// Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();
// Map<Integer, Integer> indexToNumber = new HashMap<>();

// public void change(int index, int number) {
// if (indexToNumber.containsKey(index)){
// int otherNumber = indexToNumber.get(index);
// Set<Integer> oldIndices = numberToIndices.get(otherNumber);
// oldIndices.remove(index);
// }
// indexToNumber.put(index, number);
// numberToIndices.putIfAbsent(number, new TreeSet<>());
// numberToIndices.get(number).add(index);
// }

// public int find(int number) {
// TreeSet<Integer> indices = numberToIndices.get(number);
// if (indices == null || indices.size() == 0) {
// return -1;
// }
// return indices.first();
// }
// }

// class Solution {
// public int firstUniqChar(String s) {
// Map<Character, Integer> map = new HashMap<>();
// for (char letter : s.toCharArray()){
// if (map.containsKey(letter)){
// map.put(letter, 1 + map.get(letter));
// } else {
// map.put(letter, 1);
// }
// }
// for (int i = 0; i < s.length(); i++){
// if (map.get(s.charAt(i)) == 1){
// return i;
// }
// }
// return -1;
// }
// }

// class Solution {
// public int firstUniqChar(String s) {
// Set<Character> set = new HashSet<>();
// int current = 0;
// while (current < s.length()){
// while(current < s.length() && set.contains(s.charAt(current))){
// current++;
// }
// int next = current + 1;
// while(next < s.length() && s.charAt(current) != s.charAt(next)){
// next++;
// }
// if (next == s.length()){
// return current;
// }
// set.add(s.charAt(current));
// current++;
// }
// return -1;
// }
// }

// class Solution {
// class Node{
// int city;
// int distance;
// Node(int city, int distance){
// this.city = city;
// this.distance = distance;
// }
// }

// public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
// {
// Map<Integer, List<Node>> map = new HashMap<>();
// buildAdjacencyMap(flights, n, map);

// Set<Integer> visited = new HashSet<>();
// PriorityQueue<Node> pq = new PriorityQueue<>((Node x, Node y) -> {
// if (x.distance == y.distance) {
// return 0;
// } else if (x.distance < y.distance) {
// return -1;
// } else {
// return +1;
// }
// });

// if (map.isEmpty()){
// return -1;
// }

// pq.add(new Node(src, 0));
// while(!pq.isEmpty() && k >= 0){
// Node current = pq.poll();
// visited.add(current.city);
// for (Node neighbor : map.get(current.city)){
// if (!visited.contains(neighbor.city)){
// neighbor.distance += current.distance;
// pq.add(neighbor);
// }
// }

// k--;
// }

// return -1;
// }

// private void buildAdjacencyMap(int[][] flights, int n, Map<Integer,
// List<Node>> map){
// for(int i = 0; i < n; i++){
// map.put(i, new ArrayList<>());
// }
// for (int[] flight : flights){
// Node node = new Node(flight[1], flight[2]);
// List<Node> list = map.get(flight[0]);
// list.add(node);
// }
// }
// }

// class Solution {
// public int[][] merge(int[][] intervals) {
// Arrays.sort(intervals, (int[] a, int[] b) -> {
// return a[0] - b[0];
// });

// List<int[]> result = new ArrayList<>();
// int[] current = intervals[0];
// int index = 1;
// while(index < intervals.length){
// int[] next = intervals[index];
// if (areOverlapping(current, next)){
// current[1] = Math.max(current[1], next[1]);
// } else {
// result.add(current);
// current = next;
// }
// index++;
// }
// result.add(current);

// int[][] merge = toStaticArray(result);
// return merge;
// }

// private boolean areOverlapping(int[] current, int[] next){
// return current[1] >= next[0];
// }

// private int[][] toStaticArray(List<int[]> result){
// int[][] arrays = new int[result.size()][];
// int index = 0;
// for (int[] array : result){
// arrays[index++] = array;
// }
// return arrays;
// }

// public static void main(String[] args) {
// int[][] intervals = new int[][]{{1,3},{2,6},{8,10}};
// System.out.println(Arrays.toString(new Solution().merge(intervals)));
// }
// }

// class Solution {
// public int[] asteroidCollision(int[] asteroids) {
// Stack<Integer> stack = new Stack<>();
// int index = 0;
// while (index < asteroids.length){
// if (!stack.isEmpty() && isColliding(asteroids[index], stack)){
// while(!stack.empty() && index < asteroids.length &&
// isColliding(asteroids[index], stack)){
// if(absVal(asteroids[index]) > absVal(stack.peek())){
// stack.pop();
// } else if(absVal(asteroids[index]) < absVal(stack.peek())){
// index++;
// } else {
// stack.pop();
// index++;
// }
// }
// } else {
// stack.push(asteroids[index]);
// index++;
// }
// }

// int[] result = stackToIntArray(stack);
// return result;
// }

// private Boolean isColliding(int asteroid, Stack<Integer> stack){
// return stack.peek() > 0 && asteroid < 0;
// }

// private int absVal(int n){
// if (n < 0){
// return n * (-1);
// }
// return n;
// }

// private static int[] stackToIntArray(Stack<Integer> stack){
// int[] array = new int[stack.size()];
// int index = stack.size() - 1;
// while (!stack.isEmpty()) {
// array[index--] = stack.pop();
// }
// return array;
// }

// public static void main(String[] args) {
// int[] asteroids = new int[]{5,10,-5};
// System.out.println(Arrays.toString(new
// Solution().asteroidCollision(asteroids)));
// }
// }

// class MinStack {
// private List<Pair> list = new ArrayList<>();
// class Pair{
// int value;
// int min;
// Pair(int val){
// this.value = val;
// }
// }

// public void push(int val) {
// Pair pair = new Pair(val);
// if (list.isEmpty()){
// pair.min = val;
// } else {
// pair.min = Math.min(val, list.getLast().min);
// }
// list.add(pair);
// }

// public void pop() {
// list.removeLast();
// }

// public int top() {
// return list.getLast().value;
// }

// public int getMin() {
// return list.getLast().min;
// }
// }

// class Solution {
// public int[] findOrder(int numCourses, int[][] prerequisites) {
// List<Integer> orders = new ArrayList<>();
// List<List<Integer>> dependencies = new ArrayList<>();
// int[] inDegree = new int[numCourses];
// fillDependenciesAndInDegree(numCourses, prerequisites, dependencies,
// inDegree);

// Stack<Integer> stack = new Stack<>();
// for (int i = 0; i < inDegree.length; i++){
// if (inDegree[i] == 0){
// stack.push(i);
// }
// }

// while(!stack.isEmpty()){
// int current = stack.pop();
// if (inDegree[current] == 0){
// orders.add(current);
// }
// for (int dependent : dependencies.get(current)){
// inDegree[dependent] -= 1;
// if (inDegree[dependent] == 0){
// stack.push(dependent);
// }
// }
// }

// if (orders.size() == numCourses){
// int[] result = new int[numCourses];
// for (int i = 0; i < result.length; i++){
// result[i] = orders.get(i);
// }
// return result;
// }
// int[] result = new int[0];
// return result;
// }

// private void fillDependenciesAndInDegree(int numCourses, int[][]
// prerequisites, List<List<Integer>> dependencies, int[] inDegree){
// for (int i = 0; i < numCourses; i++){
// dependencies.add(new ArrayList<>());
// }
// for (int[] prerequisite : prerequisites){
// List<Integer> list = dependencies.get(prerequisite[1]);
// list.add(prerequisite[0]);
// inDegree[prerequisite[0]] += 1;
// }
// }

// public static void main(String[] args) {
// int[][] prerequisites = new int[][]{{0,1},{2,1}};
// System.out.println(Arrays.toString(new Solution().findOrder(3,
// prerequisites)));
// }
// }

// class Solution {
// public List<String> summaryRanges(int[] nums) {
// List<String> result = new ArrayList<>();
// int start = 0;
// while (start < nums.length){
// int end = start + 1;
// StringBuilder sb = new StringBuilder();
// while(end < nums.length && nums[end] == nums[end - 1] + 1){
// end++;
// }
// if (start == (end - 1)){
// sb.append(nums[start]);
// result.add(sb.toString());
// } else {
// sb.append(nums[start]);
// sb.append("->");
// sb.append(nums[end - 1]);
// result.add(sb.toString());
// }
// start = end;
// }
// return result;
// }

// public static void main(String[] args) {
// int[] nums = new int[]{0,1,2,4,5,7};
// System.out.println(new Solution().summaryRanges(nums));
// }
// }

// class Solution {
// public boolean canFinish(int numCourses, int[][] prerequisites) {
// if (prerequisites.length == 0){
// return true;
// }

// int courses = 0;
// Map<Integer,List<Integer>> dependencies = new HashMap<>();
// int[] inDegree = new int[numCourses];
// addToAdjMapAndInDegree(dependencies, prerequisites, numCourses, inDegree);

// Queue<Integer> queue = new LinkedList<>();
// for (int i = 0; i < numCourses; i++){
// if (inDegree[i] == 0){
// queue.add(i);
// }
// }

// while (!queue.isEmpty()){
// int current = queue.remove();
// courses++;
// for (int neighbor : dependencies.get(current)){
// inDegree[neighbor] -= 1;
// if (inDegree[neighbor] == 0){
// queue.add(neighbor);
// }
// }
// }
// return courses == numCourses;
// }

// private void addToAdjMapAndInDegree(Map<Integer,List<Integer>> map, int[][]
// prerequisites, int numCourses, int[] inDegree){
// for (int i = 0; i < numCourses; i++){
// map.put(i, new ArrayList<>());
// }
// for (int[] prerequisite : prerequisites){
// List<Integer> list= map.get(prerequisite[1]);
// list.add(prerequisite[0]);
// inDegree[prerequisite[0]] += 1;
// }
// }
// }

// //Definition for a binary tree node.
// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode() {}
// TreeNode(int val) { this.val = val; }
// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// class Solution {
// public List<String> binaryTreePaths(TreeNode root) {
// List<String> result = new ArrayList<>();
// if (root == null){
// return result;
// }
// buildStrings(root, "", result);
// return result;
// }

// private void buildStrings(TreeNode current, String str, List<String> result){
// str += current.val;
// if (current.left == null && current.right == null){
// result.add(str);
// return;
// }
// if (current.left != null){
// buildStrings(current.left, str + "->", result);
// }
// if (current.right != null){
// buildStrings(current.right, str + "->", result);
// }
// }
// }

// class Solution {
// public List<String> binaryTreePaths(TreeNode root) {
// List<String> result = new ArrayList<>();
// if (root == null){
// return result;
// }
// return dfs(root);
// }

// private List<String> dfs(TreeNode root){
// List<String> result = new ArrayList<>();
// Stack<TreeNode> stack = new Stack<>();
// stack.add(root);
// while(!stack.isEmpty()){
// StringBuilder sb = new StringBuilder();
// TreeNode current = stack.pop();
// sb.append(current.val);
// while(current.left != null && current.right != null){
// if (current.left != null){
// stack.add(current.left);
// sb.append("->");
// }
// if (current.right != null){
// stack.add(current.right);
// sb.append("->");
// }
// }
// result.add(sb.toString());
// }
// return result;
// }
// }

// class Solution {
// public List<List<String>> groupAnagrams(String[] strs) {
// Map<String, List<String>> map = new HashMap<>();
// List<List<String>> result = new ArrayList<>();

// for (String str : strs){
// String key = toKey(str);
// if (!map.containsKey(key)){
// List<String> list = new ArrayList<>();
// list.add(str);
// map.put(key, list);
// } else {
// List<String> list = map.get(key);
// list.add(str);
// }
// }

// for (List<String> list : map.values()){
// System.out.println(list);
// result.add(list);
// }
// return result;
// }

// private String toKey(String str){
// char[] letters = str.toCharArray();
// StringBuilder sb = new StringBuilder();
// for (char letter : letters){
// sb.append(letter);
// }
// return sb.toString();
// }

// public static void main(String[] args) {
// String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
// System.out.println(new Solution().groupAnagrams(strs));
// }
// }

// class MyStack {
// private Queue<Integer> q1 = new LinkedList<>();
// private Queue<Integer> q2 = new LinkedList<>();

// public MyStack() {

// }

// public void push(int x) {
// q1.add(x);
// }

// public int pop() {
// while(q1.size() > 1){
// int num = q1.remove();
// q2.add(num);
// }
// int pop = q1.remove();
// q1 = q2;
// System.out.println(q1);
// return pop;
// }

// public int top() {
// while(q1.size() > 1){
// int num = q1.remove();
// q2.add(num);
// }
// int top = q1.remove();
// q2.add(top);
// q1 = q2;
// System.out.println(q1);
// return top;
// }

// public boolean empty() {
// return q1.size() == 0;
// }

// public static void main(String[] args) {
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.push(3);
// System.out.println(myStack.pop());
// System.out.println(myStack.top());
// }
// }

// class Solution {
// // split("ab,c", ',') -> ["ab", "c"]
// // split("1::2:3", ':') -> ["1", "", "2", "3"]
// public List<String> split(String str, char delimiter) {
// List<String> result = new ArrayList<>();
// int index = 0;
// while (index < str.length()){
// StringBuilder sb = new StringBuilder();
// while (index < str.length() && str.charAt(index) != delimiter){
// sb.append(str.charAt(index));
// index++;
// }
// result.add(sb.toString());
// index++;
// }
// return result;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().split("1::2:3", '?'));
// }

// }

// class Solution {
// public int longestConsecutive(int[] nums) {
// if (nums.length == 0 || nums.length == 1){
// return nums.length;
// }

// Set<Integer> set = new HashSet<>();
// for (int num : nums){
// set.add(num);
// }
// int max = 0;
// Set<Integer> visited = new HashSet<>();
// for (int num : set){
// if (!visited.contains(num)){
// int sequence = dfs(set, num, visited);
// max = Math.max(max, sequence);
// }
// }
// return max;
// }

// private int dfs(Set<Integer> set, int n, Set<Integer> visited){
// Stack<Integer> stack = new Stack<>();
// stack.add(n);
// int sequence = 0;
// while (!stack.isEmpty()){
// int current = stack.pop();
// sequence++;
// int a = current + 1;
// int b = current - 1;
// if (set.contains(a) && !visited.contains(a)){
// stack.add(a);
// visited.add(a);
// }
// if (set.contains(b) && !visited.contains(b)){
// stack.add(b);
// visited.add(b);
// }
// }
// return sequence;
// }

// public static void main(String[] args) {
// int[] nums = new int[]{0,1,1,2};
// System.out.println(new Solution().longestConsecutive(nums));
// }
// }

// class Solution {
// public int minCostClimbingStairs(int[] cost) {
// Map<Integer, Integer> map = new HashMap<>();
// int a = minCostClimbingStairs(cost, 0, map);
// int b = minCostClimbingStairs(cost, 1, map);
// return Math.min(a, b);
// }

// private int minCostClimbingStairs(int[] cost, int node, Map<Integer, Integer>
// map) {
// if (node >= cost.length){
// return 0;
// }
// if (map.containsKey(node)){
// return map.get(node);
// }
// int c = cost[node];
// int oneStep = minCostClimbingStairs(cost, node + 1, map);
// int twoSteps = minCostClimbingStairs(cost, node + 2, map);
// c += Math.min(oneStep, twoSteps);
// map.put(node, c);
// return c;
// }
// }

// // Definition for a binary tree node.
// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode() {}
// TreeNode(int val) { this.val = val; }
// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// class Solution {
// public List<List<Integer>> levelOrder(TreeNode root) {
// List<List<Integer>> result = new ArrayList<>();
// if (root == null){
// return result;
// }
// Queue<TreeNode> queue = new LinkedList<>();
// queue.add(root);
// while(!queue.isEmpty()){
// List<Integer> list = new ArrayList<>();
// int size = queue.size();
// for (int i = 0; i < size; i++){
// TreeNode current = queue.remove();
// if (current.left != null){
// queue.add(current.left);
// }
// if (current.right != null){
// queue.add(current.right);
// }
// list.add(current.val);
// }
// result.add(list);
// }
// return result;
// }
// }

// class Solution {
// public int[] productExceptSelf(int[] nums) {
// int[] leftProducts = new int[nums.length];
// int[] rightProducts = new int[nums.length];
// int left = 1;
// int right = 1;
// for (int i = 0; i < leftProducts.length; i++){
// leftProducts[i] = left;
// left *= nums[i];
// }
// for (int i = rightProducts.length - 1; i >= 0; i--){
// rightProducts[i] = right;
// right *= nums[i];
// }
// for (int i = 0; i < nums.length; i++){
// nums[i] = leftProducts[i] * rightProducts[i];
// }
// return nums;
// }

// public static void main(String[] args) {
// int[] nums = new int[]{1, 2, 3, 4};
// System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
// }
// }

// class Solution {
// public String mergeAlternately(String word1, String word2) {
// int index1 = 0;
// int index2 = 0;
// StringBuilder sb = new StringBuilder();
// while (index1 < word1.length() && index2 < word2.length()){
// sb.append(word1.charAt(index1));
// sb.append(word2.charAt(index2));
// index1++;
// index2++;
// }
// if (index1 == word1.length()){
// sb.append(addString(word2, index2));
// }
// if (index2 == word2.length()){
// sb.append(addString(word1, index1));
// }
// return sb.toString();
// }

// private String addString(String word, int num){
// StringBuilder sb = new StringBuilder();
// for (int i = num; i < word.length(); i++){
// sb.append(word.charAt(i));
// }
// return sb.toString();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().mergeAlternately("ab", "pqrs"));
// }
// }

// class Solution {
// public String gcdOfStrings(String str1, String str2) {
// int l1 = str1.length();
// int l2 = str2.length();
// String result = "";
// StringBuilder sb = new StringBuilder();
// int index = 0;
// while (index < l2 && index < l1){
// if (str1.charAt(index) != str2.charAt(index)){
// return result;
// }
// sb.append(str2.charAt(index));
// int l = sb.length();
// if (l1 % l == 0 && l2 % l == 0){
// String s = sb.toString();
// String s2 = repeatString(s, l2 / l);
// if (s2.equals(str2)){
// String s1 = repeatString(s, l1 / l);
// if (s1.equals(str1)){
// result = s;
// }
// }
// }
// index++;
// }
// return result;
// }

// private String repeatString(String str, int num){
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < num; i++){
// sb.append(str);
// }
// return sb.toString();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
// "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
// }
// }

// Definition for a binary tree node.
// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode() {}
// TreeNode(int val) { this.val = val; }
// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// class Solution {
// public int pathSum(TreeNode root, int targetSum) {
// int pathSum = 0;

// return pathSum;
// }

// }

// class Solution {
// class Pair {
// String node;
// double weight;
// public Pair(String node, double weight){
// this.node = node;
// this.weight = weight;
// }
// }

// public double[] calcEquation(List<List<String>> equations, double[] values,
// List<List<String>> queries) {
// addToAdjMap(equations, values);
// List<Double> result = new ArrayList<>();
// for (int i = 0; i < queries.size(); i++){
// String start = queries.get(i).get(0);
// String target = queries.get(i).get(1);
// if (!adjMap.containsKey(start) || !adjMap.containsKey(target)){
// result.add(-1.0);
// } else if (start.equals(target)){
// result.add(1.0);
// } else {
// result.add(bfs(start, target));
// }
// }
// double[] calcEquation = new double[result.size()];
// for (int j = 0; j < result.size(); j++){
// calcEquation[j] = result.get(j);
// }
// return calcEquation;
// }

// private double bfs(String start, String target){
// Queue<Pair> queue = new LinkedList<>();
// Set<String> visited = new HashSet<>();
// queue.add(new Pair(start, 1.0));
// while (!queue.isEmpty()){
// Pair current = queue.poll();
// if (current.node.equals(target)){
// return current.weight;
// }
// for (Pair neighbor : neighbors(current)){
// if (!visited.contains(neighbor.node)){
// visited.add(neighbor.node);
// queue.add(new Pair(neighbor.node, current.weight * neighbor.weight));
// }
// }
// }
// return -1.0;
// }

// private List<Pair> neighbors(Pair current){
// List<Pair> neighbors = new ArrayList<>();
// neighbors.addAll(adjMap.get(current.node));
// return neighbors;
// }

// private Map<String, List<Pair>> adjMap = new HashMap<>();

// private void addToAdjMap(List<List<String>> equations, double[] values){
// for (int i = 0; i < values.length; i++){
// String num = equations.get(i).get(0);
// String denum = equations.get(i).get(1);
// Pair pair1 = new Pair(denum, values[i]);
// Pair pair2 = new Pair(num, 1 / values[i]);
// if (!adjMap.containsKey(num)){
// List<Pair> list = new ArrayList<>();
// list.add(pair1);
// adjMap.put(num, list);
// } else {
// adjMap.get(num).add(pair1);
// }
// if (!adjMap.containsKey(denum)){
// List<Pair> list = new ArrayList<>();
// list.add(pair2);
// adjMap.put(denum, list);
// } else {
// adjMap.get(denum).add(pair2);
// }
// }
// }
// }

// // Definition for singly-linked list.
// class ListNode {
// int val;
// ListNode next;
// ListNode() {}
// ListNode(int val) { this.val = val; }
// ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

// class Solution {
// public ListNode reverseList(ListNode head) {
// ListNode previous = null;
// ListNode current = head;
// while (current != null){
// ListNode next = current.next;
// current.next = previous;
// previous = current;
// current = next;
// }
// return previous;
// }
// }

// class Solution {
// public int pivotIndex(int[] nums) {
// int left = 0;
// int right = 0;
// for (int num : nums){
// right += num;
// }
// for (int index = 0; index < nums.length; index++){
// right -= nums[index];
// if (left == right){
// return index;
// }
// left += nums[index];
// }
// return -1;
// }
// }

// class Backpack {
// int weight;
// String color;
// // public Backpack(int w, String c) {
// // weight = w;
// // color = c;
// // System.out.println("creating backpack");
// // }
// // public Backpack(int w) {
// // weight = w;
// // color = "red";
// // System.out.println("creating backpack");
// // }
// }

// class Solution {
// public static void main(String[] args) {
// // Backpack backpack1 = new Backpack(100, "red");
// // Backpack backpack2 = new Backpack(100);
// Backpack backpack = new Backpack();
// }
// }

// class Solution {
// class Trie{
// public void insert(String s){
// Node current = root;
// for (int i = 0; i < s.length(); i++){
// char letter = s.charAt(i);
// if (!current.children.containsKey(letter)){
// Node child = new Node();
// child.letter = letter;
// current.children.put(letter, child);
// }
// current = current.children.get(letter);
// }
// current.isWord = true;
// }

// public List<String> wordsWithPrefix(String prefix, int limit){
// List<String> list = new ArrayList<>();
// Node current = root;
// for (int i = 0; i < prefix.length(); i++){
// char letter = prefix.charAt(i);
// if (!current.children.containsKey(letter)){
// return list;
// }
// current = current.children.get(letter);
// }
// return list;
// }

// public void gatherWords(String prefix, Node current, List<String> result, int
// limit){
// if (result.size() == limit){
// return;
// }
// if (current.isWord){
// result.add(prefix);
// }
// for (char letter : current.children.keySet()){
// gatherWords(prefix + letter, current.children.get(letter), result, limit);
// }
// }
// }

// class Node{
// char letter;
// TreeMap<Character, Node> children = new TreeMap<>();
// boolean isWord = false;
// }

// private Node root = new Node();

// public List<List<String>> suggestedProducts(String[] products, String
// searchWord) {
// Trie trie = new Trie();
// for (String product : products){
// trie.insert(product);
// }

// List<List<String>> result = new ArrayList<>();
// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < searchWord.length(); i++){
// sb.append(searchWord.charAt(i));
// String prefix = sb.toString();
// result.add(trie.wordsWithPrefix(prefix, 3));
// }
// return result;
// }
// }

// class Trie {
// class Node{
// char letter;
// Map<Character, Node> children = new HashMap<>();
// boolean isWord = false;
// }

// private Node root = new Node();

// public void print() {
// printHelper("", root);
// }

// private void printHelper(String letters, Node current){
// if (current.isWord){
// System.out.println(letters);
// }
// for (char letter : current.children.keySet()){
// printHelper(letters + letter, current.children.get(letter));
// }
// }

// public void insert(String word) {
// Node current = root;
// for (int i = 0; i < word.length(); i++){
// char c = word.charAt(i);
// if (!current.children.containsKey(c)){
// Node child = new Node();
// child.letter = c;
// current.children.put(c, child);
// current = child;
// } else {
// current = current.children.get(c);
// }
// }
// current.isWord = true;
// }

// public static void main(String[] args) {
// Trie trie = new Trie();
// trie.insert("hello");
// trie.insert("hi");
// trie.insert("cat");
// trie.insert("car");
// trie.insert("foo");
// trie.insert("cartoon");
// System.out.println(trie.startsWith("cart"));
// System.out.println(trie.search("cart"));
// trie.print();
// }

// public boolean search(String word) {
// Node current = root;
// for (int i = 0; i < word.length(); i++){
// char letter = word.charAt(i);
// if (!current.children.containsKey(letter)){
// return false;
// }
// current = current.children.get(letter);
// }
// if(current.isWord){
// return true;
// }
// return false;
// }

// public boolean startsWith(String prefix) {
// Node current = root;
// for (int i = 0; i < prefix.length(); i++){
// char letter = prefix.charAt(i);
// if (!current.children.containsKey(letter)){
// return false;
// }
// current = current.children.get(letter);
// }
// return true;
// }
// }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// public class App {
// private String password = "";

// public void setPassword(String newPw){
// password = newPw;
// return;
// }

// public int authorize(int hash){
// if (hash == h(password)){
// return 1;
// }
// for (int i = 0; i < 256; i++){
// if (hash == h(password + (char)i)){
// return 1;
// }
// }
// return 0;
// }

// public long h(String str){
// long hash = 0;
// for (int i = 0; i < str.length() - 1; i++){
// int s = str.charAt(i);
// hash += (s * Math.pow(131, str.length() - i - 1));
// }
// hash += str.charAt(str.length() - 1);
// hash %= (Math.pow(10, 9) + 7);
// return hash;
// }

// public static void main(String[] args) {
// App app = new App();
// app.setPassword("cAr1");
// System.out.println(app.authorize(223691457));
// System.out.println(app.authorize(303580761));
// System.out.println(app.authorize(100));
// app.setPassword("d");
// System.out.println(app.authorize(100));
// }

// }
// class Solution {
// private static final Map<Integer, String> map = Map.of(
// 2, "abc",
// 3, "def",
// 4, "ghi",
// 5, "jkl",
// 6, "mno",
// 7, "pqrs",
// 8, "tuv",
// 9, "wxyz"
// );

// public List<String> letterCombinations(String digits) {
// List<String> result = new ArrayList<>();
// combination(digits, "", 0, result);
// return result;
// }

// private void combination(String digits, String current, int index,
// List<String> result){
// if (current.length() == digits.length()){
// result.add(current);
// return;
// }
// String letters = map.get(Integer.valueOf(digits.charAt(index)));
// for (int i = 0; i < letters.length(); i++){
// combination(digits, current + letters.charAt(i), index + 1, result);
// }
// }
// }

// class Solution {
// public int equalPairs(int[][] grid) {
// int result = 0;
// Map<String, Integer> map = new HashMap<>();
// for (int y = 0; y < grid.length; y++){
// String row = row(grid, y);
// if (map.containsKey(row)){
// map.put(row, map.get(row) + 1);
// } else {
// map.put(row, 1);
// }
// }

// for (int x = 0; x < grid.length; x++){
// String column = column(grid, x);
// if (map.containsKey(column)){
// result += map.get(column);
// }

// }
// return result;
// }

// private String row(int[][] grid, int y){
// StringBuilder row = new StringBuilder();
// for (int x = 0; x < grid.length; x++){
// row.append(grid[y][x]);
// row.append(',');
// }
// return row.toString();
// }

// private String column(int[][] grid, int x){
// StringBuilder column = new StringBuilder();
// for (int y = 0; y < grid.length; y++){
// column.append(grid[y][x]);
// column.append(',');

// }
// return column.toString();
// }
// }

// class Solution {
// public String removeStars(String s) {
// Stack<Character> stack = new Stack<>();
// int index = 0;
// while (index < s.length()){
// char c = s.charAt(index);
// if (c == '*'){
// stack.pop();
// } else {
// stack.add(c);
// }
// index++;
// }
// StringBuilder sb = new StringBuilder();
// while (!stack.isEmpty()){
// char c = stack.pop();
// sb.append(c);
// }
// return sb.reverse().toString();
// }

// public static void main(String[] args) {
// System.out.println(new Solution().removeStars("leet**cod*e"));
// }
// }

// Definition for a binary tree node.
// public class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode() {}
// TreeNode(int val) { this.val = val; }
// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// class Solution {
// public int maxLevelSum(TreeNode root) {
// Map<Integer, Integer> map = new HashMap<>();
// fillMap(root, 1, map);
// int max = map.get(1);
// int index = 1;
// for (int i = 2; i <= map.size(); i++ ){
// if (max < map.get(i)){
// max = map.get(i);
// index = i;
// }
// }
// return index;
// }

// public void fillMap(TreeNode root, int level, Map<Integer, Integer> map){
// if (root == null){
// return;
// }
// if (map.containsKey(level)){
// map.put(level, root.val + map.get(level));
// } else {
// map.put(level, root.val);
// }
// fillMap(root.left, level + 1, map);
// fillMap(root.right, level + 1, map);
// }
// }

// class Solution {
// public int minFlips(int a, int b, int c) {
// int flips = 0;
// while (c > 0 || a > 0 || b > 0){
// if (isOne(c)){
// if (!isOne(a) && !isOne(b)){
// flips++;
// }
// } else {
// if (isOne(a) && isOne(b)){
// flips += 2;
// } else if (isOne(a) || isOne(b)){
// flips++;
// }
// }
// a >>= 1;
// b >>= 1;
// c >>= 1;
// }
// return flips;
// }

// private boolean isOne(int n){
// return (n & 1) == 1;
// }
// }

// class Solution {
// public int[] countBits(int n) {
// List<Integer> bits = new ArrayList<>();
// while(n >= 0){
// bits.add(hammingWeight(n));
// n--;
// }
// int[] result = new int[bits.size()];
// for(int i = 0; i < bits.size(); i++){
// result[i] = bits.get(bits.size() - i - 1);
// }
// return result;
// }

// private int hammingWeight(int n){
// int count = 0;
// while (n > 0){
// n &= (n - 1);
// count++;
// }
// return count;
// }
// }

// class Solution {
// public int singleNumber(int[] nums) {
// int n = 0;
// for (int num : nums){
// n ^= num;
// }
// return n;
// }
// }

// class Solution {
// public int hammingWeight(int n) {
// int count = 0;
// while (n > 0){
// n = n & (n - 1);
// count++;
// }
// return count;
// }
// }

// class Solution {
// public int findKthLargest(int[] nums, int k) {
// PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
// if (x == y) {
// return 0;
// }
// if (x < y) {
// return -1;
// } else {
// return +1;
// }
// });
// for (int i = 0; i < nums.length; i++) {
// if (pq.size() < k) {
// pq.add(nums[i]);
// } else if (nums[i] > pq.peek()) {
// pq.remove();
// pq.add(nums[i]);
// }
// }
// return pq.peek();
// }
// }

// interface List {
// int size();
// int get(int index);
// void add(int num);
// }

// class ArrayList implements List {

// private int[] buffer = new int[2];
// private int size = 0;

// @Override
// public int size() {
// return size;
// }

// @Override
// public int get(int index) {
// return buffer[index];
// }

// @Override
// public void add(int num) {
// if (size == buffer.length) {
// grow();
// }
// buffer[size] = num;
// size++;
// }

// private void grow() {
// int[] newBuffer = new int[buffer.length * 2];
// for (int i = 0; i < buffer.length; i++) {
// newBuffer[i] = buffer[i];
// }
// buffer = newBuffer;
// }
// }

// class LinkedList implements List {

// class Node {
// int value;
// Node next;
// }

// private Node head = new Node();
// private Node tail = head;
// private int size = 0;

// @Override
// public int size() {
// return size;
// }

// @Override
// public int get(int index) {
// Node current = head;
// while (index >= 0) {
// current = current.next;
// index--;
// }
// return current.value;
// }

// @Override
// public void add(int num) {
// Node newNode = new Node();
// newNode.value = num;
// tail.next = newNode;
// tail = newNode;
// size++;
// }
// }

// class Solution {
// public static void main(String[] args) {
// List list = new LinkedList();
// list.add(1);
// list.add(2);
// list.add(3);
// list.add(4);
// list.add(5);

// System.out.println(sumList(list));
// }

// private static int sumList(List list) {
// int sum = 0;
// for (int i = 0; i < list.size(); i++) {
// sum += list.get(i);
// }
// return sum;
// }
// }

// class Solution {
// public int findCircleNum(int[][] isConnected) {
// Set<Integer> visited = new HashSet<>();
// int result = 0;
// for (int i = 0; i < isConnected.length; i++){
// if (!visited.contains(i)){
// result++;
// eraseProvinces(isConnected, i, visited);
// }
// }
// return result;
// }

// private void eraseProvinces(int[][] isConnected, int node, Set<Integer>
// visited){
// Stack<Integer> stack = new Stack<>();
// stack.push(node);
// while(!stack.empty()){
// int current = stack.pop();
// visited.add(current);
// for(int neighbor : neighbors(isConnected, current, visited)){
// stack.push(neighbor);
// }
// }
// }
// //

// private List<Integer> neighbors(int[][] isConnected, int node, Set<Integer>
// visited){
// List<Integer> neighbors = new ArrayList<>();
// for (int neighbor = 0; neighbor < isConnected[node].length; neighbor++){
// if (!visited.contains(node) && node != neighbor &&
// isConnected[node][neighbor] == 1){
// neighbors.add(neighbor);
// }
// }
// return neighbors;
// }
// }

// class Solution {
// class Location{
// int x;
// int y;
// public Location(int x, int y){
// this.x = x;
// this.y = y;
// }
// }

// public int numIslands(char[][] grid) {
// int islands = 0;
// for (int y = 0; y < grid.length; y++){
// for (int x = 0; x < grid[y].length; x++){
// if (grid[y][x] == '1'){
// islands++;
// Location location = new Location(x, y);
// eraseIsland(grid, location);
// }
// }
// }
// return islands;
// }

// private void eraseIsland(char[][] grid, Location location){
// Stack<Location> stack = new Stack<>();
// stack.push(location);

// while(!stack.empty()){
// Location current = stack.pop();
// grid[current.y][current.x] = '0';
// for (Location neighbor : neighbors(grid, current)) {
// stack.push(neighbor);
// }
// }
// }

// private List<Location> neighbors(char[][] grid, Location location){
// List<Location> list = new ArrayList<>();
// Location left = new Location(location.x - 1, location.y);
// if (isInsideGrid(grid, left) && grid[left.y][left.x] == '1'){
// list.add(left);
// }
// Location right = new Location(location.x + 1, location.y);
// if (isInsideGrid(grid, right) && grid[right.y][right.x] == '1'){
// list.add(right);
// }
// Location up = new Location(location.x, location.y - 1);
// if (isInsideGrid(grid, up) && grid[up.y][up.x] == '1'){
// list.add(up);
// }
// Location down = new Location(location.x, location.y + 1);
// if (isInsideGrid(grid, down) && grid[down.y][down.x] == '1'){
// list.add(down);
// }
// return list;
// }

// private boolean isInsideGrid(char[][] grid, Location location){
// int height = grid.length;
// int width = grid[0].length;
// if (location.x >= 0 && location.x < width){
// if (location.y >= 0 && location.y < height){
// return true;
// }
// }
// return false;
// }
// }

// class Solution {
// public int minSubArrayLen(int target, int[] nums) {

// int minLength = nums.length + 1;
// int left = 0;
// int right = 0;
// int length = 1;
// int sum = nums[left];
// while (left <= right && right < nums.length){
// if (sum >= target){
// if (length < minLength){
// minLength = length;
// }
// sum -= nums[left];
// length--;
// left++;
// } else{
// length++;
// right++;
// if (right < nums.length){
// sum += nums[right];
// }
// }
// }
// if (minLength > nums.length){
// return 0;
// } else {
// return minLength;
// }
// }
// public static void main(String[] args) {
// int target = 7;
// int[] nums = new int[] {2,3,1,2,4,3};
// System.out.println(new Solution().minSubArrayLen(target, nums));
// }
// }

// class Solution {
// private Map<String, String> letters = Map.of(
// "2", "abc",
// "3", "def",
// "4", "ghi",
// "5", "jkl",
// "6", "mno",
// "7", "pqrs",
// "8", "tuv",
// "9", "wxyz");

// public List<String> letterCombinations(String digits) {
// List<String> result = new ArrayList<>();
// if (digits.length() == 0){
// return result;
// }

// }

// private String combination(String digits, int index, String curStr){
// if (curStr.length() == digits.length()){
// letters.get(digits.charAt(index));
// }
// }
// }

// class Solution {
// public int maxVowels(String s, int k) {
// int count = 0;
// int index = 0;
// while (index < k){
// Character c = s.charAt(index);
// if (isVowel(c)){
// count++;
// }
// index++;
// }
// int max = 0;
// int left = 0;
// while (left <= s.length() - k){
// int right = left + k;
// Character c1 = s.charAt(left);
// Character c2 = s.charAt(right);
// if (isVowel(c1)){
// count--;
// }
// if (isVowel(c2)){
// count++;
// }
// if (max < count){
// max = count;
// }
// left++;
// }
// return max;
// }

// public boolean isVowel(Character c){
// char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
// for (Character vowel : vowels){
// if (c == vowel){
// return true;
// }
// }
// return false;
// }
// }

// class Solution {
// public int findKthLargest(int[] nums, int k) {
// int index = 0;
// Set<Integer> indexesToIgnore = new HashSet<>();
// while(k > 0){
// index = indexWithLargestElement(nums, indexesToIgnore);
// indexesToIgnore.add(index);
// k--;
// }
// return nums[index];
// }

// private int indexWithLargestElement(int[] nums, Set<Integer>
// indexesToIgnore){
// int largestIndex = 0;
// while (indexesToIgnore.contains(largestIndex)){
// largestIndex++;
// }
// for (int i = 0; i < nums.length; i++){
// if (!indexesToIgnore.contains(i) && nums[largestIndex] < nums[i]){
// largestIndex = i;
// }
// }
// return largestIndex;
// }
// }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Solution {
// public boolean isSameTree(TreeNode p, TreeNode q) {
// if (p == null && q == null){
// return true;
// }
// if (p == null || q == null){
// return false;
// }
// if (p.val == q.val){
// if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
// return true;
// }
// }
// return false;
// }
// }

// class Solution {
// public int maxProfit(int[] prices) {
// int min = prices[0];
// int index = 0;
// int profit = 0;
// for (int i = 1; i < prices.length; i++){
// if (min > prices[i]){
// min = prices[i];
// index = i;
// }
// }

// if (min == prices[prices.length - 1]){
// return profit;
// }
// int max = 0;
// for (int j = index + 1; j < prices.length; j++){
// if (prices[j] > max){
// max = prices[j];
// }
// }
// profit = max - min;
// return profit;
// }
// }

// class RecentCounter {
// private Queue<Integer> timeStamps = new LinkedList<>();

// public RecentCounter() {

// }

// public int ping(int t) {
// timeStamps.add(t);
// int limit = t - 3000;
// while(timeStamps.peek() <= limit){
// timeStamps.remove();
// }
// return timeStamps.size();
// }
// }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

// /**
// * Forward declaration of guess API.
// * @param num your guess
// * @return -1 if num is higher than the picked number
// * 1 if num is lower than the picked number
// * otherwise return 0
// * int guess(int num);
// */

// public class Solution extends GuessGame {
// public int guessNumber(int n) {
// int left = 1;
// int right = n;
// int pick = 0;
// while(left <= right){
// int middle = left + (right - left)/2;
// int result = guess(middle);
// if (result == -1){
// right = middle - 1;
// } else if (result == 1){
// left = middle + 1;
// } else {
// return middle;
// }
// }
// return -1;
// }
// }

// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;
// TreeNode() {}
// TreeNode(int val) { this.val = val; }
// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// class Solution {
// public static void main(String[] args) {
// TreeNode left1 = new TreeNode(5);
// TreeNode right1 = new TreeNode(1);
// TreeNode root1 = new TreeNode(3, left1, right1);
// TreeNode left2 = new TreeNode(6);
// TreeNode right2 = new TreeNode(1);
// TreeNode root2 = new TreeNode(2, left2, right2);
// System.out.println(new Solution().leafSimilar(root1, root2));
// }

// public boolean leafSimilar(TreeNode root1, TreeNode root2) {
// List<Integer> leaves1 = leaves(root1);
// List<Integer> leaves2 = leaves(root2);
// System.out.println(leaves1);
// System.out.println(leaves2);
// return leaves1.equals(leaves2);
// }

// public List<Integer> leaves(TreeNode root){
// List<Integer> leaves = new ArrayList<>();
// if(root == null) return leaves;
// if (root.left == null && root.right == null) {
// leaves.add(root.val);
// }
// if (root.left != null) {
// List<Integer> leftLeaves = leaves(root.left);
// leaves.addAll(leftLeaves);
// }
// if (root.right != null) {
// List<Integer> rightLeaves = leaves(root.right);
// leaves.addAll(rightLeaves);
// }
// return leaves;
// }
// }

// Definition for singly-linked list.
// public class ListNode {
// int val;
// ListNode next;
// ListNode() {}
// ListNode(int val) { this.val = val; }
// ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

// class Solution {
// public ListNode deleteMiddle(ListNode head) {
// int size = 0;
// ListNode current = head;
// while(current != null){
// size++;
// current = current.next;
// }
// if (size == 1){
// return null;
// }
// int middle = size / 2;
// ListNode left = head;
// for (int i = 0; i < middle - 1; i++){
// left = left.next;
// }
// ListNode right = left.next.next;
// left.next = right;
// return head;
// }
// }

// class Solution {
// public int compress(char[] chars) {
// int insert = 0;
// int index = 0;
// while (index < chars.length){
// int letterCount = 0;
// char c = chars[index];
// while(index < chars.length && chars[index] == c){
// letterCount++;
// index++;
// }
// chars[insert++] = c;
// if (letterCount > 1){
// String countString = String.valueOf(letterCount);
// for (int i = 0; i < countString.length(); i++) {
// chars[insert++] = countString.charAt(i);
// }
// }
// }
// return insert;
// }
// }

// class Solution {

// public static void main(String[] args) {
// char[][] maze = new char[][]{
// {'+','+','.','+'},
// {'.','.','.','+'},
// {'+','+','+','.'},
// };
// int[] entrance = new int[]{1, 2};
// new Solution().nearestExit(maze, entrance);
// }

// class Location{
// int x;
// int y;
// public Location(int x, int y){
// this.x = x;
// this.y = y;
// }
// }

// private String toKey(Location l) {
// return String.format("%d,%d", l.x, l.y);
// }
// public int nearestExit(char[][] maze, int[] entrance) {
// int steps = 0;
// Location location = new Location(entrance[1], entrance[0]);
// Queue<Location> queue = new LinkedList<>();
// queue.add(location);
// HashSet<String> visited = new HashSet<>();
// while(!queue.isEmpty()){
// int nodesInLevel = queue.size();
// while(nodesInLevel > 0){
// Location current = queue.remove();
// visited.add(toKey(current));
// if (current != location && isExit(maze, current)){
// return steps;
// }
// for (Location neighbor : neighbors(maze, current)){
// if (visited.contains(toKey(neighbor))) {
// continue;
// }
// queue.add(neighbor);
// }
// nodesInLevel--;
// }
// steps++;
// }
// return -1;
// }

// private List<Location> neighbors(char[][] maze, Location location){
// List<Location> list = new ArrayList<>();
// Location left = new Location(location.x - 1, location.y);
// if (isInsideGrid(maze, left) && maze[left.y][left.x] == '.'){
// list.add(left);
// }
// Location right = new Location(location.x + 1, location.y);
// if (isInsideGrid(maze, right) && maze[right.y][right.x] == '.'){
// list.add(right);
// }
// Location up = new Location(location.x, location.y - 1);
// if (isInsideGrid(maze, up) && maze[up.y][up.x] == '.'){
// list.add(up);
// }
// Location down = new Location(location.x, location.y + 1);
// if (isInsideGrid(maze, down) && maze[down.y][down.x] == '.'){
// list.add(down);
// }
// return list;
// }

// private boolean isInsideGrid(char[][] maze, Location location){
// int height = maze.length;
// int width = maze[0].length;
// if (location.x >= 0 && location.x < width){
// if (location.y >= 0 && location.y < height){
// return true;
// }
// }
// return false;
// }

// private boolean isExit(char[][] maze, Location location){
// if (location.x == 0 || location.y == 0 || location.x == maze[0].length - 1 ||
// location.y == maze.length - 1){
// return true;
// }
// return false;
// }
// }

// class ArrayList {
// private int[] buffer = new int[2];
// private int offset = 0;

// public void add(int num) {
// if (offset == buffer.length) {
// grow();
// }
// buffer[offset] = num;
// offset++;
// }

// public void remove(int index){
// for(int i = index + 1; i < offset; i++){
// buffer[i - 1] = buffer[i];
// }
// offset--;
// }

// public int get(int index) {
// return buffer[index];
// }

// public int size() {
// return offset;
// }

// private void grow() {
// int[] newBuffer = new int[buffer.length * 2];
// for (int i = 0; i < buffer.length; i++) {
// newBuffer[i] = buffer[i];
// }
// buffer = newBuffer;
// }

// public static void main(String[] args) {

// ArrayList al = new ArrayList();
// print(al);
// al.add(3);
// print(al);
// al.add(7);
// print(al);
// al.remove(0);
// print(al);
// al.add(22);
// print(al);
// al.add(55);
// print(al);
// al.add(300);
// print(al);
// al.add(5000);
// print(al);
// }

// public static void print(ArrayList al) {
// System.out.print("[");
// for (int i = 0; i < al.size(); i++) {
// System.out.print(al.get(i));
// if (i != al.size()-1) {
// System.out.print(", ");
// }
// }
// System.out.print("]\n");
// }
// }

// class Solution {
// class Location{
// int x;
// int y;
// public Location(int x, int y){
// this.x = x;
// this.y = y;
// }
// }

// public int[][] floodFill(int[][] image, int sr, int sc, int color) {
// Location location = new Location(sc, sr);
// int currentColor = image[sr][sc];
// Stack<Location> stack = new Stack<>();
// stack.push(location);
// while (!stack.empty()){
// Location current = stack.pop();
// if (image[current.y][current.x] == color) {
// continue;
// }
// image[current.y][current.x] = color;
// for (Location neighbor : neighbors(image, current, currentColor)){
// stack.push(neighbor);
// }
// }
// return image;
// }

// private List<Location> neighbors(int[][] image, Location location, int
// currentColor){
// List<Location> list = new ArrayList<>();
// Location left = new Location(location.x - 1, location.y);
// if (isInsideGrid(image, left) && image[left.y][left.x] == currentColor){
// list.add(left);
// }
// Location right = new Location(location.x + 1, location.y);
// if (isInsideGrid(image, right) && image[right.y][right.x] == currentColor){
// list.add(right);
// }
// Location up = new Location(location.x, location.y - 1);
// if (isInsideGrid(image, up) && image[up.y][up.x] == currentColor){
// list.add(up);
// }
// Location down = new Location(location.x, location.y + 1);
// if (isInsideGrid(image, down) && image[down.y][down.x] == currentColor){
// list.add(down);
// }
// return list;
// }

// private boolean isInsideGrid(int[][] image, Location location){
// int height = image.length;
// int width = image[0].length;
// if (location.x >= 0 && location.x < width){
// if (location.y >= 0 && location.y < height){
// return true;
// }
// }
// return false;
// }

// public static void main(String[] args) {
// int[][] image = new int[][]{
// {1,1,1},
// {1,1,0},
// {1,0,1},
// };
// new Solution().floodFill(image, 1,1,2);
// }
// }

// class Solution {
// class Location{
// int x;
// int y;
// public Location(int x, int y){
// this.x = x;
// this.y = y;
// }
// }

// public int numIslands(char[][] grid) {
// int islands = 0;
// for (int y = 0; y < grid.length; y++){
// for (int x = 0; x < grid[y].length; x++){
// if (grid[y][x] == '1'){
// islands++;
// Location location = new Location(x, y);
// eraseIsland(grid, location);
// }
// }
// }
// return islands;
// }

// private void eraseIsland(char[][] grid, Location location){
// Stack<Location> stack = new Stack<>();
// stack.push(location);

// while(!stack.empty()){
// Location current = stack.pop();
// grid[current.y][current.x] = '0';
// for (Location neighbor : neighbors(grid, current)) {
// stack.push(neighbor);
// }
// }
// }

// private List<Location> neighbors(char[][] grid, Location location){
// List<Location> list = new ArrayList<>();
// Location left = new Location(location.x - 1, location.y);
// if (isInsideGrid(grid, left) && grid[left.y][left.x] == '1'){
// list.add(left);
// }
// Location right = new Location(location.x + 1, location.y);
// if (isInsideGrid(grid, right) && grid[right.y][right.x] == '1'){
// list.add(right);
// }
// Location up = new Location(location.x, location.y - 1);
// if (isInsideGrid(grid, up) && grid[up.y][up.x] == '1'){
// list.add(up);
// }
// Location down = new Location(location.x, location.y + 1);
// if (isInsideGrid(grid, down) && grid[down.y][down.x] == '1'){
// list.add(down);
// }
// return list;
// }

// private boolean isInsideGrid(char[][] grid, Location location){
// int height = grid.length;
// int width = grid[0].length;
// if (location.x >= 0 && location.x < width){
// if (location.y >= 0 && location.y < height){
// return true;
// }
// }
// return false;
// }
// }

// class Solution {
// public boolean uniqueOccurrences(int[] arr) {
// Map<Integer, Integer> map = new HashMap<>();
// for (int i = 0; i < arr.length; i++){
// if (map.containsKey(arr[i])){
// int value = map.get(arr[i]);
// map.replace(arr[i], value++);
// } else {
// map.put(arr[i], 1);
// }
// }
// Set<Integer> set = new HashSet<>();
// for (int i = 0; i < map.size(); i++){
// int value = map.get(arr[i]);
// if (set.contains(value)){
// return false;
// } else {
// set.add(value);
// }
// }
// return true;
// }

// public static void main(String[] args) {
// System.out.println(new Solution().uniqueOccurrences(new int[]{1, 0}));
// }
// }

// class Solution {

// class ListNode {
// int val;
// ListNode next;
// public ListNode(int x) {
// val = x;
// next = null;
// }
// }

// public boolean hasCycle(ListNode head) {
// ListNode slow = head;
// ListNode fast = head;
// while (fast != null){
// slow = slow.next;
// fast = fast.next;
// if(fast != null){
// fast = fast.next;
// }
// if (slow == fast){
// return true;
// }
// }
// return false;
// }

// public boolean hasCycle(ListNode head) {
// Set<ListNode> set = new HashSet<>();
// ListNode current = head;
// while (current != null){
// if (set.contains(current)){
// return true;
// } else {
// set.add(current);
// }
// current = current.next;
// }
// return false;
// }

// public void printElements(ListNode head){
// ListNode current = head;
// while(current != null){
// System.out.println(current.val);
// current = current.next;
// }
// }

// public static void main( String[] args )
// {
// ListNode n1 = new ListNode(1);
// ListNode n2 = new ListNode(9);
// ListNode n3 = new ListNode(3);
// ListNode n4 = new ListNode(-1);
// ListNode n5 = new ListNode(5);

// n1.next = n2;
// n2.next = n3;
// n3.next = n4;
// n4.next = n5;
// n5.next = n2;
// new Solution().printElements(n1);
// }

// /**
// * Hello world!
// *
// */
// public class App
// // {
// public static boolean isPalindrome(String word)
// {
// int left = 0;
// int right = word.length()-1;
// while (left<right){
// if (word.charAt(left) != word.charAt(right)){
// return false;
// }
// else {
// left += 1;
// right -= 1;
// }
// }
// return true;
// }
// public static int sumSquares(int[] nums)
// {
// int sum = 0;
// for(int i=0; i<nums.length; i++){
// if (nums[i] % 2 == 0){
// sum += nums[i]*nums[i];
// }
// else {
// sum += nums[i];
// }
// }
// return sum;
// }

// public static int max(int[] nums){
// int max = 0;
// for(int i=0; i<nums.length; i++){
// if (nums[i] > max){
// max = nums[i];
// }
// }
// return max;
// }

// public static int min(int[] nums){
// int min = nums[0];
// for(int i=0; i<nums.length; i++){
// if (nums[i] < min){
// min = nums[i];
// }
// }
// return min;
// }

// // Write a program that prints the numbers from 1 to 100. However, for
// multiples of three, print "Fizz" instead of the number,
// // and for multiples of five, print "Buzz." For numbers which are multiples
// of both three and five, print "FizzBuzz."

// public static List<String> fizzBuzz(int num){
// List<String> output = new ArrayList<>();
// for(int i=1; i<=num; i++){
// if (i%3 == 0 && i%5 == 0) {
// output.add("FizzBuzz");
// } else if (i%5 == 0) {
// output.add("Buzz");
// } else if (i%3 == 0){
// output.add("Fizz");
// } else {
// output.add(String.valueOf(i));
// }
// }
// return output;
// }

// // A phrase is a palindrome if, after converting all uppercase letters into
// lowercase letters and removing all non-alphanumeric characters,
// // it reads the same forward and backward. Alphanumeric characters include
// letters and numbers.

// // class Solution {
// // public boolean isPalindrome(String s) {
// // s = s.toLowerCase();

// // int left = 0;
// // int right = s.length()-1;

// // while (left < right) {
// // if (!Character.isLetterOrDigit(s.charAt(left))){
// // left += 1;
// // continue;
// // }
// // if (!Character.isLetterOrDigit(s.charAt(right))){
// // right -= 1;
// // continue;
// // }
// // if (s.charAt(left) != s.charAt(right)) {
// // return false;
// // }
// // left += 1;
// // right -= 1;
// // }
// // return true;
// // }
// // }

// // /*
// // You are given a non-negative floating point number rounded to two decimal
// places celsius, that denotes the temperature in Celsius.
// // You should convert Celsius into Kelvin and Fahrenheit and return it as an
// array ans = [kelvin, fahrenheit].
// // Return the array ans. Answers within 10-5 of the actual answer will be
// accepted.
// // Note that:
// // Kelvin = Celsius + 273.15
// // Fahrenheit = Celsius * 1.80 + 32.00
// // */
// // class Solution {
// // public double[] convertTemperature(double celsius) {
// // double kelvin = celsius + 273.15;
// // double fahrenheit = celsius * 1.80 + 32.00;
// // return new double[]{kelvin, fahrenheit};
// // }
// // }

// // /*
// // You are given a 0-indexed array of strings words and a character x.
// // Return an array of indices representing the words that contain the
// character x.
// // Note that the returned array may be in any order.
// // Constraints:
// // 1 <= words.length <= 50
// // 1 <= words[i].length <= 50
// // x is a lowercase English letter.
// // words[i] consists only of lowercase English letters.
// // */

// // class Solution {
// // public List<Integer> findWordsContaining(String[] words, char x) {
// // List<Integer> indices = new ArrayList<>();
// // for (int i=0; i<words.length; i++){
// // String word = words[i];
// // if (doesWordContainLetter(word, x)){
// // indices.add(i);
// // }
// // }
// // return indices;
// // }

// // public boolean doesWordContainLetter(String word, char x){
// // for (int j=0; j < word.length(); j++){
// // if(word.charAt(j) == x){
// // return true;
// // }
// // }
// // return false;
// // }

// // /*Given an integer array nums of length n, you want to create an array ans
// of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n
// (0-indexed).
// // Specifically, ans is the concatenation of two nums arrays.
// // Return the array ans.
// // */
// // class Solution {
// // public int[] getConcatenation(int[] nums) {
// // int[] ans = new int[2*nums.length];
// // for (int i = 0; i < nums.length; i++){
// // ans[i] = nums[i];
// // }
// // for (int i = 0; i < nums.length; i++){
// // ans[i+nums.length] = nums[i];
// // }
// // return ans;
// // }
// // }

// // /* There is a programming language with only four operations and one
// variable X:
// // ++X and X++ increments the value of the variable X by 1.
// // --X and X-- decrements the value of the variable X by 1.
// // Initially, the value of X is 0.
// // Given an array of strings operations containing a list of operations,
// return the final value of X after performing all the operations.
// // */
// // class Solution {
// // public int finalValueAfterOperations(String[] operations) {
// // int x = 0;
// // for (int j = 0; j < operations.length; j++) {
// // String operation = operations[i];
// // if (operation.equals("++X") || operation.equals("X++")) {
// // x += 1;
// // } else if (operation.equals("--X") || operation.equals("X--")){
// // x -= 1;
// // }
// // }
// // return x;
// // }
// // }

// // /* Given an array of integers nums, return the number of good pairs.
// // A pair (i, j) is called good if nums[i] == nums[j] and i < j. */
// // class Solution {
// // public int numIdenticalPairs(int[] nums) {
// // int identicalPairs = 0;
// // for (int i = 0; i < nums.length; i++){
// // for (int j = i+1; j < nums.length; j++) {
// // if (nums[i] == nums[j]){
// // identicalPairs++;
// // }
// // }
// // }
// // return identicalPairs;
// // }
// // }

// public static void main( String[] args )
// {
// // System.out.println(new Solution().arrayRankTransform(new int[]{10, 20,
// 30}));
// List<Integer> nums = new ArrayList<>();
// nums.add(7);
// nums.add(-1);
// nums.add(0);
// nums.add(9);
// nums.add(100);
// mergeSort(nums);
// System.out.println(nums);

// }

// public int[] sortArray(int[] nums) {
// List<Integer> numbers = new ArrayList<>();
// for (int i = 0; i < nums.length; i++){
// numbers.add(nums[i]);
// }
// mergeSort(numbers);
// }
// public static void mergeSort(List<Integer> nums){
// if (nums.size() <= 1){
// return;
// }
// List<Integer> leftHalf = nums.subList(0, nums.size() / 2);
// List<Integer> rightHalf = nums.subList(nums.size() / 2, nums.size());
// mergeSort(leftHalf);
// mergeSort(rightHalf);
// List<Integer> sorted = merge(leftHalf, rightHalf);
// for (int i = 0; i < sorted.size(); i++){
// nums.set(i, sorted.get(i));
// }
// }

// public static List<Integer> merge(List<Integer> leftHalf, List<Integer>
// rightHalf){
// List<Integer> sorted = new ArrayList<>();
// int leftIndex = 0;
// int rightIndex = 0;
// while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()){
// if (leftHalf.get(leftIndex) < rightHalf.get(rightIndex)){
// sorted.add(leftHalf.get(leftIndex));
// leftIndex++;
// } else {
// sorted.add(rightHalf.get(rightIndex));
// rightIndex++;
// }
// }
// while (leftIndex < leftHalf.size()){
// sorted.add(leftHalf.get(leftIndex));
// leftIndex++;
// }
// while (rightIndex < rightHalf.size()){
// sorted.add(rightHalf.get(rightIndex));
// rightIndex++;
// }
// return sorted;
// }

// }

// // class Solution {
// // public int[] arrayRankTransform(int[] arr) {
// // int[] copyArray = Arrays.copyOf(arr, arr.length);
// // Arrays.sort(copyArray);

// // Map <Integer, Integer> map = new HashMap<>();
// // int rank = 1;
// // for (int i = 0; i < copyArray.length; i++){
// // if (!map.containsKey(copyArray[i])){
// // map.put(copyArray[i], rank++);
// // }
// // }
// // for (int i = 0; i < arr.length; i++){
// // int index = map.get(arr[i]);
// // arr[i] = index;
// // }
// // return arr;
// // }
// // }

// // class Solution {
// // public boolean threeConsecutiveOdds(int[] arr) {
// // int odds = 0;
// // for (int num : arr){
// // if (num % 2 == 1){
// // odds += 1;
// // if (odds == 3){
// // return true;
// // }
// // } else {
// // odds = 0;
// // }
// // }
// // return false;
// // }
// // }

// // class Solution {
// // public boolean isIsomorphic(String s, String t) {
// // Map<Character, Character> map = new HashMap<>();
// // for (int i = 0; i < s.length(); i++){
// // char c1 = s.charAt(i);
// // char c2 = t.charAt(i);
// // if (map.containsKey(c1) && map.get(c1) != c2){
// // return false;
// // } else if (map.containsValue(c2) && !map.containsKey(c1)){
// // return false;
// // } else {
// // map.put(c1, c2);
// // }
// // }
// // return true;
// // }
// // }

// // class Solution {
// // public int romanToInt(String s) {
// // Map<Character, Integer> map = new HashMap<>();
// // map.put('I', 1);
// // map.put('V', 5);
// // map.put('X', 10);
// // map.put('L', 50);
// // map.put('C', 100);
// // map.put('D', 500);
// // map.put('M', 1000);

// // int result = 0;

// // for (int i = s.length() - 1; i >= 0; i--){
// // char c = s.charAt(i);
// // result += map.get(c);
// // if (i < s.length() - 1 && map.get(c) < map.get(s.charAt(i+1))){
// // result -= 2 * map.get(c);
// // }
// // }
// // return result;
// // }
// // }

// // class Pair{
// // public String symbol;
// // public int value;
// // public Pair(String symbol, int value){
// // this.symbol = symbol;
// // this.value = value;
// // }
// // }

// // class Solution {
// // public String intToRoman(int num) {
// // List<Pair> pairs = new ArrayList<>();
// // pairs.add(new Pair("M", 1000));
// // pairs.add(new Pair("CM", 900));
// // pairs.add(new Pair("D", 500));
// // pairs.add(new Pair("CD", 400));
// // pairs.add(new Pair("C", 100));
// // pairs.add(new Pair("XC", 90));
// // pairs.add(new Pair("L", 50));
// // pairs.add(new Pair("XL", 40));
// // pairs.add(new Pair("X", 10));
// // pairs.add(new Pair("IX", 9));
// // pairs.add(new Pair("V", 5));
// // pairs.add(new Pair("IV", 4));
// // pairs.add(new Pair("I", 1));

// // StringBuilder sb = new StringBuilder();
// // for (int i = 0; i < pairs.size(); i++){
// // int div = num / pairs.get(i).value;
// // if (div > 0){
// // for (int j = 0; j < div; j++){
// // sb.append(pairs.get(i).symbol);
// // }
// // num %= pairs.get(i).value;
// // }
// // }
// // return sb.toString();
// // }
// // }

// // class Solution {
// // public boolean checkRecord(String s) {
// // int count = 0;
// // for(int i = 0; i < s.length(); i++){
// // char c = s.charAt(i);
// // if (c == 'A'){
// // count++;
// // if (count == 2){
// // return false;
// // }
// // }
// // }
// // for(int i = 0; i < s.length()-2; i++){
// // char c = s.charAt(i);
// // if (c == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L'){
// // return false;
// // }
// // }
// // return true;
// // }
// // }

// // class Solution {
// // public String addStrings(String num1, String num2) {
// // List<Integer> str = new ArrayList<>();
// // int i = num1.length() - 1;
// // int j = num2.length() - 1;
// // int remainder = 0;

// // while(i >= 0 || j >= 0 || remainder == 1){
// // int c1 = 0;
// // int c2 = 0;
// // if (i >= 0){
// // c1 = Character.getNumericValue(num1.charAt(i));
// // }
// // if (j >= 0){
// // c2 = Character.getNumericValue(num2.charAt(j));
// // }
// // int sum = c1 + c2 + remainder;
// // if (sum < 10){
// // str.add(sum);
// // remainder = 0;
// // } else {
// // str.add(sum%10);
// // remainder = 1;
// // }
// // i--;
// // j--;
// // }
// // StringBuilder sb = new StringBuilder();
// // for(int c = str.size() - 1; c >= 0; c--){
// // sb.append(str.get(c));
// // }
// // return sb.toString();
// // }
// // }

// // class Solution {
// // public boolean isSubsequence(String s, String t) {
// // int i = 0;
// // int j = 0;
// // while (i < s.length() && j < t.length()){
// // if (s.charAt(i) == t.charAt(j)){
// // i++;
// // j++;
// // } else {
// // j++;
// // }
// // }
// // return i == s.length();
// // }
// // }

// // class Solution {
// // public String reverseVowels(String s) {
// // char[] letters = s.toCharArray();
// // int left = 0;
// // int right = letters.length - 1;
// // char temp = 'a';
// // while (left < right){
// // if (!isVowel(letters[left])){
// // left++;
// // } else if (!isVowel(letters[right])){
// // right--;
// // } else {
// // temp = letters[left];
// // letters[left] = letters[right];
// // letters[right] = temp;
// // left++;
// // right--;
// // }
// // }
// // String result = new String(letters);
// // return result;
// // }

// // public Boolean isVowel(char c){
// // char character = Character.toLowerCase(c);
// // if (character == 'a') return true;
// // else if (character == 'e') return true;
// // else if (character == 'o') return true;
// // else if (character == 'i') return true;
// // else if (character == 'u') return true;
// // else return false;
// // }
// // }

// // class Solution {
// // public int[] plusOne(int[] digits) {
// // for(int i = digits.length - 1; i >= 0; i--){
// // if(digits[i] < 9){
// // digits[i] += 1;
// // return digits;
// // } else if (digits[i] == 9){
// // digits[i] = 0;
// // }
// // }
// // if(digits[0] == 0){
// // int[] newDigits = new int[digits.length + 1];
// // newDigits[0] = 1;
// // for(int i = 1; i < newDigits.length; i++){
// // newDigits[i] = digits[i-1];
// // }
// // return newDigits;
// // }
// // return null;
// // }
// // }

// // class Solution {
// // public int digit(int[] digits) {
// // int digit = 0;
// // int num = 1;
// // for(int i = digits.length - 1; i >= 0; i--){
// // digit += digits[i] * num;
// // num *= 10;
// // }
// // return digit + 1;
// // }
// // }

// // class Solution {
// // public boolean isBalanced(String num) {
// // int sumEven = 0;
// // int sumOdd = 0;
// // for(int i = 0; i < num.length(); i++){
// // if (i % 2 == 0){
// // sumEven += Integer.parseInt(String.valueOf(num.charAt(i)));
// // } else {
// // sumOdd += Integer.parseInt(String.valueOf(num.charAt(i)));
// // }
// // return sumEven == sumOdd;
// // }
// // }

// // class Solution {
// // public boolean isPalindrome(int x) {
// // String str = String.valueOf(x);
// // int left = 0;
// // int right = str.length() - 1;
// // while(left < right){
// // if (str.charAt(left) == str.charAt(right)){
// // left++;
// // right--;
// // } else return false;
// // }
// // return true;
// // }
// // }

// // class Solution {
// // public int findClosestNumber(int[] nums) {
// // int closestNum = Integer.MAX_VALUE;
// // for (int i = 0; i < nums.length; i++){
// // if(Math.abs(nums[i]) < Math.abs(closestNum)){
// // closestNum = nums[i];
// // } else if (Math.abs(nums[i]) == Math.abs(closestNum)){
// // closestNum = Math.max(closestNum, nums[i]);
// // }
// // }
// // return closestNum;
// // }
// // }

// // class Solution {
// // public int findClosestNumber(int[] nums) {
// // int closestNum = Integer.MAX_VALUE;
// // for (int i = 0; i < nums.length; i++){
// // if(absoluteValue(nums[i]) < absoluteValue(closestNum)){
// // closestNum = nums[i];
// // } else if (absoluteValue(nums[i]) == absoluteValue(closestNum)){
// // closestNum = Math.max(closestNum, nums[i]);
// // }
// // }
// // return closestNum;
// // }

// // public int absoluteValue(int num){
// // if (num > 0) return num;
// // else return num * -1;
// // }
// // }

// // class Solution {
// // public int maxDepth(TreeNode root) {
// // if (root == null) return 0;
// // int left = maxDepth(root.left);
// // int right = maxDepth(root.right);
// // return 1 + Math.max(left, right);
// // }
// // }

// // class Solution {
// // public int countBalls(int lowLimit, int highLimit) {
// // Map<Integer, Integer> map = new HashMap<>();
// // for (int i = lowLimit; i <= highLimit; i++){
// // int key = sumOfDigits(i)
// // if (map.containsKey(key)){
// // map.put(key, map.get(key) + 1);
// // } else {
// // map.put(key, 1);
// // }
// // }
// // int countBalls = 0;
// // for(int num : map.values()){
// // if (num > countBalls){
// // countBalls = num;
// // }
// // }
// // return countBalls;
// // }

// // public int sumOfDigits(int num){
// // int sum = 0;
// // while(num > 0){
// // sum += num % 10;
// // num //= 10;
// // }
// // return sum;
// // }
// // }

// // class Solution {
// // public String reversedString(String string) {
// // int lastIndex = string.length() - 1;
// // if (string.equals("")) {
// // return "";
// // } else if (string.length() == 1){
// // return string;
// // } else {
// // return string.charAt(lastIndex) + reversedString(string.substring(0,
// lastIndex));
// // }
// // }
// // }

// // class Solution {
// // public int numJewelsInStones(String jewels, String stones) {
// // int numJewelsInStones = 0;
// // for (int i = 0; i < jewels.length(); i++){
// // for (int j = 0; j < stones.length(); j++){
// // if (jewels.charAt(i) == stones.charAt(j)){
// // numJewelsInStones++;
// // }
// // }
// // }
// // return numJewelsInStones;
// // }
// // }

// // class Solution {
// // public int search(int[] nums, int target) {
// // int left = 0;
// // int right = nums.length - 1;
// // while(left < right){
// // int mid = (left + right) / 2;
// // if (nums[mid] == target){
// // return mid;
// // } else if (nums[mid] > target){
// // right = mid - 1;
// // } else {
// // left = mid + 1;
// // }
// // }
// // return -1;
// // }
// // }

// // class Solution {
// // public List<Integer> majorityElement(int[] nums) {
// // Map<Integer, Integer> map = new HashMap<>();
// // for(int num : nums){
// // if(map.containsKey(num)){
// // map.put(num, map.get(num) + 1);
// // } else {
// // map.put(num, 1);
// // }
// // }
// // List<Integer> list = new ArrayList<>();
// // for(int num : map.keySet()){
// // if((nums.length / 3) < map.get(num)){
// // list.add(num);
// // }
// // }
// // return list;
// // }
// // }

// // class Solution {
// // public int majorityElement(int[] nums) {
// // Map<Integer, Integer> map = new HashMap<>();
// // for(int num : nums){
// // if(map.containsKey(num)){
// // map.put(num, map.get(num) + 1);
// // } else {
// // map.put(num, 1);
// // }
// // }
// // int largestValue = 0;
// // int largestKey = 0;
// // for(int num : map.keySet()){
// // if(largestValue < map.get(num)){
// // largestValue = map.get(num);
// // largestKey = num;
// // }
// // }
// // return largestKey;
// // }
// // }

// // class Solution {
// // public int majorityElement(int[] nums) {
// // Arrays.sort(nums);
// // int largestValue = 0;
// // int largestKey = 0;
// // int i = 0;
// // while(i < nums.length){
// // int num = nums[i];
// // int duplicates = 0;
// // while (i < nums.length && num == nums[i]){
// // i++;
// // duplicates++;
// // }
// // if(largestValue < duplicates){
// // largestValue = duplicates;
// // largestKey = num;
// // }
// // }
// // return largestKey;
// // }
// // }

// // class Solution {
// // public int majorityElement(int[] nums) {
// // Map<Integer, Integer> map = new HashMap<>();
// // for(int num : nums){
// // if(map.containsKey(num)){
// // map.put(num, map.get(num) + 1);
// // } else {
// // map.put(num, 1);
// // }
// // }
// // int largestValue = 0;
// // int largestKey = 0;
// // for(int num : map.keySet()){
// // if(largestValue < map.get(num)){
// // largestValue = map.get(num);
// // largestKey = num;
// // }
// // }
// // return largestKey;
// // }
// // }

// /**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode() {}
// * TreeNode(int val) { this.val = val; }
// * TreeNode(int val, TreeNode left, TreeNode right) {
// * this.val = val;
// * this.left = left;
// * this.right = right;
// * }
// * }
// */

// // class Solution {
// // public TreeNode searchBST(TreeNode root, int val) {
// // if(root == null){
// // return null;
// // } else if(root.val == val) {
// // return root;
// // } else if(root.val < val){
// // return searchBST(root.right, val);
// // } else {
// // return searchBST(root.left, val);
// // }
// // }
// // }

// // class Solution {
// // public int minimumMoves(String s) {
// // int minimumMoves = 0;
// // char[] ch = s.toCharArray();
// // for (int i = 0; i < ch.length; i++){
// // if (ch[i] == 'X'){
// // i+=2;
// // minimumMoves++;
// // }
// // }
// // return minimumMoves;
// // }
// // }

// // class Solution {
// // public boolean hasTrailingZeros(int[] nums) {
// // int count = 0;
// // for (int num : nums){
// // if (num % 2) count++;
// // }
// // return count >= 2;
// // }
// // }

// // class Solution {
// // public int[] intersection(int[] nums1, int[] nums2) {
// // List<Integer> intersection = new ArrayList<>();
// // Arrays.sort(nums1);
// // Arrays.sort(nums2);

// // int nums1Index = 0;
// // int nums2Index = 0;

// // while(nums1Index < nums1.length && nums2Index < nums2.length){
// // while(nums1Index + 1 < nums1.length && nums1[nums1Index] ==
// nums1[nums1Index + 1]){
// // nums1Index++;
// // }
// // while(nums2Index + 1 < nums2.length && nums2[nums2Index] ==
// nums2[nums2Index + 1]){
// // nums2Index++;
// // }

// // if (nums1[nums1Index] == nums2[nums2Index]){
// // intersection.add(nums1[nums1Index]);
// // nums1Index++;
// // nums2Index++;
// // } else if (nums1[nums1Index] < nums2[nums2Index]){
// // nums1Index++;
// // } else {
// // nums2Index++;
// // }
// // }

// // int[] result = new int[intersection.size()];
// // for (int i = 0; i < result.length; i++){
// // result[i] = intersection.get(i);
// // }

// // return result;
// // }
// // }

// // class Solution {
// // public boolean isPowerOfTwo(int n) {
// // while (n > 1){
// // if (n % 2 == 0){
// // n = n / 2;
// // } else {
// // return false;
// // }
// // }
// // return n == 1;
// // }
// // }

// // class Solution {
// // public int tribonacci(int n) {
// // int l = 0;
// // int m = 1;
// // int r = 1;
// // if (n == 0) return 0;
// // if (n == 1) return 1;
// // for (int i = 0; i < n - 2; i++){
// // int tribonacci = l + m + r;
// // l = m;
// // m = r;
// // r = tribonacci;
// // }
// // return r;
// // }
// // }

// // class Solution {
// // public int tribonacci(int n) {
// // if (n == 0) return 0;
// // if (n == 1) return 1;
// // if (n == 2) return 1;
// // return tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
// // }
// // }

// // class Solution {
// // public int fib(int n) {
// // int l = 0;
// // int r = 1;
// // if (n == 0) return l;
// // for (int i = 0; i < n - 1; i++){
// // int next = l + r;
// // l = r;
// // r = next;
// // }
// // System.out.println(r);
// // return r;
// // }
// // }

// // class Solution {
// // public int fib(int n) {
// // if (n == 0) {
// // return 0;
// // }
// // if (n == 1) {
// // return 1;
// // }
// // return fib(n-1) + fib(n-2);
// // }
// // }

// // class Solution {
// // public void printNumbers(int n) {
// // System.out.println(n);
// // if (n > 0) {
// // printNumbers(n-1);
// // }
// // }
// // }

// // class Solution {
// // public String binary(int num) {
// // StringBuilder sb = new StringBuilder();
// // while (num > 0){
// // if(num % 2 == 0){
// // sb.append('0');
// // } else {
// // sb.append('1');
// // }
// // num = num / 2;
// // }
// // return sb.reverse().toString();
// // }
// // }

// // class Solution {
// // public void printChristmasTree(int height) {
// // for (int row = 0; row < height; row++){
// // for (int space = 0; space < height - row; space++){
// // System.out.print(' ');
// // }
// // for (int col = 0; col <= row; col++){
// // System.out.print("* ");
// // }
// // System.out.print("\n");
// // }
// // }
// // }

// // class Solution {
// // public boolean checkIfPangram(String sentence) {
// // Set<Character> set = new HashSet<>();
// // for (int i = 0; i < sentence.length(); i++) {
// // set.add(sentence.charAt(i));
// // }
// // return set.size() == 26;
// // }
// // }

// // class Solution {
// // public int countConsistentStrings(String allowed, String[] words) {
// // int count = 0;
// // Set<Character> allowedSet = new HashSet<>();
// // for (int i = 0; i < allowed.length(); i++){
// // allowedSet.add(allowed.charAt(i));
// // }
// // for (int i = 0; i < words.length; i++){
// // String s = words[i];
// // if (isStringConsistent(allowedSet, s)){
// // count++;
// // }
// // }
// // return count;
// // }

// // public boolean isStringConsistent(Set<Character> allowedSet, String str){
// // for (int j = 0; j < str.length(); j++){
// // if (!allowedSet.contains(str.charAt(j))){
// // return false;
// // }
// // }
// // return true;
// // }
// // }

// // class Solution {
// // public int countPairs(List<Integer> nums, int target) {
// // int count = 0;
// // for (int i = 0; i < nums.size(); i++){
// // for (int j = i + 1; j < nums.size(); j++){
// // if (nums.get(i) + nums.get(j) < target){
// // count++;
// // }
// // }
// // }
// // return count;
// // }
// // }

// // class Solution {
// // public String truncateSentence(String s, int k) {
// // StringBuilder sb = new StringBuilder();
// // int space = 0;
// // for (int i = 0; i < s.length(); i++){
// // if (s.charAt(i)== ' '){
// // space++;
// // }
// // if (space == k){
// // break;
// // }
// // sb.append(s.charAt(i));
// // }
// // return sb.toString();
// // }
// // }

// // class Solution {
// // public int[] smallerNumbersThanCurrent(int[] nums) {
// // int[] smallerNumbers = new int[nums.length];
// // for (int i = 0; i < nums.length; i++){
// // int count = 0;
// // for (int j = 0; j < nums.length; j++){
// // if (nums[j] < nums[i]){
// // count++;
// // }
// // }
// // smallerNumbers[i] = count;
// // }
// // return smallerNumbers;
// // }
// // }

// class ParkingSystem {
// private int big;
// private int medium;
// private int small;

// public ParkingSystem(int big, int medium, int small) {
// this.big = big;
// this.medium = medium;
// this.small = small;
// }

// public boolean addCar(int carType) {
// boolean addCar = false;
// switch (carType) {
// case 1:
// if (big > 0){
// addCar = true;
// big--;
// }
// break;
// case 2:
// if (medium > 0){
// addCar = true;
// medium--;
// }
// break;
// case 3:
// if (small > 0){
// addCar = true;
// small--;
// }
// break;
// default:
// break;
// }
// return addCar;
// }
// }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

// class Solution {
// public int minOperations(int[] nums, int k) {
// int minOperations = 0;
// for (int i = 0; i < nums.length; i++){
// if (nums[i] < k){
// minOperations++;
// }
// }
// return minOperations;
// }
// }

// class Solution {
// public int missingNumber(int[] nums) {
// int missingNumber;
// Arrays.sort(nums);
// for (int i = 0; i < nums.length; i++){
// if (nums[i] != i){
// return i;
// }
// }
// return nums.length;
// }
// }