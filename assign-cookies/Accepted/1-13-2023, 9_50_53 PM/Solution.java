// https://leetcode.com/problems/assign-cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int idx = 0, count = 0, len = Math.min(g.length, s.length);
        for (int i = 0; i < len && idx < s.length; i++) count += s[idx++] >= g[i] ? 1 : (--i - i);
        return count;
    }
}