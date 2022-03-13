package com.example.testingtool;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    protected void setUp() {}

    public void run(Class<? extends TestCase> testCase, TestResult result) {
        result.testStarted();
        this.setUp();
        try {
            testCase.getDeclaredMethod(name).invoke(this);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new TestExecutionException(e);
        } catch (Exception e) {
            result.testFailed();
        }
        this.tearDown();
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
