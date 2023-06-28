// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    // for number>1
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currSum = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        
        for(int i : nums) {
            currSum += i;
            int diff = currSum - k;
            
            res += mp.getOrDefault(diff,0);
            mp.put(currSum,mp.getOrDefault(currSum,0) + 1);
        }
        return res;
    }
}