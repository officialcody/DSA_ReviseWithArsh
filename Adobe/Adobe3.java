/**
 * QUES 3 -> Find players with zero or one losses (LEETCODE - 2225)
 * 
 * Company - Adobe
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Approach 1 -> Storing Frequencies of winners and losers in map
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winners = new TreeMap<Integer, Integer>();
        Map<Integer, Integer> losers = new TreeMap<Integer, Integer>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<matches.length;i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            winners.put(winner, winners.getOrDefault(winner, 0) + 1);
            losers.put(loser, losers.getOrDefault(loser, 0) + 1);
        }
        Set<Integer> winnersList = new HashSet<Integer>();
        Set<Integer> losersList = new HashSet<Integer>();
        for(int i=0;i<matches.length;i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            if(losers.getOrDefault(winner, 0) == 0) {
                winnersList.add(winner);
            }
            if(losers.getOrDefault(loser, 0) == 1) {
                losersList.add(loser);
            }
        }
        answer.add(convertSetToList(winnersList));
        answer.add(convertSetToList(losersList));
        return answer;
    }

    public List<Integer> convertSetToList(Set<Integer> set) {
        List<Integer> answer = new ArrayList<Integer>();
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            answer.add(iter.next());
        }
        Collections.sort(answer);
        return answer;
    }

    // Solution 2 -> Storing the frequency of lost matches for each memeber present
    public List<List<Integer>> findWinners2(int[][] matches) {
        Map<Integer, Integer> lost = new HashMap<>();
        
        for (int[] m : matches) {
            lost.putIfAbsent(m[0], 0);
            lost.put(m[1], lost.getOrDefault(m[1], 0) + 1);
        }
        
        List<Integer> zero = lost.entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        
        List<Integer> ones = lost.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(zero);
        result.add(ones);
        
        return result;
    }
}