import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {
    public static void main(String[] args) {
        // Create a method called `decryptReversed` that takes a filename string
        // as a parameter and decrypts the file's content.
        // Decryption is the process reversing an encryption, i.e. the process
        // which converts encrypted data into its original form.
        // If the file can't be opened it should print this message: "File not found"
        // The (decrypted) result should be saved in the "output.txt" file (don't change the path).
        // Change the path of the reversed-order.txt source file to the path
        // where you saved it on your computer.
        // You can find the source file in a link next to this exercise.
        decryptReversed("C:\\Users\\daves\\greenfox\\Davias97\\week-03\\day-1\\reversed-order.txt");
    }

    public static void decryptReversed(String fileName) {

        Path fileSource = Paths.get(fileName);
        Path decryptedPath = Paths.get("output.txt");

        try {
            List<String> sourceLines = Files.readAllLines(fileSource);
            List<String> decryptedLines = new ArrayList<>();

            for (int i = sourceLines.size() - 1; i >= 0; i--) {
                decryptedLines.add(sourceLines.get(i));
            }
            Files.write(decryptedPath, decryptedLines);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
