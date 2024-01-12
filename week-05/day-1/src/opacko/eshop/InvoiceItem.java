package opacko.eshop;

public class InvoiceItem extends Product {

    private Product product;
    private int amount;
    private int unitPrice;

    public int totalPrice() {
        return this.amount*this.unitPrice;
    }
    public InvoiceItem(Product product, int amount, int price) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = price;
    }

    @Override
    public String toString() {
        return amount + "x " + product + " " + totalPrice() + " Kc";
    }
}
