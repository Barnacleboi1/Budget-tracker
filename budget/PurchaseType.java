package budget;

public enum PurchaseType {
    FOOD("Food:"),
    CLOTHES("Clothes:"),
    ENTERTAINMENT("Entertainment:"),
    OTHER("Other:"),
    ALL("All:"),
    BACK("");
    private String str;

    PurchaseType(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
