package bankaccount;

public class BankAccount {
    public double balance;
    public boolean isFrozen;

    public BankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
    }

    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact");
            return;
        } else if (amount == 0) {
            System.out.printf("Amount deposited: %.1f\n", amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else if (amount < 0) {
            System.out.printf("Amount deposited: %.1f\n", amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else {
            balance += amount;
            System.out.printf("Amount deposited: %.2f\n", amount);
            System.out.printf("Current balance: %.2f\n", balance);
        }

    }

    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        } else if (amount <= 0) {
            System.out.printf("Amount withdrawn: %.1f\n", amount);
            System.out.printf("Invalid amount. Must be greater than 0\n");
        } else if (amount < balance) {
            System.out.printf("Amount withdrawn: %.1f\n", amount);
            balance -= amount;
            System.out.printf("Current balance: %.2f\n", balance);
        } else if (amount > balance) {
            System.out.printf("Amount withdrawn: %.1f\n", amount);
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: %.2f\n", balance);
        }
    }

    public void getBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }

    public void isFrozen() {
        if (isFrozen) {
            System.out.println("Account is currently frozen.");
        } else {
            System.out.println("Account is not frozen.");
        }
    }

}
