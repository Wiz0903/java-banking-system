/**
 * A class representing a bank account with basic transaction capabilities.
 * Encapsulates account holder name and balance, and provides safe deposit/withdrawal logic.
 */
public class BankAccount {
   // Private fields ensure data integrity — only accessible through methods
   private String accountHolder;
   private double balance;
   private String[] transactionLog = new String[100]; // max 100 transactions
   private int transactionCount = 0;
   
   /**
    * Constructor to create a new bank account.
    * @param name The name of the account holder
    * @param balance The initial account balance (should be >= 0)
    */
   public BankAccount(String name, double balance) {
      this.accountHolder = name;
      this.balance = balance;
   }
   
   /**
    * Deposits a positive amount into the account.
    * @param amount The amount to deposit (must be > 0)
    */
   public void deposit(double amount) {
      if (amount > 0) {
         balance += amount;
         // Log the deposit if there's space in the transaction history
         if (transactionCount < 100) {
            transactionLog[transactionCount] = "Deposited " + amount;
            transactionCount++;
         }
      } else {
         System.out.println("Amount must be positive");
      }
   }
   
   /**
    * Withdraws an amount if sufficient funds are available.
    * @param amount The amount to withdraw
    */
   public void withdraw(double amount) {
      if (balance >= amount) {
         balance -= amount;
         System.out.println("Withdrew " + amount + ". New balance: " + balance);
         // Log the withdrawal if there's space in the transaction history
         if (transactionCount < 100) {
            transactionLog[transactionCount] = "Withdrew " + amount;
            transactionCount++;
         }
      } else {
         System.out.println("Insufficient funds available");
      }
   }
   
   /**
    * Returns the account holder's name.
    * @return The name of the account holder
    */
   public String getAccountHolder() {
      return accountHolder;
   }
   
   /**
    * Returns the current account balance.
    * @return The current balance
    */
   public double getBalance() {
      return balance;
   }
   
   /**
    * Prints the full transaction history for this account.
    * Displays a numbered list of all recorded transactions, or a message if none exist.
    */
   public void printStatement() {
      if (transactionCount == 0) {
        System.out.println("No transactions yet.");
      } else {
        System.out.println("Transaction History:");
        // Iterate through all logged transactions and print them with numbering
        for (int i = 0; i < transactionCount; i++) {
            System.out.println((i + 1) + ". " + transactionLog[i]);
        }
      }
   }
 }