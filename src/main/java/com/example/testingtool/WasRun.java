package com.example.testingtool;

public class WasRun extends TestCase {
    public boolean wasRun;
    public String log;

    public WasRun(String name) {
        super(name);
    }

    protected void setUp() {
        this.log = "setUp ";
    }

    public void testMethod() {
        wasRun = true;
    }
}
