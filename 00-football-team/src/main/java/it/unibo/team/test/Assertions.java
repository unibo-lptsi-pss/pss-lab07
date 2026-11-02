package it.unibo.team.test;

import java.util.Objects;

/**
 * Utilities for testing.
 */
public final class Assertions {

    private static final String ERROR_HEADER = "# ERROR! ";
    private static final String ERROR_FOOTER = " #";
    private static final String EXPECTED_HEADER = "- As expected: ";

    private Assertions() { }

    /**
     * Exits with an error if the condition is not met.
     *
     * @param condition the condition to check
     */
    public static void assertTrue(final boolean condition) {
        if (condition) {
            confirmOK(true, condition);
        } else {
            printAndExit(1, "expected true, but got false");
        }
    }

    /**
     * Exits with an error if the condition is met.
     *
     * @param condition the condition to check
     */
    public static void assertFalse(final boolean condition) {
        if (condition) {
            printAndExit(1, "expected false, but got true");
        } else {
            confirmOK(false, condition);
        }
    }

    /**
     * Exits with an error if actual is not equal to expected, according to the {@code equals} method of actual.
     *
     * @param expected the expected object
     * @param actual the actual object
     */
    public static void assertEquals(final Object expected, final Object actual) {
        if (Objects.equals(actual, expected)) {
            confirmOK(expected, actual);
        } else {
            printAndExit(2, "expected " + expected + ", but got " + actual);
        }
    }

    /**
     * Exits with an error if actual is equal to unexpected, according to the {@code equals} method of actual.
     *
     * @param unexpected the object that actual must differ from
     * @param actual the actual object
     */
    public static void assertNotEquals(final Object unexpected, final Object actual) {
        if (Objects.equals(actual, unexpected)) {
            printAndExit(2, "expected something different from " + unexpected + ", but got " + actual);
        } else {
            IO.println(EXPECTED_HEADER + actual + " is different from " + unexpected + ".");
        }
    }

    /**
     * Exits with an error if expected and actual are not the very same object.
     *
     * @param expected the expected object
     * @param actual the actual object
     */
    public static void assertSame(final Object expected, final Object actual) {
        if (expected == actual) {
            confirmOK(expected, actual);
        } else {
            printAndExit(2, "expected the same object as " + expected + ", but got " + actual);
        }
    }

    /**
     * Exits with an error if running the action does not throw an exception of the expected type.
     *
     * @param expectedType the type of the exception that the action must throw
     * @param action the code to run
     */
    public static void assertThrows(final Class<? extends RuntimeException> expectedType, final Runnable action) {
        try {
            action.run();
        } catch (final RuntimeException e) {
            if (expectedType.isInstance(e)) {
                IO.println(EXPECTED_HEADER + e.getClass().getSimpleName() + " thrown: " + e.getMessage());
                return;
            }
            printAndExit(3, "expected " + expectedType.getSimpleName() + ", but " + e + " was thrown");
        }
        printAndExit(3, "expected " + expectedType.getSimpleName() + ", but nothing was thrown");
    }

    private static void confirmOK(final Object expected, final Object actual) {
        IO.println(EXPECTED_HEADER + expected + " expected, and " + actual + " received.");
    }

    private static void printAndExit(final int errorCode, final String message) {
        final var error = ERROR_HEADER + message + ERROR_FOOTER;
        final var decoration = "#".repeat(error.length());
        final var builder = new StringBuilder(3 * error.length() + 2)
            .append(decoration)
            .append('\n')
            .append(error)
            .append('\n')
            .append(decoration);
        System.err.println(builder); // NOPMD
        System.exit(errorCode);
    }
}
