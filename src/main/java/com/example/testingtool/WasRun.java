package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public class WasRun {
    public boolean wasRun;
    private final String name;

    public WasRun(String name) {
        this.name = name;
    }

    public void testMethod() {
        wasRun = true;
    }

    public void run() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        WasRun.class.getDeclaredMethod(name).invoke(this);
    }
}
