package MakeItFit.activities;

public interface ActivityInterface {

    int calculateCaloricWaste();

    int getDuration();

    int getExpectedDuration();

    String getDesignation();

    void setDuration(int duration);

    void setExpectedDuration(int expectedDuration);

    void setDesignation(String designation);

    String toString();
}
