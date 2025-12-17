package exception;

public class DuplicateStudentException extends StudentException {

    public DuplicateStudentException(){
        super();
    }

    public DuplicateStudentException(String message){
        super(message);
    }
}
