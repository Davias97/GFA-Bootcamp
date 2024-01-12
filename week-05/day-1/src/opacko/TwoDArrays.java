package opacko;

import java.util.Arrays;

public class TwoDArrays {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2},
                {3, 4}
        };

        int[][] b = {
                {5, 6},
                {7, 8}
        };

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9,}
        };

        String[][] input1 = {
                {"apple", "banana", "orange"},
                {"cat", "dog", "elephant"},
                {"red", "green", "blue"}
        };

        String[][] input2 = {
                {"app", "pear", "grape"},
                {"rabbit", "fox", "lion"},
                {"purple", "pink", "yellow"}
        };

        System.out.println(Arrays.deepToString(matrixAddition(a, b)));
        System.out.println(Arrays.deepToString(transpose(matrix)));
        System.out.println(Arrays.deepToString(arraySum(matrix)));
        printMatrix(shorterStrings(input1, input2));
        System.out.println(sumOddRows(matrix));

    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] m) {

        int[][] result = new int[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            if (m[i].length != m[0].length) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result[i][j] = m[j][i];
            }
        }
        return result;
    }

    public static int[][] arraySum(int[][] m) {
        int[][] result = new int[2][m.length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                result[0][i] += m[i][j];
            }
        }

        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                result[1][i] += m[j][i];
            }
        }
        return result;
    }

    public static String[][] shorterStrings(String[][] a, String[][] b) {

        String[][] result = new String[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j].length() > b[i][j].length()) {
                    result[i][j] = b[i][j];
                } else {
                    result[i][j] = a[i][j];
                }
            }
        }
        return result;
    }

    public static int sumOddRows(int[][] matrix) {

        int sum = 0;

        for (int i = 1; i < matrix.length; i += 2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
