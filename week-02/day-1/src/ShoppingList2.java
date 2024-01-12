import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {
    public static void main(String[] args) {

        Map<String, Double> priceList = new HashMap<>();
        priceList.put("Milk", 1.07);
        priceList.put("Rice", 1.59);
        priceList.put("Eggs", 3.14);
        priceList.put("Cheese", 12.60);
        priceList.put("Chicken Breasts", 9.40);
        priceList.put("Apples", 2.31);
        priceList.put("Tomato", 2.58);
        priceList.put("Potato", 1.75);
        priceList.put("Onion", 1.10);

        Map<String, Integer> bobsList = new HashMap<>();
        bobsList.put("Milk", 3);
        bobsList.put("Rice", 2);
        bobsList.put("Eggs", 2);
        bobsList.put("Cheese", 1);
        bobsList.put("Chicken Breasts", 4);
        bobsList.put("Apples", 1);
        bobsList.put("Tomato", 2);
        bobsList.put("Potato", 1);

        Map<String, Integer> alicesList = new HashMap<>();
        alicesList.put("Rice", 1);
        alicesList.put("Eggs", 5);
        alicesList.put("Chicken Breasts", 2);
        alicesList.put("Apples", 1);
        alicesList.put("Tomato", 10);

        System.out.println(printSum(priceList, bobsList));
        System.out.println(printSum(priceList, alicesList));
        System.out.println(whoBuysMore(bobsList, alicesList, "Rice"));
        System.out.println(whoBuysMore(bobsList, alicesList, "Potato"));
        System.out.println(whoBuysMore(bobsList, alicesList, "Ham"));
        System.out.println(whoBuysMore(bobsList, alicesList, "Apples"));
        System.out.println(whoHasMoreItems(bobsList, alicesList));
        System.out.println(whoBoughMoreItems(bobsList, alicesList));

    }

    public static double printSum(Map<String, Double> priceList, Map<String, Integer> list) {
        double sum = 0;
        for (String key : list.keySet()) {
            sum += (priceList.get(key) * list.get(key));


        }
        return sum;
    }

    public static String whoBuysMore(Map<String, Integer> bobsList, Map<String, Integer> alicesList, String food) {

        if (bobsList.get(food) == null && alicesList.get(food) == null) {
            return "no one";
        }else if (alicesList.get(food) == null || bobsList.get(food) > alicesList.get(food)) {
            return "Bob";
        } else if (bobsList.get(food) ==null || bobsList.get(food) < alicesList.get(food)) {
            return "Alice";
        }else {
            return "no one";
        }
    }

    public static String whoHasMoreItems(Map<String, Integer> bobsList, Map<String, Integer> alicesList) {
        if (bobsList.size()>alicesList.size()) {
            return "Bob";
        }else
            return "Alice";
    }

    public static String whoBoughMoreItems(Map<String, Integer> bobsList, Map<String, Integer> alicesList) {
    int bob = 0;
    int alice = 0;
        for (String key : bobsList.keySet()) {
            bob += bobsList.get(key);
        }
        for (String key : alicesList.keySet()) {
            alice += alicesList.get(key);
        }
        if (bob > alice) {
            return "Bob";
        }else {
            return "Alice";
        }
    }

}

