import java.util.Arrays;

public class MatrixChars {
    public static void main(String[] args) {
        String[] lines = new String[] {"Ahoj", "Mami"};

        // -> ["hj", "ai"]
        System.out.println(Arrays.toString(cutThrough(lines)));
        System.out.println(Arrays.toString(cutThrough2(lines)));
    }

    public static String[] cutThrough(String[] input) {
        String[] result = new String[input.length];

        int naPrasaka = 0;

        for(String line : input) {
            //radky.... slova

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < line.length(); i += 2) {
                //znaky
                sb.append(line.charAt(i));
            }

            result[naPrasaka] = sb.toString();
            naPrasaka = naPrasaka + 1;
        }

        return result;
    }

    public static String[] cutThrough2(String[] input) {
        String[] result = new String[input.length];

        for(int wordIndex = 0; wordIndex < input.length; wordIndex++) {
            //radky.... slova

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < input[wordIndex].length(); i += 2) {
                //znaky
                sb.append(input[wordIndex].charAt(i));
            }

            result[wordIndex] = sb.toString();
        }

        return result;
    }
}