package ru.otus.tests;

import ru.otus.annotations.Before;
import ru.otus.annotations.Test;
import ru.otus.annotations.After;

public class SuccessfulTests {
    private int counter = 0;

    @Before
    public void init() {
        counter++;
    }

    @Test
    public void createNewObject1() {
        if (counter != 1) {
            throw new RuntimeException(
                    "Expected counter == 1, but was " + counter);
        }
    }

    @Test
    public void createNewObject2() {
        if (counter != 1) {
            throw new RuntimeException(
                    "Expected counter == 1, but was " + counter);
        }
    }

    @After
    public void finishTest() {
        System.out.println("finish test is successful");
    }
}
