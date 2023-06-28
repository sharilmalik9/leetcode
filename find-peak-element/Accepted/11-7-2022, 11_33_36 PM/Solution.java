// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
  // 1. check if mid is greater than next element.
 // 2. change start and end accordingly.
// 3. start and end will end-up at the peak element eventually 
        
        int start = 0 , end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start)/2; 

            if (nums[mid] < nums[mid +1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}