package MakeItFit.users;

import java.util.stream.Collectors;

import MakeItFit.activities.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation for the UserInterface class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public abstract class User implements UserInterface {

    private int code;
    private String name;
    private int age;
    private Gender gender;
    private int weight;
    private int height;
    private int bpm;
    private int level; // TODO: Check usage in our context
    private String address;
    private String phone;
    private String email;
    private List<Activity> activities;

    /**
     * Parameterized constructor of the class User.
     */
    public User(int code, String name, int age, Gender gender, int weight, int height,int bpm , int level, String address, String phone, String email) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bpm = bpm;
        this.level = level; // TODO: Check usage in our context
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.activities = new ArrayList<Activity>();
    }

    /**
     * Copy constructor of the class User.
     */
    public User(User u) {
        this.code = u.getCode();
        this.name = u.getName();
        this.age = u.getAge();
        this.gender = u.getGender();
        this.weight = u.getWeight();
        this.height = u.getHeight();
        this.bpm = u.getBpm();
        this.level = u.level; // TODO: Check usage in our context
        this.address = u.getAddress();
        this.phone = u.getPhone();
        this.email = u.getEmail();
        this.activities = u.getListActivities();
    }

    /**
     * Get the code of the User.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Get the name of the User.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the age of the user.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Get the gender of the user.
     */
    public Gender getGender(){
        return this.gender;
    }

    /**
     * Get the weight of the user.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Get the height of the user.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Get the bpm(beats per minute) of the user.
     */
    public int getBpm() {
        return this.bpm;
    }

    /**
     * Get the level of the user.
     */
    public int getLevel() {
        return this.level;
    } // TODO: Check usage in our context
    
    /**
     * Get the address of the user.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Get the phone of the user.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Get the email of the user.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Get the activities of the user.
     */
    public List<Activity> getListActivities(){
        return this.activities.stream().map(Activity::clone).collect(Collectors.toList());
    }

    /**
     * Set the code of the user.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Set the name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the age of the user.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Set the gender of the name.
     */
    public void setGender(Gender gender){
        this.gender=gender;
    }

    /**
     * Set the weight of the user.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Set the height of the user.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Set the bpm(beats per minute) of the user.
     */
    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    /**
     * Set the level of the user.
     */
    public void setLevel(int level) {
        this.level = level;
    } // TODO: Check usage in our context

    /**
     * Set the address of the user.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the phone of the user.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the activities for the user.
     */
    public void addActivity(Activity activity){
        this.activities.add(activity.clone());
    }

    /**
     * Default method toString for the user.
     */
    public String toString() {
        return "User Code: " + this.code + "\n" +
                "Name: " + this.name + "\n" +
                "Age: " + this.age + "\n" +
                "Gender: " + this.gender + "\n" +
                "Weight: " + this.weight + "\n" +
                "Height: " + this.height + "\n" +
                "Bpm: " + this.bpm + "\n" +
                "Level: " + this.level + "\n" + // TODO: Check usage in our context
                "Address: " + this.address + "\n" +
                "Phone: " + this.phone + "\n" +
                "Email: " + this.email + "\n" +
                "Activities: " + this.activities ;
    }
}
