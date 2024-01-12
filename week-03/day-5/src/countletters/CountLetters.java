package countletters;

import java.util.HashMap;
import java.util.Map;

public class CountLetters {

    public Map<String, Integer> countLetters(String word) {

        Map<String, Integer> dictionary = new HashMap<>();

        for (String letter : word.split("")) {
            Integer count = dictionary.putIfAbsent(letter, 1);
            if (count != null) {
                dictionary.computeIfPresent(letter, (k, v) -> v + 1);
            } else {
                return null;
            }
        }
        return dictionary;
    }
}


