/*Merge Two Sorted Arrays
You are given two sorted arrays arr1 of size m and arr2 of size n. Your task is to merge these two arrays into a single sorted array without using any extra space (i.e., in-place merging). The elements in arr1 should be merged first, followed by the elements of arr2, resulting in both arrays being sorted after the merge.
*/
import java.util.Arrays;

public class day4 {
    static int findgap(int gap) {
        if (gap <= 1) return 0;
        return (gap + 1) / 2;
    }

    static void find(int[] arr1, int[] arr2, int n, int m) {
        int gap = n + m;
        while (gap > 0) {
            for (int i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }
            int i = (gap > n) ? n : 0;
            int j = (gap > n) ? gap - n : 0;
            while (i < n && j < m) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                i++;
                j++;
            }
            for (j = 0; j + gap < m; j++) {
                if (arr2[j] > arr2[j + gap]) {
                    int temp = arr2[j];
                    arr2[j] = arr2[j + gap];
                    arr2[j + gap] = temp;
                }
            }

            gap = findgap(gap);
        }
    }

    public static void main(String args[]) {
        int[] arr1 = {2, 7, 4};
        int[] arr2 = {9, 3, 5};
        find(arr1, arr2, arr1.length, arr2.length);

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
    }
}
