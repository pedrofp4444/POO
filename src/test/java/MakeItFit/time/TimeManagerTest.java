import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import MakeItFit.time.TimeManager;
/**
 * The tests for the TimeManager class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104100)
 * @version (11052024)
 */
public class TimeManagerTest {
    /**
     * Tests the constructor of the class TimeManager.
     */
    @Test
    public void testTimeManagerTest() {
        MakeItFitDate currentDate = MakeItFitDate.of(2021, 12, 1);
        TimeManager timeManager = new TimeManager(currentDate);
        assertNotNull(timeManager);
        assertEquals(currentDate, timeManager.getCurrentDate());

        assertEquals(timeManager.getCurrentDate().plusDays(2).getDate(),timeManager.advanceTime(2).getDate());
        assertEquals(timeManager.getCurrentDate().plusDays(18).getDate(),timeManager.advanceTime(18).getDate());
        assertNotEquals(timeManager.getCurrentDate().plusDays(2).getDate(),timeManager.advanceTime(4).getDate());
    }

    /**
     * Tests the constructor of the class TimeManager
     */
    @Test
    public void testTimeManagerConstructor() {
        MakeItFitDate currentDate = MakeItFitDate.of(2021, 12, 1);
        TimeManager timeManager = new TimeManager(currentDate);
        assertNotNull(timeManager);
        assertEquals(currentDate, timeManager.getCurrentDate());
    }

    /**
     * Tests the advanceTime method of the class TimeManager
     */
    @Test
    public void testAdvanceTime() {
        MakeItFitDate currentDate = MakeItFitDate.of(2021, 12, 1);
        TimeManager timeManager = new TimeManager(currentDate);
        assertNotNull(timeManager);
        assertEquals(currentDate, timeManager.getCurrentDate());
        assertEquals(timeManager.getCurrentDate().plusDays(2).getDate(),timeManager.advanceTime(2).getDate());
        assertEquals(timeManager.getCurrentDate().plusDays(18).getDate(),timeManager.advanceTime(18).getDate());
        assertNotEquals(timeManager.getCurrentDate().plusDays(2).getDate(),timeManager.advanceTime(4).getDate());
    }

    /**
     * Tests the advanceTime method of the class TimeManager
     */
    @Test
    public void testAdvanceTimeInvalidInputs() {
        MakeItFitDate currentDate = MakeItFitDate.of(2021, 12, 1);
        TimeManager timeManager = new TimeManager(currentDate);
        assertNotNull(timeManager);
        assertThrows(IllegalArgumentException.class, () -> {
            timeManager.advanceTime(-1);
        });
    }
}