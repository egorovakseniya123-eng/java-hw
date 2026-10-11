package org.example;

import java.util.Objects;

public class Point3D {
    public final Rational x, y, z;

    public static final Point3D ORIGIN = new Point3D(Rational.ZERO, Rational.ZERO, Rational.ZERO);

    public Point3D(Rational x, Rational y, Rational z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D add(Vector3D v) {
        return new Point3D(x.add(v.x), y.add(v.y), z.add(v.z));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Objects.equals(x, point3D.x) && Objects.equals(y, point3D.y) && Objects.equals(z, point3D.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
