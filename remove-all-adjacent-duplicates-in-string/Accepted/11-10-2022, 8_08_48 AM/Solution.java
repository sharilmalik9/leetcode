// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        char[] charArray = new char[stack.size()];
        for(int i = charArray.length - 1; i >= 0; i--) {
            charArray[i] = stack.pop();
        }
        return String.valueOf(charArray);
    }
}