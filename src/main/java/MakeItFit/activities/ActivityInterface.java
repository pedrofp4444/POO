package MakeItFit.activities;

import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public interface ActivityInterface {

    /**
     * Calculates the caloric waste of the activity.
     *
     * @param index the index of the user
     */
    void calculateCaloricWaste(float index);

    /**
     * Gets the code of the user.
     *
     * @return the code of the user
     */
    UUID getUserCode();

    /**
     * Gets the code of the user.
     *
     * @return the code of the user
     */
    UUID getCode();

    /**
     * Gets the expected duration of the activity.
     *
     * @return the expected duration of the activity
     */
    int getExpectedDuration();

    /**
     * Gets the duration of the activity.
     *
     * @return the dureation of the activity
     */
    int getDuration();

    /**
     * Gets the designation of the activity.
     *
     * @return the designation of the activity
     */
    String getDesignation();

    /**
     * Sets the duration of the activity.
     */
    void setDuration(int duration);

    /**
     * Sets expected duration of the activity.
     */
    void setExpectedDuration(int expectedDuration);

/**
     * Sets the designation of the activity.
     */
    void setDesignation(String designation);

    /**
     * Returns a string representation of the Activity.
     *
     * @return the string representation of the Activity
     */
    String toString();

    /**
     * Compares the Activity with another object.
     *
     * @param o the object to compare
     * @return true if the object is equal to the Activity, false otherwise
     */
    public boolean equals(Object o);

    /**
     * Creates a deep copy of the Activity.
     *
     * @return A new Activity instance that is a deep copy of the current instance.
     */
    int compareTo(Activity other);
}
