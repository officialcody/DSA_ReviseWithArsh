/**
 * QUES 1 -> Image Smoother (LEETCODE - 661)
 * 
 * Company - Microsoft
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */

 class Solution {
    public int[][] imageSmoother(int[][] img) {
        int [] moves = new int[]{-1, 0, 1};
        int m = img.length;
        int n = img[0].length;
        int [][] res = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int cnt = 0;
                int val = 0;
                for(int a: moves) {
                    for(int b: moves) {
                        int x = i + a;
                        int y = j + b;
                        if(x < 0 || x >= m || y < 0 || y >= n) continue;
                        cnt++;
                        val += img[x][y];
                    }
                }
                res[i][j] = val/cnt;
            }
        }
        return res;
    }
}