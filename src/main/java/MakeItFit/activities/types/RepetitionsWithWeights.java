package MakeItFit.activities.types;
import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

public abstract class RepetitionsWithWeights extends Repetitions{
    private double weight;

    public RepetitionsWithWeights(int userCode, int code, MakeItFitDate realizationDate, int expectedDuration, String designation, int repetitions, int series, double weight) {
        super(userCode, code, realizationDate, expectedDuration, designation, repetitions, series);
        this.weight = weight;
    }

    public RepetitionsWithWeights(RepetitionsWithWeights r){
        super(r);
        this.weight = r.getWeight();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract int calculateCaloricWaste();

    public String toString(){
        return super.toString() + "Weight: " + weight + "\n";
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof RepetitionsWithWeights)) return false;
        RepetitionsWithWeights r = (RepetitionsWithWeights) o;
        return super.equals(r) && weight == r.getWeight();
    }

    public abstract RepetitionsWithWeights clone();
}
