/***
 * Takes the element and places it in its correct position
 */
public class Solution {
    public static void insertionSort(int[] arr, int size) {
        for(int i=0;i<size;i++) {
            for(int j=i;j>0&&arr[j-1] > arr[j];j--) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}