package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class Line2DTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorABCZero() {
        new Line2D(Rational.ZERO, Rational.ZERO, Rational.ONE);
    }

    @Test
    public void testIntersectionLines() {
        // x = 1, y = 2 -> (1, 2)
        Line2D l1 = new Line2D(Rational.ONE, Rational.ZERO, new Rational(-1));
        Line2D l2 = new Line2D(Rational.ZERO, Rational.ONE, new Rational(-2));
        assertEquals(new Point2D(new Rational(1), new Rational(2)),
                l1.intersection(l2));
    }

    @Test
    public void testIntersectionParallelLines() {
        //x = 1, x = 2/7
        Line2D l1 = new Line2D(Rational.ONE, Rational.ZERO, new Rational(-1));
        Line2D l2 = new Line2D(Rational.ONE, Rational.ZERO, new Rational(-2,7));
        assertNull(l1.intersection(l2));
    }

    @Test
    public void testIntersectionCoincidentLines() {
        // x = 1, 2x − 2 = 0 совпадают
        Line2D l1 = new Line2D(Rational.ONE, Rational.ZERO, new Rational(-1));
        Line2D l2 = new Line2D(new Rational(2), Rational.ZERO, new Rational(-2));
        assertNull(l1.intersection(l2));
    }

    @Test
    public void testIntersectionOx() {
        //x = 5/3 -> (5/3, 0)
        Line2D l = new Line2D(Rational.ONE, Rational.ZERO, new Rational(-5,3));
        assertEquals(new Point2D(new Rational(5,3), Rational.ZERO),
                l.intersectionOx());
    }
    @Test
    public void testIntersectionOxParallelReturnsNull() {
        //y = 3/7 - параллельна
        Line2D y3 = new Line2D(Rational.ZERO, Rational.ONE, new Rational(-3,7));
        assertNull(y3.intersectionOx());
    }

    @Test
    public void testIntersectionOy() {
        //y = 5/4 -> (0, 5/4)
        Line2D l = new Line2D(Rational.ZERO, Rational.ONE, new Rational(-5, 4));
        assertEquals(new Point2D(Rational.ZERO, new Rational(5, 4)),
                l.intersectionOy());
    }

    @Test
    public void testIntersectionOyParallelReturnsNull() {
        // x = 3/7 - параллельна Oy
        Line2D x3 = new Line2D(Rational.ONE, Rational.ZERO, new Rational(-3,7));
        assertNull(x3.intersectionOy());
    }

    @Test
    public void testIsParallelTrue() {
        //1/2x + 1/2y − 1/2 = 0 и 2x + 2y − 3 = 0 -> параллельны
        Line2D a = new Line2D(new Rational(1, 2), new Rational(1, 2), new Rational(-1, 2));
        Line2D b = new Line2D(new Rational(2), new Rational(2), new Rational(-3));
        assertTrue(a.isParallel(b));
    }

    @Test
    public void testIsParallelFalse() {
        //x + 2y − 1 = 0 и 2x + 2y − 3 = 0 -> не параллельны
        Line2D a = new Line2D(Rational.ONE, new Rational(2), new Rational(-1));
        Line2D b = new Line2D(new Rational(2), new Rational(2), new Rational(-3));
        assertFalse(a.isParallel(b));
    }
}