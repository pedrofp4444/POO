package MakeItFit.views;

import MakeItFit.activities.Activity;
import MakeItFit.activities.implementation.PushUp;
import MakeItFit.exceptions.*;
import MakeItFit.feeder.Feeder;
import MakeItFit.users.*;
import MakeItFit.utils.MakeItFitDate;

import java.time.LocalDate;
import java.util.*;

/**
 * The class AdminView represents a view of an admin user.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class AdminView {

    private final UserController userController;

    /**
     * Constructs an AdminView with the provided UserController.
     *
     * @param userController The UserController instance to be used.
     */
    public AdminView(UserController userController) {
        this.userController = userController;
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

            userController.createUser(name, age, gender, weight, height, bpm, level, address, phone, email);
            System.out.println("[APP] User created successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
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

            System.out.print("[APP] Enter the user's email or code: ");
            Object identifier = scanner.nextLine();

            userController.removeUser(identifier);
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

        System.out.print("[APP] Enter the user's email or code: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);
            System.out.println(user.toString());
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's name.
     * Requests the user's email or code and new name from the console, and updates the user's name.
     */
    public void updateUserName() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user name: ");
            String name = scanner.nextLine();

            userController.updateUserName(user, name);
            System.out.println("[APP] User name updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's age.
     * Requests the user's email or code and new age from the console, and updates the user's age.
     */
    public void updateUserAge() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user age: ");
            int age = scanner.nextInt();

            userController.updateUserAge(user, age);
            System.out.println("[APP] User age updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's gender.
     * Requests the user's email or code and new gender from the console, and updates the user's gender.
     */
    public void updateUserGender() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user gender: ");
            Gender gender = Gender.valueOf(scanner.next());

            userController.updateUserGender(user, gender);
            System.out.println("[APP] User gender updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's weight.
     * Requests the user's email or code and new weight from the console, and updates the user's weight.
     */
    public void updateUserWeight() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user weight: ");
            float weight = scanner.nextFloat();

            userController.updateUserWeight(user, weight);
            System.out.println("[APP] User weight updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's height.
     * Requests the user's email or code and new height from the console, and updates the user's height.
     */
    public void updateUserHeight() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user height: ");
            int height = scanner.nextInt();

            userController.updateUserHeight(user, height);
            System.out.println("[APP] User height updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's heart rate in beats per minute.
     * Requests the user's email or code and new heart rate from the console, and updates the user's heart rate.
     */
    public void updateUserBpm() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user bpm: ");
            int bpm = scanner.nextInt();

            userController.updateUserBpm(user, bpm);
            System.out.println("[APP] User bpm updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's experience level.
     * Requests the user's email or code and new experience level from the console, and updates the user's level.
     */
    public void updateUserLevel() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user level: ");
            int level = scanner.nextInt();

            userController.updateUserLevel(user, level);
            System.out.println("[APP] User level updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's address.
     * Requests the user's email or code and new address from the console, and updates the user's address.
     */
    public void updateUserAddress() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user address: ");
            String address = scanner.nextLine();

            userController.updateUserAddress(user, address);
            System.out.println("[APP] User address updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's phone number.
     * Requests the user's email or code and new phone number from the console, and updates the user's phone number.
     */
    public void updateUserPhone() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user phone: ");
            String phone = scanner.nextLine();

            userController.updateUserPhone(user, phone);
            System.out.println("[APP] User phone updated successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to update a user's email address.
     * Requests the user's email or code and new email address from the console, and updates the user's email.
     */
    public void updateUserEmail() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code to be updated: ");
        Object identifier = scanner.nextLine();

        try {
            User user = userController.getUser(identifier);

            System.out.print("[APP] Please enter the user email: ");
            String email = scanner.nextLine();

            userController.updateUserEmail(user, email);
            System.out.println("[APP] User email updated successfully.");
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
            Feeder feeder = new Feeder(userController);
            feeder.feedData(numberOfUsers);
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
            for (User user : userController.getAllUsers()) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
        System.out.println("==================");
    }

    /**
     * Prompts the administrator to add an activity to a user.
     * Requests the user's email or code and activity details from the console, and adds the activity to the user.
     */
    public void addActivity() {
        System.out.println("[APP] Adding activity ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code: ");
        Object identifier = scanner.nextLine();

        try {
            User user = this.userController.getUser(identifier);

            PushUp pushUp = new PushUp(user.getCode(), MakeItFitDate.fromString("10/12/2021"), 30, "Push-up", 10, 3);

            user.addActivity(pushUp);
            user.addActivity(pushUp);
            user.addActivity(pushUp);

            List<Activity> activities = user.getListActivities();

            System.out.println(activities);

            //this.userController.addActivityToUser(user, pushUp);
            System.out.println("[APP] Activity added successfully.");
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }

    /**
     * Prompts the administrator to list all activities from a user.
     * Requests the user's email or code from the console and lists all activities from the user.
     */
    public void listActivitiesFromUser() {
        System.out.println("[APP] Listing activities ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code: ");
        Object identifier = scanner.nextLine();

        try {
            User user = this.userController.getUser(identifier);

           List<Activity> activities = user.getListActivities();

            System.out.println(activities);
        } catch (Exception e) {
            System.out.println("[APP] Invalid input.");
        }
    }
}
