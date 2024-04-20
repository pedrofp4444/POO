package MakeItFit.activities.types;
import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

public abstract class DistanceWithAltimetry extends Distance {
    private double elevationGain;
    private double elevationLoss;

    public DistanceWithAltimetry(int userCode, int code, MakeItFitDate realizationDate, int expectedDuration, String designation, double distance, double elevationGain, double elevationLoss) {
        super(userCode, code, realizationDate, expectedDuration, designation, distance);
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
}
