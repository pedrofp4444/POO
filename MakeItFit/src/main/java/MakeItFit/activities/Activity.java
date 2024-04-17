package MakeItFit.activities;

public abstract class Activity implements ActivityInterface {
    private int expectedDuration;
    private String designation;

    private int duration;
    private int caloricWaste;

    public Activity(int expectedDuration, String designation) {
        this.expectedDuration = expectedDuration;
        this.designation = designation;
        this.duration = 0;
        this.caloricWaste = 0;
    }

    public Activity(){
        this.expectedDuration = 0;
        this.designation = "Empty Activity";
        this.duration = 0;
        this.caloricWaste = 0;
    }

    public Activity(Activity a){
        this.expectedDuration = a.getExpectedDuration();
        this.designation = a.getDesignation();
        this.duration = a.getDuration();
        this.caloricWaste = a.getCaloricWaste();
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public String getDesignation() {
        return designation;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloricWaste() {
        return caloricWaste;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCaloricWaste(int caloricWaste) {
        this.caloricWaste = caloricWaste;
    }

    public abstract int calculateCaloricWaste();

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Activity)) return false;
        Activity a = (Activity) o;
        return (this.expectedDuration == a.expectedDuration && this.designation.equals(a.designation));
    }
}
