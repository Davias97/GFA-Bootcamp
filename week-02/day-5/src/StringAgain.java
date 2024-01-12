public class StringAgain {

    public static void main(String[] args) {

        System.out.println(removeX("DsadadsadXXXXxxxxxxxYYYYYyyyy"));

    }

    public static String removeX(String word) {

        if (word.isEmpty()) {
            return "";
        }
        if (word.charAt(0) == 'x') {

            return removeX(word.substring(1));

        }else
            return word.charAt(0) + removeX(word.substring(1));

    }


}
