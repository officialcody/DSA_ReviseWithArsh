/**
 * Given an array 'arr' of size 'n'.
 * Return an array with all the elements placed in reverse order.
 */
public class Solution {
    public static int[] reverseArray(int n, int []nums) {
        reverseNumbersOfArray(nums, 0, n-1);
        return nums;
    }

    public static void reverseNumbersOfArray(int [] arr, int start, int end) {
        if(start > end) return;
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
        reverseNumbersOfArray(arr, start, end);
    }
}