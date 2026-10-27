package bankaccount;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the bank account, deposit, withdraw, getBalance, Freeze, unFreeze
 * and isFrozen.
 */
public class BankAccount {
    private double balance;
    private boolean isFrozen;
    private String accountHolderName;
    private List<Transaction> transactionHistory;
    private String accountFrozenMessage = 
    "Account is FROZEN. Unable to transact.";
    private String invalidAmountMessage = 
    "Invalid amount. Must be greater than 0";
    private String insufficientFundMessage = "Insufficient balance.";

    /**
     * Bank Account.
     *
     * @param accountHolderName Represents the Bank Account.
     */
    public BankAccount(String accountHolderName) {
        this.balance = 0.0;
        this.isFrozen = false;
        this.accountHolderName = accountHolderName;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Deposit function.
     *
     * @param amount Represents the amount Deposit function.
     */
    public void deposit(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(accountFrozenMessage);
            }
            System.out.printf("Amount deposited: %.2f\n", amount);
            if (amount <= 0) {
                throw new InvalidAmountException(invalidAmountMessage);
            }

            balance += amount;
            System.out.printf("Current balance: %.2f\n", balance);
            transactionHistory.add(new Transaction("Deposit", amount));

        } catch (AccountFrozenException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Withdraw function.
     *
     * @param amount Represents the amount Withdraw function.
     */
    public void withdraw(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(accountFrozenMessage);
            }

            System.out.printf("Amount withdrawn: %.2f\n", amount);

            if (amount <= 0) {
                throw new InvalidAmountException(invalidAmountMessage);
            }

            if (amount > balance) {
                System.out.printf("Current balance: %.2f\n", balance);
                throw new InsufficientFundsException(insufficientFundMessage);
            }

            balance -= amount;
            System.out.printf("Current balance: %.2f\n", balance);
            transactionHistory.add(new Transaction("Withdraw", amount));

        } catch (AccountFrozenException | InvalidAmountException 
            | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Represents the printing of Transaction History.
     */
    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

}
