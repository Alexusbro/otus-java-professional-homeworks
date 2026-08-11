package ru.otus.tests;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class AfterFailureTests {

    @Before
    public void before() {
        System.out.println("before test successful");
    }

    @Test
    public void test1() {
        System.out.println("test1 successful");
    }

    @Test
    public void test2() {
        System.out.println("test2 didn`t complete");
    }

    @After
    public void after() {
        throw new RuntimeException("after test failed");
    }
}
