
import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;
import MakeItFit.trainingPlan.TrainingPlanManager;

import java.util.UUID;

/**
 * The tests for the TrainingPlanManager class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (11052024)
 */
public class TrainingPlanManagerTest {

    /**
     * Tests the creation of TrainingPlanManager instances using different constructors.
     */
    @Test
    public void testCreateTrainingPlan() {
        UUID userCode = UUID.randomUUID();
        MakeItFitDate startDate = MakeItFitDate.of(2024, 4, 4);

        TrainingPlanManager manager = new TrainingPlanManager();
        TrainingPlan trainingPlan = manager.createTrainingPlan(userCode, startDate);

        assertNotNull(trainingPlan);
        assertEquals(userCode, trainingPlan.getUserCode());
        assertEquals(startDate, trainingPlan.getStartDate());
    }

    /**
     * Test the method createTrainingPlan with null inputs
     */
    @Test
    public void testCreateTrainingPlanWithNullInputs() {
        TrainingPlanManager manager = new TrainingPlanManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.createTrainingPlan(null, MakeItFitDate.of(2024, 4, 4));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            manager.createTrainingPlan(UUID.randomUUID(), null);
        });
    }

    /**
     * Test the method insertTrainingPlan with a null training plan
     */
    @Test
    public void testInsertTrainingPlanWithNullTrainingPlan() {
        TrainingPlanManager manager = new TrainingPlanManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.insertTrainingPlan(null);
        });
    }

    /**
    * Test the method removeTrainingPlan with a valid training plan
    */
    @Test
    public void testRemoveTrainingPlan() {
        UUID code = UUID.randomUUID();
        TrainingPlan trainingPlan = new TrainingPlan(UUID.randomUUID(), MakeItFitDate.of(2024, 4, 4));

        TrainingPlanManager manager = new TrainingPlanManager();
        manager.insertTrainingPlan(trainingPlan);

        manager.removeTrainingPlan(code);

        assertThrows(IllegalArgumentException.class, () -> {
            manager.getTrainingPlan(code);
        });
    }

    /**
     * Test the method getAllTrainingPlans with a valid training plan
     */
    @Test
    public void testGetAllTrainingPlans() {
        TrainingPlan trainingPlan1 = new TrainingPlan(UUID.randomUUID(), MakeItFitDate.of(2024, 4, 4));
        TrainingPlan trainingPlan2 = new TrainingPlan(UUID.randomUUID(), MakeItFitDate.of(2024, 4, 4));

        TrainingPlanManager manager = new TrainingPlanManager();
        manager.insertTrainingPlan(trainingPlan1);
        manager.insertTrainingPlan(trainingPlan2);

        assertEquals(2, manager.getAllTrainingPlans().size());
    }

}