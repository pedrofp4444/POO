package MakeItFit.queries;

import MakeItFit.trainingPlan.TrainingPlan;
import MakeItFit.trainingPlan.TrainingPlanManager;
import MakeItFit.users.User;
import MakeItFit.users.UserManager;
import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;

/**
     * The class QueriesManager represents a manager of queries.
     *
     * @author Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
     * @version (11052024)
     */
public class QueriesManager implements Serializable {
    private HowManyAltimetryDone howManyAltimetryDone;
    private HowManyKMsDone howManyKMsDone;
    private MostDoneActivity mostDoneActivity;
    private MostDemandingTrainingPlan mostDemandingTrainingPlan;
    private WhoBurnsMoreCalories whoBurnsMoreCalories;
    private WhoDidTheMostActivities whoDidTheMostActivities;

    /**
     * Constructs a new queries manager.
     */
    public QueriesManager(UserManager userManager, TrainingPlanManager trainingPlanManager) {
        this.howManyAltimetryDone = new HowManyAltimetryDone();
        this.howManyKMsDone = new HowManyKMsDone();
        this.mostDoneActivity = new MostDoneActivity();
        this.mostDemandingTrainingPlan = new MostDemandingTrainingPlan();
        this.whoBurnsMoreCalories = new WhoBurnsMoreCalories();
        this.whoDidTheMostActivities = new WhoDidTheMostActivities();

        this.mostDemandingTrainingPlan =  new MostDemandingTrainingPlan();
    }

    /**
     * Executes a query.
     * @param userManager
     * @param email
     * @param date1
     * @param date2
     *
     * @return number of altimetry the user done
     */
    public double executeQueryHowManyAltimetryDone(UserManager userManager, String email , MakeItFitDate date1 , MakeItFitDate date2) {
        return this.howManyAltimetryDone.executeQuery(userManager, email, date1, date2);
    }

    /**
     * Executes a query.
     * @param userManager
     * @param email
     *
     * @return number of altimetry the user done
     */
    public double executeQueryHowManyAltimetryDone(UserManager userManager, String email) {
        return this.howManyAltimetryDone.executeQuery(userManager, email);
    }

    /**
     * Executes a query and returns the result.
     * @param userManager
     * @param email
     * @param date1
     * @param date2
     *
     * @return number of km the user did in a given period of time or in total
     */
    public double executeQueryHowManyKMsDone(UserManager userManager, String email , MakeItFitDate date1 , MakeItFitDate date2) {
        return this.howManyKMsDone.executeQuery(userManager, email, date1, date2);
    }

    /**
     * Executes a query and returns the result.
     * @param userManager
     * @param email
     *
     * @return number of km the user did in a given period of time or in total
     */
    public double executeQueryHowManyKMsDone(UserManager userManager, String email) {
        return this.howManyKMsDone.executeQuery(userManager, email);
    }

    /**
     * Executes a query.
     * @param userManager
     *
     * @return the most done activity
     */
    public String executeQueryMostDoneActivity(UserManager userManager) {
        return this.mostDoneActivity.executeQuery(userManager);
    }

    /**
     * Executes a query.
     * @param trainingPlanManager
     * @return the most demanding training plan
     */
    public TrainingPlan executeQueryMostDemandingTrainingPlan(TrainingPlanManager trainingPlanManager , UserManager userManager) {
        return this.mostDemandingTrainingPlan.executeQuery(trainingPlanManager, userManager);
    }

    /**
     * Executes a query.
     * @param userManager
     * @param date1
     * @param date2
     *
     * @return the user who burns more calories
     */
    public User executeQuerywhoBurnsMoreCalories(UserManager userManager, MakeItFitDate date1, MakeItFitDate date2) {
        return this.whoBurnsMoreCalories.executeQuery(userManager, date1, date2);
    }

    /**
     * Executes a query.
     * @param userManager
     *
     * @return the user who burns more calories
     */
    public User executeQuerywhoBurnsMoreCalories(UserManager userManager) {
        return this.whoBurnsMoreCalories.executeQuery(userManager);
    }

    /**
     * Executes a query.
     * @param userManager
     * @param date1
     * @param date2
     *
     * @return the user who did the most activities
     */
    public User executeQueryWhoDidTheMostActivities (UserManager userManager, MakeItFitDate date1, MakeItFitDate date2) {
        return this.whoDidTheMostActivities.executeQuery(userManager, date1, date2);
    }

    /**
     * Executes a query.
     * @param userManager
     *
     * @return the user who did the most activities
     */
    public User executeQueryWhoDidTheMostActivities (UserManager userManager) {
        return this.whoDidTheMostActivities.executeQuery(userManager);
    }
}