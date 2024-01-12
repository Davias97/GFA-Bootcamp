public class BunniesAgain {

    public static void main(String[] args) {

        int bunnies = 5;
        System.out.println(bunniesEars(bunnies));
    }

    public static int bunniesEars(int bunnies) {

        if (bunnies < 1) {

            return bunnies;

        } else if (bunnies % 2 == 0) {
            return 2 + bunniesEars(bunnies - 1);

        }else {
            return 3 + bunniesEars(bunnies - 1);
        }

    }

}


