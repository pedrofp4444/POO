package MakeItFit.time;

import MakeItFit.utils.MakeItFitDate;
public class TimeManager {
    private MakeItFitDate currentDate;

    public TimeManager(MakeItFitDate currentDate) {
        this.currentDate = currentDate;
    }

    public MakeItFitDate getCurrentDate() {
        return this.currentDate;
    }

    public MakeItFitDate advanceTime(int days){
        return this.currentDate = this.currentDate.plusDays(days);
    }

}
