/*
mapOperation() method accepts a Map object having two key-value pairs with the keys val1 and val2.
and modifies and returns the given map as follows:
a. set the key `val2` to have value of 'key1', and
b. Set the key `val1` to have the value `""` (empty string).
 */
package com.stackroute.pe5;

import java.util.HashMap;
import java.util.Map;

class MapOperation {
    Map<String, String> changeMap(Map<String, String> input, String firstKey, String secondKey) {
        if (input == null || firstKey == null || secondKey == null)                 //check for null inputs
            return null;

        if (input.size() == 0 || firstKey.length() == 0 || secondKey.length() == 0) //check for empty inputs
            return null;

        if (!input.containsKey(firstKey) || !input.containsKey(secondKey))          //check for keys not in map
            return null;

        if (input.size() == 1 || firstKey.equals(secondKey))                        //check for same keys being passed
            return null;                                                            //or if map has only one element

        Map<String, String> output = new HashMap<>(input);                           //create a copy of input to avoid
        //java.lang.UnsupportedOperationException immutable collections
        output.put(secondKey, output.get(firstKey));
        output.put(firstKey, "");

        return output;
    }
}
