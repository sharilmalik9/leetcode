// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr= new int[nums.length];
        int idx=0;
        int[] ans= new int[2];
        int idx1=0;
        for(int i=0;i<nums.length;i++){

            arr[idx]=target-nums[i];

            idx++;
        }
        for(int i=0;i<arr.length;i++){

            int element=arr[i];
            for(int j=0;j<nums.length;j++){
                if(nums[j]==element){
                    if(i!=j) {

                        ans[0] = j;

                        ans[1] = i;
                    }
                    else{
                        continue;
                    }

                }

            }

        }
        return ans;

        
        
        
        
    }
}