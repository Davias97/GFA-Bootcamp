public class Sum {
    public static void main(String[] args) {
        int numberA = 5;
        sum(5);
        System.out.println(sum(numberA));

    }

    public static int sum(int number) {
        int result = 0;
        for (int a = 0; a <= number; a++) {
            result = result + a;
        }
        return result;
    }
}

// Write a function called `sum()` that returns the sum of numbers from zero
// to the given parameter
//
// Example: sum(5) = 0 + 1 + 2 + 3 + 4 + 5 = 15