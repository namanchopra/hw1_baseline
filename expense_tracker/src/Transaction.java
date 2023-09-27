

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The Transaction class creates a transaction object to be used in the list of transaction for the app.
 */
public class Transaction {

  private double amount;
  private String category;
  private String timestamp;

  // Constructor
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  // Returns the amount for the transaction
  public double getAmount() {
    return amount;
  }

  // Sets the amount for the transaction
  public void setAmount(double amount) {
    this.amount = amount;
  }

  // Returns the category for the transaction
  public String getCategory() {
    return category;
  }

  // Sets the catefory for the transaction
  public void setCategory(String category) {
    this.category = category; 
  }
  
  // Returns the timestamp for the transaction
  public String getTimestamp() {
    return timestamp;
  }

  // Generates the catefory for the transaction
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}