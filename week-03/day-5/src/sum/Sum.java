package sum;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class Sum {

    public int sum(List<Integer> list) {
        int sum = 0;

        if (list == null) {
            return 0;
        }
        for (Integer element : list) {
            sum += element;
        }
        return sum;
    }
}
