import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.activities.implementation.Running;
import org.junit.jupiter.api.Test;

/**
 * The tests for the Running class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class RunningTest {
    /**
     * Tests the Running class constructors.
     */
    @Test
    public void testConstructors() {
        Running run1 = new Running();
        assertNotNull(run1);
        assertEquals(run1.getSpeed(), 0);
        Running run2 = new Running(45, "Braga em Movimento", 2300, 14.5);
        assertNotNull(run2);
        assertEquals(run2.getSpeed(), 14.5);
        Running run3 = new Running(run1);
        assertNotNull(run3);
        assertEquals(run3.getSpeed(), 0);
    }

    /**
     * Tests the Running class method getSpeed.
     */
    @Test
    public void testGetSpeed() {
        Running run1 = new Running();
        assertEquals(run1.getSpeed(), 0);
    }

    /**
     * Tests the Running class method setSpeed.
     */
    @Test
    public void testSetSpeed() {
        Running run1 = new Running();
        run1.setSpeed(12);
        assertEquals(run1.getSpeed(), 12);
    }

    /**
     * Tests the Running class method calculateCaloricWaste.
     */
    @Test
    public void testCalculateCaloricWaste() {
        Running run1 = new Running(45, "Braga em Movimento", 2300, 14.5);
        assertEquals(run1.calculateCaloricWaste(), 33350);
    }

    /**
     * Tests the Running class method equals.
     */
    @Test
    public void testEquals(){
        Running run1 = new Running(45, "Braga em Movimento", 2300, 14.5);
        assertFalse(run1.equals(null));
        Running run2 = new Running(45, "Braga em Movimento", 2300, 14.5);
        assertTrue(run1.equals(run2));
    }
}
