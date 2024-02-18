// Second Largest and Second Smallest Elements in an array 
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        int largestElement = a[0];
        int secondLargestElement = a[0];
        for(int i=1;i<n;i++) {
            if(a[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = a[i];
            } else if(a[i] > secondLargestElement && a[i] != largestElement) {
                secondLargestElement = a[i];
            }
        }
        int smallestElement = Integer.MAX_VALUE;
        int secondSmallestElement = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(a[i] < smallestElement) {
                secondSmallestElement = smallestElement;
                smallestElement = a[i];
            } else if(a[i] < secondSmallestElement && a[i] != smallestElement){
                secondSmallestElement = a[i];
            }
        }
        return new int[]{secondLargestElement, secondSmallestElement};
    }
}