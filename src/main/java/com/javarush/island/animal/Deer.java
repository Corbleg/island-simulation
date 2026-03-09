package com.javarush.island.animal;

import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import com.javarush.island.model.Plant;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Класс Олень - наследник класса Животное
 * - это травоядное животное, которое питается растениями. Олени не едят других животных, поэтому их карта вероятности поедания других животных будет пустой. Кролики могут перемещаться по острову и размножаться, но эти методы пока оставлены как заглушки для дальнейшей реализации.
 */
@Slf4j
public class Deer extends Animal {

    private static final double WEIGHT = 300;
    private static final double MAX_SATIETY = 50;

    public Deer() {
        super(WEIGHT, MAX_SATIETY);
        this.eatingProbabilities = Map.of(); // Кролики не едят других животных
    }

    @Override
    public void eat(Location location) {
        // Жив ли объект?
        if (!isAlive()) {
            return;
        }
        // Олени питаются растениями
        if (currentSatiety < maxSatiety) {
            Plant plant = location.removePlant();
            if (plant != null) {
                currentSatiety = Math.min(maxSatiety, currentSatiety + plant.getWeight());
                log.debug("Олень съел растение и восстановил сытость до {}", currentSatiety);
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
