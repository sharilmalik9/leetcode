// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashSet<Integer> hs= new HashSet<>();
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
           hs.add(nums[i]);
           hm.put(nums[i]%value,nums[i]);
        }
        int start=0;

        while(true){
            if(hs.contains(start)){
                start++;
                continue;
            }
            else if(start<=value){
               if(hm.containsKey(start)){
                  
                   hm.remove(start);
                   hs.remove(hm.get(start));
                    start++;

               }
               else{
                   
                   return start;
               }
            }
            else{
                if(hs.contains(start%value)){
                    hs.remove(start%value);
                    start++;
                    
                }
                else{
                    return start;
                }
            }
        }
        

    }
}