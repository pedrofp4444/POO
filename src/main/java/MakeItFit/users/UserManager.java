package MakeItFit.users;

import MakeItFit.exceptions.ExistingEntityConflictException;
import MakeItFit.exceptions.EntityDoesNotExistException;
import MakeItFit.users.types.Amateur;

import java.util.*;

/**
 * The UserManager class to manage all the users.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class UserManager {

    private Map<UUID, User> usersByCode;
    private Map<String, User> usersByEmail;

    public UserManager() {
        this.usersByCode = new HashMap<>();
        this.usersByEmail = new HashMap<>();
    }

    public User createUser(String name, int age, Gender gender, int weight, int height, int bpm , int level, String address, String phone, String email) {
        User user = new Amateur(name, age, gender, weight, height, bpm, level, address, phone, email); // TODO: Make it abstract
        return user;
    }

    public void insertUser(User user) throws ExistingEntityConflictException {
        String email = user.getEmail();

        if (this.usersByEmail.containsKey(email)) {
            throw new ExistingEntityConflictException("There's already a user with the email: " + email + ".");
        }

        this.usersByCode.put(user.getCode(), user);
        this.usersByEmail.put(email, user);
    }

    public boolean existsUserWithEmail(String email) {
        return this.usersByEmail.containsKey(email.toLowerCase());
    }

    public User getUserByCode(UUID code) throws EntityDoesNotExistException {
        User user = this.usersByCode.get(code);

        if (user == null) {
            throw new EntityDoesNotExistException("User with the code " + code + " does not exist.");
        }

        return user.clone();
    }

    public User getUserByEmail(String email) {
        User user = this.usersByEmail.get(email.toLowerCase());

        if (user == null) {
            throw new EntityDoesNotExistException("User with the email " + email + " does not exist.");
        }

        return user.clone();
    }

    public void updateUser(User user){
        UUID code = user.getCode();
        if (!this.usersByCode.containsKey(code)) {
            throw new EntityDoesNotExistException("User with the code " + code + " does not exist.");
        }

        String email = user.getEmail();
        if (!this.usersByEmail.containsKey(email)) {
            throw new EntityDoesNotExistException("User with the email " + email + " does not exit.");
        }

        this.usersByCode.put(code, user);
        this.usersByEmail.put(email, user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(this.usersByCode.values());
    }
}
