package MakeItFit.activities;

import java.util.UUID;

public interface ActivityInterface {

    int calculateCaloricWaste();

    UUID getUserCode();

    UUID getCode();

    int getExpectedDuration();

    int getDuration();

    String getDesignation();

    void setDuration(int duration);

    void setExpectedDuration(int expectedDuration);

    void setDesignation(String designation);

    String toString();

    public boolean equals(Object o);
}
