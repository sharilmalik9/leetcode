// https://leetcode.com/problems/maximum-strength-of-a-group

class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
       // int[] arr= new int[nums.length];
        for(int i = 0; i < nums.length / 2; i++) {
            // Swapping the elements
            int j = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = j;
        }
     System.out.println(Arrays.toString(nums));
        int neg=0;
        long ans=1;
        boolean contain=false;
       
        
        for(int i:nums){
            if(i<0){
                neg++;
            }
        }
        if(neg%2==0){
            for(int i:nums){
                if(i==0){
continue;}
                ans=ans*i;
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0 && !(neg ==1 && nums.length==2)){
                    continue;
                }
                if(nums[i]<0 && !contain){
                    contain=true;
                    continue;
                }
                ans=ans*nums[i];
            }
        }
       
        return ans; 
    }
}