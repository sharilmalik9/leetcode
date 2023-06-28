// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses

class Solution {
    public int maxDepth(String s) {
       int c=0;
        int ans=0;
        if(s.length()==0){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
              c++;

            }
            else if(s.charAt(i)==')'){
               c--;
            }
           if(c>ans){
               ans=c;

           }
        }
        return ans;
        
    }
}