import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonApp {

    public static void main(String[] args) {
        List<String> pokemons = readFile("src/pokemons.csv");
        List<String> pokemonNames = filterPokemonNames(pokemons);
        writeFile(pokemonNames, "src/pokemonNames.csv");
        appendFile(Arrays.asList("Furkesz", "Dosha"), "src/pokemonNames.csv");
    }

    private static void appendFile(List<String> fileContent, String file) {
        try {
            Files.write(Paths.get(file), fileContent, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Unable to write file.");
        }
    }

    private static void writeFile(List<String> fileContent, String file) {
        try {
            Files.write(Paths.get(file), fileContent);
        } catch (IOException e) {
            System.err.println("Unable to write file.");
        }
    }

    private static List<String> filterPokemonNames(List<String> pokemons) {
        List<String> pokemonNames = new ArrayList<>();
        for (int i = 0; i < pokemons.size(); i++) {
            String pokemonLine = pokemons.get(i);
            String[] pokemonData = pokemonLine.split(",");
            String pokemonName = pokemonData[1];
            pokemonNames.add(pokemonName);
        }
        return pokemonNames;
    }

    public static List<String> readFile(String file) {
        Path filePath = Paths.get(file);
        try {
            List<String> fileLines = Files.readAllLines(filePath);
            fileLines.remove(0);
            return fileLines;
        } catch (IOException e) {
            System.err.println("Unable to read file.");
            return new ArrayList<>();
        }
    }
}
