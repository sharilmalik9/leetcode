// https://leetcode.com/problems/powx-n

class Solution {
    
    public double myPow(double x, int n) {
        if (n >= 0) {

        double ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= x;
        }


            return ans;
        }


     else{
         
            double y  = 1 / x;
            double ans = 1;
            for (int i = 1; i < =-n; i++) {
                ans *= y;

            }
            return ans;

        }
    }
}