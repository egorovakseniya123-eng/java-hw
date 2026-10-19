package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private final List<Flower> flowers;
    private final List<Accessory> accessories;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }
}
