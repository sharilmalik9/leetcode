// https://leetcode.com/problems/number-of-zero-filled-subarrays

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]==0){
                int curr=1;
                i++;
                ans++;
                while(i<nums.length && nums[i]==0){
                    curr++;
                    i++;
                    ans+=curr;

                }
            }
            else{
                i++;
            }

        }
        return ans;
    }
}