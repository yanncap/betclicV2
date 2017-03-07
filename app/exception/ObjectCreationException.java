package exception;

/**
 * Created by formation on 07/03/17.
 */
public class ObjectCreationException extends Exception {

    public ObjectCreationException(String message){
        super(message);
    }

    public ObjectCreationException(String message, Throwable cause){
        super(message, cause);
    }
}
