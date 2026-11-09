package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotepadTest {

    private Notepad notepad;
    private final LocalDate today = LocalDate.now();

    @BeforeEach // чистый блокнот
    void setUp() {
        notepad = new Notepad("Ксения");
    }

    @Test
    void add() {
        Notepad.Record rec = notepad.add(today, "Запись 1");

        assertNotNull(rec);
        assertEquals("Запись 1", rec.getText());
        assertEquals(today, rec.getDate());

        assertTrue(rec.toString().contains("Ксения"));

        notepad.add(today, "Запись 2");
        notepad.add(today, "Запись 3");
        assertEquals(3, notepad.getByDate(today).size());
    }

    @Test
    void getByDate() {
        notepad.add(today, "Запись 1");
        notepad.add(today, "Запись 2");

        List<Notepad.Record> list = notepad.getByDate(today);
        assertEquals(2, list.size());
        assertEquals("Запись 1", list.get(0).getText());

        List<Notepad.Record> emptyList = notepad.getByDate(today.plusDays(1));
        assertNotNull(emptyList);
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void printAll() {
        notepad.add(today, "Запись 1");
        notepad.add(today, "Запись 2");

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // подмена консоли

        try {
            notepad.printAll(new Notepad.Formatter() {
                @Override
                public String format(Notepad.Record r) {
                    return ">> " + r.getText();
                }
            });
        } finally {
            System.setOut(originalOut);
        }

        String output = outContent.toString();

        assertTrue(output.contains(">> Запись 1"));
        assertTrue(output.contains(">> Запись 2"));
    }
}