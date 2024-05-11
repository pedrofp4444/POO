package MakeItFit.users;

import MakeItFit.activities.Activity;
import MakeItFit.exceptions.ExistingEntityConflictException;
import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.exceptions.InvalidTypeException;
import MakeItFit.users.types.*;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.*;

/**
 * The UserManager class to manage all the users.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class UserManager implements Serializable {

    private Map<UUID, User> usersByCode;
    private Map<String, User> usersByEmail;

    public UserManager() {
        this.usersByCode = new HashMap<>();
        this.usersByEmail = new HashMap<>();
    }

    /**
     * Creates a user with the specified parameters.
     *
     * @param name the name of the user
     * @param age the age of the user
     * @param gender the gender of the user
     * @param weight the weight of the user
     * @param height the height of the user
     * @param bpm the heart rate (bpm) of the user
     * @param level the fitness level of the user
     * @param address the address of the user
     * @param phone the phone number of the user
     * @param email the email address of the user
     * @param frequency the training frequency of the user
     * @param type the type of the user
     * @return the created user
     * @throws IllegalArgumentException if any argument is null or invalid
     */
    public User createUser(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email, int frequency, String type) throws IllegalArgumentException, InvalidTypeException {

        if (name == null || address == null || phone == null || email == null) {
            throw new IllegalArgumentException("Invalid input: name, address, phone, or email cannot be null.");
        }
        if (age < 0 || weight < 0 || height < 0 || bpm < 0 || level < 0) {
            throw new IllegalArgumentException("Invalid input: age, weight, height, bpm, and level must be non-negative.");
        }

        if (type.equals("Amateur")) {
           return new Amateur(name, age, gender, weight, height, bpm, level, address, phone, email);
        } else if (type.equals("Occasional")) {
            return new Occasional(name, age, gender, weight, height, bpm, level, address, phone, email, frequency);
        } else if (type.equals("Professional")) {
            return new Professional(name, age, gender, weight, height, bpm, level, address, phone, email, frequency);
        } else throw new InvalidTypeException(type);
    }

    /**
     * Inserts a user into the manager.
     *
     * @param user the user to be inserted
     * @throws ExistingEntityConflictException if a user with the same email already exists
     */
    public void insertUser(User user) throws ExistingEntityConflictException {
        String email = user.getEmail().toLowerCase();

        if (this.usersByEmail.containsKey(email)) {
            throw new ExistingEntityConflictException("User with email " + email + " already exists.");
        }

        this.usersByCode.put(user.getCode(), user);
        this.usersByEmail.put(email, user);
    }

    /**
     * Removes a user by their code.
     *
     * @param code the code of the user to be removed
     * @throws EntityDoesNotExistException if the user does not exist
     */
    public void removeUserByCode(UUID code) throws EntityDoesNotExistException {

        if (!this.usersByCode.containsKey(code)) {
            throw new EntityDoesNotExistException("User with code " + code + " does not exist.");
        }

        User user = this.usersByCode.get(code);
        this.usersByCode.remove(code);
        this.usersByEmail.remove(user.getEmail());
    }

    /**
     * Removes a user by their email.
     *
     * @param email the email of the user to be removed
     * @throws EntityDoesNotExistException if the user does not exist
     */
    public void removeUserByEmail(String email) throws EntityDoesNotExistException {

        if (!this.usersByEmail.containsKey(email)) {
            throw new EntityDoesNotExistException("User with code " + email + " does not exist.");
        }

        User user = this.usersByEmail.get(email);
        this.usersByEmail.remove(email);
        this.usersByCode.remove(user.getCode());
    }

    /**
     * Checks if a user with the specified email exists.
     *
     * @param email the email to check
     * @return true if a user with the email exists, false otherwise
     */
    public boolean existsUserWithEmail(String email) {
        return this.usersByEmail.containsKey(email.toLowerCase());
    }

    /**
     * Retrieves a user by their code.
     *
     * @param code the code of the user
     * @return the user with the specified code
     * @throws EntityDoesNotExistException if the user does not exist
     */
    public User getUserByCode(UUID code) throws EntityDoesNotExistException {
        User user = this.usersByCode.get(code);

        if (user == null) {
            throw new EntityDoesNotExistException("User with code " + code + " does not exist.");
        }

        return user;
    }

    /**
     * Retrieves a user by their email.
     *
     * @param email the email of the user
     * @return the user with the specified email
     * @throws EntityDoesNotExistException if the user does not exist
     */
    public User getUserByEmail(String email) throws EntityDoesNotExistException {
        email = email.toLowerCase();
        User user = this.usersByEmail.get(email);

        if (user == null) {
            throw new EntityDoesNotExistException("User with email " + email + " does not exist.");
        }

        return user;
    }

    /**
     * Updates the information of a user.
     *
     * @param user the user to update
     * @throws EntityDoesNotExistException if the user does not exist
     */
    public void updateUser(User user) throws EntityDoesNotExistException {
        UUID code = user.getCode();
        if (!this.usersByCode.containsKey(code)) {
            throw new EntityDoesNotExistException("User with code " + code + " does not exist.");
        }

        String email = user.getEmail().toLowerCase();
        User existingUser = this.usersByEmail.get(email);

        if (existingUser == null || !existingUser.getCode().equals(code)) {
            throw new EntityDoesNotExistException("User with email " + email + " does not exist.");
        }

        this.usersByCode.put(code, user);
        this.usersByEmail.put(email, user);
    }

    /**
     * Retrieves a list of all users.
     *
     * @return a list of all users
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(this.usersByCode.values());
    }

    /**
     * Retrieves a list of all activities from a user.
     *
     * @param email the user's email address
     * @return a list of all activities from the user
     */
    public List<Activity> getActivitiesFromUser(String email) throws EntityDoesNotExistException{
        if(!this.usersByEmail.containsKey(email)){
            throw new EntityDoesNotExistException(email);
        }
        return this.usersByEmail.get(email).getListActivities();
    }

    /**
     * Adds an activity to a user.
     *
     * @param email the user's email
     * @param activity the activity to be added
     */
    public void addActivityToUser(String email, Activity activity) {
        usersByEmail.get(email).addActivity(activity);
    }

    /**
     * Removes an activity from a user.
     *
     * @param email the user's email
     * @param activityCode the activity code
     */
    public void removeActivityFromUser(String email, UUID activityCode) {
        usersByEmail.get(email).removeActivity(activityCode);
    }

    /**
     * Adds a list of activities to a user.
     *
     * @param userCode the user's code
     * @param activities the activities to be added
     */
    public void addActivitiesToUser(UUID userCode, List<Activity> activities) {
        usersByCode.get(userCode).addActivities(activities);
    }

    /**
     * Updates the system.
     */
    public void updateSystem() {
        for (User user : usersByCode.values()) {
            user.updateActivities();
            if(user instanceof Professional) {
                ((Professional) user).updateSpecialization();
            }
        }
    }
}
