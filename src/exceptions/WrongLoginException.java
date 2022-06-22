package exceptions;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String string) {
        super(string);

    }
}