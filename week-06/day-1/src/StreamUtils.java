import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtils {
    public static void main(String[] args) throws IOException {

        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
        List<Integer> numbers2 = Arrays.asList(3, 9, 2, 8, 6, 5);
        List<Integer> numbers3 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
        String s = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Morbi nec mattis odio.";
        List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");
        List<Character> characters = Arrays.asList('L', 'o', 'r', 'e', 'm', ' ', 'i', 'p', 's', 'u', 'm');
        String s2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.";
        int number = 20;
        char ch = 'N';

        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("Even numbers: " + evenNumbers);

        List<Integer> positiveSquares = getPositiveSquares(numbers);
        System.out.println("Squares of positive numbers: " + positiveSquares);

        List<Integer> numbersWithSquareGreaterThan20 = getNumbersWithSquareGreaterThan(numbers2, number);
        System.out.println("Numbers with square greater than " + number + ": " + numbersWithSquareGreaterThan20);

        System.out.println("Average of odd numbers: " + averageOfOddNumbers(numbers));

        System.out.println("Sum of odd numbers: " + sumOfOddNumbers(numbers3));

        System.out.println("Upper letters: " + uppercaseCharacters(s));

        System.out.println("Cities starting with " + ch + ": " + citiesStartingWithChar(cities, ch));

        System.out.println("Concatenated list: " + concatenatedList(characters));

        System.out.println("List of character occurences: " + frequencyOfChars(s2));

        System.out.println(getWordFrequency("wikiarticle"));
    }

    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> getPositiveSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > 0)
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    public static List<Integer> getNumbersWithSquareGreaterThan(List<Integer> numbers2, int number) {
        return numbers2.stream()
                .filter(num -> num * num > number)
                .collect(Collectors.toList());
    }

    public static double averageOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static int sumOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<Character> uppercaseCharacters(String s) {
        return s.chars()
                .filter(Character::isUpperCase)
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());
    }

    public static List<String> citiesStartingWithChar(List<String> cities, char ch) {
        return cities.stream()
                .filter(s -> s.charAt(0) == ch)
                .collect(Collectors.toList());
    }

    public static String concatenatedList(List<Character> list) {
        return list.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static Map<Character, Long> frequencyOfChars(String s) {
        return s.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isLetterOrDigit)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> getWordFrequency(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String s = Files.readString(path);

        List<Character> separators = List.of(' ');

        String[] words = s.split("[" + separators.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("")) + "]");

        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
