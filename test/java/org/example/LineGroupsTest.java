package org.example;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class LineGroupsTest {

    @Test
    public void testGroupParallel3DAllParallel() {
        List<Line3D> lines = List.of(
                new Line3D(Point3D.ORIGIN, Vector3D.OX),
                new Line3D(new Point3D(Rational.ZERO, Rational.ONE, Rational.ZERO),
                        Vector3D.OX),
                new Line3D(new Point3D(Rational.ZERO, Rational.ZERO, Rational.ONE),
                        new Vector3D(new Rational(5), Rational.ZERO, Rational.ZERO)));
        List<List<Line3D>> groups = LineGroups.groupParallel3D(lines);
        assertEquals(1, groups.size());
        assertEquals(3, groups.get(0).size());
    }

    @Test
    public void testGroupParallel3DTwoDirections() {

        List<Line3D> lines = List.of(
                new Line3D(Point3D.ORIGIN, Vector3D.OX),
                new Line3D(new Point3D(Rational.ZERO, Rational.ONE, Rational.ZERO),
                        Vector3D.OX),
                new Line3D(Point3D.ORIGIN, Vector3D.OY),
                new Line3D(new Point3D(Rational.ONE, Rational.ZERO, Rational.ZERO),
                        Vector3D.OY));
        List<List<Line3D>> groups = LineGroups.groupParallel3D(lines);
        assertEquals(2, groups.size());

        // По 2 прямые
        assertEquals(2, groups.get(0).size());
        assertEquals(2, groups.get(1).size());

        // Внутри группы прямые параллельны
        assertTrue(groups.get(0).get(0).isParallel(groups.get(0).get(1)));
        assertTrue(groups.get(1).get(0).isParallel(groups.get(1).get(1)));

        // Между группами не параллельны
        assertFalse(groups.get(0).get(0).isParallel(groups.get(1).get(0)));
    }

    @Test
    public void testGroupParallel3DEmptyList() {
        List<List<Line3D>> groups = LineGroups.groupParallel3D(List.of());
        assertTrue(groups.isEmpty());
    }

    @Test
    public void testGroupParallel2DAllParallel() {
        List<Line2D> lines = List.of(
                new Line2D(Rational.ONE, Rational.ZERO, new Rational(-1)),
                new Line2D(Rational.ONE, Rational.ZERO, new Rational(-2)),
                new Line2D(Rational.ONE, Rational.ZERO, new Rational(-3)));
        List<List<Line2D>> groups = LineGroups.groupParallel2D(lines);
        assertEquals(1, groups.size());
        assertEquals(3, groups.get(0).size());
    }

    @Test
    public void testGroupParallel2DTwoDirections() {
        List<Line2D> lines = List.of(
                new Line2D(Rational.ONE, Rational.ZERO, new Rational(-1)),
                new Line2D(Rational.ONE, Rational.ZERO, new Rational(-2)),
                new Line2D(Rational.ZERO, Rational.ONE, new Rational(-3)),
                new Line2D(Rational.ZERO, Rational.ONE, new Rational(-4)));
        List<List<Line2D>> groups = LineGroups.groupParallel2D(lines);
        assertEquals(2, groups.size());

        // По 2 прямые
        assertEquals(2, groups.get(0).size());
        assertEquals(2, groups.get(1).size());

        // Внутри группы прямые параллельны
        assertTrue(groups.get(0).get(0).isParallel(groups.get(0).get(1)));
        assertTrue(groups.get(1).get(0).isParallel(groups.get(1).get(1)));

        // Между группами не параллельны
        assertFalse(groups.get(0).get(0).isParallel(groups.get(1).get(0)));
    }

    @Test
    public void testGroupParallel2DEmptyList() {
        List<List<Line2D>> groups = LineGroups.groupParallel2D(List.of());
        assertTrue(groups.isEmpty());
    }
}