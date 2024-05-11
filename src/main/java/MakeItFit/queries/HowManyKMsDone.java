package MakeItFit.queries;

import MakeItFit.activities.Activity;
import MakeItFit.activities.types.*;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;

/**
 * This class is responsible for the query that calculates the total distance done by a user in a given period of time.
 *
 * @author Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */

public class HowManyKMsDone implements Serializable {

    /**
     * Executes a query to find the total distance done by a user in a given period of time.
     * @param userManager
     * @param email
     * @param date1
     * @param date2
     * @return the total distance done by a user in a given period of time
     */
    public double executeQuery(UserManager userManager, String email, MakeItFitDate date1 , MakeItFitDate date2) {

        if ( date1 != null && date2 != null && date2.isAfter(date1) ) {
            User user = userManager.getUserByEmail(email);
            double distance = 0;

            for (Activity a : user.getListActivities()) {
                if (a instanceof Distance && a.getRealizationDate().isAfter(date1) && a.getRealizationDate().isBefore(date2)) {
                    distance += ((Distance) a).getDistance();
                }
            }

            return distance/1000;

        }else{
             throw  new IllegalArgumentException("Invalid dates.");
        }

    }

    /**
     * Executes a query to find the total distance done by a user.
     * @param userManager
     * @param email
     * @return the total distance done by a user
     */
    public double executeQuery(UserManager userManager, String email) {

        User user = userManager.getUserByEmail(email);
        double distance = 0;

        for( Activity a : user.getListActivities() ){
            if(a instanceof Distance ) {
                distance += ((Distance) a).getDistance();
            }
        }

        return distance/1000;
    }
}
