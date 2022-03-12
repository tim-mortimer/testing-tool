package com.example.testingtool;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() throws Exception {
        var test = new WasRun("testMethod");
        test.run(WasRun.class);
        if (!test.wasRun) throw new Exception();
    }

    public void testSetUp() throws Exception {
        var test = new WasRun("testMethod");
        test.run(WasRun.class);
        if (!test.wasSetUp) throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        (new TestCaseTest("testRunning")).run(TestCaseTest.class);
        (new TestCaseTest("testSetUp")).run(TestCaseTest.class);
    }
}
