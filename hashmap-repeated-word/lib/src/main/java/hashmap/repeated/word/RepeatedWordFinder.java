package hashmap.repeated.word;

import java.util.HashMap;
import java.util.Map;

public class RepeatedWordFinder {
    public static String findRepeatedWord(String input) {
        String[] words = input.split("\\s+");

        Map<String, Integer> wordOccurrences = new HashMap<>();

        for (String word : words) {
            String lowercaseWord = word.toLowerCase();

            if (wordOccurrences.containsKey(lowercaseWord)) {
                return lowercaseWord;
            }

            wordOccurrences.put(lowercaseWord, 1);
        }

        return "";
    } }