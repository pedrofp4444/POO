package MakeItFit.activities.implementation;

import MakeItFit.activities.types.Distance;

public class Running extends Distance {
    private double averageSpeed;

    public Running(int duration, int expectedDuration, String designation, int caloricWaste, double distance, double speed) {
        super(duration, expectedDuration, designation, caloricWaste, distance);
        this.averageSpeed = speed;
    }

    public Running(){
        super();
        this.averageSpeed = 0;
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

}
