// https://leetcode.com/problems/arithmetic-slices

public int numberOfArithmeticSlices(int[] nums) {
    int res = 0;
    for(int i =0; i<nums.length-1; i++){
        int diff = nums[i+1] - nums[i];
        for(int j = i+2; j<nums.length; j++){
            if(nums[j] - nums[j-1] == diff)res++;
            else break;
        }
    }
    return res;
}