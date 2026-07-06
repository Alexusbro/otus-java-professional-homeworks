package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Second");
        stringList.add("Third");
        System.out.println(stringList);
        HelloOtus helloOtus = new HelloOtus();
        List<String> result = helloOtus.copyToImmutableReverse(stringList);
        System.out.println(result);
    }
}
