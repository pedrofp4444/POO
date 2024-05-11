import MakeItFit.queries.HowManyAltimetryDone;
import MakeItFit.users.Gender;
import MakeItFit.users.User;
import MakeItFit.users.types.*;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.users.UserManager;
import MakeItFit.activities.implementation.Trail;

/**
 * The tests for the HowManyAltimetryDone class.
 *
 * This class contains tests for the constructors, methods, and operations of the HowManyAltimetryDone class,
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class HowManyAltimetryDoneTest {

    private UserManager userManager;
    private User testUser;

    /**
     * Sets up the test environment.
     */
    @BeforeEach
    void setUp() {
        userManager = new UserManager();
        testUser = new Amateur("Test User", 30, Gender.Male, 70, 180, 65, 3, "Test Street", "123456789", "test@example.com");

        userManager.insertUser(testUser);

        testUser.addActivity(new Trail(testUser.getCode(), MakeItFitDate.of(2024, 5, 2), 40, "Serra da Estrela", "Trail", 10000.6, 700.8, 200.3, Trail.TRAIL_TYPE_MEDIUM));
        testUser.addActivity(new Trail(testUser.getCode(), MakeItFitDate.of(2024, 5, 7), 30, "Serra da Lua", "Trail", 55040.6, 299.2, 299.7, Trail.TRAIL_TYPE_EASY));
    }

    /**
     * Tests the HowManyAltimetryDone class method executeQuery.
     */
    @Test
    void testExecuteQueryWithoutDates() {
        HowManyAltimetryDone altimetryAnalyzer = new HowManyAltimetryDone();

        double result = altimetryAnalyzer.executeQuery(userManager, "test@example.com");

        assertEquals(500, round(result));
    }

    /**
     * Tests the HowManyAltimetryDone class method executeQuery.
     */
    @Test
    void testExecuteQueryValidDates() {
        HowManyAltimetryDone altimetryAnalyzer = new HowManyAltimetryDone();
        MakeItFitDate date1 = MakeItFitDate.of(2024, 5, 1);
        MakeItFitDate date2 = MakeItFitDate.of(2024, 5, 5);

        double result = altimetryAnalyzer.executeQuery(userManager, "test@example.com", date1, date2);

        assertEquals((double) 1500, round(result));
    }

    /**
     * Tests the HowManyAltimetryDone class method executeQuery.
     */
    @Test
    void testExecuteQueryInvalidDates() {
        UserManager userManager = new UserManager();
        HowManyAltimetryDone altimetryAnalyzer = new HowManyAltimetryDone();
        MakeItFitDate date1 = MakeItFitDate.of(2024, 5, 5);

        assertThrows(IllegalArgumentException.class, () -> {
            altimetryAnalyzer.executeQuery(userManager, "test@example.com", date1, null);
        });
    }
}