package MakeItFit.queries;

import MakeItFit.activities.Activity;
import MakeItFit.activities.types.*;
import MakeItFit.users.User;

import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;

/**
 * This class is responsible for the query that calculates the total altimetry done by a user in a given period of time.
 *
 * @author Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */

public class HowManyAltimetryDone {

    /**
     * Executes a query to find the total altimetry done by a user in a given period of time.
     * @param userManager
     * @param email
     * @param date1
     * @param date2
     * @return the total altimetry done by a user in a given period of time
     */

    public double executeQuery(UserManager userManager, String email, MakeItFitDate date1 , MakeItFitDate date2) {

        if(date1 == null && date2 == null){

            User user = userManager.getUserByEmail(email);
            double altimetry = 0;
            for (Activity a : user.getListActivities()) {

                if (a instanceof DistanceWithAltimetry)  {
                    altimetry += ((DistanceWithAltimetry) a).getElevationGain()-((DistanceWithAltimetry) a).getElevationLoss();
                }
            }
            return altimetry;



        }else if ( (date1 != null && date2 != null )&& date2.isAfter(date1) ) {

            User user = userManager.getUserByEmail(email);
            double altimetry = 0;
            for (Activity a : user.getListActivities()) {

                if (a instanceof DistanceWithAltimetry  && a.getRealizationDate().isAfter(date1) && a.getRealizationDate().isBefore(date2)){
                    altimetry += ((DistanceWithAltimetry) a).getElevationGain()-((DistanceWithAltimetry) a).getElevationLoss();
                }
            }
            return altimetry;

        }else{
            throw  new IllegalArgumentException("Invalid input: date1 and date2 must be non-null and date2 must be after date1.");
        }

    }

}

