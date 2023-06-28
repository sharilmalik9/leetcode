// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int[] arr=new int[nums.length];
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr[i]=0-nums[i];
        }
         int[] curr1= twosum(nums,0,arr[0]);
         if(curr1.length!=0){
            List<Integer> ls= new ArrayList<>();
            ls.add(nums[curr1[0]]);
            ls.add(nums[0]);
            ls.add(nums[curr1[1]]);
            ans.add(ls);
            }

         for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            while(curr.length)
            int[] curr= twosum(nums,i,arr[i]);
            if(curr.length!=0){
            List<Integer> ls= new ArrayList<>();
            ls.add(nums[curr[0]]);
            ls.add(nums[i]);
            ls.add(nums[curr[1]]);
            ans.add(ls);
            }
        }
        return ans;

    }
    public int[] twosum(int[] nums,int i,int num){
        int start=i+1;
        int end=nums.length-1;
        while(start<end){
            int sum=nums[start]+nums[end];
            if(sum==num){
                int[] ans= new int[2];
                ans[0]=start;
                ans[1]=end;
                return ans;
            }
            if(sum>num){
                end--;
               
            }
            else{
                start++;
               
            }
        }
        return new int[0];
    }
}