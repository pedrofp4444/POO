package MakeItFit.time;

import MakeItFit.utils.MakeItFitDate;

import java.io.Serializable;

/**
 * Represents the time manager of the system, with the current date and the ability to advance time.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class TimeManager implements Serializable {
    private MakeItFitDate currentDate;

    /**
     * Constructs a new TimeManager with the current date set to the current system date.
     *
     * @return the created TimeManager
     */
    public TimeManager() {
        this.currentDate = new MakeItFitDate();
    }

    /**
     * Constructs a new TimeManager with the specified current date.
     *
     * @param currentDate
     *
     * @return the created TimeManager
     */
    public TimeManager(MakeItFitDate currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * Gets the current date of the TimeManager.
     *
     * @return the current date
     */
    public MakeItFitDate getCurrentDate() {
        return this.currentDate;
    }

    /**
     * Advances the current date by the specified number of days.
     *
     * @param days the number of days to advance the current date
     *
     * @return the new current date
     *
     * @throws IllegalArgumentException if the number of days is negative
     */
    public MakeItFitDate advanceTime(int days) throws IllegalArgumentException {
        if(days < 0){
            throw new IllegalArgumentException("Days must be a positive number.");
        }
        return this.currentDate = this.currentDate.plusDays(days);
    }
}
