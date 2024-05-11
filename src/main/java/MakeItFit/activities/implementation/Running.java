package MakeItFit.activities.implementation;

import MakeItFit.activities.types.Distance;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

/**
 * The Running class represents a running activity in the application.
 * It extends the Distance class, providing additional properties and methods related to running activities.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class Running extends Distance implements Serializable {
    private double averageSpeed;

    /**
     * Constructs a new Running activity with the specified parameters.
     *
     * @param userCode          the code of the user who performed the activity
     * @param realizationDate   the date the activity was performed
     * @param expectedDuration  the expected duration of the activity in minutes
     * @param designation       a description of the activity
     * @param name              the name of the activity
     * @param distance          the distance covered during the activity in meters
     * @param speed             the average speed during the activity in km/h
     */
    public Running(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, double distance, double speed) {
        super(userCode, realizationDate, expectedDuration, designation, name, distance);
        setSpecialization(this.getClass().getSimpleName());
        this.averageSpeed = speed;
    }

    /**
     * Constructs a new Running activity with the default parameters.
     */
    public Running() {
        super();
        setSpecialization(this.getClass().getSimpleName());
        this.averageSpeed = 0;
    }

    /**
     * Copy constructor for the Running class.
     *
     * @param r the Running object to be copied
     */
    public Running(Running r) {
        super(r);
        this.averageSpeed = r.getSpeed();
    }

    /**
     * Gets the average speed of the running activity.
     *
     * @return the average speed in km/h
     */
    public double getSpeed() {
        return averageSpeed;
    }

    /**
     * Sets the average speed of the running activity.
     *
     * @param speed the average speed in km/h
     */
    public void setSpeed(double speed) {
        this.averageSpeed = speed;
    }

    /**
     * Calculates the caloric waste during the running activity.
     *
     * @return the estimated caloric waste as an integer value
     */
    public void calculateCaloricWaste(float index) {
        setCaloricWaste(caloricWaste(index));
    }

    /**
     * Calculates the caloric waste during the running activity.
     *
     * @param index the index to be used in the calculation
     * @return the estimated caloric waste as an integer value
     */
    public int caloricWaste(float index) {
        return (int) (averageSpeed * getDistance() * index * 0.005);
    }

    /**
     * Returns a string representation of the running activity.
     *
     * @return a string representation including the speed
     */
    @Override
    public String toString() {
        return super.toString() + "Speed: " + averageSpeed + " Km/h\n";
    }

    /**
     * Determines whether the specified object is equal to this running activity.
     *
     * @param o the object to be compared
     * @return true if the specified object is equal to this running activity, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Running)) {
            return false;
        }
        Running r = (Running) o;
        return super.equals(r) && averageSpeed == r.getSpeed();
    }

    /**
     * Creates a copy of this running activity.
     *
     * @return a new Running object that is a copy of this running activity
     */
    @Override
    public Running clone() {
        return new Running(this);
    }
}
