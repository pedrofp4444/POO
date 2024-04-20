package MakeItFit.activities.implementation;

import MakeItFit.activities.types.RepetitionsWithWeights;
import MakeItFit.utils.makeItFitDate;

public class WeightSquat extends RepetitionsWithWeights {
    public WeightSquat(int userCode, int code, makeItFitDate realizationDate, int expectedDuration, String designation, int repetitions, int series, double weight) {
        super(userCode, code, realizationDate, expectedDuration, designation, repetitions, series, weight);
    }

    public WeightSquat(WeightSquat w){
        super(w);
    }

    public int calculateCaloricWaste(){
        return (int) (getRepetitions() * getSeries() * getWeight() * 0.5);
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof WeightSquat)) return false;
        WeightSquat w = (WeightSquat) o;
        return super.equals(w);
    }

    public WeightSquat clone(){
        WeightSquat newSquat = new WeightSquat(this);
        return newSquat;
    }
}
