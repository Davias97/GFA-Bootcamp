package opacko.eshop;

public class Product {
    protected int price;
    protected String name;

    public Product() {

    }

    public Product(String name, int price) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return name;
    }
}
