public class Solution {

    public static void mergeSort(int[] arr, int l, int r){
        if(l >= r) return;
        int mid = l + (r - l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int [] arr, int start, int mid, int end) {
        int len1 = mid - start + 1;
        int len2 = end - mid;

        int[] left = new int[len1];
        int[] right = new int[len2];

        int originalArrayIndex = start;
        for(int i=0;i<len1;i++) {
            left[i] = arr[originalArrayIndex];
            originalArrayIndex++;
        }
        // originalArrayIndex = mid + 1;
        for(int i=0;i<len2;i++) {
            right[i] = arr[originalArrayIndex];
            originalArrayIndex++;
        }
        originalArrayIndex = start;
        int index1 = 0;
        int index2 = 0;
        while(index1 < len1 && index2 < len2) {
            if(left[index1] < right[index2]) {
                arr[originalArrayIndex] = left[index1];
                index1++;
            } else {
                arr[originalArrayIndex] = right[index2];
                index2++;
            }
            originalArrayIndex++;
        }

        while(index1 < len1) {
            arr[originalArrayIndex] = left[index1];
            index1++;
            originalArrayIndex++;
        }

        while(index2 < len2) {
            arr[originalArrayIndex] = right[index2];
            index2++;
            originalArrayIndex++;
        }
    }
}
