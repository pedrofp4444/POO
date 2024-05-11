import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.users.types.Amateur;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The tests for the PushUp class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class PushUpTest {
    /**
     * Tests the PushUp class constructors.
     */
    @Test
        public void testConstructors() {
            UUID UUID = java.util.UUID.randomUUID();
            PushUp pushUp1 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 40, "Daily try", "PushUp", 10, 4);
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
        PushUp pushUp1 = new PushUp(UUID, MakeItFitDate.of(2024, 4, 4), 30, "Daily try", "PushUp", 10, 10);
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
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        PushUp pushUp1 = new PushUp(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Daily try", "PushUp", 10, 10);
        int expectedWaste1 = 232;
        pushUp1.calculateCaloricWaste(user.getIndex());
        assertEquals(expectedWaste1, pushUp1.getCaloricWaste(), "Caloric waste should match the expected value.");

        PushUp pushUp2 = new PushUp(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Daily try", "PushUp", 5, 25);
        int expectedWaste2 = 290;
        pushUp2.calculateCaloricWaste(user.getIndex());
        assertEquals(expectedWaste2, pushUp2.getCaloricWaste(), "Caloric waste should match the expected value.");
    }

    /**
     * Tests the equals method for PushUp instances.
     */
    @Test
    public void testPushUpEquals() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        PushUp pushUp1 = new PushUp(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Daily try", "PushUp", 6, 4);
        assertNotEquals(null, pushUp1, "PushUp instance should not be equal to null.");

        PushUp pushUp2 = new PushUp(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Daily try", "PushUp", 6, 4);
        assertEquals(pushUp1, pushUp2, "PushUp instances with the same properties should be equal.");
    }
}
