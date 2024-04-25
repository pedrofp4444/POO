package MakeItFit;

import MakeItFit.users.UserController;
import MakeItFit.users.UserView;
import MakeItFit.users.UserManager;
import MakeItFit.menu.*;
import java.util.*;

public class Main {
    public static void main(String args[]){

        UserManager userManager = new UserManager();
        UserController userController = new UserController(userManager);
        UserView userView = new UserView(userController);

        List<MenuItem> mainMenuItems = new ArrayList<>();

        mainMenuItems.add(new MenuItem("Init the application", () -> {
            System.out.println("[APP] Application is running ...");

            List<MenuItem> appMenuItems = new ArrayList<>();

            appMenuItems.add(new MenuItem("Create User", () -> userView.createUser()));
            appMenuItems.add(new MenuItem("Update User", () -> userView.updateUser()));
            appMenuItems.add(new MenuItem("Remove User", () -> userView.removeUser()));
            appMenuItems.add(new MenuItem("User Details", () -> userView.getUserDetails()));
            appMenuItems.add(new MenuItem("List all users", () -> userView.printAllUsersDetails()));
            appMenuItems.add(new MenuItem("Exit", () -> System.exit(0)));

            Menu appMenu = new Menu(appMenuItems);

            appMenu.run();
        }));
        mainMenuItems.add(new MenuItem("Help", () -> System.out.println("This is a help message that I should write.")));
        mainMenuItems.add(new MenuItem("Authors", () -> System.out.println("Afonso Santos, Hélder Gomes e Pedro Pereira")));
        mainMenuItems.add(new MenuItem("Exit", () -> System.exit(0)));

        Menu mainMenu = new Menu(mainMenuItems);
    
        mainMenu.run();
    }
}
