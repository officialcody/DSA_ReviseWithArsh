/**
 * QUES 2 -> High-Access Employees (LEETCODE - 2933)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {

    // Approach 1 - Check if an employee has high access or not using Sliding Window technique
    public boolean isHighAccess(List<Integer> list) {
        int n = list.size();

        for(int i=2;i<n;i++) {
            int currentTime = list.get(i);
            int prevTime = list.get(i - 2);
            if(prevTime + 59 >= currentTime) {
                return true;
            }
        }
        return false;
    }

    // Approach 1 - Find High Access employees by converting String values of time(hhmm) to minutes
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(int i=0;i<access_times.size();i++) {
            List<String> list = access_times.get(i);
            String employee = list.get(0);
            String time = list.get(1);
            if(!map.containsKey(employee)) {
                map.put(employee, new ArrayList<Integer>());
            }
            map.get(employee).add(convertStringToValue(time));
        }
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String employee = entry.getKey();
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            if(isHighAccess(list)) {
                answer.add(employee);
            }
        }
        return answer;
    }

    // Approach 2 - Check if an employee has high access or not using Sliding Window technique
    public boolean isHighAccess2(List<Integer> list) {
        int n = list.size();

        for(int i=2;i<n;i++) {
            int currentTime = list.get(i);
            int prevTime = list.get(i - 2);
            if(prevTime + 99 >= currentTime) {
                return true;
            }
        }
        return false;
    }

    // Approach 2 - Find High access employees without time conversion
    public List<String> findHighAccessEmployees2(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(int i=0;i<access_times.size();i++) {
            List<String> list = access_times.get(i);
            String employee = list.get(0);
            String time = list.get(1);
            if(!map.containsKey(employee)) {
                map.put(employee, new ArrayList<Integer>());
            }
            int t = Integer.parseInt(time);
            map.get(employee).add(t);
        }
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String employee = entry.getKey();
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            if(isHighAccess2(list)) {
                answer.add(employee);
            }
        }
        return answer;
    }

    // Approach 1 - Convert String values of time(hhmm) to minutes
    public int convertStringToValue(String str) {
        return (Character.getNumericValue(str.charAt(0)) * 60 * 10)  + (Character.getNumericValue(str.charAt(1)) * 60) + (Character.getNumericValue(str.charAt(2)) * 10) + Character.getNumericValue(str.charAt(3));
    }
}