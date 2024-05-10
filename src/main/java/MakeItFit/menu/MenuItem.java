package MakeItFit.menu;

public class MenuItem {

    public interface PreCondition {
        boolean validate();
    }

    public interface Handler {
        void execute();
    }

    private String name;
    private PreCondition preCondition;
    private Handler action;

    public MenuItem(String name, Handler action) {
        this.name = name;
        this.action = action;
        this.preCondition = () -> true;
    }

    public MenuItem(String name, PreCondition preCondition, Handler action) {
        this.name = name;
        this.preCondition = preCondition;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void execute() {
        if (preCondition.validate()) {
            action.execute();
        } else {
            System.out.println("Option not available!");
        }
    }

    public boolean isValid() {
        return preCondition.validate();
    }
}
