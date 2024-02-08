/**
 * QUES 4 -> Cinema Seat Allocation (LEETCODE - 1386)
 * 
 * Company - Adobe
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Each row has 3 possible group positions: "left", "middle", and "right".
        // Keep track of which positions are unavailable (blocked).
        Map<Integer, Set<String>> blocked = new HashMap<>();

        // Iterate over all reserved seats, indicating which positions are blocked.
        for (int[] reservation : reservedSeats) {
            int row = reservation[0];
            int col = reservation[1];

            // Reservations in columns 1 and 10 don't block 4-person positions.
            if (col == 1 || col == 10) {
                continue;
            }

            // Retrieve the set for this row, creating it if it didn't exist.
            Set<String> set = blocked.computeIfAbsent(row, k -> new HashSet<>());

            // Add strings indicating which of the 3 positions are blocked.
            if (col >= 2 && col <= 5) {
                set.add("left");
            }
            if (col >= 4 && col <= 7) {
                set.add("middle");
            }
            if (col >= 6 && col <= 9) {
                set.add("right");
            }
        }

        // The variable total will hold the number of 4-person positions available.
        // Initialize it with 2 for each row that does not have any blocked positions.
        int total = 2 * (n - blocked.size());

        // Map the number of positions blocked to the number available.
        int[] numAvailable = {
            2, // if no positions are blocked, 2 are available
            1, // if one position is blocked, 1 is available
            1, // if two positions are blocked, 1 is available
            0  // if all 3 positions are blocked, none are available 
        };

        // For each row having blocks, add the number of available positions.
        for (Set<String> blocks : blocked.values()) {
            total += numAvailable[blocks.size()];
        }
        
        return total;
    }
}