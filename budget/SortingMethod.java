package budget;

import java.util.*;

import static budget.Main.*;

public interface SortingMethod {
    List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases);
    void printSorted(Map<Purchase, PurchaseType> mapOfPurchases);
}
class sortAllPurchases implements SortingMethod {

    @Override
    public List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        List<Purchase> list = new ArrayList<>(mapOfPurchases.keySet());
        list.sort(Comparator.comparing(Purchase::getPrice));
        List<Purchase> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(list.size() - 1 - i));
        }
        return result;
    }

    @Override
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        List<Purchase> list = returnSorted(mapOfPurchases);
        if (list.isEmpty()) {
            System.out.println();
            System.out.println("The purchase list is empty!");
            System.out.println();
            return;
        }
        double total = 0;
        System.out.println();
        for (Purchase purchase : list) {
            total += purchase.getPrice();
            System.out.println(purchase);
        }
        System.out.printf("Total: $%.2f", total);
        System.out.println();
        System.out.println();
    }
}
class sortByType implements SortingMethod {
    public double costOfType(Map<Purchase, PurchaseType> mapOfPurchases, PurchaseType type) {
        double costOfType = 0;
        for (Purchase purchase : returnSorted(mapOfPurchases)) {
            if (purchase.getPurchaseType() == type) {
                costOfType += purchase.getPrice();
            }
        }
        return costOfType;
    }
    @Override
    public List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        return new ArrayList<>(mapOfPurchases.keySet());
    }

    @Override
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        double totalCost = costOfType(mapOfPurchases, PurchaseType.FOOD) +
        costOfType(mapOfPurchases, PurchaseType.ENTERTAINMENT) +
                costOfType(mapOfPurchases, PurchaseType.CLOTHES) +
                costOfType(mapOfPurchases, PurchaseType.OTHER);
        System.out.println();
        System.out.printf("""
                Types:
                Food - $%.2f
                Entertainment - $%.2f
                Clothes - $%.2f
                Other - $%.2f
                Total sum: $%.2f""",
                costOfType(mapOfPurchases, PurchaseType.FOOD),
                costOfType(mapOfPurchases, PurchaseType.ENTERTAINMENT),
                costOfType(mapOfPurchases, PurchaseType.CLOTHES),
                costOfType(mapOfPurchases, PurchaseType.OTHER),
                totalCost);
        System.out.println();
        System.out.println();
    }
}
class sortByCertainType implements  SortingMethod {

    @Override
    public List<Purchase> returnSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        System.out.println();
        PurchaseType type = pickPurchaseType();
        if (type == PurchaseType.BACK) {
            return null;
        }
        List<Purchase> list = new ArrayList<>();
        for (Purchase purchase : mapOfPurchases.keySet()) {
            if (purchase.getPurchaseType() == type) {
                list.add(purchase);
            }
        }
        list.sort(Comparator.comparing(Purchase::getPrice));
        List<Purchase> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(list.size() - 1 - i));
        }
        return result;
    }

    @Override
    public void printSorted(Map<Purchase, PurchaseType> mapOfPurchases) {
        List<Purchase> list = returnSorted(mapOfPurchases);
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            System.out.println();
            System.out.println("The purchase list is empty!");
            System.out.println();
            return;
        }
        double total = 0;
        System.out.println();
        for (Purchase purchase : list) {
            total += purchase.getPrice();
            System.out.println(purchase);
        }
        System.out.printf("Total: $%.2f", total);
        System.out.println();
        System.out.println();
    }
}
