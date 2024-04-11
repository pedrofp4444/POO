package MakeItFit.activities.types;

import MakeItFit.activities.Activity;

public abstract class Distance extends Activity {
    private double distance;

    public Distance(int duration, int expectedDuration, String designation, int caloricWaste, double distance) {
        super(duration, expectedDuration, designation, caloricWaste);
        this.distance = distance;
    }

    public Distance(double distance) {
        super();
        this.distance = distance;
    }

    public Distance(){
        super();
        this.distance = 0;
    }

    public Distance(Distance a){
        this.distance = a.getDistance();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public abstract int calculateCaloricWaste();
}
