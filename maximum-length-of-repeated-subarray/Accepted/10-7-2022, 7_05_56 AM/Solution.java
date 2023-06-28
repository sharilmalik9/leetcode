// https://leetcode.com/problems/maximum-length-of-repeated-subarray

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int i, j;
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n+1][m+1];
        
        for(i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        
        for(j=0;j<=m;j++){
            dp[0][j] = 0;
        }
        
        int ans = 0;
        
        for(i=1;i<=n;i++){
            for(j=1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if(dp[i][j] > ans){
                    ans = dp[i][j];
                }
            }
        }
        
        return ans;
    }
}