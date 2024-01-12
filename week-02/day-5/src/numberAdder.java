public class numberAdder {

    public static void main(String[] args) {

        int n = recursion(10);
        System.out.println(n);
    }

    public static int recursion(int n) {

        if (n < 1) {

            return 0;
        } else {

            return n + recursion(n - 1);
        }
    }

}



