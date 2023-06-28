// https://leetcode.com/problems/stone-game-iii

class Solution {
    int[] piles;
    int n;
    int ans = 0;
    int[][]  dp;
    public String stoneGameIII(int[] stoneValue) {
        this.piles = stoneValue;
        this.n = piles.length;
        this.dp  = new int[piles.length+1][2];
        for(int i[] : dp)  Arrays.fill(i,-1);
        int ans= f(0,true);
        int sum=0;
        for(int i:stoneValue){
            sum+=i;
        }
        if(ans>sum-ans){
            return "Alice";
        }
        else if(ans==sum-ans){
            return "Tie";
        }
        else{
            return "Bob";
        } 
    }
     public int f(int i, boolean turn){

        if(i == piles.length) {
            // ans = Math.max(ans,curr);
            return 0;
        }

        int k = turn ? 1:0;
        if(dp[i][k] != -1 ) return dp[i][k];
        if(turn){
            int ans2 = 0;
            int sum = 0;
            for(int x = 1; x<= 3 && i+x-1<n; x++){
                sum += piles[i+x-1];
                ans2 = Math.max(ans2, sum + f(i + x, !turn));
            }
            return dp[i][k] = ans2;

        }else{
            int ans1 = Integer.MAX_VALUE;
            for(int x = 1; x<= 3  && i+x-1<n; x++){
                ans1 = Math.min(ans1, f(i + x, !turn));
            }
            return dp[i][k]= ans1;
        }


        
    }
}