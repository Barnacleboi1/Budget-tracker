package budget;

public class Purchase {
    private String name;
    private double price;
    private PurchaseType purchaseType;

    public Purchase(String name, double price, PurchaseType purchaseType) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
