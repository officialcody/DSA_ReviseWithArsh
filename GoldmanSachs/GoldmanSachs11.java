/**
 * QUES 11 -> Map of Highest Peak (LEETCODE - 1765)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    private class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    int [] dr = {1, 0, -1, 0};
    int [] dc = {0, 1, 0, -1};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int [][] heights = new int[n][m];
        for(int[] row : heights) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(isWater[i][j] == 1) {
                    heights[i][j] = 0;
                    queue.add(new Pair(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.first;
            int col = current.second;
            for(int i=0;i<4;i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && heights[nr][nc] > 1+heights[row][col]) {
                    heights[nr][nc] = 1 + heights[row][col];
                    queue.add(new Pair(nr, nc));
                }
            }
        }
        return heights;
    }
}