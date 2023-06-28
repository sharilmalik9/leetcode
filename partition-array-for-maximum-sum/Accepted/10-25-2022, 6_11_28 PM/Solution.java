// https://leetcode.com/problems/partition-array-for-maximum-sum

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp= new int[arr.length];
        Arrays.fill(dp,-1);
        return help(arr,0,k,dp);
        
    }
    public int help(int[] arr,int idx, int k,int[] dp){
        if(idx==arr.length){
            return 0;
        }
        if (dp[idx]!=-1){
            return dp[idx];
        }
        int max=Integer.MIN_VALUE;
        int maxSum=Integer.MIN_VALUE;
        int len=0;
        
        for(int j=idx;j<Math.min(idx+k,arr.length);j++){
            len++;
            max=Math.max(max,arr[j]);
            maxSum=Math.max(maxSum,max*len+help(arr,j+1,k,dp));
            
            
        }
        return dp[idx]=maxSum;
    }
}