package ru.otus;

import ru.otus.runner.TestRunner;
import ru.otus.tests.AfterFailureTests;
import ru.otus.tests.BeforeFailureTests;
import ru.otus.tests.SuccessfulTests;
import ru.otus.tests.TestsFailureTests;

public class App {
    public static void main(String[] args) {
        TestRunner.run(SuccessfulTests.class);
        System.out.println("_________________");
        TestRunner.run(BeforeFailureTests.class);
        System.out.println("_________________");
        TestRunner.run(TestsFailureTests.class);
        System.out.println("_________________");
        TestRunner.run(AfterFailureTests.class);
    }
}
