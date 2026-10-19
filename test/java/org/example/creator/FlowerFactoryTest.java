package org.example.creator;

import org.example.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowerFactoryTest {
    private final FlowerFactory factory = new FlowerFactory();

    @Test
    public void testCreateValidRose() {
        Flower flower = factory.createFlower("Rose;Роза;5.5;50.0;8;RED;STRONG;true");

        assertNotNull(flower);
        assertTrue(flower instanceof Rose);
        assertEquals("Роза", flower.getName());
        assertEquals(5.5f, flower.getPrice(), 0.001f);
        assertEquals(50.0f, flower.getStemLength(), 0.001f);
        assertEquals(8, flower.getFreshness());
        assertEquals(Color.RED, flower.getColor());
        assertEquals(Aroma.STRONG, flower.getAroma());
        assertTrue(((Rose) flower).areThornsPresent());
    }

    @Test
    public void testCreateValidLily() {
        Flower flower = factory.createFlower("Lily;Лилия;6;55.0;10;WHITE;MEDIUM;3");

        assertNotNull(flower);
        assertTrue(flower instanceof Lily);
        assertEquals("Лилия", flower.getName());
        assertEquals(6.0f, flower.getPrice(), 0.001f);
        assertEquals(55.0f, flower.getStemLength(), 0.001f);
        assertEquals(10, flower.getFreshness());
        assertEquals(Color.WHITE, flower.getColor());
        assertEquals(Aroma.MEDIUM, flower.getAroma());
        assertEquals(3, ((Lily) flower).getBudCount());
    }

    @Test
    public void testCreateValidPeony() {
        Flower flower = factory.createFlower("Peony;Пион;4;51.0;2;YELLOW;STRONG;5.8");

        assertNotNull(flower);
        assertTrue(flower instanceof Peony);
        assertEquals("Пион", flower.getName());
        assertEquals(4.0f, flower.getPrice(), 0.001f);
        assertEquals(51.0f, flower.getStemLength(), 0.001f);
        assertEquals(2, flower.getFreshness());
        assertEquals(Color.YELLOW, flower.getColor());
        assertEquals(Aroma.STRONG, flower.getAroma());
        assertEquals(5.8f, ((Peony) flower).getBudDiameter(), 0.001f);
    }

    @Test
    public void testCreateValidChamomile() {
        Flower flower = factory.createFlower("Chamomile;Ромашка;5.5;50.0;8;WHITE;NONE;8");

        assertNotNull(flower);
        assertTrue(flower instanceof Chamomile);
        assertEquals("Ромашка", flower.getName());
        assertEquals(5.5f, flower.getPrice(), 0.001f);
        assertEquals(50.0f, flower.getStemLength(), 0.001f);
        assertEquals(8, flower.getFreshness());
        assertEquals(Color.WHITE, flower.getColor());
        assertEquals(Aroma.NONE, flower.getAroma());
        assertEquals(8, ((Chamomile) flower).getPetalCount());
    }

    @Test
    public void testWrongCountOfFields() {
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;8;RED"));
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;8;RED;STRONG;true;4"));
    }

    @Test
    public void testWrongEnumValue() {
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;8;BLACK;STRONG;true"));
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;8;RED;VERY_STRONG;true"));
    }

    @Test
    public void testWrongTypeOfFlower() {
        assertNull(factory.createFlower("Lavender;Лаванда;5.5;50.0;8;BLUE;STRONG;9"));
    }

    @Test
    public void testWrongBooleanValue() {
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;8;RED;STRONG;maybe"));
    }

    @Test
    public void testNotPositivePrice() {
        assertNull(factory.createFlower("Rose;Роза;-5.5;50.0;8;RED;STRONG;true"));
        assertNull(factory.createFlower("Rose;Роза;0;50.0;8;RED;STRONG;true"));
    }

    @Test
    public void testNotPositiveStemLength() {
        assertNull(factory.createFlower("Rose;Роза;5.5;-9;8;RED;STRONG;true"));
        assertNull(factory.createFlower("Rose;Роза;5.5;0;8;RED;STRONG;true"));
    }

    @Test
    public void testFreshnessOutOfRange() {
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;90;RED;STRONG;true"));
        assertNull(factory.createFlower("Rose;Роза;5.5;50.0;0;RED;STRONG;true"));
    }


    @Test
    public void testNotPositiveBudCount() {
        assertNull(factory.createFlower("Lily;Лилия;6;55.0;10;WHITE;MEDIUM;-3"));
        assertNull(factory.createFlower("Lily;Лилия;6;55.0;10;WHITE;MEDIUM;0"));
    }

    @Test
    public void testNotPositiveBudDiameter() {
        assertNull(factory.createFlower("Peony;Пион;4;51.0;2;YELLOW;STRONG;-5.8"));
        assertNull(factory.createFlower("Peony;Пион;4;51.0;2;YELLOW;STRONG;0"));
    }

    @Test
    public void testNotPositivePetalCount() {
        assertNull(factory.createFlower("Chamomile;Ромашка;5.5;50.0;8;WHITE;NONE;-8"));
        assertNull(factory.createFlower("Chamomile;Ромашка;5.5;50.0;8;WHITE;NONE;0"));
    }
}