import com.company.dao.DaoAdmin;
import com.company.exceptions.AdminNotFoundException;
import com.company.model.Admin;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestAdmin {
    private final DaoAdmin dao_admin;

    public TestAdmin() {
        dao_admin = new DaoAdmin();
    }

    @AfterEach
    public void clear() {
        dao_admin.deleteAdmin(0);
        dao_admin.deleteAdmin(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_admin.createAdmin(new Admin(0, "", ""));
        dao_admin.createAdmin(new Admin(1, "", "2"));
        System.err.println("Before test");
    }

    @Test
    public void testCreateAdmin() {
        Assertions.assertEquals(dao_admin.readAdmin(0).getEmail(), "");
    }

    @Test
    public void testDeleteAdmin() {
        dao_admin.deleteAdmin(0);
        Assertions.assertThrows(AdminNotFoundException.class, () -> dao_admin.readAdmin(0));
        Assertions.assertEquals(dao_admin.readAdmin(1).getPassword(),"2");
    }

    @Test
    public void testReadAdmin() {
        Assertions.assertEquals(dao_admin.readAdmin(1).getPassword(), "2");
    }

    @Test
    public void testReaddAllAdmins(){
        ArrayList<Admin> admins = dao_admin.readAll();
        Assertions.assertEquals(admins.get(1).getPassword(),"2");
    }

    @Test
    public void testDeleteAllAdmins()
    {
        dao_admin.deleteAll();
        Assertions.assertThrows(AdminNotFoundException.class, () -> dao_admin.readAdmin(0));
        Assertions.assertThrows(AdminNotFoundException.class, () -> dao_admin.readAdmin(1));
    }
}
