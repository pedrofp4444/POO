import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.WeightSquat;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.users.types.Amateur;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The tests for the WeightSquat class.
 *
 * This class contains tests for the constructors, methods, and operations of the WeightSquat class,
 * including tests for construction, calculating caloric waste, and object equality.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class WeightSquatTest {

    /**
     * Tests the WeightSquat class constructors.
     */
    @Test
    public void testConstructors() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        WeightSquat squat1 = new WeightSquat(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", "WeightSquat", 20, 3, 50);
        assertNotNull(squat1, "WeightSquat instance should be created successfully.");

        WeightSquat squat3 = new WeightSquat(squat1);
        assertNotNull(squat3, "Copy of WeightSquat instance should be created successfully.");
    }

    /**
     * Tests the WeightSquat class method calculateCaloricWaste.
     */
    @Test
    public void testCalculateCaloricWaste() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        WeightSquat squat1 = new WeightSquat(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", "WeightSquat", 20, 3, 50);
        squat1.calculateCaloricWaste(user.getIndex());
        assertEquals(6968, squat1.getCaloricWaste(), "Calculated caloric waste should match the expected value.");
    }

    /**
     * Tests the WeightSquat class method equals.
     */
    @Test
    public void testEquals() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        WeightSquat squat1 = new WeightSquat(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", "WeightSquat", 20, 3, 50);
        assertNotEquals(null, squat1, "WeightSquat instance should not be equal to null.");

        UUID UUID2 = java.util.UUID.randomUUID();
        WeightSquat squat2 = new WeightSquat(user.getCode(), MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", "WeightSquat", 20, 3, 50);
        assertEquals(squat1, squat2, "WeightSquat instances with identical parameters should be considered equal.");
    }
}
