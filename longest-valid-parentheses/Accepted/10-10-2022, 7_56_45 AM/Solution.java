// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stk = new Stack<>();
        char[] arr = s.toCharArray();
        
        int count =0;
        int res=0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='('){
                stk.push(i);
            }
            else if(arr[i]==')' && stk.size()>0){
                stk.pop();
            }
            else if(arr[i]==')' && stk.size()==0){
                arr[i]='.';
            }
        }
        
        while(stk.size()>0){
            arr[stk.pop()]= '.';
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='(' || arr[i]==')'){
                count++;
            }
            else{
                res = Math.max(res, count);
                count=0;
            }
        }
        return Math.max(res,count);
    }
}