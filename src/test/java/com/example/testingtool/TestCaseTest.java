package com.example.testingtool;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() throws Exception {
        var test = new WasRun("testMethod");
        assert !test.wasRun;
        test.run(WasRun.class);
        assert test.wasRun;
    }

    public static void main(String[] args) throws Exception {
        var testCaseTest = new TestCaseTest("testRunning");
        testCaseTest.run(TestCaseTest.class);
    }
}
