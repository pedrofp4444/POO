package MakeItFit.activities.types;
import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public abstract class RepetitionsWithWeights extends Repetitions{
    private double weight;

    public RepetitionsWithWeights(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, int repetitions, int series, double weight) {
        super(userCode, realizationDate, expectedDuration, designation, repetitions, series);
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

    @Override
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
