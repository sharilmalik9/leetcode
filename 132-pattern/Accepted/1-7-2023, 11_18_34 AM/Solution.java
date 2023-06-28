// https://leetcode.com/problems/132-pattern

class Solution {
    public boolean find132pattern(int[] nums){
           Stack<Integer> st=new Stack<>();
           int second=Integer.MIN_VALUE;
          for(int i=nums.length-1;i>=0;i--){
              if(nums[i] < second){
                  return true;
              }
              while(st.size()!=0 && nums[i]> st.peek()){
                  second=Math.max(second,st.pop());
              }
              st.add(nums[i]);
          }



          return false;
        
    }
}