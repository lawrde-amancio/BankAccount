package bankaccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * BankAccountManager.
 */
public class BankAccountManager implements Bank {
    private Map<Integer, BankAccount> accounts;
    private int id;
    private static final int MAX_ACCOUNTS = 100;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    /**
     * (non-Javadoc)
     * Bank Accounts.
     *
     * @see bankaccount.Bank#addAccount(bankaccount.BankAccount) Represents adding
     *      of Accounts.
     */
    public void addAccount(BankAccount account) {
        if (accounts.size() >= MAX_ACCOUNTS) {
            System.out.println("Maximum account limit reached.");
            return;
        }
        accounts.put(this.id, account);
        System.out.println("Account added successfully with ID: " + this.id);
        this.id++;
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    /**
     * Represents List of Accounts.
     */
    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accountId = entry.getKey();
            BankAccount acc = entry.getValue();
            System.out.println("Account ID: " + accountId +
                    ", Account Name: " + acc.getAccountHolderName() +
                    ", Balance: " + String.format("%.2f", acc.getBalance()));
        }
    }

    public List<Transaction> filterTransactionsAtOrAbove(
            double amount, List<Transaction> txList) {
        return txList.stream()
                .filter(tx -> tx.getAmount() >= amount)
                .collect(Collectors.toList());
    }

    public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
        return txList.stream()
                .sorted((tx1, tx2) -> Double.compare(tx1.getAmount(), tx2.getAmount()))
                .collect(Collectors.toList());
    }

}
