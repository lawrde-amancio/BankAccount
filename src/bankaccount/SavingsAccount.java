package bankaccount;

/**
 * Represents the savings account and the owner.
 */
public class SavingsAccount extends BankAccount  {
    public SavingsAccount(String ownerName) {
        super(ownerName);
    }

    public String getOwnerName() {
        return getAccountHolderName();
    }
}
