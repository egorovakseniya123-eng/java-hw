//1. Создать класс Notepad с внутренним классом или классами, с
// помощью объектов которого могут храниться несколько записей на одну дату
package org.example;
import java.time.LocalDate;
import java.util.*;

public class Notepad {
    public class Record {
        private final String text;
        private final LocalDate date;

        public Record(LocalDate date, String text) {
            this.date = date;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public LocalDate getDate() {
            return date;
        }

        @Override
        public String toString() {
            return "[" + owner + "] " + date + ": " + text;
        }
    }

    private final String owner;
    private final Map<LocalDate, List<Record>> notes = new HashMap<>();

    public Notepad(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public Record add(LocalDate date, String text) {
        Record rec = new Record(date, text);
        notes.computeIfAbsent(date, d -> new ArrayList<>()).add(rec);
        return rec;
    }

    public List<Record> getByDate(LocalDate date) {
        return notes.getOrDefault(date, Collections.emptyList());
    }

    public interface Formatter {
        String format(Record r);
    }

    public void printAll(Formatter f) {
        for (List<Record> list : notes.values()) {
            for (Record r : list) {
                String line = f.format(r);
                System.out.println(line);
            }
        }
    }
}