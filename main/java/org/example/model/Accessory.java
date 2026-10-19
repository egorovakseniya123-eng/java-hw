package org.example.model;

public abstract class Accessory {
    private final String name;
    private final float price;

    public Accessory(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price;
    }
}
