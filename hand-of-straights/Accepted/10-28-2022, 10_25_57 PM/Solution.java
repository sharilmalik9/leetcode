// https://leetcode.com/problems/hand-of-straights

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:hand)
            map.put(i,map.getOrDefault(i,0)+1);
        
        Arrays.sort(hand);
        
        for(int i=0;i<n;i++){
            int cur=hand[i];
            if(map.getOrDefault(cur,0)==0)
                continue;
            map.put(cur,map.get(cur)-1);
            int count=groupSize;
            while(count>1){
                if(map.getOrDefault(cur+1,0)>0){
                    map.put(cur+1,map.get(cur+1)-1);
                    count--;
                    cur++;
                }
                else
                    return false;     
            }     
        }
        return true;
    
    }
}