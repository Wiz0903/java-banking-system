# Java OOP Banking System

A console-based banking application built in Java demonstrating core OOP principles:
- Encapsulation
- Classes and objects
- Transaction logging
- Safe deposit/withdraw logic

## Features
- ✅ **Account management**: Create accounts with names and starting balances  
- ✅ **Secure transactions**: Deposit, withdraw, and **transfer between accounts**  
- ✅ **Dual-side logging**: Both sender and receiver see personalized records (e.g., "Transferred R50 to Karabo" / "Received R50 from Tshokolo")  
- ✅ **Dynamic transaction history**: Unlimited log entries (no 100-entry limit)  
- ✅ **Robust error handling**: Prevents negative amounts, insufficient funds, and invalid transfers

## How to Run
```bash
javac BankAccount.java Transaction.java
java Transaction
