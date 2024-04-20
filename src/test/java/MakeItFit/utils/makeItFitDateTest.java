package MakeItFit.utils;

import MakeItFit.utils.makeItFitDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The tests for the MakeItFitDate class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (a version number or a date)
 */
public class makeItFitDateTest {
    /**
     * Tests the MakeItFitDate essential methods.
     */
    @Test
    public void distance() {
        makeItFitDate date1 = makeItFitDate.of(2021, 12, 1);
        assertNotNull(date1);
        assertEquals(date1.getDayOfMonth(), 1);
        assertEquals(date1.getMonth(), 12);
        assertEquals(date1.getYear(), 2021);
        makeItFitDate date2 = makeItFitDate.fromString("10/12/2021");
        assertNotNull(date2);
        assertEquals(date2.getDayOfMonth(), 10);
        assertEquals(date2.getMonth(), 12);
        assertEquals(date2.getYear(), 2021);
        assertEquals(date1.distance(date2), 9);
    }
}