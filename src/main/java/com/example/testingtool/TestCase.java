package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    protected void setUp() {}

    public TestResult run(Class<? extends TestCase> testCase) {
        var testResult = new TestResult();
        testResult.testStarted();
        this.setUp();
        try {
            testCase.getDeclaredMethod(name).invoke(this);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new TestExecutionException(e);
        } catch (Exception e) {
            testResult.testFailed();
        }
        this.tearDown();
        return testResult;
    }

    protected void tearDown() {}

    protected static void assertTrue(boolean assertion) {
        if (!assertion) {
            throw new AssertionFailedException();
        }
    }

    private static class AssertionFailedException extends RuntimeException {
    }

    private static class TestExecutionException extends RuntimeException {
        public TestExecutionException(ReflectiveOperationException e) {
            super(e);
        }
    }
}
