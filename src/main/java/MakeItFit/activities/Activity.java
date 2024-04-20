package MakeItFit.activities;

import MakeItFit.utils.MakeItFitDate;

public abstract class Activity implements ActivityInterface {
    private int userCode;

    private int code;
    private MakeItFitDate realizationDate;
    private int expectedDuration;
    private String designation;

    private int duration;
    private int caloricWaste;

    public Activity(int userCode, int code, MakeItFitDate realizationDate, int expectedDuration, String designation) {
        this.userCode = userCode;
        this.code = code;
        this.realizationDate = realizationDate;
        this.expectedDuration = expectedDuration;
        this.designation = designation;
        this.duration = 0;
        this.caloricWaste = 0;
    }

    public Activity(Activity a){
        this.userCode = a.getUserCode();
        this.code = a.getCode();
        this.realizationDate = a.getRealizationDate();
        this.expectedDuration = a.getExpectedDuration();
        this.designation = a.getDesignation();
        this.duration = a.getDuration();
        this.caloricWaste = a.getCaloricWaste();
    }

    public int getUserCode(){ return this.userCode; }

    public int getCode(){ return this.code;}

    public MakeItFitDate getRealizationDate(){
        return this.realizationDate;
    }

    public int getExpectedDuration() {
        return this.expectedDuration;
    }

    public String getDesignation() {
        return this.designation;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getCaloricWaste() {
        return this.caloricWaste;
    }

    public void setUserCode(int userCode){ this.userCode = userCode; }

    public void setCode(int code){ this.code = code; }

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

    public abstract Activity clone();
}
