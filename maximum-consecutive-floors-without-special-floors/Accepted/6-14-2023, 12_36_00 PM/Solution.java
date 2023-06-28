// https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int result = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            result = Math.max(result, special[i] - special[i - 1] - 1);
        }
        return result;
    }
}