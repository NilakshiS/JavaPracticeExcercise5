package com.stackroute.pe5;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayListOperationsTest {
    private static ArrayListOperations arrayListOperations;
    private static List<String> testList;

    @BeforeClass
    public static void setUp() {
        arrayListOperations = new ArrayListOperations();
        testList = new ArrayList<>();
    }

    @AfterClass
    public static void tearDown() {
        arrayListOperations = null;
        testList = null;
    }

    @Before
    public void setTestList() {
        testList.clear();
    }

    @Test
    public void givenNullInputsShouldReturnNull() {
        testList.add("a");
        testList.add("b");
        assertNull(arrayListOperations.operateOnList(null, 1, "hello"));
        assertNull(arrayListOperations.operateOnList(testList, 1, null));
    }

    @Test
    public void givenIndexOutOfRangeShouldReturnNull() {
        testList.add("a");
        testList.add("b");
        assertNull(arrayListOperations.operateOnList(testList, 3, "hello"));
        assertNull(arrayListOperations.operateOnList(testList, -1, "mango"));
    }

    @Test
    public void givenEmptyArrayListShouldReturnNull() {
        assertNull(arrayListOperations.operateOnList(testList, 3, "apple"));
    }

    @Test
    public void givenValidInputsShouldReturnCorrectOutput() {
        //Arrange
        testList.add("Apple");
        testList.add("Grape");
        testList.add("Mango");
        testList.add("Berry");
        String result = arrayListOperations.operateOnList(testList, 0, "Kiwi");
        assertEquals("[Kiwi, Grape, Mango, Berry][]", result);
        testList.add("Apple");
        testList.add("Grape");
        testList.add("Mango");
        testList.add("Berry");
        result = arrayListOperations.operateOnList(testList, 0, "");
        assertEquals("[, Grape, Mango, Berry][]", result);
    }
}