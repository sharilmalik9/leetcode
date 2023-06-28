// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Character> str= new Stack<>();
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            if(sc=='(' || sc=='[' || sc=='{'){
                str.push(sc);
            }
            else{
                if(sc==')'){
                    if(str.pop()!='('){
                        return  false;
                    }
                }
                 if(sc==']'){
                    if(str.pop()!='['){
                        return  false;
                    }
                }
                 if(sc=='}'){
                    if(str.pop()!='{'){
                        return  false;
                    }
                }
            }
        }
        return true;
    }
}