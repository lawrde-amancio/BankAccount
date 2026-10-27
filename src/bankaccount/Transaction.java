package bankaccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * Represents the Transaction Class
 */
public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime time_stamp;

    /**
     * Transaction.
     *
     * @param type   Represent the Transaction type.
     * @param amount Represent the Transaction amount.
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();

    }

    public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    return String.format(
        "Transaction {\n" +
        "  Type      : %s\n" +
        "  Amount    : %.2f\n" +
        "  Date/Time : %s\n" +
        "}",
        type, amount, time_stamp.format(formatter)
    );
}

    public double getAmount() {
        return amount;
    }

}
