package radarCriminal.validation;

public class radarException extends RuntimeException {

    public radarException() {
        super();
    }
    public radarException(String message, Throwable cause) {
        super(message, cause);
    }
    public radarException(String message) {
        super(message);
    }

    public radarException(Throwable cause) {
        super(cause);
    }
}
