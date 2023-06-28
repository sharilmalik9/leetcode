// https://leetcode.com/problems/find-the-most-competitive-subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
       PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->nums[a]-nums[b]);
       int start=0;
      int end=nums.length-k;
        for(int i=0;i<=end;i++){
            pq.add(i);
        }
        int[] ans= new int[k];
        int idx=0;
        while(end<nums.length){
            int curr= pq.poll();
            ans[idx]=nums[curr];
            idx++;
            
            while(start<curr){
                pq.remove(start);
                start++;
            }
            start++;
            if(end<nums.length){
                end++;
                pq.add(end);
            }
            else{
                end++;
            }
        }
        return ans;
        
    }
}