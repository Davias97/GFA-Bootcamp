public class Main {
    public static double getADiagonalAvg(int[][] matrix, int diagonalType) {
        int n = matrix.length;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (diagonalType == 1) { // Main diagonal
                sum += matrix[i][i];
                count++;
            } else if (diagonalType == -1) { // Anti-diagonal
                sum += matrix[i][n - 1 - i];
                count++;
            }
        }

        if (count == 0) {
            return 0.0; // Avoid division by zero
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int diagonalType = 1;

        double average = getADiagonalAvg(matrix, diagonalType);
        System.out.println("Average of the main diagonal: " + average);
    }
}
