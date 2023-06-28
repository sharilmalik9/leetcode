// https://leetcode.com/problems/single-element-in-a-sorted-array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 0;
        int e = nums.length-1;

        while(s<= e){
            int mid = (s + e)/2;
            // System.out.println(s + " "+ mid + " " + e);

            if(mid == 0 || mid == nums.length-1 || (nums[mid-1] != nums[mid] && nums[mid+1] != nums[mid])){
                return nums[mid];
            }else if(nums[mid-1] == nums[mid] ){
                if((mid-s) % 2 == 0 ){
                    e = mid;
                }else{
                    s = mid +1;
                }
            }else{
                if((e-mid) % 2 == 0 ){
                    s = mid;
                }else{
                    e = mid -1;
                }
            }
            
        }

        return s;
    }
}