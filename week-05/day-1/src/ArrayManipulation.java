import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[] a = {0, 1, 3, 8, 4, 6, 9};
        System.out.println(Arrays.toString(arrayDouble(a, "odd")));
    }

    public static int[] arrayDouble(int[] a, String oddOrEven) {

        if (oddOrEven.equals("even")) {

            for (int i = 0; i < a.length; i += 2) {
                a[i] = a[i] * 2;
            }
        } else {
            for (int i = 1; i < a.length; i += 2) {
                a[i] = a[i] * 2;
            }
        }


        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
}