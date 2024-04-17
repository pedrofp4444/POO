package MakeItFit.activities.types;

import MakeItFit.activities.Activity;

public abstract class Distance extends Activity {
    private double distance;

    public Distance(int expectedDuration, String designation, double distance) {
        super(expectedDuration, designation);
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

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Distance)) return false;
        Distance d = (Distance) o;
        return (super.equals(d) && this.distance == d.distance);
    }
}
