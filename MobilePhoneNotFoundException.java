public class MobilePhoneNotFoundException extends Exception
{
    private String message = null;

    public MobilePhoneNotFoundException() {
        super();
    }

    public MobilePhoneNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public MobilePhoneNotFoundException(Throwable cause) {
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