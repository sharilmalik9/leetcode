// https://leetcode.com/problems/maximum-length-of-pair-chain

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->
        a[1]-b[1]);

        int chainLen = 1;
        int chainend = pairs[0][1]; // Last Selected pair end // chain end 
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > chainend){
                chainLen++;
                chainend = pairs[i][1];
            }
        }
       return chainLen;
    }
}