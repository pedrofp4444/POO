package MakeItFit.activities.implementation;

import MakeItFit.activities.types.RepetitionsWithWeights;

public class WeightSquat extends RepetitionsWithWeights {
    public WeightSquat(int expectedDuration, String designation, int repetitions, int series, double weight) {
        super(expectedDuration, designation, repetitions, series, weight);
    }

    public WeightSquat(){
        super();
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
}
