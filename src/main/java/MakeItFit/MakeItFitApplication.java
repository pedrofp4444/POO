package MakeItFit;

import MakeItFit.menu.*;
import MakeItFit.views.AdminView;
import MakeItFit.views.UserView;

import java.util.*;

/**
 * The class MakeItFitApplication represents the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class MakeItFitApplication {
    private UserView userView;
    private AdminView adminView;
    private Menu mainMenu;

    /**
     * Constructor for objects of class MakeItFitApplication.
     */
    public void init() {
        this.userView = new UserView();
        this.adminView = new AdminView();
        this.mainMenu = createMainMenu();
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
     * @return The created main menu.
     */
    private Menu createMainMenu() {
        List<MenuItem> mainMenuItems = new ArrayList<>();
        mainMenuItems.add(new MenuItem("Init the application", () -> initApplication()));
        mainMenuItems.add(new MenuItem("Help", () -> showHelpMessage()));
        mainMenuItems.add(new MenuItem("Authors", () -> showAuthors()));

        return new Menu(mainMenuItems);
    }

    /**
     * Initializes the application and starts the app menu.
     */
    private void initApplication() {
        System.out.println("[APP] Application is running ...");

        System.out.print("[APP] Do you want to login as an admin? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        if (answer.equals("y") || answer.equals("Y")) {
            this.adminView.login();
        } else {
            this.userView.login();
        }
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
