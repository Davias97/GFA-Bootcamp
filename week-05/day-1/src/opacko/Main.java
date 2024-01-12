package opacko;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        String s = "(Lukas)";
        String[] names = {s, "Ales", "David", "Karel"};
        System.out.println(printNames(names));

    }

    public static String printNames(String[] sa) {
        StringBuilder output = new StringBuilder("GFA:\n");

        for (int i = 0; i < sa.length; i++) {
            output.append(i + 1).append(".").append("-".repeat(i + 1)).append(sa[i]).append("\n");
        }
        return output.toString();
    }
}
