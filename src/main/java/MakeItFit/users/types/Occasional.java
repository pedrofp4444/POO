package MakeItFit.users.types;

import MakeItFit.users.Gender;
import MakeItFit.users.User;

/**
 * The Occasional class to define a subclasse of the User class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class Occasional extends User {
    private int frequency;

    /**
     * The parameterized constructor for Occasional.
     */
    public Occasional(String name, int age, Gender gender, int weight, int height, int bpm, int level, String address, String phone, String email, int frequency) {
        super(name, age, gender, weight, height, bpm, level, address, phone, email);
        this.frequency = frequency;
    }

    /**
     * The copy constructor for Occasional.
     */
    public Occasional(Occasional o){
        super(o);
        this.frequency = o.getFrequency();
    }

    /**
     * The method getFrequency for Occasional.
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * The method setFrequency for Occasional.
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * The method clone for Occasional.
     */
    public Occasional clone() {
        Occasional newUser = new Occasional(this);
        return newUser;
    }
}
