import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Running;
import MakeItFit.activities.implementation.Trail;
import org.junit.jupiter.api.Test;

/**
 * The tests for the Trail class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class TrailTest {
    /**
     * Tests the Trail class constructors.
     */
    @Test
    public void testConstructors() {
        Trail trail1 = new Trail();
        assertNotNull(trail1);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_EASY);
        Trail trail2 = new Trail(40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertNotNull(trail2);
        assertEquals(Trail.TRAIL_TYPE_MEDIUM, trail2.getTrailType());
        Trail trail3 = new Trail(trail1);
        assertNotNull(trail3);
        assertEquals(trail3.getTrailType(), Trail.TRAIL_TYPE_EASY);

    }

    /**
     * Tests the Trail class method getTrailType.
     */
    @Test
    public void testGetTrailType() {
        Trail trail1 = new Trail();
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_EASY);
    }

    /**
     * Tests the Trail class method setTrailType.
     */
    @Test
    public void testSetTrailType() {
        Trail trail1 = new Trail();
        trail1.setTrailType(Trail.TRAIL_TYPE_HARD);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_HARD);
    }

    /**
     * Tests the Trail class method calculateCaloricWaste.
     */
    @Test
    public void testCalculateCaloricWaste() {
        Trail trail1 = new Trail(40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertEquals(trail1.calculateCaloricWaste(), 1403786622);
    }

    /**
     * Tests the Trail class method equals.
     */
    @Test
    public void testEquals(){
        Trail trail1 = new Trail(40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertFalse(trail1.equals(null));
        Trail trail2 = new Trail(40, "Serra da Estrela", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertTrue(trail1.equals(trail2));
    }
}
