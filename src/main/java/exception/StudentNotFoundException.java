package exception;

public class StudentNotFoundException extends StudentException{

    public StudentNotFoundException(){
        super();
    }

    public StudentNotFoundException(String message){
        super(message);
    }
}
