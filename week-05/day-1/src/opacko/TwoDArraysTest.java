package opacko;

import static org.junit.jupiter.api.Assertions.*;

class TwoDArraysTest {

    @org.junit.jupiter.api.Test
    void transpose() {
        int[][] inputMatrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] expectedOutput = {
                {1, 3, 5},
                {2, 4, 6}
        };

        int[][] actualOutput = TwoDArrays.transpose(inputMatrix);

        assertArrayEquals(expectedOutput, actualOutput);
    }
}