// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int[] dp= new int[nums.length];
        if(nums.length==0){
            return true;
        }
        if(nums.length==1){
            return true;
        }
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==0){
                return false;
            }
            int element= nums[i];
             for(int j=1;j+i<nums.length;j++){
                 dp[j]=1;
             }
        }
        return dp[nums.length-1]==1;
        
        
        
        
        
    }
}