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

    public static void main(String[] args) {
        (new TestCaseTest("testTemplateMethod")).run(TestCaseTest.class);
    }
}
