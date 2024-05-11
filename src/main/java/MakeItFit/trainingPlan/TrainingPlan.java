package MakeItFit.trainingPlan;

import MakeItFit.activities.Activity;
import MakeItFit.users.UserManager;
import MakeItFit.utils.*;

import java.io.Serializable;
import java.util.*;

/**
 * The class TrainingPlan represents a training plan.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class TrainingPlan implements Serializable, Comparable<TrainingPlan> {
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
     * Constructs a new TrainingPlan instance with the default parameters.
     */
    public TrainingPlan(){
        this.userCode = new UUID(0L, 0L);
        this.code = UUID.randomUUID();
        this.startDate = new MakeItFitDate();
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
     * @param code the code of the activity to remove
     */
    public void removeActivity(UUID code) {
        for (MyTuple<Integer, Activity> tuple : this.activities) {
            if (tuple.getItem2().getCode().equals(code)) {
                this.activities.remove(tuple);
                break;
            }
        }
    }

    /**
     * Updates the activities of the training plan.
     *
     * @param currentDate the current date
     */
    public void updateActivities(MakeItFitDate currentDate, float index) {
        for (MyTuple<Integer, Activity> tuple : this.activities) {
            Activity activity = tuple.getItem2();
            if(currentDate.isAfter(activity.getRealizationDate())){
                activity.updateActivity(index);
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

    /**
     * Returns a string representation of the training plan.
     *
     * @return a string representation of the training plan
     */
    @Override
    public String toString() {
        return "        == (Training plan details) ==" + "        \nTraining Plan: " + this.code + "\n        User Code: " + this.userCode + "\n        Start Date: " + this.startDate + "\n        Activities(Iterations / Activity): " + this.activities;
    }

    /**
     * The equals method compares two training plans for equality.
     *
     * @param o the object to compare
     * @return true if the training plans are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrainingPlan)) {
            return false;
        }
        TrainingPlan trainingPlan = (TrainingPlan) o;
        return this.userCode.equals(trainingPlan.getUserCode()) && this.startDate.equals(trainingPlan.getStartDate()) && this.activities.equals(trainingPlan.getActivities());
    }

    /**
     * Compares the training plan to another training plan based on the start date and activities.
     *
     * @param other the other training plan to compare
     * @return a negative integer, zero, or a positive integer as this training plan is less than, equal to, or greater than the other training plan
     */
    @Override
    public int compareTo(TrainingPlan other) {
        int compareDate = this.startDate.compareTo(other.getStartDate());
        if (compareDate == 0) {
            return this.activities.size() - other.getActivities().size();
        }
        return compareDate;
    }

    /**
     * Creates a copy of the current TrainingPlan instance.
     *
     * @return A new TrainingPlan instance that is a copy of the current instance.
     */
    @Override
    public TrainingPlan clone() {
        return new TrainingPlan(this);
    }
}
