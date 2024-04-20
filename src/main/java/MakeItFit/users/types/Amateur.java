package MakeItFit.users.types;

import MakeItFit.users.Gender;
import MakeItFit.users.User;

/**
 * The Amateur class to define a subclasse of the User class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class Amateur extends User {

    /**
     * The parameterized constructor for Amateur.
     */
    public Amateur(String name, int age, Gender gender, int weight, int height, int bpm,int level,  String address, String phone, String email) {
        super(name, age, gender, weight, height, bpm,level ,address, phone, email);
    }

    /**
     * The copy constructor for Amateur.
     */
    public Amateur(Amateur a){
        super(a);
    }

    /**
     * The clone method for Amateur.
     */
    public Amateur clone() {
        Amateur newUser = new Amateur(this);
        return newUser;
    }
}
