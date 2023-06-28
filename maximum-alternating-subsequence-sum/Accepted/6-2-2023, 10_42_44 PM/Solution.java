// https://leetcode.com/problems/maximum-alternating-subsequence-sum

class Solution {
    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        dp=new long[nums.length+1][2];
        for(long[] i:dp){
            Arrays.fill(i,-1);
        }
    
        return rec(nums,0,true);
    }
    public long rec(int[] nums,int idx,boolean odd){
        if(idx==nums.length){
            return 0;
        }
        long include=0;
        int k=1;
        if(odd){
            k=0;
        }
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        
        if(odd){
            include=rec(nums,idx+1,!odd)+nums[idx];
        }
        else{
            include=rec(nums,idx+1,!odd)-nums[idx];
        }
        long dont=rec(nums,idx+1,odd);
        return dp[idx][k]=Math.max(include,dont);
    }
}