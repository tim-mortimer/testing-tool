package com.example.testingtool;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testTemplateMethod() {
        var test = new WasRun("testMethod");
        test.run(WasRun.class, new TestResult());
        assertTrue(test.log().equals("setUp testMethod tearDown "));
    }

    public void testResult() {
        var test = new WasRun("testMethod");
        var result = new TestResult();
        test.run(WasRun.class, result);
        assertTrue("1 run, 0 failed".equals(result.summary()));
    }

    public void testFailedResult() {
        var test = new WasRun("testBrokenMethod");
        var result = new TestResult();
        test.run(WasRun.class, result);
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    public void testFailedResultFormatting() {
        var result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    public void testSuite() {
        var suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        var result = new TestResult();
        suite.run(result);
        assertTrue("2 run, 1 failed".equals(result.summary()));
    }

    public static void main(String[] args) {
        var suite = new TestSuite();
        suite.add(new TestCaseTest("testTemplateMethod"));
        suite.add(new TestCaseTest("testResult"));
        suite.add(new TestCaseTest("testFailedResult"));
        suite.add(new TestCaseTest("testFailedResultFormatting"));
        suite.add(new TestCaseTest("testSuite"));
        var result = new TestResult();
        suite.run(result);
        System.out.println(result.summary());
    }
}
