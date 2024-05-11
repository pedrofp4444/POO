package MakeItFit.views;

import MakeItFit.exceptions.*;
import MakeItFit.menu.*;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

import static MakeItFit.utils.EmailValidator.isValidEmail;

/**
 * The class AdminView represents a view of an admin user.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class AdminView extends MakeItFitView {

    /**
     * Constructor for objects of class AdminView.
     */
    public AdminView() {
        super();
    }

    /**
     * Sets the user's email.
     */
    public void setEmail() throws RuntimeException {
        try {
            String email = "";
            do{
                Scanner scanner = new Scanner(System.in);
                System.out.print("[APP] Please enter the user email: ");
                email = scanner.nextLine();
            } while (!isValidEmail(email));
            this.makeItFitController.setEmail(email);
        } catch (Exception e) {
            System.out.println("[APP] Invalid email.");
            throw new RuntimeException();
        }
    }

    /**
     * Sets the new user's email.
     */
    public void setNewEmail() throws RuntimeException {
        try {
            String email = "";
            do{
                Scanner scanner = new Scanner(System.in);
                System.out.print("[APP] Please enter the user email: ");
                email = scanner.nextLine();
            } while (!isValidEmail(email));
            this.makeItFitController.setNewEmail(email);
        } catch (Exception e) {
            System.out.println("[APP] Invalid email.");
            throw new RuntimeException();
        }
    }

    /**
     * Prompts the user to login.
     * Requests the user's email from the console and logs the user in using the controller.
     */
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[APP] Logging in as administrator ...");

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

        Menu appMenu = createAppMenu();

        appMenu.run();
    }

    /**
     * Creates the app menu of the application.
     *
     * @return The created app menu.
     */
    private Menu createAppMenu() {
        List<MenuItem> appMenuItems = new ArrayList<>();

        appMenuItems.add(new MenuItem("Create user", () -> {try{setNewEmail();createUser();}catch(Exception e){}}));

        Menu updateUserMenu = createUpdateUserMenu();
        appMenuItems.add(new MenuItem("Update user info", () -> {
            System.out.println("[APP] Updating user ...");

            try {
                setEmail();
                updateUserMenu.run();
            } catch (Exception e) {
                System.out.println("[APP] Invalid input.");
            }
        }));

        appMenuItems.add(new MenuItem("Remove user", () -> removeUser()));
        appMenuItems.add(new MenuItem("User Details", () -> {try{setEmail();getUserDetails();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("List all users", () -> printAllUsersDetails()));
        appMenuItems.add(new MenuItem("Add activity to user", () -> {try{setEmail();addActivityToUser();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("Remove activity from user", () -> {try{setEmail();removeActivityFromUser();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("List activities from user", () -> {try{setEmail();listActivities();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("Add training plan to user", () -> {try{setEmail();createTrainingPlan();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("Remove training plan", () -> {try{setEmail();removeTrainingPlan();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("Add activity to a training plan", () -> {
            try {
                setEmail();
                selectTrainingPlan();
                addActivityToTrainingPlan();
            } catch (Exception e){}
        }));
        appMenuItems.add(new MenuItem("Remove activity from a training plan", () -> {
            try {
                setEmail();
                selectTrainingPlan();
                removeActivityFromTrainingPlan();
            } catch (Exception e){}
        }));
        appMenuItems.add(new MenuItem("List training plans from user", () -> {try{setEmail();listAllTrainingPlansFromUser();}catch(Exception e){}}));
        appMenuItems.add(new MenuItem("List all training plans", () -> listAllTrainingPlans()));
        appMenuItems.add(new MenuItem("Execute queries", () -> executeQueries()));
        appMenuItems.add(new MenuItem("Advance time", () -> advanceTimeManager()));
        appMenuItems.add(new MenuItem("Save system state", () -> saveSystem()));

        return new Menu(appMenuItems);
    }

    /**
     * Prompts the administrator to remove a user.
     * Requests the user's email or code from the console and removes the user using the user controller.
     */
    public void removeUser() {
        try {
            System.out.println("[APP] Removing user ...");

            Scanner scanner = new Scanner(System.in);

            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            this.makeItFitController.removeUser();
            System.out.println("[APP] User removed successfully.");
        } catch (EntityDoesNotExistException e) {
            System.out.println("[APP] User does not exist.");
        }
    }

    /**
     * Prints details of all users in the system.
     * Fetches and displays details of all users using the user controller.
     */
    public void printAllUsersDetails() {
        System.out.println("== (All users) ==");
        try {
            System.out.println(this.makeItFitController.getAllUsers());
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
        System.out.println("==================");
    }

    /*
    * Lists all the training plans of the application.
    */
    public void listAllTrainingPlans() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing all training plans ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(this.makeItFitController.getTrainingPlans());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Unexpected behaviour.");
        }
    }

    /*
     * Executes the queries of the application.
     */
    public void executeQueries() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing queries ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("[APP] Please select the query to execute:");

            Menu queryMenu = createQueryMenu();
            queryMenu.run();

        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Creates the query menu of the application.
     *
     * @return The created query menu.
     */
    public Menu createQueryMenu() {
        List<MenuItem> queryMenuItems = new ArrayList<>();

        queryMenuItems.add(new MenuItem("How many kms has a user has run in a period or ever since?", () -> executeQueryHowManyKMsDone()));
        queryMenuItems.add(new MenuItem("How many meters of altimetry has a user totaled in a period or ever since?", () -> executeQueryHowManyAltimetryDone()));
        queryMenuItems.add(new MenuItem("What is the most demanding training plan depending on the proposed calorie expenditure?", () -> executeQueryMostDemandingTrainingPlan()));
        queryMenuItems.add(new MenuItem("what type of activity is most carried out?", () -> executeQueryMostDoneActivity()));
        queryMenuItems.add(new MenuItem("Which user has burned the most calories over a period of time or ever?", () -> executeQuerywhoBurnsMoreCalories()));
        queryMenuItems.add(new MenuItem("Which user has carried out the most activities in a period or ever since?", () -> executeQueryWhoDidTheMostActivities()));
        queryMenuItems.add(new MenuItem("List all activities from a user.", () -> executeQueryGetAllActivitiesFromUser()));

        return new Menu(queryMenuItems);
    }

    /**
     * Executes the query to determine how many kilometers a user has driven in a period or ever since.
     */
    public void executeQueryHowManyKMsDone() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.print("[APP] Do you choose a period of time? (y/n): ");
            String response = scanner.nextLine();
            if(response.equals("Y") || response.equals("y")) {
                System.out.print("[APP] Enter the start date (dd/mm/aaaa): ");
                MakeItFitDate startDate = MakeItFitDate.fromString(scanner.nextLine());
                System.out.print("[APP] Enter the end date (dd/mm/aaaa): ");
                MakeItFitDate endDate = MakeItFitDate.fromString(scanner.nextLine());

                System.out.println("Result: " + this.makeItFitController.executeQueryHowManyKMsDone(startDate, endDate) + " kilometers");
            }
            else {
                System.out.println("Result: " + this.makeItFitController.executeQueryHowManyKMsDone() + " kilometers");
            }
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Executes the query to determine how many meters of altimetry a user has totaled in a period or ever since.
     */
    public void executeQueryHowManyAltimetryDone() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.print("[APP] Do you choose a period of time? (y/n): ");
            String response = scanner.nextLine();
            if(response.equals("Y") || response.equals("y")) {
                System.out.print("[APP] Enter the start date (dd/mm/aaaa): ");
                MakeItFitDate startDate = MakeItFitDate.fromString(scanner.nextLine());
                System.out.print("[APP] Enter the end date (dd/mm/aaaa): ");
                MakeItFitDate endDate = MakeItFitDate.fromString(scanner.nextLine());

                System.out.println("Result: " + this.makeItFitController.executeQueryHowManyAltimetryDone(startDate, endDate) + " meters");
            }
            else {
                System.out.println("Result: " + this.makeItFitController.executeQueryHowManyAltimetryDone() + " meters");
            }
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Executes the query to determine the most demanding training plan depending on the proposed calorie expenditure.
     */
    public void executeQueryMostDemandingTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Result: \n" + this.makeItFitController.executeQueryMostDemandingTrainingPlan());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Executes the query to determine what type of activity is most carried out.
     */
    public void executeQueryMostDoneActivity() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Result: " + this.makeItFitController.executeQueryMostDoneActivity());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Executes the query to determine which user has burned the most calories over a period of time or ever.
     */
    public void executeQuerywhoBurnsMoreCalories() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Do you choose a period of time? (y/n): ");
            String response = scanner.nextLine();
            if (response.equals("Y") || response.equals("y")) {
                System.out.print("[APP] Enter the start date (dd/mm/aaaa): ");
                MakeItFitDate startDate = MakeItFitDate.fromString(scanner.nextLine());
                System.out.print("[APP] Enter the end date (dd/mm/aaaa): ");
                MakeItFitDate endDate = MakeItFitDate.fromString(scanner.nextLine());

                System.out.println("Result: \n" + this.makeItFitController.executeQuerywhoBurnsMoreCalories(startDate, endDate));
            }
            else {
                System.out.println("Result: \n" + this.makeItFitController.executeQuerywhoBurnsMoreCalories());
            }
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Executes the query to determine which user has carried out the most activities in a period or ever since.
     */
    public void executeQueryWhoDidTheMostActivities() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Do you choose a period of time? (y/n): ");
            String response = scanner.nextLine();
            if (response.equals("Y") || response.equals("y")) {
                System.out.print("[APP] Enter the start date (dd/mm/aaaa): ");
                MakeItFitDate startDate = MakeItFitDate.fromString(scanner.nextLine());
                System.out.print("[APP] Enter the end date (dd/mm/aaaa): ");
                MakeItFitDate endDate = MakeItFitDate.fromString(scanner.nextLine());

                System.out.println("Result: \n" + this.makeItFitController.executeQueryWhoDidTheMostActivities(startDate, endDate));
            }
            else {
                System.out.println("Result: \n" + this.makeItFitController.executeQueryWhoDidTheMostActivities());
            }
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Executes the query to list all activities from a user.
     */
    public void executeQueryGetAllActivitiesFromUser() {
        System.out.println("[" + this.makeItFitController.getName() + "] Executing query ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.println("Result: \n" + this.makeItFitController.getActivities());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }
}
