package MakeItFit;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.activities.implementation.Running;
import MakeItFit.activities.implementation.Trail;
import MakeItFit.activities.implementation.WeightSquat;
import MakeItFit.exceptions.*;
import MakeItFit.time.TimeManager;
import MakeItFit.users.Gender;
import MakeItFit.utils.MakeItFitDate;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * The class MakeItFitController represents the connection between the views and the MakeItFit.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MakeItFitController {

    private MakeItFit makeItFit;
    public String email;
    private String name;
    private UUID trainingPlan;
    private TimeManager timeManager;

    public MakeItFitController() {
        this.makeItFit = new MakeItFit();
        this.email = "NO EMAIL";
        this.name = "NO NAME";
        this.timeManager = new TimeManager();
    }

    /**
     * Sets the email of the currently working user.
     *
     * @param email The email of the currently logged in user.
     * @throws EntityDoesNotExistException The exception that can happen.
     */
    public void setEmail(String email) throws EntityDoesNotExistException {
        this.email = email;
        try {
            this.name = this.makeItFit.getUser(email).getName();
        } catch (Exception e) {
            throw new EntityDoesNotExistException(email);
        }
    }

    /**
     * Sets the email of the currently working user.
     *
     * @param email The email of the currently logged in user.
     * @throws EntityDoesNotExistException The exception that can happen.
     */
    public void setNewEmail(String email) throws EntityDoesNotExistException {
        this.email = email;
    }

    /**
     * Sets the code of the training plan.
     * 
     * @param trainingPlan The code of the training plan.
     */
    public void setTrainingPlan(UUID trainingPlan) {
        this.trainingPlan = trainingPlan;
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
    public void login(String email) throws IllegalArgumentException {
        this.email = email;
        if(this.makeItFit.existsUserWithEmail(email)) {
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
     * @param frequency The user's training frequency.
     * @param type The user's type.
     * @throws IllegalArgumentException If any of the provided arguments are invalid.
     * @throws ExistingEntityConflictException If a user with the same email already exists.
     * @throws InvalidTypeException If an invalid type is encountered during user creation.
     */
    public void createUser(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, int frequency, String type) throws IllegalArgumentException, ExistingEntityConflictException, InvalidTypeException {
        makeItFit.createUser(name, age, gender, weight, height, bpm, level, address, phone, this.email, frequency, type);
        this.name = name;
    }

    /**
     * Removes the currently working user.
     */
    public void removeUser() {
        this.makeItFit.removeUser(this.email);
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
     * Gets all the users in the system.
     * 
     * @return A list of all users in the system.
     */
    public String getAllUsers() {
        return this.makeItFit.getAllUsers().toString();
    }

    /**
     * Retrieves a list of all activities from the currently logged in user.
     *
     * @return A String of all activities from the user.
     */
    public String getActivities() {
        return this.makeItFit.getActivitiesFromUser(this.email).toString();
    }

    /**
     * Adds a new push-up activity to the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     */
    public void addActivityToUser(MakeItFitDate date, int duration, String designation, String name, int repetitions, int series) {
        PushUp activity = new PushUp(this.makeItFit.getUser(this.email).getCode() , date, duration, designation, name, repetitions, series);
        this.makeItFit.addActivityToUser(this.email, activity);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Adds a new running activity to the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param speed The speed of the activity.
     */
    public void addActivityToUser(MakeItFitDate date, int duration, String designation, String name, double distance, double speed) {
        Running activity = new Running(this.makeItFit.getUser(email).getCode(), date, duration, designation, name, distance, speed);
        this.makeItFit.addActivityToUser(this.email, activity);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Adds a new trail activity to the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param elevationGain The elevation gain of the activity.
     * @param elevationLoss The elevation loss of the activity.
     * @param trailType The trail type of the activity.
     */
    public void addActivityToUser(MakeItFitDate date, int duration, String designation, String name, double distance, double elevationGain, double elevationLoss, int trailType) {
        Trail activity = new Trail(this.makeItFit.getUser(email).getCode(), date, duration, designation, name, distance, elevationGain, elevationLoss, trailType);
        this.makeItFit.addActivityToUser(this.email, activity);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Adds a new  weight squat activity to the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     * @param weight The weight of the activity.
     */
    public void addActivityToUser(MakeItFitDate date, int duration, String designation, String name, int repetitions, int series, double weight) {
        WeightSquat activity = new WeightSquat(this.makeItFit.getUser(email).getCode(), date, duration, designation, name, repetitions, series, weight);
        this.makeItFit.addActivityToUser(this.email, activity);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Removes the currently working activity.
     */
    public void removeActivityFromUser(UUID activity) {
        this.makeItFit.removeActivityFromUser(this.email, activity);
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
       this.trainingPlan = this.makeItFit.createTrainingPlan(makeItFit.getUser(this.email).getCode(), startDate);
    }

    /**
     * Removes the currently working training plan.
     */
    public void removeTrainingPlan() {
        this.makeItFit.removeTrainingPlan(this.trainingPlan);
    }

    /**
     * Creates a new training plan for the currently logged in user.
     *
     * @param hardActivity Whether the training plan should include hard activities.
     * @param maxActivitiesPerDay The maximum number of activities per day.
     * @param maxDifferentActivities The maximum number of different activities.
     * @param weeklyRecurrence The weekly recurrence of the training plan.
     * @param minimumCaloricWaste The minimum caloric waste of the training plan.
     */
    public void constructTrainingPlanByObjectives(boolean hardActivity, int maxActivitiesPerDay, int maxDifferentActivities, int weeklyRecurrence, int minimumCaloricWaste) throws IllegalArgumentException {
        this.makeItFit.constructTrainingPlanByObjectives(this.makeItFit.getTrainingPlan(this.trainingPlan), hardActivity, maxActivitiesPerDay, maxDifferentActivities, weeklyRecurrence, minimumCaloricWaste);
    }

    /**
     * Adds a new activity to one of the training plans of the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityToTrainingPlan(MakeItFitDate date, int duration, String designation, String name, int repetitions, int series, int iterations) {
        PushUp activity = new PushUp(this.makeItFit.getUser(this.email).getCode() , date, duration, designation, name, repetitions, series);
        this.makeItFit.addActivityToTrainingPlan(this.trainingPlan, activity, iterations);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Adds a new activity to one of the training plans of the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param speed The speed of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityToTrainingPlan(MakeItFitDate date, int duration, String designation, String name, double distance, double speed, int iterations) {
        Running activity = new Running(this.makeItFit.getUser(this.email).getCode() , date, duration, designation, name, distance, speed);
        this.makeItFit.addActivityToTrainingPlan(this.trainingPlan, activity, iterations);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Adds a new activity to one of the training plans of the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param elevationGain The elevation gain of the activity.
     * @param elevationLoss The elevation loss of the activity.
     * @param trailType The trail type of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityToTrainingPlan(MakeItFitDate date, int duration, String designation, String name, double distance, double elevationGain, double elevationLoss, int trailType, int iterations) {
        Trail activity = new Trail(this.makeItFit.getUser(this.email).getCode() , date, duration, designation, name, distance, elevationGain, elevationLoss, trailType);
        this.makeItFit.addActivityToTrainingPlan(this.trainingPlan, activity, iterations);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Adds a new activity to one of the training plans of the currently logged in user.
     *
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     * @param weight The weight of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityToTrainingPlan(MakeItFitDate date, int duration, String designation, String name, int repetitions, int series, double weight, int iterations) {
        WeightSquat activity = new WeightSquat(this.makeItFit.getUser(this.email).getCode(), date, duration, designation, name, repetitions, series, weight);
        this.makeItFit.addActivityToTrainingPlan(this.trainingPlan, activity, iterations);
        if (this.timeManager.getCurrentDate().isAfter(date)){
            this.makeItFit.updateSystem(this.timeManager.getCurrentDate(), this.makeItFit.getUser(this.email).getCode());
        }
    }

    /**
     * Removes the currently working activity from the training plan.
     */
    public void removeActivityFromTrainingPlan(UUID activity) {
        this.makeItFit.removeActivityFromTrainingPlan(this.trainingPlan, activity);
    }

    /**
     * Retrieves a list of all training plans from the currently logged in user.
     *
     * @return A String of all training plans from the user.
     */
    public String getTrainingPlansFromUser() {
        return this.makeItFit.getTrainingPlansFromUser(this.makeItFit.getUser(this.email).getCode()).toString();
    }

    /**
     * Retrieves a list of all activities from a training plan of the currently logged in user.
     *
     * @return A String of all activities from the training plan.
     */
    public String getTrainingPlans() {
        return this.makeItFit.getAllTrainingPlans().toString();
    }

    /**
     * Saves the system to a file.
     * 
     * @param fileName The name of the file to save the system to.
     */
    public void saveSystem(String fileName) throws FileNotFoundException {
        this.makeItFit.saveSystem(fileName);
    }

    /**
     * Loads the system from a file.
     *
     * @param fileName The name of the file to load the system from.
     */
    public void loadSystem(String fileName) throws FileNotFoundException {
        this.makeItFit.loadSystem(fileName);
    }

    /**
     * Executes a query and returns the result.
     * @param date1 If wanted, the start date of the period.
     * @param date2 If wanted, the end date of the period.
     * @return number of km the user did in a given period of time or in total
     */
    public double executeQueryHowManyKMsDone(MakeItFitDate date1, MakeItFitDate date2) {
        return this.makeItFit.executeQueryHowManyKMsDone(this.email, date1, date2);
    }

    /**
     * Executes a query and returns the result.
     * @return number of km the user did in a given period of time or in total
     */
    public double executeQueryHowManyKMsDone() {
        return this.makeItFit.executeQueryHowManyKMsDone(this.email);
    }

    /**
     * Executes a query and returns the result.
     * @param date1 If wanted, the start date of the period.
     * @param date2 If wanted, the end date of the period.
     * @return number of altimetry the user did in a given period of time or in total
     */
    public double executeQueryHowManyAltimetryDone(MakeItFitDate date1, MakeItFitDate date2) {
        return this.makeItFit.executeQueryHowManyAltimetryDone(this.email, date1, date2);
    }

    /**
     * Executes a query and returns the result.
     * @return number of altimetry the user did in a given period of time or in total
     */
    public double executeQueryHowManyAltimetryDone() {
        return this.makeItFit.executeQueryHowManyAltimetryDone(this.email);
    }

    /**
     *  Executes a query and returns the result.
     * 
     * @return The most demanding training plan.
     */
    public String executeQueryMostDemandingTrainingPlan(){
        return this.makeItFit.executeQueryMostDemandingTrainingPlan().toString();
    }

    /**
     * Executes a query and returns the result.
     * @return The most done activity.
     */
    public String executeQueryMostDoneActivity() {
        return this.makeItFit.executeQueryMostDoneActivity();
    }

    /**
     * Executes a query and returns the result.
     * @param date1 If wanted, the start date of the period.
     * @param date2 If wanted, the end date of the period.
     * @return the user who burns more calories between two dates or in total
     */
    public String executeQuerywhoBurnsMoreCalories(MakeItFitDate date1, MakeItFitDate date2) {
        return this.makeItFit.executeQuerywhoBurnsMoreCalories(date1, date2).toString();
    }

    /**
     * Executes a query and returns the result.
     * @return the user who burns more calories between two dates or in total
     */
    public String executeQuerywhoBurnsMoreCalories() {
        return this.makeItFit.executeQuerywhoBurnsMoreCalories().toString();
    }

    /**
     *  Executes a query and returns the result.
     * @param date1 If wanted, the start date of the period.
     * @param date2 If wanted, the end date of the period.
     * @return the user who did the most activities between two dates or in total
     */
    public String executeQueryWhoDidTheMostActivities(MakeItFitDate date1, MakeItFitDate date2) {
        return this.makeItFit.executeQueryWhoDidTheMostActivities(date1, date2).toString();
    }

    /**
     *  Executes a query and returns the result.
     * @return the user who did the most activities between two dates or in total
     */
    public String executeQueryWhoDidTheMostActivities() {
        return this.makeItFit.executeQueryWhoDidTheMostActivities().toString();
    }
}
