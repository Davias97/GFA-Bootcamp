//  Create the usual class wrapper (Factorial) and main method on your own
public class Factorial {
    public static void main(String[] args) {
        int number = 5;
        calculateFactorial(number);
        System.out.println(calculateFactorial(number));
    }

    public static int calculateFactorial(int number) {
        int result = 1;
        for (int a = 2; a <= number; a++) {
            result = result * a;
        }
        return result;
    }
}
// - Create a function called `calculateFactorial()`
//   that returns the factorial of its input
//
// - Example: calculateFactorial(5) = 1 * 2 * 3 * 4 * 5 = 120