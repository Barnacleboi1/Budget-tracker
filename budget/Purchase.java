package budget;

public class Purchase {
    private String name;
    private double price;
    private PurchaseType purchaseType;

    public Purchase(String name, double price, PurchaseType purchaseType) {
        this.name = name;
        this.price = price;
        this.purchaseType = purchaseType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", getName(), getPrice());
    }
}
