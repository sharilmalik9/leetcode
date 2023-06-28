// https://leetcode.com/problems/majority-element-ii

class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int num1=0;
        int num2=0;
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                cnt1++;
            }
            else if(nums[i]==num2){
                cnt2++;
            }
            else if(cnt1==0){
                cnt1=1;
                num1=nums[i];
            }
            else if(cnt2==0){
                cnt2=1;
                num2=nums[i];
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                cnt1++;
                
            }
            else if(nums[i]==num2){
                cnt2++;
            }
        }
        
        List<Integer> ans= new ArrayList<>();
        if(cnt1>nums.length/3){
            ans.add(num1);
        }
        if(cnt2>nums.length/3){
            ans.add(num2);
        }
        return ans;
    }
}