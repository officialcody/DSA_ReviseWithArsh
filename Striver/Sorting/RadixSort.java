import java.util.*;

class Solution {
    // A utility function to get maximum value in arr[]
    public static int getMaximumElement(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            int lastDigit = (arr[i] / exp) % 10;
            count[lastDigit]++;
        }
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            int lastDigit = (arr[i] / exp) % 10;
            output[count[lastDigit] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
 
    // The main function to that sorts arr[] of
    // size n using Radix Sort
    public static void radixsort(int arr[], int n) {
        int maxElement = getMaximumElement(arr, n);
        for (int exp = 1; maxElement / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }
 
    // A utility function to print an array
    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;
        System.out.println("Before Sorting: ");
        printArray(arr, n);
        radixsort(arr, n);
        System.out.println("After Sorting: ");
        printArray(arr, n);
    }
}