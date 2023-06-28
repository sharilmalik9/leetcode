// https://leetcode.com/problems/arithmetic-slices-ii-subsequence

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        long ans = 0;
        int n = A.length;
        HashMap<Integer, Integer>[] maps = new HashMap[n];
        for(int i=0; i < n; i++) {
            maps[i] = new HashMap<>();
            for(int j=0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];
                if(diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                int delta = (int)diff;
                int apsEndingOnJ = maps[j].getOrDefault(delta, 0);
                int apsEndingOnI = maps[i].getOrDefault(delta, 0);
                ans += apsEndingOnJ;
                maps[i].put(delta, apsEndingOnJ + apsEndingOnI + 1);
            }
        }
        return (int)ans;
    }
}