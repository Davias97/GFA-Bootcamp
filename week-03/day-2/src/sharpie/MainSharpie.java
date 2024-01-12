package sharpie;

public class MainSharpie {
    public static void main(String[] args) {

        Sharpie sharpie1 = new Sharpie("blue", 15);
        sharpie1.use();
        System.out.println(sharpie1.inkAmount);


    }
}
