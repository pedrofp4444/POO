package MakeItFit.queries;

import MakeItFit.activities.Activity;
import MakeItFit.activities.types.DistanceWithAltimetry;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.List;

/**
 * The class WhoBurnsMoreCalories represents a query that returns the user who burns more calories between two dates.
 *
 * @author Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */

public class WhoBurnsMoreCalories implements Serializable {

    /**
     * Executes a query and returns the result.
     * @param userManager
     * @param date1
     * @param date2
     *
     * @return the user who burns more calories between two dates
     */
    public User executeQuery(UserManager userManager, MakeItFitDate date1, MakeItFitDate date2) {

        if ((date1 != null && date2 != null )&& date2.isAfter(date1) ) {

            List<User> list_users = userManager.getAllUsers();

            User user = null;
            int maxCalories = 0;

            for (User u : list_users) {
                int calories = 0;
                float index = u.getIndex();
                for (Activity a : u.getListActivities()) {
                    if (a.getRealizationDate().isAfter(date1) && a.getRealizationDate().isBefore(date2)) {
                        calories += a.caloricWaste(index);
                    }
                }
                if (calories > maxCalories) {
                    maxCalories = calories;
                    user = u;
                }
            }
            return user;

        }else{
            throw  new IllegalArgumentException("Invalid dates.");
        }
    }

    /**
     * Executes a query and returns the result.
     * @param userManager
     *
     * @return the user who burns more calories
     */
    public User executeQuery(UserManager userManager) {

        List<User> list_users = userManager.getAllUsers();

        User user = null;
        int maxCalories = 0;

        for (User u : list_users) {
            float index = u.getIndex();
            int calories = 0;
            for (Activity a : u.getListActivities()) {
                calories += a.caloricWaste(index);

            }
            if (calories > maxCalories) {
                maxCalories = calories;
                user = u;
            }
        }
        return user;
    }
}
