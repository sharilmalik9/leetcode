// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int sum=0-nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int currsum=nums[start]+nums[end];
                if(currsum==sum){
                    List<Integer> ls= new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[start]);
                    ls.add(nums[end]);
                    ans.add(ls);
                    start++;
                    end--;
                 while(start<end && nums[start]==nums[start-1]){
                    start++;
                }
                while(start<end && nums[end]== nums[end+1]){
                    end--;
                }
                }
               
                else if(currsum>sum){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return ans;
    }
}