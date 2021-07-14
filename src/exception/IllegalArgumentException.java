package exception;

import javax.servlet.ServletException;

public class IllegalArgumentException extends ServletException {
    private static final long serialVersionUID = 1L;

    public IllegalArgumentException() {
        super();
    }

    public IllegalArgumentException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(Throwable rootCause) {
        super(rootCause);
    }
}
