// https://leetcode.com/problems/k-diff-pairs-in-an-array

class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i:nums){
           hm.put(i-k,hm.getOrDefault(i-k,0)+1);
        }
         int cnt=0;
        if(k==0){
            for(int i: nums){
              if(hm.getOrDefault(i,0)>1){
                  cnt++;
                 
                      hm.remove(i);
                  
              }
            }
            return cnt;
        }
       
        for(int i:nums){
            if(hm.containsKey(i)){
                cnt++;
                hm.put(i,hm.getOrDefault(i,0)-1);
                if(hm.get(i)==0){
                    hm.remove(i);
                }
            }
           
            // cnt+=hm.getOrDefault(i,0);
            System.out.println(hm.get(i));
        }
        return cnt;
        
    }
}