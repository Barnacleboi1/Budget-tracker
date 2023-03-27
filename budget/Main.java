package budget;

import java.io.*;
import java.util.*;
import static budget.Action.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static File file = new File ("C:\\Users\\HP\\eclipse-workspace\\Budget Manager\\Budget Manager\\task\\src\\purchases.txt");
    public static void main(String[] args) {



        double balance = 0;
        double totalSumOfPurchases = 0;
        Map<Purchase, PurchaseType> mapOfPurchases= new HashMap<>();

        BufferedWriter writer = null;

        while (true) {

            Action currentAction = choosingAction();

            switch (currentAction) {
                case ADD_INCOME -> {
                    System.out.println("Enter income:");
                    balance += scanner.nextInt();
                    System.out.println("Income was added!");
                }

                case ADD_PURCHASE -> {
                    PurchaseType type = pickPurchaseType();
                        while (type != PurchaseType.BACK) {

                            System.out.println("Enter purchase name:");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println("Enter its price:");
                            double price = scanner.nextDouble();

                            mapOfPurchases.put(new Purchase(name, price, type)
                                    , new Purchase(name, price, type).getPurchaseType());
                            totalSumOfPurchases += price;
                            balance -= price;
                            System.out.println("Purchase was added!");
                            System.out.println();
                            type = pickPurchaseType();

                        }
                }

                case LIST_OF_PURCHASES -> {
                    double sumOfPurchases = 0;
                    PurchaseType typeToShow = pickTypeToShow();
                    while (typeToShow != PurchaseType.BACK) {
                        if (mapOfPurchases.isEmpty()) {
                            System.out.println("The purchase list is empty!");
                            typeToShow = PurchaseType.BACK;
                        } else {
                            if (typeToShow == PurchaseType.ALL) {
                                System.out.println(PurchaseType.ALL);
                                mapOfPurchases.forEach((purchase, type) -> System.out.println(purchase.toString()));
                                System.out.printf("Total sum: $%.2f\n", totalSumOfPurchases);
                                System.out.println();

                            } else {
                                if (!mapOfPurchases.containsValue(typeToShow)) {

                                    System.out.println(typeToShow.toString());
                                    System.out.println("The purchase list is empty!");
                                    System.out.println();

                                }
                                else {
                                    for (var entry : mapOfPurchases.entrySet()) {
                                        if (entry.getValue() == typeToShow) {
                                            System.out.println(entry.getKey().toString());
                                            sumOfPurchases += entry.getKey().getPrice();
                                        }
                                    }
                                    System.out.printf("Total sum: $%.2f\n", sumOfPurchases);
                                    System.out.println();
                                }
                            }
                            typeToShow = pickTypeToShow();
                        }
                        sumOfPurchases = 0;
                    }
                }

                case BALANCE -> {
                    if (balance < 0) {
                        System.out.println("Balance: $0.00");
                    }
                    else {
                        System.out.printf("Balance: $%.2f\n", balance);
                    }
                }
                case SAVE -> {
                    try {
                        writer = new BufferedWriter(new FileWriter(file));
                        writer.write(String.format("Balance: $%.2f", balance));
                        for (Purchase purchase : mapOfPurchases.keySet()) {
                            writer.write(purchase.intoFile());
                        }
                        writer.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                case LOAD -> loadFiles();
                case EXIT -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
            }
        }
    }
    public static PurchaseType pickPurchaseType() {
        System.out.println("""
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) Back""");
        scanner.nextLine();
        int input = scanner.nextInt();
        System.out.println();
        return input == 1 ? PurchaseType.FOOD
                : input == 2 ? PurchaseType.CLOTHES
                : input == 3 ? PurchaseType.ENTERTAINMENT
                : input == 4 ? PurchaseType.OTHER
                : input == 5 ? PurchaseType.BACK
                : null;
    }
    public static PurchaseType pickTypeToShow() {
        System.out.println("""
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) All
                6) Back""");
        int input = scanner.nextInt();
        System.out.println();
        return input == 1 ? PurchaseType.FOOD
                : input == 2 ? PurchaseType.CLOTHES
                : input == 3 ? PurchaseType.ENTERTAINMENT
                : input == 4 ? PurchaseType.OTHER
                : input == 5 ? PurchaseType.ALL
                : input == 6 ? PurchaseType.BACK
                : null;
    }
    public static Action choosingAction() {
        System.out.println();
        System.out.printf("""
                        Choose your action:
                        1) %s
                        2) %s
                        3) %s
                        4) %s
                        5) %s
                        6) %s
                        0) %s
                        """, ADD_INCOME, ADD_PURCHASE,
                LIST_OF_PURCHASES, BALANCE, SAVE, LOAD, EXIT);
        int result = scanner.nextInt();
        System.out.println();

        return result == 1 ? ADD_INCOME
                : result == 2 ? ADD_PURCHASE
                : result == 3 ? LIST_OF_PURCHASES
                : result == 4 ? BALANCE
                : result == 5 ? SAVE
                : result == 6 ? LOAD
                : result == 0 ? EXIT
                : null;
    }
    public static void loadFiles(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
