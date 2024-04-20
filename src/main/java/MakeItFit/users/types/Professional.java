package MakeItFit.users.types;

import MakeItFit.users.User;
import MakeItFit.users.Gender;

/**
 * The Professional class to define a subclasse of the User class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class Professional extends User {
    private enum Specialization {
        Distance,
        Repetitions,
        DistanceRepetitions,
    } // TODO: Change this for correct implementation with interface

    private Specialization specialization;
    private int frequency;

    /**
     * The parameterized constructor for Professional.
     */
    public Professional(String name, int age, Gender gender, int weight, int height, int bpm, int level, String address, String phone, String email, Specialization specialization, int frequency) {
        super(name, age, gender, weight, height, bpm, level, address, phone, email);
    }

    /**
     * The copy constructor for Professional.
     */
    public Professional(Professional p){
        super(p);
    }

    /**
     * The method getSpecialization for Professional.
     */
    public Specialization getSpecialization() {
        return specialization;
    }

    /**
     * The method setSpecialization for Professional.
     */
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    /**
     * The method getFrequency for Professional.
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * The parameterized constructor for Professional.
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * The method clone for Professional.
     */
    public Professional clone() {
        Professional newUser = new Professional(this);
        return newUser;
    }
}
