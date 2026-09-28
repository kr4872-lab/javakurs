package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {

    @Test
    void testComplexAddition() {
        Complex c1 = new Complex(1.0, 2.0); // 1 + 2i
        Complex c2 = new Complex(3.0, 4.0); // 3 + 4i

        Complex sum = c1.add(c2);


        assertEquals(4.0, sum.getRe(), 0.001);
        assertEquals(6.0, sum.getIm(), 0.001);
    }

    @Test
    void testPolynomialAddition() {
        Polynomial p1 = new Polynomial(List.of(
                new Complex(1.0, 1.0),
                new Complex(2.0, 2.0)
        ));

        Polynomial p2 = new Polynomial(List.of(
                new Complex(3.0, 3.0),
                new Complex(4.0, 4.0)
        ));

        Polynomial result = p1.add(p2);
        assertNotNull(result);
    }
}