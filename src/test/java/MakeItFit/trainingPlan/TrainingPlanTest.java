

import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.trainingPlan.TrainingPlan;

import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * The tests for the TrainingPlan class.
 *
 * This class contains tests for the constructors, methods, and operations of the TrainingPlan class,
 * including tests for construction, object equality, and getters.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (11052024)
 */
public class TrainingPlanTest {

    /**
     * Tests the TrainingPlan class constructors.
     *
     */
    @Test
    public void testConstructors() {
        UUID UUID_user = java.util.UUID.randomUUID();
        TrainingPlan trainingPlan1 = new TrainingPlan(UUID_user, MakeItFitDate.of(2024, 4, 4));
        assertNotNull(trainingPlan1);
        TrainingPlan trainingPlan2 = new TrainingPlan(trainingPlan1);
        assertNotNull(trainingPlan2);
    }

    /**
     * Tests the creation of TrainingPlan instances using different constructors.
     *
     */
    @Test
    public void testTrainingPlanConstructors() {
        UUID UUID_user = java.util.UUID.randomUUID();
        TrainingPlan trainingPlan1 = new TrainingPlan(UUID_user, MakeItFitDate.of(2024, 4, 4));
        assertNotNull(trainingPlan1, "TrainingPlan instance should be created successfully.");

        TrainingPlan trainingPlan2 = new TrainingPlan(trainingPlan1);
        assertNotNull(trainingPlan2, "Copy constructor should create a non-null instance.");
        assertEquals(trainingPlan1, trainingPlan2, "Copy constructor should create an equal instance.");
    }

    /**
     * Tests the getters of the TrainingPlan class.
     */
    @Test
    public void testTrainingPlanGetters() {
        UUID UUID_user = java.util.UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan trainingPlan = new TrainingPlan(UUID_user, startDate);
        assertEquals(UUID_user, trainingPlan.getUserCode(), "User code should match the expected value.");
        assertEquals(startDate, trainingPlan.getStartDate(), "Start date should match the expected value.");
    }

    /**
     * Tests the addActivity for TrainingPlan class.
     *
     */
    @Test
    public void testTrainingPlanAddActivity() {
        UUID UUID_user = java.util.UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan trainingPlan = new TrainingPlan(UUID_user, startDate);
        assertEquals(0, trainingPlan.getActivities().size(), "The activities list should be empty.");

        trainingPlan.addActivity(10, null);
        assertEquals(1, trainingPlan.getActivities().size(), "The activities list should have one element.");
    }

    /**
     * Tests the removeActivity for TrainingPlan class.
     *
     */
    @Test
    public void testTrainingPlanRemoveActivity() {
        UUID UUID_user = java.util.UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);
        TrainingPlan trainingPlan = new TrainingPlan(UUID_user, startDate);
        assertEquals(0, trainingPlan.getActivities().size(), "The activities list should be empty.");

        PushUp pushUp = new PushUp(UUID.randomUUID(), MakeItFitDate.of(2024, 4, 4), 30, "Daily try", "PushUp", 10, 10);
        trainingPlan.addActivity(10, pushUp);
        assertEquals(1, trainingPlan.getActivities().size(), "The activities list should have one element.");

        trainingPlan.removeActivity(pushUp.getCode());
        assertEquals(0, trainingPlan.getActivities().size(), "The activities list should be empty.");
    }

    /**
     * Tests the equals method for TrainingPlan instances.
     *
     */
    @Test
    public void testTrainingPlanEquals() {
        UUID UUID_user = java.util.UUID.randomUUID();
        TrainingPlan trainingPlan1 = new TrainingPlan(UUID_user, MakeItFitDate.of(2024, 4, 4));
        TrainingPlan trainingPlan2 = new TrainingPlan(UUID_user, MakeItFitDate.of(2024, 4, 4));
        assertNotEquals(trainingPlan1, null, "TrainingPlan instance should not be equal to null.");

        assertTrue(trainingPlan1.equals(trainingPlan2), "TrainingPlan instance should be equal to another instance with the same attributes.");
    }
}