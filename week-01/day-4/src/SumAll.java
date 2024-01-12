public class SumAll {
    public static void main(String[] args) {
        // - Create an array variable named `numbers`
        //   with the following content: `[3, 4, 5, 6, 7]`
        // - Print the sum of the elements of `numbers`
        int[] numbers = {3, 4, 5, 6, 7};
        int sum = 0;
        for (int x = 0; x < numbers.length; x++) {
            sum = sum + numbers[x];
        }
        System.out.println(sum);
    }
}