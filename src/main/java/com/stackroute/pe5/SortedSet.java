/*
The sortSet() method sorts the given randomly ordered names in
ascending order, converts the sorted set into an array list
and finally returns both as string output
 */

package com.stackroute.pe5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class SortedSet {
    String sortSet(Set<String> inputSet) {
        if (inputSet == null || inputSet.isEmpty())             //check if input is null or empty
            return null;

        if (inputSet.contains(null))                            //check if set contains null
            return null;

        String output = "";
        TreeSet<String> toSort = new TreeSet<>(inputSet);       //create a TreeSet object with the set to sort it
        output += toSort.toString();                            //store the sorted set to string
        List<String> list = new ArrayList<>(toSort);            //convert set to ArrayList
        output += list.toString();                              //store the arrayList to string
        return output;
    }
}
