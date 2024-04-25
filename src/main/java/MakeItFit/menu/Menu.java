package MakeItFit.menu;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> items;

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public void display() {
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println((i + 1) + ". " + this.items.get(i).getName());
        }
    }

    public int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void executeSelectedOption() {
        int choice = getUserChoice();
        if (choice > 0 && choice <= this.items.size()) {
            this.items.get(choice - 1).execute();
        } else {
            System.out.println("Invalid option");
        }
    }

    public void run() {
        do {
            display();
            executeSelectedOption();
        } while (true);
    }
}
