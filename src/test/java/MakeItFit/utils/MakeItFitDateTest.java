import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.utils.MakeItFitDate;

/**
 * The tests for the MakeItFitDate class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class MakeItFitDateTest {

    /**
     * Tests the MakeItFitDate essential methods.
     */
    @Test
    public void distanceTest() {
        MakeItFitDate date1 = MakeItFitDate.of(2021, 12, 1);
        assertNotNull(date1);
        assertEquals(date1.getDayOfMonth(), 1);
        assertEquals(date1.getMonth(), 12);
        assertEquals(date1.getYear(), 2021);
        MakeItFitDate date2 = MakeItFitDate.fromString("10/12/2021");
        assertNotNull(date2);
        assertEquals(date2.getDayOfMonth(), 10);
        assertEquals(date2.getMonth(), 12);
        assertEquals(date2.getYear(), 2021);
        assertEquals(date1.distance(date2), 9);
    }

    /**
     * Tests the MakeItFitDate essential methods.
     */
    @Test
    public void testToString() {
        MakeItFitDate date1 = MakeItFitDate.of(2021, 12, 1);
        assertNotNull(date1);
        assertEquals(date1.toString(), "01/12/2021");
    }

    /**
     * Tests the MakeItFitDate essential methods.
     */
    @Test
    public void equals(){
        MakeItFitDate date1 = MakeItFitDate.of(2021, 12, 1);
        MakeItFitDate date2 = MakeItFitDate.of(2021, 12, 1);
        MakeItFitDate date3 = MakeItFitDate.of(2021, 12, 2);
        MakeItFitDate date4 = MakeItFitDate.of(2021, 11, 1);
        MakeItFitDate date5 = MakeItFitDate.of(2020, 12, 1);
        MakeItFitDate date6 = MakeItFitDate.of(2021, 12, 1);
        assertEquals(date1, date2);
        assertNotEquals(date1, date3);
        assertNotEquals(date1, date4);
        assertNotEquals(date1, date5);
        assertEquals(date1, date6);
    }

    /**
     * Tests the MakeItFitDate essential methods.
     */
    @Test
    public void compareTo(){
        MakeItFitDate date1 = MakeItFitDate.of(2021, 12, 1);
        MakeItFitDate date2 = MakeItFitDate.of(2021, 12, 1);
        MakeItFitDate date3 = MakeItFitDate.of(2021, 12, 2);
        MakeItFitDate date4 = MakeItFitDate.of(2021, 11, 1);
        MakeItFitDate date5 = MakeItFitDate.of(2020, 12, 1);
        MakeItFitDate date6 = MakeItFitDate.of(2021, 12, 1);
        assertEquals(date1.compareTo(date2), 0);
        assertEquals(date1.compareTo(date3), -1);
        assertEquals(date1.compareTo(date4), 1);
        assertEquals(date1.compareTo(date5), 1);
        assertEquals(date1.compareTo(date6), 0);
    }
}
