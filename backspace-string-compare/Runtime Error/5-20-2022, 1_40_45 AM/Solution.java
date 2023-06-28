// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        String ans1="";
        String ans="";
        Stack<String> verify= new Stack<>();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)!='#'){
                verify.push(s.substring(i,i+1));

            }
            else{
                if(!s.isEmpty()){
                verify.pop();
                }
            }

        }
        Stack<String> verify1= new Stack<>();
        for(int i=0;i<t.length();i++){

            if(t.charAt(i)!='#'){
                verify1.push(t.substring(i,i+1));

            }
            else{
                if(!t.isEmpty()){
                verify1.pop();
                }
            }

        }
        String okay="";
        while(!verify.isEmpty()){
            okay+=verify.peek();
            verify.pop();

        }
        String okay1="";
        while(!verify1.isEmpty()){
            okay1+=verify1.peek();
            verify1.pop();

        }

        if(okay.compareTo(okay1)==0){
            return true;
        }
        else{
            return false;
        }
        
    }
}