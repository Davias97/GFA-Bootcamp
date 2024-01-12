package opacko.eshop;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;

    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    public Invoice(Customer customer) {
        this.customer = customer;
        customer.add(this);
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (InvoiceItem item : invoiceItems) {
            totalPrice += item.totalPrice();
        }
        return totalPrice;
    }

    public void add(Product product, int amount) {
        InvoiceItem item = new InvoiceItem(product, amount, product.getPrice());
        invoiceItems.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice for: ").append(customer).append("\n");
        for (InvoiceItem item : invoiceItems) {
            sb.append(item).append("\n");
        }
        sb.append("---\n");
        sb.append("Total: ").append(totalPrice()).append(" Kc");
        return sb.toString();
    }
}
