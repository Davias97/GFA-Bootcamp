public class Power {

    public static void main(String[] args) {

        int cislo = 5;
        int power = 3;
        System.out.println(powerN(cislo, power));

    }

    public static int powerN(int cislo, int power) {

        if (power < 2) {

            return cislo;
        }else {
            return cislo*powerN(cislo, (power - 1));
        }

    }

}