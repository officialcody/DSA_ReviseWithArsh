/**
 * QUES 3 -> Query Kth Smallest Trimmed Number (LEETCODE - 2343)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Create a Pair class to store the trimmed String and the index at which the strings occurs in the main array
    private class Pair {
        String str;
        int index;

        Pair(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }
    
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        // Create a map consisting indexs and String after trimming
        for(int i=0;i<nums.length;i++) {
            String str = nums[i];
            int n = str.length();
            int l = n;
            for(int j=0;j<n;j++) {
                map.putIfAbsent(l, new ArrayList<>());
                Pair pair = new Pair(str.substring(j), i);
                map.get(l--).add(pair);
            }
        }

        int [] answer = new int[queries.length];
        int index = 0;
        // Iterate over each query to find the kth smallest element 
        for(int[] query : queries) {
            int k = query[0];
            int trim = query[1];
            List<Pair> list = map.get(trim);
            // Sort the list of Pair according to index if the strings are same.
            Collections.sort(list, (p1, p2) -> {
                return p1.str.equals(p2.str) ? p1.index - p2.index : p1.str.compareTo(p2.str);
            });
            answer[index++] = list.get(k-1).index;
        }
        return answer;
    }
}