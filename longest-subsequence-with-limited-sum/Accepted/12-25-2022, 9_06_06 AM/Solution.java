// https://leetcode.com/problems/longest-subsequence-with-limited-sum

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        //2,3,4,5            1
        for(int j = 0; j<queries.length; j++){
            int count = 0, sum = 0;
            
            for(int i = 0;  i < nums.length; i++){
                sum += nums[i];
                
                if(sum <= queries[j])
                    count++;
                else
                    break;
            }
            
            res[j] = count;
        }
        return res;
    }
}
