package MakeItFit.activities.types;
import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.UUID;

public abstract class DistanceWithAltimetry extends Distance implements Serializable {
    private double elevationGain;
    private double elevationLoss;

    /**
     * Constructs a new DistanceWithAltimetry instance with the specified parameters.
     *
     * @param userCode the user code
     * @param realizationDate the realization date of the activity
     * @param expectedDuration the expected duration of the activity
     * @param designation the designation of the activity
     * @param name the name of the activity
     * @param distance the distance covered during the activity
     * @param elevationGain the elevation gain during the activity
     * @param elevationLoss the elevation loss during the activity
     */
    public DistanceWithAltimetry(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, String name, double distance, double elevationGain, double elevationLoss) {
        super(userCode, realizationDate, expectedDuration, designation, name, distance);
        this.elevationGain = elevationGain;
        this.elevationLoss = elevationLoss;
    }

    /**
     * Constructs a new DistanceWithAltimetry instance with the default parameters.
     */
    public DistanceWithAltimetry() {
        super();
        this.elevationGain = 0;
        this.elevationLoss = 0;
    }

    /**
     * Constructs a new DistanceWithAltimetry instance as a copy of another DistanceWithAltimetry instance.
     *
     * @param a the DistanceWithAltimetry instance to copy
     */
    public DistanceWithAltimetry(DistanceWithAltimetry a){
        super(a);
        this.elevationGain = a.getElevationGain();
        this.elevationLoss = a.getElevationLoss();
    }

    /**
     * Gets the elevation gain during the activity.
     *
     * @return the elevation gain
     */
    public double getElevationGain() {
        return elevationGain;
    }

    /**
     * Gets the elevation loss during the activity.
     *
     * @return the elevation loss
     */
    public double getElevationLoss() {
        return elevationLoss;
    }

    /**
     * Sets the elevation gain during the activity.
     *
     * @param elevationGain the elevation gain
     */
    public void setElevationGain(double elevationGain) {
        this.elevationGain = elevationGain;
    }

    /**
     * Sets the elevation loss during the activity.
     *
     * @param elevationLoss the elevation loss
     */
    public void setElevationLoss(double elevationLoss) {
        this.elevationLoss = elevationLoss;
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
     * Verifies if the DistanceWithAltimetry instance is equal to another object.
     *
     * @param o the object to compare
     * @return true if the object is an instance of DistanceWithAltimetry and all attributes match; otherwise, false
     */
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof DistanceWithAltimetry)) return false;
        DistanceWithAltimetry d = (DistanceWithAltimetry) o;
        return (super.equals(d) && this.elevationGain == d.elevationGain && this.elevationLoss == d.elevationLoss);
    }

    /**
     * Clones the DistanceWithAltimetry instance.
     *
     * @return the cloned DistanceWithAltimetry instance
     */
    public abstract DistanceWithAltimetry clone();

    /**
     * Returns a string representation of the DistanceWithAltimetry instance.
     *
     * @return the string representation of the DistanceWithAltimetry instance
     */
    @Override
    public String toString(){
        return super.toString() + "Elevation Gain: " + this.elevationGain + " meters, " + "Elevation Loss: " + this.elevationLoss + " meters, ";
    }
}
