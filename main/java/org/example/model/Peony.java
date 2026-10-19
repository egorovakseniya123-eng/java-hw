package org.example.model;

public class Peony extends Flower {
    private final float budDiameter;

    public Peony(String name, float price, float stemLength, int freshness, Color color, Aroma aroma, float budDiameter) {
        super(name, price, stemLength, freshness, color, aroma);
        this.budDiameter = budDiameter;
    }

    public float getBudDiameter() {
        return budDiameter;
    }

    @Override
    public String toString() {
        return "Peony{" + super.toString() +
                ", budDiameter=" + budDiameter +
                '}';
    }
}
