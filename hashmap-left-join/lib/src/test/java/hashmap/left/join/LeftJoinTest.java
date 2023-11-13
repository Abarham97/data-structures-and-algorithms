package hashmap.left.join;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LeftJoinTest {

    @Test
    public void testLeftJoin() {
        // Test Case 1
        Map<String, String> synonyms1 = new HashMap<>();
        synonyms1.put("happy", "joyful");
        synonyms1.put("sad", "unhappy");
        synonyms1.put("bright", "radiant");

        Map<String, String> antonyms1 = new HashMap<>();
        antonyms1.put("happy", "sad");
        antonyms1.put("sad", "happy");
        antonyms1.put("bright", "dim");

        Map<String, String[]> expected1 = new HashMap<>();
        expected1.put("happy", new String[]{"joyful", "sad"});
        expected1.put("sad", new String[]{"unhappy", "happy"});
        expected1.put("bright", new String[]{"radiant", "dim"});
        assertLeftJoin(synonyms1, antonyms1, expected1);

        // Test Case 2: Empty antonyms
        Map<String, String> synonyms2 = new HashMap<>();
        synonyms2.put("happy", "joyful");
        synonyms2.put("sad", "unhappy");

        Map<String, String> antonyms2 = new HashMap<>();

        Map<String, String[]> expected2 = new HashMap<>();
        expected2.put("happy", new String[]{"joyful", null});
        expected2.put("sad", new String[]{"unhappy", null});
        assertLeftJoin(synonyms2, antonyms2, expected2);

        // Test Case 3: Empty synonyms
        Map<String, String> synonyms3 = new HashMap<>();

        Map<String, String> antonyms3 = new HashMap<>();
        antonyms3.put("happy", "sad");

        Map<String, String[]> expected3 = new HashMap<>();
        assertLeftJoin(synonyms3, antonyms3, expected3);
    }

    @Test
    public void testAppendValues() {
        // Test Case 1: Both values present
        String[] result1 = LeftJoin.appendValues("syn", "ant");
        assertArrayEquals(new String[]{"syn", "ant"}, result1);

        // Test Case 2: Antonym is null
        String[] result2 = LeftJoin.appendValues("syn", null);
        assertArrayEquals(new String[]{"syn", null}, result2);

        // Test Case 3: Synonym is null
        String[] result3 = LeftJoin.appendValues(null, "ant");
        assertArrayEquals(new String[]{null, "ant"}, result3);

        // Test Case 4: Both values are null
        String[] result4 = LeftJoin.appendValues(null, null);
        assertArrayEquals(new String[]{null, null}, result4);
    }

    @Test
    public void testLeftJoinWithNullValues() {
        // Test Case 1
        Map<String, String> synonyms1 = new HashMap<>();
        synonyms1.put("happy", "joyful");
        synonyms1.put("sad", "unhappy");

        Map<String, String> antonyms1 = new HashMap<>();
        antonyms1.put("happy", null);
        antonyms1.put("sad", "happy");

        Map<String, String[]> expected1 = new HashMap<>();
        expected1.put("happy", new String[]{"joyful", null});
        expected1.put("sad", new String[]{"unhappy", "happy"});
        assertLeftJoin(synonyms1, antonyms1, expected1);
    }

    private void assertLeftJoin(Map<String, String> leftMap, Map<String, String> rightMap, Map<String, String[]> expectedResult) {
        Map<String, String[]> result = LeftJoin.leftJoin(leftMap, rightMap);
        assertEquals(expectedResult.size(), result.size());

        for (Map.Entry<String, String[]> entry : expectedResult.entrySet()) {
            String word = entry.getKey();
            String[] expectedValues = entry.getValue();
            String[] actualValues = result.get(word);

            assertArrayEquals(expectedValues, actualValues);
        }
    }
}

