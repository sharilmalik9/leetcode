// https://leetcode.com/problems/remove-invalid-parentheses

class Solution {
    HashSet<String> ans;
    int minremoves;
    public List<String> removeInvalidParentheses(String s){
        ans=new HashSet<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(1);
            }
            if(s.charAt(i)==')'){
                if(st.size()==0){
                    minremoves++;
                }
                else{
                    st.pop();
                }
            }
        }
        minremoves+=st.size();
        List<String> hehe=new ArrayList<>();
        rec(s,"",0,0,0,0);
         for(String str:ans){
            hehe.add(str);
        }
        return hehe;
        
    }
    public void rec(String s,String str,int open,int close,int removals,int idx){
        if(idx>=s.length()){
              if(open==close && removals==minremoves){
               ans.add(str); 
              }
              return;
        }
        if(close>open){
            return;
        }
       
        char curr=s.charAt(idx);
        // at current idx;
        if(curr-'a'>=0 && curr-'a'<26){
            rec(s,str+curr,open,close,removals,idx+1);
        }
        if(curr=='('){
          
            rec(s,str+curr,open+1,close,removals,idx+1);

        }
        else{
         
            rec(s,str+curr,open,close+1,removals,idx+1);
        }
        //  remove
        rec(s,str,open,close,removals+1,idx+1);

        
    }
}