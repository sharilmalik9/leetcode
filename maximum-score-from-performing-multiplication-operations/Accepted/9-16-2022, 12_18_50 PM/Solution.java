// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    int[][] dp=new int[1001][1001];
    public int maximumScore(int[] nums, int[] multipliers) {
      Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MIN_VALUE));
     return max(nums,multipliers,0,0);
    }
    int max(int[] nums,int[] m,int s,int i){
        if(i==m.length) return 0;
        if(dp[i][s]!=Integer.MIN_VALUE) return dp[i][s];
        int e=nums.length-(i-s)-1;
        int op1=nums[s]*m[i]+max(nums,m,s+1,i+1);
        int op2=nums[e]*m[i]+max(nums,m,s,i+1);
        return dp[i][s]=Math.max(op1,op2);
    }

}