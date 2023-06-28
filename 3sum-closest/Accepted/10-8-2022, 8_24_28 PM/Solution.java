// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            
            int a = i + 1;
            int b = nums.length - 1;
            
            while(a < b){
                
                int curr_sum = nums[i] + nums[a] + nums[b];
                
                if(curr_sum > target){
                    b -= 1;
                }
                else{
                    a += 1;
                }
                
                if(Math.abs(curr_sum - target) < Math.abs(res - target)){
                    res = curr_sum;
                }  
            }
            
        }
        return res;
    }
}