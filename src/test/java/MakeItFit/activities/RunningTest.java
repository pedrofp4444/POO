import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Running;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.users.types.Amateur;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The tests for the Running class.
 *
 * These tests verify the functionality of the Running class, which represents a running activity in the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class RunningTest {
    /**
     * Tests the Running class constructors.
     */
    @Test
    public void testConstructors() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Running run1 = new Running(user.getCode(), MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", "Running", 2300, 14.5);
        assertNotNull(run1);
        assertEquals(14.5, run1.getSpeed());
        Running run3 = new Running(run1);
        assertNotNull(run3);
        assertEquals(14.5, run3.getSpeed());
    }

    /**
     * Tests the getSpeed method of the Running class.
     */
    @Test
    public void testGetSpeed() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Running run1 = new Running(user.getCode(), MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", "Running", 2300, 14.5);
        assertEquals(14.5, run1.getSpeed());
    }

    /**
     * Tests the setSpeed method of the Running class.
     */
    @Test
    public void testSetSpeed() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Running run1 = new Running(user.getCode(), MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", "Running", 2300, 14.5);
        run1.setSpeed(12.0);
        assertEquals(12.0, run1.getSpeed());
    }

    /**
     * Tests the calculateCaloricWaste method of the Running class.
     */
    @Test
    public void testCalculateCaloricWaste() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Running run1 = new Running(user.getCode(), MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", "Runnign", 2300, 14.5);
        int expectedCaloricWaste = 3873;
        run1.calculateCaloricWaste(user.getIndex());
        assertEquals(expectedCaloricWaste, run1.getCaloricWaste());
    }

    /**
     * Tests the equals method of the Running class.
     */
    @Test
    public void testEquals() {
        User user1 = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        User user2 = new Amateur("Erica", 25, Gender.Female, 56, 164, 75, 2, "Wallstreet N18", "972233536", "erica@mail.com");

        Running run1 = new Running(user1.getCode(), MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", "Running", 2300, 14.5);
        Running run2 = new Running(user2.getCode(), MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", "Running", 2300, 14.5);
        assertNotEquals(null, run1);
        assertEquals(run1, run2);
    }
}
