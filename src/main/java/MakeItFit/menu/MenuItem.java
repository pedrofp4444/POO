package MakeItFit.menu;

public class MenuItem {
    private String name;
    private Runnable action;

    public MenuItem(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        action.run();
    }
}
