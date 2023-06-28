// https://leetcode.com/problems/longest-square-streak-in-an-array

class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            int curr = nums[i];
            while(true){
                curr *= curr;
                if(set.contains(curr)){
                    count++;
                }
                else{
                    break;
                }
            }
            ans = Math.max(ans, count);
        }
        if(ans < 2)return -1;
        return ans;
    }
}