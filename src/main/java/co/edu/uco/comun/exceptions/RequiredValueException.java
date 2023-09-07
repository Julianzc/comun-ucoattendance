package co.edu.uco.comun.exceptions;

public class RequiredValueException extends RuntimeException{
    public RequiredValueException(String message){
        super(message);
    }
}
