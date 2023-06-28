// https://leetcode.com/problems/minimum-cost-to-make-array-equal

class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int costf=0;
            for(int j=0;j<nums.length;j++){
                costf+=Math.abs(nums[j]-nums[i])*cost[j];
            }
            ans=Math.min(costf,ans);
        }
        return ans;
    }
}