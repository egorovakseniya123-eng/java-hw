package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String username = System.getProperty("user.name");
        Notepad notepad = new Notepad(username);

        LocalDate today = LocalDate.now();
        notepad.add(today, "Яблоки, батон, куркума");
        notepad.add(today, "Привет");
        LocalDate d = LocalDate.of(2026, 11, 28);      // 7 ноября 2026
        notepad.add(d, "3456");
        notepad.add(today.plusDays(2), "Вернуть 100 рублей");

        notepad.printAll(new Notepad.Formatter() {
            @Override
            public String format(Notepad.Record r) {
                return ">> " + r.getText();
            }
        });

        notepad.printAll(new Notepad.Formatter() {
            @Override
            public String format(Notepad.Record r) {
                return "[" + notepad.getOwner() + "] " + r.getDate() + ": " + r.getText();
            }
        });
    }
}