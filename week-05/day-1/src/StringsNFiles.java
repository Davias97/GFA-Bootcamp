import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class StringsNFiles {
    public static void main(String[] args) throws Exception {
        Path input = Paths.get("C:\\Users\\daves\\greenfox\\Davias97\\week-05\\day-1\\src\\inputFile.txt");
        Path output = Paths.get("C:\\Users\\daves\\greenfox\\Davias97\\week-05\\day-1\\src\\outputFile.txt");
        findLongestWord(input,output);

    }

    public static void findLongestWord(Path inputFile, Path outputFile) throws Exception {
        //Step 1
//        String[] words = sentence.split(" ");
//        int longest = 0;
//
//        for (String word : words) {
//            if (word.toCharArray().length > longest) {
//                longest = word.toCharArray().length;
//            }
//        }
//        return longest;

        //Step 2
        if (!Files.exists(inputFile)) {
            throw new Exception("Error: Can not manipulate file - original error message: ");
        }


        String[] sentence = Files.readAllLines(inputFile).toArray(new String[0]);
        String[] sentenceSplit = sentence[0].split(" ");


        int longest = 0;

        for (String word : sentenceSplit) {
            if (word.toCharArray().length > longest) {
                longest = word.length();
            }
        }

        Files.write(outputFile, String.valueOf(longest).getBytes());

    }
}
