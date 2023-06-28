// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n ==1 ) return x;
        if(n== -1) return 1/x;

        int k = n/2;
        double val = myPow(x, k);

        double sub = 1;
        if(n % 2 != 0) {
        if(n > 0) sub = x;
        if(n < 0) sub = 1/x;
        }

        return val * val * sub;
    }
}