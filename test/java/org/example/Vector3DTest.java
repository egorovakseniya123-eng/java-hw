package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Vector3DTest {
    @Test
    public void testUnitVectors() {
        assertEquals(new Vector3D(Rational.ONE, Rational.ZERO, Rational.ZERO),
                Vector3D.OX);
        assertEquals(new Vector3D(Rational.ZERO, Rational.ONE, Rational.ZERO),
                Vector3D.OY);
        assertEquals(new Vector3D(Rational.ZERO, Rational.ZERO, Rational.ONE),
                Vector3D.OZ);
    }

    @Test
    public void testConstructorFromPointsIsDifference() {
        // b − a = (4 − 1, 5 − 2, 6 − 3) = (3, 3, 3)
        Point3D a = new Point3D(new Rational(1), new Rational(2), new Rational(3));
        Point3D b = new Point3D(new Rational(4), new Rational(5), new Rational(6));
        assertEquals(new Vector3D(new Rational(3), new Rational(3), new Rational(3)),
                new Vector3D(a, b));
    }

    @Test
    public void testCrossOfBasisVectors() {
        // (1,0,0) x (0,1,0) = (0,0,1)
        assertEquals(Vector3D.OZ, Vector3D.OX.cross(Vector3D.OY));
        assertEquals(Vector3D.OX, Vector3D.OY.cross(Vector3D.OZ));
        assertEquals(Vector3D.OY, Vector3D.OZ.cross(Vector3D.OX));
    }

    @Test
    public void testCrossArbitraryVectors() {
        // (1, 2, 3) x (4, 5, 6) = (−3, 6, −3)
        Vector3D a = new Vector3D(new Rational(1), new Rational(2), new Rational(3));
        Vector3D b = new Vector3D(new Rational(4), new Rational(5), new Rational(6));
        assertEquals(new Vector3D(new Rational(-3), new Rational(6), new Rational(-3)),
                a.cross(b));
    }

    @Test
    public void testDot() {
        // (1, 2, 3).(4, 5, 6) = 32
        Vector3D a = new Vector3D(new Rational(1), new Rational(2), new Rational(3));
        Vector3D b = new Vector3D(new Rational(4), new Rational(5), new Rational(6));
        assertEquals(new Rational(32), a.dot(b));
    }

    @Test
    public void testIsZeroForZeroVector() {
        assertTrue(new Vector3D(Rational.ZERO, Rational.ZERO, Rational.ZERO).isZero());
    }

    @Test
    public void testIsZeroFalseForNonZero() {
        assertFalse(Vector3D.OX.isZero());
        assertFalse(new Vector3D(new Rational(1,7), Rational.ZERO, Rational.ZERO).isZero());
    }

    @Test
    public void testLengthSquareKnownValue() {
        //|(1,2,2)|^2 = 9
        Vector3D v = new Vector3D(new Rational(1), new Rational(2), new Rational(2));
        assertEquals(new Rational(9), v.lengthSquare());
    }

    @Test
    public void testMultiplyByScalar() {
        Vector3D v = new Vector3D(new Rational(1,6), new Rational(2, 8), new Rational(3));
        assertEquals(new Vector3D(new Rational(1,3), new Rational(1,2), new Rational(6)),
                v.multiply(new Rational(2)));
    }

    @Test
    public void testEqualsSame() {
        assertEquals(
                new Vector3D(new Rational(1), new Rational(2), new Rational(3)),
                new Vector3D(new Rational(1), new Rational(2), new Rational(3)));
    }

    @Test
    public void testEqualsDifferent() {
        assertNotEquals(
                new Vector3D(new Rational(1), new Rational(2), new Rational(3)),
                new Vector3D(new Rational(1), new Rational(2), new Rational(4)));
    }
}