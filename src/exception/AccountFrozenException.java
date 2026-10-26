package exception;

public class AccountFrozenException extends Exception {
    private String message;

    public AccountFrozenException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
