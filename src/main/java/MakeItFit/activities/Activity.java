package MakeItFit.activities;

import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public abstract class Activity implements ActivityInterface {
    private UUID userCode;
    private UUID code;
    private MakeItFitDate realizationDate;
    private int expectedDuration;
    private String designation;

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
     */
    public Activity(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation) {
        this.userCode = userCode;
        this.code = UUID.randomUUID();
        this.realizationDate = realizationDate;
        this.expectedDuration = expectedDuration;
        this.designation = designation;
        this.duration = 0;
        this.caloricWaste = 0;
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
    public void updateActivity(){
        calculateCaloricWaste();
    }

    /**
     * Calculates the caloric waste of the activity based on the current date.
     */
    public abstract void calculateCaloricWaste();

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
    public abstract Activity clone();

    /**
     * Returns a string representation of the activity.
     *
     * @return A string containing the details of the activity.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Activity: ").append(this.designation).append(", ");
        sb.append("Expected Duration: ").append(this.expectedDuration).append(", ");
        sb.append("Realization Date: ").append(this.realizationDate).append(", ");
        sb.append("Duration: ").append(this.duration).append(", ");
        sb.append("Caloric Waste: ").append(this.caloricWaste).append(", ");
        return sb.toString();
    }
}
