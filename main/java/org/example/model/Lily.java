package org.example.model;

public class Lily extends Flower {
    private final int budCount;

    public Lily(String name, float price, float stemLength, int freshness, Color color, Aroma aroma, int budCount) {
        super(name, price, stemLength, freshness, color, aroma);
        this.budCount = budCount;
    }

    public int getBudCount() {
        return budCount;
    }

    @Override
    public String toString() {
        return "Lily{" + super.toString() +
                ", budCount=" + budCount +
                '}';
    }
}
