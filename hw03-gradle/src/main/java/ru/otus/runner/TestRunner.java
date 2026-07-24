package ru.otus.runner;

import ru.otus.annotations.Test;
import ru.otus.statistics.TestStatistics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class TestRunner {

    public static void run(String className) {
        TestStatistics statistics = new TestStatistics();

        Class<?> testClass = findClass(className);
        Method[] methods = testClass.getDeclaredMethods();
        Constructor<?> constructor = findConstructor(testClass);

        for (Method method : methods) {
            if (!isTestMethod(method)) {
                continue;
            }
            executeTest(constructor, method, statistics);
        }

        System.out.println(statistics);
    }

    private static Class<?> findClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(className + " not found", e);
        }
    }

    private static Constructor<?> findConstructor(Class<?> testClass) {
        try {
            return testClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("default constructor not found for class " + testClass.getName(), e);
        }
    }

    private static boolean isTestMethod(Method method) {
        return method.isAnnotationPresent(Test.class);
    }

    private static void executeTest(Constructor<?> constructor, Method method, TestStatistics statistics) {
        try {
            Object testObject = constructor.newInstance();
            method.invoke(testObject);
            statistics.testPassed();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            statistics.testFailed();
            System.out.println("Test " + method.getName() + " is failed" + e.getCause());
        }

    }

}
