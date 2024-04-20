package MakeItFit.activities.types;

import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

public abstract class Distance extends Activity {
    private double distance;

    public Distance(int userCode, int code, MakeItFitDate realizationDate, int expectedDuration, String designation, double distance) {
        super(userCode, code, realizationDate, expectedDuration, designation);
        this.distance = distance;
    }

    public Distance(Distance d){
        super(d);
        this.distance = d.getDistance();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public abstract int calculateCaloricWaste();

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Distance)) return false;
        Distance d = (Distance) o;
        return (super.equals(d) && this.distance == d.distance);
    }

    public abstract Distance clone();
}
