package com.example.testingtool;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private final List<TestToRun> tests;

    public TestSuite() {
        this.tests = new ArrayList<>();
    }

    public <U extends TestCase> void add(U testCase) {
        tests.add(new TestToRun(testCase.getClass(), testCase));
    }

    public void run(TestResult result) {
        for (TestToRun test : tests) {
            test.getTestCase().run(test.getaClass(), result);
        }
    }

    private static class TestToRun {
        Class<? extends TestCase> aClass;
        TestCase testCase;

        public TestToRun(Class<? extends TestCase> aClass, TestCase testCase) {
            this.aClass = aClass;
            this.testCase = testCase;
        }

        public Class<? extends TestCase> getaClass() {
            return aClass;
        }

        public TestCase getTestCase() {
            return testCase;
        }
    }
}
