package MakeItFit.users.types;

import MakeItFit.users.User;
import MakeItFit.users.Gender;

/**
 * The Professional class defines a subclass of the User class representing a professional athlete.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class Professional extends User {
    /**
     * The specialization options for a professional athlete.
     */
    public enum Specialization {
        Distance,
        Repetitions,
        DistanceRepetitions
    }

    private Specialization specialization;
    private int frequency;

    /**
     * The parameterized constructor for Professional.
     * Initializes a Professional with the given parameters.
     *
     * @param name         the name of the professional
     * @param age          the age of the professional
     * @param gender       the gender of the professional
     * @param weight       the weight of the professional
     * @param height       the height of the professional
     * @param bpm          the baseline pulse of the professional
     * @param level        the experience level of the professional
     * @param address      the address of the professional
     * @param phone        the phone number of the professional
     * @param email        the email of the professional
     * @param specialization the specialization of the professional
     * @param frequency    the training frequency of the professional
     */
    public Professional(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email, Specialization specialization, int frequency) {
        super(name, age, gender, weight, height, bpm, level, address, phone, email);
        this.specialization = specialization;
        this.frequency = frequency;
    }

    /**
     * The copy constructor for Professional.
     * Creates a new Professional by copying the fields of another Professional.
     *
     * @param p the Professional to copy
     */
    public Professional(Professional p) {
        super(p);
        this.specialization = p.specialization;
        this.frequency = p.frequency;
    }

    /**
     * Gets the specialization of the professional.
     *
     * @return the specialization of the professional
     */
    public Specialization getSpecialization() {
        return specialization;
    }

    /**
     * Sets the specialization of the professional.
     *
     * @param specialization the new specialization to set
     */
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets the training frequency of the professional.
     *
     * @return the training frequency of the professional
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Sets the training frequency of the professional.
     *
     * @param frequency the new training frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Clones the Professional object, creating a new instance with the same values.
     *
     * @return a cloned instance of the professional
     */
    @Override
    public Professional clone() {
        return new Professional(this);
    }
}
