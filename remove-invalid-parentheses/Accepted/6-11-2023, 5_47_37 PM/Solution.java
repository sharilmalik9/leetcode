// https://leetcode.com/problems/remove-invalid-parentheses

// class Solution {
//     HashSet<String> ans;
//     int minremoves;
//     public List<String> removeInvalidParentheses(String s){
//         ans=new HashSet<>();
//         Stack<Integer> st=new Stack<>();
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='('){
//                 st.push(1);
//             }
//             if(s.charAt(i)==')'){
//                 if(st.size()==0){
//                     minremoves++;
//                 }
//                 else{
//                     st.pop();
//                 }
//             }
//         }
//         minremoves+=st.size();
//         List<String> hehe=new ArrayList<>();
//         rec(s,new StringBuilder(),0,0,0,0);
//          for(String str:ans){
//             hehe.add(str);
//         }
//         return hehe;
//     }
//     public void rec(String s,StringBuilder str,int open,int close,int removals,int idx){
//         if(idx>=s.length()){
//               if(open==close && removals==minremoves){
//                ans.add(str.toString()); 
//               }
//               return;
//         }
//         if(close>open){
//             return;
//         }
//         char curr=s.charAt(idx);
//         // at current idx;
//         if(curr-'a'>=0 && curr-'a'<26){
//             str.append(curr);
//             rec(s,str,open,close,removals,idx+1);
//             str.deleteCharAt(str.length()-1);
//         }
//         else if(curr=='('){
//              str.append(curr);
//             rec(s,str,open+1,close,removals,idx+1);
//              str.deleteCharAt(str.length()-1);

//         }
//         else{
//              str.append(curr);
//             rec(s,str,open,close+1,removals,idx+1);
//              str.deleteCharAt(str.length()-1);
//         }
//         //  remove
//         rec(s,str,open,close,removals+1,idx+1);

        
//     }
// }
class Solution {
    public List<String> removeInvalidParentheses(String s) {
 List<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<String>();
        
        int minBracket=removeBracket(s);
        getAns(s, minBracket,set,ans);
        
        return ans;
    }
    
    public void getAns(String s, int minBracket, HashSet<String> set, List<String> ans){
        if(set.contains(s)) return;
        set.add(s);
        if(minBracket==0){
            int remove=removeBracket(s);   
            if(remove==0) ans.add(s);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='(' && s.charAt(i)!=')') continue;
            String L=s.substring(0,i);
            String R=s.substring(i+1);
            if(!set.contains(L+R)) getAns(L+R,minBracket-1,set,ans);
        }
    } 
    public int removeBracket(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='(') stack.push(x);
            else if(x==')'){
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else stack.push(x);
            } 
        }
        return stack.size();
    }
}