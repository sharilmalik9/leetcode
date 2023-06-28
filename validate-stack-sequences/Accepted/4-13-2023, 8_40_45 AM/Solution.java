// https://leetcode.com/problems/validate-stack-sequences

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st= new Stack<>();
        int push=0;
        int pop=0;
        while(push!=pushed.length){
             st.push(pushed[push]);
            push++;
            while(st.size()!=0 &&  st.peek()==popped[pop]){
               st.pop();
               
                pop++;
            }
           
        }
        while(st.size()!=0 &&  st.peek()==popped[pop]){
                st.pop();
                pop++;
            }
            System.out.println(pop);
  
      if(pop==popped.length){
          return true;
      }
      return false;

    }
}