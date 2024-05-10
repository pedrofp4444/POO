package MakeItFit.queries;

import MakeItFit.activities.implementation.*;
import MakeItFit.users.*;
import MakeItFit.users.types.*;
import MakeItFit.utils.MakeItFitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhoDidTheMostActivitiesTest {

    private UserManager userManager;
    private User testUser1;
    private User testUser2;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
        testUser1 = new Amateur("Test User 1", 30, Gender.Male, 70, 180, 65, 3, "Test Street", "123456789", "test1@example.com");
        testUser2 = new Amateur("Test User 2", 30, Gender.Female, 60, 170, 55, 2, "Test Street", "123456789", "test2@example.com");

        userManager.insertUser(testUser1);
        userManager.insertUser(testUser2);

        testUser1.addActivity(new Running(testUser1.getCode(), MakeItFitDate.of(2024, 5, 4), 45, "Braga em Movimento", "Running", 2300, 14.5));
        testUser1.addActivity(new Trail(testUser1.getCode(), MakeItFitDate.of(2024, 5, 7), 30, "Serra da Lua", "Trail", 55040.6, 299.2, 299.7, Trail.TRAIL_TYPE_EASY));
        testUser2.addActivity(new Running(testUser2.getCode(), MakeItFitDate.of(2024, 5, 12), 45, "Porto em Movimento", "Running", 1000, 15));
    }

    @Test
    void testExecuteQueryValidUsers() {
        WhoDidTheMostActivities activityAnalyzer = new WhoDidTheMostActivities();

        String result = activityAnalyzer.executeQuery(userManager).toString();

        assertEquals(testUser1.toString(), result);
    }

    @Test
    void testExecuteQueryNoUsers() {
        WhoDidTheMostActivities activityAnalyzer = new WhoDidTheMostActivities();

        assertThrows(IllegalArgumentException.class, () -> {
            activityAnalyzer.executeQuery(null, null, null);
        });
    }

    @Test
    void testExecuteQueryBetweenDates() {
        WhoDidTheMostActivities activityAnalyzer = new WhoDidTheMostActivities();

        MakeItFitDate date1 = MakeItFitDate.of(2024, 5, 1);
        MakeItFitDate date2 = MakeItFitDate.of(2024, 5, 10);

        String result = activityAnalyzer.executeQuery(userManager, date1, date2).toString();

        assertEquals(testUser1.toString(), result);
    }
}
