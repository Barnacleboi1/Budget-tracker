package budget;

import java.util.*;
import static budget.Action.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {



        double balance = 0;
        double sumOfPurchases = 0;
        List<Purchase> listOfPurchases = new ArrayList<>();

        while (true) {
            int numOfAction = choosingAction();
            Action currentAction = numOfAction == 1 ? ADD_INCOME
                    : numOfAction == 2 ? ADD_PURCHASE
                    : numOfAction == 3 ? LIST_OF_PURCHASES
                    : numOfAction == 4 ? BALANCE
                    : numOfAction == 0 ? EXIT
                    : null;

            switch (currentAction) {
                case ADD_INCOME -> {
                    System.out.println("Enter income:");
                    balance += scanner.nextInt();
                    System.out.println("Income was added!");
                }

                case ADD_PURCHASE -> {
                        System.out.println("Enter purchase name:");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.println("Enter its price:");
                        double price = scanner.nextDouble();
                        listOfPurchases.add(new Purchase(name, price));
                        sumOfPurchases += price;
                        balance -= price;
                        System.out.println("Purchase was added!");

                }

                case LIST_OF_PURCHASES -> {
                    if (listOfPurchases.isEmpty()) {
                        System.out.println("The purchase list is empty");
                    }
                    else {
                        for (Purchase purchase : listOfPurchases) {
                            System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
                        }
                        System.out.printf("Total sum: $%.2f\n", sumOfPurchases);
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

                case EXIT -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
            }
        }
    }
    public static int choosingAction() {
        System.out.println();
        System.out.printf("""
                        Choose your action:
                        1) %s
                        2) %s
                        3) %s
                        4) %s
                        0) %s
                        """, ADD_INCOME, ADD_PURCHASE,
                LIST_OF_PURCHASES, BALANCE, EXIT);
        System.out.println();
        int result = scanner.nextInt();
        System.out.println();

        return result;

    }
}
