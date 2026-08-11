package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class BeforeFailureTests {

    @Before
    public void beforeTestFailed() {
        throw new RuntimeException("Before test failed");
    }

    @Test
    public void isTestComplete() {
        System.out.println("test run");
    }

    @After
    public void isAfterComplete() {
        System.out.println("Before test failed, but After test complete successful");
    }
}
