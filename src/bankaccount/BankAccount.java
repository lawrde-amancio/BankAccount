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
    public void deposit(double amount) throws AccountFrozenException, InvalidAmountException  {
        if (isFrozen()) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
            // System.out.println("Account is FROZEN.");
            // System.out.println("Unable to transact.");
            // return;
        }

        if (amount == 0 || amount < 0) {
            System.out.printf("Amount deposited: %.2f\n", amount);
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");
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
     * @param amount Represents the amount Withdraw function.
     */
    public void withdraw(double amount) throws AccountFrozenException, InvalidAmountException, InsufficientFundsException {
        if (isFrozen) {
            throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
        }

        System.out.printf("Amount withdrawn: %.2f\n", amount);

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount. Must be greater than 0");

        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: %.2f\n", balance);
            throw new InsufficientFundsException("Insufficient balance.");

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
