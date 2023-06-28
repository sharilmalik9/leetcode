// https://leetcode.com/problems/minimum-cost-to-make-array-equal

class Solution {
    public long minCost(int[] nums, int[] cost) {

        int min = nums[0];
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }

        long res =getcost(nums, cost, min);

        while(min < max){
            int mid = min + (max-min)/2;

            long t1 = getcost(nums, cost, mid);
            long t2 = getcost(nums, cost, mid+1);

            res = Math.min(t1, t2);

            if(t1 < t2){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }

        return res;
    }

    public long getcost(int [] nums, int [] cost, int x){
        long ans = 0;
        for(int i=0; i<nums.length; i++){
            ans += (long)Math.abs(nums[i]-x)*cost[i];
        }
        return ans;
    }
    
}