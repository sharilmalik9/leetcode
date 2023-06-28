// https://leetcode.com/problems/bitwise-and-of-numbers-range

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftcount=0;
        while(left!=right){//we are removing bits from last until they both become equal 
            left>>=1;
            right>>=1;
            shiftcount++;
        }
        return left<<shiftcount;//do leftshift to left with shiftcount 
    }
}