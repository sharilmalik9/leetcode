// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();
      
        for(int i:asteroids){
            while(st.size()!=0  && st.peek()>0 && st.peek()<-1*i){
                st.pop();
            }
            if(st.size()==0 || st.peek()<0 || i>0){
                st.push(i);
            }
            else if( st.peek()==-1*i){
                st.pop();
               
                
                
                
}
        }
        
        int[] ans= new int[st.size()];
        int idx=ans.length-1;
        while(st.size()!=0){
            ans[idx]=st.pop();
            idx--;
        }
        
        return ans;
        
    }
}