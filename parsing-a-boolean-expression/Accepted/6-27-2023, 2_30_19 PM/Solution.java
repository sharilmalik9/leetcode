// https://leetcode.com/problems/parsing-a-boolean-expression

class Solution {

    public char find(boolean hasTrue, boolean hasFalse, char op){
        if(op == '!') return hasTrue? 'f' : 't';
        else if(op == '|') return hasTrue? 't' : 'f';
        else if(op == '&') return hasFalse? 'f' : 't';
        return 'a';
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        char[] exp = expression.toCharArray();
        for(char ch : exp){
            if(ch == ',') continue;
            if(ch != ')') st.push(ch);
            else{
                boolean hasTrue = false;
                boolean hasFalse = false;
                while(!st.isEmpty() && st.peek() != '('){
                    char top = st.pop();
                    if(top == 't') hasTrue = true;
                    else if(top == 'f') hasFalse = true;
                }
                st.pop(); // Removing the opening bracket
                char op = st.pop(); // Operator
                st.push(find(hasTrue,hasFalse,op));
            }
        }
        return st.peek() == 't';
    }
}