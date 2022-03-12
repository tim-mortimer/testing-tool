package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void run() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        WasRun.class.getDeclaredMethod(name).invoke(this);
    }
}
