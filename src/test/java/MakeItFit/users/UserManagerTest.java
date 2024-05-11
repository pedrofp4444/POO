import MakeItFit.exceptions.*;
import MakeItFit.users.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests for the UserManager class.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public class UserManagerTest {

    /**
     * Tests the constructor of the class UserManager.
     */
    @Test
    public void testConstructor() {
        UserManager userManager = new UserManager();
        assertNotNull(userManager);
    }

    /**
     * Tests the creation of a user with valid entries.
     */
    @Test
    public void testCreateUserValidInputs() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
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
    }

    /**
     * Tests the creation of a user with invalid entries.
     */
    @Test
    public void testCreateUserInvalidInputs() {
        UserManager userManager = new UserManager();
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.createUser(null, 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.createUser("José Fernandes", -1, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.createUser("José Fernandes", 45, Gender.Male, -75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.createUser("José Fernandes", 45, Gender.Male, 75, -175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, -67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, -6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        });
    }

    /**
     * Tests the insertion of a valid user.
     */
    @Test
    public void testInsertUserValid() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user);
        assertNotNull(userManager.getUserByCode(user.getCode()));
    }

    /**
     * Tests the insertion of a user with an email that already exists.
     */
    @Test
    public void testInsertUserDuplicateEmail() {
        UserManager userManager = new UserManager();
        User user1 = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user1);
        User user2 = userManager.createUser("António Silva", 25, Gender.Male, 95, 198, 72, 9, "Lisboa", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        assertThrows(ExistingEntityConflictException.class, () -> {
            userManager.insertUser(user2);
        });
    }

    /**
     * Tests the removal of a valid user.
     */
    @Test
    public void testRemoveUser() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user);
        userManager.removeUserByCode(user.getCode());
        assertThrows(EntityDoesNotExistException.class, () -> {
            userManager.getUserByCode(user.getCode());
        });
    }

    /**
     * Tests the removal of a non-existing user.
     */
    @Test
    public void testRemoveNonExistingUser() {
        UserManager userManager = new UserManager();
        UUID invalidCode = UUID.randomUUID();
        assertThrows(EntityDoesNotExistException.class, () -> {
            userManager.removeUserByCode(invalidCode);
        });
    }

    /**
     * Tests the verification of existence of a user by using his email.
     */
    @Test
    public void testExistsUserWithEmail() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user);
        assertTrue(userManager.existsUserWithEmail("josefernandes@mail.com"));
        assertFalse(userManager.existsUserWithEmail("antoniosilva@mail.com"));
    }

    /**
     * Tests the verification of existence of a user by using his code.
     */
    @Test
    public void testGetUserByCode() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user);
        assertNotNull(userManager.getUserByCode(user.getCode()));
    }

    /**
     * Tests the retrieve of a user by his email.
     */
    @Test
    public void testGetUserByEmail() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user);
        assertNotNull(userManager.getUserByEmail(user.getEmail()));
    }

    /**
     * Tests the update of an existing user.
     */
    @Test
    public void testUpdateUser() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        userManager.insertUser(user);
        user.setAge(34);
        user.setLevel(5);
        userManager.updateUser(user);
        User updatedUser = userManager.getUserByCode(user.getCode());
        assertNotNull(updatedUser);
        assertEquals(34, updatedUser.getAge());
        assertEquals(5, updatedUser.getLevel());
    }

    /**
     * Tests the update of a non-existing user.
     */
    @Test
    public void testUpdateNonExistingUser() {
        UserManager userManager = new UserManager();
        User user = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        assertThrows(EntityDoesNotExistException.class, () -> {
            userManager.updateUser(user);
        });
    }

    /**
     * Tests the retrieve of all the users.
     */
    @Test
    public void testGetAllUsers() {
        UserManager userManager = new UserManager();
        User user1 = userManager.createUser("José Fernandes", 45, Gender.Male, 75, 175, 67, 6, "Braga", "990 000 000", "josefernandes@mail.com", 7, "Professional");
        User user2 = userManager.createUser("António Silva", 25, Gender.Male, 95, 198, 72, 9, "Lisboa", "990 000 000", "antoniosilva@mail.com", 7, "Professional");
        userManager.insertUser(user1);
        userManager.insertUser(user2);
        List<User> allUsers = userManager.getAllUsers();
        assertEquals(2, allUsers.size());
        assertTrue(allUsers.contains(user1));
        assertTrue(allUsers.contains(user2));
    }

    /**
     * Tests the retrieve of all the users when the list is empty.
     */
    @Test
    public void testGetAllUsersEmpty() {
        UserManager userManager = new UserManager();
        List<User> allUsers = userManager.getAllUsers();
        assertTrue(allUsers.isEmpty());
    }
}
