// https://leetcode.com/problems/minimum-path-sum

class Solution {
    public int minPathSum(int[][] input) {
        
        int[][] dp = new int[input.length][input[0].length];
        
        dp[0][0] = input[0][0];
        
        for(int i = 0; i< input.length ; i++){
            for(int j = 0 ; j<input[0].length ; j++){
                int ans1 = Integer.MAX_VALUE;
        		int ans2 = Integer.MAX_VALUE;
                if( i == 0&& j == 0){
                    continue;
                }
                
                if(i > 0){
            		ans1 = dp[i-1][j] ;     
                }
                if(j > 0){
            		ans2 = dp[i][j-1] ;     
                }
               
                
                dp[i][j] = Math.min(ans1, ans2) + input[i][j];
            }
        }
        
        return dp[input.length - 1][input[0].length -1];
        
    }
}