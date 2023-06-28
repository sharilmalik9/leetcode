// https://leetcode.com/problems/integer-break

class Solution {
    public int integerBreak(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,integerBreak(n-i)*i);
        }
        return max;
        
        
        
        
    }
}