// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        return help(capacity,rocks,additionalRocks,0);
        
    }
    public int help(int[] capacity,int[] rocks,int additionalRocks,int i){
        if(i>=rocks.length){
            return 0;
        }
        if(additionalRocks<=0){
            return 0;
        }
        if(capacity[i]==rocks[i]){
            return help(capacity,rocks,additionalRocks,i+1)+1;
        }
        return Math.max(help(capacity,rocks,additionalRocks,i+1),help(capacity,rocks,additionalRocks-(capacity[i]-rocks[i]),i+1)+1);

    }
}