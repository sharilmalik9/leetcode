// https://leetcode.com/problems/random-pick-index

class Solution {
    int[] nums;
     HashMap<Integer,Integer> hm;
    

    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
          hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        
    
       
        return hm.get(target);
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */