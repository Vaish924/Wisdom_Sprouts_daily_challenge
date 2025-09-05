import java.util.*;

public class FirstElementToRepeatKTimes {
    public static int firstElementKTimes(int[] arr, int k) {
        // Use HashMap to store frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Traverse array and update frequency
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Traverse again in order to find the first element with frequency = k
        for (int num : arr) {
            if (freqMap.get(num) == k) {
                return num;
            }
        }

        // If no element found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k = 2;

        int result = firstElementKTimes(arr, k);
        System.out.println("Output: " + result);
    }
}
