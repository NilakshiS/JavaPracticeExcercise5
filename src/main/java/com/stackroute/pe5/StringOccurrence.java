/*
checkOccurrence() method takes an array of strings as input and gives output as a Map<String,boolean> where
each different string is a key and its value is true if that string appears 2 or more times in the array
otherwise false.
 */
package com.stackroute.pe5;

import java.util.*;

class StringOccurrence {
    Map<String, Boolean> checkOccurrence(String[] strings) {
        if (strings == null || strings.length == 0)                                 //check for null or empty input
            return null;

        Map<String, Boolean> count = new HashMap<>();

        Set<String> uniqueElements = new HashSet<>(Arrays.asList(strings));         //convert to set to get unique elements
        ArrayList<String> allElements = new ArrayList<>(Arrays.asList(strings));    //convert to ArrayList

        if (allElements.contains(null))                                             //check if any element is null
            return null;

        for (String element :
                uniqueElements) {

            int size = allElements.size();                                          //find initial size
            allElements.removeAll(Collections.singleton(element));                  //remove the element
            count.put(element, (size - allElements.size() >= 2));                   //if difference in size >=2, it means element was present more than once

        }
        return count;
    }
}
