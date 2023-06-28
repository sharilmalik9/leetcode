// https://leetcode.com/problems/basic-calculator

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sum=0,sign = 1;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                int val = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                {
                    val = val*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                val = val*sign;
                sum+=val;
                sign = 1;
            }
            else if(ch == '(')
            {
                st.push(sum);
                st.push(sign);
                sum=0;sign=1;
            }
            else if(ch == ')')
            {
                sum *= st.pop();
                sum += st.pop();
            }
            else if(ch == '-')
                sign *= -1;
        }
        return sum;
    }
}