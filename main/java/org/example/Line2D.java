package org.example;

public class Line2D {
    private final Rational A, B, C;

    public Line2D(Rational A, Rational B, Rational C){
        if (A.isZero() && B.isZero()) {
            throw new IllegalArgumentException("A and B cannot both be zero at the same time.");
        }
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Point2D intersection(Line2D other){
        Rational det = this.A.multiply(other.B).subtract(other.A.multiply(this.B));
        if (det.isZero()) return null;
        // формула Крамера x_i = Δ_i/Δ
        Rational x = this.B.multiply(other.C).subtract(other.B.multiply(this.C)).divide(det);
        Rational y = other.A.multiply(this.C).subtract(this.A.multiply(other.C)).divide(det);
        return new Point2D(x, y);
    }

    public Point2D intersectionOx(){
        if (A.isZero()) return null;
        Rational x = C.multiply(new Rational(-1, 1)).divide(A);
        return new Point2D(x, new Rational(0,1));
    }

    public Point2D intersectionOy(){
        if (B.isZero()) return null;
        Rational y = C.multiply(new Rational(-1, 1)).divide(B);
        return new Point2D(new Rational(0,1),y);
    }

    public boolean isParallel(Line2D other){
        Rational det = this.A.multiply(other.B).subtract((other.A.multiply(this.B)));
        return det.isZero();
    }
    @Override
    public String toString() {
        return "Line2D {" + A + "x + " + B + "y +" + C + " = 0}";
    }
}
