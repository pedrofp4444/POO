package MakeItFit.activities;

public abstract class Activity implements ActivityInterface {
    private int duration;
    private int expectedDuration;
    private String designation;
    private int caloricWaste;

    public Activity(int duration, int expectedDuration, String designation, int caloricWaste) {
        this.duration = duration;
        this.expectedDuration = expectedDuration;
        this.designation = designation;
        this.caloricWaste = caloricWaste;
    }

    public Activity(){
        this.duration = 0;
        this.expectedDuration = 0;
        this.designation = "";
        this.caloricWaste = 0;
    }

    public Activity(Activity a){
        this.duration = a.getDuration();
        this.expectedDuration = a.getExpectedDuration();
        this.designation = a.getDesignation();
        this.caloricWaste = a.getCaloricWaste();
    }

    public int getDuration() {
        return duration;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public String getDesignation() {
        return designation;
    }

    public int getCaloricWaste() {
        return caloricWaste;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setCaloricWaste(int caloricWaste) {
        this.caloricWaste = caloricWaste;
    }

    public abstract int calculateCaloricWaste();
}
