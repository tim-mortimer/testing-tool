package com.example.testingtool;

import java.lang.reflect.Method;
import java.util.Arrays;

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
        Arrays.stream(TestCaseTest.class.getMethods())
                .filter(method -> method.getDeclaringClass().equals(TestCaseTest.class))
                .map(Method::getName)
                .filter(methodName -> !methodName.equals("main"))
                .map(TestCaseTest::new)
                .forEach(suite::add);
        var result = new TestResult();
        suite.run(result);
        System.out.println(result.summary());
    }
}
