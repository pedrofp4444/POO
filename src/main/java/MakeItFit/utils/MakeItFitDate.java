package MakeItFit.utils;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The implementation for the MakeItFitDate.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MakeItFitDate implements Comparable<MakeItFitDate>, Serializable {

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

    /**
     * Parameterized constructor of the class MakeItFitDate.
     */
    private MakeItFitDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Creates a MakeItFitDate from a string.
     *
     * @param date the string to be converted
     * @return the MakeItFitDate
     * @throws IllegalArgumentException if the string is not a valid date
     */
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

    /**
     * Gets the day of the week.
     * Monday is 1, Tuesday is 2, ..., Sunday is 7.
     *
     * @return the day of the week
     */
    public int getDayOfWeek() {
        return this.date.getDayOfWeek().getValue();
    }

    /**
     * Gets the day of the month.
     *
     * @return the day of the month
     */
    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    /**
     * Gets the month.
     *
     * @return the month
     */
    public int getMonth(){
        return this.date.getMonthValue();
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear(){
        return this.date.getYear();
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Determines whether this MakeItFitDate instance is before or the same as another MakeItFitDate instance.
     *
     * @param date the MakeItFitDate instance to compare with
     * @return true if this MakeItFitDate instance is before or the same as the other MakeItFitDate instance; otherwise, false
     */
    public boolean isBeforeOrSame(MakeItFitDate date) {
        return this.compareTo(date) <= 0;
    }

    /**
     * Determines whether this MakeItFitDate instance is before another MakeItFitDate instance.
     *
     * @param date the MakeItFitDate instance to compare with
     * @return true if this MakeItFitDate instance is before the other MakeItFitDate instance; otherwise, false
     */
    public boolean isBefore(MakeItFitDate date) {
        return this.compareTo(date) < 0;
    }

    /**
     * Determines whether this MakeItFitDate instance is after or the same as another MakeItFitDate instance.
     *
     * @param date the MakeItFitDate instance to compare with
     * @return true if this MakeItFitDate instance is after or the same as the other MakeItFitDate instance; otherwise, false
     */
    public boolean isAfterOrSame(MakeItFitDate date) {
        return this.compareTo(date) >= 0;
    }

    /**
     * Determines whether this MakeItFitDate instance is after another MakeItFitDate instance.
     *
     * @param date the MakeItFitDate instance to compare with
     * @return true if this MakeItFitDate instance is after the other MakeItFitDate instance; otherwise, false
     */
    public boolean isAfter(MakeItFitDate date) {
        return this.compareTo(date) > 0;
    }

    /**
     * Adds days to the date.
     *
     * @param days the number of days to add
     * @return the new date
     */
    public MakeItFitDate plusDays(int days) {
        return new MakeItFitDate(this.date.plusDays(days));
    }

    /**
     * Checks if two dates are equal.
     *
     * @param o the other date
     * @return true if the dates are equal; otherwise, false
     */
    @Override
    public boolean equals(Object o) {
        MakeItFitDate date = (MakeItFitDate) o;
        return this.date.isEqual(date.getDate());
    }

    /**
     * Calculates the distance between two dates.
     *
     * @param date the other date
     * @return the distance between the two dates
     */
    public int distance(MakeItFitDate date) {
        return (int) Math.abs(this.date.toEpochDay() - date.date.toEpochDay());
    }

    /**
     * Returns a string representation of the MakeItFitDate.
     *
     * @return a string representation of the MakeItFitDate
     */
    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d", this.getDayOfMonth(), this.getMonth(), this.getYear());
    }

    /**
     * Compares this MakeItFitDate instance with another MakeItFitDate instance.
     *
     * @param object the MakeItFitDate instance to compare with
     * @return a negative integer, zero, or a positive integer as this MakeItFitDate instance is before, the same as, or after the other MakeItFitDate instance
     */
    @Override
    public int compareTo(MakeItFitDate object) {
        return this.date.compareTo(object.date);
    }

    /**
     * Creates a copy of the current MakeItFitDate instance.
     *
     * @return A new MakeItFitDate instance that is a copy of the current instance.
     */
    @Override
    public MakeItFitDate clone() {
        return new MakeItFitDate(this.date);
    }
}
