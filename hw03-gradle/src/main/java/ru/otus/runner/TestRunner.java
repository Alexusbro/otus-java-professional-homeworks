package ru.otus.runner;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;
import ru.otus.statistics.TestStatistics;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TestRunner {

    public static void run(String className) {
        TestStatistics statistics = new TestStatistics();

        Class<?> testClass = findClass(className);
        Method[] methods = testClass.getDeclaredMethods();
        Map<Class<? extends Annotation>, List<Method>> methodsByAnnotation = collectAnnotatedMethods(methods);
        Constructor<?> constructor = findConstructor(testClass);

        runTests(methodsByAnnotation, constructor, statistics);

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

    private static Map<Class<? extends Annotation>, List<Method>> collectAnnotatedMethods(Method[] methods) {
        Map<Class<? extends Annotation>, List<Method>> methodsByAnnotation = new HashMap<>();
        for (Method method : methods) {

            if (method.isAnnotationPresent(Before.class)) {
                methodsByAnnotation.computeIfAbsent(Before.class, k -> new ArrayList<>()).add(method);
            }

            if (method.isAnnotationPresent(Test.class)) {
                methodsByAnnotation.computeIfAbsent(Test.class, k -> new ArrayList<>()).add(method);
            }

            if (method.isAnnotationPresent(After.class)) {
                methodsByAnnotation.computeIfAbsent(After.class, k -> new ArrayList<>()).add(method);
            }
        }
        return methodsByAnnotation;
    }

    private static void runTests(Map<Class<? extends Annotation>, List<Method>> methodsByAnnotation, Constructor<?> constructor, TestStatistics statistics) {
        boolean isTestFailed;
        for (Method method : methodsByAnnotation.getOrDefault(Test.class, new ArrayList<>())) {
            Object testObject = null;
            isTestFailed = false;
            try {
                testObject = constructor.newInstance();

                for (Method methodBefore : methodsByAnnotation.getOrDefault(Before.class, new ArrayList<>())) {
                    boolean isBeforeFailed = executeMethod(methodBefore, testObject);
                    isTestFailed = isTestFailed || isBeforeFailed;
                }

                if (!isTestFailed) {
                    isTestFailed = executeMethod(method, testObject);
                }

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            } finally {
                if (testObject != null) {
                    for (Method methodAfter : methodsByAnnotation.getOrDefault(After.class, new ArrayList<>())) {
                        boolean isAfterFailed = executeMethod(methodAfter, testObject);
                        isTestFailed = isTestFailed || isAfterFailed;
                    }
                }
            }
            if (!isTestFailed) {
                statistics.testPassed();
            } else statistics.testFailed();
        }


    }


    private static boolean executeMethod(Method method, Object testObject) {
        try {
            method.invoke(testObject);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot invode method " + method.getName());
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            System.out.println("Test of method " + method.getName() + " failed: " + e.getCause());
            return true;
        }
        return false;
    }
}
