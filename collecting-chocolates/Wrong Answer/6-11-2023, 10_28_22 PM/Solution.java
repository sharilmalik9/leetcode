// https://leetcode.com/problems/collecting-chocolates

class Solution {
    public long minCost(int[] nums, int x) {
        int n=nums.length;
        int[] costs=new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        long ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            long cost=0;
            for(int j=0;j<n;j++){
                costs[j]=Math.min(nums[(j+i)%n],costs[j]);
                cost+=costs[j];
            }
            cost+=x*i;
            ans=Math.min(ans,cost);
        }
        return ans;
    }
}