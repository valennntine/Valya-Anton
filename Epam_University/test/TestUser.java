import com.company.DAO.DAO_User;
import com.company.exceptions.UserNotFoundException;
import com.company.model.User;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestUser {
    private final DAO_User dao_User;

    public TestUser() {
        dao_User = new DAO_User();
    }

    @AfterEach
    public void clear() {
        dao_User.deleteUser(0);
        dao_User.deleteUser(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_User.createUser(new User(0, "", "", "", ""));
        dao_User.createUser(new User(1, "", "2", "",""));
        System.err.println("Before test");
    }

    @Test
    public void testCreateUser() {
        Assertions.assertEquals(dao_User.readUser(0).getEmail(), "");
    }

    @Test
    public void testDeleteUser() {
        dao_User.deleteUser(0);
        Assertions.assertThrows(UserNotFoundException.class, () -> dao_User.readUser(0));
    }

    @Test
    public void testReadUser() {
        Assertions.assertEquals(dao_User.readUser(1).getPassword(), "2");
    }

    @Test
    public void testReaddAllUsers(){
        ArrayList<User> Users = dao_User.readAll();
        Assertions.assertEquals(Users.get(1).getPassword(),"2");
    }

    @Test
    public void testDeleteAllUsers()
    {
        dao_User.deleteAll();
        Assertions.assertThrows(UserNotFoundException.class, () -> dao_User.readUser(0));
        Assertions.assertThrows(UserNotFoundException.class, () -> dao_User.readUser(1));
    }
}
