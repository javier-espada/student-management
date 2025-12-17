package exception;

public class InvalidGradeException extends StudentException{

    public InvalidGradeException(){
        super();
    }

    public InvalidGradeException(double grade){
        super(String.valueOf(grade));
    }
}
