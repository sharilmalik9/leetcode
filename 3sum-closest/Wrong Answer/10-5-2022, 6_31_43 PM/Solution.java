// https://leetcode.com/problems/3sum-closest

class Solution {
    public int threeSumClosest(int[] nums, int target){
        
        int fix=0;
        int start=1;
        int end=nums.length-1;
        int ans=nums[fix]+nums[start]+nums[end];
        for(int i=0;i<nums.length-2;i++){
            fix=i;
            start=fix+1;
            end=nums.length-1;
            int sum=nums[fix];
            System.out.println(sum);
            
            while(end>start){
                sum+=nums[start]+nums[end];
                System.out.println(sum);
               if(Math.abs(target-sum)<Math.abs(ans-target)){
                   ans=sum;
               }
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