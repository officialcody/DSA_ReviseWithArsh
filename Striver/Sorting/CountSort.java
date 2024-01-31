import java.util.*;

class Solution {
    public static void printArray(int [] arr) {
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Before Sorting: ");
        printArray(arr);
        countSort(arr, n);
        System.out.println("After Sorting");
        printArray(arr);
    }
    
    public static void countSort(int [] arr, int n) {
        int maxElement = arr[0];
        for(int i=1;i<n;i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        int [] frequency = new int[maxElement+1];
        Arrays.fill(frequency, 0);
        // Calculate Frequency of each element present in the array
        for(int i=0;i<n;i++) {
            frequency[arr[i]]++;
        }
        // Calculate Cumulative Frequency (this denotes the position of element at index in the sorted array)
        for(int i=1;i<maxElement;i++) {
            frequency[i] += frequency[i-1];
        }
        int answer[] = new int[n];
        // Traverse over each element in the original array to place each element as per sorted positions
        for(int i=n-1;i>=0;i--) {
            answer[--frequency[arr[i]]] = arr[i];
        }
        // Finally, copy the sorted array elements to answer array
        for(int i=0;i<n;i++) {
            arr[i] = answer[i];
        }
    }
}