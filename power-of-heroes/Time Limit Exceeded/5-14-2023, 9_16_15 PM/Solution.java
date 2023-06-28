// https://leetcode.com/problems/power-of-heroes

class Solution {
       int mod=1000000007;
    public int sumOfPower(int[] nums) {
        int[] dp= new int[nums.length+1];
        Arrays.fill(dp,-1);
        return help(nums,0,Integer.MIN_VALUE,Integer.MAX_VALUE,dp);
        
    }
    public int help(int[] nums,int idx,int max,int min,int[] dp){
        if(idx==nums.length){
            return max*max*min;
        }
      
        
        int dont=help(nums,idx+1,max, min,dp);
        if(max==Integer.MIN_VALUE){
            max=nums[idx];
        }
        if(min==Integer.MIN_VALUE){
            min=nums[idx];
        }
        if(nums[idx]>max){
            max=nums[idx];
        }
        if(nums[idx]<min){
            min=nums[idx];
        }
        int include=help(nums,idx+1,max,min,dp);
        return dp[idx] =(include+dont)%mod;
    }
}