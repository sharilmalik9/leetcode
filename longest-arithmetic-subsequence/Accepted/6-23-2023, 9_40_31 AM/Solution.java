// https://leetcode.com/problems/longest-arithmetic-subsequence

// class Solution {
//     Integer[][][] dp;
//     public int longestArithSeqLength(int[] nums) {
//         dp=new Integer[nums.length+1][nums.length+1][1002];
//         return rec(0,1001,-1,nums);
        
//     }
//     public int rec(int idx,int diff,int prev,int[] nums){
//         if(idx>=nums.length){
//             return 0;
//         }
//         if()
//         int ans=0;
//         //dont include
//         ans=rec(idx+1,diff,prev,nums);
//         // include
//         if(prev==-1){
//             ans=Math.max(1+rec(idx+1,diff,idx,nums),ans);
//         }
//         else if(diff==1001){
//             ans=Math.max(1+rec(idx+1,nums[idx]-nums[prev],idx,nums),ans);
//         }
//         else if(nums[idx]-nums[prev]==diff){
//             ans=Math.max(1+rec(idx+1,diff,idx,nums),ans);
//         }
//         return ans;
//     }
// }
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int dp[][] = new int[nums.length][1001];
        int max = 0;
        for(int i = 1; i<nums.length; i++){
            for(int j = i-1; j >= 0; j--){
                int dif = 500 + nums[i] - nums[j];
                dp[i][dif] = Math.max(dp[i][dif], dp[j][dif]+1);
                max = Math.max(max, dp[i][dif]);
            }
        }
        return max+1;
    }
}
