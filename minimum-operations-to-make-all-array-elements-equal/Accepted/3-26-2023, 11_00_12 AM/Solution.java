// https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        int n = nums.length;
        long[] record = new long[n];
        Arrays.sort(nums);      
        record[0] = nums[0];
        for(int i = 1; i < n; i++){
            record[i] = record[i-1] + nums[i];
        }
        
        
        for(int i = 0; i < queries.length; i++){
            long cur = 0;
            int tmp = search(nums, queries[i]);
            if(tmp == -1)tmp = 0;
            cur += Math.abs(record[tmp] - (long)queries[i] * (tmp+1));
            cur += Math.abs(record[n-1] - record[tmp] - (long)queries[i] * (n-tmp-1)); 
            res.add(cur);
        }
        return res;
    }
    
    public int search(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}