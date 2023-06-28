// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string

class Solution {
    public int minInsertions(String s){
        Stack<Character> st=new Stack<>();
        int idx=s.length()-1;
        int ans=0;
        while(idx>=0){

            if(s.charAt(idx)==')'){
                st.push(')');
            }
            else{
                System.out.println(st.size());
                if(st.size()==1){
                    st.pop();
                    ans++;
                }
                else if(st.size()==0){
                    ans+=2;
                }
                else{
                    st.pop();
                    st.pop();

                }

            }
            idx--;
        }
        if(st.size()!=0){
            if(st.size()%2==0){
                ans+=st.size()/2;
            }
            else{
                ans+=(st.size()+1)/2+1;
            }
        }
        return ans;
        
    }
}