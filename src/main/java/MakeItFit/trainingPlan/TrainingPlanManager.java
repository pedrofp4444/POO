package MakeItFit.trainingPlan;

import MakeItFit.activities.Activity;
import MakeItFit.activities.ActivityManager;
import MakeItFit.activities.HardInterface;
import MakeItFit.activities.implementation.*;
import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

/**
 * The class TrainingPlanManager represents a manager of training plans.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
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
     * @param startDate the date that the training plan starts
     * @return the planing train created
     * @throws IllegalArgumentException if any argument is null
     */
    public TrainingPlan createTrainingPlan(UUID userCode, MakeItFitDate startDate) throws IllegalArgumentException {

        if (userCode == null || startDate == null) {
            throw new IllegalArgumentException("Invalid input: userCode, startDate.");
        }

        TrainingPlan trainingPlan = new TrainingPlan(userCode, startDate);
        return trainingPlan;
    }

    /**
     * Creates a new training plan by objectives.
     *
     * @param userCode the code of the user
     * @param startDate the date that the training plan starts
     * @param hardActivities if the activities are hard
     * @param maxActivitiesPerDay the maximum number of activities per day
     * @param maxDifferentActivities the maximum number of different activities
     * @param weeklyRecurrence the weekly recurrence
     * @param minimumCaloricWaste the minimum caloric waste
     * @return the planing train created
     * @throws IllegalArgumentException if any argument is invalid
     */
    public TrainingPlan createTrainingPlanByObjectives(UUID userCode, MakeItFitDate startDate, boolean hardActivities, int maxActivitiesPerDay, int maxDifferentActivities, int weeklyRecurrence, int minimumCaloricWaste) throws IllegalArgumentException {

        if (userCode == null || startDate == null || maxActivitiesPerDay < 0 || maxActivitiesPerDay > 3 || maxDifferentActivities < 0 || weeklyRecurrence < 0 || weeklyRecurrence > 7 || minimumCaloricWaste < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        
        TrainingPlan trainingPlan = new TrainingPlan(userCode, startDate);
        ActivityManager activityManager = new ActivityManager();
        int totalCaloricWaste = 0;
        int activitiesAddedToday = 0;
        int differentActivities = 0;
        int startDayOfWeek = startDate.getDayOfWeek();
        MakeItFitDate currentDate = startDate;
        Activity previousActivity = null;
        Random random = new Random();
        boolean hardActivityAddedYesterday = false;
        boolean hardActivityAddedToday = false;
        
        while (totalCaloricWaste < minimumCaloricWaste) {

            String activityType = activityManager.getRandomActivity();
            Activity activity;

            switch (activityType) {
                case "PushUp" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    int repetitions = random.nextInt(5, 20);
                    int series = random.nextInt(1, 5);
                    activity = new PushUp(userCode, currentDate, expectedDuration, "PushUp created automatically", repetitions, series);
                }
                case "Running" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    double distance = random.nextInt(500, 5000);
                    double speed = random.nextInt(5, 20);
                    activity = new Running(userCode, currentDate, expectedDuration, "Running created automatically", distance, speed);
                }
                case "Trail" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    int distance = random.nextInt(500, 5000);
                    int elevationGain = random.nextInt(0, 800);
                    int elevationLoss = random.nextInt(0, 800);
                    int trailType = random.nextInt(1, 3);
                    activity = new Trail(userCode, currentDate, expectedDuration, "Trail created automatically", distance, elevationGain, elevationLoss, trailType);
                }
                case "WeightSquat" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    int repetitions = random.nextInt(5, 20);
                    int series = random.nextInt(1, 5);
                    double weight = random.nextInt(5, 80);
                    activity = new WeightSquat(userCode, currentDate, expectedDuration, "WeightSquat created automatically", repetitions, series, weight);
                }
                default -> throw new IllegalArgumentException("Invalid type.");
            }

                if (!hardActivities && activity instanceof HardInterface) {
                    continue;
                }

                if (hardActivities && activity instanceof HardInterface) {
                    if (hardActivityAddedYesterday || hardActivityAddedToday) {
                        continue;
                    }
                }

                if (activitiesAddedToday < maxActivitiesPerDay && differentActivities < maxDifferentActivities && (previousActivity == null || !previousActivity.equals(activity))) {
                    trainingPlan.addActivity(random.nextInt(1, 4), activity);
                    totalCaloricWaste += activity.getCaloricWaste();
                    activitiesAddedToday++;
                    differentActivities++;
                    previousActivity = activity;
                    if (activity instanceof HardInterface) {
                        hardActivityAddedToday = true;
                    }
                }


            currentDate = currentDate.plusDays(1);
            if ((currentDate.getDayOfWeek() - startDayOfWeek) % weeklyRecurrence == 0) {
                activitiesAddedToday = 0;
                hardActivityAddedYesterday = hardActivityAddedToday;
                hardActivityAddedToday = false;
            }
        }
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

    /**
     * Updates the system.
     *
     * @param currentDate the current date
     */
    public void updateActivities(MakeItFitDate currentDate, float index){
        for(TrainingPlan trainingPlan : this.trainingPlans.values()){
            trainingPlan.updateActivities(currentDate, index);
        }
    }

    /**
     * Extracts the activities of the user.
     *
     * @param currentDate the current date
     * @param userCode the code of the user
     * @return a list of activities
     */
    public List<Activity> extractActivities(MakeItFitDate currentDate, UUID userCode) {
        List<Activity> activities = new ArrayList<Activity>();
        for (TrainingPlan trainingPlan : this.trainingPlans.values()) {
            if (trainingPlan.getUserCode().equals(userCode)) {
                activities.addAll(trainingPlan.extractActivities(currentDate));
            }
        }
        return activities;
    }
}
