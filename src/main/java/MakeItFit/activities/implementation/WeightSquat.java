package MakeItFit.activities.implementation;

import MakeItFit.activities.types.RepetitionsWithWeights;
import MakeItFit.utils.MakeItFitDate;

/**
 * The WeightSquat class represents an activity of performing squats with weights as part of a fitness routine.
 * It extends the RepetitionsWithWeights class to include specific functionality related to squats with weights.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class WeightSquat extends RepetitionsWithWeights {

    /**
     * Constructs a new WeightSquat activity with the given parameters.
     *
     * @param userCode        The user code associated with the activity.
     * @param code            The activity code.
     * @param realizationDate The date the activity was performed.
     * @param expectedDuration The expected duration of the activity in minutes.
     * @param designation     The designation or name of the activity.
     * @param repetitions     The number of repetitions performed in each series.
     * @param series          The number of series performed.
     * @param weight          The weight used during the squats.
     */
    public WeightSquat(int userCode, int code, MakeItFitDate realizationDate, int expectedDuration, String designation, int repetitions, int series, double weight) {
        super(userCode, code, realizationDate, expectedDuration, designation, repetitions, series, weight);
    }

    /**
     * Copy constructor to create a new instance as a copy of an existing WeightSquat instance.
     *
     * @param w The existing WeightSquat instance to copy.
     */
    public WeightSquat(WeightSquat w) {
        super(w);
    }

    /**
     * Calculates the caloric waste for the WeightSquat activity based on the repetitions, series, and weight.
     *
     * @return The calculated caloric waste as an integer.
     */
    public int calculateCaloricWaste() {
        return (int) (getRepetitions() * getSeries() * getWeight() * 0.5);
    }

    /**
     * Returns a string representation of the WeightSquat instance.
     *
     * @return A string containing the representation of the WeightSquat instance.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Determines whether this WeightSquat instance is equal to another object.
     *
     * @param o The object to compare with this instance.
     * @return True if the object is an instance of WeightSquat and all attributes match; otherwise, false.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WeightSquat)) {
            return false;
        }
        WeightSquat w = (WeightSquat) o;
        return super.equals(w);
    }

    /**
     * Creates a deep copy of this WeightSquat instance.
     *
     * @return A new WeightSquat instance that is a deep copy of the current instance.
     */
    @Override
    public WeightSquat clone() {
        return new WeightSquat(this);
    }
}
