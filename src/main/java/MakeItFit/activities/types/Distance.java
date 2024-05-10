package MakeItFit.activities.types;

import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

public abstract class Distance extends Activity implements Serializable {
    private double distance;

    /**
     * Constructs a new Distance instance with the specified parameters.
     *
     * @param userCode the user code
     * @param realizationDate the realization date of the activity
     * @param expectedDuration the expected duration of the activity
     * @param designation the designation of the activity
     * @param name the name of the activity
     * @param distance the distance covered during the activity
     */
    public Distance(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, double distance) {
        super(userCode, realizationDate, expectedDuration, designation, name);
        this.distance = distance;
    }

    /**
     * Constructs a new Distance instance with the default parameters.
     */
    public Distance() {
        super();
        this.distance = 0;
    }

    /**
     * Constructs a new Distance instance as a copy of another Distance instance.
     *
     * @param d the Distance instance to copy
     */
    public Distance(Distance d){
        super(d);
        this.distance = d.getDistance();
    }

    /**
     * Gets the distance covered during the activity.
     *
     * @return the distance covered
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the distance covered during the activity.
     *
     * @param distance the distance covered
     */
    public void setDistance(double distance) {
        this.distance = distance;
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
     * Returns a string representation of the Distance instance.
     *
     * @return the string representation of the Distance instance
     */
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Distance)) return false;
        Distance d = (Distance) o;
        return (super.equals(d) && this.distance == d.distance);
    }

    /**
     * Clones the Distance instance.
     *
     * @return the cloned Distance instance
     */
    public abstract Distance clone();

    /**
     * Returns a string representation of the Distance instance.
     *
     * @return the string representation of the Distance instance
     */
    @Override
    public String toString(){
        return super.toString() + "Distance: " + this.distance + " meters, ";
    }
}
