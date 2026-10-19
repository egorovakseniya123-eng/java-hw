package org.example.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.creator.FlowerFactory;
import org.example.model.Flower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlowersFileReader {
    private final FlowerFactory factory = new FlowerFactory();
    private static final Logger logger = LogManager.getLogger(FlowersFileReader.class);

    public List<Flower> readFlowersFromFile(String path) {
        List<Flower> flowers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            logger.info("Чтение файла {}", path);
            String line;
            while ((line = reader.readLine()) != null) {
                Flower flower = factory.createFlower(line);
                if (flower != null) {
                    flowers.add(flower);
                } else {
                    logger.warn("Пропущена строка {}", line);
                }
            }
        } catch (IOException e) {
            logger.error("Ошибка чтения файла {}", path, e);
            return flowers;
        }
        return flowers;
    }
}
