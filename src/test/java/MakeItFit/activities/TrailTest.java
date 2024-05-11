import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.Trail;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.users.types.Amateur;
import MakeItFit.users.types.Professional;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Tests for the Trail class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class TrailTest {
    /**
     * Tests the constructors of the Trail class.
     */
    @Test
    public void testConstructors() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Trail trail1 = new Trail(user.getCode(), MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", "Trail", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertNotNull(trail1, "Trail instance should not be null");
        assertEquals(Trail.TRAIL_TYPE_MEDIUM, trail1.getTrailType(), "Trail type should be medium");

        Trail trail2 = new Trail(trail1);
        assertNotNull(trail2, "Trail instance created using copy constructor should not be null");
        assertEquals(trail2.getTrailType(), Trail.TRAIL_TYPE_MEDIUM, "Trail type should match the original");
    }

    /**
     * Tests the getTrailType method of the Trail class.
     */
    @Test
    public void testGetTrailType() {
        User user = new Professional("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com", 7);
        Trail trail1 = new Trail(user.getCode(), MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", "Trail", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_MEDIUM, "The trail type should be medium");
    }

    /**
     * Tests the setTrailType method of the Trail class.
     */
    @Test
    public void testSetTrailType() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Trail trail1 = new Trail(user.getCode(), MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", "Trail", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_EASY);

        trail1.setTrailType(Trail.TRAIL_TYPE_HARD);
        assertEquals(trail1.getTrailType(), Trail.TRAIL_TYPE_HARD, "The trail type should be hard");
    }

    /**
     * Tests the calculateCaloricWaste method of the Trail class.
     */
    @Test
    public void testCalculateCaloricWaste() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Trail trail1 = new Trail(user.getCode(), MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", "Trail", 900.6, 700.8, 200.3, Trail.TRAIL_TYPE_HARD);
        trail1.calculateCaloricWaste(user.getIndex());
        assertEquals(trail1.getCaloricWaste(), 116, "Caloric waste should match the expected value");
    }

    /**
     * Tests the equals method of the Trail class.
     */
    @Test
    public void testEquals() {
        User user = new Amateur("John", 20, Gender.Male, 70, 180, 65, 3, "Wallstreet N16", "974632836", "jonh@mail.com");
        Trail trail1 = new Trail(user.getCode(), MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", "Trail", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_EASY);
        Trail trail2 = new Trail(user.getCode(), MakeItFitDate.of(2024, 4, 4), 40, "Serra da Estrela", "Trail", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_EASY);

        assertEquals(trail1, trail2, "Two identical Trail instances should be equal");
        assertNotEquals(null, trail1, "Trail instance should not be equal to null");
    }
}
