public class Exceptions{

class NotInSetException extends Exception
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

class MobilePhoneSwitchedOffException extends Exception
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

class MobilePhoneNotFoundException extends Exception
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
class ExchangeNotFoundException extends Exception
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
class ChildNotFoundException extends Exception
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

class MobilePhoneAlreadyOnException extends Exception
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
}
