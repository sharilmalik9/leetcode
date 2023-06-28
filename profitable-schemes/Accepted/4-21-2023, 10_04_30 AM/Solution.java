// https://leetcode.com/problems/profitable-schemes

class Solution {
    int mod = (int) (1e9 + 7);
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp= new int[minProfit+1][group.length+1][n+1];
        for(int[][] i: dp){
            for(int[] j : i){
                Arrays.fill(j,-1);
            }
        }
        return rec(group.length,minProfit,n,group,profit,0,dp);



        
    }
    public int rec(int n ,int currprofit,int ppl,int[] group,int[] profit,int idx,int[][][] dp){
        if(idx==n){
           return currprofit==0 ? 1 : 0;
            
        }
        if(dp[currprofit][idx][ppl]!=-1){
            return dp[currprofit][idx][ppl];
        }
        long p1=0;
        long p2=0;
        p1=rec(n,currprofit,ppl,group,profit,idx+1,dp);
        if(ppl>=group[idx]){
            p2=rec(n,Math.max(currprofit-profit[idx],0),ppl-group[idx],group,profit,idx+1,dp);
        }
        long p=p1+p2;
        p%=mod;
      
        return dp[currprofit][idx][ppl]= (int)p;
        

    }
}