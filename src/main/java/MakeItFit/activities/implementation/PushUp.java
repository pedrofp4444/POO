package MakeItFit.activities.implementation;

import MakeItFit.activities.types.Repetitions;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

/**
 * The PushUp class represents an exercise activity of push-ups.
 * It extends the Repetitions class, providing additional context specific to the push-up exercise.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class PushUp extends Repetitions implements Serializable {
    /**
     * Constructs a PushUp instance with the given parameters.
     *
     * @param userCode         The code of the user performing the exercise.
     * @param realizationDate  The date when the exercise was performed.
     * @param expectedDuration The expected duration of the exercise in minutes.
     * @param designation      The name of the exercise.
     * @param name             The name of the exercise.
     * @param repetitions      The number of repetitions in each series.
     * @param series           The number of series.
     */
    public PushUp(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, int repetitions, int series) {
        super(userCode, realizationDate, expectedDuration, designation, name, repetitions, series);
        setSpecialization(this.getClass().getSimpleName());
    }

    /**
     * Constructs a PushUp instance with the default parameters.
     */
    public PushUp() {
        super();
        setSpecialization(this.getClass().getSimpleName());
    }

    /**
     * Constructs a PushUp instance as a copy of another PushUp instance.
     *
     * @param p The PushUp instance to copy.
     */
    public PushUp(PushUp p) {
        super(p);
    }

    /**
     * Calculates the caloric waste for the push-up exercise.
     *
     * @return The total caloric waste calculated based on the number of repetitions and series.
     */
    public void calculateCaloricWaste(float index) {
        setCaloricWaste(caloricWaste(index));
    }

    /**
     * Calculates the caloric waste for the push-up exercise.
     *
     * @param index The index to be used in the calculation.
     * @return The total caloric waste calculated based on the number of repetitions and series.
     */
    public int caloricWaste(float index) {
        return (int) (getRepetitions() * getSeries() * index * 0.1);
    }

    /**
     * Returns a string representation of the PushUp instance.
     *
     * @return The string representation of the PushUp instance.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Determines whether this PushUp instance is equal to another object.
     *
     * @param o The object to compare with.
     * @return True if the object is a PushUp instance and is equal to this instance; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PushUp)) {
            return false;
        }
        PushUp p = (PushUp) o;
        return super.equals(p);
    }

    /**
     * Creates a copy of this PushUp instance.
     *
     * @return A new PushUp instance that is a copy of this instance.
     */
    @Override
    public PushUp clone() {
        return new PushUp(this);
    }
}
