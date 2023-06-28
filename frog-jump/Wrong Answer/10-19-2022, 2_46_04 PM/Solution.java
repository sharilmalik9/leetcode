// https://leetcode.com/problems/frog-jump

class Solution {
    public boolean canCross(int[] stones){
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<stones.length;i++){
            hm.put(stones[i],i);
        }
        return help(hm,1,1,stones);
        
        
    }
    public boolean help(HashMap<Integer,Integer> hm,int idx,int steps,int[] stones){
        if(idx==stones.length-1){
            return true;
        }
        if(idx>=stones.length || steps<=0){
            return false;
        }
        // if(steps==-1){
        //     return false;
        // }
        
        boolean ans=false;
        for(int i=steps-1;i<steps+2;i++){
            if(hm.containsKey(i+stones[idx])){
                ans=ans||help(hm,hm.get(i+stones[idx]),i,stones);  
                System.out.println("heyy");
            }
            else{
                continue;
            }
        }
        return ans;
    }
}