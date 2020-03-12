import com.company.DAO.DAO_Admin;
import com.company.model.Admin;
import com.company.service.AdminService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestServiceAdmin {
    private final DAO_Admin dao_admin;
    private final AdminService adminService;

    public TestServiceAdmin() {
        dao_admin = new DAO_Admin();
        adminService = new AdminService();
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
    public void testReadAdmin() {
        Assertions.assertEquals(adminService.readAdmin(0).getEmail(), "");
        Assertions.assertNull(adminService.readAdmin(2));
        Assertions.assertNull(adminService.readAdmin(-1));
    }

    @Test
    public void testCreateAdmin() {
        adminService.createAdmin(new Admin(2, null, " "));
        Assertions.assertNull(adminService.readAdmin(2));
        adminService.createAdmin(new Admin(-2, " ", " "));
        Assertions.assertNull(adminService.readAdmin(-2));
        adminService.createAdmin(new Admin(2, " ", " "));
        Assertions.assertEquals(adminService.readAdmin(2).getEmail(), " ");
        dao_admin.deleteAdmin(2);
    }

    @Test
    public void testDeleteAdmin() {
        adminService.deleteAdmin(-1);
        Assertions.assertEquals(adminService.readAdmin(1).getEmail(),"");
        adminService.deleteAdmin(1);
        Assertions.assertNull(adminService.readAdmin(1));
    }

    @Test
    public void testUpdateAdmin(){
        adminService.updateAdmin(new Admin(2,"2",null),1);
        Assertions.assertNull(adminService.readAdmin(2));
        Assertions.assertEquals(adminService.readAdmin(1).getEmail(),"");
        adminService.updateAdmin(new Admin(2,"2","2"),1);
        Assertions.assertEquals(adminService.readAdmin(2).getEmail(),"2");
        Assertions.assertNull(adminService.readAdmin(1));
    }


}
