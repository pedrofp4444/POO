package MakeItFit.activities.types;

import MakeItFit.activities.Activity;

public abstract class DistanceWithAltimetry extends Distance {
    private double elevationGain;
    private double elevationLoss;

    public DistanceWithAltimetry(int duration, int expectedDuration, String designation, int caloricWaste, double distance, double elevationGain, double elevationLoss) {
        super(duration, expectedDuration, designation, caloricWaste, distance);
        this.elevationGain = elevationGain;
        this.elevationLoss = elevationLoss;
    }

    public DistanceWithAltimetry(){
        super();
        this.elevationGain = 0;
        this.elevationLoss = 0;
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
}
