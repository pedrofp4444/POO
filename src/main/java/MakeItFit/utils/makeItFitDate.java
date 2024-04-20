package MakeItFit.utils;

import java.time.LocalDate;

/**
 * The implementation for the makeItFitDate.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class makeItFitDate implements Comparable<makeItFitDate>{

    private final LocalDate date;
    
    /**
     * Parameterized constructor of the class makeItFitDate.
     */
    public static makeItFitDate of(int year, int month, int dayOfMonth) {
        return new makeItFitDate(LocalDate.of(year, month, dayOfMonth));
    }
    
    private makeItFitDate(LocalDate date) {
        this.date = date;
    }

    public static makeItFitDate fromString(String date) throws IllegalArgumentException {
        String[] split = date.trim().split("/");
        if (split.length != 3) {
            throw new IllegalArgumentException(date);
        }

        try {
            int dayOfMonth = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int year = Integer.parseInt(split[2]);

            return makeItFitDate.of(year, month, dayOfMonth);
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

    public boolean isBeforeOrSame(makeItFitDate date) {
        return this.compareTo(date) <= 0;
    }

    public boolean isBefore(makeItFitDate date) {
        return this.compareTo(date) < 0;
    }

    public boolean isAfterOrSame(makeItFitDate date) {
        return this.compareTo(date) >= 0;
    }

    public boolean isAfter(makeItFitDate date) {
        return this.compareTo(date) > 0;
    }

    public makeItFitDate plusDays(int days) {
        return new makeItFitDate(this.date.plusDays(days));
    }

    public boolean isEqual(makeItFitDate other) {
        return this.date.isEqual(other.date);
    }

    public int distance(makeItFitDate date) {
        return (int) Math.abs(this.date.toEpochDay() - date.date.toEpochDay());
    }

    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d", this.getDayOfMonth(), this.getDayOfMonth(), this.getYear());
    }

    @Override
    public int compareTo(makeItFitDate object) {
        return this.date.compareTo(object.date);
    }
}