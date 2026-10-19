package org.example.comparator;

import org.example.model.Flower;

import java.util.Comparator;

public class FreshnessComparator implements Comparator<Flower> {
    @Override
    public int compare(Flower o1, Flower o2) {
        return Integer.compare(o2.getFreshness(), o1.getFreshness());
    }
}
