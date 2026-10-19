package org.example.model;

public class Packaging extends Accessory {
    private final int sheetCount;

    public Packaging(String name, float price, int sheetCount) {
        super(name, price);
        this.sheetCount = sheetCount;
    }

    public int getSheetCount() {
        return sheetCount;
    }

    @Override
    public String toString() {
        return "Packaging{" + super.toString() +
                ", sheetCount=" + sheetCount +
                '}';
    }
}
