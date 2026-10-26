package bankaccount;

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

    // public BankAccount() {
    // this("Unknown");
    // }

    public BankAccount(String accountHolderName) {
        this.balance = 0.0;
        this.isFrozen = false;
        this.accountHolderName = accountHolderName;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Deposit function.
     *
     * @param amount Deposit amount.
     */
    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        }

        if (amount == 0 || amount < 0) {
            System.out.printf("Amount deposited: %.1f\n", amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else {
            balance += amount;
            System.out.printf("Amount deposited: %.2f\n", amount);
            System.out.printf("Current balance: %.2f\n", balance);
            transactionHistory.add(new Transaction("Deposit", amount));
        }

    }

    /**
     * Withdraw function.
     *
     * @param amount Withdraw amount.
     */
    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        }

        if (amount <= 0) {
            System.out.printf("Amount withdrawn: %.1f\n", amount);
            System.out.printf("Invalid amount. Must be greater than 0\n");

        } else if (amount > balance) {
            System.out.printf("Amount withdrawn: %.1f\n", amount);
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: %.2f\n", balance);

        } else if (amount <= balance) {
            System.out.printf("Amount withdrawn: %.1f\n", amount);
            balance -= amount;
            System.out.printf("Current balance: %.2f\n", balance);
            transactionHistory.add(new Transaction("Withdraw", amount));
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
        System.out.println("Account has been unfrozen.");
    }

    /**
     * Frozen.
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

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
