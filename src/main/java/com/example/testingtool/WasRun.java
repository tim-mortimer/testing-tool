package com.example.testingtool;

public class WasRun extends TestCase {
    public String log;

    public WasRun(String name) {
        super(name);
    }

    protected void setUp() {
        this.log = "setUp ";
    }

    public void testMethod() {
        this.log += "testMethod ";
    }

    protected void tearDown() {
        this.log += "tearDown ";
    }
}
