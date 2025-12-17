package exception;

public class InvalidGradeException extends StudentException{

    public InvalidGradeException(){
        super();
    }

    public InvalidGradeException(String message){
        super(message);
    }
}
