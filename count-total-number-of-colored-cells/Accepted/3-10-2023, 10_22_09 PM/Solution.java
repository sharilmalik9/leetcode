// https://leetcode.com/problems/count-total-number-of-colored-cells

class Solution {
    public long coloredCells(int n) {
        return (long)(n-1)*n*2+1;

        
    }
}