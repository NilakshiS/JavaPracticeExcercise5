package com.stackroute.pe5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MapOperationTest {
    private static MapOperation mapOperation;

    @BeforeClass
    public static void setUp() {
        mapOperation = new MapOperation();
    }

    @AfterClass
    public static void tearDown() {
        mapOperation = null;
    }

    @Test
    public void givenNullInputsShouldReturnNull() {
        assertNull(mapOperation.changeMap(null, "key1", "key2"));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), null, "key2"));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key1", null));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), null, null));
        assertNull(mapOperation.changeMap(null, "key1", null));
        assertNull(mapOperation.changeMap(null, null, "key2"));
        assertNull(mapOperation.changeMap(null, null, null));
    }

    @Test
    public void givenEmptyInputsShouldReturnNull() {
        assertNull(mapOperation.changeMap(new HashMap<>(), "key1", "key2"));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "", "key2"));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key1", ""));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "", ""));
        assertNull(mapOperation.changeMap(new HashMap<>(), "key1", ""));
        assertNull(mapOperation.changeMap(new HashMap<>(), "", "key2"));
        assertNull(mapOperation.changeMap(new HashMap<>(), "", ""));
    }

    @Test
    public void givenSameKeysShouldReturnNull() {
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key1", "key1"));
    }

    @Test
    public void givenKeysNotInMapShouldReturnNull() {
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key3", "key1"));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key1", "key3"));
        assertNull(mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key3", "key4"));
    }

    @Test
    public void givenSingleElementMapShouldReturnNull() {
        assertNull(mapOperation.changeMap(Map.of("key1", "c++"), "key1", "key2"));
    }

    @Test
    public void givenValidInputsShouldReturnCorrectOutput() {
        Map<String, String> expected = Map.of("key1", "", "key2", "c++");
        assertEquals(expected, mapOperation.changeMap(Map.of("key1", "c++", "key2", "java"), "key1", "key2"));
    }
}