package hashmap.repeated.word;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedWordFinderTester {

    @Test
    public void testFindRepeatedWordNoRepeats() {
        String input = "This is a test sentence.";
        String result = RepeatedWordFinder.findRepeatedWord(input);
        assertEquals("", result);
    }

    @Test
    public void testFindRepeatedWordWithRepeats() {
        String input = "This is a test sentence with repeated words. This is a test sentence.";
        String result = RepeatedWordFinder.findRepeatedWord(input);
        assertEquals("this", result);
    }

    @Test
    public void testFindRepeatedWordCaseInsensitive() {
        String input = "This is a test sentence. this is a test sentence.";
        String result = RepeatedWordFinder.findRepeatedWord(input);
        assertEquals("this", result);
    }


}

