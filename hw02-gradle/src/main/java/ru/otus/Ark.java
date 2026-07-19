package ru.otus;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class Ark<T> {
    private String nameArk;
    private T[] animals;

    public Ark(String nameArk, T[] animals) {
        this.nameArk = nameArk;
        this.animals = animals;
    }
    /*Написать метод, который меняет два элемента массива местами
    (массив может быть любого ссылочного типа)*/
    /*кастомный метод*/
    void changeSeatCustom(int index1, int index2) {
        T animalTemp = animals[index1];
        animals[index1] = animals[index2];
        animals[index2] = animalTemp;
    }

    /*метод с подключением библиотеки org.apache.commons:commons-lang3*/
    void changeSeatDepends(int index1, int index2) {
        ArrayUtils.swap(animals, index1, index2);
    }


    @Override
    public String toString() {
        return "in the ark "
                + nameArk
                + " floating: "
                + Arrays.toString(animals);
    }
}
