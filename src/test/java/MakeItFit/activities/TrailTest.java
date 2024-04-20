import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Trail;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Trail class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class TrailTest {
    /**
     * Tests the constructors of the Trail class.
     */
    @Test
    public void testConstructors() {
        // Create a Trail instance using the constructor with parameters
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertNotNull(trail1, "Trail instance should not be null");
        assertEquals(Trail.TRAIL_TYPE_MEDIUM, trail1.getTrailType(), "Trail type should be medium");

        // Create a Trail instance using the copy constructor
        Trail trail3 = new Trail(trail1);
        assertNotNull(trail3, "Trail instance created using copy constructor should not be null");
        assertEquals(trail3.getTrailType(), Trail.TRAIL_TYPE_MEDIUM, "Trail type should match the original");
    }

    /**
     * Tests the getTrailType method of the Trail class.
     */
    @Test
    public void testGetTrailType() {
        // Create a Trail instance
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_MEDIUM, "The trail type should be medium");
    }

    /**
     * Tests the setTrailType method of the Trail class.
     */
    @Test
    public void testSetTrailType() {
        // Create a Trail instance
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);

        // Change the trail type and verify the update
        trail1.setTrailType(Trail.TRAIL_TYPE_HARD);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_HARD, "The trail type should be hard");
    }

    /**
     * Tests the calculateCaloricWaste method of the Trail class.
     */
    @Test
    public void testCalculateCaloricWaste() {
        // Create a Trail instance
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);

        // Calculate caloric waste and verify the result
        assertEquals(trail1.calculateCaloricWaste(), 1403786622, "Caloric waste should match the expected value");
    }

    /**
     * Tests the equals method of the Trail class.
     */
    @Test
    public void testEquals() {
        // Create two identical Trail instances
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        Trail trail2 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);

        // Verify they are equal
        assertTrue(trail1.equals(trail2), "Two identical Trail instances should be equal");

        // Verify trail1 does not equal null
        assertFalse(trail1.equals(null), "Trail instance should not be equal to null");
    }
}
