package exception;

public abstract class  StudentException extends Exception{

    public StudentException() {
        super();
    };

    public StudentException(String message) {
        super(message);
    };
}
