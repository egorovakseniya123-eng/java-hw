package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Point3DTest {
    @Test
    public void testAddArbitrary() {
        // (1,2,3) + (4,5,6) = (5,7,9)
        Point3D p = new Point3D(new Rational(1),
                                new Rational(2),
                                new Rational(3));
        Vector3D v = new Vector3D(new Rational(4),
                     new Rational(5),
                     new Rational(6));
        assertEquals(new Point3D(new Rational(5),
                                 new Rational(7),
                                 new Rational(9)),
                     p.add(v));
    }

    @Test
    public void testAddFromOrigin() {
        Vector3D v = new Vector3D(Rational.ONE, Rational.ONE, Rational.ONE);
        assertEquals(new Point3D(new Rational(1),
                        new Rational(1),
                        new Rational(1)),
                Point3D.ORIGIN.add(v));
    }

    @Test
    public void testEqualsSame() {
        Point3D p1 = new Point3D(new Rational(1),
                new Rational(2),
                new Rational(3));
        Point3D p2 = new Point3D(new Rational(1),
                new Rational(2),
                new Rational(3));
        assertEquals(p1, p2);
    }

    @Test
    public void testEqualsDifferent() {
        Point3D p1 = new Point3D(new Rational(1),
                new Rational(2),
                new Rational(3));
        Point3D p2 = new Point3D(new Rational(1),
                new Rational(2),
                new Rational(4));
        assertNotEquals(p1, p2);
    }

    @Test
    public void testOriginIsZeroPoint() {
        assertEquals(new Point3D(Rational.ZERO, Rational.ZERO, Rational.ZERO),
                Point3D.ORIGIN);
    }
}