import java.util.*;

public class ProductDatabase {
    public static void main(String[] args) {
        Map<String, Integer> productsMap = new HashMap<>();
        productsMap.put("Eggs", 200);
        productsMap.put("Milk", 200);
        productsMap.put("Fish", 400);
        productsMap.put("Apples", 150);
        productsMap.put("Bread", 50);
        productsMap.put("Chicken", 550);

        print(productsMap);
    }

    public static void print(Map<String, Integer> map) {

        // Fish price

        System.out.println(map.get("Fish"));

        // Most expensive product

        String mostExpensiveProduct = "";
        int maxPrice = 0;

        for (String product : map.keySet()) {
            int price = map.get(product);
            if (price > maxPrice) {
                maxPrice = price;
                mostExpensiveProduct = product;
            }
        }
        System.out.println(mostExpensiveProduct);

        // Average price

        double averagePrice = 0;
        double totalProductPrice = 0;

        for (String product : map.keySet()) {
            double productPrice = map.get(product);
            totalProductPrice += productPrice;
            averagePrice = totalProductPrice / map.size();

        }
        System.out.println(averagePrice);

        // How many products below 300

        int productsBelow300 = 0;
        for (String product : map.keySet()) {
            int value = map.get(product);
            if (value < 300) {
                productsBelow300++;
            }
        }
        System.out.println(productsBelow300);

        // Can we buy smth for 125?

        String canWe = "";
        for (String product : map.keySet()) {
            int value = map.get(product);
            if (value == 125) {
                canWe = "yes";
                break;
            } else
                canWe = "no";
        }
        System.out.println(canWe);

        // Cheapest product

        String cheapestProduct = "";
        int minPrice = Integer.MAX_VALUE;

        for (String product : map.keySet()) {
            int value = map.get(product);
            if (value < minPrice) {
                minPrice = value;
                cheapestProduct = product;
            }
        }
        System.out.println(cheapestProduct);
    }
}