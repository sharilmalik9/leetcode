// https://leetcode.com/problems/find-the-most-competitive-subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->nums[a]-nums[b]);
        int least=0;
        for(int i=1;i<nums.length-k+1;i++){
            if(nums[least]>nums[i]){
                least=i;
            }
            
        } 
        int[] ans= new int[k];
        ans[0]=nums[least];
        int start=least+1;
        int idx=1;
        
        int end=nums.length-k+1;
        least++;
        while(least<=nums.length-k+1){
            pq.add(least);
            least++;
        }
        while(end<nums.length&&start<=end){
            int curr=pq.poll();
            while(start<curr){
                pq.remove(start);
                
            }
            start=curr+1;
            ans[idx]=nums[curr];
            idx++;
            pq.add(end);
            end++;
            
            
        }
        return ans;
        
        
    }
}