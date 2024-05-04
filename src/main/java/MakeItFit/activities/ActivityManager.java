package MakeItFit.activities;

import MakeItFit.activities.implementation.PushUp;
import MakeItFit.activities.implementation.Running;
import MakeItFit.activities.implementation.Trail;
import MakeItFit.activities.implementation.WeightSquat;

import java.util.*;

/**
 * The ActivityManager class represents a manager of activities.
 * It provides methods to create and manage activities.
 * It is a singleton class
 */

public class ActivityManager {
    private static final List<String> activities = Arrays.asList("PushUp", "Running", "Trail", "WeightSquat");
    Random random = new Random();

    /**
     * Constructs a new ActivityManager instance.
     */
    public String getRandomActivity() {
        int index = random.nextInt(activities.size());
        return activities.get(index);
    }
}
