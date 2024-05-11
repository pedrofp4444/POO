package MakeItFit.queries;

import MakeItFit.activities.Activity;
import MakeItFit.activities.types.*;
import MakeItFit.users.User;

import MakeItFit.users.UserManager;

import java.io.Serializable;
import java.util.List;

/**
 * The class MostDoneActivity represents the query that returns the most done activity.
 *
 * @author Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */

public class MostDoneActivity implements Serializable {

    /**
     * Executes the query and returns the result.
     * @param userManager
     *
     * @return the most done activity
     */

    public String executeQuery(UserManager userManager) {
        List<User> list_users = userManager.getAllUsers();

        int[] count ={0,0,0,0};

        for (User u : list_users) {
            for (Activity a : u.getListActivities()) {
                if (a instanceof DistanceWithAltimetry) {
                    count[0]++;
                } else if (a instanceof Distance) {
                    count[1]++;
                } else if (a instanceof RepetitionsWithWeights) {
                    count[2]++;
                } else if (a instanceof Repetitions) {
                    count[3]++;
                }
            }
        }
        int maxIndex = max(count);
        return switch (maxIndex) {
            case 0 -> "DistanceWithAltimetry";
            case 1 -> "Distance";
            case 2 -> "Repetitions";
            case 3 -> "RepetitionsWithWeights";
            default -> "No activities";
        };

    }


    /**
     * Returns the index of the maximum value in the array.
     * @param array
     *
     * @return the index of the maximum value in the array
     */
    private static int max(int[] array){
        int maxIndex=0;

        for(int j=0;j<array.length;j++){
            if(array[j]>array[maxIndex]){
                maxIndex=j;
            }
        }
        return maxIndex;
    }
}
