package fibonacci;

public class Fibonacci {

    public int fibonacciSequence(int n) {

        if (n < 2) {
            return n;
        }
        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
    }
}
