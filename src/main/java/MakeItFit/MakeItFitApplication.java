package MakeItFit;

import MakeItFit.users.*;
import MakeItFit.views.AdminView;
import MakeItFit.menu.*;
import java.util.*;

/**
 * The class MakeItFitApplication represents the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class MakeItFitApplication {
    private AdminView adminView;
    private Menu mainMenu;

    /**
     * Initializes the application components.
     * Creates instances of `UserManager`, `UserController`, and `AdminView`.
     * Also creates the main menu of the application.
     */
    public void init() {
        UserManager userManager = new UserManager();
        UserController userController = new UserController(userManager);
        this.adminView = new AdminView(userController);
        this.mainMenu = createMainMenu(this.adminView);
    }

    /**
     * Starts the main menu of the application.
     * This method runs the main menu loop.
     */
    public void start() {
        mainMenu.run();
    }

    /**
     * Creates the main menu of the application.
     *
     * @param adminView The admin view to be used for managing user interactions.
     * @return The created main menu.
     */
    private static Menu createMainMenu(AdminView adminView) {
        List<MenuItem> mainMenuItems = new ArrayList<>();
        mainMenuItems.add(new MenuItem("Init the application", () -> initApplication(adminView)));
        mainMenuItems.add(new MenuItem("Help", () -> showHelpMessage()));
        mainMenuItems.add(new MenuItem("Authors", () -> showAuthors()));

        return new Menu(mainMenuItems);
    }

    /**
     * Initializes the application and starts the app menu.
     *
     * @param adminView The admin view to be used for managing user interactions.
     */
    private static void initApplication(AdminView adminView) {
        System.out.println("[APP] Application is running ...");
        Menu appMenu = createAppMenu(adminView);
        appMenu.run();
    }

    /**
     * Creates the app menu of the application.
     *
     * @param adminView The admin view to be used for managing user interactions.
     * @return The created app menu.
     */
    private static Menu createAppMenu(AdminView adminView) {
        List<MenuItem> appMenuItems = new ArrayList<>();

        appMenuItems.add(new MenuItem("Create User", adminView::createUser));

        Menu updateUserMenu = createUpdateUserMenu(adminView);
        appMenuItems.add(new MenuItem("Update User", updateUserMenu::run));

        appMenuItems.add(new MenuItem("Remove User", adminView::removeUser));
        appMenuItems.add(new MenuItem("User Details", adminView::getUserDetails));
        appMenuItems.add(new MenuItem("Populate Users", adminView::feedUsers));
        appMenuItems.add(new MenuItem("List all users", adminView::printAllUsersDetails));

        return new Menu(appMenuItems);
    }

    /**
     * Creates the update user menu of the application.
     *
     * @param adminView The admin view to be used for managing user interactions.
     * @return The created update user menu.
     */
    private static Menu createUpdateUserMenu(AdminView adminView) {
        List<MenuItem> updateUserMenuItems = new ArrayList<>();

        updateUserMenuItems.add(new MenuItem("Update Name", adminView::updateUserName));
        updateUserMenuItems.add(new MenuItem("Update Age", adminView::updateUserAge));
        updateUserMenuItems.add(new MenuItem("Update Gender", adminView::updateUserGender));
        updateUserMenuItems.add(new MenuItem("Update Weight", adminView::updateUserWeight));
        updateUserMenuItems.add(new MenuItem("Update Height", adminView::updateUserHeight));
        updateUserMenuItems.add(new MenuItem("Update BPM", adminView::updateUserBpm));
        updateUserMenuItems.add(new MenuItem("Update Level", adminView::updateUserLevel));
        updateUserMenuItems.add(new MenuItem("Update Address", adminView::updateUserAddress));
        updateUserMenuItems.add(new MenuItem("Update Phone", adminView::updateUserPhone));
        updateUserMenuItems.add(new MenuItem("Update Email", adminView::updateUserEmail));

        return new Menu(updateUserMenuItems);
    }

    /**
     * Displays a help message to the user.
     * Currently, this method displays a placeholder message.
     */
    private static void showHelpMessage() {
        System.out.println("This is a help message that I should write.");
    }

    /**
     * Displays the authors of the application.
     * Currently, this method displays a list of authors' names.
     */
    private static void showAuthors() {
        System.out.println("Afonso Santos, Hélder Gomes e Pedro Pereira");
    }
}
