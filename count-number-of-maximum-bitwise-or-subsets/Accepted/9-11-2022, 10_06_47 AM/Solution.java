// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets

class Solution {
    int cnt=0;
    int maxOr=0;
    public int countMaxOrSubsets(int[] nums) {
        subset(nums,0,0);
        return cnt;
        
    }
    public void subset(int[] nums,int idx,int or){
        if(idx==nums.length){
            if(or==maxOr){
                cnt+=1;
            }
            else if(or>maxOr){
                maxOr=or;
                cnt=1;
            }
            return;
            
        }
        subset(nums,idx+1,or|nums[idx]);
        subset(nums,idx+1,or);
    }
}