package MakeItFit.users;

import MakeItFit.exceptions.EntityDoesNotExistException;

import java.util.Scanner;

public class UserView {

    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

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

        this.userController.createUser(name, age, gender, weight, height, bpm, level, address, phone, email);

        System.out.println("[APP] User created successfully.");
        } catch (Exception e) { // TODO: Check if we want to improve this
            System.out.println("[APP] Invalid input.");
        }
    }

    public void removeUser() {
        try {
            System.out.println("[APP] Removing user ...");

            Scanner scanner = new Scanner(System.in);

            System.out.print("[APP] Enter the user's email or code: ");
            Object identifier = scanner.nextLine();

            this.userController.removeUser(identifier);
            System.out.println("[APP] User removed successfully.");
        } catch (EntityDoesNotExistException e) {
            System.out.println("[APP] User does not exist.");
        }
    }

    public void getUserDetails() {
        System.out.println("[APP] Getting user details ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code: ");
        Object identifier = scanner.nextLine();

        try {
        User user = userController.getUser(identifier);
            System.out.println(user.toString());
        } catch (Exception e) { // TODO: Check if we want to improve this
            System.out.println("[APP] Invalid input.");
        }
    }

    public void updateUser() {
        System.out.println("[APP] Updating user ...");

        Scanner scanner = new Scanner(System.in);

        System.out.print("[APP] Enter the user's email or code: ");
        Object identifier = scanner.nextLine();

        try {
        User user = userController.getUser(identifier);

        System.out.println("[APP] Please enter the following information:");

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

        this.userController.updateUser(user, name, age, gender, weight, height, bpm, level, address, phone, email);
        System.out.println("[APP] User updated successfully.");
        } catch (Exception e) { // TODO: Check if we want to improve this
            System.out.println("[APP] Invalid input.");
        }
    }

    public void printAllUsersDetails() {
        System.out.println("== (All users) ==");
        try {
            for (User user : userController.getAllUsers()) {
                System.out.println(user.toString());
            }
        } catch (Exception e) { // TODO: Check if we want to improve this
            System.out.println("[APP] Invalid input.");
        }
        System.out.println("==================");
    }
}
