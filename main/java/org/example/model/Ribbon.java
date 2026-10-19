package org.example.model;

public class Ribbon extends Accessory {
    private final float width;

    public Ribbon(String name, float price, float width) {
        super(name, price);
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Ribbon{" + super.toString() +
                ", width=" + width +
                '}';
    }
}
