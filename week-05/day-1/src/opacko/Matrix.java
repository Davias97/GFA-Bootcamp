import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        for(int[] row : transpose(matrix)) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();

        transpose(new int[][]{ });

        int[][] omg = transpose(matrix);

        for(int i = 0; i < omg.length; i++) {
            System.out.println(Arrays.toString(omg[i]));
        }
    }

    public static int[][] transpose(int[][] m) {
        if (m == null) {
            return null;
        }

        if (m.length == 0) {
            return m;
        }

        int[][] out = new int[m[0].length][m.length];

        for (int y = 0; y < m.length; y++) {
            for(int x = 0; x < m[0].length; x++) {
                out[y][x] = m[m.length - 1 - x][y];
            }
        }

        return out;
    }
}