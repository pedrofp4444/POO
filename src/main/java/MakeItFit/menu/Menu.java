package MakeItFit.menu;

import java.util.List;
import java.util.Scanner;

/**
 * The class Menu represents a menu for the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class Menu {
    private List<MenuItem> items;
    private boolean keepRunning;

    public Menu(List<MenuItem> items) {
        this.items = items;
        this.keepRunning = true;
    }

    public void display() {
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + (item.isValid() ? item.getName() : "---"));
        }
        System.out.println((items.size() + 1) + ". Exit");
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the option: ");
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumes the next line
                if (choice >= 1 && choice <= items.size() + 1) {
                    break;
                }
            } else {
                scanner.nextLine(); // Consumes the next line
            }
            System.out.println("Invalid option!");
        }
        return choice;
    }

    public void executeSelectedOption() {
        int choice = getUserChoice();
        if (choice > 0 && choice <= items.size()) {
            items.get(choice - 1).execute();
        } else if (choice == items.size() + 1) {
            keepRunning = false;
        } else {
            System.out.println("Invalid option!");
        }
    }

    public void run() {
        while (keepRunning) {
            display();
            executeSelectedOption();
        }
    }
}
