package MakeItFit.queries;

import MakeItFit.activities.Activity;
import MakeItFit.trainingPlan.TrainingPlan;

import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MyTuple;

import java.io.Serializable;
import java.util.List;

/**
 * The class MostDemandingTrainingPlan represents the most demanding training plan.
 * It is a query that returns the training plan that burns more calories.
 *
 * @author Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */

public class MostDemandingTrainingPlan implements Serializable {
    /**
     * Executes a query and returns the mostdemanding training plan.
     * @param trainingPlanManager
     * @param userManager
     *
     * @return the most demanding training plan
     */
    public TrainingPlan executeQuery(TrainingPlanManager trainingPlanManager, UserManager userManager) {
        List<TrainingPlan> list_trainingPlans = trainingPlanManager.getAllTrainingPlans();

        TrainingPlan trainingPlan = null;
        int maxActivities = 0;

        for (TrainingPlan tp : list_trainingPlans) {
            int calories = 0;
            User user = userManager.getUserByCode(tp.getUserCode());
            float index = user.getIndex();

            List<MyTuple<Integer, Activity>> activities = tp.getActivities();



            for (MyTuple<Integer, Activity> tuple : activities) {
                calories += tuple.getItem1()* tuple.getItem2().caloricWaste(index);
            }
            if (calories > maxActivities) {
                maxActivities = calories;
                trainingPlan = tp;
            }
        }

        return trainingPlan;
    }
}
