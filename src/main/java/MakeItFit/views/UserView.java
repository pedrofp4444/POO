package MakeItFit.views;

import MakeItFit.menu.*;
import java.util.*;

import static MakeItFit.utils.EmailValidator.*;

/**
 * The class UserView represents a view for a normal user.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class UserView extends MakeItFitView {

    /*
     * Empty constructor of the class.
     */
    public UserView() {
        super();
    }

    /**
     * Prompts the user to login.
     * Requests the user's email from the console and logs the user in using the controller.
     */
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[APP] Do you want to load a previous state? (y/n): ");
        String choice = scanner.nextLine();

        if (choice.equals("Y") || choice.equals("y")) {
            System.out.print("[APP] Please enter the file name: ");
            String fileName = scanner.nextLine();
            try {
                this.makeItFitController.loadSystem(fileName);
                System.out.println("[APP] Loaded successfully.");
            } catch (Exception e) {
                System.out.println("[APP] Could not load the file.");
            }
        }

        System.out.println("[APP] Logging in ...");

        Menu appMenu = createAppMenu();

        try {
            String email = "";
            do {
                System.out.print("[APP] Please enter your email: ");
                email = scanner.nextLine();
            } while (!isValidEmail(email));
            this.makeItFitController.login(email);
            System.out.println("[" + this.makeItFitController.getName() + "] Logged in successfully.");

            appMenu.run();

        } catch (Exception e) {
            System.out.println("[APP] The email " + e.getMessage() + " does not exist.");

            System.out.print("[APP] Would you like to create a new user? (y/n): ");

            String response = scanner.nextLine();

            if (response.equals("Y") || response.equals("y")) {
                
                try {
                    createUser();
                    appMenu.run();
                } catch (Exception e2) {
                    // TODO: appMenu.stopMenu();
                }
            } else {
                System.out.println("[APP] Exiting ...");
            }
        }
    }

    /**
     * Creates the app menu of the application.
     *
     * @return The created app menu.
     */
    private Menu createAppMenu() {
        List<MenuItem> appMenuItems = new ArrayList<>();

        appMenuItems.add(new MenuItem("User Details", () -> getUserDetails()));

        Menu updateUserMenu = createUpdateUserMenu();
        appMenuItems.add(new MenuItem("Update user info", updateUserMenu::run));

        appMenuItems.add(new MenuItem("Add activity", () -> addActivityToUser()));
        appMenuItems.add(new MenuItem("Remove activity", () -> removeActivityFromUser()));
        appMenuItems.add(new MenuItem("List activities", () -> listActivities()));
        appMenuItems.add(new MenuItem("Create training plan", () -> createTrainingPlan()));
        appMenuItems.add(new MenuItem("Remove training plan", () -> removeTrainingPlan()));
        appMenuItems.add(new MenuItem("Add activity to a training plan", () -> {
            selectTrainingPlan();
            addActivityToTrainingPlan();
        }));
        appMenuItems.add(new MenuItem("Remove activity from a training plan", () -> {
            selectTrainingPlan();
            removeActivityFromTrainingPlan();
        }));
        appMenuItems.add(new MenuItem("List all training plans", () -> listAllTrainingPlansFromUser()));
        appMenuItems.add(new MenuItem("Advance time", () -> advanceTimeManager()));
        appMenuItems.add(new MenuItem("Save system state", () -> saveSystem()));

        return new Menu(appMenuItems);
    }
}
