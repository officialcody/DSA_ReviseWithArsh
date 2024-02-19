import java.util.*;
/**
 * Merge 2 Sorted Array
 * Link: https://www.codingninjas.com/studio/problems/sorted-array_6613259?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
 */
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        TreeSet<Integer> unionSet = new TreeSet<>();
        for (int num : a) {
            unionSet.add(num);
        }

        for (int num : b) {
            unionSet.add(num);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int value: unionSet) {
            answer.add(value);
        }

        return answer;
    }
}

// My Solution -> Failing 1 test case
public class Solution2 {
    public static List< Integer > sortedArray(int []a, int []b) {
        List<Integer> answer = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while(indexA < a.length && indexB < b.length) {
            if(a[indexA] < b[indexB]) {
                if(!answer.contains(a[indexA])) {
                    answer.add(a[indexA]);
                }
                indexA++;
            } else {
                if(!answer.contains(b[indexB])) {
                    answer.add(b[indexB]);
                }
                indexB++;
            }
        }

        while(indexA < a.length) {
            if(!answer.contains(a[indexA])) {
                answer.add(a[indexA]);
            }
            indexA++;
        }

        while(indexB < b.length) {
            if(!answer.contains(b[indexB])) {
                answer.add(b[indexB]);
            }
            indexB++;
        }
        return answer;
    }
}