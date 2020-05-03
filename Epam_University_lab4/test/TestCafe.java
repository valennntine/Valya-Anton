import com.company.dao.DaoCafe;
import com.company.exceptions.CafeNotFoundException;
import com.company.model.Cafe;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TestCafe {
    private final DaoCafe dao_Cafe;

    public TestCafe() {
        dao_Cafe = new DaoCafe();
    }

    @AfterEach
    public void clear() {
        dao_Cafe.deleteCafe(0);
        dao_Cafe.deleteCafe(1);
        System.err.println("After test");
    }

    @BeforeEach
    public void init() {
        dao_Cafe.createCafe(new Cafe(0, "", "", "", 1));
        dao_Cafe.createCafe(new Cafe(1, "", "2", "",0));
        System.err.println("Before test");
    }

    @Test
    public void testCreateCafe() {
        Assertions.assertEquals(dao_Cafe.readCafe(0).getAvgbill(), 1);
    }

    @Test
    public void testDeleteCafe() {
        dao_Cafe.deleteCafe(0);
        Assertions.assertThrows(CafeNotFoundException.class, () -> dao_Cafe.readCafe(0));
        Assertions.assertEquals(dao_Cafe.readCafe(1).getName(),"");
    }

    @Test
    public void testReadCafe() {
        Assertions.assertEquals(dao_Cafe.readCafe(1).getAvgbill(), 0);
    }

    @Test
    public void testReaddAllCafes(){
        ArrayList<Cafe> Cafes = dao_Cafe.readAll();
        Assertions.assertEquals(Cafes.get(1).getAvgbill(),0);
    }

    @Test
    public void testDeleteAllCafes()
    {
        dao_Cafe.deleteAll();
        Assertions.assertThrows(CafeNotFoundException.class, () -> dao_Cafe.readCafe(0));
        Assertions.assertThrows(CafeNotFoundException.class, () -> dao_Cafe.readCafe(1));
    }
}
