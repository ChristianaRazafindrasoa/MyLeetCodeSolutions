package com.leetcode;

public class DSU {
    private int[] parent;
    public DSU(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid size");
        }
        this.parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parent[parentA] = parentB;
        }
    }
    
    public int size() {
        return parent.length;
    }

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return find(parent[a]);
    }
}
