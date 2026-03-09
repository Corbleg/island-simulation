package com.javarush.island.animal;

import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import com.javarush.island.model.Plant;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Rabbit extends Animal {

    private static final double WEIGTH = 2;
    private static final double MAX_SATIETY = 1;

    public Rabbit() {
        super(WEIGTH, MAX_SATIETY);
        this.eatingProbabilities = Map.of(); // Кролики не едят других животных
    }

    @Override
    public void eat(Location location) {
        // Жив ли объект?
        if (!isAlive()) {
            return;
        }
        // Кролики питаются растениями
        if (currentSatiety < maxSatiety) {
            Plant plant = location.removePlant();
            if (plant != null) {
                currentSatiety = Math.min(maxSatiety, currentSatiety + plant.getWeight());
                log.debug("Кролик съел растение и восстановил сытость до {}", currentSatiety);
            }
        }

    }

    @Override
    public void move(Island island, int currentX, int currentY) {
        //todo Пока заглушка

    }

    @Override
    public void reproduce(Location location) {
        //todo Пока заглушка

    }
}
