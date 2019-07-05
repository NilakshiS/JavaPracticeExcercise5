/*
countWord() method finds the count of each word in a String, It uses String's replaceAll
method to remove any special characters. It returns the count of each word as key value pair in a map
 */
package com.stackroute.pe5;

import java.util.HashMap;
import java.util.Map;

class WordCount {
    Map<String, Integer> countWords(String inputString) {
        if (inputString == null || inputString.equals(""))              //check for null inputs
            return null;

        //replace special characters with space
        inputString = inputString.replaceAll("[.,?_*^&%$#@!()\\-+=;:'></\"\\[\\]}{\\\\|~`]+", " ");

        if (inputString.matches("\\s+"))                        //if string is just spaces now return null
            return null;

        Map<String, Integer> count = new HashMap<>();                  //HashMap to store counts as key-value pairs

        String[] splitString = inputString.split("\\s+");       //split words with spaces

        for (String word :
                splitString) {
            if (count.containsKey(word)) {                              //if map already has the word update the count
                Integer value = count.get(word);
                count.put(word, ++value);
            } else {
                count.put(word, 1);                                 //otherwise put the word in map with count 1
            }
        }
        return count;
    }
}
