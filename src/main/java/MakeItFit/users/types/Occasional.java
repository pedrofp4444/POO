package MakeItFit.users.types;

import MakeItFit.users.Gender;
import MakeItFit.users.User;

import java.io.Serializable;

/**
 * The Occasional class defines a subclass of the User class, representing an occasional user.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class Occasional extends User implements Serializable {
    private int frequency;

    /**
     * Constructs an Occasional user with the specified parameters.
     *
     * @param name      the name of the user
     * @param age       the age of the user
     * @param gender    the gender of the user
     * @param weight    the weight of the user
     * @param height    the height of the user
     * @param bpm       the BPM of the user
     * @param level     the level of the user
     * @param address   the address of the user
     * @param phone     the phone number of the user
     * @param email     the email address of the user
     * @param frequency the frequency of the user's visits, must be a non-negative integer
     */
    public Occasional(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email, int frequency) {
        super(name, age, gender, weight, height, bpm, level, address, phone, email);
        setFrequency(frequency);
    }

    /**
     * Constructs a copy of an Occasional user.
     *
     * @param o the Occasional user to copy
     */
    public Occasional(Occasional o) {
        super(o);
        this.frequency = o.getFrequency();
    }

    /**
     * Returns the frequency of the user's visits.
     *
     * @return the frequency of the user's visits
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Sets the frequency of the user's visits.
     *
     * @param frequency the frequency to set, must be a non-negative integer
     */
    public void setFrequency(int frequency) {
        if (frequency < 0) {
            throw new IllegalArgumentException("Frequency must be a non-negative integer");
        }
        this.frequency = frequency;
    }

    /**
     * Creates and returns a copy of this Occasional user.
     *
     * @return a clone of this Occasional user
     */
    @Override
    public Occasional clone() {
        return new Occasional(this);
    }

    /**
     * Returns a string representation of the Occasional user.
     *
     * @return a string containing the details of the Occasional user
     */
    public String toString() {
        return super.toString() + "        Frequency: " + frequency + "\n" + "        ====================\n";
    }
}
