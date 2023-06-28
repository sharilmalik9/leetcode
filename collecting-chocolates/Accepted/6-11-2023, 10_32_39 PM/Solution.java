// https://leetcode.com/problems/collecting-chocolates

class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long sum = 0;
        long temp[] = new long[n];
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            temp[i] = nums[i];
        }

        for(int rotation = 1; rotation < n ; rotation++ ){
            long cost = 1L * rotation * x;

            for(int i = 0 ; i < n ; i++){
                long val = nums[(rotation+i)% n];
                temp[i] = Math.min(temp[i],val);
                cost += temp[i];
            }

            sum = Math.min(sum,cost);
        }
        return sum;

    }
}