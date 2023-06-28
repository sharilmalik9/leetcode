// https://leetcode.com/problems/reducing-dishes

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return rec(satisfaction,0,1);
        
    }
    public int rec(int[] s,int idx,int time ){
        if(idx>=s.length){
            return 0;
        }
        if(s[idx]>=0){
            return s[idx]*time +rec(s,idx+1,time+1);
        }
        return Math.max(s[idx]*time+rec(s,idx+1,time+1),rec(s,idx+1,time));

    }
}