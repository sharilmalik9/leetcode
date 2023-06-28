// https://leetcode.com/problems/integer-break

class Solution {
    public int integerBreak(int n) {
        if(n<=2){
            return 1;
        }
        int max=0;
        for(int i=1;i<n-2;i++){
            max=Math.max(max,integerBreak(n-i)*i);
        }
        return max;
    }
}