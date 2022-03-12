package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public class WasRun extends TestCase {
    public boolean wasRun;

    public WasRun(String name) {
        super(name);
    }

    public void testMethod() {
        wasRun = true;
    }

    public void run() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        WasRun.class.getDeclaredMethod(name).invoke(this);
    }
}
