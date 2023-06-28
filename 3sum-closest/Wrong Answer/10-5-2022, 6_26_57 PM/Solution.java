// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target){
        
        int fix=0;
        int start=1;
        int end=nums.length-1;
        int ans=nums[fix]+nums[start]+nums[end];
        for(int i=1;i<nums.length-2;i++){
            fix=i;
            start=fix+1;
            end=nums.length-1;
            int sum=nums[fix];
            
            while(end>start){
                sum+=nums[start]+nums[end];
                ans=Math.min(Math.abs(ans-target),Math.abs(sum-target));
                if(sum>target){
                    end--;
                }
                else{
                    start++;
                }
                
            }
            
        }
        
        
        return ans;
        
    }
}