// https://leetcode.com/problems/jump-game-ii

class Solution {
public 
    int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int maxReach = 0;
        int curReach = 0;
        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == curReach) {
                jumps++;
                curReach = maxReach;
                if (curReach >= n-1)
                    return jumps;
                if (i >= maxReach)
                    return 0;
            }
        }
        return jumps;
    }
}