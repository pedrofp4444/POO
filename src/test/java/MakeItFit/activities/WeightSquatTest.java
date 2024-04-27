import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.WeightSquat;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

/**
 * The tests for the WeightSquat class.
 *
 * This class contains tests for the constructors, methods, and operations of the WeightSquat class,
 * including tests for construction, calculating caloric waste, and object equality.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class WeightSquatTest {

    /**
     * Tests the WeightSquat class constructors.
     */
    @Test
    public void testConstructors() {
        WeightSquat squat1 = new WeightSquat(0, 4, MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", 20, 3, 50);
        assertNotNull(squat1, "WeightSquat instance should be created successfully.");

        WeightSquat squat3 = new WeightSquat(squat1);
        assertNotNull(squat3, "Copy of WeightSquat instance should be created successfully.");
    }

    /**
     * Tests the WeightSquat class method calculateCaloricWaste.
     */
    @Test
    public void testCalculateCaloricWaste() {
        WeightSquat squat1 = new WeightSquat(0, 4, MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", 20, 3, 50);
        assertEquals(1500, squat1.calculateCaloricWaste(), "Calculated caloric waste should match the expected value.");
    }

    /**
     * Tests the WeightSquat class method equals.
     */
    @Test
    public void testEquals() {
        WeightSquat squat1 = new WeightSquat(0, 4, MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", 20, 3, 50);
        assertFalse(squat1.equals(null), "WeightSquat instance should not be equal to null.");

        WeightSquat squat2 = new WeightSquat(0, 4, MakeItFitDate.of(2024, 4, 4), 30, "Weekly try", 20, 3, 50);
        assertTrue(squat1.equals(squat2), "WeightSquat instances with identical parameters should be considered equal.");
    }
}
