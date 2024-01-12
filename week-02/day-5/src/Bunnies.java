public class Bunnies {

    public static void main(String[] args) {

        int bunnies = 10000;
        System.out.println(bunniesEars(bunnies));

    }

    public static int bunniesEars(int bunnies) {

        if (bunnies < 1) {

            return bunnies;

        } else {
            return 2 + bunniesEars(bunnies-1);
        }

    }
}
