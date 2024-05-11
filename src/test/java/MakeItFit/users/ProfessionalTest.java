import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import MakeItFit.users.types.Professional;
import MakeItFit.users.Gender;

/**
 * The tests for the Professional class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class ProfessionalTest {

    /**
     * Tests the constructor of the Professional class and object creation.
     */
    @Test
    public void testConstructor() {
        Professional user = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        assertNotNull(user);
        assertEquals("José Fernandes", user.getName());
        assertEquals(45, user.getAge());
        assertEquals(Gender.Male, user.getGender());
        assertEquals(75, user.getWeight());
        assertEquals(175, user.getHeight());
        assertEquals(67, user.getBpm());
        assertEquals(6, user.getLevel());
        assertEquals("Braga", user.getAddress());
        assertEquals("990 000 000", user.getPhone());
        assertEquals("josefernandes@mail.com", user.getEmail());
        assertEquals("No specialization", user.getSpecialization());
        assertEquals(2, user.getFrequency());
    }

    /**
     * Tests the copy constructor of the Professional class.
     */
    @Test
    public void testCopyConstructor() {
        Professional user1 = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        Professional user2 = new Professional(user1);
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
        assertEquals(user1.getSpecialization(), user2.getSpecialization());
        assertEquals(user1.getFrequency(), user2.getFrequency());
    }

    /**
     * Tests the getSpecialization method.
     */
    @Test
    public void testGetSpecialization() {
        Professional user = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        String specialization = user.getSpecialization();
        assertEquals("No specialization", specialization);
    }

    /**
     * Tests the setSpecialization method.
     */
    @Test
    public void testSetSpecialization() {
        Professional user = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        user.setSpecialization("Running");
        assertEquals("Running", user.getSpecialization());
    }

    /**
     * Tests the getFrequency method.
     */
    @Test
    public void testGetFrequency() {
        Professional user = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        int frequency = user.getFrequency();
        assertEquals(2, frequency);
    }

    /**
     * Tests the setFrequency method.
     */
    @Test
    public void testSetFrequency() {
        Professional user = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        user.setFrequency(4);
        assertEquals(4, user.getFrequency());
    }

    /**
     * Tests the clone method.
     */
    @Test
    public void testClone() {
        Professional user = new Professional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        Professional clone = user.clone();

        assertNotNull(clone);
        assertNotSame(user, clone);
        assertEquals(user.getName(), clone.getName());
        assertEquals(user.getAge(), clone.getAge());
        assertEquals(user.getGender(), clone.getGender());
        assertEquals(user.getWeight(), clone.getWeight());
        assertEquals(user.getHeight(), clone.getHeight());
        assertEquals(user.getBpm(), clone.getBpm());
        assertEquals(user.getLevel(), clone.getLevel());
        assertEquals(user.getAddress(), clone.getAddress());
        assertEquals(user.getPhone(), clone.getPhone());
        assertEquals(user.getEmail(), clone.getEmail());
        assertEquals(user.getSpecialization(), clone.getSpecialization());
        assertEquals(user.getFrequency(), clone.getFrequency());
    }
}
