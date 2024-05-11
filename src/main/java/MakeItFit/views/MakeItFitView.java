package MakeItFit.views;

import MakeItFit.MakeItFitController;
import MakeItFit.exceptions.InvalidTypeException;
import MakeItFit.menu.*;
import MakeItFit.users.Gender;
import MakeItFit.utils.MakeItFitDate;

import java.util.*;

/**
 * The class MakeItFitView represents a base for the views.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public abstract class MakeItFitView {

    public final MakeItFitController makeItFitController;
    private String userType;
    private String activityType;

    /**
     * Empty constructor of the class.
     */
    public MakeItFitView() {
        this.makeItFitController = new MakeItFitController();
        this.userType = "UNDEFINED";
        this.activityType = "UNDEFINED";
    }

    /*
    * Abstract method login to be implemented by the subclasses such as user or admin.
    */
    public abstract void login();

    /**
     * Creates a new user.
     * Requests the user's information from the console and creates a new user using the controller.
     */
    public void createUser() throws InvalidTypeException {
        System.out.println("[APP] Creating user ...");

        Scanner scanner = new Scanner(System.in);

        try {
            String userType = "";
            do{
                System.out.print("[APP] Please enter the type of user (Amateur | Occasional | Professional): ");
                userType = scanner.nextLine();
            } while (!userType.equals("Amateur") && !userType.equals("Occasional") && !userType.equals("Professional"));

            this.userType = userType;

            System.out.println("[APP] Please enter the following information:");

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
                default -> {System.out.println("[APP] Invalid type.");}
            }
            System.out.println("[" + this.makeItFitController.getName() + "] User created successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Gets the user details.
     */
    public void getUserDetails() {
        System.out.println("[" + this.makeItFitController.getName() + "] Getting user details ...");

        try {
            System.out.println(this.makeItFitController.getUserDetails());
        } catch (Exception e) {
            System.out.println("[APP] Something went wrong.");
        }
    }


    /**
     * Creates the update user menu of the application.
     *
     * @return The created update user menu.
     */
    public Menu createUpdateUserMenu() {
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
     * Adds an activity to the currently logged in user.
     */
    public void addActivityToUser() {
        System.out.println("[" + this.makeItFitController.getName() + "] Adding activity to user ...");

        Scanner scanner = new Scanner(System.in);

        try {

            String activityType = "";
            do{
                System.out.print("[" + this.makeItFitController.getName() + "] Please select the activity (PushUp | WeightSquat | Running | Trail): ");
                activityType = scanner.nextLine();
            } while (!activityType.equals("PushUp") && !activityType.equals("WeightSquat") && !activityType.equals("Running") && !activityType.equals("Trail"));

            this.activityType = activityType;

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

                        this.makeItFitController.addActivityToUser(date, duration, designation, this.activityType, repetitions, series);
                    }
                    case "Running" -> {
                        System.out.print("[APP] Distance (meters): ");
                        double distance = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Speed (Km/h):");
                        double speed = scanner.nextDouble();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityToUser(date, duration, designation, this.activityType, distance, speed);
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

                        this.makeItFitController.addActivityToUser(date, duration, designation, this.activityType, distance, elevationGain, elevationLoss, trailType);
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

                        this.makeItFitController.addActivityToUser(date, duration, designation, this.activityType, repetitions, series, weight);
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
            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the code of the activity: ");
            UUID code = UUID.fromString(scanner.nextLine());

            this.makeItFitController.removeActivityFromUser(code);
            System.out.println("[" + this.makeItFitController.getName() + "] Activity removed successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
        }
    }

    /**
     * Lists the activities from the currently logged in user.
     */
    public void listActivities() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing activities ...");

        try{
        System.out.println(this.makeItFitController.getActivities());
        } catch(Exception e) {
            System.out.println("[APP] invalid input.");
        }
    }

    /**
     * Creates a new training plan based on the provided specifications.
     */
    public void createTrainingPlan() {
        System.out.println("[" + this.makeItFitController.getName() + "] Creating training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please enter the start date (dd/mm/aaaa): ");
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
            scanner.nextLine(); // Consume the remaining line

            String activityType = "";

            do{
                System.out.print("[" + this.makeItFitController.getName() + "] Please select the activity (PushUp | WeightSquat | Running | Trail): ");
                activityType = scanner.nextLine();
            } while (!activityType.equals("PushUp") && !activityType.equals("WeightSquat") && !activityType.equals("Running") && !activityType.equals("Trail"));

            this.activityType = activityType;

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

                        this.makeItFitController.addActivityToTrainingPlan(date, duration, designation, this.activityType, repetitions, series, iterations);
                    }
                    case "Running" -> {
                        System.out.print("[APP] Distance (meters): ");
                        double distance = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        System.out.print("[APP] Speed (Km/h): ");
                        double speed = scanner.nextDouble();
                        scanner.nextLine(); // Consume the remaining newline

                        this.makeItFitController.addActivityToTrainingPlan(date, duration, designation, this.activityType, distance, speed, iterations);
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

                        this.makeItFitController.addActivityToTrainingPlan(date, duration, designation, this.activityType, distance, elevationGain, elevationLoss, trailType, iterations);
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

                        this.makeItFitController.addActivityToTrainingPlan(date, duration, designation, this.activityType, repetitions, series, weight, iterations);
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
    public void selectTrainingPlan() throws RuntimeException {
        System.out.println("[" + this.makeItFitController.getName() + "] Selecting training plan ...");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("[" + this.makeItFitController.getName() + "] Please insert the code of the training plan: ");
            UUID code = UUID.fromString(scanner.nextLine());

            this.makeItFitController.setTrainingPlan(code);
            System.out.println("[" + this.makeItFitController.getName() + "] Training plan selected successfully.");
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Invalid input.");
            throw new RuntimeException();
        }
    }

    /**
     * Lists all training plans from the currently logged in user.
     */
    public void listAllTrainingPlansFromUser() {
        System.out.println("[" + this.makeItFitController.getName() + "] Listing all training plans ...");

        try {
            System.out.println(this.makeItFitController.getTrainingPlansFromUser());
        } catch (Exception e) {
            System.out.println("[" + this.makeItFitController.getName() + "] Unexpected behaviour.");
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
            System.out.println("View: " + e.getMessage());
            System.out.println("[" + this.makeItFitController.getName() + "] Could not save the file.");
        }
    }
}
