import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Doubled {

    public static void main(String[] args) {
        // Create a method called `decryptDoubled` that takes a filename string
        // as a parameter and decrypts the file's content.
        // Decryption is the process reversing an encryption, i.e. the process
        // which converts encrypted data into its original form.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the duplicated-chars.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        decryptDoubled("duplicated-chars.txt");
    }

    public static void decryptDoubled(String fileName) {

        Path fileSource = Paths.get(fileName);
        Path decryptedPath = Paths.get("output.txt");

        try {
            List<String> sourceLines = Files.readAllLines(fileSource);
            List<String> decryptedLines = new ArrayList<>();
            for (String sourceLine : sourceLines) {
                StringBuilder decryptedLine = new StringBuilder();
                for (int i = 0; i < sourceLine.length(); i += 2) {
                    decryptedLine.append(sourceLine.charAt(i));
                }

                decryptedLines.add(decryptedLine.toString());
            }
        Files.write(decryptedPath, decryptedLines);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}