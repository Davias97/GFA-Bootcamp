import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingList {
    public static void main(String[] args) {

        List<String> shoppingList = new ArrayList<>();
        shoppingList.addAll(Arrays.asList("eggs", "milk", "fish", "apples", "bread", "chicken"));

        System.out.println(output(shoppingList, "milk"));
        System.out.println(output(shoppingList, "bananas"));
    }

    public static String output(List<String> shoppingList, String food) {

        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).equals(food)) {
                return "yes";
            }
        }
        return "no";
    }
}
