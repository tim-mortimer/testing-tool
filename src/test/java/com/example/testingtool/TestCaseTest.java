package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var test = new WasRun("testMethod");
        assert !test.wasRun;
        test.run(WasRun.class);
        assert test.wasRun;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        var testCaseTest = new TestCaseTest("testRunning");
        testCaseTest.run(TestCaseTest.class);
    }
}
