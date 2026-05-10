package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        if (left >= right || left < 0 || right < 0) {
            throw new IllegalArgumentException("Invalid indices");
        }

        int pivotIndex = left + (right - left) / 2;
        int pivot = nums[pivotIndex];
        List<Integer> leftArray = new ArrayList<>();
        int middle = 0;
        List<Integer> rightArray = new ArrayList<>();

        for (int currentIndex = left; currentIndex <= right; currentIndex++) {
            if (nums[currentIndex] < nums[pivotIndex]) {
                leftArray.add(nums[currentIndex]);
            } else if (nums[currentIndex] > nums[pivotIndex]) {
                rightArray.add(nums[currentIndex]);
            } else {
                middle++;
            }
        }

        int index = left;
        for (int i = 0; i < leftArray.size(); i++) {
            nums[index++] = leftArray.get(i);
        }
        for (int i = 0; i < middle; i++) {
            nums[index++] = pivot;
        }
        for (int i = 0; i < rightArray.size(); i++) {
            nums[index++] = rightArray.get(i);
        }
        return findFinalPivot(nums, pivot, left, right);
    }

    private int findFinalPivot(int[] nums, int pivot, int left, int right) {
        for (int i = left; i < right; i++) {
            if (nums[i] == pivot) {
                return i;
            }
        }
        return -1;
    }
}
