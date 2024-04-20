package MakeItFit.time;

import MakeItFit.utils.makeItFitDate;
public class TimeManager {
    private makeItFitDate currentDate;

    public TimeManager(makeItFitDate currentDate) {
        this.currentDate = currentDate;
    }

    public makeItFitDate getCurrentDate() {
        return this.currentDate;
    }

    public makeItFitDate advanceTime(int days){
        return this.currentDate = this.currentDate.plusDays(days);
    }
}
