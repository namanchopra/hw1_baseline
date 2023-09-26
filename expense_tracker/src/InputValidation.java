import java.util.List;
import java.util.Arrays;

public class InputValidation {
    
    private static final List<String> VALID_CATEGORIES = Arrays.asList("food", "travel", "bills", "entertainment", "other");

    public static void validateAmount(double amount) throws IllegalArgumentException {
        if (amount < 0 || amount > 1000) {
            throw new IllegalArgumentException("Amount must be greater than 0 and less than 1000.");
        }
    }

    public static void validateCategory(String category) throws IllegalArgumentException {
        if (!VALID_CATEGORIES.contains(category.toLowerCase())) {
            throw new IllegalArgumentException("Invalid category. Please choose from: food, travel, bills, entertainment, other.");
        }
    }
}