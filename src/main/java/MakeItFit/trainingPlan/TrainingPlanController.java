package MakeItFit.trainingPlan;

import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.utils.*;

import java.util.*;

/**
 * The class TrainingPlanController represents a controller of training plans.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class TrainingPlanController {

    private final TrainingPlanManager trainingPlanManager;

    /**
     * Constructs a new training plan controller with the provided training plan manager.
     *
     * @param trainingPlanManager The training plan manager to be used by the controller.
     */
    public TrainingPlanController(TrainingPlanManager trainingPlanManager) {
        this.trainingPlanManager = trainingPlanManager;
    }

    /**
     * Creates a new training plan based on the provided specifications.
     *
     * @param userCode  The code of the user for whom the training plan will be created.
     * @param startDate The start date of the new training plan.
     * @throws IllegalArgumentException If the provided arguments are not valid.
     */
    public void createTrainingPlan(UUID userCode, MakeItFitDate startDate) throws IllegalArgumentException {
        TrainingPlan trainingPlan = this.trainingPlanManager.createTrainingPlan(userCode, startDate);
        this.trainingPlanManager.insertTrainingPlan(trainingPlan);
    }

    /**
     * Removes a training plan based on the provided code.
     *
     * @param code The code of the training plan to be removed.
     */
    public void removeTrainingPlan(UUID code) {
        this.trainingPlanManager.removeTrainingPlan(code);
    }

    /**
     * Retrieves a training plan based on the provided code.
     *
     * @param code The code of the training plan to be retrieved.
     * @throws IllegalArgumentException If the provided code is not valid.
     * @return The retrieved training plan.
     */
    public TrainingPlan getTrainingPlan(UUID code) throws IllegalArgumentException {
        return this.trainingPlanManager.getTrainingPlan(code);
    }

    /**
     * Updates a training plan based on the provided details.
     *
     * @param trainingPlan The updated training plan.
     * @throws EntityDoesNotExistException If the training plan does not exist.
     */
    public void updateTrainingPlan(TrainingPlan trainingPlan) throws EntityDoesNotExistException {
        this.trainingPlanManager.updateTrainingPlan(trainingPlan);
    }

    /**
     * Returns a list of all existing training plans.
     *
     * @return A list of all training plans.
     */
    public List<TrainingPlan> getAllTrainingPlans() {
        return this.trainingPlanManager.getAllTrainingPlans();
    }
}
