package MakeItFit;

import MakeItFit.activities.Activity;
import MakeItFit.exceptions.ExistingEntityConflictException;
import MakeItFit.exceptions.InvalidTypeException;
import MakeItFit.time.TimeManager;
import MakeItFit.users.Gender;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

public class MakeItFitController {

    private MakeItFit makeItFit;
    private String email;
    private String name;
    private TimeManager timeManager;

    public MakeItFitController() {
        this.makeItFit = new MakeItFit();
        this.email = "NO EMAIL";
        this.name = "NO NAME";
        this.timeManager = new TimeManager();
    }

    /**
     * Returns the email of the currently logged in user.
     *
     * @return The email of the currently logged in user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the name of the currently logged in user.
     *
     * @return The name of the currently logged in user.
     */
    public String getName() {
        return name;
    }

    /**
     * Logs the user in using the provided email.
     *
     * @param email The user's email address.
     */
    public void login(String email) throws IllegalArgumentException{
        if(this.makeItFit.existsUserWithEmail(email)) {
            this.email = email;
            this.name = makeItFit.getUser(email).getName();
        } else throw new IllegalArgumentException(email);
    }

    /**
     * Creates a new user with the provided details.
     *
     * @param name The user's name.
     * @param age The user's age.
     * @param gender The user's gender.
     * @param weight The user's weight.
     * @param height The user's height.
     * @param bpm The user's heart rate in beats per minute.
     * @param level The user's experience level.
     * @param address The user's address.
     * @param phone The user's phone number.
     * @param email The user's email address.
     * @throws IllegalArgumentException If any of the provided arguments are invalid.
     * @throws ExistingEntityConflictException If a user with the same email already exists.
     * @throws InvalidTypeException If an invalid type is encountered during user creation.
     */
    public void createUser(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email) throws IllegalArgumentException, ExistingEntityConflictException, InvalidTypeException {
        makeItFit.createUser(name, age, gender, weight, height, bpm, level, address, phone, email);
        this.email = email;
        this.name = name;
    }

    /**
     * Retrieves the user details of the currently logged in user.
     * 
     * @return The user details of the currently logged in user.
     */
    public String getUserDetails() {
        return this.makeItFit.getUser(this.email).toString();
    }

    /**
     * Updates the name of the currently logged in user.
     *
     * @param name The new name of the user.
     */
    public void updateName(String name) {
        this.makeItFit.updateUserName(name, this.email);
        this.name = name;
    }

    /**
     * Updates the age of the currently logged in user.
     *
     * @param age The new age of the user.
     */
    public void updateAge(int age) {
        this.makeItFit.updateUserAge(age, this.email);
    }

    /**
     * Updates the gender of the currently logged in user.
     * 
     * @param gender The new gender of the user.
     */
    public void updateGender(Gender gender) {
        this.makeItFit.updateUserGender(gender, this.email);
    }

    /**
     * Updates the weight of the currently logged in user.
     *
     * @param weight The new weight of the user.
     */
    public void updateWeight(float weight) {
        this.makeItFit.updateUserWeight(weight, this.email);
    }

    /**
     * Updates the height of the currently logged in user.
     *
     * @param height The new height of the user.
     */
    public void updateHeight(int height) {
        this.makeItFit.updateUserHeight(height, this.email);
    }

    /**
     * Updates the heart rate of the currently logged in user.
     *
     * @param bpm The new heart rate of the user.
     */
    public void updateBpm(int bpm) {
        this.makeItFit.updateUserBpm(bpm, this.email);
    }

    /**
     * Updates the fitness level of the currently logged in user.
     *
     * @param level The new fitness level of the user.
     */
    public void updateLevel(int level) {
        this.makeItFit.updateUserLevel(level, this.email);
    }

    /**
     * Updates the address of the currently logged in user.
     *
     * @param address The new address of the user.
     */
    public void updateAddress(String address) {
        this.makeItFit.updateUserAddress(address, this.email);
    }

    /**
     * Updates the phone number of the currently logged in user.
     *
     * @param phone The new phone number of the user.
     */
    public void updatePhone(String phone) {
        this.makeItFit.updateUserPhone(phone, this.email);
    }

    /**
     * Updates the email of the currently logged in user.
     *
     * @param email The new email of the user.
     */
    public void updateEmail(String email) {
        this.makeItFit.updateUserEmail(email, this.email);
        this.email = email;
    }

    /**
     * Adds an activity to the currently logged in user.
     *
     * @param activity The activity to be added.
     */
    public void addActivity(Activity activity) {
        this.makeItFit.addActivityToUser(this.email, activity);
    }

    /**
     * Retrieves a list of all activities from the currently logged in user.
     *
     * @return A list of all activities from the user.
     */
    public List<Activity> getActivities() {
        return this.makeItFit.getActivitiesFromUser(this.email);
    }

    /**
     * Updates the system current date.
     *
     * @param days The number of days to advance the system date.
     */
    public void updateSystemDate(int days) throws IllegalArgumentException {
        this.timeManager.advanceTime(days);
        this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
    }

    /**
     * Creates a new training plan for the currently logged in user.
     *
     * @param startDate The start date of the training plan.
     */
    public void createTrainingPlan(MakeItFitDate startDate) {
        this.makeItFit.createTrainingPlan(makeItFit.getUser(this.email).getCode(), startDate);
    }
}
