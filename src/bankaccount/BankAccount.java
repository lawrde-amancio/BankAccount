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
            System.out.println("Account is frozen. Cannot deposit.");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is frozen. Cannot withdraw.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Cannot withdraw.");
            return;
        }
        balance -= amount;
    }

    public void getBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void freezeAccount() {
        isFrozen = true;
        System.out.println("Account has been frozen.");
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
