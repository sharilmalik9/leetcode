// https://leetcode.com/problems/steps-to-make-array-non-decreasing

class Solution {
    public int totalSteps(int[] nums){
        Stack<Integer> st= new Stack<>();
        st.push(nums[0]);
        int cnt=0;
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(st.peek()>nums[i]){
                cnt++;
                
            }
            else{
                ans=Math.max(ans,cnt);
                cnt=0;
                st.push(nums[i]);
                
            }
        }
        
        
        return ans;
    }
}