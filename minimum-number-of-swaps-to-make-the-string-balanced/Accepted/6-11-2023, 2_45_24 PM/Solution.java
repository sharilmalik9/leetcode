// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced

class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int count=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '[')
            {
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty() && s.charAt(i) == ']')
                {
                    st.pop();
                }else{
                    count++;
                }
            }
        }
        return (count+1)/2;
    }
}