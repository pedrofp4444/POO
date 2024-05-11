import org.junit.jupiter.api.Test;

import MakeItFit.users.types.Occasional;
import MakeItFit.users.Gender;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Occasional class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class OccasionalTest {
    /**
     * Tests the Occasional class parameterized constructor.
     */
    @Test
    public void testParameterizedConstructor() {
        Occasional user1 = new Occasional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        assertNotNull(user1, "The Occasional object should not be null");
        assertEquals(2, user1.getFrequency(), "The frequency should be set to 2");
        assertEquals("José Fernandes", user1.getName(), "The name should match the input");
        assertEquals(45, user1.getAge(), "The age should match the input");
        assertEquals(Gender.Male, user1.getGender(), "The gender should match the input");
        assertEquals(75, user1.getWeight(), "The weight should match the input");
        assertEquals(175, user1.getHeight(), "The height should match the input");
        assertEquals(67, user1.getBpm(), "The BPM should match the input");
        assertEquals(6, user1.getLevel(), "The level should match the input");
        assertEquals("Braga", user1.getAddress(), "The address should match the input");
        assertEquals("990 000 000", user1.getPhone(), "The phone number should match the input");
        assertEquals("josefernandes@mail.com", user1.getEmail(), "The email should match the input");
    }

    /**
     * Tests the Occasional class copy constructor.
     */
    @Test
    public void testCopyConstructor() {
        Occasional user1 = new Occasional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        Occasional user2 = new Occasional(user1);
        assertNotNull(user2, "The copied Occasional object should not be null");
        assertEquals(user1.getFrequency(), user2.getFrequency(), "The frequency should be equal to the original");
        assertEquals(user1.getName(), user2.getName(), "The name should be equal to the original");
        assertEquals(user1.getAge(), user2.getAge(), "The age should be equal to the original");
        assertEquals(user1.getGender(), user2.getGender(), "The gender should be equal to the original");
        assertEquals(user1.getWeight(), user2.getWeight(), "The weight should be equal to the original");
        assertEquals(user1.getHeight(), user2.getHeight(), "The height should be equal to the original");
        assertEquals(user1.getBpm(), user2.getBpm(), "The BPM should be equal to the original");
        assertEquals(user1.getLevel(), user2.getLevel(), "The level should be equal to the original");
        assertEquals(user1.getAddress(), user2.getAddress(), "The address should be equal to the original");
        assertEquals(user1.getPhone(), user2.getPhone(), "The phone number should be equal to the original");
        assertEquals(user1.getEmail(), user2.getEmail(), "The email should be equal to the original");
    }

    /**
     * Tests the Occasional class method getFrequency.
     */
    @Test
    public void testGetFrequency() {
        Occasional user1 = new Occasional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        assertEquals(2, user1.getFrequency(), "The frequency should be 2");
    }

    /**
     * Tests the Occasional class method setFrequency.
     */
    @Test
    public void testSetFrequency() {
        Occasional user1 = new Occasional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        user1.setFrequency(4);
        assertEquals(4, user1.getFrequency(), "The frequency should be updated to 4");
    }

    /**
     * Tests the Occasional class method clone.
     */
    @Test
    public void testClone() {
        Occasional user1 = new Occasional("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 2);
        Occasional user2 = user1.clone();
        assertNotSame(user1, user2, "The clone should not reference the same object");
        assertEquals(user1.getName(), user2.getName(), "The name should match");
        assertEquals(user1.getAge(), user2.getAge(), "The age should match");
        assertEquals(user1.getGender(), user2.getGender(), "The gender should match");
        assertEquals(user1.getWeight(), user2.getWeight(), "The weight should match");
        assertEquals(user1.getHeight(), user2.getHeight(), "The height should match");
        assertEquals(user1.getBpm(), user2.getBpm(), "The BPM should match");
        assertEquals(user1.getLevel(), user2.getLevel(), "The level should match");
        assertEquals(user1.getAddress(), user2.getAddress(), "The address should match");
        assertEquals(user1.getPhone(), user2.getPhone(), "The phone number should match");
        assertEquals(user1.getEmail(), user2.getEmail(), "The email should match");
        assertEquals(user1.getFrequency(), user2.getFrequency(), "The frequency should match");
    }
}
