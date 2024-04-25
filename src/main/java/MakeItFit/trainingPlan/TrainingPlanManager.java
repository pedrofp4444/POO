package MakeItFit.trainingPlan;

import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

/**
 * The class TrainingPlanManager represents a manager of training plans.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class TrainingPlanManager {

    private Map<UUID, TrainingPlan> trainingPlans;

    public TrainingPlanManager() {
        this.trainingPlans = new HashMap<>();
    }

    /**
     * Creates a new training plan.
     *
     * @param userCode the code of the user
     * @param code the code of the training plan
     * @param startDate the date that the training plan starts
     * @return the planing train created
     * @throws IllegalArgumentException if any argument is null
     */
    public TrainingPlan createTrainingPlan(UUID userCode, UUID code, MakeItFitDate startDate) {

        if (userCode == null || startDate == null || code == null) {
            throw new IllegalArgumentException("Invalid input: userCode, code, startDate.");
        }

        TrainingPlan trainingPlan = new TrainingPlan(userCode, code, startDate);
        return trainingPlan;
    }

    /**
     * Inserts a training plan into the manager.
     *
     * @param trainingPlan the training plan to be inserted
     */
    public void insertTrainingPlan(TrainingPlan trainingPlan) throws IllegalArgumentException{

        if (trainingPlan == null) {
            throw new IllegalArgumentException("Invalid input: trainingPlan cannot be null.");
        }

        if(this.trainingPlans.containsKey(trainingPlan.getCode())){
            throw new IllegalArgumentException("Training with code " + trainingPlan.getCode() + " already exists.");
        }

        this.trainingPlans.put(trainingPlan.getCode(), trainingPlan);
    }

    /**
     * Removes a training plan by the user code.
     *
     * @param code the code of the user
     */
    public void removeTrainingPlan(UUID code){
        this.trainingPlans.remove(code);
    }

    /**
     * Returns the training plan by the code.
     *
     * @param code the code of the user
     * @return the training plan by the user code
     * @throws IllegalArgumentException if the training plan does not exist
     */
    public TrainingPlan getTrainingPlan(UUID code){
        TrainingPlan trainingPlan = this.trainingPlans.get(code);

        if(trainingPlan == null){
            throw new IllegalArgumentException("Training with code " + code + " does not exist.");
        }

        return trainingPlan;
    }

    /**
     * Updates the training plan.
     *
     * @param trainingPlan the training plan to be updated
     * @throws EntityDoesNotExistException if the training plan does not exist
     */
    public void updateTrainingPlan(TrainingPlan trainingPlan){
        UUID code = trainingPlan.getCode();
        if (!this.trainingPlans.containsKey(code)) {
            throw new EntityDoesNotExistException("Training Plan with code " + code + " does not exist.");
        }

        this.trainingPlans.put(code, trainingPlan);
    }

    /**
     * Retrieves a list of all training plans.
     *
     * @return a list of all training plans
     */

    public List<TrainingPlan> getAllTrainingPlans(){
        return new ArrayList<>(this.trainingPlans.values());
    }
}