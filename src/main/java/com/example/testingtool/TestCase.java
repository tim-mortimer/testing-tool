package com.example.testingtool;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void run(Class<? extends TestCase> testCase) throws Exception {
        testCase.getDeclaredMethod(name).invoke(this);
    }
}
