public class ExchangeNotFoundException extends Exception
{
    private String message = null;

    public ExchangeNotFoundException() {
        super();
    }

    public ExchangeNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ExchangeNotFoundException(Throwable cause) {
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