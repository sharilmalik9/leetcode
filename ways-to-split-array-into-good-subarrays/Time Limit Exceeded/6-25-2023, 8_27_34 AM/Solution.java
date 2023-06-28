// https://leetcode.com/problems/ways-to-split-array-into-good-subarrays

class Solution {
    int[] pre;
    int[] num;
    Integer[] dp;
    int mod=1000000007;
    public int numberOfGoodSubarraySplits(int[] nums) {
        num=nums;
        dp=new Integer[nums.length+1];
        pre=new int[nums.length];
        pre[0]=nums[0];
        dp[nums.length]=1;
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
            
        }
        for(int idx=nums.length-1;idx>=0;idx--){
            int ans=0;
        for(int i=idx;i<num.length;i++){
            if(num[idx]+pre[i]-pre[idx]==1){
                ans=(ans+dp[i+1])%mod;
            }
            
        }
             dp[idx]=ans%mod;
            
        }
        return dp[0];
        
        
    }
//     public int rec(int idx){
//         if(idx>=num.length){
//             return 1;
//         }
//         if(dp[idx]!=null){
//             return dp[idx];
//         }
//         int ans=0;
//         for(int i=idx;i<num.length;i++){
//             if(num[idx]+pre[i]-pre[idx]==1){
//                 ans=(ans+rec(i+1))%mod;
//             }
            
//         }
//         return dp[idx]=ans%mod;
//     }
}