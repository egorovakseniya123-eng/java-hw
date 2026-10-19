package org.example.service;

import org.example.model.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BouquetServiceTest {
    private final BouquetService service = new BouquetService();

    // вспомогательные методы
    private Flower createFlower(String name, float price, float stemLength, int freshness) {
        return new Rose(name, price, stemLength, freshness, Color.RED, Aroma.STRONG, true);
    }

    private Accessory createAccessory(String name, float price) {
        return new Packaging(name, price, 1);
    }

    @Test
    public void testCalculateTotalPrice_emptyBouquet() {
        Bouquet bouquet = new Bouquet();
        assertEquals(0.0f, service.calculateTotalPrice(bouquet), 0.001f);
    }

    @Test
    public void testCalculateTotalPrice_flowers() {
        Bouquet bouquet = new Bouquet();
        for (int i = 5; i <= 15; i += 5) {
            bouquet.addFlower(createFlower(("Роза ценой" + i), i, 30.0f, 5));
        }
        assertEquals(30.0f, service.calculateTotalPrice(bouquet), 0.001f);
    }

    @Test
    public void testCalculateTotalPrice_accessories() {
        Bouquet bouquet = new Bouquet();
        for (int i = 1; i <= 5; i++) {
            bouquet.addAccessory(createAccessory(("Упаковка ценой" + i), i));
        }
        assertEquals(15.0f, service.calculateTotalPrice(bouquet), 0.001f);
    }

    @Test
    public void testCalculateTotalPrice_bouquet() {
        Bouquet bouquet = new Bouquet();
        for (int i = 5; i <= 15; i += 5) {
            bouquet.addFlower(createFlower(("Роза ценой" + i), i, 30.0f, 5));
        }
        for (int i = 1; i <= 5; i++) {
            bouquet.addAccessory(createAccessory(("Упаковка ценой" + i), i));
        }
        assertEquals(45.0f, service.calculateTotalPrice(bouquet), 0.001f);
    }

    @Test
    public void testSortByFreshness() {
        Bouquet bouquet = new Bouquet();
        for (int i = 2; i <= 10; i += 2) {
            bouquet.addFlower(createFlower(("Роза со свежестью" + i), 2.0f, 30.0f, i));
        }
        service.sortByFreshness(bouquet);
        int k = 0;
        for (int i = 10; i >= 2; i -= 2) {
            assertEquals(i, bouquet.getFlowers().get(k).getFreshness());
            k++;
        }
    }

    @Test
    public void testFindByStemLength_found() {
        Bouquet bouquet = new Bouquet();
        for (int i = 20; i <= 30; i += 5) {
            bouquet.addFlower(createFlower(("Роза со стеблем" + i), 2.0f, i, 6));
        }
        List<Flower> flowers = service.findByStemLength(bouquet, 25.0f, 30.0f);
        assertEquals(25.0f, flowers.get(0).getStemLength(), 0.001f);
        assertEquals(30.0f, flowers.get(1).getStemLength(), 0.001f);
    }

    @Test
    public void testFindByStemLength_notFound() {
        Bouquet bouquet = new Bouquet();
        for (int i = 20; i <= 30; i += 5) {
            bouquet.addFlower(createFlower(("Роза со стеблем" + i), 2.0f, i, 6));
        }
        List<Flower> flowers = service.findByStemLength(bouquet, 30.1f, 32.0f);
        assertTrue(flowers.isEmpty());
    }
}