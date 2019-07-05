package com.stackroute.pe5;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MainClassTest {
    private static MainClass mainClass;
    private static List<Student> expected;
    private static List<Student> testInput;

    @BeforeClass
    public static void setUp() {
        mainClass = new MainClass();
        expected = new ArrayList<>();
        testInput = new ArrayList<>();
    }

    @AfterClass
    public static void tearDown() {
        mainClass = null;
        expected = null;
        testInput = null;
    }

    @Before
    public void clearLists() {
        expected.clear();
        testInput.clear();
    }

    @Test
    public void givenNullInputShouldReturnNull() {
        assertNull(mainClass.sortStudents(null));
    }

    @Test
    public void givenEmptyListShouldReturnNull() {
        assertNull(mainClass.sortStudents(new ArrayList<>()));
    }

    @Test
    public void givenNullInListShouldReturnNull() {
        testInput.add(new Student(23, "a", 2));
        testInput.add(new Student(24, "b", 3));
        testInput.add(null);
        testInput.add(new Student(25, "c", 4));
        assertNull(mainClass.sortStudents(testInput));
    }

    @Test
    public void givenValidInputShouldReturnCorrectOutput() {
        Student student1 = new Student(20, "b", 1);
        Student student2 = new Student(21, "b", 2);
        Student student3 = new Student(20, "b", 3);
        Student student4 = new Student(20, "b", 3);
        Student student5 = new Student(20, "a", 5);

        testInput.add(student1);
        testInput.add(student2);
        testInput.add(student3);
        testInput.add(student4);
        testInput.add(student5);

        expected.add(student5);
        expected.add(student3);
        expected.add(student4);
        expected.add(student1);
        expected.add(student2);

        assertEquals(expected, mainClass.sortStudents(testInput));

        expected.clear();
        testInput.clear();

        student1 = new Student(25, "b", 1);
        student2 = new Student(24, "b", 2);
        student3 = new Student(23, "b", 3);
        student4 = new Student(22, "b", 3);
        student5 = new Student(21, "a", 5);

        testInput.add(student1);
        testInput.add(student2);
        testInput.add(student3);
        testInput.add(student4);
        testInput.add(student5);

        expected.add(student5);
        expected.add(student4);
        expected.add(student3);
        expected.add(student2);
        expected.add(student1);

        assertEquals(expected, mainClass.sortStudents(testInput));
    }

}