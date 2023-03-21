package budget;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        List<String> list = new ArrayList<>();
        double total = 0;
        while (scanner.hasNext()) {
            input = scanner.nextLine();
            list.add(input);
            total += Double.parseDouble(input.substring(input.lastIndexOf("$") + 1));
        }
        list.forEach(System.out :: println);

        System.out.printf("\ntotal: $%.2f", total);
    }
}
