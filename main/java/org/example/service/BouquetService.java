package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.comparator.FreshnessComparator;
import org.example.model.Accessory;
import org.example.model.Bouquet;
import org.example.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class BouquetService {
    private static final Logger logger = LogManager.getLogger(BouquetService.class);

    public float calculateTotalPrice(Bouquet bouquet) {
        float total = 0;

        for (Flower f : bouquet.getFlowers()) {
            total += f.getPrice();
        }

        for (Accessory a : bouquet.getAccessories()) {
            total += a.getPrice();
        }

        return total;
    }

    public void sortByFreshness(Bouquet bouquet) {
        logger.info("Цветы отсортированы по свежести");
        bouquet.getFlowers().sort(new FreshnessComparator());
    }

    public List<Flower> findByStemLength(Bouquet bouquet, float minLen, float maxLen) {
        List<Flower> res = new ArrayList<>();

        for (Flower f : bouquet.getFlowers()) {
            float l = f.getStemLength();
            if (l >= minLen && l <= maxLen) {
                res.add(f);
            }
        }
        logger.info("Поиск по длине стебля [{}; {}] см: найдено {} цветов", minLen, maxLen, res.size());
        return res;
    }
}
