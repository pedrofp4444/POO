package MakeItFit.views;

import MakeItFit.MakeItFitController;
import MakeItFit.activities.Activity;
import MakeItFit.menu.*;
import MakeItFit.users.Gender;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

import java.util.Scanner;

public class UserView {

    private final MakeItFitController makeItFitController;

    public UserView() {
        this.makeItFitController = new MakeItFitController();
    }

    /**
     * Prompts the user to login.
     * Requests the user's email from the console and logs the user in using the controller.
     */
    public void login() {
        System.out.println("[APP] Logging in ...");
        System.out.println("[APP] Please enter your email:");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Email: ");
            String email = scanner.nextLine();

            makeItFitController.login(email);
            System.out.println("[" + this.makeItFitController.getName() + "] Logged in successfully.");

            Menu appMenu = createAppMenu();
            appMenu.run();

        } catch (Exception e) {
            System.out.println("[APP] The email " + e.getMessage() + " does not exist.");

            System.out.println("[APP] Would you like to create a new user? (yes/no)");

            String response = scanner.nextLine();

            if (response.equals("yes")) {
                createUser();
            } else {
                System.out.println("[APP] Exiting ...");
                System.exit(0);
            }
        }
    }

    /**
     * Prompts the administrator to create a new user.
     * Requests user details from the console and creates the user using the user controller.
     */
    public void createUser() {
        System.out.println("[APP] Creating user ...");
        System.out.println("[APP] Please enter the following information:");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Name: ");
            String name = scanner.nextLine();
            System.out.print("[APP] Age: ");
            int age = scanner.nextInt();
            System.out.print("[APP] Gender: ");
            Gender gender = Gender.valueOf(scanner.next());
            System.out.print("[APP] Weight: ");
            float weight = scanner.nextFloat();
            System.out.print("[APP] Height: ");
            int height = scanner.nextInt();
            System.out.print("[APP] Bpm: ");
            int bpm = scanner.nextInt();
            System.out.print("[APP] Level: ");
            int level = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            System.out.print("[APP] Address: ");
            String address = scanner.nextLine();
            System.out.print("[APP] Phone: ");
            String phone = scanner.nextLine();
            System.out.print("[APP] Email: ");
            String email = scanner.nextLine();

            this.makeItFitController.createUser(name, age, gender, weight, height, bpm, level, address, phone, email);
            System.out.println("[" + this.makeItFitController.getName() + "] User created successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
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

        appMenuItems.add(new MenuItem("Add activity", () -> addActivity()));
        appMenuItems.add(new MenuItem("List activities", () -> listActivities()));
        appMenuItems.add(new MenuItem("Create training plan", () -> createTrainingPlan()));
        appMenuItems.add(new MenuItem("Advance time", () -> advanceTimeManager()));

        return new Menu(appMenuItems);
    }

    /**
     * Runs the app menu of the application.
     */
    public void getUserDetails() {
        System.out.println("[" + this.makeItFitController.getName() + "] Getting user details ...");

        System.out.println(this.makeItFitController.getUserDetails());
    }

    /**
     * Creates the update user menu of the application.
     *
     * @return The created update user menu.
     */
    private Menu createUpdateUserMenu() {
        List<MenuItem> updateUserMenuItems = new ArrayList<>();

        updateUserMenuItems.add(new MenuItem("Update Name", () -> updateName()));
        updateUserMenuItems.add(new MenuItem("Update Age", () -> updateAge()));
        updateUserMenuItems.add(new MenuItem("Update Gender", () -> updateGender()));
        updateUserMenuItems.add(new MenuItem("Update Weight", () -> updateWeight()));
        updateUserMenuItems.add(new MenuItem("Update Height", () -> updateHeight()));
        updateUserMenuItems.add(new MenuItem("Update BPM", () -> updateBpm()));
        updateUserMenuItems.add(new MenuItem("Update Level", () -> updateLevel()));
        updateUserMenuItems.add(new MenuItem("Update Address", () -> updateAddress()));
        updateUserMenuItems.add(new MenuItem("Update Phone", () -> updatePhone()));
        updateUserMenuItems.add(new MenuItem("Update Email", () -> updateEmail()));

        return new Menu(updateUserMenuItems);
    }

    /**
     * Updates the name of the currently logged in user.
     */
    private void updateName() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating name ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new name:");
            String name = scanner.nextLine();

            this.makeItFitController.updateName(name);
            System.out.println("[" + this.makeItFitController.getName() + "] Name updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the age of the currently logged in user.
     */
    private void updateAge() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating age ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new age:");
            int age = scanner.nextInt();

            this.makeItFitController.updateAge(age);
            System.out.println("[" + this.makeItFitController.getName() + "] Age updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the gender of the currently logged in user.
     */
    private void updateGender() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating gender ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the gender:");
            Gender gender = Gender.valueOf(scanner.next());

            this.makeItFitController.updateGender(gender);
            System.out.println("[" + this.makeItFitController.getName() + "] Gender updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the weight of the currently logged in user.
     */
    private void updateWeight() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating weight ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new weight:");
            float weight = scanner.nextFloat();

            this.makeItFitController.updateWeight(weight);
            System.out.println("[" + this.makeItFitController.getName() + "] Weight updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the height of the currently logged in user.
     */
    private void updateHeight() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating height ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new height:");
            int height = scanner.nextInt();

            this.makeItFitController.updateHeight(height);
            System.out.println("[" + this.makeItFitController.getName() + "] Height updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the bpm of the currently logged in user.
     */
    private void updateBpm() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating bpm ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new bpm:");
            int bpm = scanner.nextInt();

            this.makeItFitController.updateBpm(bpm);
            System.out.println("[" + this.makeItFitController.getName() + "] BPM updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the level of the currently logged in user.
     */
    private void updateLevel() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating level ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new level:");
            int level = scanner.nextInt();

            this.makeItFitController.updateLevel(level);
            System.out.println("[" + this.makeItFitController.getName() + "] Level updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the address of the currently logged in user.
     */
    private void updateAddress() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating address ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new address:");
            String address = scanner.nextLine();

            this.makeItFitController.updateAddress(address);
            System.out.println("[" + this.makeItFitController.getName() + "] Address updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the phone of the currently logged in user.
     */
    private void updatePhone() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating phone ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new phone:");
            String phone = scanner.nextLine();

            this.makeItFitController.updatePhone(phone);
            System.out.println("[" + this.makeItFitController.getName() + "] Phone updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Updates the email of the currently logged in user.
     */
    private void updateEmail() {
        System.out.println("[" + this.makeItFitController.getName() + "] Updating email ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new email:");
            String email = scanner.nextLine();

            this.makeItFitController.updateEmail(email);
            System.out.println("[" + this.makeItFitController.getName() + "] Email updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Adds an activity to the currently logged in user.
     */
    private void addActivity() {
        System.out.println("[" + this.makeItFitController.getName() + "] Adding activity ...");
        System.out.println("[" + this.makeItFitController.getName() + "] Please select the activity:");

        Menu activityMenu = createActivityChooserMenu();
        activityMenu.run();

        System.out.println("[" + this.makeItFitController.getName() + "] Activity added successfully.");
    }

    /**
     * Creates the activity chooser menu of the application.
     *
     * @return The created activity chooser menu.
     */
    public Menu createActivityChooserMenu() {
        List<MenuItem> activityMenuItems = new ArrayList<>();

        activityMenuItems.add(new MenuItem("PushUp", () -> System.out.println("PushUp")));
        activityMenuItems.add(new MenuItem("Running", () -> System.out.println("Running")));
        activityMenuItems.add(new MenuItem("Trail", () -> System.out.println("Trail")));
        activityMenuItems.add(new MenuItem("WeightSquat", () -> System.out.println("WeightSquat")));

        return new Menu(activityMenuItems);
    }

    /**
     * Lists the activities from the currently logged in user.
     */
    public void listActivities() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing activities ...");

        List<Activity> activities = this.makeItFitController.getActivities();

        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    /**
     * Creates a new training plan based on the provided specifications.
     */
    public void createTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Creating training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the start date (dd/mm/aaaa):");
            MakeItFitDate startDate = MakeItFitDate.fromString(scanner.nextLine());

            this.makeItFitController.createTrainingPlan(startDate);
            System.out.println("[" + this.makeItFitController.getName() + "] Training plan created successfully.");

            Menu trainingPlanMenu = createTrainingPlanMenu();
            trainingPlanMenu.run();
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Generates a new training plan based on the provided specifications.
     */
    public Menu createTrainingPlanMenu() {
        List<MenuItem> trainingPlanMenuItems = new ArrayList<>();

        trainingPlanMenuItems.add(new MenuItem("Construct plan", () -> constructTrainingPlan()));
        trainingPlanMenuItems.add(new MenuItem("Generate plan", () -> generateTrainingPlan()));

        return new Menu(trainingPlanMenuItems);
    }

    /**
     * Constructs a new training plan based on the provided specifications.
     */
    public void constructTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Constructing training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            addActivityToTrainingPlan();

            // Colocar método no controller

            System.out.println("[" + this.makeItFitController.getName() + "] Training plan constructed successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    public void addActivityToTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Adding activity to training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("[" + this.makeItFitController.getName() + "] Please select the activity:");

            Menu activityMenu = createActivityChooserMenu();
            activityMenu.run();

            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the number of iterations: ");
            int repetitions = scanner.nextInt();

            // Método para adicionar ao plano de treino

            System.out.println("[" + this.makeItFitController.getName() + "] Activity added to training plan successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Generates a new training plan based on the provided specifications.
     */
    public void generateTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Generating training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("[" + this.makeItFitController.getName() + "] Training plan generated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    public void advanceTimeManager() {
        System.out.println("[" + this.makeItFitController.getName() + "] Advancing time ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the number of days to advance: ");
            int days = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            this.makeItFitController.updateSystemDate(days);
            System.out.println("[" + this.makeItFitController.getName() + "] Time advanced successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }
}
