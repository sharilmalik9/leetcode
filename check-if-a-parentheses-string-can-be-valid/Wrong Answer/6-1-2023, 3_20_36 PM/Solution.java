// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid

class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0){
            return false;
        }
        int lock=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                lock++;
            }
            else{
                if(s.charAt(i)=='('){
                    st.push('(');
                }
                else{
                    if(st.size()==0){
                        lock--;

                    }
                    else{
                        st.pop();
                    }
                }
            }
        }
        while(st.size()!=0){
            st.pop();
            lock--;
        }
    
        if(lock<0){
            return false;
        }
        return true;
    }
}