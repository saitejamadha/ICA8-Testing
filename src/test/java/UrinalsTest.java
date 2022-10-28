import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

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
    void goodStringOne(){
        System.out.println(" ==== TEST 1 EXECUTED - Valid String ==== ");
        Assertions.assertTrue(urinals.goodString("1000101"));
    }

    @Test
    void goodStringTwo() {
        System.out.println(" ==== TEST 2 EXECUTED - Invalid String ==== ");
        Assertions.assertFalse(urinals.goodString(""));
    }

    @Test
    void goodStringThree() {
        System.out.println(" ==== TEST 3 EXECUTED - NumberFormatException ==== ");
        Assertions.assertThrows(NumberFormatException.class, () -> {
            urinals.goodString("abc");
        });
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
    void readFromFileOne() throws IOException {
        System.out.println(" ==== TEST 1 EXECUTED - Valid Case ==== ");
        String filePath = "urinal.dat";
        Assertions.assertArrayEquals(new String[]{"10001", "1001", "00000", "0000", "01000"}, urinals.readFromFile(filePath));
    }

    @Test
    void readFromFileTwo() {
        System.out.println(" ==== TEST 2 EXECUTED - File doesn't exist ==== ");
        String filePath = "urinal.dat1";
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            urinals.readFromFile(filePath);
        });
    }

    @Test
    void readFromFileThree() throws IOException {
        System.out.println(" ==== TEST 3 EXECUTED - Empty file ==== ");
        String filePath = "urinal-empty.dat";
        String[] strings = urinals.readFromFile(filePath);
        Assertions.assertArrayEquals(new String[]{}, urinals.readFromFile(filePath));
    }

    @Test
    void readFromFileFour() {
        System.out.println(" ==== TEST 4 EXECUTED - IOException ==== ");
        String filePath = "urinal";
        Assertions.assertThrows(IOException.class, () -> {
            urinals.readFromFile(filePath);
        });
    }

}
