package com.stackroute.pe5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SortedSetTest {
    private static SortedSet sortedSet;

    @BeforeClass
    public static void setUp() {
        sortedSet = new SortedSet();
    }

    @AfterClass
    public static void tearDown() {
        sortedSet = null;
    }

    @Test
    public void givenNullShouldReturnNull() {
        assertNull(sortedSet.sortSet(null));
    }

    @Test
    public void givenEmptySetShouldReturnNull() {
        assertNull(sortedSet.sortSet(new HashSet<>()));
    }

    @Test
    public void givenValidInputShouldReturnCorrectOutput() {
        Set<String> testInput = new HashSet<>();
        testInput.add("Harry");
        testInput.add("Olive");
        testInput.add("Eugene");
        testInput.add("Bluto");
        testInput.add("Alice");
        String expected = "[Alice, Bluto, Eugene, Harry, Olive][Alice, Bluto, Eugene, Harry, Olive]";
        assertEquals(expected, sortedSet.sortSet(testInput));
    }

    @Test
    public void givenNullInSetShouldReturnNull() {
        Set<String> testInput = new HashSet<>();
        testInput.add("Harry");
        testInput.add(null);
        testInput.add("Eugene");
        testInput.add(null);
        testInput.add("Alice");
        assertNull(sortedSet.sortSet(testInput));
    }
}