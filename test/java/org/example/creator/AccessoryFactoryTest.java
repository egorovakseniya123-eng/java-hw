package org.example.creator;

import org.example.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccessoryFactoryTest {
    private final AccessoryFactory factory = new AccessoryFactory();

    @Test
    public void testCreateValidPackaging() {
        Accessory accessory = factory.createAccessory("Packaging;Бумага;2.5;8");

        assertNotNull(accessory);
        assertTrue(accessory instanceof Packaging);
        assertEquals("Бумага", accessory.getName());
        assertEquals(2.5f, accessory.getPrice(), 0.001f);
        assertEquals(8, ((Packaging) accessory).getSheetCount());
    }

    @Test
    public void testCreateValidRibbon() {
        Accessory accessory = factory.createAccessory("Ribbon;Лента;3.5;2.5");

        assertNotNull(accessory);
        assertTrue(accessory instanceof Ribbon);
        assertEquals("Лента", accessory.getName());
        assertEquals(3.5f, accessory.getPrice(), 0.001f);
        assertEquals(2.5f, ((Ribbon) accessory).getWidth(), 0.001f);
    }

    @Test
    public void testWrongCountOfFields() {
        assertNull(factory.createAccessory("Packaging;Бумага;2.5"));
        assertNull(factory.createAccessory("Packaging;Бумага;2.5;8;true"));
    }

    @Test
    public void testWrongTypeOfAccessory() {
        assertNull(factory.createAccessory("Box;Коробка;2.5;8"));
    }

    @Test
    public void testNotPositivePrice() {
        assertNull(factory.createAccessory("Packaging;Бумага;-2.5;8"));
        assertNull(factory.createAccessory("Packaging;Бумага;0;8"));
    }

    @Test
    public void testNotPositiveSheetsCount() {
        assertNull(factory.createAccessory("Packaging;Бумага;2.5;-8"));
        assertNull(factory.createAccessory("Packaging;Бумага;2.5;0"));
    }

    @Test
    public void testNotPositiveWidth() {
        assertNull(factory.createAccessory("Ribbon;Лента;3.5;-2.5"));
        assertNull(factory.createAccessory("Ribbon;Лента;3.5;0"));
    }

    @Test
    public void testWrongNumberFormat() {
        assertNull(factory.createAccessory("Packaging;Бумага;true;8"));
        assertNull(factory.createAccessory("Packaging;Бумага;2.5;YELLOW"));
        assertNull(factory.createAccessory("Ribbon;Лента;3.5;CURLED"));
    }
}