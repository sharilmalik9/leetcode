// https://leetcode.com/problems/best-sightseeing-pair

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] dp= new int[values.length];
        dp[0]=values[0];
        for(int i=1;i<values.length;i++){
            dp[i]=Math.max(dp[i-1],values[i]+i);
        }
        values[values.length-1]=values[values.length-1]-(values.length-1);
        for(int i=values.length-2;i>=0;i--){
            values[i]=Math.max(values[i]-i,values[i+1]);
        }
      
        int max=0;
        for(int i=0;i<dp.length-1;i++){
            max=Math.max(dp[i]+values[i+1],max);
        }
        
        
        
        return max;
        
    }
}