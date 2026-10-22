package bankaccount;

/**
 * Main.
 */
public class Main {

    /**
     * Test cases.
     *
     * @param args Run test cases.
     */
    public static void main(String[] args) {

        //TEST CASES//

        // 1. Create a savings account
        BankAccount acc1 = new SavingsAccount("Test0");
        SavingsAccount owner = (SavingsAccount) acc1;
        System.out.println("Account Owner: " + owner.getOwnerName() + ".");

        // 2. Deposit with valid amount
        acc1.deposit(1000.125);

        // 3. Deposit with zero amount
        // acc1.deposit(0);

        // 4. Deposit with negative amount
        // acc1.deposit(-500);

        // 5. Withdraw with sufficient funds
        // acc1.withdraw(500);

        // 6. Withdraw with insufficient funds
        // acc1.withdraw(1500);

        // 7. Withdraw with negative amount
        // acc1.withdraw(-100);

        // 8. Deposit when account is frozen
        // acc1.freezeAccount();
        // acc1.deposit(11500);

        // 9. Withdraw when account is frozen
        // acc1.withdraw(500);

        // 10. Unfreeze account and withdraw
        // acc1.unfreezeAccount();
        // acc1.withdraw(100);


        //EXERCISE 2//
        //1. Display transaction history of acc1.

        acc1.printTransactionHistory();




    }
}
