// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
         Map<Integer,Integer> sh= new HashMap<>();
       
        for(int i=0;i<nums.length;i++){
            if(!sh.containsKey(nums[i])){
                sh.put(nums[i],1);

            }
           else{
               nums[i]=Integer.MAX_VALUE;
               sh.put(nums[i],1);

            }
        }
        for(int i=0;i<nums.length;i++){
            if(sh.containsKey(nums[i]+1)){
                sh.put(nums[i]+1,2);
            }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(sh.get(nums[i])==2){
                count++;

            }
        }
        if(count==0){
            return count;
        }
      


            return count+1;
       
        
        
    }
}