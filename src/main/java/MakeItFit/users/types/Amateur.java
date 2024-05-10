package MakeItFit.users.types;

import MakeItFit.users.Gender;
import MakeItFit.users.User;

import java.io.Serializable;

/**
 * A class that represents an amateur user, extending the User class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class Amateur extends User implements Serializable {

    /**
     * Constructs an Amateur user with the specified details.
     *
     * @param name The name of the amateur user.
     * @param age The age of the amateur user.
     * @param gender The gender of the amateur user.
     * @param weight The weight of the amateur user.
     * @param height The height of the amateur user.
     * @param bpm The beats per minute of the amateur user.
     * @param level The level of the amateur user.
     * @param address The address of the amateur user.
     * @param phone The phone number of the amateur user.
     * @param email The email of the amateur user.
     */
    public Amateur(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email) {
        super(name, age, gender, weight, height, bpm, level, address, phone, email);
    }

    /**
     * Copy constructor that creates a new Amateur user by copying the attributes of another.
     *
     * @param amateur The amateur user to copy.
     */
    public Amateur(Amateur amateur) {
        super(amateur);
    }

    /**
     * Clones this Amateur user, creating a new instance with the same attributes.
     *
     * @return A new Amateur user with the same attributes as this one.
     */
    @Override
    public Amateur clone() {
        return new Amateur(this);
    }

    /**
     * Returns a string representation of this Amateur user.
     *
     * @return A string representation of this Amateur user.
     */
    public String toString() {
        return super.toString() + "        ====================\n";
    }
}
