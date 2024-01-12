import java.util.ArrayList;
import java.util.HashMap;

public class MapIntroduction1 {
    public static void main(String... args) {

        HashMap<Integer, String> dabu = new HashMap<>();

        System.out.println(dabu.isEmpty());

        dabu.put(97, "a");
        dabu.put(98, "b");
        dabu.put(99, "c");
        dabu.put(65, "A");
        dabu.put(66, "B");
        dabu.put(67, "C");

        System.out.println(dabu.keySet());

        System.out.println(dabu.values());

        dabu.put(68, "D");

        System.out.println(dabu.size());

        System.out.println(dabu.get(99));

        dabu.remove(97);

        System.out.println(dabu.containsValue(100));

        dabu.clear();

        System.out.println(dabu.size());
    }
}