import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonnaieTest {

    @Test
    @DisplayName("Conversions en cents fonctionnelles")
    void conversionInt() {
    int t1= Monnaie.conversionInt(21474836.47);
    int t2= Monnaie.conversionInt(0.01);

    assertEquals(2147483647, t1);
    assertEquals(1, t2);
    }

    @Test
    @DisplayName("Reconversion de cents à dollars fonctionnelle")
    void reconversion() {
        String t1 = Monnaie.reconversion(2147483647);
        assertEquals("21474836.47", t1);
        String t2 = Monnaie.reconversion(1);
        assertEquals("0.01", t2);
    }
}