// https://leetcode.com/problems/longest-increasing-path-in-a-matrix

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
		
        int max = 0;

        dp = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
		
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
				// initially prev = -1
				// x stores the max length of increasing path starting from (i,j) in the matrix
                int x = s(matrix, i, j, vis, -1);
                max = Math.max(x, max);
            }
        }
        return max;
    }
    int[][] dp;
    int s(int[][] arr, int i, int j, boolean[][] vis, int prev){
        if((i<0 || j<0 || i>=arr.length || j>=arr[0].length || vis[i][j] || arr[i][j]<=prev) && prev!=-1)
			return 0;

        if(dp[i][j]!=-1)
			return dp[i][j];
		
        vis[i][j] = true;
        int a = s(arr, i-1, j, vis, arr[i][j]); // top
        int b = s(arr, i+1, j, vis, arr[i][j]); // down
        int c = s(arr, i, j-1, vis, arr[i][j]); // left
        int d = s(arr, i, j+1, vis, arr[i][j]); // right
		
        vis[i][j] = false; // backtrack
        return dp[i][j] = 1+Math.max(a, Math.max(b, Math.max(c, d)));
    }
}