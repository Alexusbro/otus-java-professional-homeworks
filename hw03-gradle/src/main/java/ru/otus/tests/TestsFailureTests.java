package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class TestsFailureTests {

    @Before
    public void before1() {
        System.out.println("First before test successful");
    }

    @Before
    public void before2() {
        System.out.println("Second before test successful");
    }

    @Test
    public void test1() {
        System.out.println("First test failed");
    }

    @Test
    public void test2() {
        throw new RuntimeException("Second test failed");
    }

    @After
    public void after() {
        System.out.println("after test successful");
    }
}
