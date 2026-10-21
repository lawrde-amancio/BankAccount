package bankaccount;


public class Main {
    public static void main(String[] args) {
        // SavingsAccount account = new SavingsAccount("Darryle");

        // System.out.println(account.getOwnerName());
        BankAccount acc1 = new SavingsAccount("Test0");
        SavingsAccount mySavingsAccount = (SavingsAccount) acc1;
        System.out.println(mySavingsAccount.getOwnerName());
    }
}
