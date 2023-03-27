package budget;
import java.util.*;
public enum Action {
    ADD_INCOME("Add income", 1),
    ADD_PURCHASE("Add purchase", 2),
    LIST_OF_PURCHASES("Show list of purchases", 3),
    BALANCE("Balance", 4),
    SAVE("Save", 5),
    LOAD("Load", 6),
    EXIT("Exit", 0);
    private final String description;
    private final int number;
    Action(String description, int number) {
        this.description = description;
        this.number = number;
    }
    @Override
    public String toString() {
        return description;
    }

}
