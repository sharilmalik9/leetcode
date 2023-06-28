// https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
       int max=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int[] freq= new int[max+1];
        int[] dp= new int[max+1];
        for(int i:nums){
            freq[i]+=1;
}
        dp[1]=Math.max(0,freq[1]*1);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],freq[i]*i+dp[i-2]);
        }
        
        return dp[dp.length-1];
    }
}