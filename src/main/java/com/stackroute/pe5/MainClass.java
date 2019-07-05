/*
The sortStudents() method takes an List of Students, sorts the student by using a comparator
 and returns the sorted list.
 */
package com.stackroute.pe5;

import java.util.List;

class MainClass {
    List<Student> sortStudents(List<Student> studentList) {
        //check for null or empty inputs or null in list
        if (studentList == null || studentList.contains(null) || studentList.isEmpty())
            return null;

        //sort the list by calling the StudentSorter comparator
        studentList.sort(new StudentSorter());

        //return the sorted list
        return studentList;
    }
}
