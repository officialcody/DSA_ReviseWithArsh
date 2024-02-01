/**
 * QUES 4 -> Sort Characters by Frequency (LEETCODE - 541)
 * 
 * Company - Walmart
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
import java.util.*;

// Solution 1: Using HashMap and Sorting
class Solution1 {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> charCountMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        charCountMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(record -> {
                    Character key = record.getKey();
                    int value = record.getValue();
                    for (int i = 0; i < value; i++) {
                        sb.append(key);
                    }
                });
        return sb.toString();
    }
}

// Solution 2: Using Heap i.e. PriorityQueue
class Solution2 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
	    for (char c: s.toCharArray()) {
		    map.put(c, map.getOrDefault(c, 0) + 1);
	    }
        
        //heap
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->(map.get(b)-map.get(a) ) ); //for decreasing order
        pq.addAll(map.keySet());
        
        //putting in string builder
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            for(int i =0;i<map.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

// Solution 3:
class Solution3 {

    public record Pair<L, R>(L left, R right) {
        static <L, R> Pair<L, R> create(L l, R r) {
            return new Pair<>(l, r);
        }
    }

    public String frequencySort(String s) {
           System.gc();
        int[] histogram = new int[128];
        for (char c : s.toCharArray()) {
            ++histogram[c];
        }
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] != 0) {
                Pair<String, Integer> stringIntegerPair = Pair.create(String.valueOf((char) i), histogram[i]);
                list.add(stringIntegerPair);
            }
        }
        list.sort(Comparator.comparing(Pair::right, Comparator.reverseOrder()));
        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(element -> stringBuilder.append(element.left().repeat(element.right())));
        return stringBuilder.toString();
    }
}