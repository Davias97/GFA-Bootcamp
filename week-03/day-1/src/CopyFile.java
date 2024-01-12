import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    // Write a `copy` function that copies the contents of a file into another file.
    // The function should take two filenames (strings) as parameters:
    //  - path and name of the source file
    //  - path and name of the target file
    // It should return a boolean that shows whether the copy was successful or not.
    public static void main(String[] args) {
        copy("my-file.txt", "my-file-2.txt");
    }

    public static Boolean copy(String path1, String path2) {
        Path sourceFile = Path.of(path1);
        Path targetFile = Path.of(path2);

        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            return false;
        }

    }
}
