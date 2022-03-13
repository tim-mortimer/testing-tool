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

    public void testTemplateMethod() {
        test.run(WasRun.class);
        assertTrue(test.log.equals("setUp testMethod "));
    }

    public static void main(String[] args) {
        (new TestCaseTest("testTemplateMethod")).run(TestCaseTest.class);
    }
}
