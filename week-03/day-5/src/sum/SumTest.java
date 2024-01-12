package sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {
    Sum sumTest;

    @BeforeEach
    void init() {

        sumTest = new Sum();
    }

    @Test
    void sum() {

        List<Integer> testList = Arrays.asList(1, 2, 3);
        assertEquals(6, sumTest.sum(testList));
    }

    @Test
    void sumEmptyList() {

        List<Integer> emptyList = Arrays.asList();
        assertEquals(0, sumTest.sum(emptyList));

    }

    @Test
    void sumOneElement() {

        List<Integer> oneElementList = Arrays.asList(1);
        assertEquals(1, sumTest.sum(oneElementList));

    }

    @Test
    void sumMultipleElements() {

        List<Integer> multipleElementsList = Arrays.asList(1, 3, 5);
        assertEquals(9, sumTest.sum(multipleElementsList));

    }

    @Test
    void sumNull() {

        assertEquals(0, sumTest.sum(null));

    }
}