package com.leetcode;

import org.junit.Test;
import org.junit.Assert;

public class DSUTest {
    @Test
    public void testSetsBeginAsSingeltons() {
        // Setup
        final int size = 5;
        final DSU dsu = new DSU(size);

        // Execute + Verify
        Assert.assertTrue(dsu.size() == size);
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                if (a == b) {
                    continue;
                }
                Assert.assertTrue(dsu.find(a) != dsu.find(b));
            }
        }
    }

    @Test
    public void testUnionAndFind() {
        // Setup
        final int size = 5;
        final DSU dsu = new DSU(size);

        // Execute
        dsu.union(2, 3);
        dsu.union(0, 2);
        dsu.union(1, 2);

        // Verify
        Assert.assertEquals(dsu.find(2), dsu.find(3));
        Assert.assertEquals(dsu.find(0), dsu.find(3));
        Assert.assertEquals(dsu.find(1), dsu.find(0));
    }

    @Test
    public void testInvalidSize() {
        try {
            DSU dsu = new DSU(0);
            Assert.fail("Expected thrown message");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid size", e.getMessage());
        }
    }
}
