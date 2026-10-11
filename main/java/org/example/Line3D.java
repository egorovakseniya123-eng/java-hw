package org.example;

public class Line3D {
    public final Point3D p;
    public final Vector3D v;

    public Line3D(Point3D p, Vector3D v) {
        if (v.isZero())
            throw new IllegalArgumentException("Direction vector cannot be zero.");
        this.p = p;
        this.v = v;
    }

    public Point3D intersection(Line3D other){
        Vector3D uv = this.v.cross(other.v);
        if (uv.isZero()) return null;

        Vector3D w = new Vector3D(this.p, other.p);
        Rational mixed = w.dot(uv);
        if (!mixed.isZero()) return null;

        Rational t = w.cross(other.v).dot(uv).divide(uv.lengthSquare());
        return this.p.add(this.v.multiply(t));
    }

    public Point3D intersectionOx() {
        return this.intersection(new Line3D(Point3D.ORIGIN, Vector3D.OX));
    }

    public Point3D intersectionOy(){
        return this.intersection(new Line3D(Point3D.ORIGIN, Vector3D.OY));
    }

    public Point3D intersectionOz(){
        return this.intersection(new Line3D(Point3D.ORIGIN, Vector3D.OZ));
    }

    public boolean isParallel(Line3D other){
        Vector3D uv = this.v.cross(other.v);
        return uv.isZero();
    }

    @Override
    public String toString() {
        return "Line3D {p = " + p + ", v =" + v + "}";
    }
}