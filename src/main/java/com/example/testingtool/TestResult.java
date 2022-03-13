package com.example.testingtool;

public class TestResult {
    private int runCount;
    private int errorCount;

    public TestResult() {
        this.runCount = 0;
        this.errorCount = 0;
    }

    public void testStarted() {
        this.runCount += 1;
    }

    public void testFailed() {
        this.errorCount += 1;
    }

    public String summary() {
        return String.format("%d run, %d failed", runCount, errorCount);
    }
}
