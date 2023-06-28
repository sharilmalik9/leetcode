// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer,Integer> sh= new HashMap<>();
        for(int i:nums){
            if(!sh.isEmpty() && sh.containsKey(i)){
                sh.replace(i,sh.get(i)+1);
            }
            else{
                sh.put(i,1);
            }
        }

        int idx=0;
        for(int i : sh.keySet()){
            if(sh.get(i)>=k){
               
                idx++;
                
            }
        }
        int[] ans= new int[idx];
      idx=0;
         for(int i : sh.keySet()){
            if(sh.get(i)>=k){
               ans[idx]=i;
                idx++;
                
            }
        }
        
        return ans ;
        
    }
}