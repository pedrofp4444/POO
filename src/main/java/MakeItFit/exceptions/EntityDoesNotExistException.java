package MakeItFit.exceptions;

/**
 * The EntityDoesNotExistException class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class EntityDoesNotExistException extends RuntimeException {

    /**
     * The empty constructor for EntityDoesNotExistException.
     */
    public EntityDoesNotExistException() { super(); }

    /**
     * The parameterized constructor for EntityDoesNotExistException.
     */
    public EntityDoesNotExistException(String exception) { super(exception); }
}
