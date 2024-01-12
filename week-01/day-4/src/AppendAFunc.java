public class AppendAFunc {
    public static void main(String[] args) {
        String typo = "Chinchill";
        appendA(typo);
    }

    public static String appendA(String input) {
        System.out.println(input+"a");
        return input+"a";


    }
}

// - Write a function called `appendA()` that takes a string as an input,
// appends the character 'a' at the end and returns the modified string
// - Print the result of `appendA(typo)`