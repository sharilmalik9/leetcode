// https://leetcode.com/problems/simplify-path

class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb= new StringBuilder();
        Stack<Character> st= new Stack<>();
        for(int i=0;i<path.length();i++){
            char curr= path.charAt(i);
            if(curr=='/'  && st.size()==0){
                st.push(curr);
            }
            else if(curr-'a'>=0 && curr-'a'<=26){
                st.push(curr);
            }
            else if(curr=='/'  && st.size()>0){
                StringBuilder now= new StringBuilder();
                while(st.size()>0){
                    
                    now.insert(0,st.pop());
}
                sb.append(now);
                
            }
            else if(curr=='.' && path.charAt(i+1)=='.'){
                while(st.size()>0){
                    st.pop();
                }
            }
          
            
            
        }
        return sb.toString();
        
    }
}