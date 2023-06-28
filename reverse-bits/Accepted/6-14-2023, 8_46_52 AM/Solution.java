// https://leetcode.com/problems/reverse-bits

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int temp = n;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = res<<1;
            if ((temp & 1) == 1) {
                res += 1;
            }
            temp = temp>>1;
        }

        return res;
        
    }
}