package MakeItFit.views;

import MakeItFit.MakeItFitController;
import MakeItFit.activities.Activity;
import MakeItFit.exceptions.*;
import MakeItFit.feeder.Feeder;
import MakeItFit.menu.*;
import MakeItFit.users.*;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

/**
 * The class AdminView represents a view of an admin user.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class AdminView {

    private MakeItFitController makeItFitController;
    private String userType;
    private String activityType;

    /**
     * Constructor for objects of class AdminView.
     */
    public AdminView() {
        this.makeItFitController = new MakeItFitController();
        this.userType = "UNDEFINED";
        this.activityType = "UNDEFINED";
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

        appMenuItems.add(new MenuItem("Create user", () -> createUser()));

        Menu updateUserMenu = createUpdateUserMenu();
        appMenuItems.add(new MenuItem("Update user info", () -> {
            System.out.println("[APP] Updating user ...");

            try {
                System.out.print("[APP] Enter the user's email: ");
                Scanner scanner = new Scanner(System.in);
                String email = scanner.nextLine();
                this.makeItFitController.setEmail(email);
            } catch (Exception e) {
                System.out.println("[APP] Invalid input.");
            }
        }));

        appMenuItems.add(new MenuItem("Remove user", () -> removeUser()));
        appMenuItems.add(new MenuItem("User Details", () -> getUserDetails()));
        appMenuItems.add(new MenuItem("Populate users", () -> feedUsers()));
        appMenuItems.add(new MenuItem("List all users", () -> printAllUsersDetails()));
        appMenuItems.add(new MenuItem("Add activity to user", () -> addActivityToUser()));
        appMenuItems.add(new MenuItem("Remove activity from user", () -> removeActivityFromUser()));
        appMenuItems.add(new MenuItem("List activities from user", () -> listActivities()));
        appMenuItems.add(new MenuItem("Add training plan to user", () -> createTrainingPlan()));
        appMenuItems.add(new MenuItem("Remove training plan", () -> removeTrainingPlan()));
        appMenuItems.add(new MenuItem("Add activity to a training plan", () -> {
            selectTrainingPlan();
            addActivityToTrainingPlan();
        }));
        appMenuItems.add(new MenuItem("Remove activity from a training plan", () -> {
            selectTrainingPlan();
            removeActivityFromTrainingPlan();
        }));
        appMenuItems.add(new MenuItem("List training plans from user", () -> listAllTrainingPlansFromUser()));
        appMenuItems.add(new MenuItem("List all training plans", () -> listAllTrainingPlans()));
        appMenuItems.add(new MenuItem("Execute queries", () -> executeQueries()));
        appMenuItems.add(new MenuItem("Advance time", () -> advanceTimeManager()));
        appMenuItems.add(new MenuItem("Save system state", () -> saveSystem()));

        return new Menu(appMenuItems);
    }

    /**
     * Prompts the administrator to create a new user.
     * Requests user details from the console and creates the user using the user controller.
     */
    public void createUser() throws InvalidTypeException {
        System.out.println("[APP] Creating user ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Please enter the user email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }

        System.out.println("[APP] Please enter the type of user:");

        Menu createUserChoiceMenu = createUserChoiceMenu();
        createUserChoiceMenu.run();

        System.out.println("[APP] Please enter the following information:");

        try {
            System.out.print("[APP] Name: ");
            String name = scanner.nextLine();
            System.out.print("[APP] Age: ");
            int age = scanner.nextInt();
            System.out.print("[APP] Gender (Male | Female | Other): ");
            Gender gender = Gender.valueOf(scanner.next());
            System.out.print("[APP] Weight (Kg): ");
            float weight = scanner.nextFloat();
            System.out.print("[APP] Height (cm): ");
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

            switch (this.userType) {
                case "Amateur" ->
                        this.makeItFitController.createUser(name, age, gender, weight, height, bpm, level, address, phone, -1, this.userType);
                case "Occasional", "Professional" -> {
                    System.out.print("[APP] Frequency: ");
                    int frequency = scanner.nextInt();
                    scanner.nextLine(); // Consume the remaining newline

                    this.makeItFitController.createUser(name, age, gender, weight, height, bpm, level, address, phone, frequency, this.userType);
                }
                default -> System.out.println("[APP] Invalid type.");
            }
            System.out.println("[" + this.makeItFitController.getName() + "] User created successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
            throw new InvalidTypeException();
        }
    }

    /**
     * Creates the user choice menu of the application.
     *
     * @return The created user choice menu.
     */
    public Menu createUserChoiceMenu() {
        List<MenuItem> createUserChoiceMenuItems = new ArrayList<>();

        createUserChoiceMenuItems.add(new MenuItem("Amateur", () -> {this.userType = "Amateur"; System.out.println("[APP] Selected Amateur, please Exit.");}));
        createUserChoiceMenuItems.add(new MenuItem("Occasional", () -> {this.userType = "Occasional"; System.out.println("[APP] Selected Occasional, please Exit.");}));
        createUserChoiceMenuItems.add(new MenuItem("Professional", () -> {this.userType = "Professional"; System.out.println("[APP] Selected Professional, please Exit.");}));

        return new Menu(createUserChoiceMenuItems);
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new name: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new age: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the gender (Male | Female | Other): ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new weight: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new height: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new bpm: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new level: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new address: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new phone: ");
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the new email: ");
            String email = scanner.nextLine();

            this.makeItFitController.updateEmail(email);
            System.out.println("[" + this.makeItFitController.getName() + "] Email updated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
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
     * Prompts the administrator to get user details.
     * Requests the user's email or code from the console and displays the user details.
     */
    public void getUserDetails() {
        System.out.println("[APP] Getting user details ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.println(this.makeItFitController.getUserDetails());

        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Populates a specified number of users in the system.
     * Requests the number of users to be populated from the console and populates them using the feeder.
     */
    public void feedUsers() {
        System.out.println("[APP] Populating users ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the number of users to be populated: ");
        int numberOfUsers = scanner.nextInt();

        try {
             this.makeItFitController.feedUserData(numberOfUsers);
            System.out.println("[APP] Users populated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
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

    /**
     * Creates the activity chooser menu of the application.
     *
     * @return The created activity chooser menu.
     */
    public Menu createActivityChooserMenu() {
        List<MenuItem> activityMenuItems = new ArrayList<>();

        activityMenuItems.add(new MenuItem("PushUp", () -> {this.activityType = "PushUp"; System.out.println("[" + this.makeItFitController.getName() + "] Selected PushUp, please Exit.");}));
        activityMenuItems.add(new MenuItem("Running", () -> {this.activityType = "Running"; System.out.println("[" + this.makeItFitController.getName() + "] Selected Running, please Exit.");}));
        activityMenuItems.add(new MenuItem("Trail", () -> {this.activityType = "Trail"; System.out.println("[" + this.makeItFitController.getName() + "] Selected Trail, please Exit.");}));
        activityMenuItems.add(new MenuItem("WeightSquat", () -> {this.activityType = "WeightSquat"; System.out.println("[" + this.makeItFitController.getName() + "] Selected WeightSquat, please Exit.");}));

        return new Menu(activityMenuItems);
    }

    /**
     * Prompts the administrator to add an activity to a user.
     * Requests the user's email or code and activity details from the console, and adds the activity to the user.
     */
    public void addActivityToUser() {
        System.out.println("[" + this.makeItFitController.getName() + "] Adding activity to user ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.println("[" + this.makeItFitController.getName() + "] Please select the activity:");

            Menu activityMenu = createActivityChooserMenu();
            activityMenu.run();

            System.out.println("[APP] Please enter the following information:");

            try {
                System.out.print("[APP] Date (dd/mm/aaaa): ");
                MakeItFitDate date = MakeItFitDate.fromString(scanner.nextLine());
                System.out.print("[APP] Duration (minutes): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline
                System.out.print("[APP] Designation: ");
                String designation = scanner.nextLine();

                switch (this.activityType) {
                    case "PushUp" -> {
                        System.out.print("[APP] Repetitions: ");
                        int repetitions = scanner.nextInt();
                        System.out.print("[APP] Series: ");
                        int series = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityPushUpToUser(date, duration, designation, this.activityType, repetitions, series);
                    }
                    case "Running" -> {
                        System.out.print("[APP] Distance (meters): ");
                        double distance = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Speed (Km/h):");
                        double speed = scanner.nextDouble();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityRunningToUser(date, duration, designation, this.activityType, distance, speed);
                    }
                    case "Trail" -> {
                        System.out.print("[APP] Distance (meters): ");
                        double distance = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Elevation gain (meters): ");
                        double elevationGain = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Elevation loss (meters): ");
                        double elevationLoss = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Trail type ([0] Easy, [1] Medium, [2] Hard): ");
                        int trailType = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityTrailToUser(date, duration, designation, this.activityType, distance, elevationGain, elevationLoss, trailType);
                    }
                    case "WeightSquat" -> {
                        System.out.print("[APP] Repetitions: ");
                        int repetitions = scanner.nextInt();
                        System.out.print("[APP] Series: ");
                        int series = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Weight (Kg): ");
                        double weight = scanner.nextDouble();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityWeightSquatToUser(date, duration, designation, this.activityType, repetitions, series, weight);
                    }
                    default -> System.out.println("[APP] Invalid type.");
                }
            } catch (Exception e) {
                System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
                return;
            }

            System.out.println("[" + this.makeItFitController.getName() + "] Activity added to user successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Removes an activity from the currently logged in user.
     */
    public void removeActivityFromUser() {
        System.out.println("[" + this.makeItFitController.getName() + "] Removing activity from user ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the code of the activity: ");
            UUID code = UUID.fromString(scanner.nextLine());

            this.makeItFitController.removeActivityFromUser(code);
            System.out.println("[" + this.makeItFitController.getName() + "] Activity removed successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Lists the activities from the currently working user.
     */
    public void listActivities() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing activities ...");

        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.println(this.makeItFitController.getActivities());
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Creates a new training plan based on the provided specifications.
     */
    public void createTrainingPlan() {
        System.out.println("[APP] Creating training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.print("[APP] Please enter the start date (dd/mm/aaaa): ");
            MakeItFitDate startDate = MakeItFitDate.fromString(scanner.nextLine());

            this.makeItFitController.createTrainingPlan(startDate);
            System.out.println("[APP] Training plan created successfully.");

            Menu trainingPlanMenu = createTrainingPlanMenu();
            trainingPlanMenu.run();
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
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

            System.out.println("[" + this.makeItFitController.getName() + "] Training plan constructed successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Adds an activity to the training plan of the currently logged in user.
     */
    public void addActivityToTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Adding activity to training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the number of iterations for the activity: ");
            int iterations = scanner.nextInt();

            System.out.println("[" + this.makeItFitController.getName() + "] Please select the activity:");

            Menu activityMenu = createActivityChooserMenu();
            activityMenu.run();

            System.out.println("[APP] Please enter the following information:");

            try {
                scanner.nextLine(); // Consume the remaining newline
                System.out.print("[APP] Date (dd/mm/aaaa): ");
                MakeItFitDate date = MakeItFitDate.fromString(scanner.nextLine());
                System.out.print("[APP] Duration (minutes): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline
                System.out.print("[APP] Designation: ");
                String designation = scanner.nextLine();

                switch (this.activityType) {
                    case "PushUp" -> {
                        System.out.print("[APP] Repetitions: ");
                        int repetitions = scanner.nextInt();
                        System.out.print("[APP] Series: ");
                        int series = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityPushUpToTrainingPlan(date, duration, designation, this.activityType, repetitions, series, iterations);
                    }
                    case "Running" -> {
                        System.out.print("[APP] Distance (meters): ");
                        double distance = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Speed (Km/h): ");
                        double speed = scanner.nextDouble();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityRunningToTrainingPlan(date, duration, designation, this.activityType, distance, speed, iterations);
                    }
                    case "Trail" -> {
                        System.out.print("[APP] Distance (meters): ");
                        double distance = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Elevation gain (meters): ");
                        double elevationGain = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Elevation loss (meters): ");
                        double elevationLoss = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Trail type ([0] Easy, [1] Medium, [2] Hard): ");
                        int trailType = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityTrailToTrainingPlan(date, duration, designation, this.activityType, distance, elevationGain, elevationLoss, trailType, iterations);
                    }
                    case "WeightSquat" -> {
                        System.out.print("[APP] Repetitions: ");
                        int repetitions = scanner.nextInt();
                        System.out.print("[APP] Series: ");
                        int series = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Weight (Kg): ");
                        double weight = scanner.nextDouble();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityWeightSquatToTrainingPlan(date, duration, designation, this.activityType, repetitions, series, weight, iterations);
                    }
                    default -> System.out.println("[APP] Invalid type.");
                }
            } catch (Exception e) {
                System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
                return;
            }

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
            System.out.print("[" + this.makeItFitController.getName() + "] Do you want to add hard activities? (y/n): ");
            String response = scanner.nextLine();
            boolean hardActivities = response.equals("Y") || response.equals("y");

            int maxActivitiesPerDay = 4;
            while (maxActivitiesPerDay > 3) {
                System.out.print("[" + this.makeItFitController.getName() + "] Please insert the maximum number of activities per day (max 3): ");
                maxActivitiesPerDay = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline

            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the maximum number of different activities: ");
            int maxDifferentActivities = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            int maxWeeklyRecurrence = 8;
            while (maxWeeklyRecurrence > 7) {
                System.out.print("[" + this.makeItFitController.getName() + "] Please insert the weekly recurrence expected (max 7): ");
                maxWeeklyRecurrence = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline

            int minCalories = 0;
            while (minCalories < 1) {
                System.out.print("[" + this.makeItFitController.getName() + "] Please insert the minimum number of calories to be consumed: ");
                minCalories = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline

            System.out.println("Chegou aqui !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            this.makeItFitController.constructTrainingPlanByObjectives(hardActivities, maxActivitiesPerDay, maxDifferentActivities, maxWeeklyRecurrence, minCalories);
            System.out.println("[" + this.makeItFitController.getName() + "] Training plan generated successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Removes an activity from the training plan of the currently logged in user.
     */
    public void removeActivityFromTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Removing activity from training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the code of the activity: ");
            UUID code = UUID.fromString(scanner.nextLine());

            this.makeItFitController.removeActivityFromTrainingPlan(code);
            System.out.println("[" + this.makeItFitController.getName() + "] Activity removed successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Removes a training plan from the currently logged in user.
     */
    public void removeTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Removing training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the code of the training plan: ");
            UUID code = UUID.fromString(scanner.nextLine());

            this.makeItFitController.setTrainingPlan(code);

            this.makeItFitController.removeTrainingPlan();
            System.out.println("[" + this.makeItFitController.getName() + "] Training plan removed successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Selects a training plan from the currently logged in user.
     */
    public void selectTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Selecting training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the code of the training plan: ");
            UUID code = UUID.fromString(scanner.nextLine());

            this.makeItFitController.setTrainingPlan(code);
            System.out.println("[" + this.makeItFitController.getName() + "] Training plan selected successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    public void listAllTrainingPlansFromUser() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing all training plans ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[APP] Enter the user's email: ");
            String email = scanner.nextLine();

            this.makeItFitController.setEmail(email);

            System.out.println(this.makeItFitController.getTrainingPlansFromUser());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Unexpected behaviour.");
        }
    }

    public void listAllTrainingPlans() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing all training plans ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(this.makeItFitController.getTrainingPlans());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Unexpected behaviour.");
        }
    }

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

        queryMenuItems.add(new MenuItem("How many kms has a user driven in a period or ever since?", () -> executeQueryHowManyKMsDone()));
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
                System.out.println("Result: " + this.makeItFitController.executeQueryHowManyKMsDone(null, null) + " kilometers");
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
                System.out.println("Result: " + this.makeItFitController.executeQueryHowManyAltimetryDone(null, null) + " meters");
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
                System.out.println("Result: \n" + this.makeItFitController.executeQuerywhoBurnsMoreCalories(null, null));
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
                System.out.println("Result: \n" + this.makeItFitController.executeQueryWhoDidTheMostActivities(null, null));
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

    /**
     * Advances the time of the application.
     */
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

    /**
     * Saves the current state of the application.
     */
    public void saveSystem() {
        System.out.println("[" + this.makeItFitController.getName() + "] Saving system state ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the file name: ");
            String fileName = scanner.nextLine();

            this.makeItFitController.saveSystem(fileName);
            System.out.println("[" + this.makeItFitController.getName() + "] System state saved successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Could not save the file.");
        }
    }
}
