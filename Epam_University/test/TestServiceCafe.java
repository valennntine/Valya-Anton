import com.company.DAO.DAO_Cafe;
import com.company.model.Cafe;
import com.company.service.CafeService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestServiceCafe {
    private final DAO_Cafe dao_Cafe;
    private final CafeService CafeService;

    public TestServiceCafe() {
        dao_Cafe = new DAO_Cafe();
        CafeService = new CafeService();
    }

    @AfterEach
    public void clear() {
        dao_Cafe.deleteCafe(0);
        dao_Cafe.deleteCafe(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_Cafe.createCafe(new Cafe(0,"0", "0", "0", 0));
        dao_Cafe.createCafe(new Cafe(1, "1", "1", "1", 1));
        System.err.println("Before test");
    }

    @Test
    public void testReadCafe() {
        Assertions.assertEquals(CafeService.readCafe(0).getName(), "0");
        Assertions.assertNull(CafeService.readCafe(2));
        Assertions.assertNull(CafeService.readCafe(-1));
    }

    @Test
    public void testCreateCafe() {
        CafeService.createCafe(new Cafe(2, null, " ","1", 1));
        Assertions.assertNull(CafeService.readCafe(2));
        CafeService.createCafe(new Cafe(-2, " ", " ","1", 1));
        Assertions.assertNull(CafeService.readCafe(-2));
        CafeService.createCafe(new Cafe(2, " ", " ","1", 1));
        Assertions.assertEquals(CafeService.readCafe(2).getName(), " ");
        dao_Cafe.deleteCafe(2);
    }

    @Test
    public void testDeleteCafe() {
        CafeService.deleteCafe(-1);
        Assertions.assertEquals(CafeService.readCafe(1).getName(), "1");
        CafeService.deleteCafe(1);
        Assertions.assertNull(CafeService.readCafe(1));
    }

    @Test
    public void testUpdateCafe() {
        CafeService.updateCafe(new Cafe(2, "2", null,"2", 2), 1);
        Assertions.assertNull(CafeService.readCafe(2));
        Assertions.assertEquals(CafeService.readCafe(1).getName(), "1");
        CafeService.updateCafe(new Cafe(2, "2", "2","2",2), 1);
        Assertions.assertEquals(CafeService.readCafe(2).getName(), "2");
        Assertions.assertNull(CafeService.readCafe(1));
    }


}
