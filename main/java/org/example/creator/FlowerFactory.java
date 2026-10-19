package org.example.creator;

import org.example.model.*;

public class FlowerFactory {
    public Flower createFlower(String line) {
        String[] characteristics = line.split(";");

        if (characteristics.length != 8) {
            return null;
        }
        try {
            String type = characteristics[0];
            String name = characteristics[1];
            float price = Float.parseFloat(characteristics[2]);
            float stemLength = Float.parseFloat(characteristics[3]);
            int freshness = Integer.parseInt(characteristics[4]);
            Color color = Color.valueOf(characteristics[5]);
            Aroma aroma = Aroma.valueOf(characteristics[6]);
            String uniqueProperty = characteristics[7];

            if (price <= 0 || stemLength <= 0 || freshness <= 0 || freshness > 10) {
                return null;
            }

            switch (type) {
                case "Rose":
                    if (!"true".equals(uniqueProperty) && !"false".equals(uniqueProperty)) {
                        return null;
                    }
                    boolean hasThorns = Boolean.parseBoolean(uniqueProperty);
                    return new Rose(name, price, stemLength, freshness, color, aroma, hasThorns);

                case "Lily":
                    int budCount = Integer.parseInt(uniqueProperty);
                    if (budCount <= 0) {
                        return null;
                    }
                    return new Lily(name, price, stemLength, freshness, color, aroma, budCount);

                case "Peony":
                    float budDiameter = Float.parseFloat(uniqueProperty);
                    if (budDiameter <= 0) {
                        return null;
                    }
                    return new Peony(name, price, stemLength, freshness, color, aroma, budDiameter);

                case "Chamomile":
                    int petalCount = Integer.parseInt(uniqueProperty);
                    if (petalCount <= 0) {
                        return null;
                    }
                    return new Chamomile(name, price, stemLength, freshness, color, aroma, petalCount);
                default:
                    return null;
            }
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
