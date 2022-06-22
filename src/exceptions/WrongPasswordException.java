package exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String string) {
        super(string);
    }
}
