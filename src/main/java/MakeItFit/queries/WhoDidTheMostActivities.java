package MakeItFit.queries;

import MakeItFit.activities.Activity;
import MakeItFit.activities.types.DistanceWithAltimetry;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;
import java.util.List;

public class WhoDidTheMostActivities implements Serializable {

    /**
     * Executes a query and returns the result.
     * @param userManager
     * @param date1
     * @param date2
     *
     * @return the user who did the most activities between two dates
     */
    public User executeQuery(UserManager userManager, MakeItFitDate date1, MakeItFitDate date2) {

        if ((date1 != null && date2 != null )&& date2.isAfter(date1)) {

            List<User> list_users = userManager.getAllUsers();

            User user = null;
            int maxActivities = 0;

            for (User u : list_users) {
                int activities = 0;
                for (Activity a : u.getListActivities()) {
                    if (a.getRealizationDate().isAfter(date1) && a.getRealizationDate().isBefore(date2)) {
                        activities++;
                    }
                }
                if (activities > maxActivities) {
                    maxActivities = activities;
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
     * @return the user who did the most activities
     */
    public User executeQuery(UserManager userManager) {

        List<User> list_users = userManager.getAllUsers();

        User user = null;
        int maxActivities = 0;

        for (User u : list_users) {

            List<Activity> activitiesList = u.getListActivities();
            int activities = activitiesList.size();

            if (activities > maxActivities) {
                maxActivities = activities;
                user = u;
            }
        }
        return user;
    }
}
