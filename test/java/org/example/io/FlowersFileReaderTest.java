package org.example.io;

import org.example.model.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static org.junit.Assert.*;

public class FlowersFileReaderTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testReadValidFlowers() throws Exception {
        File file = tempFolder.newFile("valid.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Rose;Роза;5.5;50.0;8;RED;STRONG;true\n");
            writer.write("Lily;Лилия;6.0;55.0;10;WHITE;MEDIUM;3\n");
        }
        FlowersFileReader reader = new FlowersFileReader();
        List<Flower> flowers = reader.readFlowersFromFile(file.getAbsolutePath());

        assertEquals(2, flowers.size());
    }

    @Test
    public void testReadMixedFlowers() throws Exception {
        File file = tempFolder.newFile("mixed.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Lavender;Роза;5.5;50.0;8;RED;STRONG;true\n");
            writer.write("Lily;Лилия;6.0;55.0;10;WHITE;MEDIUM;3\n");
            writer.write("Peony;Пион;6.0;55.0;-10;WHITE;MEDIUM;3\n");
        }
        FlowersFileReader reader = new FlowersFileReader();
        List<Flower> flowers = reader.readFlowersFromFile(file.getAbsolutePath());

        assertEquals(1, flowers.size());

        assertTrue(flowers.get(0) instanceof Lily);
        assertEquals("Лилия", flowers.get(0).getName());
        assertEquals(6.0f, flowers.get(0).getPrice(), 0.001f);
        assertEquals(55.0f, flowers.get(0).getStemLength(), 0.001f);
        assertEquals(10, flowers.get(0).getFreshness());
        assertEquals(Color.WHITE, flowers.get(0).getColor());
        assertEquals(Aroma.MEDIUM, flowers.get(0).getAroma());
        assertEquals(3, ((Lily) flowers.get(0)).getBudCount());
    }

    @Test
    public void testReadNonExistentFile() {
        FlowersFileReader reader = new FlowersFileReader();
        List<Flower> flowers = reader.readFlowersFromFile("path/to/nonexistent.txt");
        assertTrue(flowers.isEmpty());
    }
}