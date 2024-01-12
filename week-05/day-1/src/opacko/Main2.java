package opacko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Path filePath = Paths.get("fileio_ext.txt");

        try {
            System.out.println(vowelIsIndices(Path.of("fileio_ext.txt")));
        } catch (IOException e) {
            System.out.println("Cant find the file");
        }
    }

    public static List<String> readFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static String withoutVowel(Path path) throws IOException {
        List<String> fileToText = Files.readAllLines(path);
        char[] fileAsChar = fileToText.toString().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (Character letter : fileAsChar) {
            if (letter != 'a' && letter != 'u' && letter != 'o' && letter != 'i' && letter != 'e') {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public static List<Integer> vowelIsIndices(Path filename) throws IOException {

        String toWorkWith = readFile(filename).toString();
        char[] fileAsChar = toWorkWith.toCharArray();
        List<Integer> listOfIndices = new ArrayList<>();

        for (int i = 0; i < fileAsChar.length; i++) {
            if (fileAsChar[i] == 'a' && fileAsChar[i] == 'u' && fileAsChar[i] == 'o' && fileAsChar[i] == 'i' && fileAsChar[i] == 'e') {
                listOfIndices.add(i);
            }
        }
        return listOfIndices;
    }
}


