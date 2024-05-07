package MakeItFit.feeder;

import MakeItFit.exceptions.*;
import MakeItFit.users.*;
import java.util.Random;

/**
 * The class Feeder represents way of populate random users into the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class FeederUser {

    private final UserManager userManager;
    private final Random random = new Random();

    /**
     * Constructs a new user feeder with the provided user Manager.
     *
     * @param userManager The user Manager to be used for adding random users.
     */
    public FeederUser(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * Feeds a specified number of random users into the application.
     *
     * @param numberOfUsers The number of random users to be added.
     * @throws IllegalArgumentException If any of the provided arguments for creating a user are invalid.
     * @throws ExistingEntityConflictException If a user with the same identifier already exists.
     * @throws InvalidTypeException If an invalid type is encountered during user creation.
     */
    public void feedRandomUsers(int numberOfUsers) throws IllegalArgumentException, ExistingEntityConflictException, InvalidTypeException {
        for (int i = 0; i < numberOfUsers; i++) {
            String name = "User" + i;
            int age = random.nextInt(100) + 1; // Age between 1 and 100
            Gender gender = random.nextBoolean() ? Gender.Male : Gender.Female; // Gender between Male and Female
            float weight = 50 + random.nextFloat() * (100 - 50); // Weight between 50 and 100
            int height = 150 + random.nextInt(50); // Height between 150 and 200 cm
            int bpm = 60 + random.nextInt(100); // BPM between 60 and 160
            int level = random.nextInt(5) + 1; // Level between 1 and 5
            String address = "Random Address " + i;
            String phone = "90000000" + i;
            String email = "user" + i + "@example.com";

            userManager.createUser(name, age, gender, weight, height, bpm, level, address, phone, email, 0, "Amateur");
        }
    }
}
