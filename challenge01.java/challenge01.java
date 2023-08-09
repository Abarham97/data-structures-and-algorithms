public class Main {
    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5, 6};
        int[] reversedArray = reverseArray(inputArray);
        
      
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
    }
    
    public static int[] reverseArray(int[] array) {
        int length = array.length;
        int[] reversed = new int[length];
        
        for (int i = 0; i < length; i++) {
            reversed[length - 1 - i] = array[i];
        }
        
        return reversed;
    }
}
