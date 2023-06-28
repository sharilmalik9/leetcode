// https://leetcode.com/problems/stone-game-ii

class Solution {
    int[] piles;
    int n;
    int ans = 0;
    int[][][]  dp;
    public int stoneGameII(int[] piles) {
        this.piles = piles;
        this.n = piles.length;
        this.dp  = new int[piles.length][piles.length*2 + 1][2];
        for(int i[][] : dp) for(int j[] : i) Arrays.fill(j,-1);
        return f(0,1,true);
    }
    public int f(int i, int m, boolean turn){

        if(i == piles.length) {
            // ans = Math.max(ans,curr);
            return 0;
        }

        int k = turn ? 1:0;
        if(dp[i][m][k] != -1 ) return dp[i][m][k];
        if(turn){
            int ans2 = 0;
            int sum = 0;
            for(int x = 1; x<= 2*m && i+x-1<n; x++){
                sum += piles[i+x-1];
                ans2 = Math.max(ans2, sum + f(i + x, Math.max(x,m), !turn));
            }
            return dp[i][m][k] = ans2;

        }else{
            int ans1 = Integer.MAX_VALUE;
            for(int x = 1; x<= 2*m  && i+x-1<n; x++){
                ans1 = Math.min(ans1, f(i + x, Math.max(x,m), !turn));
            }
            return dp[i][m][k]= ans1;
        }


        
    }
    
    
}