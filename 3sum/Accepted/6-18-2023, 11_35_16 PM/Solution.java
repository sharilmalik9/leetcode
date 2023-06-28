// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length && nums[i]<=0;i++){
            if(i==0 || nums[i-1] != nums[i]){
                solve(nums,i,result);
            }
        }
        return result;
    }
    public static void solve(int[] nums,int i,List<List<Integer>> result){
        int low=i+1;
        int high=nums.length-1;
        while(low<high){
            int sum=nums[i]+nums[low]+nums[high];
            if(sum<0){
                low++;
            }
            else if(sum>0){
                high--;
            }
            else{
                result.add(Arrays.asList(nums[i],nums[low++],nums[high--]));
                while(low<high && nums[low]==nums[low-1]){
                    low++;
                }
            }
        }
    }
}
//time complexity:O(n^2)
//space complexity:o(n)