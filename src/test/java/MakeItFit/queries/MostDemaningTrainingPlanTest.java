package MakeItFit.queries;

import MakeItFit.activities.implementation.*;
import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for the MostDemaningTrainingPlan class.
 *
 * This class contains tests for the constructors, methods, and operations of the MostDemaningTrainingPlan class,
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MostDemaningTrainingPlanTest {

    private UserManager userManager;
    private TrainingPlanManager trainingPlanManager;
    private User testUser;
    private UUID trainingPlanCode;

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

        trainingPlanManager = new TrainingPlanManager();

        TrainingPlan trainingPlan1 = new TrainingPlan(testUser.getCode(), MakeItFitDate.of(2024, 5, 1));

        trainingPlanCode = trainingPlan1.getCode();

        Running running = (new Running(testUser.getCode(), MakeItFitDate.of(2024, 5, 12), 45, "Porto em Movimento", "Running", 1000, 15));

        trainingPlan1.addActivity(3, running);

        trainingPlanManager.insertTrainingPlan(trainingPlan1);

    }

    /**
     * Tests the MostDemaningTrainingPlan class method executeQuery.
     */
    @Test
    void testExecuteQueryValidDates() {
        MostDemandingTrainingPlan trainingPlanAnalyzer = new MostDemandingTrainingPlan();

        String result = trainingPlanAnalyzer.executeQuery(trainingPlanManager, userManager).toString();

        assertEquals(trainingPlanManager.getTrainingPlan(trainingPlanCode).toString(), result);
    }

    /**
     * Tests the MostDemaningTrainingPlan class method executeQuery.
     */
    @Test
    void testExecuteQueryInvalidInput() {
        UserManager userManager = new UserManager();
        MostDemandingTrainingPlan trainingPlanAnalyzer = new MostDemandingTrainingPlan();

        assertThrows(NullPointerException.class, () -> {trainingPlanAnalyzer.executeQuery(null, userManager);});
    }
}