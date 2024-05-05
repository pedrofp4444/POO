package MakeItFit;

import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.*;
import MakeItFit.exceptions.*;
import MakeItFit.trainingPlan.*;
import MakeItFit.users.*;
import MakeItFit.utils.MakeItFitDate;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class MakeItFit implements Serializable {

    private UserManager userManager;
    private TrainingPlanManager trainingPlanManager;

    public MakeItFit() {
        this.userManager = new UserManager();
        this.trainingPlanManager = new TrainingPlanManager();
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
     * @param frequency The user's training frequency.
     * @param type The user's type.
     * @throws IllegalArgumentException If any of the provided arguments are invalid.
     * @throws ExistingEntityConflictException If a user with the same email already exists.
     * @throws InvalidTypeException If an invalid type is encountered during user creation.
     */
    public void createUser(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email, int frequency, String type) throws IllegalArgumentException, ExistingEntityConflictException, InvalidTypeException {
        User user = this.userManager.createUser(name, age, gender, weight, height, bpm, level, address, phone, email, frequency, type);
        this.userManager.insertUser(user);
    }

    /**
     * Removes a user based on the provided identifier.
     *
     * @param identifier The user's identifier, either a UUID or email.
     * @throws EntityDoesNotExistException If the user does not exist.
     * @throws InvalidTypeException If the identifier type is neither UUID nor String.
     */
    public void removeUser(Object identifier) throws EntityDoesNotExistException {
        if (identifier instanceof UUID) {
            this.userManager.removeUserByCode((UUID) identifier);
        } else if (identifier instanceof String) {
            this.userManager.removeUserByEmail((String) identifier);
        } else {
            throw new InvalidTypeException();
        }
    }

    /**
     * Checks whether a user with the specified email exists.
     *
     * @param email The user's email address.
     * @return `true` if a user with the email exists, `false` otherwise.
     */
    public boolean existsUserWithEmail(String email) {
        return this.userManager.existsUserWithEmail(email);
    }

    /**
     * Retrieves a user based on the provided identifier.
     *
     * @param identifier The user's identifier, either a UUID or email.
     * @return The retrieved user.
     * @throws InvalidTypeException If the identifier type is neither UUID nor String.
     */
    public User getUser(Object identifier) throws InvalidTypeException {
        if (identifier instanceof UUID) {
            return this.userManager.getUserByCode((UUID) identifier);
        } else if (identifier instanceof String) {
            return this.userManager.getUserByEmail((String) identifier);
        } else {
            throw new InvalidTypeException();
        }
    }

    /**
     * Updates the user's name.
     *
     * @param name The new name for the user.
     * @param email The user's email.
     */
    public void updateUserName(String name, String email) {
        User user = getUser(email);
        user.setName(name);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's age.
     *
     * @param age The new age for the user.
     * @param email The user's email.
     */
    public void updateUserAge(int age, String email) {
        User user = getUser(email);
        user.setAge(age);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's gender.
     * 
     * @param gender The new gender for the user.
     * @param email The user's email.
     */
    public void updateUserGender(Gender gender, String email) {
        User user = getUser(email);
        user.setGender(gender);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's weight.
     *
     * @param weight The new weight for the user.
     * @param email The user's email.
     */
    public void updateUserWeight(float weight, String email) {
        User user = getUser(email);
        user.setWeight(weight);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's height.
     *
     * @param height The new height for the user.
     * @param email The user's email.
     */
    public void updateUserHeight(int height, String email) {
        User user = getUser(email);
        user.setHeight(height);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's heart rate in beats per minute (BPM).
     *
     * @param bpm The new BPM for the user.
     * @param email The user's email.
     */

    public void updateUserBpm(int bpm, String email) {
        User user = getUser(email);
        user.setBpm(bpm);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's experience level.
     *
     * @param level The new experience level for the user.
     * @param email The user's email.
     */
    public void updateUserLevel(int level, String email) {
        User user = getUser(email);
        user.setLevel(level);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's address.
     *
     * @param address The new address for the user.
     * @param email The user's email.
     */
    public void updateUserAddress(String address, String email) {
        User user = getUser(email);
        user.setAddress(address);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's phone number.
     *
     * @param phone The new phone number for the user.
     * @param email The user's email.
     */
    public void updateUserPhone(String phone, String email) {
        User user = getUser(email);
        user.setPhone(phone);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's email address.
     *
     * @param email The new email address for the user.
     * @param email The user's email.
     */
    public void updateUserEmail(String email, String newEmail) {
        User user = getUser(email);
        user.setEmail(newEmail);
        this.userManager.updateUser(user);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return this.userManager.getAllUsers();
    }

    /**
     * Retrieves a list of all activities from a user.
     *
     * @param email The user's email address.
     * @return A list of all activities from the user.
     */
    public List<Activity> getActivitiesFromUser(String email) {
        return this.userManager.getActivitiesFromUser(email);
    }

    /**
     * Adds an activity to a user.
     *
     * @param email The user's email.
     * @param activity The activity to be added.
     */
    public void addActivityToUser(String email, Activity activity) {
        this.userManager.addActivityToUser(email, activity);
    }

    /**
     * Adds a push-up activity to a user.
     *
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     */
    public void addActivityPushUpToUser(String email, MakeItFitDate date, int duration, String designation, String name, int repetitions, int series) {
        PushUp activity = new PushUp(this.userManager.getUserByEmail(email).getCode() , date, duration, designation, name, repetitions, series);
        this.userManager.addActivityToUser(email, activity);
    }

    /**
     * Adds a running activity to a user.
     *
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param speed The speed of the activity.
     */
    public void addActivityRunningToUser(String email, MakeItFitDate date, int duration, String designation, String name, double distance, double speed) {
        Running activity = new Running(this.userManager.getUserByEmail(email).getCode(), date, duration, designation, name, distance, speed);
        this.userManager.addActivityToUser(email, activity);
    }

    /**
     * Adds a trail activity to a user.
     *
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param elevationGain The elevation gain of the activity.
     * @param elevationLoss The elevation loss of the activity.
     * @param trailType The type of the trail.
     */
    public void addActivityTrailToUser(String email, MakeItFitDate date, int duration, String designation, String name, double distance, double elevationGain, double elevationLoss, int trailType) {
        Trail activity = new Trail(this.userManager.getUserByEmail(email).getCode(), date, duration, designation, name, distance, elevationGain, elevationLoss, trailType);
        this.userManager.addActivityToUser(email, activity);
    }

    /**
     * Adds a weight squat activity to a user.
     *
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     * @param weight The weight of the activity.
     */
    public void addActivityWeightSquatToUser(String email, MakeItFitDate date, int duration, String designation, String name, int repetitions, int series, double weight) {
        WeightSquat activity = new WeightSquat(this.userManager.getUserByEmail(email).getCode(), date, duration, designation, name, repetitions, series, weight);
        this.userManager.addActivityToUser(email, activity);
    }


    // TODO: SEPARATION BETWEEN USER AND TRAINING PLAN


    /**
     * Creates a new training plan based on the provided specifications.
     *
     * @param userCode  The code of the user for whom the training plan will be created.
     * @param startDate The start date of the new training plan.
     * @return The code of the created training plan.
     * @throws IllegalArgumentException If the provided arguments are not valid.
     */
    public UUID createTrainingPlan(UUID userCode, MakeItFitDate startDate) throws IllegalArgumentException {
        TrainingPlan trainingPlan = this.trainingPlanManager.createTrainingPlan(userCode, startDate);
        this.trainingPlanManager.insertTrainingPlan(trainingPlan);
        return trainingPlan.getCode();
    }

    /**
     * Creates a new training plan based on the provided objectives.
     *
     * @param trainingPlan The training plan in usage.
     * @param hardActivity Whether the activities should be hard.
     * @param maxActivitiesPerDay The maximum number of activities per day.
     * @param maxDifferentActivities The maximum number of different activities.
     * @param weeklyRecurrence The weekly recurrence of the activities.
     * @param minimumCaloricWaste The minimum caloric waste of the activities.
     * @throws IllegalArgumentException If the provided arguments are not valid.
     */
    public void constructTrainingPlanByObjectives(TrainingPlan trainingPlan, boolean hardActivity, int maxActivitiesPerDay, int maxDifferentActivities, int weeklyRecurrence, int minimumCaloricWaste) throws IllegalArgumentException {
        this.trainingPlanManager.constructTrainingPlanByObjectives(trainingPlan, this.userManager.getUserByCode(trainingPlan.getUserCode()).getIndex(), hardActivity, maxActivitiesPerDay, maxDifferentActivities, weeklyRecurrence, minimumCaloricWaste);
    }

    /**
     * Removes a training plan based on the provided code.
     *
     * @param code The code of the training plan to be removed.
     */
    public void removeTrainingPlan(UUID code) {
        this.trainingPlanManager.removeTrainingPlan(code);
    }

    /**
     * Retrieves a training plan based on the provided code.
     *
     * @param code The code of the training plan to be retrieved.
     * @throws IllegalArgumentException If the provided code is not valid.
     * @return The retrieved training plan.
     */
    public TrainingPlan getTrainingPlan(UUID code) throws IllegalArgumentException {
        return this.trainingPlanManager.getTrainingPlan(code);
    }

    /**
     * Updates a training plan based on the provided details.
     *
     * @param trainingPlan The updated training plan.
     * @throws EntityDoesNotExistException If the training plan does not exist.
     */
    public void updateTrainingPlan(TrainingPlan trainingPlan) throws EntityDoesNotExistException {
        this.trainingPlanManager.updateTrainingPlan(trainingPlan);
    }

    /**
     * Returns a list of all existing training plans.
     *
     * @return A list of all training plans.
     */
    public List<TrainingPlan> getAllTrainingPlans() {
        return this.trainingPlanManager.getAllTrainingPlans();
    }

    /**
     * Adds a push-up activity to a training plan from a user.
     *
     * @param code The code of the training plan.
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityPushUpToTrainingPlan(UUID code, String email, MakeItFitDate date, int duration, String designation, String name, int repetitions, int series, int iterations) {
        PushUp activity = new PushUp(this.userManager.getUserByEmail(email).getCode() , date, duration, designation, name, repetitions, series);
        this.trainingPlanManager.addActivity(code, iterations, activity);
    }

    /**
     * Adds a running activity to a training plan from a user.
     *
     * @param code The code of the training plan.
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param speed The speed of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityRunningToTrainingPlan(UUID code, String email, MakeItFitDate date, int duration, String designation, String name, double distance, double speed, int iterations) {
        Running activity = new Running(this.userManager.getUserByEmail(email).getCode(), date, duration, designation, name, distance, speed);
        this.trainingPlanManager.addActivity(code, iterations, activity);
    }

    /**
     * Adds a trail activity to a training plan from a user.
     *
     * @param code The code of the training plan.
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param distance The distance of the activity.
     * @param elevationGain The elevation gain of the activity.
     * @param elevationLoss The elevation loss of the activity.
     * @param trailType The type of the trail.
     * @param iterations The iterations of the activity.
     */
    public void addActivityTrailToTrainingPlan(UUID code, String email, MakeItFitDate date, int duration, String designation, String name, double distance, double elevationGain, double elevationLoss, int trailType, int iterations) {
        Trail activity = new Trail(this.userManager.getUserByEmail(email).getCode(), date, duration, designation, name, distance, elevationGain, elevationLoss, trailType);
        this.trainingPlanManager.addActivity(code, iterations, activity);
    }

    /**
     * Adds a weight squat activity to a training plan from a user.
     *
     * @param email The user's email.
     * @param email The user's email.
     * @param date The date of the activity.
     * @param duration The duration of the activity.
     * @param designation The designation of the activity.
     * @param name The name of the activity.
     * @param repetitions The repetitions of the activity.
     * @param series The series of the activity.
     * @param weight The weight of the activity.
     * @param iterations The iterations of the activity.
     */
    public void addActivityWeightSquatToTrainingPlan(UUID code, String email, MakeItFitDate date, int duration, String designation, String name, int repetitions, int series, double weight, int iterations) {
        WeightSquat activity = new WeightSquat(this.userManager.getUserByEmail(email).getCode(), date, duration, designation, name, repetitions, series, weight);
        this.trainingPlanManager.addActivity(code, iterations, activity);
    }

    /**
     * Retrieves a list of all training plans from a user.
     *
     * @param userCode The code of the user.
     * @return A list of all training plans from the user.
     */
    public List<TrainingPlan> getTrainingPlansFromUser(UUID userCode) {
        return this.trainingPlanManager.getTrainingPlansFromUser(userCode);
    }


    // TODO: SEPARATION BETWEEN USER AND TRAINING PLAN


    /**
     * Updates the system current date.
     *
     * @param currentDate The current date of the system.
     */
    public void updateSystem(MakeItFitDate currentDate, UUID userCode){
        this.userManager.updateSystem();
        this.trainingPlanManager.updateActivities(currentDate, userManager.getUserByCode(userCode).getIndex());
        List<Activity> activities = this.trainingPlanManager.extractActivities(currentDate, userCode);
        this.userManager.addActivitiesToUser(userCode, activities);
    }

    /**
     * Saves the system to a file.
     *
     * @param fileName The name of the file to save the system to.
     */
    public void saveSystem(String fileName) throws FileNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Loads the system from a file.
     *
     * @param fileName The name of the file to load the system from.
     */
    public void loadSystem(String fileName) throws FileNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            MakeItFit makeItFit = (MakeItFit) ois.readObject();
            this.userManager = makeItFit.userManager;
            this.trainingPlanManager = makeItFit.trainingPlanManager;
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException();
        }
    }
}
