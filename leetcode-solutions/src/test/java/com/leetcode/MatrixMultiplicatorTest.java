package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MatrixMultiplicatorTest {
    @Test
    public void testInvalidSizes() {
        try {
            new MatrixMultiplicator(new int[][]{{},{}}, new int[][]{{1,2}});
            Assert.fail("Expected thrown message");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid matrixA size", e.getMessage());
        }

        try {
            new MatrixMultiplicator(new int[][]{{1},{2}}, new int[][]{});
            Assert.fail("Expected thrown message");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid matrixB size", e.getMessage());
        }

        try {
            new MatrixMultiplicator(new int[][]{{},{}}, new int[][]{{}});
            Assert.fail("Expected thrown message");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid matrixA size", e.getMessage());
        }
    }

    @Test
    public void testCompatibilityRule() {
        try {
            new MatrixMultiplicator(new int[][]{{1,2,3},{4,5,6}}, new int[][]{{1,2},{3,4}});
            Assert.fail("Expected thrown message");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Failed compatibility rule", e.getMessage());
        }

        try {
            new MatrixMultiplicator(new int[][]{{1,2},{3,4}}, new int[][]{{1},{2},{3}});
            Assert.fail("Expected thrown message");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Failed compatibility rule", e.getMessage());
        }
    }

    @Test
    public void testMatrixMultiplication() {
        MatrixMultiplicator mm1 = new MatrixMultiplicator(new int[][]{{2}}, new int[][]{{3}});
        Assert.assertArrayEquals(mm1.getMatrixMultiplication(), new int[][]{{6}});

        MatrixMultiplicator mm2 = new MatrixMultiplicator(new int[][]{{2, 4}}, new int[][]{{3},{7}});
        Assert.assertArrayEquals(mm2.getMatrixMultiplication(), new int[][]{{34}});

        MatrixMultiplicator mm3 = new MatrixMultiplicator(new int[][]{{1,3},{2,4}}, new int[][]{{3,2,5},{3,8,4}});
        Assert.assertArrayEquals(mm3.getMatrixMultiplication(), new int[][]{{12,26,17},{18,36,26}});

        MatrixMultiplicator mm4 = new MatrixMultiplicator(new int[][]{{1},{8},{3},{2},{6}}, new int[][]{{4,2}});
        Assert.assertArrayEquals(mm4.getMatrixMultiplication(), new int[][]{{4,2},{32,16},{12,6},{8,4},{24,12}});
    }
}
