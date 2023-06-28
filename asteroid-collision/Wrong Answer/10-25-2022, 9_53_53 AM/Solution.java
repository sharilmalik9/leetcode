// https://leetcode.com/problems/asteroid-collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();
      
        for(int i:asteroids){
            if(st.size()!=0){
                if(i<0){
                    int element=st.pop();
                    if(element>-i){
                        st.push(element);
                    }
                    else if(element<-i){
                        while(st.size()!=0 && -i>st.peek()){
                            st.pop();
                        }
                       
                    }
                }
                else{
                    st.push(i);
                }
                    
              
                
            }
                
            else{
                st.push(i);
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