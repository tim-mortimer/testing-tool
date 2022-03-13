package com.example.testingtool;

import java.lang.reflect.InvocationTargetException;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    protected void setUp() {}

    public TestResult run(Class<? extends TestCase> testCase) {
        this.setUp();
        try {
            testCase.getDeclaredMethod(name).invoke(this);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new TestExecutionException(e);
        }
        this.tearDown();
        return new TestResult();
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
