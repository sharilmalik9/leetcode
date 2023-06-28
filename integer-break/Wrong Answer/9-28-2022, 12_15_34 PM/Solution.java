// https://leetcode.com/problems/integer-break

class Solution {
    public int integerBreak(int n) {
        if(n==1){
            return 1;
        }
       
        
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,Math.max(integerBreak(n-i)*i,(n-i*i)));
        }
        
        return max;
    }
}