package salary.payment.exceptions;

public class InsufficientInventoryException extends Exception {
    public InsufficientInventoryException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InsufficientInventoryException() {
    }

    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


}

