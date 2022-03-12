package com.example.testingtool;

public class WasRun extends TestCase {
    public boolean wasSetUp;
    public boolean wasRun;

    public WasRun(String name) {
        super(name);
    }

    protected void setUp() {
        this.wasSetUp = true;
    }

    public void testMethod() {
        wasRun = true;
    }
}
