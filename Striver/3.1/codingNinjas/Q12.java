import java.util.*;

public class Solution {
    public static int getSingleElement(int []arr){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
                break; 
            }
        }
        return answer;
    }
}