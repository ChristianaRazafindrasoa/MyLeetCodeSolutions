package com.leetcode;

class MatrixMultiplicator {
    private int[][] matrixA;
    private int[][] matrixB;

    public MatrixMultiplicator(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length == 0 || matrixA[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrixA size");
        }

        if (matrixB.length == 0 || matrixB[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrixB size");
        }

        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Failed compatibility rule");
        }

        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public int[][] getMatrixMultiplication() {
        int[][] result = new int[matrixA.length][matrixB[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[row][col] = getDotProduct(row, col);
            }
        }
        return result;
    }

    private int getDotProduct(int row, int col) {
        int product = 0;
        for (int i = 0; i < matrixA[row].length; i++) {
            product += (matrixA[row][i] * matrixB[i][col]);
        }
        return product;
    }
}
