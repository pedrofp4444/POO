import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The tests for the PushUp class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class PushUpTest {
    /**
     * Tests the PushUp class constructors.
     */
    @Test
        public void testConstructors() {
            UUID UUID = java.util.UUID.randomUUID();
            PushUp pushUp1 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", 10, 10);
            assertNotNull(pushUp1);
            PushUp pushUp2 = new PushUp(pushUp1);
            assertNotNull(pushUp2);
        }

    /**
     * Tests the creation of PushUp instances using different constructors.
     */
    @Test
    public void testPushUpConstructors() {
        UUID UUID = java.util.UUID.randomUUID();
        PushUp pushUp1 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", 10, 10);
        assertNotNull(pushUp1, "PushUp instance should be created successfully.");

        PushUp pushUp2 = new PushUp(pushUp1);
        assertNotNull(pushUp2, "Copy constructor should create a non-null instance.");
        assertEquals(pushUp1, pushUp2, "Copy constructor should create an equal instance.");
    }

    /**
     * Tests the calculation of caloric waste for PushUp instances.
     */
    @Test
    public void testCalculateCaloricWaste() {
        UUID UUID = java.util.UUID.randomUUID();
        PushUp pushUp1 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", 10, 10);
        int expectedWaste1 = 50;
        assertEquals(expectedWaste1, pushUp1.calculateCaloricWaste(), "Caloric waste should match the expected value.");

        UUID UUID2 = java.util.UUID.randomUUID();
        PushUp pushUp2 = new PushUp(UUID2, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", 5, 25);
        int expectedWaste2 = 62;
        assertEquals(expectedWaste2, pushUp2.calculateCaloricWaste(), "Caloric waste should match the expected value.");
    }

    /**
     * Tests the equals method for PushUp instances.
     */
    @Test
    public void testPushUpEquals() {
        UUID UUID = java.util.UUID.randomUUID();
        PushUp pushUp1 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", 10, 10);
        assertFalse(pushUp1.equals(null), "PushUp instance should not be equal to null.");

        UUID UUID2 = java.util.UUID.randomUUID();
        PushUp pushUp2 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", 10, 10);
        assertTrue(pushUp1.equals(pushUp2), "PushUp instances with the same properties should be equal.");
    }
}
