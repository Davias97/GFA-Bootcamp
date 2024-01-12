import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) throws IOException {
        // Write a program that opens a file called "my-file.txt" and prints each
        // line from the file to separate lines on the console.
        // If the program is unable to read the file (for example the file does not exist),
        // it should print the following error message: "Unable to read file: my-file.txt".
        String fileName = "my-file.txt";
        Path filePath = Path.of(fileName);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.err.println("Unable to read file: " + filePath.getFileName());
            }
        }
        List<String> loadedContent = Files.readAllLines(filePath);
        for (String name : loadedContent) {
            System.out.println(name);
        }
    }
}