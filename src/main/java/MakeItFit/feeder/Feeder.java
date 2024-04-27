package MakeItFit.feeder;

import MakeItFit.users.UserController;

/**
 * The class Feeder represents way of populate the different facilities of the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class Feeder {
    private FeederUser feederUser;

    /**
     * Constructs a new feeder with the provided user controller.
     *
     * @param userController The user controller to be used by the feeder.
     */
    public Feeder(UserController userController) {
        this.feederUser = new FeederUser(userController);
    }

    /**
     * Feeds random user data into the application.
     *
     * @param numberOfUsers The number of random users to be added.
     */
    public void feedData(int numberOfUsers) {
        feederUser.feedRandomUsers(numberOfUsers);
    }
}
