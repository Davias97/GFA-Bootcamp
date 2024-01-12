package countletters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountLettersTest {

    CountLetters count;

    @BeforeEach
    void init() {

        count = new CountLetters();
    }

    @Test
    void countLetters() {

        System.out.println(count.countLetters(""));
    }
}