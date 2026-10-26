package bankaccount;

import java.time.LocalDateTime;

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
        return "Transaction [Type=" + type + ", Amount=" + amount + ", Timestamp=" + time_stamp + "]";
    }

     public double getAmount() {
        return amount;
    }
    
}
