package mergesort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] inputArray = {8, 4, 23, 42, 16, 15};
        int[] expectedSortedArray = {4, 8, 15, 16, 23, 42};

        mergeSort.mergeSort(inputArray);

        assertArrayEquals(expectedSortedArray, inputArray);
    }

    @Test
    public void testMerge() {
        int[] left = {4, 8, 15};
        int[] right = {16, 23, 42};
        int[] result = new int[left.length + right.length];

        mergeSort.merge(left, right, result);

        int[] expectedMergedArray = {4, 8, 15, 16, 23, 42};
        assertArrayEquals(expectedMergedArray, result);
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        mergeSort.mergeSort(emptyArray);

        assertArrayEquals(new int[]{}, emptyArray);
    }
}
