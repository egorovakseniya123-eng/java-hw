package org.example;

import java.util.Objects;

public class Rational {
    private final int numerator;
    private final int denominator;

    public static final Rational ZERO = new Rational(0);
    public static final Rational ONE  = new Rational(1);

    public Rational(int numerator, int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("You cannot divide by zero.");
        }
        if (denominator < 0) {
            numerator   = -numerator;
            denominator = -denominator;
        }
        int commonDiv = gcd(numerator, denominator);
        this.numerator = numerator / commonDiv;
        this.denominator = denominator / commonDiv;
    }

    public Rational(int numerator) {
        this(numerator, 1);
    }

    private int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public Rational add(Rational other){
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Rational(num, den);
    }

    public Rational subtract(Rational other){
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Rational(num, den);
    }

    public Rational multiply(Rational other){
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Rational(num, den);
    }

    public Rational divide(Rational other){
        if (other.numerator == 0) {
            throw new IllegalArgumentException("You cannot divide by zero.");
        }
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        return new Rational(num, den);
    }

    public boolean isZero() {
        return numerator == 0;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator && denominator == rational.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
