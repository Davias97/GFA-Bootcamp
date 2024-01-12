package sharpieset;

public class Sharpie {
    private String color;
    private int width;
    private int inkAmount;

    public Sharpie(String color, int width) {
        this.color = color;
        this.width = width;
        this.inkAmount = 100;
    }

    public int getInkAmount() {
        return inkAmount;
    }

    public void use() {
        this.inkAmount -= 10;
    }
}