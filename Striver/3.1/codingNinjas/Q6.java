import java.util.ArrayList;

/**
 * Problem statement
 * Given an array 'arr' with 'n' elements, the task is to rotate the array to the left by 'k' steps, where 'k' 
 * is non-negative.
 * 
 */
public class Solution {
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=k;i<arr.size();i++) {
            answer.add(arr.get(i));
        }

        for(int i=0;i<k;i++) {
            answer.add(arr.get(i));
        }

        return answer;
    }
}