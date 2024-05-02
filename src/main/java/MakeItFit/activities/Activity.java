package MakeItFit.activities;

import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public abstract class Activity implements ActivityInterface {
    private UUID userCode;
    private UUID code;
    private MakeItFitDate realizationDate;
    private int expectedDuration;
    private String designation;

    private String specialization;
    private int duration;
    private int caloricWaste;

    public Activity(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation) {
        this.userCode = userCode;
        this.code = UUID.randomUUID();
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

    public UUID getUserCode(){ return this.userCode; }

    public UUID getCode(){ return this.code;}

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

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public abstract int calculateCaloricWaste();

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Activity)) return false;
        Activity a = (Activity) o;
        return (this.expectedDuration == a.expectedDuration && this.designation.equals(a.designation));
    }

    public abstract Activity clone();

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Activity: ").append(this.designation).append(", ");
        sb.append("Expected Duration: ").append(this.expectedDuration).append(", ");
        sb.append("Realization Date: ").append(this.realizationDate).append(", ");
        sb.append("Duration: ").append(this.duration).append(", ");
        sb.append("Caloric Waste: ").append(this.caloricWaste).append(", ");
        return sb.toString();
    }
}
