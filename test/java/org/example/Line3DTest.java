package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class Line3DTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorZeroVector() {
        new Line3D(Point3D.ORIGIN,
                new Vector3D(Rational.ZERO, Rational.ZERO, Rational.ZERO));
    }

    @Test
    public void testIntersectionAtPoint() {
        //Ox: (t, 0, 0)
        //l: (3, −1 + s, 0) -> пересекаются в (3, 0, 0) при t = 3, s = 1
        Line3D ox = new Line3D(Point3D.ORIGIN, Vector3D.OX);
        Line3D l = new Line3D(new Point3D(new Rational(3),
                                          new Rational(-1),
                                          Rational.ZERO), Vector3D.OY);
        assertEquals(new Point3D(new Rational(3), Rational.ZERO, Rational.ZERO),
                ox.intersection(l));
    }

    @Test
    public void testIntersectionParallel() {
        Line3D l1 = new Line3D(Point3D.ORIGIN, Vector3D.OX);
        Line3D l2 = new Line3D(new Point3D(Rational.ZERO, Rational.ONE, Rational.ZERO),
                              Vector3D.OX);
        assertNull(l1.intersection(l2));
    }

    @Test
    public void testIntersectionCoincident() {
        Line3D ox1 = new Line3D(Point3D.ORIGIN, Vector3D.OX);
        Line3D ox2 = new Line3D(new Point3D(new Rational(5),
                              Rational.ZERO, Rational.ZERO),
                              new Vector3D(new Rational(2),
                                           Rational.ZERO, Rational.ZERO));
        assertNull(ox1.intersection(ox2));
    }

    @Test
    public void testIntersectionSkew() {
        // Ox: (t, 0, 0)
        // l: (0, 1/3+s, 1)
        Line3D ox = new Line3D(Point3D.ORIGIN, Vector3D.OX);
        Line3D skew = new Line3D(
                new Point3D(Rational.ZERO, new Rational(1,3), Rational.ONE),
                Vector3D.OY);
        assertNull(ox.intersection(skew));
    }

    @Test
    public void testIntersectionOx() {
        //Прямая (3/7, −1 + s, 0), пересекает в (3/7, 0, 0)
        Line3D l = new Line3D(new Point3D(new Rational(3,7),
                              new Rational(-1), Rational.ZERO), Vector3D.OY);
        assertEquals(new Point3D(new Rational(3,7), Rational.ZERO, Rational.ZERO),
                     l.intersectionOx());
    }

    @Test
    public void testIntersectionOy() {
        //Прямая (3/5 + s, −1/9, 0), пересекает в (0, -1/9, 0)
        Line3D l = new Line3D(new Point3D(new Rational(3),
                new Rational(-1,9), Rational.ZERO), Vector3D.OX);
        assertEquals(new Point3D(Rational.ZERO, new Rational(-1, 9),Rational.ZERO),
                l.intersectionOy());
    }

    @Test
    public void testIntersectionOz() {
        //Прямая (1 - s, 2 - 2s, 9/5), пересекает в (0, 0, 9/5)
        Line3D l = new Line3D(new Point3D(Rational.ONE,
                new Rational(2),
                new Rational(9,5)),
                new Vector3D(new Rational(-1), new Rational(-2), Rational.ZERO));
        assertEquals(new Point3D(Rational.ZERO,Rational.ZERO, new Rational(9,5)),
                l.intersectionOz());
    }

    @Test
    public void testIsParallelTrue() {
        Line3D a = new Line3D(Point3D.ORIGIN, Vector3D.OX);
        Line3D b = new Line3D(
                new Point3D(Rational.ZERO, Rational.ZERO, Rational.ONE),
                new Vector3D(new Rational(5), Rational.ZERO, Rational.ZERO));
        assertTrue(a.isParallel(b));
    }

    @Test
    public void testIsParallelFalse() {
        Line3D a = new Line3D(Point3D.ORIGIN, Vector3D.OX);
        Line3D b = new Line3D(Point3D.ORIGIN, Vector3D.OY);
        assertFalse(a.isParallel(b));
    }
}