package MakeItFit.activities.types;
import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public abstract class DistanceWithAltimetry extends Distance {
    private double elevationGain;
    private double elevationLoss;

    public DistanceWithAltimetry(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, double distance, double elevationGain, double elevationLoss) {
        super(userCode, realizationDate, expectedDuration, designation, distance);
        this.elevationGain = elevationGain;
        this.elevationLoss = elevationLoss;
    }

    public DistanceWithAltimetry(DistanceWithAltimetry a){
        super(a);
        this.elevationGain = a.getElevationGain();
        this.elevationLoss = a.getElevationLoss();
    }

    public double getElevationGain() {
        return elevationGain;
    }

    public double getElevationLoss() {
        return elevationLoss;
    }

    public void setElevationGain(double elevationGain) {
        this.elevationGain = elevationGain;
    }

    public void setElevationLoss(double elevationLoss) {
        this.elevationLoss = elevationLoss;
    }

    public abstract int calculateCaloricWaste();

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof DistanceWithAltimetry)) return false;
        DistanceWithAltimetry d = (DistanceWithAltimetry) o;
        return (super.equals(d) && this.elevationGain == d.elevationGain && this.elevationLoss == d.elevationLoss);
    }

    public abstract DistanceWithAltimetry clone();

    @Override
    public String toString(){
        return super.toString() + "Elevation Gain: " + this.elevationGain + ", " + "Elevation Loss: " + this.elevationLoss + ", ";
    }
}
