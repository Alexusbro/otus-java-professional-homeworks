package ru.otus;

import ru.otus.runner.TestRunner;

public class App {
    public static void main(String[] args) {
        TestRunner.run("ru.otus.tests.SuccessfulTests");
        System.out.println("_________________");
        TestRunner.run("ru.otus.tests.BeforeFailureTests");
        System.out.println("_________________");
        TestRunner.run("ru.otus.tests.TestsFailureTests");
        System.out.println("_________________");
        TestRunner.run("ru.otus.tests.AfterFailureTests");
    }
}
