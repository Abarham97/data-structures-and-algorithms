package hashmap.left.join;

import java.util.HashMap;
import java.util.Map;

public class LeftJoin {

    public static Map<String, String[]> leftJoin(Map<String, String> leftMap, Map<String, String> rightMap) {
        Map<String, String[]> result = new HashMap<>();

        for (Map.Entry<String, String> entry : leftMap.entrySet()) {
            String word = entry.getKey();
            String synonym = entry.getValue();
            String antonym = rightMap.get(word);

            result.put(word, appendValues(synonym, antonym));
        }

        return result;
    }

    public static String[] appendValues(String synonym, String antonym) {
        if (antonym != null) {
            return new String[]{synonym, antonym};
        } else {
            return new String[]{synonym, null};
        }
    }

    public static void assertLeftJoin(Map<String, String> synonyms, Map<String, String> antonyms,
                                       Map<String, String[]> expectedResult) {
        Map<String, String[]> result = leftJoin(synonyms, antonyms);
        System.out.println("Expected: " + expectedResult);
        System.out.println("Actual:   " + result);
        System.out.println("Assertion: " + (result.equals(expectedResult) ? "Passed" : "Failed"));
        System.out.println();
    }
}


