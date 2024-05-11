package MakeItFit.exceptions;

/**
 * The ExistingEntityConflictException class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class ExistingEntityConflictException extends RuntimeException {

    /**
     * The empty constructor for ExistingEntityConflictException.
     */
    public ExistingEntityConflictException() { super(); }

    /**
     * The parameterized constructor for ExistingEntityConflictException.
     */
    public ExistingEntityConflictException(String exception) { super(exception); }
}
