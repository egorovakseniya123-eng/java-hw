//1.
//Цветочница. Определить иерархию цветов. Создать несколько
//объектов-цветов. Собрать букет (используя аксессуары) с определением его
//стоимости. Провести сортировку цветов в букете на основе уровня свежести.
//Найти цветок в букете, соответствующий заданному диапазону длин стеблей.

package org.example.app;

import org.example.io.*;
import org.example.model.*;
import org.example.service.BouquetService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Программа запущена");
        FlowersFileReader fReader = new FlowersFileReader();
        List<Flower> flowers = fReader.readFlowersFromFile("src/main/resources/flowers.txt");

        AccessoriesFileReader aReader = new AccessoriesFileReader();
        List<Accessory> accessories = aReader.readAccessoryFromFile("src/main/resources/accessories.txt");

        Bouquet bouquet = new Bouquet();
        for (Flower f : flowers) {
            bouquet.addFlower(f);
        }
        for (Accessory a : accessories) {
            bouquet.addAccessory(a);
        }

        BouquetService service = new BouquetService();

        float totalPrice = service.calculateTotalPrice(bouquet);
        logger.info("Рассчитана стоимость букета: {} (цветов: {}, аксессуаров: {})", totalPrice, bouquet.getFlowers().size(), bouquet.getAccessories().size());

        service.sortByFreshness(bouquet);
        for (Flower f : bouquet.getFlowers()){
            logger.info("{}", f);
        }

        List<Flower> found = service.findByStemLength(bouquet, 40, 55);
        for (Flower f : found) {
            logger.info("{}", f);
        }

        logger.info("Программа завершена");
    }
}