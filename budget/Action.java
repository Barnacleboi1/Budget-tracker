package budget;
import java.util.*;
public enum Action {
    ADD_INCOME("Add income", 1),
    ADD_PURCHASE("Add purchase", 2),
    LIST_OF_PURCHASES("Show list of purchases", 3),
    BALANCE("Balance", 4),
    EXIT("Exit", 0);
    private String description;
    private int number;
    Action(String description, int number) {
        this.description = description;
        this.number = number;
    }
    @Override
    public String toString() {
        return description;
    }

}
