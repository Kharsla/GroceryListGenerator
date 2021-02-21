package finalproject.persistence;

import finalproject.entity.User;
import finalproject.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao dao;

    @BeforeEach
    void setUp() {
        dao = new UserDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAllUsers();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User user = new User("anotherTest", "blah");
        int id = dao.insert(user);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("anotherTest", insertedUser.getUserName());
        assertEquals("blah", insertedUser.getPassword());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful update of recipe
     */
    @Test
    void updateSuccess() {
        String newUserName = "did it work?";
        User userToUpdate = dao.getById(2);
        userToUpdate.setUserName(newUserName);
        dao.update(userToUpdate);
        User retrievedUser = dao.getById(2);
        assertEquals(newUserName, retrievedUser.getUserName());
    }


}