// https://leetcode.com/problems/divide-two-integers

class Solution {
    public int divide(int dividend, int divisor) {
        if( dividend == -2147483648 && divisor == -1) return 2147483647;
        boolean isNegative = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ) isNegative = true;
        long a = dividend;
        long b = divisor;
        if(a<0) a = -a;
        if(b<0) b = -b;
        int ans = 0;
        for(int i = 31; i>=0; i--){
            if(a >= (b<<i)){
                a = a - (b<<i);
                ans += (1<<i);
                if(a<b){
                    break;
                }
            }
        }
        if(isNegative) ans = -ans;
        return ans;
    }
}