package MakeItFit.menu;

import java.util.List;
import java.util.Scanner;

/**
 * The class Menu represents a menu for the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class Menu {
    private List<MenuItem> items;
    private boolean keepRunning;

    /**
     * Constructs a Menu with a list of menu items.
     *
     * @param items The list of menu items to be included in the menu.
     */
    public Menu(List<MenuItem> items) {
        this.items = items;
        this.keepRunning = true;
    }

    /**
     * Displays the menu options to the user.
     * Each menu item is displayed with a corresponding index number.
     * An "Exit" option is also included at the end of the menu.
     */
    public void display() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println((i + 1) + ". " + this.items.get(i).getName());
        }
        System.out.println((this.items.size() + 1) + ". Exit");
    }

    /**
     * Prompts the user to select an option from the menu.
     * The user enters the index number of the desired option.
     *
     * @return The index number of the user's choice.
     */
    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline
        return choice;
    }

    /**
     * Executes the action associated with the selected menu option.
     * If the user selects an option within the range of available items, the corresponding menu item is executed.
     * If the user selects the "Exit" option, the menu stops running.
     * Otherwise, an "Invalid Option" message is displayed.
     */
    public void executeSelectedOption() {
        int choice = getUserChoice();
        if (choice > 0 && choice <= this.items.size()) {
            this.items.get(choice - 1).execute();
        } else if (choice == this.items.size() + 1) {
            keepRunning = false; // Stop the menu
        } else {
            System.out.println("Invalid Option");
        }
    }

    /**
     * Stops the menu from running.
     */
    public void stopMenu() {
        keepRunning = false;
    }

    /**
     * Runs the menu, displaying the options and handling user input.
     * The menu will keep running until the user selects the "Exit" option.
     */
    public void run() {
        do {
            display(); // Display the menu options
            executeSelectedOption(); // Execute the selected option
        } while (keepRunning); // Keep running the menu until the user chooses to exit
    }
}
