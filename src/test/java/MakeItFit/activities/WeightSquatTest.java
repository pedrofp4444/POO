import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Trail;
import MakeItFit.activities.implementation.WeightSquat;
import org.junit.jupiter.api.Test;

/**
 * The tests for the WeightSquat class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class WeightSquatTest {
    /**
     * Tests the WeightSquat class constructors.
     */
    @Test
    public void testConstructors() {
        WeightSquat squat1 = new WeightSquat();
        assertNotNull(squat1);
        WeightSquat squat2 = new WeightSquat(30, "Weekly try",20,3,50);
        assertNotNull(squat2);
        WeightSquat squat3 = new WeightSquat(squat1);
        assertNotNull(squat3);
    }

    /**
     * Tests the WeightSquat class method calculateCaloricWaste.
     */
    @Test
    public void testCalculateCaloricWaste() {
        WeightSquat squat1 = new WeightSquat(30, "Weekly try", 20, 3, 50);
        assertEquals(squat1.calculateCaloricWaste(), 1500);
    }

    /**
     * Tests the WeightSquat class method equals.
     */
    @Test
    public void testEquals(){
        WeightSquat squat1 = new WeightSquat(30, "Weekly try", 20, 3, 50);
        assertFalse(squat1.equals(null));
        WeightSquat squat2 = new WeightSquat(30, "Weekly try", 20, 3, 50);
        assertTrue(squat1.equals(squat2));
    }
}
