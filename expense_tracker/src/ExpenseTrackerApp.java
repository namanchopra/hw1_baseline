import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
       // Get transaction data from view
       double amount;
       String category;
      
       // Run the model and validate the user inputs
       try {
         amount = view.getAmountField();
         InputValidation.validateAmount(amount);
         
         category = view.getCategoryField();
         InputValidation.validateCategory(category);
 
         Transaction t = new Transaction(amount, category);
 
         view.addTransaction(t);
 
      } catch(NumberFormatException x) {
         
         JOptionPane.showMessageDialog(new JFrame(), "Invalid input for amount. Please enter a valid number.");
 
      } catch(IllegalArgumentException x){
 
         JOptionPane.showMessageDialog(new JFrame(), x.getMessage());
         
      }
     });

  }

}