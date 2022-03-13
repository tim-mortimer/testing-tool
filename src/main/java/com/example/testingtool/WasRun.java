package com.example.testingtool;

public class WasRun extends TestCase {
    private String log;

    public WasRun(String name) {
        super(name);
    }

    protected void setUp() {
        this.log = "setUp ";
    }

    public void testMethod() {
        this.log = this.getLog() + "testMethod ";
    }

    public void testBrokenMethod() {
        throw new RuntimeException();
    }

    protected void tearDown() {
        this.log = this.getLog() + "tearDown ";
    }

    public String getLog() {
        return log;
    }
}
