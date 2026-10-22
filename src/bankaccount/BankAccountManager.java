package bankaccount;

import java.util.HashMap;
import java.util.Map;

public class BankAccountManager implements Bank {
    private Map<Integer, BankAccount> accounts;
    private int id;
    private static final int MAX_ACCOUNTS = 100;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

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

    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accountId = entry.getKey();
            BankAccount acc = entry.getValue();
            System.out.println("Account ID: " + accountId + 
                               ", Account Name: " + acc.getAccountHolderName() + 
                               ", Balance: " + String.format("%.2f", acc.getBalance()));
        }
    }
    

}
