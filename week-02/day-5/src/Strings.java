public class Strings {

    public static void main(String[] args) {

        System.out.println(xChangeToY("XxxXYyyyasfsds"));
    }

    public static String xChangeToY(String word) {

        if (word.isEmpty()) {
            return "";
        }
        if (word.charAt(0) == 'x') {
            return 'y' + xChangeToY(word.substring(1));
        }else {
            return word.charAt(0) + xChangeToY(word.substring(1));
        }
    }

}


