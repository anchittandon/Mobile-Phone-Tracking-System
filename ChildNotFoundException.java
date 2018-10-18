public class ChildNotFoundException extends Exception
{
    private String message = null;

    public ChildNotFoundException() {
        super();
    }

    public ChildNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ChildNotFoundException(Throwable cause) {
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