package budget;

import java.util.*;

public interface SortingMethod {
    List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases);
    void printSorted(Map<Purchase, PurchaseType> mapOfPurchases);
}
class sortAllPurchases implements SortingMethod {

    @Override
    public List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        List<Purchase> list = new ArrayList<>(mapOfPurchases.keySet().stream().toList());
        list.sort(Comparator.comparing(Purchase::getPrice));
        list.sort(Collections.reverseOrder());
        return list;
    }

    @Override
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        double total = 0;
        for (Purchase purchase : returnSorted(mapOfPurchases)) {
            total += purchase.getPrice();
            System.out.println(purchase.toString());
        }
        System.out.printf("\nTotal: $%.2f", total);
    }
}
class sortByType implements SortingMethod {
    double costOfType;
    @Override
    public List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases) {

        return null;
    }

    @Override
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {

    }
}
class sortByCertainType implements  SortingMethod {

    @Override
    public List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        return null;
    }

    @Override
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {

    }
}