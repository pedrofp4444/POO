package MakeItFit.activities.types;

import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

public abstract class Repetitions extends Activity implements Serializable {
    private int repetitions;
    private int series;

    /**
     * Constructs a new Repetitions instance with the specified parameters.
     *
     * @param userCode the user code
     * @param realizationDate the realization date of the activity
     * @param expectedDuration the expected duration of the activity
     * @param designation the designation of the activity
     * @param name the name of the activity
     * @param repetitions the number of repetitions
     * @param series the number of series
     */
    public Repetitions(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, int repetitions, int series) {
        super(userCode, realizationDate, expectedDuration, designation, name);
        this.repetitions = repetitions;
        this.series = series;
    }

    /**
     * Constructs a new Repetitions instance with the default parameters.
     */
    public Repetitions() {
        super();
        this.repetitions = 0;
        this.series = 0;
    }

    /**
     * Constructs a new Repetitions instance as a copy of another Repetitions instance.
     *
     * @param r the Repetitions instance to copy
     */
    public Repetitions(Repetitions r){
        super(r);
        this.repetitions = r.getRepetitions();
        this.series = r.getSeries();
    }

    /**
     * Gets the number of repetitions.
     *
     * @return the number of repetitions
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * Gets the number of series.
     *
     * @return the number of series
     */
    public int getSeries() {
        return series;
    }

    /**
     * Sets the number of repetitions.
     *
     * @param repetitions the number of repetitions
     */
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    /**
     * Sets the number of series.
     *
     * @param series the number of series
     */
    public void setSeries(int series) {
        this.series = series;
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
     * Determines whether this Repetitions instance is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the object is a Repetitions instance and is equal to this instance; false otherwise
     */
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Repetitions)) return false;
        Repetitions r = (Repetitions) o;
        return (super.equals(r) && this.repetitions == r.repetitions && this.series == r.series);
    }

    /**
     * Creates a deep copy of this Repetitions instance.
     *
     * @return A new Repetitions instance that is a deep copy of the current instance.
     */
    public abstract Repetitions clone();

    /**
     * Returns a string representation of the Repetitions instance.
     *
     * @return the string representation of the Repetitions instance
     */
    @Override
    public String toString(){
        return super.toString() + "Repetitions: " + this.repetitions + ", " + "Series: " + this.series + ", ";
    }
}
