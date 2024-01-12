import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabase2 {
    public static void main(String[] args) {

        Map<String, Integer> productsMap = new HashMap<>();
        productsMap.put("Eggs", 200);
        productsMap.put("Milk", 200);
        productsMap.put("Fish", 400);
        productsMap.put("Apples", 150);
        productsMap.put("Bread", 50);
        productsMap.put("Chicken", 550);

        costLess(productsMap);
        costMore(productsMap);

    }

    public static void costLess(Map<String, Integer> map) {

        for (String product : map.keySet()) {
            int value = map.get(product);
            if (value < 201) {
                System.out.println(product);
            }
        }
    }

    public static void costMore(Map<String, Integer> map) {

        for (String product : map.keySet()) {
            int value = map.get(product);
            if (value > 150) {
                System.out.println(product + " " + value);
            }
        }
    }
}
