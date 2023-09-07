package co.edu.uco.comun.exceptions;

import java.io.Serial;

public class DuplicityException extends RuntimeException{
    @Serial
    private static final long serialVersionUID=1L;
    public DuplicityException(String message){
        super(message);
    }
}
