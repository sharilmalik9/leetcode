// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
}
        if(sum %2!=0){
            return false;
        }
      int k=sum/2;
       boolean[][] dp= new boolean[nums.length][k];
        if(nums[0]<k){
             dp[0][nums[0]]=true;
        }
     //  dp[0][nums[0]]=true;
       for(int i=0;i<nums.length;i++){
           dp[i][0]=true;
       }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<k;j++){
                boolean notinclude=dp[i-1][j];
                boolean include=false;
                if(nums[i]<=j){
                    include=dp[i-1][j-nums[i]];
                    
                }
                dp[i][j]=include || notinclude;
                
                
                
}
        }
        
        
        return dp[nums.length-1][k-1];
        
    }
}