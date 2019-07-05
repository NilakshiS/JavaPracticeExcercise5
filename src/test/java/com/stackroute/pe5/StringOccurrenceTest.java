package com.stackroute.pe5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringOccurrenceTest {
    private static StringOccurrence stringOccurrence;

    @BeforeClass
    public static void setUp() {
        stringOccurrence = new StringOccurrence();
    }

    @AfterClass
    public static void tearDown() {
        stringOccurrence = null;
    }

    @Test
    public void givenNullShouldReturnNull() {
        assertNull(stringOccurrence.checkOccurrence(null));
    }

    @Test
    public void givenEmptyArrayShouldReturnNull() {
        assertNull(stringOccurrence.checkOccurrence(new String[]{}));
    }

    @Test
    public void givenNullInArrayShouldReturnNull() {
        assertNull(stringOccurrence.checkOccurrence(new String[]{null, "a", "b", "c", null}));
    }

    @Test
    public void givenStringsWithLessThanTwoOccurrenceShouldReturnAllFalseMap() {
        Map<String, Boolean> test = Map.of("a", false, "b", false, "c", false, "d", false);
        assertEquals(test, stringOccurrence.checkOccurrence(new String[]{"a", "b", "c", "d"}));
    }

    @Test
    public void givenStringsWithMoreThanTwoOccurrenceShouldReturnCorrectOutput() {
        Map<String, Boolean> test = Map.of("a", true, "b", false, "c", true, "d", false);
        assertEquals(test, stringOccurrence.checkOccurrence(new String[]{"a", "b", "c", "d", "a", "c", "c"}));

        test = Map.of("2.3", true, "4", false, "6.7", true, "3.4", false);
        assertEquals(test, stringOccurrence.checkOccurrence(new String[]{"2.3", "4", "6.7", "3.4", "2.3", "6.7", "6.7"}));
    }
}