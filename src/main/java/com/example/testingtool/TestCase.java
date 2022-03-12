package com.example.testingtool;

public abstract class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    protected void setUp() {}

    public void run(Class<? extends TestCase> testCase) throws Exception {
        this.setUp();
        testCase.getDeclaredMethod(name).invoke(this);
    }
}
