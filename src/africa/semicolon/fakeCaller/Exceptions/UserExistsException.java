package africa.semicolon.fakeCaller.Exceptions;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String s) {
        super(s);
    }
}
