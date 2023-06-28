// https://leetcode.com/problems/partition-to-k-equal-sum-subsets

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
       int sum=0;
        for(int i:nums){
            sum+=i;
}
        if(sum %k!=0){
            return false;
        }
       k=sum/k;
       boolean[][] dp= new boolean[nums.length][k+1];
        if(nums[0]<k){
             dp[0][nums[0]]=true;
        }
     //  dp[0][nums[0]]=true;
       for(int i=0;i<nums.length;i++){
           dp[i][0]=true;
       }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<k+1;j++){
                boolean notinclude=dp[i-1][j];
                boolean include=false;
                if(nums[i]<=j){
                    include=dp[i-1][j-nums[i]];
                    
                }
                dp[i][j]=include || notinclude;
                
                
                
}
        }
        
        
        return dp[nums.length-1][k];
        
        
    }
}