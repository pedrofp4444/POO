package MakeItFit.activities.implementation;

import MakeItFit.activities.types.Distance;
import MakeItFit.utils.makeItFitDate;

public class Running extends Distance {
    private double averageSpeed;

    public Running(int userCode, int code, makeItFitDate realizationDate, int expectedDuration, String designation, double distance, double speed) {
        super(userCode, code, realizationDate, expectedDuration, designation, distance);
        this.averageSpeed = speed;
    }

    public Running(Running r){
        super(r);
        this.averageSpeed = r.getSpeed();
    }

    public double getSpeed() {
        return averageSpeed;
    }

    public void setSpeed(double speed) {
        this.averageSpeed = speed;
    }

    public int calculateCaloricWaste(){
        return (int) (getDistance() * averageSpeed); //we can change it to a more complex formula
    }

    public String toString(){
        return super.toString() + "Speed: " + averageSpeed + "\n";
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Running)) return false;
        Running r = (Running) o;
        return super.equals(r) && averageSpeed == r.getSpeed();
    }

    public Running clone(){
        Running newRun = new Running(this);
        return newRun;
    }
}
