package MakeItFit.trainingPlan;

import MakeItFit.activities.Activity;
import MakeItFit.users.User;
import MakeItFit.utils.*;

import java.util.*;

/**
 * The class TrainingPlan represents a training plan.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class TrainingPlan {
    private final UUID userCode;
    private final UUID code;
    private List<MyTuple<Integer, Activity>> activities; /* Tuple<Repetitions, Activity> */
    private MakeItFitDate startDate;

    /**
     * Constructs a new TrainingPlan instance with the specified parameters.
     *
     * @param userCode the user code
     * @param startDate the start date of the training plan
     */
    public TrainingPlan(UUID userCode, MakeItFitDate startDate) {
        this.userCode = userCode;
        this.code = UUID.randomUUID();
        this.startDate = startDate;
        this.activities = new ArrayList<MyTuple<Integer, Activity>>();
    }

    /**
     * Constructs a new TrainingPlan instance as a copy of another TrainingPlan instance.
     *
     * @param tp the TrainingPlan instance to copy
     */
    public TrainingPlan(TrainingPlan tp) {
        this.userCode = tp.getUserCode();
        this.code = tp.getCode();
        this.startDate = tp.getStartDate();
        this.activities = tp.getActivities();
    }

    /**
     * Gets the user code of the training plan.
     *
     * @return the user code
     */
    public UUID getUserCode() {
        return this.userCode;
    }

    /**
     * Gets the code of the training plan.
     *
     * @return the code
     */
    public UUID getCode() {
        return this.code;
    }

    /**
     * Gets the start date of the training plan.
     *
     * @return the start date
     */
    public MakeItFitDate getStartDate() {
        return this.startDate;
    }

    /**
     * Gets the activities of the training plan.
     *
     * @return the activities
     */
    public List<MyTuple<Integer, Activity>> getActivities() {
        return this.activities;
    }

    /**
     * Sets the start date of the training plan.
     *
     * @param startDate the new start date
     */
    public void setStartDate(MakeItFitDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Adds an activity to the training plan.
     *
     * @param repetitions the number of repetitions
     * @param activity the activity to add
     */
    public void addActivity(int repetitions, Activity activity) {
        this.activities.add(new MyTuple<Integer, Activity>(repetitions, activity));
    }

    /**
     * Removes an activity from the training plan.
     *
     * @param activity the activity to remove
     */
    public void removeActivity(Activity activity) {
        for (MyTuple<Integer, Activity> tuple : this.activities) {
            if (tuple.getItem2().equals(activity)) {
                this.activities.remove(tuple);
                break;
            }
        }
    }

    /**
     * Returns a string representation of the training plan.
     *
     * @return a string representation of the training plan
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrainingPlan)) {
            return false;
        }
        TrainingPlan trainingPlan = (TrainingPlan) o;
        return this.userCode.equals(trainingPlan.getUserCode()) && this.code.equals(trainingPlan.getCode()) && this.startDate.equals(trainingPlan.getStartDate()) && this.activities.equals(trainingPlan.getActivities());
    }

    /**
     * Updates the activities of the training plan.
     *
     * @param currentDate the current date
     */
    public void updateActivities(MakeItFitDate currentDate) {
        for (MyTuple<Integer, Activity> tuple : this.activities) {
            Activity activity = tuple.getItem2();
            if(currentDate.isAfter(activity.getRealizationDate())){
                activity.updateActivity();
            }
        }
    }

    /**
     * Extracts the activities of the training plan.
     *
     * @param currentDate the current date
     * @return a list of activities
     */
    public List<Activity> extractActivities(MakeItFitDate currentDate) {
        List<Activity> activities = new ArrayList<Activity>();
        for (MyTuple<Integer, Activity> tuple : this.activities) {
            if (currentDate.isAfter(tuple.getItem2().getRealizationDate())) {
                activities.add(tuple.getItem2().clone());
            }
        }
        return activities;
    }
}


