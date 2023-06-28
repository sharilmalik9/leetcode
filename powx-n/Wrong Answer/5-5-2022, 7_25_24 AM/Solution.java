// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        double ans=x;
        for(int i =1;i<n;i++){
            ans*=x;
            
        }
        return ans;
    }
}