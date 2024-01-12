package opacko;

import java.util.*;

public class CharPlayground {
    public static void main(String[] args) {
        String s = "yrau aorient oiasrenit oniawio nf tpnoawfqy t yuna rostu naow yut na orysu toawyu tnoarfie ntoarsiesnt yawfun oawun ftoaren stoiearn oitena roip4320952039840 239840 2398409238 4-129834 -0129834-091823-4981-230948-1029384023749t82374982374snt1299999932/3.,41/24.56,13456134";



        System.out.println();

        long t0 = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            lameNumberFinder(s);
        }
        System.out.println(new Date().getTime() - t0);

        t0 = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            gigaChadNumberFinder(s);
        }
        System.out.println(new Date().getTime() - t0);






        //znak po znaku
        //je aktualni znak cislo?
        // ano
        // prevedu ho na cislo
        // zakladam novy cislo
        // nasleduje cislo? --> x10 + aktualni cislo
        // nenasleduje cislo? novy vkladam do listu nalezenych cisel
        // sortuju nalezeny cisla, vracim posledni
    }

    private static long lameNumberFinder(String s) {
        List<Long> found = new ArrayList<>();
        long currentNumber = 0;

        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber *= 10;
                currentNumber += Character.getNumericValue(ch);
                found.add(currentNumber);
            } else {
                currentNumber = 0;
            }
        }

        Collections.sort(found);

        return found.get(found.size() - 1);
    }

    private static long gigaChadNumberFinder(String s) {
        long gigaChad = 0;
        long currentNumber = 0;

        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber *= 10;
                currentNumber += Character.getNumericValue(ch);
                if (currentNumber > gigaChad) {
                    gigaChad = currentNumber;
                }
            } else {
                currentNumber = 0;
            }
        }


        return gigaChad;
    }
}