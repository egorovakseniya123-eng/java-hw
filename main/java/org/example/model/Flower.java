package org.example.model;

public abstract class Flower {
    private static int counter = 0;
    private final int id;
    private final String name;
    private final float price;
    private final float stemLength;
    private final int freshness;
    private final Color color;
    private final Aroma aroma;

    public Flower(String name, float price, float stemLength, int freshness, Color color, Aroma aroma) {
        this.id = ++counter;
        this.name = name;
        this.price = price;
        this.stemLength = stemLength;
        this.freshness = freshness;
        this.color = color;
        this.aroma = aroma;
    }

    public int getId() {
        return id;
    }

    public Aroma getAroma() {
        return aroma;
    }

    public Color getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public float getStemLength() {
        return stemLength;
    }

    public int getFreshness() {
        return freshness;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stemLength=" + stemLength +
                ", freshness=" + freshness +
                ", color=" + color +
                ", aroma=" + aroma;
    }
}
