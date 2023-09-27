

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

/**
 * The ExpenseTrackerView class accounts for the MVC structure of the app and manipulates user inputs
 * It does so by using the JFrame class for creating the UI of the app.
 * The User inputs are then stored in private variables that create a list for transactions which stores every transaction detail.
 */
public class ExpenseTrackerView extends JFrame {

  // Private variables used
  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  
  // Returns the Transaction Table
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  // Returns the value in the amount field
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  // Sets the amountfield
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  // Returns the category field
  public String getCategoryField() {
    return categoryField.getText();
  }

  // Sets the category field
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  // Gets the transaction button
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  //Returns the model of the table
  public DefaultTableModel getTableModel() {
    return model;
  }

  // The mainframe for the View to the useer in the MVC structure and UI of the app
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  // Refreshes the transaction table with changes that are made after the last call
  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  // calls the refreshTable method
  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  // returns the transactions table
  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  // Adds the transaction to the transaction list and refreshes
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }
  


  // Other view methods
}
