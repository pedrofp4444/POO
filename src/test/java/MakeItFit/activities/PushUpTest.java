import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.PushUp;
import org.junit.jupiter.api.Test;

/**
 * The tests for the PushUp class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class PushUpTest {
    /**
     * Tests the PushUp class constructors.
     */
    @Test
        public void testConstructors() {
            PushUp pushUp1 = new PushUp();
            assertNotNull(pushUp1);
            PushUp pushUp2 = new PushUp(30, "Daily try", 10, 10);
            assertNotNull(pushUp2);
            PushUp pushUp3 = new PushUp(pushUp1);
            assertNotNull(pushUp3);
        }

    /**
     * Tests the PushUp class method calculateCaloricWaste.
     */
    @Test
    public void testCalculateCaloricWaste() {
        PushUp pushUp1 = new PushUp(30, "Daily try",10, 10);
        assertEquals(50, pushUp1.calculateCaloricWaste());
        PushUp pushUp2 = new PushUp(30, "Daily try",5, 25);
        assertEquals(62, pushUp2.calculateCaloricWaste());
    }

    /**
     * Tests the PushUp class method equals.
     */
    @Test
    public void testEquals(){
        PushUp pushUp1 = new PushUp(30, "Daily try",10,10);
        assertFalse(pushUp1.equals(null));
        PushUp pushUp2 = new PushUp(30, "Daily try",10,10);
        assertTrue(pushUp1.equals(pushUp2));
    }
}
