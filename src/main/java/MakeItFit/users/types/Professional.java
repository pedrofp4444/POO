package MakeItFit.users.types;

import MakeItFit.users.User;
import MakeItFit.users.Gender;

public class Professional extends User {
    private enum Specialization {
        Distance,
        Repetitions,
        DistanceRepetitions,
    } // TODO: Change this for correct implementation with interface

    private Specialization specialization;
    private int frequency;

    public Professional(int code, String name, int age, Gender gender, int weight, int height, int bpm, int level, String address, String phone, String email, Specialization specialization, int frequency) {
        super(code, name, age, gender, weight, height, bpm, level, address, phone, email);
    }

    public Professional(Professional p){
        super(p);
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
