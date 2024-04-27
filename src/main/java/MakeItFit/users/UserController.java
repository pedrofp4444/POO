package MakeItFit.users;

import MakeItFit.exceptions.*;

import java.util.*;

/**
 * The class UserController represents a controller of users.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class UserController {

    private final UserManager userManager;

    /**
     * Constructs a new user controller with the provided user manager.
     *
     * @param userManager The user manager to be used by the controller.
     */
    public UserController(UserManager userManager) {
        this.userManager = userManager;
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
     * @param user The user to be updated.
     * @param name The new name for the user.
     */
    public void updateUserName(User user, String name) {
        user.setName(name);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's age.
     *
     * @param user The user to be updated.
     * @param age The new age for the user.
     */
    public void updateUserAge(User user, int age) {
        user.setAge(age);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's gender.
     *
     * @param user The user to be updated.
     * @param gender The new gender for the user.
     */
    public void updateUserGender(User user, Gender gender) {
        user.setGender(gender);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's weight.
     *
     * @param user The user to be updated.
     * @param weight The new weight for the user.
     */
    public void updateUserWeight(User user, float weight) {
        user.setWeight(weight);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's height.
     *
     * @param user The user to be updated.
     * @param height The new height for the user.
     */
    public void updateUserHeight(User user, int height) {
        user.setHeight(height);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's heart rate in beats per minute (BPM).
     *
     * @param user The user to be updated.
     * @param bpm The new BPM for the user.
     */
    public void updateUserBpm(User user, int bpm) {
        user.setBpm(bpm);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's experience level.
     *
     * @param user The user to be updated.
     * @param level The new experience level for the user.
     */
    public void updateUserLevel(User user, int level) {
        user.setLevel(level);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's address.
     *
     * @param user The user to be updated.
     * @param address The new address for the user.
     */
    public void updateUserAddress(User user, String address) {
        user.setAddress(address);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's phone number.
     *
     * @param user The user to be updated.
     * @param phone The new phone number for the user.
     */
    public void updateUserPhone(User user, String phone) {
        user.setPhone(phone);
        this.userManager.updateUser(user);
    }

    /**
     * Updates the user's email address.
     *
     * @param user The user to be updated.
     * @param email The new email address for the user.
     */
    public void updateUserEmail(User user, String email) {
        user.setEmail(email);
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
}
