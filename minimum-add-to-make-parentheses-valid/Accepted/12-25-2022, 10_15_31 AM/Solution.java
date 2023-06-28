// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st= new Stack<>();
        int cnt=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')' && st.size()==0){
                cnt++;
            }
            else{
                st.pop();
            }
        }
        while(st.size()!=0){
            cnt++;
            st.pop();
        }
        return cnt;

    }
}