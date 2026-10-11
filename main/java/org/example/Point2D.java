package org.example;

import java.util.Objects;

public class Point2D {
    public final Rational x, y;

    public Point2D(Rational x, Rational y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return Objects.equals(x, point2D.x) && Objects.equals(y, point2D.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
