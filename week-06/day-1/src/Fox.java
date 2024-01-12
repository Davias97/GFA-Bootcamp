import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Fox {

    public static void main(String[] args) {

       new Fox("Dabu", "green", 1);
       new Fox("Loktar", "blue", 2);
       new Fox("Ogar", "red", 3);
       new Fox("Tromka", "yellow", 4);
       new Fox("Nerzhul", "black", 5);
       new Fox("Loknarosh", "purple", 6);
       new Fox("Zug zug", "pink", 7);
       new Fox("Zase prace?", "orange", 8);

        System.out.println(returnGreenFox(foxes).toString());
        System.out.println(returnGreenFoxYoungerThanFive(foxes).toString());
        System.out.println(foxesByColor(foxes));



    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    private String name;
    private String color;
    private int age;
    private static List<Fox> foxes = new ArrayList<>();

    @Override
    public String toString() {
        return "Fox: " + name + ", " + color + ", " + age;
    }

    public Fox(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        foxes.add(this);
    }

    public static List<Fox> returnGreenFox(List<Fox> foxes) {
        return foxes.stream()
                .filter(fox -> Objects.equals(fox.color, "green"))
                .collect(Collectors.toList());
    }

    public static List<Fox> returnGreenFoxYoungerThanFive(List<Fox> foxes) {
        return foxes.stream()
                .filter(fox -> Objects.equals(fox.color, "green") && fox.age < 5)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> foxesByColor(List<Fox> foxes) {
        return foxes.stream()
                .collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));
    }
}
