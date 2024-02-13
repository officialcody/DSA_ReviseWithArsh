/**
 * QUES 7 -> Top K Frequent words (LEETCODE - 692)
 * 
 * Company - Walmart
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
// Approach 1: Using HashMap, PriorityQueue and Comparator
class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for(int i=0;i<words.length;i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if((b.getValue() - a.getValue()) == 0) {
                    return b.getKey().compareTo(a.getKey());
                }
                return a.getValue() - b.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            queue.add(entry);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        List<String> answer = new ArrayList<String>();
        while(!queue.isEmpty()) {
            answer.add(0, queue.poll().getKey());
        }
        return answer;
    }
}

// Approach 2: Using HashMap, PriorityQueue and Comparable

class Solution2 {
    private class Frequency implements Comparable<Frequency>{
        int count = 1;
        String word;

        public Frequency(String word){
            this.word = word;
        }

        public int compareTo(Frequency input){
            if(this.count != input.count){
                return this.count - input.count;
            }
            // this part we're doing in reverse reverse so minHeap
            return input.word.compareTo(this.word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Frequency> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<String,Frequency> map = new HashMap<>();

        for(String word: words){
            if(map.containsKey(word)){
                map.get(word).count++;
            }
            else{
                map.put(word,new Frequency(word));
            }
        }

        for(Frequency freq : map.values()){
            maxHeap.add(freq);
        }

        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < k; i++){
            answer.add(maxHeap.poll().word);
        }

        return answer;
    }
}