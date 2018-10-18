public class MobilePhoneAlreadyOnException extends Exception
{
    private String message = null;

    public MobilePhoneAlreadyOnException() {
        super();
    }

    public MobilePhoneAlreadyOnException(String message) {
        super(message);
        this.message = message;
    }

    public MobilePhoneAlreadyOnException(Throwable cause) {
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