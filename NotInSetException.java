public class NotInSetException extends Exception
{
    private String message;

    public NotInSetException() {
        super();
    }

    public NotInSetException(String message) {
        super(message);
        this.message = message;
    }

    public NotInSetException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}