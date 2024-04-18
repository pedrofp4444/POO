package MakeItFit.users;

import MakeItFit.activities.Activity;

import java.util.List;

public interface UserInterface {

        int getCode();

        String getName();

        int getAge();

        Gender getGender();

        int getWeight();

        int getHeight();

        int getBpm();

        String getAddress();

        String getPhone();

        String getEmail();

        List<Activity> getListActivities();


        void setCode(int code);

        void setName(String name);

        void setAge(int age);

        void setGender(Gender gender);

        void setWeight(int weight);

        void setHeight(int height);

        void setBpm(int bpm);

        void setAddress(String address);

        void setPhone(String phone);

        void setEmail(String email);

        void addActivity(Activity activity);

        String toString();
}
