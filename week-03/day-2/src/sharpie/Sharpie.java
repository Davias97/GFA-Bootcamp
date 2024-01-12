package sharpie;

public class Sharpie {

    String color;
    int width;
    int inkAmount = 100;

    Sharpie(String color, int width) {

    }

    public void use() {

        this.inkAmount = inkAmount - 10;
    }
}
