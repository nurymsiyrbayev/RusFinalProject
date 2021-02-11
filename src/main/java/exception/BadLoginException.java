package exception;

public class BadLoginException extends Exception {
    public BadLoginException(String errorMessage) {
        super(errorMessage);
    }
}