import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Write a function called countLines() that takes a filename as string as a parameter
// and returns the number of lines the file contains.
// It should return zero if it can't open the file
// and should not raise any error.
public class CountLines {
    public static void main(String[] args) {

        String fileName = "my-file.txt";
        countLines(fileName);
    }

    public static int countLines(String fileName) {
        Path filePath = Paths.get(fileName);
        try {
            List<String> loadedContent = Files.readAllLines(filePath);
            return loadedContent.size();
        } catch (IOException e) {
            return 0;
        }
    }
}

