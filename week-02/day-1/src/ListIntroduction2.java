import java.util.ArrayList;

public class ListIntroduction2 {
    public static void main(String... args) {

        ArrayList<String> ListA = new ArrayList<>();
        ListA.add("Apple");
        ListA.add("Avocado");
        ListA.add("Blueberries");
        ListA.add("Durian");
        ListA.add("Lychee");

        ArrayList<String> ListB = new ArrayList<>();
        ListB.add("Apple");
        ListB.add("Avocado");
        ListB.add("Blueberries");
        ListB.add("Durian");
        ListB.add("Lychee");

        System.out.println(ListA.contains("Durian"));

        ListB.remove("Durian");

        ListA.add(4, "Kiwifruit");

        System.out.println(ListA.size() == ListB.size());

        System.out.println(ListA.indexOf("Avocado"));

        System.out.println(ListB.indexOf("Durian"));

        ListB.add("Passion Fruit, Pomelo");

        System.out.println(ListA.get(2));

        System.out.println(ListA);

        System.out.println(ListB);


    }
}