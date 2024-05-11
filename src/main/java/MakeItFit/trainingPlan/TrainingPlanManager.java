package MakeItFit.trainingPlan;

import MakeItFit.activities.Activity;
import MakeItFit.activities.ActivityManager;
import MakeItFit.activities.HardInterface;
import MakeItFit.activities.implementation.*;
import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.utils.MakeItFitDate;
import MakeItFit.utils.MyTuple;

import java.io.Serializable;
import java.util.*;

/**
 * The class TrainingPlanManager represents a manager of training plans.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class TrainingPlanManager implements Serializable {

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
     * Constructs a new training plan by objectives.
     *
     * @param trainingPlan The training plan in usage.
     * @param index The index of the user.
     * @param hardActivities if the activities are hard
     * @param maxActivitiesPerDay the maximum number of activities per day
     * @param maxDifferentActivities the maximum number of different activities
     * @param weeklyRecurrence the weekly recurrence
     * @param minimumCaloricWaste the minimum caloric waste
     * @return the planing train created
     * @throws IllegalArgumentException if any argument is invalid
     */
    public TrainingPlan constructTrainingPlanByObjectives(TrainingPlan trainingPlan, float index, boolean hardActivities, int maxActivitiesPerDay, int maxDifferentActivities, int weeklyRecurrence, int minimumCaloricWaste) throws IllegalArgumentException {

        if (maxActivitiesPerDay < 0 || maxActivitiesPerDay > 3 || maxDifferentActivities < 0 || weeklyRecurrence < 0 || weeklyRecurrence > 7 || minimumCaloricWaste < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        int totalCaloricWaste = 0;
        int activitiesAddedToday = 0;
        int daysWithActivitiesThisWeek = 0;
        int startDayOfWeek = trainingPlan.getStartDate().getDayOfWeek();
        boolean hardActivityAddedYesterday = false;
        boolean hardActivityAddedToday = false;
        boolean newWeek = false;
        boolean addedActivity = false;

        ActivityManager activityManager = new ActivityManager();
        MakeItFitDate currentDate = trainingPlan.getStartDate();
        Random random = new Random();
        
        Set<String> differentActivityTypes = new HashSet<>();

        while (totalCaloricWaste < minimumCaloricWaste) {

            String activityType = activityManager.getRandomActivity();
            Activity activity;

            while (differentActivityTypes.size() == maxDifferentActivities && !differentActivityTypes.contains(activityType)) {
                activityType = activityManager.getRandomActivity();
            }

            switch (activityType) {
                case "PushUp" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    int repetitions = random.nextInt(5, 20);
                    int series = random.nextInt(1, 5);
                    activity = new PushUp(trainingPlan.getUserCode(), currentDate, expectedDuration, "PushUp created automatically", activityType, repetitions, series);
                }
                case "Running" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    double distance = random.nextInt(500, 5000);
                    double speed = random.nextInt(5, 20);
                    activity = new Running(trainingPlan.getUserCode(), currentDate, expectedDuration, "Running created automatically", activityType, distance, speed);
                }
                case "Trail" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    int distance = random.nextInt(500, 5000);
                    int elevationGain = random.nextInt(0, 800);
                    int elevationLoss = random.nextInt(0, 800);
                    int trailType = random.nextInt(1, 3);
                    activity = new Trail(trainingPlan.getUserCode(), currentDate, expectedDuration, "Trail created automatically", activityType, distance, elevationGain, elevationLoss, trailType);
                }
                case "WeightSquat" -> {
                    int expectedDuration = random.nextInt(10, 40);
                    int repetitions = random.nextInt(5, 20);
                    int series = random.nextInt(1, 5);
                    double weight = random.nextInt(5, 80);
                    activity = new WeightSquat(trainingPlan.getUserCode(), currentDate, expectedDuration, "WeightSquat created automatically", activityType, repetitions, series, weight);
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

            if (activitiesAddedToday < maxActivitiesPerDay && daysWithActivitiesThisWeek < weeklyRecurrence) {
                differentActivityTypes.add(activityType);
                trainingPlan.addActivity(random.nextInt(1, 4), activity);
                totalCaloricWaste += activity.caloricWaste(index);
                activitiesAddedToday++;
                addedActivity = true;
                if (activity instanceof HardInterface) {
                    hardActivityAddedToday = true;
                }
            } else {
                currentDate = currentDate.plusDays(1);
                newWeek = true;
                activitiesAddedToday = 0;
                if(addedActivity){
                    daysWithActivitiesThisWeek++;
                }
                addedActivity = false;
            }

            if ((currentDate.getDayOfWeek() == startDayOfWeek) && newWeek) {
                daysWithActivitiesThisWeek = 0;
                hardActivityAddedYesterday = hardActivityAddedToday;
                hardActivityAddedToday = false;
                newWeek = false;
            }
        }
        return trainingPlan;
    }

    /**
     * Inserts a training plan into the manager.
     *
     * @param trainingPlan the training plan to be inserted
     */
    public void insertTrainingPlan(TrainingPlan trainingPlan) throws IllegalArgumentException {

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
    public TrainingPlan getTrainingPlan(UUID code) throws IllegalArgumentException {
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
    public void updateTrainingPlan(TrainingPlan trainingPlan) throws EntityDoesNotExistException{
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
     * Adds an activity to a specific training plan.
     *
     * @param repetitions the number of repetitions
     * @param activity the activity to add
     */
    public void addActivity(UUID code, int repetitions, Activity activity) {
        this.trainingPlans.get(code).addActivity(repetitions, activity);
    }

    /**
     * Removes an activity from a specific training plan.
     * 
     * @param code the code of the training plan
     * @param activity the code of the activity to remove
     */
    public void removeActivity(UUID code, UUID activity) {
        this.trainingPlans.get(code).removeActivity(activity);
    }

    /**
     * Retrieves a list of all training plans from a user.
     *
     * @param userCode the code of the user
     * @return a list of all training plans from the user
     */
    public List<TrainingPlan> getTrainingPlansFromUser(UUID userCode){
        List<TrainingPlan> trainingPlans = new ArrayList<>();

        for(TrainingPlan trainingPlan : this.trainingPlans.values()){
            if(trainingPlan.getUserCode().equals(userCode)){
                trainingPlans.add(trainingPlan);
            }
        }
        return trainingPlans;
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
