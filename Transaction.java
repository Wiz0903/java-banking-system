/**
 * Main application class that provides an interactive menu for managing a BankAccount.
 * Demonstrates OOP principles by using the BankAccount class in a real-world scenario.
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Transaction {
   public static void main(String[] args) {
      // Create Scanner to read user input from the console
      Scanner input = new Scanner(System.in);
      double amount; // Stores the transaction amount
      int choice = 0; // Stores the user's menu selection
      
      // Initialize two sample bank accounts with names and starting balances
      BankAccount account1 = new BankAccount("Tshokolo", 200);
      BankAccount account2 = new BankAccount("Karabo", 1000);
      
      // Prompt user to select which account to manage for this session
      System.out.println("Which account? (1) Tshokolo (2) Karabo");
      int accountChoice = input.nextInt();
      
      // Main menu loop — runs until user chooses to exit (option 6)
      while (choice != 6) {
         System.out.println("1. Deposit  2. Withdraw  3. Transfer 4. Check Balance 5. Check Transaction Log 6. Exit");
         System.out.print("Choose option: ");
         try {
             choice = input.nextInt();
         } catch (InputMismatchException e) {
             System.out.println("Invalid menu option. Please enter a number (1-6).");
             input.next(); // clear invalid input
             continue; // skip to next loop iteration
         }
         
         // Route actions based on the selected account
         switch (accountChoice) {
            case 1:
               // Perform operations on Tshokolo's account
               switch (choice) {
                  case 1:
                     // Handle deposit: read amount and update balance
                     System.out.print("Enter amount: ");
                     try {
                        amount = input.nextDouble();
                        account1.deposit(amount);
                     // Handle non-numeric input gracefully and clear scanner buffer
                     } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        input.next();
                     }
                     break;
                  case 2:
                     // Handle withdrawal: read amount and attempt to deduct
                     System.out.print("Enter amount: ");
                     try {
                        amount = input.nextDouble();
                        account1.withdraw(amount);
                     // Handle non-numeric input gracefully and clear scanner buffer
                     } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        input.next();
                     }
                     break;
                  case 3:
                     // Handle transfer: read amount and attempt to deduct
                     System.out.print("Enter amount: ");
                     try {
                        amount = input.nextDouble();
                        account1.transfer(account2, amount);
                     // Handle non-numeric input gracefully and clear scanner buffer
                     } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        input.next();
                     }
                     break;
                  case 4:
                     // Display account holder name and formatted balance
                     System.out.println(account1.getAccountHolder() + "'s balance: R" + account1.getBalance());
                     break;
                  case 5:
                     // Display full transaction history for this account
                     account1.printStatement();
                     break;
            
                  // Option 6: Exit loop (no action needed — loop condition handles exit)
               }
               break;
           case 2:
               // Perform operations on Karabo's account
               switch (choice) {
                  case 1:
                     // Handle deposit: read amount and update balance
                     System.out.print("Enter amount: ");
                     try {
                        amount = input.nextDouble();
                        account2.deposit(amount);
                     // Handle non-numeric input gracefully and clear scanner buffer
                     } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        input.next();
                     }
                     break;
                  case 2:
                     // Handle withdrawal: read amount and attempt to deduct
                     System.out.print("Enter amount: ");
                     try {
                        amount = input.nextDouble();
                        account2.withdraw(amount);
                     // Handle non-numeric input gracefully and clear scanner buffer
                     } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        input.next();
                     }
                     break;
                  case 3:
                     // Handle transfer: read amount and attempt to deduct
                     System.out.print("Enter amount: ");
                     try {
                        amount = input.nextDouble();
                        account2.transfer(account1, amount);
                     // Handle non-numeric input gracefully and clear scanner buffer
                     } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        input.next();
                     }
                     break;
                  case 4:
                     // Display account holder name and formatted balance
                     System.out.println(account2.getAccountHolder() + "'s balance: R" + account2.getBalance());
                     break;
                  case 5:
                     // Display full transaction history for this account
                     account2.printStatement();
                     break;
            
                  // Option 6: Exit loop (no action needed — loop condition handles exit)
               }
               break;
            default:
               // Handle invalid account selection
               System.out.println("Invalid account selection.");
          }
     }
      // Close scanner to free system resources and prevent memory leaks
      input.close();
   }
}
