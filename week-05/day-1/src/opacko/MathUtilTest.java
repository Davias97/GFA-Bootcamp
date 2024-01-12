package opacko;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {
    // static attribute that is constructed in the setup method
    static MathUtil MATH_UTIL;
    // when using the same seed, the pseudo-random generated numbers are always the same
    static Random random = new Random(420);

    @BeforeAll
    static void setup() {
        MATH_UTIL = new MathUtil();

    }

    @BeforeEach
    void setupBeforeEveryTest() {
        System.out.println(random.nextInt());
        // reset Counter, kdybysme ho meli
    }

    @Test
    void powerHappyCase() {
        assertEquals(8, MATH_UTIL.power(2,3));
    }

    @Test
    void powerZeroExponent() {
        assertEquals(1, MATH_UTIL.power(2,0));
    }

    @Test
    void powerNegativeExponent() {
        assertEquals(0.25, MATH_UTIL.power(2,-2));
    }

    @Test
    void powerInsaneExponent() {
        assertEquals(8589934592d, MATH_UTIL.power(2,33));
    }

    @Test
    void superTestAwesome() {
        // using random data and comparing with well-tested Java Math.pow() method
        // 1000 tests happen here
//        for (int i = 0; i < 1000; i++) {
//            int x = random.nextInt(100);
//            int y = random.nextInt(100);
//            double expected = MATH_UTIL.powerJava(x, y);
//            assertEquals(expected, MATH_UTIL.power(x, y));
//        }
//        assertArrayEquals(new int[]{1,2}, new int[]{1,2});

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        assertIterableEquals(list1, list2);


        Map<Integer, String> map1 = new HashMap<>()
        {{
            put(0, "Ales");
            put(1, "Lukas");
        }};
        Map<Integer, String> map2 = new HashMap<>()
        {{
            put(1, "Lukas");
            put(0, "Ales");
        }};
        assertIterableEquals(map1.entrySet(), map2.entrySet());
        // lists and sets are Iterable (explanation next week),
        // so if you are able to put your values into these data structures,
        // assertIterableEquals() can reliably compare them for you
    }
}