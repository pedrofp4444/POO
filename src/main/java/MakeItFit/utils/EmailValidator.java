package MakeItFit.utils;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * The class EmailValidator verifies the email.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class EmailValidator implements Serializable {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    /**
     * Verifies if the email is valid.
     */
    public static boolean isValidEmail(String emailString) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(emailString).matches();
    }
}
