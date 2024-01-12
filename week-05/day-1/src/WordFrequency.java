import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        System.out.println(wordFrequency("This is realy very very nice sentence, it is realy good for practice!", 2));

    }

    public static Map<String, Integer> wordFrequency(String sentence, int frequency) {

        // Step 1
        sentence = sentence.toLowerCase();
        String[] wordsInSentence = sentence.split(" ");
        Map<String, Integer> words = new HashMap<>();
        // Step 2
        Map<String, Integer> wordsByFrequency = new HashMap<>();
        // Step 1
        for (String word : wordsInSentence) {
            if (words.containsKey(word)) {
                words.put(word, 1 + words.get(word));
            } else {
                words.put(word, 1);
            }
        }
        // Step 2
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == frequency) {
                wordsByFrequency.put(entry.getKey(), frequency);
            }
        }
        return wordsByFrequency;
    }
}
