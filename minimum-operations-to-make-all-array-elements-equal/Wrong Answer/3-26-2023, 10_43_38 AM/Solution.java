// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> ans= new ArrayList<>();
        if(nums.length==1){
            for(int i=0;i<queries.length;i++){
                ans.add((long)Math.abs(nums[0]-queries[i]));
            }
            return ans;
        }
        int[] prefixsum=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            prefixsum[i]=sum;
        }
        for(int i=0;i<queries.length;i++){
            long ans1=0;
            int idx=binary(nums,queries[i]);
            if(idx==nums.length-1){
                ans.add((long)(queries[i]*nums.length-sum));
                continue;
            }
            else if(idx==0){
                ans.add((long)(sum-queries[i]*nums.length));
                continue;
            }
             ans1=(long)(queries[i]*(idx+1)-prefixsum[idx]);
            ans1+=(long)(prefixsum[nums.length-1]-prefixsum[idx]-(nums.length-(idx+1))*queries[i]);
            ans.add(ans1);
        }
        return ans;
        
    }
    public int binary(int[] arr,int target){
        int start = 0, end = arr.length-1;
        if(end == 0) return -1;
        if (target > arr[end]) return end;
        if(target<arr[start]){
            return 0;
        }
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}