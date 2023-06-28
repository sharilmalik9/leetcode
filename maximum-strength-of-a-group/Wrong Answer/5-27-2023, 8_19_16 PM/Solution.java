// https://leetcode.com/problems/maximum-strength-of-a-group

class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int neg=0;
        long ans=1;
        
        for(int i:nums){
            if(i<0){
                neg++;
            }
            
        }
        
            for(int i:nums){
                if(i==0){
                    continue;
                }
                ans=ans*i;
            }
        if(neg==0){
            return ans;
        }
        boolean found=false;
        if(neg%2!=0){
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]<0 && !found){
                    ans=ans/nums[i];
                    found=true;
                }
            }
        }
       
        return ans;
        
    }
}