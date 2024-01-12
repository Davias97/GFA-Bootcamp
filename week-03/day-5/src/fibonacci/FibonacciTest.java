package fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    Fibonacci fib;

    @BeforeEach
    void init() {
        fib = new Fibonacci();
    }
    @Test
    void fibonacciSequence() {
        assertEquals(55, fib.fibonacciSequence(10));
    }
}