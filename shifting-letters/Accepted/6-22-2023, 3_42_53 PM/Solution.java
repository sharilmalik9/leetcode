// https://leetcode.com/problems/shifting-letters

class Solution {
    /**
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        int n = shifts.length;

        shifts[n - 1] %= 26;
        for (int i = n - 2; i >= 0; i--)
            shifts[i] = shifts[i] + shifts[i + 1] % 26;
        for (int j = 0; j < n; j++)
            chars[j] = (char) ((chars[j] - 'a' + shifts[j]) % 26 + 'a');
        return new String(chars);
    }
}