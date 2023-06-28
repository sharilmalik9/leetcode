// https://leetcode.com/problems/shuffle-an-array

class Solution {
    
    int[] orig;
    int[] curr;
    Random rnd = new Random();

    public Solution(int[] nums) {
        orig = new int[nums.length];
        curr = nums;
        for(int i=0; i<nums.length; i++)
            orig[i] = nums[i];
    }
    
    public int[] reset() {
        for(int i=0; i<orig.length; i++)
            curr[i] = orig[i];
        return curr;
    }
    
    public int[] shuffle() {
        for(int i=0; i<curr.length; i++){
            int idx = rnd.nextInt(curr.length);
            swap(i, idx);
        }
        return curr;
    }
    
    public void swap(int i, int j){
        int tmp = curr[i];
        curr[i] = curr[j];
        curr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */