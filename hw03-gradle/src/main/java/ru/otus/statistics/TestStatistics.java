package ru.otus.statistics;

public class TestStatistics {
    private int successfulTests;
    private int failedTests;

    public int getSuccessfulTests() {
        return successfulTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public void testPassed() {
        successfulTests++;
    }

    public void testFailed() {
        failedTests++;
    }

    public int getTotalTests() {
        return successfulTests + failedTests;
    }

    @Override
    public String toString() {
        return """
                Total tests: %d
                Successful tests: %d
                Failed tests: %d
                """.formatted(getTotalTests(), getSuccessfulTests(), getFailedTests());
    }
}
