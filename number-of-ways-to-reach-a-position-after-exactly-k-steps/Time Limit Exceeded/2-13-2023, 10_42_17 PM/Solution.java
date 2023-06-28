// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps

class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        return help(startPos,endPos,k,startPos);
        
    }
    public int help(int start,int end,int k,int curr){
        if(curr==end && k==0){
            return 1;
        }
       
        if(k==0){
            return 0;
        }
        return help(start,end,k-1,curr-1)+ help(start,end,k-1,curr+1);

    }
}