/**
 * QUES 1 -> Matrix Cells in Disatance Order (LEETCODE - 1030)
 * 
 * Company - Adobe
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][];
        result[0] = new int[] {rCenter, cCenter};            // Add start point rCenter,cCenter which has distance 0.
        int resultIdx = 1;
        int lim = Math.max( rCenter, rows-rCenter-1 ) + Math.max( cCenter, cols-cCenter-1 );
		                                           // lim is highest distance value.
        for (int dist = 1; dist <= lim; dist++) {  // Process 'lim' diamond-shapes having distance 'dist'.
            int r = rCenter - dist;
            int c = cCenter;
            // Diamond side: Top Left
            for (int count = dist; count > 0; count--) {    
                if (r >= 0 && c >= 0)  result[resultIdx++] = new int[] {r, c};
                r++;
                c--;
            }
            
            // Diamond side: Left Bottom
            for (int count = dist; count > 0; count--) {
                if (r < rows && c >= 0)  result[resultIdx++] = new int[] {r, c};
                r++;
                c++;
            }
            
            // Diamond side: Bottom Right
            for (int count = dist; count > 0; count--) {
                if (r < rows && c < cols)  result[resultIdx++] = new int[] {r, c};
                r--;
                c++;
            }
            
            // Diamond side: Right Top
            for (int count = dist; count > 0; count--) {
                if (r >= 0 && c < cols)  result[resultIdx++] = new int[] {r, c};
                r--;
                c--;
            }
        }
        return result;
    }
}