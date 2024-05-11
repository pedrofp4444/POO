package MakeItFit.queries;

import MakeItFit.activities.implementation.*;
import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for the MostDoneActivity class.
 *
 * This class contains tests for the constructors, methods, and operations of the MostDoneActivity class,
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MostDoneActivityTest {

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
        testUser.addActivity(new Running(testUser.getCode(), MakeItFitDate.of(2024, 5, 12), 45, "Porto em Movimento", "Running", 1000, 15));
    }

    /**
     * Tests the MostDoneActivity class method executeQuery.
     */
    @Test
    void testExecuteQueryValidUser() {
        MostDoneActivity activityAnalyzer = new MostDoneActivity();

        String result = activityAnalyzer.executeQuery(userManager);

        assertEquals("Distance", result);
    }

    /**
     * Tests the MostDoneActivity class method executeQuery.
     */
    @Test
    void testExecuteQueryInvalidUser() {
        MostDoneActivity activityAnalyzer = new MostDoneActivity();

        assertThrows(NullPointerException.class, () -> {
            activityAnalyzer.executeQuery(null);
        });
    }
}