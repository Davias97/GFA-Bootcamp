import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {
    // Create a function `writeLines` that takes 3 parameters: a path, a word and a number.
    // The function should write multiple lines into a file.
    // - The path parameter should be a string that describes the location (path & name)
    //    of the file you wish to write.
    // - The word parameter should also be a string that will be written to the file as individual lines.
    // - The number parameter should describe how many times the function should write the word in the file.
    // Example:
    // If the word is "apple" and the number is 5, it should write 5 lines
    // into the file and each of the should be "apple".
    // When the function can't write into the file, than it shall throw a RuntimeException with the
    // "Unable to write file: <path>" error message.
    public static void main(String[] args) {
        String pathParameter = "my-file.txt";
        String wordParameter = "dabutromka";
        int numberParameter = 5;
        writeLines(pathParameter, wordParameter, numberParameter);
    }

    public static void writeLines(String path, String word, int number) {
        Path filePath = Path.of(path);
        List<String> content = new ArrayList<>();


        for (int i = 0; i <= number; i++) {
            try {
                Files.write(filePath, content);
                content.add(word);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}