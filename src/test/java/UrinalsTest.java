import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UrinalsTest {

    private Urinals urinals;

    @BeforeEach
    public void setUp() {
        urinals = new Urinals();
    }

    @Test
    void testJunit() {
        Assertions.assertEquals("Sai Teja Madha", "Sai Teja Madha");
    }

    @Test
    void testCountUrinals1() {
        System.out.println(" ==== TEST 1 EXECUTED ==== ");
        Assertions.assertEquals(-1, urinals.countUrinals("10011"));
    }

    @Test
    void testCountUrinals2() {
        System.out.println(" ==== TEST 2 EXECUTED ==== ");
        Assertions.assertEquals(1, urinals.countUrinals("10001"));
    }

    @Test
    void testCountUrinals3() {
        System.out.println(" ==== TEST 3 EXECUTED ==== ");
        Assertions.assertEquals(0, urinals.countUrinals("1001"));
    }

    @Test
    void testCountUrinals4() {
        System.out.println(" ==== TEST 4 EXECUTED ==== ");
        Assertions.assertEquals(3, urinals.countUrinals("00000"));
    }

    @Test
    void testCountUrinals5() {
        System.out.println(" ==== TEST 5 EXECUTED ==== ");
        Assertions.assertEquals(2, urinals.countUrinals("0000"));
    }

    @Test
    void testCountUrinals6() {
        System.out.println(" ==== TEST 6 EXECUTED ==== ");
        Assertions.assertEquals(1, urinals.countUrinals("01000"));
    }

    @Test
    void testIsValidString1(){
        Assertions.assertEquals(true, urinals.isValidString("1000101"));
    }

    @Test
    void testIsValidString2() {
        Assertions.assertEquals(false, urinals.isValidString("ABC"));
    }

}
