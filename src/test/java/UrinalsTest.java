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
    void testCountUrinals() {
        Assertions.assertEquals(-1, urinals.countUrinals("10011"));
        Assertions.assertEquals(1, urinals.countUrinals("10001"));
        Assertions.assertEquals(0, urinals.countUrinals("1001"));
        Assertions.assertEquals(3, urinals.countUrinals("00000"));
        Assertions.assertEquals(2, urinals.countUrinals("0000"));
        Assertions.assertEquals(1, urinals.countUrinals("01000"));
    }

}
