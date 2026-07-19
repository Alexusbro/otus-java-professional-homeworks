package ru.otus;

import ru.otus.animal.Animal;
import ru.otus.animal.Dog;
import ru.otus.animal.Monkey;
import ru.otus.animal.Tiger;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Animal[] animals = {
                new Dog("Bob"),
                new Monkey("Anfisa"),
                new Tiger("Sherhan")
        };

        var animalArk = new Ark<Animal>("animals", animals);
        System.out.println(animalArk);

        animalArk.changeSeatCustom(0, 2);
        System.out.println(animalArk);

        animalArk.changeSeatDepends(1, 2);
        System.out.println(animalArk);

        var animalList = arrToList(animals);
        System.out.println(animalList);

        String[] words = {"apple", "orange", "tomato", "bread", "butter", "milk", "meat", "candy", "honey", "tomato", "orange", "milk", "milk", "tomato"};

        System.out.println(dublicateCounter(words));
        uniqueWords(words);

    }

    /*метод, который преобразует массив в ArrayList*/
    public static <T> List<T> arrToList(T[] arr) {
        if (arr == null) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<>(arr.length);
        for (T elem : arr) {
            list.add(elem);
        }
        return list;
    }

    /* список уникальных слов, из которых состоит массив*/
    public static void uniqueWords(String[] words) {
        if (words == null) {
            System.out.println("empty");
            return;
        }
        Set<String> unique = new HashSet<>(Arrays.asList(words));
        System.out.println(unique);
    }

    /*Посчитать, сколько раз встречается каждое слово*/
    public static Map<String, Integer> dublicateCounter(String[] words) {
        Map<String, Integer> dublCount = new HashMap<>();
        if (words == null) {
            return dublCount;
        }
        for (String el : words) {
            if (dublCount.containsKey(el)) {
                dublCount.put(el, dublCount.get(el) + 1);
            } else dublCount.put(el, 1);
        }
        return dublCount;
    }
}