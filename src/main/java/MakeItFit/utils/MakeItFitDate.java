package MakeItFit.utils;

import java.time.LocalDate;

/**
 * The implementation for the MakeItFitDate.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (a version number or a date)
 */
public class MakeItFitDate implements Comparable<MakeItFitDate>{

    private final LocalDate date;

    /**
     * Default constructor of the class MakeItFitDate.
     */
    public MakeItFitDate () {
        this.date = LocalDate.now();
    }

    /**
     * Parameterized constructor of the class MakeItFitDate.
     */
    public static MakeItFitDate of(int year, int month, int dayOfMonth) {
        return new MakeItFitDate(LocalDate.of(year, month, dayOfMonth));
    }
    
    private MakeItFitDate(LocalDate date) {
        this.date = date;
    }

    public static MakeItFitDate fromString(String date) throws IllegalArgumentException {
        String[] split = date.trim().split("/");
        if (split.length != 3) {
            throw new IllegalArgumentException(date);
        }

        try {
            int dayOfMonth = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int year = Integer.parseInt(split[2]);

            return MakeItFitDate.of(year, month, dayOfMonth);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(date);
        }
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public int getMonth(){
        return this.date.getMonthValue();
    }

    public int getYear(){
        return this.date.getYear();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public boolean isBeforeOrSame(MakeItFitDate date) {
        return this.compareTo(date) <= 0;
    }

    public boolean isBefore(MakeItFitDate date) {
        return this.compareTo(date) < 0;
    }

    public boolean isAfterOrSame(MakeItFitDate date) {
        return this.compareTo(date) >= 0;
    }

    public boolean isAfter(MakeItFitDate date) {
        return this.compareTo(date) > 0;
    }

    public MakeItFitDate plusDays(int days) {
        return new MakeItFitDate(this.date.plusDays(days));
    }

    public boolean isEqual(MakeItFitDate other) {
        return this.date.isEqual(other.date);
    }

    public int distance(MakeItFitDate date) {
        return (int) Math.abs(this.date.toEpochDay() - date.date.toEpochDay());
    }

    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d", this.getDayOfMonth(), this.getMonth(), this.getYear());
    }

    @Override
    public int compareTo(MakeItFitDate object) {
        return this.date.compareTo(object.date);
    }
}