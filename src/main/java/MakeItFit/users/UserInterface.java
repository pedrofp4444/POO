package MakeItFit.users;

import MakeItFit.activities.Activity;

import java.util.*;

/**
 * The UserInterface interface to restrict the implementations connected to users.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public interface UserInterface {

        UUID getCode();

        String getName();

        int getAge();

        Gender getGender();

        float getWeight();

        int getHeight();

        int getBpm();

        String getAddress();

        String getPhone();

        String getEmail();

        List<Activity> getListActivities();


        void setName(String name);

        void setAge(int age);

        void setGender(Gender gender);

        void setWeight(float weight);

        void setHeight(int height);

        void setBpm(int bpm);

        void setAddress(String address);

        void setPhone(String phone);

        void setEmail(String email);

        void addActivity(Activity activity);

        String toString();
}
