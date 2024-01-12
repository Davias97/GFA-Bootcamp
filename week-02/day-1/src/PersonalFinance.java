import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonalFinance {
    public static void main(String[] args) {


        ArrayList<Integer> expenseList = new ArrayList<>();
        expenseList.addAll(Arrays.asList(500, 1000, 1250, 175, 800, 120));

        System.out.println(output(expenseList));
        System.out.println(output2(expenseList));
        System.out.println(output3(expenseList));
        System.out.println(output4(expenseList));
    }

    public static Integer output(ArrayList<Integer> expenseList) {
        int sum = 0;

        for (int i = 0; i < expenseList.size(); i++) {
            sum += expenseList.get(i);
        }

        return sum;


    }

    public static Integer output2(ArrayList<Integer> expenseList) {
        int greatestExpense = 0;

        for (int i = 0; i < expenseList.size(); i++) {
            if (greatestExpense < expenseList.get(i)) {
                greatestExpense = expenseList.get(i);
            }

        }

        return greatestExpense;

    }

    public static Integer output3(ArrayList<Integer> expenseList) {

        int cheapestItem = output2(expenseList);

        for (int i = 0; i < expenseList.size(); i++) {

            if (cheapestItem > expenseList.get(i)) {
                cheapestItem = expenseList.get(i);
            }

        }
        return cheapestItem;
    }

    public static Float output4(ArrayList<Integer> expenseList) {

        float averageSpending = (float)output(expenseList) / expenseList.size();

//        for (int i = 0; i < expenseList.size(); i++) {
//            averageSpending = expenseList.get(i)

        return averageSpending;
    }

}




