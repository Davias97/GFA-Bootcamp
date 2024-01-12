
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SarcasmCase {
    public static void main(String[] args) {
        String mySarcasm = "facebook pays it's taxes";
        char[] array = new char[]{};
        array = mySarcasm.toCharArray();

        for (int i = 0; i < array.length; i += 2) {
            array[i] = Character.toUpperCase(array[i]);
        }
        mySarcasm = new String(array);

        System.out.println(mySarcasm);


    }
}