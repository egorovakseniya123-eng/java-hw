package org.example.comparator;

import org.example.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FreshnessComparatorTest {
    // вспомогательный метод
    private Flower createFlowerWithFreshness(int freshness) {
        return new Rose("Test Rose", 5.5f, 50.0f, freshness, Color.RED, Aroma.STRONG, true);
    }

    @Test
    public void testCompareFirstGoesBeforeSecond() {
        Flower o1 = createFlowerWithFreshness(7);
        Flower o2 = createFlowerWithFreshness(5);
        FreshnessComparator comparator = new FreshnessComparator();
        assertTrue(comparator.compare(o1, o2) < 0);
    }

    @Test
    public void testCompareFirstGoesAfterSecond() {
        Flower o1 = createFlowerWithFreshness(5);
        Flower o2 = createFlowerWithFreshness(7);
        FreshnessComparator comparator = new FreshnessComparator();
        assertTrue(comparator.compare(o1, o2) > 0);
    }

    @Test
    public void testCompareFirstEqualsSecond() {
        Flower o1 = createFlowerWithFreshness(5);
        Flower o2 = createFlowerWithFreshness(5);
        FreshnessComparator comparator = new FreshnessComparator();
        assertEquals(0, comparator.compare(o1, o2));
    }

    @Test
    public void testSortByFreshness() {
        List<Flower> flowers = new ArrayList<>();
        for (int i = 2; i <= 10; i += 2) {
            flowers.add(createFlowerWithFreshness(i));
        }
        flowers.sort(new FreshnessComparator());

        int k = 0;
        for (int i = 10; i >= 2; i -= 2) {
            assertEquals(i, flowers.get(k).getFreshness());
            k++;
        }
    }
}