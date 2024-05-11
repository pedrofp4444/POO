package MakeItFit.queries;

import MakeItFit.activities.implementation.Running;
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
 * The tests for the HowManyMetersDone class.
 *
 * This class contains tests for the constructors, methods, and operations of the HowManyMetersDone class,
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class HowManyKMsDoneTest {

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

        testUser.addActivity(new Running(testUser.getCode(), MakeItFitDate.of(2024, 5, 4), 45, "Braga em Movimento", "Running", 2300, 14.5));
        testUser.addActivity(new Trail(testUser.getCode(), MakeItFitDate.of(2024, 5, 7), 30, "Serra da Lua", "Trail", 55040.6, 299.2, 299.7, Trail.TRAIL_TYPE_EASY));
    }

    /**
     * Tests the HowManyMetersDone class method executeQuery.
     */
    @Test
    void testExecuteQueryWithoutDates() {
        HowManyKMsDone metersAnalyzer = new HowManyKMsDone();

        double result = metersAnalyzer.executeQuery(userManager, "test@example.com");

        assertEquals(57, round(result));
    }

    /**
     * Tests the HowManyMetersDone class method executeQuery.
     */
    @Test
    void testExecuteQueryValidDates() {
        HowManyKMsDone metersAnalyzer = new HowManyKMsDone();
        MakeItFitDate date1 = MakeItFitDate.of(2024, 5, 1);
        MakeItFitDate date2 = MakeItFitDate.of(2024, 5, 5);

        double result = metersAnalyzer.executeQuery(userManager, "test@example.com", date1, date2);

        assertEquals(2.3, result);
    }

    /**
     * Tests the HowManyMetersDone class method executeQuery.
     */
    @Test
    void testExecuteQueryInvalidDates() {
        UserManager userManager = new UserManager();
        HowManyKMsDone metersAnalyzer = new HowManyKMsDone();
        MakeItFitDate date1 = MakeItFitDate.of(2024, 5, 5);

        assertThrows(IllegalArgumentException.class, () -> {
            metersAnalyzer.executeQuery(userManager, "test@example.com", date1, null);
        });
    }
}