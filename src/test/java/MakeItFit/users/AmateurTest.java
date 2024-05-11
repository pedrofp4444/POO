import org.junit.jupiter.api.Test;

import MakeItFit.users.types.Amateur;
import MakeItFit.users.Gender;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Amateur class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class AmateurTest {

    /**
     * Tests the Amateur class parameterized constructor.
     */
    @Test
    public void testParameterizedConstructors() {
        Amateur user1 = new Amateur("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com");
        assertNotNull(user1);
        assertEquals("José Fernandes", user1.getName());
        assertEquals(45, user1.getAge());
        assertEquals(Gender.Male, user1.getGender());
        assertEquals(75, user1.getWeight());
        assertEquals(175, user1.getHeight());
        assertEquals(67, user1.getBpm());
        assertEquals(6, user1.getLevel());
        assertEquals("Braga", user1.getAddress());
        assertEquals("990 000 000", user1.getPhone());
        assertEquals("josefernandes@mail.com", user1.getEmail());
    }

    /**
     * Tests the Amateur class copy constructor.
     */
    @Test
    public void testCopyConstructors() {
        Amateur user1 = new Amateur("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com");
        Amateur user2 = new Amateur(user1);
        assertNotNull(user2);
        assertEquals(user1.getName(), user2.getName());
        assertEquals(user1.getAge(), user2.getAge());
        assertEquals(user1.getGender(), user2.getGender());
        assertEquals(user1.getWeight(), user2.getWeight());
        assertEquals(user1.getHeight(), user2.getHeight());
        assertEquals(user1.getBpm(), user2.getBpm());
        assertEquals(user1.getLevel(), user2.getLevel());
        assertEquals(user1.getAddress(), user2.getAddress());
        assertEquals(user1.getPhone(), user2.getPhone());
        assertEquals(user1.getEmail(), user2.getEmail());
    }

    /**
     * Tests the Amateur class method clone.
     */
    @Test
    public void testClone() {
        Amateur user1 = new Amateur("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com");
        Amateur user2 = user1.clone();

        assertNotSame(user1, user2);
        assertEquals(user1.getName(), user2.getName());
        assertEquals(user1.getAge(), user2.getAge());
        assertEquals(user1.getGender(), user2.getGender());
        assertEquals(user1.getWeight(), user2.getWeight());
        assertEquals(user1.getHeight(), user2.getHeight());
        assertEquals(user1.getBpm(), user2.getBpm());
        assertEquals(user1.getLevel(), user2.getLevel());
        assertEquals(user1.getAddress(), user2.getAddress());
        assertEquals(user1.getPhone(), user2.getPhone());
        assertEquals(user1.getEmail(), user2.getEmail());
    }
}
