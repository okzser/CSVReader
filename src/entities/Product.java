package entities;

public class Product {

    String name;
    double price;
    int quantity;

    public Product(String n, double p, int q) {
        name = n;
        price = p;
        quantity = q;
    }

    public double total() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
