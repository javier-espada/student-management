package exception;

public class NoGradesException extends StudentException{

    public NoGradesException(){
        super();
    }

    public NoGradesException(String message){
        super(message);
    }
}
