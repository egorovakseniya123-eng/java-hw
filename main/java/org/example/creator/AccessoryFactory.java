package org.example.creator;

import org.example.model.*;

public class AccessoryFactory {
    public Accessory createAccessory(String line) {
        String[] characteristics = line.split(";");

        if (characteristics.length != 4) {
            return null;
        }
        try {
            String type = characteristics[0];
            String name = characteristics[1];
            float price = Float.parseFloat(characteristics[2]);
            String uniqueProperty = characteristics[3];

            if (price <= 0) {
                return null;
            }

            switch (type) {
                case "Ribbon":
                    float width = Float.parseFloat(uniqueProperty);
                    if (width <= 0) {
                        return null;
                    }
                    return new Ribbon(name, price, width);

                case "Packaging":
                    int sheetCount = Integer.parseInt(uniqueProperty);
                    if (sheetCount <= 0) {
                        return null;
                    }
                    return new Packaging(name, price, sheetCount);
                default:
                    return null;
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
