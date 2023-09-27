import java.util.List;
import java.util.Arrays;

/** 
 * The InputValidation class takes caring of checking user input and setting constraints to it
 */
public class InputValidation {
    
    private static final List<String> VALID_CATEGORIES = Arrays.asList("food", "travel", "bills", "entertainment", "other");

    // This method checks if the amount input meets the constraints of the app
    public static void validateAmount(double amount) throws IllegalArgumentException {
        if (amount <= 0 || amount >= 1000) {
            throw new IllegalArgumentException("Amount must be greater than 0 and less than 1000.");
        }
    }

    // This method checks if the category input is one of the options from the list of appropriate categories
    public static void validateCategory(String category) throws IllegalArgumentException {
        if (!VALID_CATEGORIES.contains(category.toLowerCase())) {
            throw new IllegalArgumentException("Invalid category. Please choose from: food, travel, bills, entertainment, other.");
        }
    }
}