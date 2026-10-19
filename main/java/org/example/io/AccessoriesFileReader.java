package org.example.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.creator.AccessoryFactory;
import org.example.model.Accessory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccessoriesFileReader {
    private final AccessoryFactory factory = new AccessoryFactory();
    private static final Logger logger = LogManager.getLogger(AccessoriesFileReader.class);
    public List<Accessory> readAccessoryFromFile(String path) {
        List<Accessory> accessories = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            logger.info("Чтение файла {}", path);
            String line;
            while ((line = reader.readLine()) != null) {
                Accessory accessory = factory.createAccessory(line);
                if (accessory != null) {
                    accessories.add(accessory);
                } else {
                    logger.warn("Пропущена строка {}", line);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка чтения файла {}", path, e);
            return accessories;
        }
        return accessories;
    }
}
