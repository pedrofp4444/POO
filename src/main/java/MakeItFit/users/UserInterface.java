package MakeItFit.users;

import MakeItFit.activities.Activity;

import java.util.*;

/**
 * The UserInterface interface to restrict the implementations connected to users.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public interface UserInterface {

        /**
         * Gets the code of the user.
         */
        UUID getCode();

        /**
         * Gets the name of the user.
         */
        String getName();

        /**
         * Gets the age of the user.
         */
        int getAge();

        /**
         * Gets the gender of the user
         */
        Gender getGender();

        /**
         * Gets the weight of the user.
         */
        float getWeight();

        /**
         * Gets the height of the user.
         */
        int getHeight();

        /**
         * Gets the heart rate of the user.
         */
        int getBpm();

        /**
         * Gets the address of the user.
         */
        String getAddress();

        /**
         * Gets the phone number of the user.
         */
        String getPhone();

        /**
         * Gets the email of the user.
         */
        String getEmail();

        /**
         * Gets the list of activities of the user.
         */
        List<Activity> getListActivities();

        /**
         * Sets the name of the user.
         */
        void setName(String name);

        /**
         * Sets the age of the user.
         */
        void setAge(int age);

        /**
         * Sets the age of the user
         */
        void setGender(Gender gender);

        /**
         * Sets the weight of the user.
         */
        void setWeight(float weight);

        /**
         * Sets the height of the user.
         */
        void setHeight(int height);

        /**
         * Sets the heart rate of the user.
         */
        void setBpm(int bpm);

        /**
         * Sets the address of the user.
         */
        void setAddress(String address);

        /**
         * Sets the phone number of the user.
         */
        void setPhone(String phone);

        /**
         * Sets the email of the user.
         */
        void setEmail(String email);

        /**
         * Adds an activity to the user.
         */
        void addActivity(Activity activity);

        /**
         *  Turns the user into a string.
         */
        String toString();
}
