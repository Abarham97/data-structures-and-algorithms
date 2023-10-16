package insertionsort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {
    @Test
    public void testInsertionSort() {
        int[] input = {8, 4, 23, 42, 16, 15};
        int[] expected = {4, 8, 15, 16, 23, 42};
        int[] sorted = InsertionSort.insertionSort(input);
        Assertions.assertArrayEquals(expected, sorted);
    }

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        int[] sorted = InsertionSort.insertionSort(input);
        Assertions.assertArrayEquals(expected, sorted);
    }

    @Test
    public void testAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] sorted = InsertionSort.insertionSort(input);
        Assertions.assertArrayEquals(expected, sorted);
    }
}
