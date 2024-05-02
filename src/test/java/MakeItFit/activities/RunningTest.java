import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Running;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The tests for the Running class.
 *
 * These tests verify the functionality of the Running class, which represents a running activity in the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class RunningTest {
    /**
     * Tests the Running class constructors.
     */
    @Test
    public void testConstructors() {
        UUID UUID = java.util.UUID.randomUUID();
        Running run1 = new Running(UUID, MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", 2300, 14.5);
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
        UUID UUID = java.util.UUID.randomUUID();
        Running run1 = new Running(UUID, MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", 2300, 14.5);
        assertEquals(14.5, run1.getSpeed());
    }

    /**
     * Tests the setSpeed method of the Running class.
     */
    @Test
    public void testSetSpeed() {
        UUID UUID = java.util.UUID.randomUUID();
        Running run1 = new Running(UUID, MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", 2300, 14.5);
        run1.setSpeed(12.0);
        assertEquals(12.0, run1.getSpeed());
    }

    /**
     * Tests the calculateCaloricWaste method of the Running class.
     */
    @Test
    public void testCalculateCaloricWaste() {
        UUID UUID = java.util.UUID.randomUUID();
        Running run1 = new Running(UUID, MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", 2300, 14.5);
        int expectedCaloricWaste = 33350;
        assertEquals(expectedCaloricWaste, run1.calculateCaloricWaste());
    }

    /**
     * Tests the equals method of the Running class.
     */
    @Test
    public void testEquals() {
        UUID UUID = java.util.UUID.randomUUID();
        UUID UUID2 = java.util.UUID.randomUUID();
        Running run1 = new Running(UUID, MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", 2300, 14.5);
        Running run2 = new Running(UUID2, MakeItFitDate.of(2024, 4, 4), 45, "Braga em Movimento", 2300, 14.5);
        assertFalse(run1.equals(null));
        assertTrue(run1.equals(run2));
    }
}
