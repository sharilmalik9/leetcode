// https://leetcode.com/problems/beautiful-arrangement-ii

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        
        // [1..n-k] leave as it is, it may contains diff of 1, or contains no diff (i.e. 1 == n - k)
        // [n-k+1..n] jump between two ends, first jump is to the right end: right -> left -> right - 1 -> left + 1
        //            (a) each jump ensures a new diff (prev jump length - 1)
        //            (b) x jump ensures there's x distinct diff 
        //            (c) the last jump is always 1, so same diff as [1..n-k] if any
        //            Thus total # of distinct diff is x.  (here x = size of [n-k+1..n] = k)
        
        // fill out [1..n-k]
        for (int i = 1; i <= n-k; i++) {
            res[i-1] = i;
        }
        
        boolean increasing = false;
        int left = n - k + 1;
        int right = n;
        // fill out [n-k+1..n]
        for (int pos = n - k; pos < n; pos++) {
            if (!increasing) {
                res[pos] = right;
                right--;
            } else {
                res[pos] = left;
                left++;
            }
            increasing = !increasing;
        }
        return res;
    }
}