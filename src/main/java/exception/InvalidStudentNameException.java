package exception;

public class InvalidStudentNameException extends StudentException{

    public InvalidStudentNameException(){
        super();
    }

    public InvalidStudentNameException(String message){
        super(message);
    }
}
