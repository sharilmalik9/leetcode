// https://leetcode.com/problems/removing-minimum-number-of-magic-beans

class Solution {
	public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long result = Long.MAX_VALUE;
        long m = beans.length;
        for (int i = 0; i < beans.length; i++, m--) {
            result = Math.min(result, sum - m * beans[i]);
        }
        return result;
    }
}