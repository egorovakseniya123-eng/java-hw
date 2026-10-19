package org.example.model;

public class Chamomile extends Flower {
    private final int petalCount;

    public Chamomile(String name, float price, float stemLength, int freshness, Color color, Aroma aroma, int petalCount) {
        super(name, price, stemLength, freshness, color, aroma);
        this.petalCount = petalCount;
    }

    public int getPetalCount() {
        return petalCount;
    }

    @Override
    public String toString() {
        return "Chamomile{" + super.toString() +
                ", petalCount=" + petalCount + '}';
    }
}
