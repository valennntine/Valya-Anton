import com.company.dao.DaoUser;
import com.company.model.User;
import com.company.service.UserService;
import org.junit.jupiter.api.*;

public class TestServiceUser {
    private final DaoUser dao_User;
    private final UserService UserService;

    public TestServiceUser() {
        dao_User = new DaoUser();
        UserService = new UserService();
    }

    @AfterEach
    public void clear() {
        dao_User.deleteUser(0);
        dao_User.deleteUser(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_User.createUser(new User(0, "", ""," ", " "));
        dao_User.createUser(new User(1, "", "2", " ", " "));
        System.err.println("Before test");
    }

    @Test
    public void testReadUser() {
        Assertions.assertEquals(UserService.readUser(0).getEmail(), "");
        Assertions.assertNull(UserService.readUser(2));
        Assertions.assertNull(UserService.readUser(-1));
    }

    @Test
    public void testCreateUser() {
        UserService.createUser(new User(2, null, " ", "",""));
        Assertions.assertNull(UserService.readUser(2));
        UserService.createUser(new User(-2, " ", " ","",""));
        Assertions.assertNull(UserService.readUser(-2));
        UserService.createUser(new User(2, " ", " "," ",""));
        Assertions.assertEquals(UserService.readUser(2).getEmail(), " ");
        dao_User.deleteUser(2);
    }

    @Test
    public void testDeleteUser() {
        UserService.deleteUser(-1);
        Assertions.assertEquals(UserService.readUser(1).getEmail(),"");
        UserService.deleteUser(1);
        Assertions.assertNull(UserService.readUser(1));
        Assertions.assertEquals(UserService.readUser(0).getEmail(),"");
    }

    @Test
    public void testUpdateUser(){
        UserService.updateUser(new User(2,"2",null," "," "),1);
        Assertions.assertNull(UserService.readUser(2));
        Assertions.assertEquals(UserService.readUser(1).getEmail(),"");
        UserService.updateUser(new User(2,"2","2", " "," "),1);
        Assertions.assertEquals(UserService.readUser(2).getEmail(),"2");
        Assertions.assertNull(UserService.readUser(1));
    }


}
