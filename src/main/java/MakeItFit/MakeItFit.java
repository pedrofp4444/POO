package MakeItFit;

import MakeItFit.activities.Activity;
import MakeItFit.exceptions.*;
import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.users.*;
import MakeItFit.utils.MakeItFitDate;

import java.util.List;
import java.util.UUID;

public class MakeItFit {

    private final UserManager userManager;
    private final TrainingPlanManager trainingPlanManager;

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
     * @throws IllegalArgumentException If any of the provided arguments are invalid.
     * @throws ExistingEntityConflictException If a user with the same email already exists.
     * @throws InvalidTypeException If an invalid type is encountered during user creation.
     */
    public void createUser(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email) throws IllegalArgumentException, ExistingEntityConflictException, InvalidTypeException {
        User user = this.userManager.createUser(name, age, gender, weight, height, bpm, level, address, phone, email);
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


    // TODO: SEPARATION BETWEEN USER AND TRAINING PLAN


    /**
     * Creates a new training plan based on the provided specifications.
     *
     * @param userCode  The code of the user for whom the training plan will be created.
     * @param startDate The start date of the new training plan.
     * @throws IllegalArgumentException If the provided arguments are not valid.
     */
    public void createTrainingPlan(UUID userCode, MakeItFitDate startDate) throws IllegalArgumentException {
        TrainingPlan trainingPlan = this.trainingPlanManager.createTrainingPlan(userCode, startDate);
        this.trainingPlanManager.insertTrainingPlan(trainingPlan);
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
}
