package org.example.io;

import org.example.model.Accessory;
import org.example.model.Packaging;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccessoriesFileReaderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testReadValidAccessories() throws Exception {
        File file = tempFolder.newFile("valid.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Packaging;Бумага;5.0;3\n");
            writer.write("Ribbon;Лента;3.5;2.5\n");
        }
        AccessoriesFileReader reader = new AccessoriesFileReader();
        List<Accessory> accessories = reader.readAccessoryFromFile(file.getAbsolutePath());

        assertEquals(2, accessories.size());
    }

    @Test
    public void testReadMixedAccessories() throws Exception {
        File file = tempFolder.newFile("mixed.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Packaging;Бумага;5.0;3\n");
            writer.write("Box;Лента;3.5;2.5\n");
            writer.write("Ribbon;Лента;3.5;-2.5\n");
        }
        AccessoriesFileReader reader = new AccessoriesFileReader();
        List<Accessory> accessories = reader.readAccessoryFromFile(file.getAbsolutePath());

        assertEquals(1, accessories.size());

        assertTrue(accessories.get(0) instanceof Packaging);
        assertEquals("Бумага", accessories.get(0).getName());
        assertEquals(5.0f, accessories.get(0).getPrice(), 0.001f);
        assertEquals(3, ((Packaging) accessories.get(0)).getSheetCount());
    }

    @Test
    public void testReadNonExistentFile() {
        AccessoriesFileReader reader = new AccessoriesFileReader();
        List<Accessory> accessories = reader.readAccessoryFromFile("path/to/nonexistent.txt");
        assertTrue(accessories.isEmpty());
    }
}