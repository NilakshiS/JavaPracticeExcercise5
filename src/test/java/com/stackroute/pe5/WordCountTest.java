package com.stackroute.pe5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WordCountTest {
    private static WordCount wordCount;

    @BeforeClass
    public static void setUp() {
        wordCount = new WordCount();
    }

    @AfterClass
    public static void tearDown() {
        wordCount = null;
    }

    @Test
    public void givenNullShouldReturnNull() {
        assertNull(wordCount.countWords(null));
    }

    @Test
    public void givenEmptyStringShouldReturnNull() {
        assertNull(wordCount.countWords(""));
    }

    @Test
    public void givenOnlyPunctuationStringShouldReturnNull() {
        assertNull(wordCount.countWords(", . * ^& . ?"));
    }

    @Test
    public void givenValidInputShouldReturnCorrectOutput() {

        Map<String, Integer> expected = new HashMap<>(Map.of("three", 2, "two", 2, "one", 5));
        Map<String, Integer> actual = wordCount.countWords("one one -one___two,,three,one @three*one?two");

        assertEquals(expected, actual);

        expected = Map.of("three", 2, "two", 2, "one", 4, "one2a", 1);
        actual = wordCount.countWords("one2a one -one___two,,three,one @three*one?two[");

        assertEquals(expected, actual);
    }
}