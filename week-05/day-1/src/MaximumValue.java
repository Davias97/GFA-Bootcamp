import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class MaximumValue {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 5, 9, 7, -5},
//                {5, 2, 10, -6, 5},
//                {-3, -10, -2, -5, -3}
//        };

        int[][] matrix = {
                {1, 5},
                {3, 5},
                {0, 0},
                {7, 9}
        };
        System.out.println(Arrays.deepToString(maxValue(matrix)));
    }

    public static Integer[] maxValue(int[][] m) {

        Integer[] maxNumbers = new Integer[m.length];
        int maxNumber = MIN_VALUE;
        for (int i = 0; i < m.length; i++) {
            maxNumbers[i] = maxNumber;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > maxNumber) {
                    maxNumber = m[i][j];
                }
                maxNumbers[i] = maxNumber;
            }
            maxNumber = MIN_VALUE;
        }
        return maxNumbers;
    }

}
