package org.example.model;

public class Rose extends Flower{
    private final boolean hasThorns;

    public Rose(String name, float price, float stemLength, int freshness, Color color, Aroma aroma, boolean hasThorns) {
        super(name, price, stemLength, freshness, color, aroma);
        this.hasThorns = hasThorns;
    }

    public boolean areThornsPresent() {
        return hasThorns;
    }

    @Override
    public String toString() {
        return "Rose{" + super.toString() +
                ", hasThorns=" + hasThorns +
                '}';
    }
}
