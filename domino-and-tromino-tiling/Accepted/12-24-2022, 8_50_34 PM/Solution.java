// https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
    public int numTilings(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        if(n >= 3){
        for(int i = 3; i <= n; i++){
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
			}
        }
        
        return dp[n] % mod;
    }

}