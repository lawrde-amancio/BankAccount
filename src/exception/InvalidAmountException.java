package exception;

/**
 * InvalidAmountException.
 */
public class InvalidAmountException extends Exception {
    private String message;

    public InvalidAmountException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
