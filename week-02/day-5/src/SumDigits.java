public class SumDigits {

    public static void main(String[] args) {

        int n = sumDigits(126);
        System.out.println(n);

    }

    public static int sumDigits(int n) {

        if (n < 1) {

            return 0;

        } else {
            System.out.println(n);
            return sumDigits(n / 10) + (n % 10);

        }

    }
}