package anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    Anagram anamagram;

    @BeforeEach
    void init() {

        anamagram = new Anagram();

    }

    @Test
    void anagram() {

        assertEquals(true, anamagram.anagram("loko", "okol"));

    }
}