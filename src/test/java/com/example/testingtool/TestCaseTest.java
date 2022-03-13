package com.example.testingtool;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testTemplateMethod() {
        var test = new WasRun("testMethod");
        test.run(WasRun.class);
        assertTrue(test.getLog().equals("setUp testMethod tearDown "));
    }

    public void testResult() {
        var test = new WasRun("testMethod");
        var result = test.run(WasRun.class);
        assertTrue("1 run, 0 failed".equals(result.summary()));
    }

    public void testFailedResult() {
        var test = new WasRun("testBrokenMethod");
        var result = test.run(WasRun.class);
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    public void testFailedResultFormatting() {
        var result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    public static void main(String[] args) {
        (new TestCaseTest("testTemplateMethod")).run(TestCaseTest.class);
        (new TestCaseTest("testResult")).run(TestCaseTest.class);
        (new TestCaseTest("testFailedResult")).run(TestCaseTest.class);
        (new TestCaseTest("testFailedResultFormatting")).run(TestCaseTest.class);
    }
}
