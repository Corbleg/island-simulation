package com.javarush.island.model;

import lombok.Getter;

/**
 * Класс Остров - содержит двумерный массив локаций
 * Индексы массива представляют координаты локации на острове (x, y).
 * Метод getSize() - возвращает размер острова (количество локаций по каждой оси).
 * Метод getLocation(int x, int y) - возвращает локацию по заданным координатам. Если координаты выходят за пределы массива, метод должен выбрасывать исключение.
 * Метод getAdjacentLocations(int x, int y) - возвращает список локаций, которые находятся рядом с заданными координатами (включая диагональные). Если координаты выходят за пределы массива, метод должен выбрасывать исключение.
 * Метод moveAnimal(Animal animal, int fromX, int fromY, int toX, int toY) - перемещает животное из одной локации в другую. Метод должен проверять, что обе локации существуют и что животное находится в исходной локации. Если проверки не проходят, метод должен выбрасывать исключение.
 */

public class Island {
    @Getter
    private final int width;
    @Getter
    private final int height;
    private final Location[][] locations;

    public Island(int height, int width) {
        this.height = height;
        this.width = width;
        this.locations = new Location[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public Location getLocation(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Координаты выходят за пределы острова");
        }
        return locations[y][x];
    }
}
