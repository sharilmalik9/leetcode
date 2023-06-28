// https://leetcode.com/problems/first-missing-positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        HashSet<Integer> hs= new HashSet<>();
        
        for(int i: nums){
            hs.add(i);
        }
        int positive=0;
        while(hs.contains(positive)){
            positive++;
        }
       
    
        return positive;
        
    }
}