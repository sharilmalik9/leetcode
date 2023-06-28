// https://leetcode.com/problems/count-number-of-bad-pairs

class Solution {
    public long countBadPairs(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(badpair(nums,i,j)){
                    cnt++;
                }
            }
        }
            return cnt;
            
            
}
        
        
        
        
    
    public boolean badpair(int[] nums, int i,int j){
        if(i<j && j - i != nums[j] - nums[i] ){
            return true;
        }
        return false;
    }
}