import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Trail;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Trail class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class TrailTest {
    /**
     * Tests the constructors of the Trail class.
     */
    @Test
    public void testConstructors() {
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertNotNull(trail1, "Trail instance should not be null");
        assertEquals(Trail.TRAIL_TYPE_MEDIUM, trail1.getTrailType(), "Trail type should be medium");

        Trail trail3 = new Trail(trail1);
        assertNotNull(trail3, "Trail instance created using copy constructor should not be null");
        assertEquals(trail3.getTrailType(), Trail.TRAIL_TYPE_MEDIUM, "Trail type should match the original");
    }

    /**
     * Tests the getTrailType method of the Trail class.
     */
    @Test
    public void testGetTrailType() {
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_MEDIUM, "The trail type should be medium");
    }

    /**
     * Tests the setTrailType method of the Trail class.
     */
    @Test
    public void testSetTrailType() {
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);

        trail1.setTrailType(Trail.TRAIL_TYPE_HARD);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_HARD, "The trail type should be hard");
    }

    /**
     * Tests the calculateCaloricWaste method of the Trail class.
     */
    @Test
    public void testCalculateCaloricWaste() {
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertEquals(trail1.calculateCaloricWaste(), 1403786622, "Caloric waste should match the expected value");
    }

    /**
     * Tests the equals method of the Trail class.
     */
    @Test
    public void testEquals() {
        Trail trail1 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        Trail trail2 = new Trail(0, 3, MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);

        assertTrue(trail1.equals(trail2), "Two identical Trail instances should be equal");
        assertFalse(trail1.equals(null), "Trail instance should not be equal to null");
    }
}
