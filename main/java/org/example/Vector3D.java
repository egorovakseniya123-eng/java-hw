package org.example;

import java.util.Objects;

public class Vector3D {
    public final Rational x, y, z;

    public static final Vector3D OX = new Vector3D(Rational.ONE, Rational.ZERO, Rational.ZERO);
    public static final Vector3D OY = new Vector3D(Rational.ZERO, Rational.ONE, Rational.ZERO);
    public static final Vector3D OZ = new Vector3D(Rational.ZERO, Rational.ZERO, Rational.ONE);

    public Vector3D(Rational x, Rational y, Rational z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Point3D a, Point3D b) {
        this.x = b.x.subtract(a.x);
        this.y = b.y.subtract(a.y);
        this.z = b.z.subtract(a.z);
    }

    public Vector3D cross(Vector3D v) {
        return new Vector3D(
                y.multiply(v.z).subtract(z.multiply(v.y)),
                z.multiply(v.x).subtract(x.multiply(v.z)),
                x.multiply(v.y).subtract(y.multiply(v.x)));
    }

    public Rational dot(Vector3D v) {
        return x.multiply(v.x)
                .add(y.multiply(v.y))
                .add(z.multiply(v.z));
    }

    public boolean isZero() {
        return x.isZero() && y.isZero() && z.isZero();
    }

    public Rational lengthSquare() {
        return x.multiply(x).add(y.multiply(y)).add(z.multiply(z));
    }

    public Vector3D multiply(Rational n) {
        return new Vector3D(x.multiply(n), y.multiply(n), z.multiply(n));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Objects.equals(x, vector3D.x) && Objects.equals(y, vector3D.y) && Objects.equals(z, vector3D.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}