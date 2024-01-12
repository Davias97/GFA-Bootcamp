package com.gfa.exam.symmetricmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricMatrixTest {

    @Test
    void isSymmetricFirstExample() {
        int[][] input = new int[][]{
                {1,0,1}, {0,2,2}, {1,2,5}
        };
        assertEquals(true, SymmetricMatrix.isSymmetric(input));
    }

    @Test
    void isSymmetricSecondExample() {
        int[][] input2 = new int[][]{
                {7,7,7}, {6,5,7}, {1,2,1}
        };
        assertEquals(false, SymmetricMatrix.isSymmetric(input2));
    }
}