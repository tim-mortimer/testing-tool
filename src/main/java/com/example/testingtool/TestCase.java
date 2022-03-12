package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void run(Class<? extends TestCase> testCase) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testCase.getDeclaredMethod(name).invoke(this);
    }
}
