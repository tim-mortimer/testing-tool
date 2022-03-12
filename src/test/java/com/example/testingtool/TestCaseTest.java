package com.example.testingtool;

public class TestCaseTest extends TestCase {
    private WasRun test;

    public TestCaseTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() {
        test = new WasRun("testMethod");
    }

    public void testRunning() throws Exception {
        test.run(WasRun.class);
        if (!test.wasRun) throw new Exception();
    }

    public void testSetUp() throws Exception {
        test.run(WasRun.class);
        if (!test.wasSetUp) throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        (new TestCaseTest("testRunning")).run(TestCaseTest.class);
        (new TestCaseTest("testSetUp")).run(TestCaseTest.class);
    }
}
