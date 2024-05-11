package MakeItFit.activities.implementation;

import MakeItFit.activities.HardInterface;
import MakeItFit.activities.types.DistanceWithAltimetry;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

/**
 * The Trail class represents a trail activity that includes distance and altimetry information.
 * It extends the DistanceWithAltimetry class and includes a trail type (easy, medium, or hard).
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class Trail extends DistanceWithAltimetry implements HardInterface, Serializable {

    // Constants representing the different types of trail difficulty
    public static final int TRAIL_TYPE_EASY = 0;
    public static final int TRAIL_TYPE_MEDIUM = 1;
    public static final int TRAIL_TYPE_HARD = 2;

    // The type of the trail, represented by one of the constants above
    private int trailType;

    /**
     * Constructs a new Trail instance with the specified parameters.
     *
     * @param userCode       The user code associated with the activity.
     * @param realizationDate The date the activity was realized.
     * @param expectedDuration The expected duration of the activity.
     * @param designation     The name or description of the activity.
     * @param name            The name of the activity.
     * @param distance        The distance covered during the activity.
     * @param elevationGain   The total elevation gain during the activity.
     * @param elevationLoss   The total elevation loss during the activity.
     * @param trailType       The type of trail (easy, medium, or hard).
     */
    public Trail(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, double distance, double elevationGain, double elevationLoss, int trailType) {
        super(userCode, realizationDate, expectedDuration, designation, name, distance, elevationGain, elevationLoss);
        setSpecialization(this.getClass().getSimpleName());
        this.trailType = trailType;
    }

    /**
     * Constructs a new Trail instance with the default parameters.
     */
    public Trail() {
        super();
        setSpecialization(this.getClass().getSimpleName());
        this.trailType = TRAIL_TYPE_EASY;
    }

    /**
     * Constructs a new Trail instance as a copy of the specified Trail instance.
     *
     * @param trail The Trail instance to copy.
     */
    public Trail(Trail trail) {
        super(trail);
        this.trailType = trail.getTrailType();
    }

    /**
     * Returns the trail type of the Trail instance.
     *
     * @return The trail type (easy, medium, or hard).
     */
    public int getTrailType() {
        return trailType;
    }

    /**
     * Sets the trail type of the Trail instance, ensuring it remains within valid bounds.
     *
     * @param trailType The trail type to set (easy, medium, or hard).
     */
    public void setTrailType(int trailType) {
        if (trailType < TRAIL_TYPE_EASY) {
            this.trailType = TRAIL_TYPE_EASY;
        } else if (trailType > TRAIL_TYPE_HARD) {
            this.trailType = TRAIL_TYPE_HARD;
        } else {
            this.trailType = trailType;
        }
    }

    /**
     * Calculates the caloric waste for the Trail instance based on distance, elevation gain, and elevation loss.
     *
     * @return The calculated caloric waste as an integer.
     */
    public void calculateCaloricWaste(float index) {
        setCaloricWaste(caloricWaste(index));
    }

    /**
     * Calculates the caloric waste for the Trail instance based on distance, elevation gain, and elevation loss.
     *
     * @param index The index to be used in the calculation.
     * @return The calculated caloric waste as an integer.
     */
    public int caloricWaste(float index) {
        return (int) ((getDistance() * 0.5 + getElevationGain() * 0.1 - getElevationLoss() * 0.1) * index * 0.01);
    }

    /**
     * Returns a string representation of the Trail instance, including its trail type.
     *
     * @return The string representation of the Trail instance.
     */
    @Override
    public String toString() {
        return super.toString() + "Trail Type: " + trailType + "\n";
    }

    /**
     * Compares the current Trail instance with another object for equality.
     *
     * @param obj The object to compare with.
     * @return True if the other object is also a Trail instance with the same properties, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trail)) {
            return false;
        }
        Trail trail = (Trail) obj;
        return super.equals(trail) && this.trailType == trail.getTrailType();
    }

    /**
     * Creates a copy of the current Trail instance.
     *
     * @return A new Trail instance that is a copy of the current instance.
     */
    @Override
    public Trail clone() {
        return new Trail(this);
    }
}
