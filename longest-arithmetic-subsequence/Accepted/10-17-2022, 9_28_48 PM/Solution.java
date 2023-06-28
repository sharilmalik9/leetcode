// https://leetcode.com/problems/longest-arithmetic-subsequence

class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Integer,Integer>[] dp= new HashMap[nums.length];
         int ans=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
           int val=nums[i];
          
           dp[i]=new HashMap<>();
           for(int j=0;j<i;j++){
               int diff=val-nums[j];
               dp[i].put(diff,dp[j].getOrDefault(diff,1)+1);
               ans=Math.max(ans,dp[i].get(diff));
           }
       }
        return ans;
    }
}