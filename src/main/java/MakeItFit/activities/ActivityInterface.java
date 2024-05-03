package MakeItFit.activities;

import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public interface ActivityInterface {

    void calculateCaloricWaste(float index);

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
