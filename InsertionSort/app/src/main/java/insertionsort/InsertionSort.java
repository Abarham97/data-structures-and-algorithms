package insertionsort;
public class InsertionSort {
    public static int[] insertionSort(int[] input) {
        int n = input.length;
        for (int i = 1; i < n; i++) {
            int value = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > value) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = value;
        }
        return input;
    }

    public static void main(String[] args) {
        int[] sampleArray = {8, 4, 23, 42, 16, 15};
        int[] sortedArray = insertionSort(sampleArray);

        System.out.println("Sorted Array: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}

