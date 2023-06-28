// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
          int ans =0;
        int left=-1;
        int right=nums.length-1;
        int sumL=0;
        int sumR=nums[right];
        while(true){
            if(sumR==sumL){
                if(left+1!=right) {
                    ans = left + 1;
                    break;
                }
                else{
                    ans=-1;
                    break;
                }
            }
            if(sumR>sumL){
                left++;
                sumL+=nums[left];
            }
            if(sumL>sumR){
                right--;
                sumR+=nums[right];
            }
            if(right==left|| left> right){
                ans=-1;
                break;
            }
        }

        return ans;
        
    }
}