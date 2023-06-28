// https://leetcode.com/problems/reducing-dishes

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int[][] dp= new int[satisfaction.length+1][satisfaction.length+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        Arrays.sort(satisfaction);
        return rec(satisfaction,0,1,dp);
        
    }
    public int rec(int[] s,int idx,int time ,int[][] dp){
        if(idx>=s.length){
            return 0;
        }
        if(dp[idx][time]!=-1){
            return dp[idx][time];

        }
        if(s[idx]>=0){
            return dp[idx][time]=s[idx]*time +rec(s,idx+1,time+1,dp);
        }
        return dp[idx][time]=Math.max(s[idx]*time+rec(s,idx+1,time+1,dp),rec(s,idx+1,time,dp));

    }
}