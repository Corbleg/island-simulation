package com.javarush.island.model;

import com.javarush.island.animal.Animal;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * Класс Локация - содержит списки животных и растений
 * Метод RemovePlant() - удаляет растение из списка и возвращает его, если список не пустой. Если список растений пуст, метод возвращает null.
 * */



public class Location {
    @lombok.Getter
    private final List<Animal> animals = new ArrayList<>();

    @Getter
    private final List<Plant> plants = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }


    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    public Plant removePlant() {
        if (!plants.isEmpty()) {
            return plants.remove(plants.size() - 1);
        }
        return null;
    }


}
