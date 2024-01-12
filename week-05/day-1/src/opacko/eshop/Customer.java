package opacko.eshop;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Invoice> invoices = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
        customers.add(this);
    }

    static List<Customer> topCustomers() {
        customers.sort((c1, c2) -> c2.totalSpent() - c1.totalSpent());
        return customers.subList(0, Math.min(customers.size(), 3));
    }

    public int totalSpent() {
        int total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.totalPrice();
        }
        return total;
    }

    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public String toString() {
        return name;
    }
}
