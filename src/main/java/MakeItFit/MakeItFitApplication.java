package MakeItFit;

import MakeItFit.menu.*;
import MakeItFit.views.AdminView;
import MakeItFit.views.UserView;

import java.util.*;

/**
 * The class MakeItFitApplication represents the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
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
        System.out.println("Welcome to the MakeItFit Application!\n" +
                "This application allows you to manage activities, users, and training plans for physical fitness enthusiasts. Here's an overview of the main features:\n" +
                "\n" +
                "Activities:\n" +
                "\n" +
                "Register various types of activities (running, trail, push-up, etc.)\n" +
                "Track distance, elevation gain, repetitions, weights, and duration for each activity\n" +
                "Calculate calorie expenditure based on activity type and user profile\n" +
                "\n" +
                "Users:\n" +
                "\n" +
                "Create different user types (professionals, amateurs and occasionals)\n" +
                "Store user information (code, name, address, email, average heart rate, height, weight, level)\n" +
                "Each user type has a specific calculation formula for his representative index\n" +
                "\n" +
                "Training Plans:\n" +
                "\n" +
                "Create training plans consisting of multiple activities\n" +
                "Specify activity recurrence (daily, specific weekdays, etc.)\n" +
                "Execute training plans and track their completion using the time manager\n" +
                "\n" +
                "Time Simulation:\n" +
                "\n" +
                "Advance the application's date to simulate future scenarios\n" +
                "Pending activities are automatically executed based on the new date\n" +
                "\n" +
                "Statistics and Records:\n" +
                "\n" +
                "View statistics on calorie expenditure, activity counts, distances, and elevation gains\n" +
                "Track individual and overall activity records for each user\n" +
                "Experiment different queries on the preserved information\n" +
                "\n" +
                "Plan Generation:\n" +
                "\n" +
                "Generate customized training plans based on user goals\n" +
                "Specify desired activity types, recurrence, calorie targets, and difficulty levels\n" +
                "\n" +
                "Help:\n" +
                "\n" +
                "Access this help text at any time for guidance on using the application\n" +
                "\n" +
                "To get started, explore the main menu options. Don't hesitate to refer to this help text whenever you need assistance with the application's features.\n" +
                "Enjoy your fitness journey!");
    }

    /**
     * Displays the authors of the application.
     * Currently, this method displays a list of authors' names.
     */
    private static void showAuthors() {
        System.out.println("Afonso Santos (a104276)\n" +
                "Hélder Gomes (a104100)\n" +
                "Pedro Pereira (a104082)");
    }
}
