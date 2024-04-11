package MakeItFit.activities.types;

public abstract class RepetitionsWithWeights extends Repetitions{
    private double weight;

    public RepetitionsWithWeights(int repetitions, int series, double weight) {
        super(repetitions, series);
        this.weight = weight;
    }

    public RepetitionsWithWeights(){
        super();
        this.weight = 0;
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

}
