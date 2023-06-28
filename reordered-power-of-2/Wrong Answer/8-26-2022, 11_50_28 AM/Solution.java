// https://leetcode.com/problems/reordered-power-of-2

class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1){
            return true;
        }
        for(int i=0;i<n/2;i++){
        double curr=Math.pow(2,i);
            if(curr==n){
                return true;
            }
}
        return false;
        
    }
}