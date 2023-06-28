// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength=0;
        int flippes=0;
        int start=0;
        int end=0;
        while(end<nums.length){
            if(nums[end]==1&&flippes<k){
                end++;
            }
            else{
                if(flippes<k){
                    flippes++;
                    end++;

                }
                else{
                    while(flippes>=k){
                        if(nums[start]==0){
                            flippes--;

                        }
                        start++;
                    }
                }
                maxLength=Math.max(maxLength,end-start);
            }
        }




        return maxLength;
        
    }
}