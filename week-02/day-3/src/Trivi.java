import java.util.Objects;
import java.util.Scanner;

public class Trivi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Viděl by David rád kolegyně z Trivi?");
        String see = scanner.nextLine();
        System.out.println("Bude David moc?");
        String moc = scanner.nextLine();

        otazka(see, moc);
    }

    public static void otazka(String see, String moc) {

        if (Objects.equals(see, "ano") && Objects.equals(moc, "ano")) {
            System.out.println("DÁME SRAZY!");

        } else if (Objects.equals(see, "ano") && Objects.equals(moc, "nevím")) {
            System.out.println("JE TOHO HROZNĚ MOC NA PRÁCI :((");

        } else
            System.out.println("Davide jsi trapnej!");
    }
}
