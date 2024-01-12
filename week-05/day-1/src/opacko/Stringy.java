package opacko;

import java.util.Arrays;

public class Stringy {
    public static void main(String[] args) {
        String s = "(Lukas)";

        String[] names = new String[] {s, "Ales", "David", "Karel"};

        System.out.println(niceString(names));

    }

    public static String niceString(String[] names) {
        String output = "GFA:\n";

        for (int i = 0; i < names.length; i++) {
            output += i + 1 + "." + "-".repeat(i+1) + names[i] + "\n";
        }

        return output;
    }
}