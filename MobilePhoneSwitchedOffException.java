public class MobilePhoneSwitchedOffException extends Exception
{
    private String message = null;

    public MobilePhoneSwitchedOffException() {
        super();
    }

    public MobilePhoneSwitchedOffException(String message) {
        super(message);
        this.message = message;
    }

    public MobilePhoneSwitchedOffException(Throwable cause) {
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