package MakeItFit.activities.types;

import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

public abstract class RepetitionsWithWeights extends Repetitions implements Serializable {
    private double weight;

    /**
     * Constructs a new RepetitionsWithWeights instance with the specified parameters.
     *
     * @param userCode the user code
     * @param realizationDate the realization date of the activity
     * @param expectedDuration the expected duration of the activity
     * @param designation the designation of the activity
     * @param name the name of the activity
     * @param repetitions the number of repetitions
     * @param series the number of series
     * @param weight the weight used during the activity
     */
    public RepetitionsWithWeights(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, int repetitions, int series, double weight) {
        super(userCode, realizationDate, expectedDuration, designation, name, repetitions, series);
        this.weight = weight;
    }

    /**
     * Constructs a new RepetitionsWithWeights instance with the default parameters.
     */
    public RepetitionsWithWeights() {
        super();
        this.weight = 0;
    }

    /**
     * Constructs a new RepetitionsWithWeights instance as a copy of another RepetitionsWithWeights instance.
     *
     * @param r the RepetitionsWithWeights instance to copy
     */
    public RepetitionsWithWeights(RepetitionsWithWeights r){
        super(r);
        this.weight = r.getWeight();
    }

    /**
     * Gets the weight used during the activity.
     *
     * @return the weight used
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight used during the activity.
     *
     * @param weight the weight used
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates the caloric waste of the activity.
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
     * Returns a string representation of the RepetitionsWithWeights instance.
     *
     * @return a string representation of the RepetitionsWithWeights instance
     */
    @Override
    public String toString(){
        return super.toString() + "Weight: " + weight + " Kg\n";
    }

    /**
     * Determines whether this RepetitionsWithWeights instance is equal to another object.
     *
     * @param o the object to compare with this instance
     * @return true if the object is an instance of RepetitionsWithWeights and all attributes match; otherwise, false
     */
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof RepetitionsWithWeights)) return false;
        RepetitionsWithWeights r = (RepetitionsWithWeights) o;
        return super.equals(r) && weight == r.getWeight();
    }

    /**
     * Clones the RepetitionsWithWeights instance.
     *
     * @return the cloned RepetitionsWithWeights instance
     */
    public abstract RepetitionsWithWeights clone();
}
