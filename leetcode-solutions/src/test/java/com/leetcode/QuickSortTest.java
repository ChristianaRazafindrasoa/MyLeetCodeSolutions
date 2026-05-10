package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest{
    @Test
    public void testPartition() {
        try {
            new QuickSort().partition(new int[]{1,2}, 0, -1);
            Assert.fail("Expected thrown message");
        } catch (Exception e) {
            Assert.assertEquals("Invalid indices", e.getMessage());
        }

        try {
            new QuickSort().partition(new int[]{1,9,4,5,6}, 4, 2);
            Assert.fail("Expected thrown message");
        } catch (Exception e) {
            Assert.assertEquals("Invalid indices", e.getMessage());
        }
    }
     
    @Test
    public void testQuickSort() {
        int[] nums1 = new int[]{3,2,-1,5,-4,9,0};
        new QuickSort().quickSort(nums1, 0, nums1.length - 1);
        Assert.assertArrayEquals(new int[]{-4,-1,0,2,3,5,9}, nums1);

        int[] nums2 = new int[]{3,2,-1,5,-4};
        new QuickSort().quickSort(nums2, 0, 2);
        Assert.assertArrayEquals(new int[]{-1,2,3,5,-4}, nums2);
    }
}
