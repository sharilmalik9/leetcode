// https://leetcode.com/problems/steps-to-make-array-non-decreasing

class Solution {
    public int totalSteps(int[] nums){
        Stack<Integer> st= new Stack<>();
        st.push(0);
        int[] arr= new int[nums.length];
       int maxcnt=0;
        for(int i=1;i<nums.length;i++){
            int cnt=0;
            while(st.size()!=0 && nums[i]>=nums[st.peek()]){
                cnt=Math.max(cnt,arr[st.peek()]);
                st.pop();
            }
            if(!st.isEmpty()&&nums[i]<nums[st.peek()]){
                arr[i]=cnt+1;
            }
            maxcnt=Math.max(maxcnt,arr[i]);
            st.push(i);
           
        }
        
        
        return maxcnt;
    }
}