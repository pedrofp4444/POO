package MakeItFit.menu;

/**
 * The class MenuItem represents a menu item for the application.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class MenuItem {
    private String name;
    private Runnable action;

    /**
     * Constructs a `MenuItem` with a specified name and action.
     *
     * @param name   The name of the menu item.
     * @param action The action to be executed when the menu item is selected.
     */
    public MenuItem(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    /**
     * Gets the name of the menu item.
     *
     * @return The name of the menu item.
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the action associated with the menu item.
     * This method is called when the menu item is selected by the user.
     */
    public void execute() {
        action.run();
    }
}
