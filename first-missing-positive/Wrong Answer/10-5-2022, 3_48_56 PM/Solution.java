// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> hs= new HashSet<>();
        
        for(int i: nums){
            hs.add(i);
        }
        int positive=Integer.MAX_VALUE;
        for(int i:nums){
            if(i>-1){
                if(!hs.contains(i+1)){
                    positive=Math.min(positive,i+1);
                }
            }
        }
    
        return positive;
        
    }
}