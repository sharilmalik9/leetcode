// https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] input) {
        
        int m = input.length;        
        int n = input[0].length;

        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;
        
        for(int i = 0; i< m ; i++){
            for(int j = 0 ; j<n ; j++){
                int ans1 = 0;
        		int ans2 = 0;
                if( i == 0&& j == 0){
                    continue;
                }
                
                if(i > 0 && input[i-1][j]!=1){
            		ans1 = dp[i-1][j] ;     
                }
                if(j > 0  && input[i][j-1]!=1){
            		ans2 = dp[i][j-1] ;     
                }
               
                
                dp[i][j] = ans1 + ans2 ;
            }
        }
        
        return dp[m-1][n-1];
        
    }
}