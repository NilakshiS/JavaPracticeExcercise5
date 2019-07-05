/*
The operateOnList method takes a list, a number and a string as inputs and
updates the specific array element on the index number by given element and empties the array list.
 */

package com.stackroute.pe5;

import java.util.List;

class ArrayListOperations {
    String operateOnList(List<String> listToOperateOn, int index, String replacement) {
        if (replacement == null || listToOperateOn == null)         //check for null inputs
            return null;
        if (listToOperateOn.isEmpty())                              //check for empty list
            return null;
        if (index < 0 || index > listToOperateOn.size() - 1)          //check for index out of range
            return null;

        listToOperateOn.set(index, replacement);                     //replace the word
        String output = listToOperateOn.toString();                 //add the result to the output string

        listToOperateOn.clear();                                    //clear the list
        output += listToOperateOn.toString();                       //add the result to the output string

        return output;
    }
}
