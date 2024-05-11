package MakeItFit.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.utils.MakeItFitDate;
/**
 * The tests for the EmailValidator class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class EmailValidatorTest {

        /**
        * Tests the EmailValidator class method isValid.
        */
        @Test
        public void testIsValid() {
            assertTrue(EmailValidator.isValidEmail("jonh@mail.com"));
            assertTrue(EmailValidator.isValidEmail("erica@gmail.com"));
            assertFalse(EmailValidator.isValidEmail("jonhmail.com"));
            assertFalse(EmailValidator.isValidEmail("erica@gmailcom"));
            assertFalse(EmailValidator.isValidEmail("jonh@mailcom"));
            assertFalse(EmailValidator.isValidEmail("ericagmail.com"));
            assertFalse(EmailValidator.isValidEmail("jonhmailcom"));
            assertFalse(EmailValidator.isValidEmail("ericagmailcom"));
        }
}
