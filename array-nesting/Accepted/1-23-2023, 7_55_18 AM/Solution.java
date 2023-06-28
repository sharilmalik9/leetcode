// https://leetcode.com/problems/array-nesting

class Solution {
    public int arrayNesting(int[] nums) {
        int res=0;
        boolean[] visited = new boolean[nums.length];
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                int len = dfs(nums,i,visited,dp);
                res = Math.max(res,len);
            }
        }
        return res;
    }
    public int dfs(int[] nums,int i,boolean[] visited,int[] dp){
        if(visited[i]) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        visited[i] = true;
        return dp[i]=1+dfs(nums,nums[i],visited,dp);
    }
}