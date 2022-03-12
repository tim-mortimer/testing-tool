package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public class WasRunTest {
    public void wasRunTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var test = new WasRun("testMethod");
        System.out.println(test.wasRun);
        test.run();
        System.out.println(test.wasRun);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var wasRunTest = new WasRunTest();
        wasRunTest.wasRunTest();
    }
}
