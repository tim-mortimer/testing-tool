package com.example.testingtool;

public class TestCaseTest extends TestCase {
    private TestResult result;

    public TestCaseTest(String name) {
        super(name);
    }

    protected void setUp() {
        this.result = new TestResult();
    }

    public void testTemplateMethod() {
        var test = new WasRun("testMethod");
        test.run(WasRun.class, result);
        assertTrue(test.log().equals("setUp testMethod tearDown "));
    }

    public void testResult() {
        var test = new WasRun("testMethod");
        test.run(WasRun.class, result);
        assertTrue("1 run, 0 failed".equals(result.summary()));
    }

    public void testFailedResult() {
        var test = new WasRun("testBrokenMethod");
        test.run(WasRun.class, result);
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    public void testFailedResultFormatting() {
        result.testStarted();
        result.testFailed();
        assertTrue("1 run, 1 failed".equals(result.summary()));
    }

    public void testSuite() {
        var suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
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
