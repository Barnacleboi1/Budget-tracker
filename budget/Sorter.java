package budget;

import java.util.Map;

public class Sorter {
    SortingMethod method;

    public void setMethod(SortingMethod method) {
        this.method = method;
    }
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        this.method.printSorted(mapOfPurchases);
    }
}
