package MakeItFit.users;

import MakeItFit.exceptions.*;

import java.util.*;

public class UserController {

    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    public void createUser(String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email) throws IllegalArgumentException, ExistingEntityConflictException, InvalidTypeException {
        User user = this.userManager.createUser(name, age, gender, weight, height, bpm, level, address, phone, email);
        this.userManager.insertUser(user);
    }

    public void removeUser(Object identifier) throws EntityDoesNotExistException {
        if (identifier instanceof UUID) {
            this.userManager.removeUserByCode((UUID) identifier);
        } else if (identifier instanceof String) {
            this.userManager.removeUserByEmail((String) identifier);
        } else {
            throw new InvalidTypeException();
        }
    }

    public boolean existsUserWithEmail(String email) {
        return this.userManager.existsUserWithEmail(email);
    }

    public User getUser(Object identifier) throws InvalidTypeException {
        if (identifier instanceof UUID) {
            return this.userManager.getUserByCode((UUID) identifier);
        } else if (identifier instanceof String) {
            return this.userManager.getUserByEmail((String) identifier);
        } else {
            throw new InvalidTypeException();
        }
    }

    public void updateUser(User user, String name, int age, Gender gender, float weight, int height, int bpm, int level, String address, String phone, String email) throws EntityDoesNotExistException {

        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setWeight(weight);
        user.setHeight(height);
        user.setBpm(bpm);
        user.setLevel(level);
        user.setAddress(address);
        user.setPhone(phone);
        user.setEmail(email);

        this.userManager.updateUser(user);
    }

    public List<User> getAllUsers() {
        return this.userManager.getAllUsers();
    }
}
