package MakeItFit.activities;

import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

/**
 * The Activity class represents an activity that includes common activity information.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public abstract class Activity implements ActivityInterface, Serializable, Comparable<Activity> {
    private UUID userCode;
    private UUID code;
    private MakeItFitDate realizationDate;
    private int expectedDuration;
    private String designation;
    private String name;
    private String specialization;
    private int duration;
    private int caloricWaste;

    /**
     * Constructs a new Activity instance with the specified parameters.
     *
     * @param userCode the user code
     * @param realizationDate the realization date of the activity
     * @param expectedDuration the expected duration of the activity
     * @param designation the designation of the activity
     * @param name the name of the activity
     */
    public Activity(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name) {
        this.userCode = userCode;
        this.code = UUID.randomUUID();
        this.realizationDate = realizationDate;
        this.expectedDuration = expectedDuration;
        this.designation = designation;
        this.duration = 0;
        this.caloricWaste = 0;
        this.name = name;
    }

    /**
     * Constructs a new Activity instance with the default parameters.
     */
    public Activity() {
        this.userCode = new UUID(0L, 0L);
        this.code = UUID.randomUUID();
        this.realizationDate = new MakeItFitDate();
        this.expectedDuration = 0;
        this.designation = "";
        this.duration = 0;
        this.caloricWaste = 0;
        this.name = "";
    }

    /**
     * Constructs a new Activity instance as a copy of another Activity instance.
     *
     * @param a the Activity instance to copy
     */
    public Activity(Activity a){
        this.userCode = a.getUserCode();
        this.code = a.getCode();
        this.realizationDate = a.getRealizationDate();
        this.expectedDuration = a.getExpectedDuration();
        this.designation = a.getDesignation();
        this.duration = a.getDuration();
        this.caloricWaste = a.getCaloricWaste();
        this.name = a.getName();
    }

    /**
     * Gets the user code of the activity.
     *
     * @return the user code
     */
    public UUID getUserCode(){ return this.userCode; }

    /**
     * Gets the code of the activity.
     *
     * @return the code of the activity
     */
    public UUID getCode(){ return this.code;}

    /**
     * Gets the realization date of the activity.
     *
     * @return the realization date of the activity
     */
    public MakeItFitDate getRealizationDate(){
        return this.realizationDate;
    }

    /**
     * Gets the expected duration of the activity.
     *
     * @return the expected duration of the activity
     */
    public int getExpectedDuration() {
        return this.expectedDuration;
    }

    /**
     * Gets the designation of the activity.
     *
     * @return the designation of the activity
     */
    public String getDesignation() {
        return this.designation;
    }

    /**
     * Gets the name of the activity.
     *
     * @return the name of the activity
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the duration of the activity.
     *
     * @return the duration of the activity
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Gets the caloric waste of the activity.
     *
     * @return the caloric waste of the activity
     */
    public int getCaloricWaste() {
        return this.caloricWaste;
    }

    /**
     * Gets the specialization of the activity.
     *
     * @param expectedDuration the expected duration of the activity
     */
    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    /**
     * Sets the designation of the activity.
     *
     * @param designation the designation of the activity
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Sets the duration of the activity.
     *
     * @param duration of the activity
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets the caloric waste of the activity.
     *
     * @param caloricWaste of the activity
     */
    public void setCaloricWaste(int caloricWaste) {
        this.caloricWaste = caloricWaste;
    }

    /**
     * Updates the activity based on the current date.
     */
    public void updateActivity(float index){
        calculateCaloricWaste(index);
    }

    /**
     * Calculates the caloric waste of the activity based on the current date.
     *
     * @param index the index of the user
     */
    public abstract void calculateCaloricWaste(float index);

    /**
     * Calculates the caloric waste of the activity.
     *
     * @param index the index of the user
     * @return the caloric waste of the activity
     */
    public abstract int caloricWaste(float index);

    /**
     * Sets the specialization of the activity.
     *
     * @param specialization the specialization of the activity
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

/**
     * Gets the specialization of the activity.
     *
     * @return the specialization of the activity
     */
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Activity)) return false;
        Activity a = (Activity) o;
        return (this.expectedDuration == a.expectedDuration && this.designation.equals(a.designation));
    }

    /**
     * Abstract method for cloning an activity. Must be implemented by subclasses.
     *
     * @return A clone of the activity.
     */
    @Override
    public abstract Activity clone();

    /**
     * Returns a string representation of the activity.
     *
     * @return A string containing the details of the activity.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Activity: ").append(this.name).append(", ");
        sb.append("Code: ").append(this.code).append(", ");
        sb.append("Designation: ").append(this.designation).append(", ");
        sb.append("Expected Duration: ").append(this.expectedDuration).append(" minutes, ");
        sb.append("Realization Date: ").append(this.realizationDate).append(", ");
        sb.append("Caloric Waste: ").append(this.caloricWaste).append(" calories, ");
        return sb.toString();
    }

    /**
     * Compares the activity to another activity based on the realization date and expected duration.
     *
     * @param other the other activity to compare
     * @return a negative integer, zero, or a positive integer as this activity is less than, equal to, or greater than the other activity
     */
    @Override
    public int compareTo(Activity other) {
        int compareDate = this.realizationDate.compareTo(other.realizationDate);
        if (compareDate != 0) {
            return compareDate;
        }
        return this.expectedDuration-(other.expectedDuration);
    }
}
