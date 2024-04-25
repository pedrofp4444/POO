package MakeItFit.exceptions;

/**
 * The InvalidTypeException class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class InvalidTypeException extends RuntimeException {

    /**
     * The empty constructor for InvalidTypeException.
     */
    public InvalidTypeException() { super(); }

    /**
     * The parameterized constructor for InvalidTypeException.
     */
    public InvalidTypeException(String exception) { super(exception); }
}
