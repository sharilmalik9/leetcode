// https://leetcode.com/problems/removing-stars-from-a-string

class Solution {
    public String removeStars(String s) {
        Stack<Character> st= new Stack<>();
    for(int i=0;i<s.length();i++){
        Character ch= s.charAt(i);
        if(ch=='*'){
            st.pop();
        }
        else{
            st.push(ch);
        }
    } 
        String ans="";
        if(st.size()==0){
            return "";
}
        else{
            while(st.size()!=0){
                ans+=st.pop();
            }
        }
        String ansf="";
        for(int i=ans.length()-1;i>=0;i--){
            ansf+=ans.charAt(i);
        }
        return ansf;
    }
}