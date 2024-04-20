package MakeItFit.activities.implementation;

import MakeItFit.activities.types.Repetitions;
import MakeItFit.utils.makeItFitDate;

public class PushUp extends Repetitions {
    public PushUp(int userCode, int code, makeItFitDate realizationDate, int expectedDuration, String designation, int repetitions, int series) {
        super(userCode, code, realizationDate, expectedDuration, designation, repetitions, series);
    }

    public PushUp(PushUp p){
        super(p);
    }

    public int calculateCaloricWaste(){
        return (int) (getRepetitions() * getSeries() * 0.5);
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof PushUp)) return false;
        PushUp p = (PushUp) o;
        return super.equals(p);
    }

    public PushUp clone(){
        PushUp newPushUp = new PushUp(this);
        return newPushUp;
    }
}
