package opacko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesPlayground {
    public static void main(String[] args) {
        String filename = "src/FilesPlayground.java";

        List<String> fileContent = readFile(filename);
        writeFile("FilesPlayground.java", fileContent);

    }

    public static void writeFile(String filename, List<String> content) {
        try {
            Files.write(Paths.get(filename), content);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write to file " + filename);
        }
    }

    public static List<String> readFile(String filepath){
        List<String> output;
        try {
            output = Files.readAllLines(Paths.get(filepath));
        } catch (IOException exception) {
            throw new RuntimeException("file doesn't exist");
        }

        return output;
    }


}