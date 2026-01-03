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
    * Transfers a specified amount from this account to another BankAccount.
    * Ensures the transfer is valid by checking for positive amount and sufficient funds.
    * Both accounts are updated atomically: if one step fails, no changes are made.
    * 
    * @param recipient The destination BankAccount to receive funds (must not be null)
    * @param amount    The amount to transfer (must be greater than zero)
    */
   public void transfer(BankAccount recipient, double amount) {
      // Validate that the recipient account is not null
      if (recipient == null) {
         System.out.println("Error: Recipient account is invalid.");
         return;
      }
      
      // Validate that the transfer amount is positive
      if (amount > 0) {
         // Check if this account has sufficient balance for the transfer
         if (balance >= amount) {
            // Deduct the amount from this account's balance
            balance -= amount;
            // Add the amount to the recipient's balance
            recipient.receiveTransfer(this, amount); // sender passes itself

            if (transactionCount < 100) {
               transactionLog[transactionCount] = "Transferred R" + amount + " to " + recipient.getAccountHolder();
               transactionCount++;
            }
         } else {
            // Inform user when balance is too low to complete transfer
            System.out.println("Insufficient funds available");
         }
      } else {
         // Inform user that transfer amount must be positive
         System.out.println("Amount must be positive");
      }
   }

   /**
    * Handles an incoming transfer from another account.
    * This method is called internally by the sender's transfer() method
    * and should not be invoked directly by users.
    * 
    * @param sender The BankAccount that is sending funds
    * @param amount The amount being received (assumed valid and positive)
    */
   public void receiveTransfer(BankAccount sender, double amount) {
      // Add the incoming amount to this account's balance
      balance += amount;
      
      // Log the incoming transfer if space is available in the transaction log
      if (transactionCount < 100) {
          transactionLog[transactionCount] = "Received R" + amount + " from " + sender.getAccountHolder();
          transactionCount++; // Increment log index to preserve order
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
