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
     * @param type Represent the Transaction type.
     * @param amount Represent the Transaction amount.
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();

    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = time_stamp.format(formatter);

        return "Transaction [Type=" + type + ", Amount=" 
        + amount + ", Timestamp=" + formattedTime + "]";
    }

     public double getAmount() {
        return amount;
    }
    
}
