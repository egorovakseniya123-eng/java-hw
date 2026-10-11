package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class RationalTest {
    @Test
    public void testConstructorReduceFrac() {
        assertEquals(new Rational(1, 2), new Rational(2, 4));
    }

    @Test
    public void testConstructorSignFrac() {
        assertEquals(new Rational(-1, 2), new Rational(1, -2));
        assertEquals(new Rational(1, 2), new Rational(-1, -2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorZeroDenominator() {
        new Rational(1, 0);
    }

    @Test
    public void testAdd() {
        assertEquals(new Rational(5, 6),
                     new Rational(1, 2).add(new Rational(1, 3)));
    }

    @Test
    public void testSubtract() {
        assertEquals(new Rational(1, 6),
                     new Rational(1, 2).subtract(new Rational(1, 3)));
    }

    @Test
    public void testMultiply() {
        assertEquals(new Rational(1, 2),
                     new Rational(2, 3).multiply(new Rational(3, 4)));
    }

    @Test
    public void testDivide() {
        assertEquals(new Rational(2, 3),
                     new Rational(1, 2).divide(new Rational(3, 4)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        new Rational(1, 2).divide(Rational.ZERO);
    }

    @Test
    public void testIsZero() {
        assertTrue(Rational.ZERO.isZero());
        assertTrue(new Rational(0, 7).isZero());
        assertFalse(new Rational(1, 2).isZero());
    }

    @Test
    public void testEqualsSame() {
        assertEquals(new Rational(1, 2), new Rational(2, 4));
    }

    @Test
    public void testEqualsDifferent() {
        assertNotEquals(new Rational(1, 2), new Rational(1, 3));
    }
}
